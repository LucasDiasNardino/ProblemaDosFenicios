public class Main {

    public static void main(String[] args) {
        String[][] matriz = Leitor.criaMatriz("matrizTeste.txt");
        // Leitor.printaMatriz(matriz);
        
        //variavel de linhas da matriz
        int linhas = matriz.length;

        Grafo grafo = new Grafo(true, false);

        //cria nodo para cada elemento da matriz
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                grafo.addNodo(matriz[i][j]);

            }
        }

        //liga nodos adjacentes
        for(Nodo nodo : grafo.getNodos()){
            //liga nodo esquerda
            if(grafo.getNodoEsquerda(nodo) != null){
                nodo.addVertice(grafo.getNodoEsquerda(nodo), 1);
            }

            //liga direita
            if(grafo.getNodoDireita(nodo) != null){
                nodo.addVertice(grafo.getNodoDireita(nodo), 1);
            }

            //liga acima
            if(grafo.getNodoCima(nodo, matriz.length) != null){
                nodo.addVertice(grafo.getNodoCima(nodo, matriz.length), 1);
            }

            //liga baixo
            if(grafo.getNodoBaixo(nodo, matriz.length) != null){
                nodo.addVertice(grafo.getNodoBaixo(nodo, matriz.length), 1);
            }
        }

        grafo.imprimeNodos(false);
    }
}