import java.net.SocketPermission;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * CONSTRUÇÃO DO GRAFO
         */

        List<List<String>> matrizList = Leitor.criaMatriz("casos\\caso1.txt");
        String[][] matriz = Leitor.converterParaMatrizDeVetores(matrizList);

        //Leitor.printaMatriz(matriz);

        Grafo grafo = new Grafo();

        // cria nodo para cada elemento da matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                String nodoat = matriz[i][j];
                // if( !nodoat.equals("*") ){
                grafo.addNodo(nodoat);
            }
        }

        // liga nodos adjacentes
        GrafoOps.ligaNodos(grafo, matriz);

        //grafo.imprimeNodos(false, false);

        /*
         * ENCONTRA CAMINHOS
         */
        
        Integer menorCaminho = 0;

        Nodo primeiroPorto = Grafo.buscaNodo(grafo, "1");
        Nodo segundoPorto = Grafo.buscaNodo(grafo, "2");

        menorCaminho = GrafoOps.menorCaminho(grafo, primeiroPorto, segundoPorto, false, menorCaminho);

        System.out.println("Menor caminho total: " + menorCaminho);

    }
}