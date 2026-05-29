public abstract class Servicos {

    private int codigo;

    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public abstract void mostraDados();
    public abstract double calcularValor();


    
}
