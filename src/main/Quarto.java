public class Quarto extends Acomodacoes {

    public Quarto(int codigo, int capacidadeMax, double valorBaseDiaria, int diasEstadia) {
        super(codigo, capacidadeMax, valorBaseDiaria, diasEstadia);
    }

    @Override
    public String getNome(){
        return "Quarto";
    }

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
