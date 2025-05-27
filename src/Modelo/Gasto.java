package Modelo;

import java.util.Date;

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
    

    public Gasto(double M_Gasto, Date F_Gasto, String D_Descripcion, int C_Categoria, int C_Cuenta_Bancaria, int C_Metodo_Pago,
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

    public double getM_Gasto() { return M_Gasto; }
    public Date getF_Gasto() { return F_Gasto; }
    public String getD_Descripcion() { return D_Descripcion; }
    public int getC_Categoria() { return C_Categoria; }
    public int getC_Cuenta_Bancaria() { return C_Cuenta_Bancaria; }
    public int getC_Metodo_Pago() { return C_Metodo_Pago; }
    public int getC_TipoMoneda() { return C_TipoMoneda; }
    public String getD_Destinatario() { return D_Destinatario; }
    public int getC_TipoTransaccion() { return C_TipoTransaccion; }
 
   
}

