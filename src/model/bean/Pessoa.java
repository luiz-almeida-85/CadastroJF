
package model.bean;

public class Pessoa {
    
    private int IdPessoa;
    private String Nome;
    private String DataNascimento;
    private Fisica Fisica;
    private Juridica Juridica;

    public Fisica getFisica() {
        return Fisica;
    }

    public void setFisica(Fisica Fisica) {
        this.Fisica = Fisica;
    }

    public Juridica getJuridica() {
        return Juridica;
    }

    public void setJuridica(Juridica Juridica) {
        this.Juridica = Juridica;
    }

    public int getIdPessoa() {
        return IdPessoa;
    }

    public void setIdPessoa(int IdPessoa) {
        this.IdPessoa = IdPessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }


    //Construtor
    
    public Pessoa(int IdPessoa, String Nome, String DataNascimento) {
        this.IdPessoa = IdPessoa;
        this.Nome = Nome;
        this.DataNascimento = DataNascimento;

    }
    
    public Pessoa (){
        
        this.IdPessoa = 0;
        this.Nome = "";
        this.DataNascimento = "";
    
    }
 
    
}
