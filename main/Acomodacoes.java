public abstract class Acomodacoes {

    private int codigo;
    private int capacidadeMax;
    private double valorBaseDiaria;
    private int diasEstadia;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("O código deve ser maior que zero.");
        }
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        if (capacidadeMax > 0) {
            this.capacidadeMax = capacidadeMax;
        } else {
            throw new IllegalArgumentException("A capacidade máxima deve ser maior que zero.");
        }
    }

    public double getValorBaseDiaria() {
        return valorBaseDiaria;
    }

    public void setValorBaseDiaria(double valorBaseDiaria) {
        if (valorBaseDiaria > 0) {
            this.valorBaseDiaria = valorBaseDiaria;
        } else {
            throw new IllegalArgumentException("O valor base da diária deve ser maior que zero.");
        }
    }

    public int getDiasEstadia() {
        return diasEstadia;
    }

    public void setDiasEstadia(int diasEstadia){
        if (diasEstadia > 0){
            this.diasEstadia = diasEstadia;
        }
        else{
            throw new IllegalArgumentException("O número de dias de estadia deve ser maior que zero.");
        }
    }

    public abstract String mostraDados();

    public abstract double calculaPrecoTotalDiaria();

}