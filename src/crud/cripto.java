package crud;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import Modelo.Crypto;

// public class CargaCrypto {

// public void cargarDatos(String coinId) {
// String jsonResponse = obtenerDatosDesdeAPI(coinId);
// if (jsonResponse != null) {
// guardarDatosEnBaseDeDatos(jsonResponse, coinId);
// }
// }

// private String obtenerDatosDesdeAPI(String coinId) {
// String apiKey =
// "ca0f0c393b8eb0f6fc763f05ac333c9e9475ec1886badeb32b607e0e7ea51518";
// long start;
// long end = System.currentTimeMillis();

// try {
// CryptoHistoricalPriceDAO dao = new CryptoHistoricalPriceDAO();
// Date lastDate = dao.getLastLoadedDate(coinId.toUpperCase()); // Convertimos a
// mayúsculas para coincidir con
// // "SOL"

// if (lastDate == null) {
// start = 0L; // Todo el historial
// } else {
// start =
// lastDate.toLocalDate().plusDays(1).atStartOfDay().toInstant(java.time.ZoneOffset.UTC)
// .toEpochMilli();
// }

// String apiUrl = String.format(
// "https://rest.coincap.io/v3/assets/%s/history?interval=d1&start=%d&end=%d",
// coinId, start, end);

// URL url = new URL(apiUrl);
// HttpURLConnection connection = (HttpURLConnection) url.openConnection();
// connection.setRequestMethod("GET");
// connection.setRequestProperty("Authorization", "Bearer " + apiKey);
// connection.setRequestProperty("Accept", "application/json");

// int responseCode = connection.getResponseCode();
// if (responseCode == HttpURLConnection.HTTP_OK) {
// BufferedReader reader = new BufferedReader(new
// InputStreamReader(connection.getInputStream()));
// StringBuilder response = new StringBuilder();
// String line;
// while ((line = reader.readLine()) != null) {
// response.append(line);
// }
// reader.close();
// connection.disconnect();
// return response.toString(); // Retornamos el JSON
// } else {
// System.out.println("Error en la conexión. Código: " + responseCode);
// }

// connection.disconnect();
// } catch (Exception e) {
// e.printStackTrace();
// }

// return null; // Si falla, retornamos null
// }

// private void guardarDatosEnBaseDeDatos(String jsonResponse, String coinId) {
// try {
// //CryptoHistoricalPriceDAO dao = new CryptoHistoricalPriceDAO();
// CargarDatosCryptoDAO dao = new CargarDatosCryptoDAO();
// JSONObject json = new JSONObject(jsonResponse);
// JSONArray data = json.getJSONArray("data");

// for (int i = 0; i < data.length(); i++) {
// JSONObject record = data.getJSONObject(i);
// String dateStr = record.getString("date"); // Fecha en formato ISO 8601
// double closePrice = record.getDouble("priceUsd");

// // Convertir dateStr a java.util.Date
// java.time.LocalDate localDate =
// java.time.LocalDate.parse(dateStr.substring(0, 10)); // Solo yyyy-MM-dd
// java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);

// //CryptoHistoricalPrice price = new
// CryptoHistoricalPrice(coinId.toUpperCase(), sqlDate, closePrice);
// Crypto price = new Crypto(coinId.toUpperCase(), sqlDate, closePrice);
// dao.insert(price);
// }

// System.out.println("Datos guardados exitosamente en la base de datos.");
// } catch (Exception e) {
// e.printStackTrace();
//     }
// }

// }