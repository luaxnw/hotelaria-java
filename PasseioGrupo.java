public class PasseioGrupo extends Servicos {

    private int qtdMaximaPessoas;

    public int getQtdMaximaPessoas() {
        return qtdMaximaPessoas;
    }

    public void setQtdMaximaPessoas(int qtdMaximaPessoas) {
        this.qtdMaximaPessoas = qtdMaximaPessoas;
    }

    @Override
    public void mostraDados() {
        System.out.printf("Tipo de Serviço: Passeio em grupo\nQuantidade máxima de pessoas\nValor: %.2f",
                qtdMaximaPessoas, calcularValor());
    }

    @Override
    public double calcularValor() {
        return getValorBase() * qtdMaximaPessoas;
    }

}
