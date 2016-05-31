
/*
 * Proyecto Complejidad y Optimización
 * Simón Naranjo
 * Andrés Cabrera
 */
package proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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
        List<String> listaLineas = new ArrayList();
        
        try {
            FileReader fr = new FileReader("entrada.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null) {
                listaLineas.add(linea);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        String[] listaTokensPrimeraLinea = listaLineas.get(0).split("\\s");
        Integer nAldeas = Integer.parseInt(listaTokensPrimeraLinea[0]);
        Integer nAviones = Integer.parseInt(listaTokensPrimeraLinea[1]);
    }
    
    public void optimizar() {
        alimentos = new Integer[0][0];
        vuelos = new Integer[0][0];
        
        try {
            lpS = LpSolve.makeLp(0, 0);
        } catch (LpSolveException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Principal().ejecutar();
    }
}
