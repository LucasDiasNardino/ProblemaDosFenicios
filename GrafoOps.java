import java.util.*;

public class GrafoOps {
    public static void ligaNodos(Grafo grafo, String[][] matriz){
        //liga nodos adjacentes
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


    //busca nodo pelo nome
    public static Nodo buscaNodo(Grafo grafo, String nome){
        for (Nodo nodo : grafo.getNodos()) {
            if(nodo.getNome().equals(nome)){
                return nodo;
            }
        }
        return null;
    }    
}