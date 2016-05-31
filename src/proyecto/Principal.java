
/*
 * Proyecto Complejidad y Optimización
 * Simón Naranjo
 * Andrés Cabrera
 */
package proyecto;

import java.util.List;
import lpsolve.LpSolve;
import lpsolve.LpSolveException;

/**
 *
 * @author jsnar
 */
public class Principal {
    
    private Integer[][] alimentos;//[aldeas][aviones]
    private Integer[][] vuelos;//[aldeas][aviones]
    
    private List<Integer> aldeas;
    private List<Integer> aviones;
    
    private LpSolve lpS;
    
    public void ejecutar() {
        leerEntrada();
        optimizar();
    }
    
    public void leerEntrada() {
        
    }
    
    public void optimizar() {
        try {
            alimentos = new Integer[0][0];
            vuelos = new Integer[0][0];
            lpS = LpSolve.makeLp(0, 0);
            
        } catch (LpSolveException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Principal().ejecutar();
    }
}
