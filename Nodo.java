import java.util.ArrayList;

public class Nodo {

    private String data;
    private ArrayList<Aresta> arestas;
    
    public Nodo(String data) {
        this.data = data;
        this.arestas = new ArrayList<Aresta>();
    }

    public void addVertice(Nodo vFinal, int peso) {
        this.arestas.add(new Aresta(this, vFinal, peso)); 
    }

    public void removeVertice(Nodo vFinal) {
        this.arestas.removeIf(aresta -> aresta.getNodoFinal().equals(vFinal));
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public void print(boolean mostraPeso){
        System.out.print(this.data + " -> ");
        for (Aresta aresta : arestas) {
            System.out.print(aresta.getNodoFinal().getData());
            if(mostraPeso){
                System.out.print(" (" + aresta.getPeso() + ")");
            }
            System.out.print(", ");
        }
        System.out.println();
    }
}
