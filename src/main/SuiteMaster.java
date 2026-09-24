
public class SuiteMaster extends Acomodacoes {

    private int valorFixo;

    public SuiteMaster(int codigo, int capacidadeMax, double valorBaseDiaria, int diasEstadia, int valorFixo) {
        super(codigo, capacidadeMax, valorBaseDiaria, diasEstadia);
        this.valorFixo = valorFixo;
    }

    public void setValorFixo(int valorFixo) {
        if (valorFixo > 0) {
            this.valorFixo = valorFixo;
        } else {
            throw new IllegalArgumentException("Valor fixo da suíte master deve ser maior que zero. ");
        }

    }

    public int getValorFixo() {
        return valorFixo;
    }

    @Override
    public String getNome() {
        return "Suíte Master";
    }

    @Override
    public double calculaPrecoTotalDiaria() {
        return (getValorBaseDiaria() * getDiasEstadia()) + valorFixo;
    }

    @Override
    public String mostraDados() {
        String template = "Tipo de acomodação: Suíte Master\nCódigo: %d\nCapacidade máxima: %d\nValor fixo definido: %d\nValor diária: %.2f\n";
        return template.formatted(getCodigo(), getCapacidadeMax(), getValorFixo(), getValorBaseDiaria());
    }
}
