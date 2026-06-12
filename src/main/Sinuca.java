public class Sinuca extends Servicos {

    public int numeroFichas;

    public Sinuca(int codigo, double valorBase, int numeroFichas) {
        super(codigo, valorBase);
        this.numeroFichas = numeroFichas;
    }

    public int getNumeroFichas() {
        return numeroFichas;
    }

    public void setNumeroFichas(int numeroFichas) {
        if (numeroFichas > 0)
            this.numeroFichas = numeroFichas;
        else {
            throw new IllegalArgumentException("Número de fichas deve ser maior que zero");
        }
    }

    @Override
    public void mostraDados() {
        System.out.printf(
                "Tipo de serviço: Jogo de sinuca\nValor por ficha: %.2f\nNúmero de fichas compradas: %d\nValor total: %.2f\n",
                getValorBase(), getNumeroFichas(), calcularValor());
    }

    @Override
    public double calcularValor() {
        return getValorBase() * numeroFichas;
    }

}