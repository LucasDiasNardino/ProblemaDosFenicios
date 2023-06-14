import java.util.*;

public class Main {

    public static void main(String[] args) {
        //inicia timer
        long start = System.currentTimeMillis();
        /*
         * CONSTRUÇÃO DO GRAFO
         */
        List<List<String>> matrizList = Leitor.criaMatriz("casos\\caso0.txt");
        String[][] matriz = Leitor.converterParaMatrizDeVetores(matrizList);

        //marcador criação matriz
        long criacaoMatriz = System.currentTimeMillis() - start;

        //Leitor.printaMatriz(matriz);

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

        //marcador criação do grafo e ligação dos nodos
        long criacaoGrafo = System.currentTimeMillis() - start - criacaoMatriz;

        //grafo.imprimeNodos(false, false);

        /*
         * ENCONTRA CAMINHOS
         */
        
        Integer menorCaminho = 0;

        Nodo primeiroPorto = Grafo.buscaNodo(grafo, "1");
        Nodo segundoPorto = Grafo.buscaNodo(grafo, "2");

        menorCaminho = GrafoOps.menorCaminho(grafo, primeiroPorto, segundoPorto, false, menorCaminho);

        //marcador encontra caminhos
        long encontraCaminhos = System.currentTimeMillis() - start - criacaoGrafo - criacaoMatriz;

        /*
         * IMPRESSÃO DE RESULTADOS
         */
        System.out.println("Menor caminho total: " + menorCaminho);

        //impressão marcadores
        System.out.println("Tempo de criação da matriz: " + criacaoMatriz + "ms");
        System.out.println("Tempo de criação do grafo: " + criacaoGrafo + "ms");
        System.out.println("Tempo de encontra caminhos: " + encontraCaminhos + "ms");
        System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + "ms");

    }
}