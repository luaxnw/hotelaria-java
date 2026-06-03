import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pousada {

    private ArrayList<Hospede> hospedes;
    private ArrayList<Acomodacoes> acomodacoes;
    private ArrayList<Servicos> servicos;
    private ArrayList<Reservas> reservas;

    public Pousada() {
        hospedes = new ArrayList<Hospede>();
        acomodacoes = new ArrayList<Acomodacoes>();
        servicos = new ArrayList<Servicos>();
        reservas = new ArrayList<Reservas>();

    }

    public ArrayList<Hospede> getHospedes() {
        return this.hospedes;
    }

    public void setHospedes(ArrayList<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    public ArrayList<Acomodacoes> getAcomodacoes() {
        return this.acomodacoes;
    }

    public void setAcomodacoes(ArrayList<Acomodacoes> acomodacoes) {
        this.acomodacoes = acomodacoes;
    }

    public ArrayList<Servicos> getServicos() {
        return this.servicos;
    }

    public void setServicos(ArrayList<Servicos> servicos) {
        this.servicos = servicos;
    }

    public ArrayList<Reservas> getReservas() {
        return this.reservas;
    }

    public void setReservas(ArrayList<Reservas> reservas) {
        this.reservas = reservas;
    }

    public void adicionarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public void adicionarAcomodacao(Acomodacoes acomodacao) {
        acomodacoes.add(acomodacao);
    }

    public void adicionarServico(Servicos servico) {
        servicos.add(servico);
    }

    public void adicionarReserva(Reservas reserva) {
        reservas.add(reserva);
    }

}
