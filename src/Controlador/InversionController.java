package Controlador;

import dao.InversionDAO;
import db.Conexion;
import Modelo.Inversion;
import dao.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class InversionController {

    private InversionDAO dao = new InversionDAO();

    public void escenario4() {
        try {
            // Obtener conexión y DAOs
            Connection conn = Conexion.getConexion();
            conn.setAutoCommit(false);

            AhorroDAO ahorroDAO = new AhorroDAO();
            InversionDAO inversionDAO = new InversionDAO();
            TransaccionDAO transaccionDAO = new TransaccionDAO();
            IngresoDAO ingresoDAO = new IngresoDAO();

            // Crear inversión de prueba
            Inversion inversion = new Inversion();
            inversion.setNombre("Inversión Hipotecaria Mayo");
            inversion.setTipoInversion("Hipotecaria");
            inversion.setMonto(new BigDecimal("10000.00"));
            inversion.setRentabilidad(new BigDecimal("0.12")); // 12% anual
            inversion.setFechaInicio(new java.sql.Date(LocalDate.now().toEpochDay() * 24 * 60 * 60 * 1000));
            inversion.setDescripcion("Inversión de prueba");
            inversion.setCuentaBancaria(6);
            inversion.setEstado(1);
            inversion.setTipoInversionId(2);
            inversion.setTipoMoneda(1);

            int categoriaSalida = 3;
            int categoriaIngreso = 5;
            int tipoMovimiento = 1;
            int tipoTransaccion = 2;

            // Validaciones
            if (inversion.getFechaInicio().before(new Date())) {
                throw new Exception("❌ La fecha de inicio no puede ser anterior a hoy.");
            }
            if (inversion.getRentabilidad().compareTo(BigDecimal.ZERO) <= 0 ||
                    inversion.getRentabilidad().compareTo(BigDecimal.ONE) > 0) {
                throw new Exception("❌ La rentabilidad debe estar entre 0 y 1.");
            }
            if (inversion.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
                throw new Exception("❌ El monto debe ser mayor a cero.");
            }

            // Verificar saldo
            double saldo = ahorroDAO.obtenerSaldoCuenta(inversion.getCuentaBancaria());
            if (saldo < inversion.getMonto().doubleValue()) {
                throw new Exception("❌ Fondos insuficientes en la cuenta.");
            }

            // Insertar inversión y obtener ID
            int idInversion = inversionDAO.insertarYObtenerID(inversion);

            // Rebajar el ahorro
            ahorroDAO.rebajarAhorro(inversion.getCuentaBancaria(), inversion.getMonto());

            // Insertar transacción de salida
            transaccionDAO.insertar(
                    inversion.getMonto(),
                    inversion.getFechaInicio(),
                    "Salida por inversión hipotecaria",
                    inversion.getNombre(),
                    categoriaSalida,
                    inversion.getCuentaBancaria(),
                    inversion.getTipoMoneda(),
                    tipoMovimiento,
                    tipoTransaccion // este valor sería 2 para salida
            );

            // Insertar ingresos mensuales
            BigDecimal interesMensual = inversion.getMonto()
                    .multiply(inversion.getRentabilidad())
                    .divide(new BigDecimal("12"), 5, RoundingMode.HALF_UP);

            for (int i = 0; i < 12; i++) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(inversion.getFechaInicio());
                cal.add(Calendar.MONTH, i);

                ingresoDAO.insertarIngresoMensual(
                        interesMensual,
                        new java.sql.Date(cal.getTimeInMillis()),
                        inversion.getNombre(),
                        categoriaIngreso,
                        inversion.getCuentaBancaria(),
                        idInversion,
                        inversion.getTipoMoneda(),
                        tipoMovimiento,
                        tipoTransaccion);
            }

            conn.commit();
            System.out.println("✅ Escenario 4 completado: inversión hipotecaria registrada.");

        } catch (Exception e) {
            try {
                Conexion.getConexion().rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("❌ Error en escenario 4: " + e.getMessage());
        }
    }

    
}
