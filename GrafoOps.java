import java.util.*;

public class GrafoOps {


    //liga os nodos vizinhos da esquerda, direita e de cima e de baixo sem pular linhas
    public static void ligaNodos(Grafo grafo, String[][] matriz) {
        int colunas = matriz[0].length;
        for (Nodo nodo : grafo.getNodos()) {
            Nodo nodoEsquerda = grafo.getNodoEsquerda(nodo);
            Nodo nodoDireita = grafo.getNodoDireita(nodo);
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
        fila.add(inicio);
        inicio.setVisitado(true);
        inicio.setDistancia(0);

        while (!fila.isEmpty()) {
            Nodo nodo = fila.remove();
            for (Vertice vertice : nodo.getVertices()) {
                Nodo nodoFinal = vertice.getNodoFinal();
                if (!nodoFinal.isVisitado() && nodoFinal.isCaminhavel()) {
                    nodoFinal.setVisitado(true);
                    nodoFinal.setDistancia(nodo.getDistancia() + 1);
                    nodoFinal.setNodoPai(nodo);
                    fila.add(nodoFinal);
                }
            }
        }

        //imprime caminho
        Nodo nodo = fim;
        while (nodo != null) {
            System.out.print(nodo.getNome() + " ");
            nodo = nodo.getNodoPai();
        }
        System.out.println();
    }
}