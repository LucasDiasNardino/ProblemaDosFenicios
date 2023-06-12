import java.util.*;

public class GrafoOps {


    //liga os nodos vizinhos da esquerda, direita e de cima e de baixo sem pular linhas
    public static void ligaNodos(Grafo grafo, String[][] matriz) {
        int colunas = matriz[0].length;
        for (Nodo nodo : grafo.getNodos()) {
            Nodo nodoEsquerda = grafo.getNodoEsquerda(nodo, colunas);
            Nodo nodoDireita = grafo.getNodoDireita(nodo, colunas);
            Nodo nodoCima = grafo.getNodoCima(nodo, colunas);
            Nodo nodoBaixo = grafo.getNodoBaixo(nodo, colunas);


            if (nodoEsquerda != null && nodoEsquerda.isCaminhavel()) {
                nodo.addVertice(nodoEsquerda, 1);
            }
            if (nodoDireita != null && nodoDireita.isCaminhavel()) {
                nodo.addVertice(nodoDireita, 1);
            }
            if (nodoCima != null && nodoCima.isCaminhavel()) {
                nodo.addVertice(nodoCima, 1);
            }
            if (nodoBaixo != null && nodoBaixo.isCaminhavel()) {
                nodo.addVertice(nodoBaixo, 1);
            }
        }
    }

    //busca em largura para encontrar o caminho mais curto entre dois nodos sem pular linhas e passar por nodos não caminháveis
    public static void bfs(Grafo grafo, Nodo inicio, Nodo fim) {
        Queue<Nodo> fila = new LinkedList<Nodo>();
        inicio.setVisitado(true);
        fila.add(inicio);
        //inicializa dicionario para armazenar distancia de cada nodo em relacao ao nodo inicial
        HashMap<Nodo, Integer> distancias = new HashMap<Nodo, Integer>();
        distancias.put(inicio, 0);

        //enquanto a fila nao estiver vazia
        while(!fila.isEmpty()){
            //retira proximo nodo da fila
            Nodo nodoAtual = fila.remove();

            //verifica se o nodo atual eh o nodo final
            if(nodoAtual.equals(fim)){
                System.out.println("Caminho encontrado!");
                System.out.println("Distancia: " + distancias.get(nodoAtual));
                return;
            }

            //para cada nodo vizinho do nodo atual
            for(Vertice vertice : nodoAtual.getVertices()){
                Nodo nodoVizinho = vertice.getNodoFinal();
                //se o nodo vizinho nao foi visitado
                if(!nodoVizinho.isVisitado()){
                    //marca como visitado
                    nodoVizinho.setVisitado(true);
                    //adiciona na fila
                    fila.add(nodoVizinho);
                    //adiciona no dicionario de distancias
                    distancias.put(nodoVizinho, distancias.get(nodoAtual) + 1);
                }
            }
        }
        //se a fila ficar vazia, nao existe caminho entre os nodos
        System.out.println("Nao existe caminho entre os nodos");
    }
}