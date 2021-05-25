package Presentacion;

import java.awt.Color;
import java.awt.event.KeyEvent;
import Aplicacion.*;


public class SnakeGUI extends javax.swing.JFrame {
    
    Snake snake;
    Snake snake2;
    Informacion info1;
    Informacion info2;
    Alimento comida;
    Arcoiris arco;
    Dulce dulce;
    poder poder;
    Veneno veneno;
    Juego juego;

public SnakeGUI(Color color,String nombre,String imagen) {
        
        initComponents();
        
        this.setLocationRelativeTo(null);
        dispose();
        setUndecorated(true);
        setVisible(true);

        info1=new Informacion(1400,nombre,imagen);
        info1.setVisible(true);  
        
        snake=new Snake(800,30);
        snake.setcolorSnake(color);
         snake.empezarEn(1, 1);
        this.add(snake);
        snake.setBounds(10,10,800,800);
        snake.setOpaque(false);

        iniciar_comida();
       
        juego=new Juego(snake,info1,comida,arco,dulce,veneno,poder);
        juego.setBounds(10, 10, 800, 800);
        juego.setOpaque(false);
        this.add(juego);
        
       iniciarFondo();
    }

   
    
     public SnakeGUI(Color color,String nombre,Color color2,String nombre2,String imagen1,String imagen2) {
          initComponents();
          this.setLocationRelativeTo(null);
          dispose();
          setUndecorated(true);
          setVisible(true);
        

        info1=new Informacion(1400,nombre,imagen1);
        info1.setVisible(true);  
        
        snake=new Snake(800,30);
        snake.setcolorSnake(color);
        snake.empezarEn(1, 1);
        this.add(snake);
        snake.setBounds(10,10,800,800);
        snake.setOpaque(false);
        
        info2=new Informacion(0,nombre2,imagen2);
        info2.setVisible(true);  
        
        snake2=new Snake(800,30);
        snake2.setcolorSnake(color2);
         snake2.empezarEn(2,2);
        this.add(snake2);
        snake2.setBounds(10,10,800,800);
        snake2.setOpaque(false);

        iniciar_comida();
       
        juego=new Juego(snake,snake2,info1,comida,arco,dulce,veneno,poder);
        juego.setBounds(10, 10, 800, 800);
        juego.setOpaque(false);
        this.add(juego);
        
       iniciarFondo();
    }
    
     
    
     private void iniciarFondo(){
         PanelFondo fondo = new PanelFondo(800,30);
        this.add(fondo);
        fondo.setBounds(10,10,800,800);
        this.requestFocus(true);
     }

    //         metodos de la clase snakeGUI
    
    

 private void iniciar_comida(){
         this.comida=new Alimento();
         
        this.arco = new Arcoiris();
       
        this.dulce=new Dulce();
        this.veneno=new Veneno();
        this.poder=new poder();
        
        añadir_comida_al_frame(comida);
        añadir_comida_al_frame(arco);
        añadir_comida_al_frame(dulce);
        añadir_comida_al_frame(veneno);
        añadir_comida_al_frame(poder);

    }    
 
 private void añadir_comida_al_frame(Alimento comida){
            this.add(comida);
            comida.setBounds(10,10,800,800);
            comida.setOpaque(false);
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
                //snake2.pausar();
                juego.pausar();
                break;
             //renudar
             case KeyEvent.VK_R:
                
                juego.renudar();
                break; 
              //usar poder 
                case KeyEvent.VK_SPACE:
                    juego.poder();
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
}
