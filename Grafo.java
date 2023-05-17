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
}
