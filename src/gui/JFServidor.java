
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 *
 * @author Daniel
 */
public class JFServidor extends JFrame implements ActionListener {

    private JPanel jPanelEmpleados;
    private JPanel jPanelActividad;
    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem jmIniciar;
    private JMenuItem jmiFinalizar;
    private JTable jTabla;
    private JScrollPane scrollTabla;
    private JScrollPane scrollTA;
    private JLabel jlempleados;
    private JLabel jlActividad;
    private JTextArea jtActividad;
    

    public JFServidor() {
        super("Servidor");
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.setLayout(new BorderLayout());
        this.setSize(1200, 600);        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        
        this.setVisible(true);

        
    }

    public void init() {
        this.jPanelEmpleados = new JPanel();
        this.jPanelEmpleados.setLayout(new BorderLayout());
        this.jPanelEmpleados.setBackground(new Color(60,85,220));
        
        this.jPanelActividad = new JPanel(new BorderLayout());
        this.jPanelActividad.setBackground(new Color(80,145,220));
        
        
        
        this.jlempleados = new JLabel("Empleados en el sistema", SwingConstants.CENTER); 
        this.jlempleados.setForeground(Color.WHITE);
        this.jlempleados.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        this.jMenuBar = new JMenuBar();


        this.jMenu = new JMenu("Opciones");
        this.jMenuBar.add(this.jMenu);
        
        this.jmIniciar = new JMenuItem("Iniciar");
        this.jmIniciar.addActionListener(this);
        this.jMenu.add(this.jmIniciar);
        this.jmiFinalizar = new JMenuItem("Finalizar");
        this.jmiFinalizar.addActionListener(this);
        this.jmiFinalizar.setEnabled(false);
        this.jMenu.add(this.jmiFinalizar);

        this.jlActividad = new JLabel("Actividad", SwingConstants.CENTER);
        this.jlActividad.setForeground(Color.WHITE);
        this.jlActividad.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        String columnas[] = {"Nombre", "Apellidos", "Cédula", "Fondos", "Num. Cuenta"};
        String tabla[][] = new String[20][5];

        //llenar tabla con los datos de la base

        this.jTabla = new JTable(tabla, columnas);
        this.jTabla.setEnabled(false);
        //this.jTabla.setFillsViewportHeight(true);
//        TableColumn column = null;
//
//        for (int i = 0; i < 5; i++) {
//            column = this.jTabla.getColumnModel().getColumn(i);
//            
//                column.setPreferredWidth(435); 
//            
//        }
        
        this.scrollTabla = new JScrollPane(jTabla);
        this.scrollTabla.setBorder(BorderFactory.createEmptyBorder(90, 10, 90, 10));
        this.scrollTabla.setBackground(new Color(80,145,220));
        
        this.jtActividad = new JTextArea("HOLA");
        this.jtActividad.setEditable(false);
        this.scrollTA = new JScrollPane(jtActividad);
        this.scrollTA.setBorder(BorderFactory.createCompoundBorder());
        
        this.jPanelActividad.add(this.jlActividad, BorderLayout.NORTH);
        this.jPanelActividad.add(this.scrollTA, BorderLayout.CENTER);
        this.jPanelEmpleados.add(this.scrollTabla, BorderLayout.CENTER);     
        this.jPanelEmpleados.add(this.jlempleados, BorderLayout.NORTH);
        this.add(this.jPanelEmpleados, BorderLayout.EAST);
        this.add(this.jPanelActividad, BorderLayout.CENTER);
        this.add(this.jMenuBar,BorderLayout.NORTH);


    }
    
  

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jmIniciar){
            System.out.println("TODO");
            this.jmiFinalizar.setEnabled(true);
            this.jmIniciar.setEnabled(false);
            
        } else if(e.getSource() == jmiFinalizar){
            System.out.println("TODO 2");
            this.jmiFinalizar.setEnabled(false);
            this.jmIniciar.setEnabled(true);
            
        }
        
        
    }

}
