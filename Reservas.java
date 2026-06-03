import java.util.ArrayList;

public class Reservas {

    private int codigo;
    private Hospede hospedeResponsavel;
    private Acomodacoes acomodacao;
    private int quantidadeHospedes;
    private int qtdDias;
    private ArrayList<Servicos> servicos;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Hospede getHospedeResponsavel() {
        return hospedeResponsavel;
    }

    public void setHospedeResponsavel(Hospede hospedeResponsavel) {
        this.hospedeResponsavel = hospedeResponsavel;
    }

    public Acomodacoes getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacoes acomodacao) {
        this.acomodacao = acomodacao;
    }

    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }

    public void setQuantidadeHospedes(int quantidadeHospedes) {
        this.quantidadeHospedes = quantidadeHospedes;
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    public ArrayList<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servicos> servicos) {
        this.servicos = servicos;
    }

    public void addServico(Servicos servicos) {
        if (this.servicos == null) {
            this.servicos = new ArrayList<>();
        }
        this.servicos.add(servicos);
    }

    public double calcularPrecoReserva(){
        double somaValorTotal = 0;
        for (int i = 0; i < servicos.size(); i++){
            somaValorTotal += servicos.get(i).calcularValor();
        }
        somaValorTotal =+ acomodacao.calculaPrecoTotalDiaria();
        
        return somaValorTotal;
    }









}
