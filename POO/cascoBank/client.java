package poo.cascoBank;

public class client {
    private String nome;
    private String cpf;
    private String profissao;

    public client(String nome, String cpf, String profissao){
        this.cpf = cpf;
        this.nome = nome;
        this.profissao = profissao;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nomeNovo){
        this.nome = nomeNovo;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getProfissao(){
        return this.profissao;
    }

    public void setProfissao(String profissao){
        this.profissao =  profissao;
    }
}
