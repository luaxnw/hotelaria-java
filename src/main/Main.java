import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File dadosHospedes = new File("dados/hospedes.txt");
        Scanner sc = new Scanner(System.in);
        LeitorUtil leitor = new LeitorUtil();
        Pousada pousada = new Pousada();

        if (dadosHospedes.exists()) {
            System.out.println("Arquivo de dados de hóspedes localizado!");
        }

        File dadosReservas = new File("dados/reservas.txt");

        if (dadosReservas.exists()) {
            System.out.println("Arquivo de dados de reservas localizado!");
        }

        pousada.lerAcomodacoes("dados/dadosAcomodacoes.txt");
        pousada.lerServicos("dados/dadosServicos.txt");

        int opcao;

        do {

            System.out.println("\n===== POUSADA OÁSIS DO OESTE =====");
            System.out.println("1 - Cadastrar hóspede");
            System.out.println("2 - Exibir dados de um hóspede");
            System.out.println("3 - Exibir todos os hóspedes");
            System.out.println("4 - Exibir dados de uma acomodação");
            System.out.println("5 - Exibir todas as acomodações");
            System.out.println("6 - Exibir dados de um serviço");
            System.out.println("7 - Exibir todos os serviços");
            System.out.println("8 - Cadastrar reserva");
            System.out.println("9 - Adicionar serviço a uma reserva");
            System.out.println("10 - Exibir dados de uma reserva");
            System.out.println("11 - Exibir todas as reservas");
            System.out.println("12 - Exibir extrato de uma reserva");
            System.out.println("13 - Salvar dados em arquivo");
            System.out.println("14 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("\n=====OPÇÃO: ADICIONAR HÓSPEDE=====");

                    Hospede hospede = new Hospede(null, 0, null);

                    leitor.lerEAtribuirStr("Nome hóspede: ", hospede::setNome);

                    leitor.lerEAtribuirInt("Idade do hóspede " + hospede.getNome() + ":", hospede::setIdade);

                    leitor.lerEAtribuirStr("CPF do hóspede " + hospede.getNome() + ":", hospede::setCPF);

                    pousada.adicionarHospede(hospede);

                    break;

                case 2:
                    System.out.println("\n=====OPÇÃO: EXIBIR DADOS HÓSPEDES=====");

                    System.out.println("Informe o CPF do hóspede: ");
                    pousada.exibirHospede(sc.nextLine());

                    break;

                case 3:
                    System.out.println("\n=====OPÇÃO: EXIBIR TODOS OS HÓSPEDES=====");

                    for (int i = 0; i < pousada.getHospedes().size(); i++) {
                        System.out.printf("NOME: %s\nIDADE: %d\nCPF: %s\n", pousada.getHospedes().get(i).getNome(),
                                pousada.getHospedes().get(i).getIdade(), pousada.getHospedes().get(i).getCPF());
                    }
                    
                    break;

                case 4:
                    System.out.println("\n=====OPÇÃO: EXIBIR DADOS ACOMODAÇÃO=====");

                    System.out.println("Informe o código da acomodação: ");
                    pousada.exibirAcomodacao(sc.nextInt());
                    sc.nextLine();

                    break;

                case 5:
                    System.out.println("\n=====OPÇÃO: EXIBIR TODAS AS ACOMODAÇÕES=====");

                    for (int i = 0; i < pousada.getAcomodacoes().size(); i++) {
                        System.out.println(pousada.getAcomodacoes().get(i).mostraDados());
                    }

                    break;

                case 6:
                    System.out.println("\n=====OPÇÃO: EXIBIR DADOS SERVIÇOS======");

                    System.out.println("Informe o código do serviço: ");
                    pousada.exibirServico(sc.nextInt());
                    sc.nextLine();

                    break;

                case 7:
                    System.out.println("\n=====OPÇÃO: EXIBIR DADOS SERVIÇOS======");

                    for (int i = 0; i < pousada.getServicos().size(); i++) {
                        pousada.getServicos().get(i).mostraDados();
                    }

                    break;

                case 8:
                    System.out.println("\n=====OPÇÃO: CADASTRAR RESERVA======");

                    Reservas reserva = new Reservas(0, null, null, 0, 0);

                    System.out.println("Informe o código da reserva: ");
                    reserva.setCodigo(sc.nextInt());
                    sc.nextLine();

                    System.out.println("Informe os dados do hóspede responsável pela acomodação: ");
                    Hospede hospedeResposavel = new Hospede(null, 0, null);

                    System.out.println("Nome hóspede responsável: ");
                    hospedeResposavel.setNome(sc.nextLine());

                    System.out.println("Idade hóspede responsável: ");
                    hospedeResposavel.setIdade(sc.nextInt());
                    sc.nextLine();

                    System.out.println("CPF do hóspede responsável: ");
                    hospedeResposavel.setCPF(sc.nextLine());

                    reserva.setHospedeResponsavel(hospedeResposavel);

                    System.out.println("Informe a quantidade de dias de estadia: ");
                    reserva.setQtdDias(sc.nextInt());
                    sc.nextLine();

                    System.out.println("Informe os dados de acomodação da reserva: ");

                    System.out.println("Escolha entre:\n1. QUARTO\n2. CHALÉ\n3. SUÍTE MASTER");
                    int opcaoAcomo = sc.nextInt();
                    sc.nextLine();

                    int diasEstadia = reserva.getQtdDias();

                    if (opcaoAcomo == 1) {
                        reserva.setAcomodacao(new Quarto(1, 2, 90.00, diasEstadia));
                    } else if (opcaoAcomo == 2) {
                        reserva.setAcomodacao(new Chale(2, 5, 150.00, diasEstadia, 10, 15));
                    } else if (opcaoAcomo == 3) {
                        reserva.setAcomodacao(new SuiteMaster(3, 3, 115.00, diasEstadia));
                    }

                    System.out.println("Informe a quantidade de hóspedes: ");
                    reserva.setQuantidadeHospedes(sc.nextInt());
                    sc.nextLine();

                    pousada.adicionarReserva(reserva);

                    break;

                case 9:
                    System.out.println("\n=====OPÇÃO: ADICIONAR SERVIÇO A RESERVA======");

                    System.out.println("Informe o código da reserva: ");
                    int codigoReserva = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < pousada.getReservas().size(); i++) {
                        if (pousada.getReservas().get(i).getCodigo() == codigoReserva) {
                            System.out.println(
                                    "Informe o código do serviço\n1. REFEIÇÃO\n2. PASSEIO EM GRUPO\n3. SINUCA");
                            int codigoServico = sc.nextInt();
                            sc.nextLine();

                            if (codigoServico == 1) {
                                RefeicaoAcomodacao RA = new RefeicaoAcomodacao(1, 30.00);
                                pousada.getReservas().get(i).addServico(RA);
                                break;
                            } else if (codigoServico == 2) {
                                PasseioGrupo PG = new PasseioGrupo(2, 25.00, 5);
                                pousada.getReservas().get(i).addServico(PG);
                                break;
                            } else if (codigoServico == 3) {
                                Sinuca sinuca = new Sinuca(3, 5.00, 4);
                                pousada.getReservas().get(i).addServico(sinuca);
                                break;
                            } else {
                                System.out.println("Código de serviço inválido");
                                break;
                            }

                        }
                    }

                    break;

                case 10:
                    System.out.println("\n=====OPÇÃO: MOSTRA DADOS RESERVA======");

                    System.out.println("Informe o código da reserva: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    pousada.exibirReserva(id);

                    break;

                case 11:
                    System.out.println("\n=====OPÇÃO: MOSTRA TODAS RESERVAS======");

                    for (int i = 0; i < pousada.getReservas().size(); i++) {
                        pousada.getReservas().get(i).mostraDados();
                    }

                    break;

                case 12:
                    System.out.println("\n=====OPÇÃO: MOSTRA EXTRATO RESERVA======");

                    System.out.println("Informe o ID da reserva: ");
                    pousada.exibirExtratoReserva(sc.nextInt());
                    sc.nextLine();

                    break;

                case 13:
                    pousada.salvaDadosHospedes("dados/hospedes.txt");
                    pousada.salvaDadosReservas("dados/reservas.txt");
                    System.out.println("Dados salvos com sucesso!");
                    break;

                case 14:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 14);

        sc.close();
    }
}
