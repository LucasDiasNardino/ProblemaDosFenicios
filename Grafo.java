import java.util.*;

public class Grafo {
    
    private ArrayList<Nodo> nodos;

    public Grafo() {
        this.nodos = new ArrayList<Nodo>();
    }

    public Nodo addNodo(String data) {
        Nodo nodo = new Nodo(data);
        //verifica se nodo é caminhavel
        if(data.equals("*")){
            nodo.setCaminhavel(false);
        }
        this.nodos.add(nodo);
        return nodo;
    }

    public void addVertice(Nodo nodoInicio, Nodo nodoFinal, Integer peso) {
        nodoInicio.addVertice(nodoFinal, peso);
        nodoFinal.addVertice(nodoInicio, peso);
        
    }

    public void removeVertice(Nodo nodoInicio, Nodo nodoFinal) {
        nodoInicio.removeVertice(nodoFinal);
        nodoFinal.removeVertice(nodoInicio);
    }

    //retorna lista de nodos do grafo
    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    //retorna indice do nodo
    public int getIndexNodo(Nodo nodo){
        return this.nodos.indexOf(nodo);
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
    
    //retorna nodo da esquerda 
    public Nodo getNodoEsquerda(Nodo nodo){
        int index = getIndexNodo(nodo);
        if(index == 0){
            return null;
        }
        //impede que o nodo da esquerda seja um nodo de outra linha
        if(index % 3 == 0){
            return null;
        }
        return this.nodos.get(index - 1);
    }

    //retorna nodo da direita 
    public Nodo getNodoDireita(Nodo nodo){
        int index = getIndexNodo(nodo);
        if(index == this.nodos.size() - 1){
            return null;
        }

        //impede que o nodo da direita seja um nodo de outra linha
        if(index % 3 == 2){
            return null;
        }
        return this.nodos.get(index + 1);
    }

    //retorna nodo de cima
    public Nodo getNodoCima(Nodo nodo, int colunas){
        int index = getIndexNodo(nodo);
        if(index < colunas){
            return null;
        }
        return this.nodos.get(index - colunas);
    }

    //retorna nodo de baixo
    public Nodo getNodoBaixo(Nodo nodo, int colunas){
        int index = getIndexNodo(nodo);
        if(index >= this.nodos.size() - colunas){
            return null;
        }
        return this.nodos.get(index + colunas);
    }


    //procura nodo por nome
    public Nodo procuraNodo(String nome){
        for (Nodo nodo : this.nodos) {
            if(nodo.getNome().equals(nome)){
                return nodo;
            }
        }
        return null;
    }

    //imprime nodos do grafo
    public void imprimeNodos(boolean mostraPeso, boolean caminhavel){
        for (Nodo nodo : nodos) {
            nodo.print(mostraPeso, caminhavel);
        }
    }
}