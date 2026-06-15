public class RefeicaoAcomodacao extends Servicos {

    public RefeicaoAcomodacao(int id, double valorBase) {
        super(id, valorBase);
    }

    @Override
    public void mostraDados(){
        System.out.println("Tipo de Serviço: Refeição na acomodação\nValor: " + getValorBase());
    }
    
    @Override
    public double calcularValor(){
        return getValorBase();
    }

    @Override
    public String getNome() {
        return "Refeição acomodação";
    }

    
}
