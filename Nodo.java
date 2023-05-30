import java.util.ArrayList;

public class Nodo {
    private String nome;
    private ArrayList<Vertice> arestas;
    private Boolean caminhavel;
    
    public Nodo(String data) {
        this.nome = data;
        this.arestas = new ArrayList<Vertice>();
        this.caminhavel = true;
    }

    public void addVertice(Nodo vFinal, int i) {
        this.arestas.add(new Vertice(this, vFinal, i)); 
    }
    public void removeVertice(Nodo vFinal) {
        this.arestas.removeIf(aresta -> aresta.getNodoFinal().equals(vFinal));
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String data) {
        this.nome = data;
    }

    public ArrayList<Vertice> getArestas() {
        return arestas;
    }
    public void setArestas(ArrayList<Vertice> arestas) {
        this.arestas = arestas;
    }

    public Boolean isCaminhavel() {
        return caminhavel;
    }
    public void setCaminhavel(Boolean caminhavel) {
        this.caminhavel = caminhavel;
    }

    public int getDistancia(){
        return Integer.parseInt(this.nome);
    }
    public void setDistancia(int distancia){
        this.nome = Integer.toString(distancia);
    }
  

    public void print(boolean mostraPeso, boolean caminhavel){
        System.out.print(this.nome + " -> ");
        for (Vertice aresta : arestas) {
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
