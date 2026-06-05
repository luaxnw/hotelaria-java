public class Sinuca extends Servicos {

    public int numeroFichas;

    public int getNumeroFichas() {
        return numeroFichas;
    }

    public void setNumeroFichas(int numeroFichas) {
        this.numeroFichas = numeroFichas;
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