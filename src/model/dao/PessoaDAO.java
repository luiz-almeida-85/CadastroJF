package model.dao;

import static connection.Conexao.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pessoa;
import model.bean.Fisica;
import model.bean.Juridica;

//CRUD VAI SER EXECUTADO
//CREATE READ UPDATE DELETE
// INSERT
public class PessoaDAO {

    public void create(Pessoa p, Fisica f, Juridica j) {

        connection.Conexao.Conectar();

        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO pessoa (Nome,DataNascimento,Rg,Cpf,NomeDaMae,NomeDoPai,RazaoSocial,Endereco,Cnpj) VALUES (?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDataNascimento());
            stmt.setInt(3, f.getRg());
            stmt.setInt(4, f.getCpf());
            stmt.setString(5, f.getNomeDaMae());
            stmt.setString(6, f.getNomeDoPai());
            stmt.setString(7, j.getRazaoSocial());
            stmt.setString(8, j.getEndereco());
            stmt.setInt(9, j.getCnpj());

            stmt.executeUpdate();   // Excuta e rodas os comando no SQL no Banco

            JOptionPane.showMessageDialog(null, "Feito cadastro com sucesso...");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            connection.Conexao.Desconectar(); // Fecha conexão Depois de Executar SQL
        }
    }

// SELECT
    public Pessoa read(String Nome) {

        Pessoa p = new Pessoa();
        Fisica f = new Fisica();
        Juridica j = new Juridica();

        connection.Conexao.Conectar();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM pessoa WHERE Nome Like  ?");
           
            stmt.setString(1, "%"+Nome+"%");

            rs = stmt.executeQuery();

            //while (rs.next)
            if (rs.next() == true) {
                
                p.setIdPessoa(rs.getInt("IdPessoa"));
                p.setNome(rs.getString("Nome"));
                p.setDataNascimento(rs.getString("DataNascimento"));
                f.setRg(rs.getInt("Rg"));
                f.setCpf(rs.getInt("Cpf"));
                f.setNomeDaMae(rs.getString("NomeDaMae"));
                f.setNomeDoPai(rs.getString("NomeDoPai"));
                j.setRazaoSocial(rs.getString("RazaoSocial"));
                j.setEndereco(rs.getString("Endereco"));
                j.setCnpj(rs.getInt("Cnpj"));
                p.setFisica(f);
                p.setJuridica(j);

                JOptionPane.showMessageDialog(null, "Nome Encontrado...");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não Localizado no banco de dados... ");
        } finally {
            connection.Conexao.Desconectar();
        }
        return p;
    }

// UPDATE
    public void update(Pessoa p, Fisica f, Juridica j) {

        connection.Conexao.Conectar();

        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE pessoa SET Nome = ?, DataNascimento = ? , Rg = ? , Cpf = ?, NomeDaMae = ?, NomeDoPai = ?, RazaoSocial = ? , Endereco = ? , Cnpj = ?  WHERE IdPessoa = ?");

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDataNascimento());
            stmt.setInt(3, f.getRg());
            stmt.setInt(4, f.getCpf());
            stmt.setString(5, f.getNomeDaMae());
            stmt.setString(6, f.getNomeDoPai());
            stmt.setString(7, j.getRazaoSocial());
            stmt.setString(8, j.getEndereco());
            stmt.setInt(9, j.getCnpj());
            stmt.setInt(10, p.getIdPessoa());

            stmt.executeUpdate();  // Executar os comando no banco SQL

            JOptionPane.showMessageDialog(null, "Feito atualização com sucesso ...");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Houve algum problema na atualização.. " + ex);
        } finally {
            connection.Conexao.Desconectar(); //Fechar conexão
        }
    }

// DELETE
    public void delete(Pessoa p) {

        connection.Conexao.Conectar();  // abri o Banco

        PreparedStatement stmt = null;  // É quem Recebe os comandos SQL

        try {
            stmt = conexao.prepareStatement("DELETE FROM pessoa WHERE IdPessoa = ?");
            stmt.setInt(1, p.getIdPessoa());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso ... ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao excluir... " + ex);
        } finally {
            connection.Conexao.Desconectar();
        }
    }

}
 