public class Chale extends Acomodacoes {

    private int taxaAquecimento;
    private int taxaLimpeza;

    public Chale(int codigo, int capacidadeMax, double valorBaseDiaria, int diasEstadia, int taxaAquecimento, int taxaLimpeza) {
        super(codigo, capacidadeMax, valorBaseDiaria, diasEstadia);
        this.taxaAquecimento = taxaAquecimento;
        this.taxaLimpeza = taxaLimpeza;
    }

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
    public String mostraDados() {
        String template = "Tipo acomodação: Chalé\nCódigo: %d\nCapacidade máxima: %d\nValor base da diária: %.2f\nDias de estadia: %d\nTaxa de aquecimento: %d\nTaxa de limpeza: %d\n";
        return template.formatted(getCodigo(), getCapacidadeMax(), getValorBaseDiaria(), getDiasEstadia(),
                getTaxaAquecimento(), getTaxaLimpeza());

    }
}
