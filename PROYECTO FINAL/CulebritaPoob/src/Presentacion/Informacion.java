
package Presentacion;




public class Informacion extends javax.swing.JFrame {
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel LabelPuntajeFruta;
    private javax.swing.JLabel jLabelNombreJugador;
    private javax.swing.JLabel jLabelPersonaje;
    private javax.swing.JLabel jLabelPuntajeDulce;
    private javax.swing.JLabel jLabelPuntajeFrutaArcoiris;
    private javax.swing.JLabel jLabelVeneno;
    String nombre;
    String imagen;
    int fruta;
    int arcoiris;
    int dulce;
    int x;
    // End of variables declaration          
    
    public Informacion(int x,String nombre,String imagen) {
        this.imagen=imagen;
        this.x=x;
        this.nombre=nombre;
        fruta=0;
        arcoiris=0;
        dulce=0;
        initComponents();
    }
    
   public void setFruta(int n){
        fruta=fruta+n;
        String numCadena= String.valueOf(fruta);
        LabelPuntajeFruta.setText("        "+numCadena);
    }
    
   public void setArcoiris(int n){
       arcoiris=arcoiris+n;
       String numCadena= String.valueOf(arcoiris);
       jLabelPuntajeFrutaArcoiris.setText("        "+numCadena);
   }
   
   public void setDulce(int n){
       dulce=dulce+n;
        String numCadena= String.valueOf(dulce);
        jLabelPuntajeDulce.setText("        "+numCadena);
   }
   
   public void setVeneno(){
         jLabelVeneno.setText("Tienes!");
   }
   
   
    private void initComponents() {
        
        jLabelPersonaje = new javax.swing.JLabel();
        LabelPuntajeFruta = new javax.swing.JLabel();
        jLabelPuntajeFrutaArcoiris = new javax.swing.JLabel();
        jLabelPuntajeDulce = new javax.swing.JLabel();
        jLabelVeneno = new javax.swing.JLabel();
        jLabelNombreJugador = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        
        this.setLocation(x,300);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPersonaje.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagen))); 
        getContentPane().add(jLabelPersonaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 120, -1, -1));

        LabelPuntajeFruta.setFont(new java.awt.Font("Segoe UI", 3, 24));
        LabelPuntajeFruta.setForeground(new java.awt.Color(255, 255, 255));
        String numCadena= String.valueOf(fruta);
        LabelPuntajeFruta.setText(numCadena);
        getContentPane().add(LabelPuntajeFruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 190, 40));

        jLabelPuntajeFrutaArcoiris.setFont(new java.awt.Font("Segoe UI", 3, 24)); 
        jLabelPuntajeFrutaArcoiris.setForeground(new java.awt.Color(204, 0, 204));
        numCadena= String.valueOf(arcoiris);
        jLabelPuntajeFrutaArcoiris.setText(numCadena);
        getContentPane().add(jLabelPuntajeFrutaArcoiris, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 170, -1));

        jLabelPuntajeDulce.setFont(new java.awt.Font("Segoe UI", 3, 24)); 
        jLabelPuntajeDulce.setForeground(new java.awt.Color(0, 0, 255));
        numCadena= String.valueOf(dulce);
        jLabelPuntajeDulce.setText(numCadena);
        getContentPane().add(jLabelPuntajeDulce, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 210, -1));

        jLabelVeneno.setFont(new java.awt.Font("Segoe UI", 3, 24)); 
        jLabelVeneno.setForeground(new java.awt.Color(153, 255, 0 ));
        jLabelVeneno.setText("Aun no");
        getContentPane().add(jLabelVeneno, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, -1));

        jLabelNombreJugador.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36));
        jLabelNombreJugador.setForeground(new java.awt.Color(255, 0, 51));
        jLabelNombreJugador.setText(nombre);
        getContentPane().add(jLabelNombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 300, 50));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); 
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    } 
         
}
