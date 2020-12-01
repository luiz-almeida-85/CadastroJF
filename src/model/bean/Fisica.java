
package model.bean;

public class Fisica extends Pessoa {

    private int Rg;
    private int Cpf;
    private String NomeDaMae;
    private String NomeDoPai;
    

    public int getRg() {
        return Rg;
    }

    public void setRg(int Rg) {
        this.Rg = Rg;
    }

    public int getCpf() {
        return Cpf;
    }

    public void setCpf(int Cpf) {
        this.Cpf = Cpf;
    }

    public String getNomeDaMae() {
        return NomeDaMae;
    }

    public void setNomeDaMae(String NomeDaMae) {
        this.NomeDaMae = NomeDaMae;
    }

    public String getNomeDoPai() {
        return NomeDoPai;
    }

    public void setNomeDoPai(String NomeDoPai) {
        this.NomeDoPai = NomeDoPai;
    }
    
    //Construtor

    public Fisica(int Rg, int Cpf, String NomeDaMae, String NomeDoPai) {
        this.Rg = Rg;
        this.Cpf = Cpf;
        this.NomeDaMae = NomeDaMae;
        this.NomeDoPai = NomeDoPai;
    }

    public Fisica() {

        this.Rg = 0;
        this.Cpf = 0;
        this.NomeDaMae = "";
        this.NomeDoPai = "";

    }

}
