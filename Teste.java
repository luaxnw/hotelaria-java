
public class Teste {

    public int numeroFichas;
    private String codigo;
    private double valorBase;

    public Teste(String codigo, double valorBase, int numeroFichas) {
        this.numeroFichas = numeroFichas;
        this.codigo = codigo;
        this.valorBase = valorBase;
    }

    public int getNumeroFichas() {
        return numeroFichas;
    }

    public void setNumeroFichas(int numeroFichas) {
        if (numeroFichas > 0) {
            this.numeroFichas = numeroFichas;
        } else {
            throw new IllegalArgumentException("Número de fichas deve ser maior que zero");
        }
    }

    public void setCodigo(String codigo) {
        if (codigo.length() > 0) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("String vazia");
        }
    }

    public String getCodigo(){
        return codigo;
    }

}
