import java.util.*;

public class GrafoOps {

    // liga os nodos vizinhos da esquerda, direita e de cima e de baixo sem pular
    // linhas
    public static void ligaNodos(Grafo grafo, String[][] matriz) {
        int nodos = grafo.getNodos().size();
        int numColumns = matriz[0].length;
        int numRows = matriz.length;

        for (int i = 0; i < nodos; i++) {
            Nodo nodoAtual = grafo.getNodos().get(i);
            int currentRow = i / numColumns;
            int currentColumn = i % numColumns;

            // Connect with node above
            if (currentRow > 0) {
                Nodo nodoAcima = grafo.getNodos().get(i - numColumns);
                if (!nodoAcima.getNome().equals("*")) {
                    nodoAtual.addVertice(nodoAcima, 1);
                }
            }

            // Connect with node below
            if (currentRow < numRows - 1) {
                Nodo belowNode = grafo.getNodos().get(i + numColumns);
                if (!belowNode.getNome().equals("*")) {
                    nodoAtual.addVertice(belowNode, 1);
                }
            }

            // Connect with node to the left
            if (currentColumn > 0) {
                Nodo leftNode = grafo.getNodos().get(i - 1);
                if (!leftNode.getNome().equals("*")) {
                    nodoAtual.addVertice(leftNode, 1);
                }
            }

            // Connect with node to the right
            if (currentColumn < numColumns - 1) {
                Nodo rightNode = grafo.getNodos().get(i + 1);
                if (!rightNode.getNome().equals("*")) {
                    nodoAtual.addVertice(rightNode, 1);
                }
            }
        }
    }

    // busca em largura para encontrar o caminho mais curto entre dois nodos sem
    // pular linhas e passar por nodos não caminháveis
    public static int bfs(Grafo grafo, Nodo inicio, Nodo fim) {
        Queue<Nodo> fila = new LinkedList<Nodo>();
        inicio.setVisitado(true);
        fila.add(inicio);
        // inicializa dicionario para armazenar distancia de cada nodo em relacao ao
        // nodo inicial
        HashMap<Nodo, Integer> distancias = new HashMap<Nodo, Integer>();
        distancias.put(inicio, 0);

        // enquanto a fila nao estiver vazia
        while (!fila.isEmpty()) {
            // retira proximo nodo da fila
            Nodo nodoAtual = fila.remove();

            // verifica se o nodo atual eh o nodo final
            if (nodoAtual.equals(fim)) {
                System.out.println("Caminho encontrado!");
                distancias.get(nodoAtual);
                //define todos os nodos como não visitados
                grafo.resetVisitados(grafo);
                return distancias.get(nodoAtual);
            }

            // para cada nodo vizinho do nodo atual
            for (Vertice vertice : nodoAtual.getVertices()) {
                Nodo nodoVizinho = vertice.getNodoFinal();
                // se o nodo vizinho nao foi visitado
                if (!nodoVizinho.isVisitado()) {
                    // marca como visitado
                    nodoVizinho.setVisitado(true);
                    // adiciona na fila
                    fila.add(nodoVizinho);
                    // adiciona no dicionario de distancias
                    distancias.put(nodoVizinho, distancias.get(nodoAtual) + 1);
                }
            }
        }
        // se a fila ficar vazia, nao existe caminho entre os nodos
        System.out.println("Nao existe caminho entre os nodos");
        return 0;
    }

    public static int menorCaminho(Grafo grafo, Nodo inicio, Nodo fim, Boolean stop, int menorCaminho) {

        if (stop) {
            grafo.resetVisitados(grafo);
            Nodo origem = Grafo.buscaNodo(grafo, Integer.toString(1));
            menorCaminho += bfs(grafo, inicio, origem);
            return menorCaminho;
        }
        
        Integer nomeFim = Integer.parseInt(fim.getNome());

        Nodo prox = Grafo.buscaNodo(grafo, Integer.toString(nomeFim + 1));

        if(fim.getNome().equals("9")){
            stop = true;
        }
        
        grafo.resetVisitados(grafo);
        int caminho = bfs(grafo, inicio, fim);

        if (caminho != 0) {
            menorCaminho += caminho;
            System.out.println("Nodo " + inicio.getNome() + " ate nodo " + fim.getNome() + " = " + caminho);
            return caminho = menorCaminho(grafo, fim, prox, stop, menorCaminho);
        } else {
            System.out.println("Nodo " + inicio.getNome() + " ate nodo " + fim.getNome() + " = " + caminho);
            return caminho = menorCaminho(grafo, inicio, prox, stop, menorCaminho);
        }
    }
}