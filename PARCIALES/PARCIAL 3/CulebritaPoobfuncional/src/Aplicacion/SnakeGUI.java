package Aplicacion;

import java.awt.Color;
import java.awt.event.KeyEvent;


public class SnakeGUI extends javax.swing.JFrame {
    
    Snake snake;
    Snake snake2;
    Informacion info1;
    Informacion info2;
    Alimento comida;
    Arcoiris arco;
    Dulce dulce;
    Veneno veneno;

public SnakeGUI(Color color,String nombre,String imagen) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        dispose();
        setUndecorated(true);
        setVisible(true);
        
        
        this.arco = new Arcoiris(800,30);
        this.comida=new Alimento(800,30);
        this.dulce=new Dulce(800,30);
        this.veneno=new Veneno(800,30);
        
        info1=new Informacion(1400,nombre,imagen);
        info1.setVisible(true);  
        
        snake=new Snake(800,30,comida,info1,arco,dulce,veneno);
        snake.setcolorSnake(color);
         snake.empezarEn(0, 0);
        this.add(snake);
        snake.setBounds(10,10,800,800);
        snake.setOpaque(false);

        this.add(comida);
        comida.setBounds(10,10,800,800);
        comida.setOpaque(false);
        
        this.add(arco);
        arco.setBounds(10,10,800,800);
        arco.setOpaque(false);
        
        this.add(dulce);
        dulce.setBounds(10,10,800,800);
        dulce.setOpaque(false);
        
        this.add(veneno);
        veneno.setBounds(10,10,800,800);
        veneno.setOpaque(false);
        
       iniciarFondo();
    }
    
     public SnakeGUI(Color color,String nombre,Color color2,String nombre2,String imagen1,String imagen2) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        dispose();
        setUndecorated(true);
        setVisible(true);
        
        this.comida=new Alimento(800,30);
        this.arco = new Arcoiris(800,30);
        this.dulce=new Dulce(800,30);
        this.veneno=new Veneno(800,30);
         info1=new Informacion(1400,nombre,imagen1);
        info1.setVisible(true);  
        
        snake=new Snake(800,30,comida,info1,arco,dulce,veneno);
        snake.setcolorSnake(color);
        snake.empezarEn(0, 0);
        this.add(snake);
        snake.setBounds(10,10,800,800);
        snake.setOpaque(false);
         
        segundoJugador(color2,nombre2,imagen2);

        this.add(comida);
        comida.setBounds(10,10,800,800);
        comida.setOpaque(false);
        
        this.add(arco);
        arco.setBounds(10,10,800,800);
        arco.setOpaque(false);
       
        this.add(dulce);
        dulce.setBounds(10,10,800,800);
        dulce.setOpaque(false);
        
         this.add(veneno);
        veneno.setBounds(10,10,800,800);
        veneno.setOpaque(false);
        
        iniciarFondo();
        
    }
    
     private void iniciarFondo(){
         PanelFondo fondo = new PanelFondo(800,30);
        this.add(fondo);
        fondo.setBounds(10,10,800,800);
        this.requestFocus(true);
     }
    private void segundoJugador(Color color, String nombre,String imagen){
        info2=new Informacion(0,nombre,imagen);
        info2.setVisible(true);
        snake2=new Snake(800,30,comida,info2,arco,dulce,veneno);
        snake2.setcolorSnake(color);
        snake2.empezarEn(500,500);
        this.add(snake2);
        snake2.setBounds(10,10,800,800);
        snake2.setOpaque(false);
    }
    
    //         metodos de la clase snakeGUI
    
    private void initComponents() {
         
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        
        pack();
    }    

//Controles     
    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
        switch (evt.getKeyCode()) {
            //Primer Jugador 
            case KeyEvent.VK_LEFT:
                snake.cambiarDireccion("iz");
                break;
            case KeyEvent.VK_RIGHT:
                snake.cambiarDireccion("de");
                break;
            case KeyEvent.VK_UP:
                snake.cambiarDireccion("ar");
                break;
            case KeyEvent.VK_DOWN:
                snake.cambiarDireccion("ab");
                break;
             //pausar
             case KeyEvent.VK_P:
                snake2.pausar();
                snake.pausar();
                break;
             //renudar
             case KeyEvent.VK_R:
                snake2.renudar();
                snake.renudar();
                break;   
             //Segundo Jugador
            case KeyEvent.VK_D:
                snake2.cambiarDireccion("de");
                break;
            case KeyEvent.VK_A:
                snake2.cambiarDireccion("iz");
                break;
            case KeyEvent.VK_S:
                snake2.cambiarDireccion("ab");
                break;
            case KeyEvent.VK_W:
                snake2.cambiarDireccion("ar");
                break;
            default:
                break;
        }
    }                               
         
}
