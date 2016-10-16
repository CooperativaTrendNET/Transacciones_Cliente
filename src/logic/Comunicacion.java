package logic;

import domain.Empleado;
import domain.Transaccion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import security.Encriptar;

/**
 * @author adrian
 */

public class Comunicacion {

    private int puerto;
    private Socket socket;
    private PrintStream enviar;
    private BufferedReader recibir;
    
    public Comunicacion() {
        this.puerto = 8080;
        
        try {
            InetAddress direccionIP = InetAddress.getByName("localhost");
            this.socket = new Socket(direccionIP, this.puerto);
            this.enviar = new PrintStream(this.socket.getOutputStream());
            this.recibir = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (Exception e) {
            System.err.println("Error en el cliente - escritura");
        }
    }
    
    public boolean login(String tipo, String cuentaOrigen, String pass){
        boolean flag = false;
        
        pass = Encriptar.password(pass, Encriptar.MD5);
        
        try {
            this.enviar.println(tipo);
            this.enviar.println(cuentaOrigen);
            this.enviar.println(pass);
            flag = Boolean.parseBoolean(this.recibir.readLine());    
            
            if (flag) {
                Empleado empleado = new Empleado();
                empleado.setNumeroCuenta(this.recibir.readLine());
                empleado.setNombre(this.recibir.readLine());
                empleado.setApellidos(this.recibir.readLine());
                empleado.setCedula(this.recibir.readLine());
                empleado.setFondo(Float.parseFloat(this.recibir.readLine()));
            }else{
                System.err.println("Login incorrecto");
            }
        } catch (IOException ex) {
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return flag;
    }
    
    public float consulta(Transaccion transaccion){
        float monto = 0;
        transaccion.setPass(Encriptar.password(transaccion.getPass(), Encriptar.MD5));
        
        try {
            this.enviar.println(transaccion.getTipo());
            this.enviar.println(transaccion.getCuentaOrigen());
            this.enviar.println(transaccion.getPass());
            monto = Float.parseFloat(this.recibir.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return monto;
    }
    
    public boolean deposito_retiro(Transaccion transaccion){
        boolean flag = false;
        transaccion.setPass(Encriptar.password(transaccion.getPass(), Encriptar.MD5));
        
        try {
            this.enviar.println(transaccion.getTipo());
            this.enviar.println(transaccion.getCuentaOrigen());
            this.enviar.println(transaccion.getPass());
            this.enviar.println(transaccion.getMonto());
            flag = Boolean.parseBoolean(this.recibir.readLine());    
        } catch (IOException ex) {
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return flag;
    }
    
    public boolean transferencia(Transaccion transaccion){
        boolean flag = false;
        transaccion.setPass(Encriptar.password(transaccion.getPass(), Encriptar.MD5));
        
        try {
            this.enviar.println(transaccion.getTipo());
            this.enviar.println(transaccion.getCuentaOrigen());
            this.enviar.println(transaccion.getPass());
            this.enviar.println(transaccion.getMonto());
            this.enviar.println(transaccion.getCuentaDestino());
            flag = Boolean.parseBoolean(this.recibir.readLine());    
        } catch (IOException ex) {
            Logger.getLogger(Comunicacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return flag;
    }
    
}
