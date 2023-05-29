import java.util.*;

public class GrafoOps {
    public static void ligaNodos(Grafo grafo, String[][] matriz){
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
    }
    
    //descobre o caminho mais curto entre dois nodos
    
}
