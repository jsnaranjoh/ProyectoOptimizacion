
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
    private List<Integer> maxViajesAvion;
    
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
        
        alimentos = new Integer[nAldeas][nAviones];
        vuelos = new Integer[nAldeas][nAviones];
        
        for(Integer i=1; i<=nAviones && i<(listaLineas.size()-2); i++) {
            String[] listaTokensNLinea = listaLineas.get(i).split("\\s");
            for(Integer j=0; j<nAldeas && j<listaTokensNLinea.length; j++) {
                alimentos[j][i-1] = Integer.parseInt(listaTokensNLinea[j]);
            }
        }
        
        String[] listaTokensPenultimaLinea = listaLineas.get(listaLineas.size()-1).split("\\s");
        for(Integer i=0; i<nAviones && i<listaTokensPenultimaLinea.length; i++) {
            maxViajesAvion.add(Integer.parseInt(listaTokensPenultimaLinea[i]));
        }
    }
    
    public void optimizar() {
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
