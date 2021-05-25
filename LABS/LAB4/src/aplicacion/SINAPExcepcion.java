/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author Nata
 */
public class SINAPExcepcion extends Exception {
    public static final String SIN_NOMBRE_INTERNACIONAL="el Area no tiene nombre internacional";
    public static final String AREA_REPETIDA ="el Area ya existe";
    public static final String AREA_ERRONEA ="el area ingresada es menor a 0";
    public static final String HUBO_UN_ERROR="Se genero un error";
    
    public SINAPExcepcion(String mensaje){
        super(mensaje);
    }
}
