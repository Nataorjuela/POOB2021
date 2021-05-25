package presentation;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AutomataGUI extends JFrame{  
    public static final int CELDA=21;
    public static final int DIMENSION=CELDA*31;
    
    private JButton botonTicTac;
    private JLabel lFila;
    private JLabel lColumna;
    private JTextField tFila;
    private JTextField tColumna;
    private JPanel panelControl;
    private JPanel panelNueva;
    private JPanel panelBNueva;
    //Preparacion de elementos del menu
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemGuardarComo;
    private javax.swing.JMenuItem jMenuItemExportar;
    private javax.swing.JMenuItem jMenuItemNuevo;
    private javax.swing.JMenuItem jMenuItemSalir;
    //Fin de elementos del menu
    private JButton botonViva;
    private JButton botonLatente;
    private FotoAutomata foto;
    
    private AutomataCelular automata;
   
    public AutomataGUI() {
        automata=new AutomataCelular();
        prepareElementos();
        prepareAcciones();
        prepareAccionesMenu();
    }
    private void prepareAccionesMenu(){
    	jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jMenuItemAbrir00ActionPerformed(evt);
            }
        });
    	jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardar00ActionPerformed(evt);
            }
        });
    	 jMenuItemExportar.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                     
             }
         });
         jMenuItemGuardarComo.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jMenuItemSalirActionPerformed(evt);
             }
         });
         jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 jMenuItemSalirActionPerformed(evt);
             }
         });
         jMenuItemNuevo.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 jMenuItemNuevoActionPerformed(evt);
             }
         });
    }
    private void prepareElementos() {
         jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNuevo = new javax.swing.JMenuItem();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuItemGuardarComo = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemExportar= new javax.swing.JMenuItem();
        
        setTitle("Automata celular");
        foto=new FotoAutomata(this);
        botonTicTac=new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(foto,BorderLayout.NORTH);
        add(botonTicTac,BorderLayout.SOUTH);
        setSize(new Dimension(DIMENSION,DIMENSION+50)); 
        setResizable(false);
        foto.repaint();
        
         jMenu1.setText("Archivo");
         jMenuItemNuevo.setText("Nuevo");
        jMenu1.add(jMenuItemNuevo);

        jMenuItemAbrir.setText("Abrir");
        
        jMenu1.add(jMenuItemAbrir);

        jMenuItemGuardar.setText("Guardar");
        
        
        
        jMenu1.add(jMenuItemGuardar);
        jMenuItemGuardarComo.setText("Importar..");
        jMenu1.add(jMenuItemGuardarComo);
        
        
        jMenuItemExportar.setText("Exportar");
       
        
         jMenu1.add(  jMenuItemExportar);
       jMenuItemExportar.setText("Exportar..");
        jMenu1.add(  jMenuItemExportar);
        
        
        jMenuItemSalir.setText("Salir");

        jMenu1.add(jMenuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Configuraciones");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }

    private void prepareAcciones(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
        botonTicTac.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    botonTicTacAccion();
                }
            });

    }

    private void botonTicTacAccion() {
        automata.ticTac();
        foto.repaint();
    }

    public AutomataCelular getAutomata(){
        return automata;
    }
    
    public static void main(String[] args) {
        AutomataGUI ca=new AutomataGUI();
        ca.setVisible(true);
    }  
    
    
    //Metodos para el menu
    
    private void opcionExportar() throws AutomataException{
            if (1==1){
                
            }
    }
            
            
     private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {                                               
        int valor=JOptionPane.showConfirmDialog(this,"¿Esta seguro que desea Cerrar la aplicacion?","Advertencia",JOptionPane.YES_NO_OPTION);
        if (valor==JOptionPane.YES_OPTION){
           JOptionPane.showMessageDialog(null, "Gracias","Despedida", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }                                              

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {                                               
         JFileChooser chooser = new JFileChooser();
          int returnVal = chooser.showOpenDialog(this);
          if(returnVal == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null,"El proceso se encuentra en construccion, aunque su archivo seleccionado es:  "+ chooser.getSelectedFile().getName(),"Nombre de archivo",JOptionPane.INFORMATION_MESSAGE);
        }   
    }                                              

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setSelectedFile(new File("fileToSave.txt"));
        jFileChooser.showSaveDialog(this);
    } 
    
    private void jMenuItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	 automata=new AutomataCelular();  
   }                                              

    //Fin de metodos del menu
    
    private void jMenuItemAbrir00ActionPerformed(java.awt.event.ActionEvent evt) { 
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showSaveDialog(this);
        
        try {
        	jFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        	File f = jFileChooser.getSelectedFile();
            ObjectInputStream out = new ObjectInputStream(new FileInputStream(f));
            automata=(AutomataCelular)out.readObject();
            foto.repaint();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    } 
    private void jMenuItemGuardar00ActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.showSaveDialog(this);
        
        try {
        	jFileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        	File f = new File(jFileChooser.getSelectedFile()+ ".dat");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(automata);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();

        } 
    }
   private void opcionImporte() {
	   automata=new AutomataCelular();
	   cargarInf();
   }
   private void opcionExporte() {
	   
   }
    
}

class FotoAutomata extends JPanel{
    private AutomataGUI gui;

    public FotoAutomata(AutomataGUI gui) {
        this.gui=gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(gui.DIMENSION, gui.DIMENSION));         
    }


    public void paintComponent(Graphics g){
        AutomataCelular automata=gui.getAutomata();
        super.paintComponent(g);
         
        for (int f=0;f<=automata.getLongitud();f++){
            g.drawLine(f*gui.CELDA,0,f*gui.CELDA,automata.getLongitud()*gui.CELDA);
        }
        for (int c=0;c<=automata.getLongitud();c++){
            g.drawLine(0,c*gui.CELDA,automata.getLongitud()*gui.CELDA,c*gui.CELDA);
        }       
        for (int f=0;f<automata.getLongitud();f++){
            for(int c=0;c<automata.getLongitud();c++){
                if (automata.getElemento(f,c)!=null){
                    g.setColor(automata.getElemento(f,c).getColor());
                    if (automata.getElemento(f,c).forma()==Elemento.CUADRADA){                  
                        if (automata.getElemento(f,c).isVivo()){
                            g.fillRoundRect(gui.CELDA*c+1,gui.CELDA*f+1,gui.CELDA-2,gui.CELDA-2,2,2);
                        }else{
                            g.drawRoundRect(gui.CELDA*c+1,gui.CELDA*f+1,gui.CELDA-2,gui.CELDA-2,2,2);    

                        }
                    }else {
                        if (automata.getElemento(f,c).isVivo()){
                            g.fillOval(gui.CELDA*c+1,gui.CELDA*f+1,gui.CELDA-2,gui.CELDA-2);
                        } else {
                            g.drawOval(gui.CELDA*c+1,gui.CELDA*f+1,gui.CELDA-2,gui.CELDA-2);
                        }
                    }
                }
            }
        }
    }
}