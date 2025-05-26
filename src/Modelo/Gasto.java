package Modelo;

import java.util.Date;



public class Gasto {

    private double M_Gasto; 
    private Date F_Gasto; 
    private String D_Descripcion;
    private int C_Categoria; 
    private int C_Cuenta_Bancaria;
    private int C_Metodo_Pago; 
   

    public Gasto(double M_Gasto, Date F_Gasto, String D_Descripcion, int C_Categoria, int C_Cuenta_Bancaria, int C_Metodo_Pago){

        this.M_Gasto = M_Gasto; 
        this.F_Gasto = F_Gasto; 
        this.D_Descripcion = D_Descripcion; 
        this.C_Categoria = C_Categoria; 
        this.C_Cuenta_Bancaria = C_Cuenta_Bancaria; 
        this.C_Metodo_Pago = C_Metodo_Pago; 
      

    }



    public double getM_Gasto (){ return M_Gasto;}
    public Date getF_Gasto() {return F_Gasto; }
    public String getD_Descripcion (){ return D_Descripcion;}
    public int getC_Categoria(){ return C_Categoria;}
    public int getC_Cuenta_Bancaria() { return C_Cuenta_Bancaria;}
    public int getC_Metodo_Pago() {return C_Metodo_Pago;}
    

    
}
