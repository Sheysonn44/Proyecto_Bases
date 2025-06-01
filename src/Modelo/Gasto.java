package Modelo;

import java.util.Date;

/**
 * Clase que representa un gasto.
 * Contiene información sobre el monto, fecha, descripción, categoría, cuenta
 * bancaria,
 * método de pago, tipo de moneda, destinatario y tipo de transacción.
 */
public class Gasto {
    private double M_Gasto;
    private Date F_Gasto;
    private String D_Descripcion;
    private int C_Categoria;
    private int C_Cuenta_Bancaria;
    private int C_Metodo_Pago;
    private int C_TipoMoneda;
    private String D_Destinatario;
    private int C_TipoTransaccion;

    /**
     * Constructor de la clase Gasto.
     *
     * @param M_Gasto           Monto del gasto.
     * @param F_Gasto           Fecha del gasto.
     * @param D_Descripcion     Descripción del gasto.
     * @param C_Categoria       Categoría del gasto.
     * @param C_Cuenta_Bancaria Cuenta bancaria asociada al gasto.
     * @param C_Metodo_Pago     Método de pago utilizado.
     * @param C_TipoMoneda      Tipo de moneda del gasto.
     * @param D_Destinatario    Destinatario del gasto.
     * @param C_TipoTransaccion Tipo de transacción del gasto.
     */
    public Gasto(double M_Gasto, Date F_Gasto, String D_Descripcion, int C_Categoria, int C_Cuenta_Bancaria,
            int C_Metodo_Pago,
            int C_TipoMoneda, String D_Destinatario, int C_TipoTransaccion) {
        this.M_Gasto = M_Gasto;
        this.F_Gasto = F_Gasto;
        this.D_Descripcion = D_Descripcion;
        this.C_Categoria = C_Categoria;
        this.C_Cuenta_Bancaria = C_Cuenta_Bancaria;
        this.C_Metodo_Pago = C_Metodo_Pago;
        this.C_TipoMoneda = C_TipoMoneda;
        this.D_Destinatario = D_Destinatario;
        this.C_TipoTransaccion = C_TipoTransaccion;

    }

    // Getters para acceder a los atributos del gasto
    public double getM_Gasto() {
        return M_Gasto;
    }

    public Date getF_Gasto() {
        return F_Gasto;
    }

    public String getD_Descripcion() {
        return D_Descripcion;
    }

    public int getC_Categoria() {
        return C_Categoria;
    }

    public int getC_Cuenta_Bancaria() {
        return C_Cuenta_Bancaria;
    }

    public int getC_Metodo_Pago() {
        return C_Metodo_Pago;
    }

    public int getC_TipoMoneda() {
        return C_TipoMoneda;
    }

    public String getD_Destinatario() {
        return D_Destinatario;
    }

    public int getC_TipoTransaccion() {
        return C_TipoTransaccion;
    }

    // Setters para modificar los atributos del gasto
    public void setM_Gasto(double M_Gasto) {
        this.M_Gasto = M_Gasto;
    }

    public void setF_Gasto(Date F_Gasto) {
        this.F_Gasto = F_Gasto;
    }

    public void setD_Descripcion(String D_Descripcion) {
        this.D_Descripcion = D_Descripcion;
    }

    public void setC_Categoria(int C_Categoria) {
        this.C_Categoria = C_Categoria;
    }

    public void setC_Cuenta_Bancaria(int C_Cuenta_Bancaria) {
        this.C_Cuenta_Bancaria = C_Cuenta_Bancaria;
    }

    public void setC_Metodo_Pago(int C_Metodo_Pago) {
        this.C_Metodo_Pago = C_Metodo_Pago;
    }

    public void setC_TipoMoneda(int C_TipoMoneda) {
        this.C_TipoMoneda = C_TipoMoneda;
    }

    public void setD_Destinatario(String D_Destinatario) {
        this.D_Destinatario = D_Destinatario;
    }

    public void setC_TipoTransaccion(int C_TipoTransaccion) {
        this.C_TipoTransaccion = C_TipoTransaccion;
    }
}