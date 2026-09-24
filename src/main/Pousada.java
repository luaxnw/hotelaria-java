
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pousada {

    private ArrayList<Hospede> hospedes;
    private ArrayList<Acomodacoes> acomodacoes;
    private ArrayList<Servicos> servicos;
    private ArrayList<Reservas> LISTAreservas;

    public Pousada() {
        hospedes = new ArrayList<Hospede>();
        acomodacoes = new ArrayList<Acomodacoes>();
        servicos = new ArrayList<Servicos>();
        LISTAreservas = new ArrayList<Reservas>();

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
        return this.LISTAreservas;
    }

    public void setReservas(ArrayList<Reservas> reservas) {
        this.LISTAreservas = reservas;
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
        LISTAreservas.add(reserva);
    }

    public void lerAcomodacoes(String nomeArquivo) {
        FileReader file = null;
        String linha;

        try {
            file = new FileReader(nomeArquivo);
            BufferedReader buffer = new BufferedReader(file);

            while ((linha = buffer.readLine()) != null) {
                String[] arrayDaLinha = linha.split(";"); // transforma a linha lida em array a partir do
                // ";"

                if (arrayDaLinha[0].equals("QUARTO")) {
                    int id = Integer.parseInt(arrayDaLinha[1]);
                    int capacidadeMax = Integer.parseInt(arrayDaLinha[2]);
                    double preco = Double.parseDouble(arrayDaLinha[3]);
                    int diasEstadia = Integer.parseInt(arrayDaLinha[4]);

                    acomodacoes.add(new Quarto(id, capacidadeMax, preco, diasEstadia));
                } else if (arrayDaLinha[0].equals("CHALE")) {
                    int id = Integer.parseInt(arrayDaLinha[1]);
                    int capacidadeMax = Integer.parseInt(arrayDaLinha[2]);
                    double preco = Double.parseDouble(arrayDaLinha[3]);
                    int diasEstadia = Integer.parseInt(arrayDaLinha[4]);
                    int taxaAquecimento = Integer.parseInt(arrayDaLinha[5]);
                    int taxaLimpeza = Integer.parseInt(arrayDaLinha[6]);

                    acomodacoes.add(new Chale(id, capacidadeMax, preco, diasEstadia, taxaAquecimento, taxaLimpeza));

                } else if (arrayDaLinha[0].equals("SUITE")) {
                    int id = Integer.parseInt(arrayDaLinha[1]);
                    int capacidadeMax = Integer.parseInt(arrayDaLinha[2]);
                    double preco = Double.parseDouble(arrayDaLinha[3]);
                    int diasEstadia = Integer.parseInt(arrayDaLinha[4]);
                    int valorFixo = Integer.parseInt(arrayDaLinha[5]);

                    acomodacoes.add(new SuiteMaster(id, capacidadeMax, preco, diasEstadia, valorFixo));

                }

            }
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void lerServicos(String nomeArquivo) {
        FileReader file = null;
        String linha;

        try {
            file = new FileReader(nomeArquivo);
            BufferedReader buffer = new BufferedReader(file);

            while ((linha = buffer.readLine()) != null) {
                String[] arrayDaLinha = linha.split(";"); // transforma a linha lida em array a partir do
                // ";"

                if (arrayDaLinha[0].equals("REFEIÇÃO")) {
                    int id = Integer.parseInt(arrayDaLinha[1]);
                    double preco = Double.parseDouble(arrayDaLinha[2]);

                    servicos.add(new RefeicaoAcomodacao(id, preco));
                } else if (arrayDaLinha[0].equals("PASSEIO_EM_GRUPO")) {
                    int id = Integer.parseInt(arrayDaLinha[1]);
                    double preco = Double.parseDouble(arrayDaLinha[2]);
                    int qtdMaximaPessoas = Integer.parseInt(arrayDaLinha[3]);

                    servicos.add(new PasseioGrupo(id, preco, qtdMaximaPessoas));

                } else if (arrayDaLinha[0].equals("SINUCA")) {
                    int id = Integer.parseInt(arrayDaLinha[1]);
                    double preco = Double.parseDouble(arrayDaLinha[2]);
                    int numeroFichas = Integer.parseInt(arrayDaLinha[3]);

                    servicos.add(new Sinuca(id, preco, numeroFichas));

                }

            }
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void salvaDadosHospedes(String nomeArquivo) {
        FileWriter file = null;

        try {
            file = new FileWriter(nomeArquivo);

            for (int i = 0; i < hospedes.size(); i++) { // itera sobre a lista e adiciona no file no formato: x;y;z
                file.write(
                        "Nome hóspede: " + hospedes.get(i).getNome() + "Idade hóspede: " + hospedes.get(i).getIdade() + "CPF hóspede: " + hospedes.get(i).getCPF()
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

            for (int i = 0; i < LISTAreservas.size(); i++) {

                file.write(
                        "Código reserva: " + LISTAreservas.get(i).getCodigo() + "\n" + "Quantidade dias estadia: "
                        + LISTAreservas.get(i).getQtdDias() + "\n"
                        + "Quantidade hóspedes: " + LISTAreservas.get(i).getQuantidadeHospedes() + "\n"
                        + "Hóspede responsável" + LISTAreservas.get(i).getHospedeResponsavel().getNome() + "\n"
                        + "========ACOMODAÇÃO========"
                        + LISTAreservas.get(i).getAcomodacao().mostraDados() + "\n");
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

    public void exibirHospede(String cpf) {
        for (int i = 0; i < hospedes.size(); i++) {

            if (cpf.equals(hospedes.get(i).getCPF())) {

                System.out.printf("NOME: %s\nIDADE: %d\nCPF: %s\n",
                        hospedes.get(i).getNome(),
                        hospedes.get(i).getIdade(),
                        hospedes.get(i).getCPF());

                return;
            }
        }

        System.out.println("Hóspede não localizado");
    }

    public Hospede retornaHospede(String cpf) {
        for (int i = 0; i < hospedes.size(); i++) {

            if (cpf.equals(hospedes.get(i).getCPF())) {
                return hospedes.get(i);
            }
        }

        System.out.println("Hóspede não localizado");
        return null;
    }

    public void listarHospedes() {
        for (int i = 0; i < hospedes.size(); i++) {
            System.out.printf("NOME: %s\nIDADE: %d\nCPF: %s\n",
                    hospedes.get(i).getNome(),
                    hospedes.get(i).getIdade(),
                    hospedes.get(i).getCPF());
            System.out.println("==========");
        }

        return;
    }

    public void exibirAcomodacao(int id) {

        for (int i = 0; i < acomodacoes.size(); i++) {

            if (id == acomodacoes.get(i).getCodigo()) {

                System.out.println(acomodacoes.get(i).mostraDados());

                return;
            }
        }

        System.out.println("Acomodação não localizada");
        return;

    }

    public void exibirServico(int id) {

        for (int i = 0; i < servicos.size(); i++) {

            if (id == servicos.get(i).getCodigo()) {

                servicos.get(i).mostraDados();

                return;
            }
        }

        System.out.println("Serviço não localizado");
        return;

    }

    public void exibirReserva(int id) {

        for (int i = 0; i < LISTAreservas.size(); i++) {
            if (LISTAreservas.get(i).getCodigo() == id) {
                LISTAreservas.get(i).mostraDados();
                return;
            }
        }
        System.out.println("Código não encontrado ");

    }

    public void exibirExtratoReserva(int id) {

        for (int i = 0; i < LISTAreservas.size(); i++) {
            if (id == LISTAreservas.get(i).getCodigo()) {
                LISTAreservas.get(i).calculaExtrato();
                return;
            }
        }
        System.out.println("Código não encontrado ");

    }

}
