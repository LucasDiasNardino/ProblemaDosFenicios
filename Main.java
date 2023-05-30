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
                grafo.addNodo(matriz[i][j]);

            }
        }

        //liga nodos adjacentes
        GrafoOps.ligaNodos(grafo, matriz);
        System.out.println("Imprimir nodos?\n");
        
        grafo.imprimeNodos(false, false);
        
        

        /*
         *  ENCONTRA CAMINHOS
         */
        GrafoOps.dijkstra(grafo, grafo.buscaNodo(grafo, "1"));
        Leitor.printaMatriz(matriz);
    }
}