public class SuiteMaster extends Acomodacoes {

    @Override
    public double calculaPrecoTotalDiaria() {

        return (getValorBaseDiaria() * getDiasEstadia()) + 130;

    }

    @Override
    public String mostraDados() {
        String template = "Tipo de acomodação: Suíte Master\nCódigo: %d\nCapacidade máxima: %d\nValor diária: %.2f\n";
        return template.formatted(getCodigo(), getCapacidadeMax(), getValorBaseDiaria());
    }
}