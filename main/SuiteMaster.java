public class SuiteMaster extends Acomodacoes {

    @Override
    public double calculaPrecoTotalDiaria() {

        return (getValorBaseDiaria() * getDiasEstadia()) + 130;

    }

    @Override
    public void mostraDados() {

        System.out.printf(
                "Tipo de acomodação: Suíte Master\nCódigo: %d\nCapacidade máxima: %d\nValor diária: %.2f\n",
                getCodigo(), getCapacidadeMax(), getValorBaseDiaria());
    }

}
