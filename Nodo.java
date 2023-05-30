import java.util.ArrayList;

public class Nodo {
    private String nome;
    private ArrayList<Aresta> arestas;
    private Boolean caminhavel;
    
    public Nodo(String data) {
        this.nome = data;
        this.arestas = new ArrayList<Aresta>();
        this.caminhavel = true;
    }

    public void addVertice(Nodo vFinal, int i) {
        this.arestas.add(new Aresta(this, vFinal, i)); 
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

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    //get distancia
    public int getDistancia(){
        return Integer.parseInt(this.nome);
    }

    //set distancia
    public void setDistancia(int distancia){
        this.nome = Integer.toString(distancia);
    }


    public void print(boolean mostraPeso, boolean caminhavel){
        System.out.print(this.nome + " -> ");
        for (Aresta aresta : arestas) {
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

    public Boolean isCaminhavel() {
        return caminhavel;
    }

    public void setCaminhavel(Boolean caminhavel) {
        this.caminhavel = caminhavel;
    }

}
