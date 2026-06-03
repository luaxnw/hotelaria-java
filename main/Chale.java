public class Chale extends Acomodacoes {

    private int taxaAquecimento;
    private int taxaLimpeza;

    public int getTaxaAquecimento() {
        return taxaAquecimento;
    }

    public void setTaxaAquecimento(int taxaAquecimento) {
        if (taxaAquecimento >= 0) {
            this.taxaAquecimento = taxaAquecimento;
        } else {
            throw new IllegalArgumentException("A taxa deve ser maior que zero.");
        }
    }

    public int getTaxaLimpeza() {
        return taxaLimpeza;
    }

    public void setTaxaLimpeza(int taxaLimpeza) {
        if (taxaLimpeza >= 0) {
            this.taxaLimpeza = taxaLimpeza;
        } else {
            throw new IllegalArgumentException("A taxa deve ser maior que zero.");

        }
    }

    @Override
    public double calculaPrecoTotalDiaria() {

        return ((double) getDiasEstadia() * getValorBaseDiaria()) + (getTaxaAquecimento() * getDiasEstadia())
                + getTaxaLimpeza();
    }

    @Override
    public void mostraDados() {

        System.out.printf(
                "Tipo de acomodação: Chalé\nCódigo: %d\nCapacidade máxima: %d\nValor diária: %.2f\nTaxa de limpeza: %d\nTaxa de aquecimento: %d\n",
                getCodigo(), getCapacidadeMax(), getValorBaseDiaria(), getTaxaLimpeza(), getTaxaAquecimento());
    }

}
