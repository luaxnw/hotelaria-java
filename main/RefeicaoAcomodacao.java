public class RefeicaoAcomodacao extends Servicos {

    @Override
    public void mostraDados(){
        System.out.println("Tipo de Serviço: Refeição na acomodação\nValor: " + getValorBase());
    }
    
    @Override
    public double calcularValor(){
        return getValorBase();
    }
    
}
