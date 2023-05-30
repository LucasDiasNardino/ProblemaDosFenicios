import java.util.*;

public class GrafoOps {

    //liga nodos adjacentes
    public static void ligaNodos(Grafo grafo, String[][] matriz){
        for(Nodo nodo : grafo.getNodos()){
            //liga nodo esquerda
            if(nodo.isCaminhavel()){
                if(grafo.getNodoEsquerda(nodo) != null && grafo.getNodoEsquerda(nodo).isCaminhavel()){
                    nodo.addVertice(grafo.getNodoEsquerda(nodo), 1);
                }
                //liga direita
                if(grafo.getNodoDireita(nodo) != null && grafo.getNodoDireita(nodo).isCaminhavel()){
                    nodo.addVertice(grafo.getNodoDireita(nodo), 1);
                }

                //liga acima
                if(grafo.getNodoCima(nodo, matriz.length) != null && grafo.getNodoCima(nodo, matriz.length).isCaminhavel()){
                    nodo.addVertice(grafo.getNodoCima(nodo, matriz.length), 1);
                }

                //liga baixo
                if(grafo.getNodoBaixo(nodo, matriz.length) != null && grafo.getNodoBaixo(nodo, matriz.length).isCaminhavel()){
                    nodo.addVertice(grafo.getNodoBaixo(nodo, matriz.length), 1);
                }
            }
        }
    }

    //implementa algoritmo de dijkstra
    public static void dijkstra(Grafo grafo, Nodo nodoInicial){
        //inicializa nodos
        for(Nodo nodo : grafo.getNodos()){
            nodo.setDistancia(Integer.MAX_VALUE);
            nodo.setVisitado(false);
        }

        //inicializa nodo inicial
        nodoInicial.setDistancia(0);
        nodoInicial.setVisitado(true);

        //inicializa fila de prioridade
        PriorityQueue<Nodo> fila = new PriorityQueue<Nodo>();
        fila.add(nodoInicial);

        //enquanto fila nao estiver vazia
        while(!fila.isEmpty()){
            //pega nodo com menor distancia
            Nodo nodoAtual = fila.poll();

            //para cada nodo adjacente
            for(Vertice vertice : nodoAtual.getVertices()){
                Nodo nodoAdjacente = vertice.getNodoFinal();
                int peso = vertice.getPeso();

                //se nodo adjacente nao foi visitado
                if(!nodoAdjacente.isVisitado()){
                    //calcula nova distancia
                    int novaDistancia = nodoAtual.getDistancia() + peso;

                    //se nova distancia for menor que distancia atual
                    if(novaDistancia < nodoAdjacente.getDistancia()){
                        //atualiza distancia
                        nodoAdjacente.setDistancia(novaDistancia);
                        nodoAdjacente.setNodoAnterior(nodoAtual);

                        //adiciona nodo na fila
                        fila.add(nodoAdjacente);
                    }
                }
            }
            //marca nodo atual como visitado
            nodoAtual.setVisitado(true);
        }
    }
}