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
    //busca em largura para encontrar menor caminho entre dois nodos e retorna o valor do caminho
    public static void bfs(Grafo grafo, Nodo inicio, Nodo fim){
        Queue<Nodo> fila = new LinkedList<Nodo>();
        ArrayList<Nodo> visitados = new ArrayList<Nodo>();
        ArrayList<Nodo> caminho = new ArrayList<Nodo>();
        int distancia = 0;

        fila.add(inicio);
        visitados.add(inicio);

        while(!fila.isEmpty()){
            Nodo nodo = fila.remove();
            if(nodo.equals(fim)){
                caminho.add(nodo);
                while(nodo.getNodoPai() != null){
                    caminho.add(nodo.getNodoPai());
                    nodo = nodo.getNodoPai();
                }
                break;
            }
            for(Vertice vertice : nodo.getVertices()){
                if(!visitados.contains(vertice.getNodoFinal())){
                    vertice.getNodoFinal().setNodoPai(nodo);
                    fila.add(vertice.getNodoFinal());
                    visitados.add(vertice.getNodoFinal());
                    distancia++;
                }
            }
        }

        //printa caminho
        for(int i = visitados.size()-1; i >= 0; i--){
            System.out.print(visitados.get(i).getNome() + " ");
        }
    }
}