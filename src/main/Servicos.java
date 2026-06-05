public abstract class Servicos {

    private int codigo;
    private double valorBase;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo > 0)
            this.codigo = codigo;
        else {
            throw new IllegalArgumentException("O código de serviço deve ser maior que zero");
        }
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        if (valorBase > 0)
            this.valorBase = valorBase;
        else {
            throw new IllegalArgumentException("O valor base deve ser maior que zero");
        }
    }

    public abstract void mostraDados();

    public abstract double calcularValor();

}
