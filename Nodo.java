import java.util.ArrayList;

public class Nodo {
    private String nome;
    private ArrayList<Vertice> vertices;
    private Boolean caminhavel;
    private Boolean visitado;
    private int distancia;

    public Nodo(String data) {
        this.nome = data;
        this.vertices = new ArrayList<Vertice>();
        this.caminhavel = true;
        this.visitado = false;
    }

    //nodo pai
    public Nodo getNodoPai(){
        return this.vertices.get(0).getNodoFinal();
    }
    public void setNodoPai(Nodo nodo){
        this.vertices.get(0).setNodoFinal(nodo);
    }

    public void addVertice(Nodo vFinal, int i) {
        this.vertices.add(new Vertice(this, vFinal, i)); 
    }
    public void removeVertice(Nodo vFinal) {
        this.vertices.removeIf(aresta -> aresta.getNodoFinal().equals(vFinal));
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String data) {
        this.nome = data;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }
    public void setVertices(ArrayList<Vertice> arestas) {
        this.vertices = arestas;
    }

    public Boolean isCaminhavel() {
        return caminhavel;
    }
    public void setCaminhavel(Boolean caminhavel) {
        this.caminhavel = caminhavel;
    }

    public Boolean isVisitado() {
        return visitado;
    }
    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }

    public int getDistancia(){
        return this.distancia;
    }
    public void setDistancia(int distancia){
        this.distancia = distancia;
    }
  
    //altera nodo anterior para o nodo passado como parametro
    public void setNodoAnterior(Nodo nodo){
        this.vertices.get(0).setNodoFinal(nodo);
    }

    public void print(boolean mostraPeso, boolean caminhavel){
        System.out.print(this.nome + " -> ");
        for (Vertice aresta : vertices) {
            System.out.print(aresta.getNodoFinal().getNome());
            if(mostraPeso){
                System.out.print("Peso:" + aresta.getPeso() + " ");
            }
            else if(caminhavel){
                System.out.print("Caminhavel:" + aresta.getNodoFinal().isCaminhavel() + " ");
            }
            System.out.print(", ");
        
        }
        System.out.println();
    }
}
