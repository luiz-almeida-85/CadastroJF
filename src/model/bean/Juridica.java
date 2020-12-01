
package model.bean;

public class Juridica extends Pessoa {
    
    private String RazaoSocial;
    private String Endereco;
    private int Cnpj;

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public int getCnpj() {
        return Cnpj;
    }

    public void setCnpj(int Cnpj) {
        this.Cnpj = Cnpj;
    }

    //Construtor
    public Juridica(String RazaoSocial, String Endereco, int Cnpj) {
        this.RazaoSocial = RazaoSocial;
        this.Endereco = Endereco;
        this.Cnpj = Cnpj;
    }
    
    public Juridica(){
        this.RazaoSocial = "";
        this.Endereco = "";
        this.Cnpj = 0;
        
        
    }
}
