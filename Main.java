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
        
        grafo.imprimeNodos(false, false);
        
        

        /*
         *  ENCONTRA CAMINHOS
         */
        Nodo inicio = grafo.procuraNodo("1");
        Nodo fim = grafo.procuraNodo("2");

        GrafoOps.bfs(grafo, inicio, fim);
    
    }
}