public abstract class Servicos {

    private int codigo;
    private double valorBase;

    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public double getValorBase(){
        return valorBase;
    }

    public void setValorBase(double valorBase){
        this.valorBase = valorBase;
    }

    public abstract void mostraDados();
    public abstract double calcularValor();


    
}
