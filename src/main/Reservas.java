import java.util.ArrayList;

public class Reservas {

    private int codigo;
    private Hospede hospedeResponsavel;
    private Acomodacoes acomodacao;
    private int quantidadeHospedes;
    private int qtdDias;
    private ArrayList<Servicos> servicos;

    public Reservas(int codigo, Hospede hospedeResponsavel, Acomodacoes acomodacao, int quantidadeHospedes,
            int qtdDias) {
        this.codigo = codigo;
        this.hospedeResponsavel = hospedeResponsavel;
        this.acomodacao = acomodacao;
        this.quantidadeHospedes = quantidadeHospedes;
        this.qtdDias = qtdDias;
        servicos = new ArrayList<Servicos>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo > 0)
            this.codigo = codigo;
        else {
            throw new IllegalArgumentException("Código da reserva deve ser maior que 0.");
        }
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
        if (quantidadeHospedes > 0)
            this.quantidadeHospedes = quantidadeHospedes;
        else {
            throw new IllegalArgumentException("Quantidade de hóspede deve ser maior que zero.");
        }
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        if (qtdDias > 0)
            this.qtdDias = qtdDias;
        else {
            throw new IllegalArgumentException("Quantidade de dias de estadia deve ser maior que zero.");
        }
    }

    public ArrayList<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servicos> servicos) {
        this.servicos = servicos;
    }

    public void addServico(Servicos servico) {
        this.servicos.add(servico);
    }

    public double calcularPrecoReserva() {
        double somaValorTotal = 0;
        for (int i = 0; i < servicos.size(); i++) {
            somaValorTotal += servicos.get(i).calcularValor();
        }
        somaValorTotal = +acomodacao.calculaPrecoTotalDiaria();

        return somaValorTotal;
    }

    public void mostraDados() {
        System.out.printf("ID: %d\nHóspede responsável: %s\nAcomodação %s\nQuantidade de hóspedes: %d\nDias estadia: %d\n",
                codigo, hospedeResponsavel.getNome(), acomodacao.getNome(), quantidadeHospedes, qtdDias);

        System.out.println("SERVIÇOS ACOMODAÇÃO");
        for (int i = 0; i < servicos.size(); i++) {
            servicos.get(i).mostraDados();
        }
    }

    public void calculaExtrato() {
        double valorAcomod = acomodacao.calculaPrecoTotalDiaria();
        double valorServicos = 0;

        for (int i = 0; i < servicos.size(); i++) {
            valorServicos += servicos.get(i).calcularValor();
            System.out.println("Serviço: " + servicos.get(i).getNome() + " -> " + servicos.get(i).calcularValor());
        }

        System.out.printf("Valor da acomadação: %.2f\nValor total serviços: %.2f\n==Valor final: %.2f==\n", valorAcomod,
                valorServicos, valorAcomod + valorServicos);

    }

}
