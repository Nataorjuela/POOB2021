package Aplicacion;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Elemento extends JPanel{
	protected Color colorSnake =new Color (34, 153, 84); 
	protected List<int[] > snake= new ArrayList<>();
    
    protected int tamp,tamc,cantidad;
    protected int residuo;
    protected Arcoiris arco;
    protected String direccion="de";
    protected Informacion info;
    protected String direccionProxima="de";
    protected int conta;
    protected int conta2;
    protected int conta3;
    protected Thread hilo;
    protected Caminante camino;
    protected Alimento ali;
    protected Dulce dulce;
    protected Veneno veneno;
    
    public Elemento() {
    	
    }
}
