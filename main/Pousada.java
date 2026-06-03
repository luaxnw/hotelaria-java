import java.util.ArrayList;
import java.io.BufferedReader;
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

    public void lerAcomodacoes(String nomeArquivo) {
        FileReader file = null;

        try { 
            file = new FileReader(nomeArquivo);
            while(file.ready()){
                System.out.println();
            }
        }

    }

    public void lerServicos(String nomeArquivo) {
        FileReader file = null;

        try { 
            file = new FileReader(nomeArquivo);
        }

    }

    public void salvaDadosHospedes(String nomeArquivo) {
        FileWriter file = null;

        try {
            file = new FileWriter(nomeArquivo);

            for (int i = 0; i < hospedes.size(); i++) { // itera sobre a lista e adiciona no file no formato: x;y;z
                file.write(
                        hospedes.get(i).getNome() + ";" + hospedes.get(i).getIdade() + ";" + hospedes.get(i).getCPF()
                                + "\n");
            }
            file.close(); // fecha quando finaliza

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file != null) { // caso houve erro no meio do primeiro try e o arquivo foi parcialmente
                            // preenchido vai fazer um try para fechar o arquivo
            try {
                file.close();
            } catch (IOException ee) {
                ee.printStackTrace();

            }
        }
    }

    public void salvaDadosReservas(String nomeArquivo) {
        FileWriter file = null;

        try {

            file = new FileWriter(nomeArquivo);

            for (int i = 0; i < reservas.size(); i++) {

                file.write(
                        reservas.get(i).getCodigo() + ";" + reservas.get(i).getQtdDias() + ";"
                                + reservas.get(i).getQuantidadeHospedes() + ";"
                                + reservas.get(i).getAcomodacao().getCodigo() + ";"
                                + reservas.get(i).getHospedeResponsavel().getNome() + ";"
                                + reservas.get(i).arrayServicosParaString() + "\n");
            }
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file != null) { // caso houve erro no meio do primeiro try e o arquivo foi parcialmente
                            // preenchido vai fazer um try para fechar o arquivo
            try {
                file.close();
            } catch (IOException ee) {
                ee.printStackTrace();

            }
        }

    }

}
