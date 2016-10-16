package main;

import domain.Transaccion;
import gui.Login;
import logic.Comunicacion;

/**
 *
 * @author adrian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        
        
//        Comunicacion c = new Comunicacion();
////        System.out.println(c.login("login", "00100", "402cb17ca41bc45390f4aa9ea3bf1cfe"));
//    
////        Transaccion transaccionC = new Transaccion("consulta", "00010", "664d297c3f00475676d2beade4026477");
////        System.out.println(c.consulta(transaccionC));
//    
//        Transaccion transaccionD = new Transaccion("deposito", 4000, "00110", "0a94cf4cd44933b7ca4d0b27a29d597f");
////        Transaccion transaccionR = new Transaccion("retiro", 5000, "00110", "0a94cf4cd44933b7ca4d0b27a29d597f");
//        System.out.println(c.deposito_retiro(transaccionD));

//        Transaccion transaccionT = new Transaccion("transferencia", 3500, "00110", "00001", "0a94cf4cd44933b7ca4d0b27a29d597f");
//        System.out.println(c.transferencia(transaccionT));
    }
    
}
