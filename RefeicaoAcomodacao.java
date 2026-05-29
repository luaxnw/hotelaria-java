public class RefeicaoAcomodacao extends Servicos {

    private double precoRefeicao;

    public void setPrecoRefeicao(double precoRefeicao){
        this.precoRefeicao = precoRefeicao;

    }

    @Override
    public void mostraDados(){
        System.out.println("Tipo de Serviço: Refeição na acomodação\nValor: " + precoRefeicao);
    }
    
    @Override
    public double calcularValor(){
        return precoRefeicao;
    }
    
}
