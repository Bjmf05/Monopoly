/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.monopoly.controller;

import cr.ac.una.monopoly.util.AppContext;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Joshua Cambronero
 */
public class BancoViewController extends Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    double saldoJ1 = 0 ;
    double saldoJ2 = 0;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      // pagarBonoInicial(); 
    }    
    @Override
    public void initialize() { 
    }
    public void pagarBonoInicial() {
       
        double bonoInicialJ1 = 1500;
        double bonoInicialJ2 = 1500;
        
        saldoJ1 += bonoInicialJ1;
        saldoJ2 += bonoInicialJ2;
        
        cargaGlobal();

    }
    
    public void pagarBonoGO(String Jugador, double cantidad) {
       double cantidadJ1=0;
       double cantidadJ2=0;
        if (Jugador == "J1"){
        cantidadJ1 = cantidad;
        }
        
        else if (Jugador == "J2"){
        cantidadJ2 = cantidad;
        }
        saldoJ1 += cantidadJ1;
        saldoJ2 += cantidadJ2;
        cargaGlobal();

    }
    private void cargaGlobal() {
        
        //Crea instancia de la clase
        Banco BonoInicial = new Banco();
        BonoInicial.setCuentaJ1(saldoJ1);
        BonoInicial.setCuentaJ2(saldoJ2);
        //Guarda los vlaores
        AppContext.getInstance().set("BonoInicial", BonoInicial);
    }
  
}

class Banco{
private double cuentaJ1;
private double cuentaJ2;
private double CuentaBanco = 1000000;

   
    public double getCuentaJ1() {
        return cuentaJ1;
    }

    public void setCuentaJ1(double cuentaJ1) {
        this.cuentaJ1 = cuentaJ1;
    }

    public double getCuentaJ2() {
        return cuentaJ2;
    }

    public void setCuentaJ2(double cuentaJ2) {
        this.cuentaJ2 = cuentaJ2;
    }

    public double getCuentaBanco() {
        return CuentaBanco;
    }

    public void setCuentaBanco(double CuentaBanco) {
        this.CuentaBanco = CuentaBanco;
    }

   
   
}