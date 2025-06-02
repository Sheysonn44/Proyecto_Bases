package Controlador;

import java.sql.Date;

import dao.CargarDatosCryptoDAO;
import Modelo.Crypto;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Jocelyn Abarca
 * @author Adrian Chavarria
 * @author Marcos Montero
 * @author Jeison Alvarez
 *         28-06-2025 Clase CargaCryptoController.java
 * 
 *         Clase encargada de cargar los datos de criptomonedas desde una API
 *         externa
 *         y guardarlos en la base de datos.
 * 
 * 
 * 
 */

public class CargaCryptoController {

    public void cargarDatos(String coinId) {
        String jsonResponse = obtenerDatosDesdeAPI(coinId);
        if (jsonResponse != null) {
            guardarDatosEnBaseDeDatos(jsonResponse, coinId);
        }
    }

    private String obtenerDatosDesdeAPI(String coinId) {
        String apiKey = "556d811537b799aa97bdf267c93754eea8b1ee1708a42d5127edf5f5c2083b2d";

        long start;
        long end = System.currentTimeMillis();

        try {
            CargarDatosCryptoDAO dao = new CargarDatosCryptoDAO();
            Date lastDate = dao.obtenerUltimaFecha(coinId.toUpperCase()); // Convertimos a mayúsculas para coincidir con
                                                                          // "SOL"

            if (lastDate == null) {
                start = 0L; // Todo el historial
            } else {
                start = lastDate.toLocalDate().plusDays(1).atStartOfDay().toInstant(java.time.ZoneOffset.UTC)
                        .toEpochMilli();
            }

            String apiUrl = String.format(
                    "https://rest.coincap.io/v3/assets/%s/history?interval=d1&start=%d&end=%d",
                    coinId, start, end);

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                connection.disconnect();
                return response.toString(); // Retornamos el JSON
            } else {
                System.out.println("Error en la conexión. Código: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Si falla, retornamos null
    }

    private void guardarDatosEnBaseDeDatos(String jsonResponse, String coinId) {
        try {
            CargarDatosCryptoDAO dao = new CargarDatosCryptoDAO();
            JSONObject json = new JSONObject(jsonResponse);
            JSONArray data = json.getJSONArray("data");
            int count = 0;
            for (int i = 0; i < data.length(); i++) {
                JSONObject record = data.getJSONObject(i);
                String dateStr = record.getString("date"); // Fecha en formato ISO 8601
                double closePrice = record.getDouble("priceUsd");

                // Convertir dateStr a java.util.Date
                java.time.LocalDate localDate = java.time.LocalDate.parse(dateStr.substring(0, 10)); // Solo yyyy-MM-dd
                java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

                Crypto price = new Crypto(coinId.toUpperCase(), sqlDate, closePrice);
                dao.insertar(price);
                count++;

            }
            System.out
                    .println("Se han insertado " + count + " registros para la criptomoneda: " + coinId.toUpperCase());

            System.out.println("Datos guardados exitosamente en la base de datos.");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}