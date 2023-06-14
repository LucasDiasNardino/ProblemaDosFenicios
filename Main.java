import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // inicia timer
        long start = System.currentTimeMillis();
        /*
         * CONSTRUÇÃO DO GRAFO
         */

        String caso0 = "casos\\caso0.txt";
        String caso1 = "casos\\caso1.txt";
        String caso2 = "casos\\caso2.txt";
        String caso3 = "casos\\caso3.txt";
        String caso4 = "casos\\caso4.txt";
        String caso5 = "casos\\caso5.txt";
        String caso6 = "casos\\caso6.txt";
        String caso7 = "casos\\caso7.txt";

        ArrayList<String> casos = new ArrayList<String>();
        casos.add(caso0);
        casos.add(caso1);
        casos.add(caso2);
        casos.add(caso3);
        casos.add(caso4);
        casos.add(caso5);
        casos.add(caso6);
        casos.add(caso7);

        for (String caso : casos) {
            List<List<String>> matrizList = Leitor.criaMatriz(caso);
            String[][] matriz = Leitor.converterParaMatrizDeVetores(matrizList);

            // marcador criação matriz
            long criacaoMatriz = System.currentTimeMillis() - start;

            // Leitor.printaMatriz(matriz);

            Grafo grafo = new Grafo();

            // cria nodo para cada elemento da matriz
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    String nodoat = matriz[i][j];
                    grafo.addNodo(nodoat);
                }
            }

            // liga nodos adjacentes
            GrafoOps.ligaNodos(grafo, matriz);

            // marcador criação do grafo e ligação dos nodos
            long criacaoGrafo = System.currentTimeMillis() - start - criacaoMatriz;

            // grafo.imprimeNodos(false, false);

            /*
             * ENCONTRA CAMINHOS
             */

            Integer menorCaminho = 0;

            Nodo primeiroPorto = Grafo.buscaNodo(grafo, "1");
            Nodo segundoPorto = Grafo.buscaNodo(grafo, "2");

            menorCaminho = GrafoOps.menorCaminho(grafo, primeiroPorto, segundoPorto, false, menorCaminho);

            // marcador encontra caminhos
            long encontraCaminhos = System.currentTimeMillis() - start - criacaoGrafo - criacaoMatriz;

            /*
             * IMPRESSÃO DE RESULTADOS
             */
            System.out.println("\n"+caso+"\nMenor caminho total: " + menorCaminho);

            // impressão marcadores
            System.out.println("Tempo de criação da matriz: " + criacaoMatriz + "ms");
            System.out.println("Tempo de criação do grafo: " + criacaoGrafo + "ms");
            System.out.println("Tempo de encontra caminhos: " + encontraCaminhos + "ms");
            System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + "ms");
        }

    }
}