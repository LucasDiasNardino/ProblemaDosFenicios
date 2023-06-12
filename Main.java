import java.net.SocketPermission;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * CONSTRUÇÃO DO GRAFO
         */

        String[][] matriz = Leitor.criaMatriz("matrizTeste.txt");
    

        Leitor.printaMatriz(matriz);
        
        
        Grafo grafo = new Grafo();

        //cria nodo para cada elemento da matriz
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                String nodoat = matriz[i][j];
                // if( !nodoat.equals("*") ){
                grafo.addNodo(nodoat);
            }
        }

        //liga nodos adjacentes
        GrafoOps.ligaNodos(grafo, matriz);
        
       grafo.imprimeNodos(false, false);
        
        

        /*
         *  ENCONTRA CAMINHOS
         */
        Nodo inicio = grafo.procuraNodo("1");
        Nodo fim = grafo.procuraNodo("2");


        // //itera pelos nodos e retorna
        // for (Nodo nodo : grafo.getNodos()) {
        //     System.out.println(nodo.getNome());
        // }

        GrafoOps.bfs(grafo, inicio, fim);
    
    }
}