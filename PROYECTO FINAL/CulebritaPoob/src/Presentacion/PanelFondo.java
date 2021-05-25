
package Presentacion;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PanelFondo extends JPanel{
    Color colorFondo =new Color(161, 136, 127); 
    int tamp,tamc,cantidad;
    int residuo;
    
    public PanelFondo(int tamp,int cantidad){
        this.tamp=tamp;
        this.cantidad=cantidad;
        this.tamc=tamp/cantidad;
        this.residuo=tamp%cantidad;
    }
    
    @Override
    public void paint(Graphics pintor){
        super.paint(pintor);
        pintor.setColor(colorFondo);
        for (int i=0; i< cantidad; i++){
            for (int j=0;j<cantidad;j++){
                pintor.fillRect(residuo/2+ i*tamc,residuo/2+j*tamc,tamc-1,tamc-1);
            }
        }
    }
    
}
