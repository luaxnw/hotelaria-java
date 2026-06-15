public class PasseioGrupo extends Servicos {

    private int qtdMaximaPessoas;

    public PasseioGrupo(int codigo, double valorBase, int qtdMaximaPessoas) {
        super(codigo, valorBase);
        this.qtdMaximaPessoas = qtdMaximaPessoas;
    }

    public int getQtdMaximaPessoas() {
        return qtdMaximaPessoas;
    }

    public void setQtdMaximaPessoas(int qtdMaximaPessoas) {
        if (qtdMaximaPessoas > 0)
            this.qtdMaximaPessoas = qtdMaximaPessoas;
        else {
            throw new IllegalArgumentException("Quantidade máxima de pessoas deve ser maior que zero");
        }
    }

    @Override
    public void mostraDados() {
        System.out.printf("Tipo de Serviço: Passeio em grupo\nQuantidade máxima de pessoas %d\nValor: %.2f\n",
                qtdMaximaPessoas, calcularValor());
    }

    @Override
    public double calcularValor() {
        return getValorBase() * qtdMaximaPessoas;
    }

    @Override
    public String getNome() {
        return "Passeio em grupo";
    }

}
