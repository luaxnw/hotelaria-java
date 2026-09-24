public class Main{
    public static void main(String[] args) {
        LeitorUtil leitor = new LeitorUtil();
        Teste t = new Teste("s",2,3);


        leitor.lerEAtribuirInt("Digite o número de fichas: ", t::setNumeroFichas);

        leitor.lerEAtribuirStr("Digite o código: ", t::setCodigo);

        System.out.println(t.getNumeroFichas());
        System.out.println(t.getCodigo());

    }
}