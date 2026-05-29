public class PasseioGrupo extends Servicos {

    private int qtdMaximaPessoas;
    private double valorBase;

    public int getQtdMaximaPessoas() {
        return qtdMaximaPessoas;
    }

    public void setQtdMaximaPessoas(int qtdMaximaPessoas) {
        this.qtdMaximaPessoas = qtdMaximaPessoas;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    @Override
    public double calcularValor() {
        return valorBase * qtdMaximaPessoas;
    }

    @Override
    public void mostraDados() {
        System.out.printf("Tipo de Serviço: Passeio em grupo\nQuantidade máxima de pessoas\nValor: %.2f",
                qtdMaximaPessoas, calcularValor());
    }

}
