import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Pousada pousada = new Pousada();
        Scanner sc = new Scanner(System.in);

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

                    System.out.println("Nome hóspede: ");
                    hospede.setNome(sc.nextLine());

                    System.out.println("Idade hóspede: ");
                    hospede.setIdade(sc.nextInt());
                    sc.nextLine();

                    System.out.println("CPF hóspede: ");
                    hospede.setCPF(sc.nextLine());

                    pousada.adicionarHospede(hospede);

                    break;

                case 2:
                    System.out.println("\n=====OPÇÃO: EXIBIR DADOS HÓSPEDES=====");
                    booelan encontrou = false;

                    System.out.println("Informe o CPF do hóspede: ");
                    String CPF = sc.nextLine();

                    for (int i = 0; i < pousada.getHospedes().size(); i++) {
                        if (CPF.equals(pousada.getHospedes().get(i).getCPF())) {
                            System.out.printf("NOME: %s\nIDADE: %d\nCPF: %s\n", pousada.getHospedes().get(i).getNome(),
                                    pousada.getHospedes().get(i).getIdade(), pousada.getHospedes().get(i).getCPF());
                                    encontrou = true;
                            break;
                        }
                    }
                    if (!encontrou)
                            System.out.println("CPF não localizado.");
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
                    boolean encontrou = false;

                    System.out.println("Informe o código da acomodação: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < pousada.getAcomodacoes().size(); i++) {
                        if (id == pousada.getAcomodacoes().get(i).getCodigo()) {
                            pousada.getAcomodacoes().get(i).mostraDados();
                            encontrou = true;
                            break;
                        }
                    }
                    if (!encontrou)
                        System.out.println("Código de acomodação não localizado. ");
                    break;

                case 5:
                    System.out.println("\n=====OPÇÃO: EXIBIR TODAS AS ACOMODAÇÕES=====");
                    
                    for (int i = 0; i < pousada.getAcomodacoes().size(); i++) {
                        pousada.getAcomodacoes().get(i).mostraDados();
                    }

                    break;

                case 6:
                    exibirServico(teclado, pousada);
                    break;

                case 7:
                    exibirTodosServicos(pousada);
                    break;

                case 8:
                    cadastrarReserva(teclado, pousada);
                    break;

                case 9:
                    adicionarServicoReserva(teclado, pousada);
                    break;

                case 10:
                    exibirReserva(teclado, pousada);
                    break;

                case 11:
                    exibirTodasReservas(pousada);
                    break;

                case 12:
                    exibirExtrato(teclado, pousada);
                    break;

                case 13:
                    pousada.salvarHospedes("dados/hospedes.txt");
                    pousada.salvarReservas("dados/reservas.txt");
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
