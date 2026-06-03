public class Quarto extends Acomodacoes {

    @Override
    public double calculaPrecoTotalDiaria() {

        return (double) getDiasEstadia() * getValorBaseDiaria();
    }

    @Override
    public void mostraDados() {

        System.out.printf("Tipo de acomodação: Quarto\nCódigo: %d\nCapacidade máxima: %d\nValor diária: %.2f\n",
                getCodigo(), getCapacidadeMax(), getValorBaseDiaria());
    }

}
