
package Presentacion;

import javax.swing.JOptionPane;

import java.awt.Color;

public class SeleccionDePersonaje extends javax.swing.JFrame {
    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonAmarilla;
    private javax.swing.JButton jButtonAzul;
    private javax.swing.JButton jButtonNaranja;
    private javax.swing.JButton jButtonRoja;
    private javax.swing.JButton jButtonRosa;
    private javax.swing.JButton jButtonSerpiente;
    private javax.swing.JLabel jLabelFondo;
    SnakeGUI snake;
    boolean dos;
    // End of variables declaration       

    
  
  
    
    public SeleccionDePersonaje(boolean son) {
        this.dos=son;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void nombreJugador(Color color,String imagen){
        String nombre=JOptionPane.showInputDialog("Ingrese el nombre del jugador1 :");
        if (dos){
        this.setVisible(false);
        snake =new SnakeGUI(color,nombre,imagen);
        snake.setVisible(true);
        }
        else{
          String nombre2=JOptionPane.showInputDialog("Ingrese el nombre del jugador2 :");  
          Color nuevo=new Color(121, 125, 127 );
         snake =new SnakeGUI(color,nombre,nuevo,nombre2,imagen,"/Imagenes/2player.png");
         this.setVisible(false);
         snake.setVisible(true);
        }
    }
                          
    private void initComponents() {

        jButtonAmarilla = new javax.swing.JButton();
        jButtonAzul = new javax.swing.JButton();
        jButtonSerpiente = new javax.swing.JButton();
        jButtonRosa = new javax.swing.JButton();
        jButtonRoja = new javax.swing.JButton();
        jButtonNaranja = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAmarilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteAmarillaPeque.png"))); // NOI18N
        jButtonAmarilla.setContentAreaFilled(false);
        jButtonAmarilla.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteAmarillaPeque.png"))); // NOI18N
        jButtonAmarilla.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteAmarilla.png"))); // NOI18N
        jButtonAmarilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAmarillaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAmarilla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 190, 290));

        jButtonAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteAzulpeque.png"))); // NOI18N
        jButtonAzul.setContentAreaFilled(false);
        jButtonAzul.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteAzulpeque.png"))); // NOI18N
        jButtonAzul.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteAzul.png"))); // NOI18N
        jButtonAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAzulActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 160, 250));

        jButtonSerpiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpientepeque.png"))); // NOI18N
        jButtonSerpiente.setContentAreaFilled(false);
        jButtonSerpiente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpientepeque.png"))); // NOI18N
        jButtonSerpiente.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpiente.png"))); // NOI18N
        jButtonSerpiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSerpienteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSerpiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 190, 260));

        jButtonRosa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteRosapeque.png"))); // NOI18N
        jButtonRosa.setContentAreaFilled(false);
        jButtonRosa.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteRosapeque.png"))); // NOI18N
        jButtonRosa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteRosa.png"))); // NOI18N
        jButtonRosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRosaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 190, 280));

        jButtonRoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteRojapeque.png"))); // NOI18N
        jButtonRoja.setContentAreaFilled(false);
        jButtonRoja.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteRojapeque.png"))); // NOI18N
        jButtonRoja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteRoja.png"))); // NOI18N
        jButtonRoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRojaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, -1, 260));

        jButtonNaranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteNaranjapeque.png"))); // NOI18N
        jButtonNaranja.setContentAreaFilled(false);
        jButtonNaranja.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteNaranjapeque.png"))); // NOI18N
        jButtonNaranja.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/serpienteNaranja.png"))); // NOI18N
        jButtonNaranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNaranjaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNaranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, 200, 260));
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SeleccionPersonaje.png"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 860));

        pack();
    }                    

    private void jButtonAmarillaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        Color color = new Color(241, 196, 15);
        nombreJugador(color,"/Imagenes/serpienteAmarilla.png");
    }                                               

    private void jButtonAzulActionPerformed(java.awt.event.ActionEvent evt) {                                            
         Color color = new Color(52, 152, 219 );
         nombreJugador(color,"/Imagenes/serpienteAzul.png");
    }                                           

    private void jButtonSerpienteActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        Color color = new Color(39, 174, 96 );
        nombreJugador(color,"/Imagenes/serpiente.png");
    }                                                

    private void jButtonRosaActionPerformed(java.awt.event.ActionEvent evt) {                                            
         Color color = new Color(240, 98, 146);
         nombreJugador(color,"/Imagenes/serpienteRosa.png");
    }                                           

    private void jButtonRojaActionPerformed(java.awt.event.ActionEvent evt) {                                            
         Color color = new Color(203, 67, 53);
         nombreJugador(color,"/Imagenes/serpienteRoja.png");
    }                                           

    private void jButtonNaranjaActionPerformed(java.awt.event.ActionEvent evt) {                                               
         Color color = new Color(255, 87, 34 );
         nombreJugador(color,"/Imagenes/serpienteNaranja.png");
    }                                              
            
}
