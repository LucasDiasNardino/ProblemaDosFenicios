public class Vertice {

    private Nodo nodoInicio;
    private Nodo nodoFinal;
    private Integer peso;

    public Vertice(Nodo nodoInicio, Nodo nodoFinal, Integer peso) {
        this.nodoInicio = nodoInicio;
        this.nodoFinal = nodoFinal;
        this.peso = peso;
    }

    public Nodo getNodoInicio() {
        return nodoInicio;
    }
    public void setNodoInicio(Nodo nodoInicio) {
        this.nodoInicio = nodoInicio;
    }

    public Nodo getNodoFinal() {
        return nodoFinal;
    }
    public void setNodoFinal(Nodo nodoFinal) {
        this.nodoFinal = nodoFinal;
    }

    public Integer getPeso() {
        return peso;
    }
    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}
