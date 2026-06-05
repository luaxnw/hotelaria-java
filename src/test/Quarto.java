public class Quarto extends Acomodacoes {

    @Override
    public double calculaPrecoTotalDiaria() {

        return (double) getDiasEstadia() * getValorBaseDiaria();
    }

    @Override
    public String mostraDados() {
        String template = "Tipo de acomodação: Quarto\nCódigo: %d\nCapacidade máxima: %d\nValor diária: %.2f\n";
        return template.formatted(getCodigo(), getCapacidadeMax(), getValorBaseDiaria());
    }

}
