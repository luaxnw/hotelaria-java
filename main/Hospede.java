public class Hospede {

    private String nome;
    private int idade;
    private String CPF;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0 && idade < 130)
            this.idade = idade;
        else {
            throw new IllegalArgumentException("Informe uma idade válida.");
        }
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {

        int stringLength = CPF.length();

        if (stringLength == 14) {
            this.CPF = CPF;
        } else {
            throw new IllegalArgumentException("Informe um CPF válido.\nFormato: 000.000.000-00");
        }

    }

}