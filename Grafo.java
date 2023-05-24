import java.util.*;

public class Grafo {
    
    private ArrayList<Nodo> nodos;
    private boolean ponderado;
    private boolean direcionado;

    public Grafo(boolean ponderado, boolean direcionado) {
        this.nodos = new ArrayList<Nodo>();
        this.ponderado = ponderado;
        this.direcionado = direcionado;
    }

    public Nodo addNodo(String data) {
        Nodo nodo = new Nodo(data);
        this.nodos.add(nodo);
        return nodo;
    }

    public void addAresta(Nodo nodoInicio, Nodo nodoFinal, Integer peso) {
        if(!this.ponderado){
            peso = null;
        }

        nodoInicio.addVertice(nodoFinal, peso);

        if(!this.direcionado){
            nodoFinal.addVertice(nodoInicio, peso);
        }
    }

    public void removeVertice(Nodo nodoInicio, Nodo nodoFinal) {
        nodoInicio.removeVertice(nodoFinal);

        if(!this.direcionado){
            nodoFinal.removeVertice(nodoInicio);
        }
    }

    public void removeNodo(Nodo nodo) {
        for (Nodo n : this.nodos) {
            n.removeVertice(nodo);
        }
        this.nodos.remove(nodo);
    }

    //retorna lista de nodos do grafo
    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    //retorna nodo da direita do nodo passado como parametro
    public Nodo getNodoDireita(Nodo nodo){
        int index = this.nodos.indexOf(nodo);
        if(index == this.nodos.size() - 1){
            return null;
        }
        return this.nodos.get(index + 1);
    }

    //retorna nodo da esquerda do nodo passado como parametro
    public Nodo getNodoEsquerda(Nodo nodo){
        int index = this.nodos.indexOf(nodo);
        if(index == 0){
            return null;
        }
        return this.nodos.get(index - 1);
    }

    //imprime nodos do grafo no formato de lista
    public void imprimeNodos(boolean mostraPeso){
        for (Nodo nodo : nodos) {
            nodo.print(mostraPeso);
        }
    }
}
