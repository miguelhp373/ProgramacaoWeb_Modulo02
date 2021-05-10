/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author miguel
 */
public class Dao {
    String sql;
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    
    public void mensagem(String msg){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", msg));
    }
    
    public void salvar(Aluno aluno){
        try {
            conexao = Conexao.getConexao();
            sql = "insert into cad_alunos (nome, escola, serie, matricula) values (?,?,?,?)";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEscola());
            ps.setString(3, aluno.getSerie());
            ps.setString(4, aluno.getMatricula());
            ps.execute();
            Conexao.fechaConexao();
            mensagem("Aluno cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            mensagem("Erro ao cadastrar!");
        }
    }
 
    public void editar(Aluno aluno){
        try {
            conexao = Conexao.getConexao();
            sql = "update cad_alunos set nome = ?,escola = ?, serie = ?, matricula = ? where cod= ?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getEscola());
            ps.setString(3, aluno.getSerie());
            ps.setString(4, aluno.getMatricula());
            ps.setInt(5,aluno.getCodigo());
            ps.execute();
            Conexao.fechaConexao();
            mensagem("Aluno alterado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            mensagem("Erro ao alterar!");
        }
    }
    
    public void excluir(int codigo){
        try {
            conexao = Conexao.getConexao();
            sql = "delete from cad_alunos where cod = ?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.execute();
            Conexao.fechaConexao();
            mensagem("Aluno  excluído com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            mensagem("Erro ao excluir!");
        }
    }
    
    public List<Aluno> listar(){
        try {
            conexao = Conexao.getConexao();
            sql = "select * from cad_alunos";
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<Aluno> listaalunos = new ArrayList<>();
            while(rs.next()){
                Aluno student = new Aluno();
                student.setCodigo(rs.getInt("cod"));
                student.setNome(rs.getString("nome"));
                student.setEscola(rs.getString("escola"));
                student.setSerie(rs.getString("serie"));
                student.setMatricula(rs.getString("matricula"));
                listaalunos.add(student);
            } 
            return listaalunos;
            
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    } 
}
