/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developer;

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
 * @author rafaelcergoli
 */
public class CarrosDAO {
    String sql;
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    
    public void mensagem(String msg){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", msg));
    }
    
    public void salvar(Carros carro){
        try {
            conexao = BDConnection.getConexao();
            sql = "insert into tbcarros (marca, modelo, cor, ano) values (?,?,?,?)";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, carro.getMarca());
            ps.setString(2, carro.getModelo());
            ps.setString(3, carro.getCor());
            ps.setInt(4, carro.getAno());
            ps.execute();
            BDConnection.fechaConexao();
            mensagem("Carro cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CarrosDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem("Erro ao cadastrar!");
        }
    }
    
    public void editar(Carros carro){
        try {
            conexao = BDConnection.getConexao();
            sql = "update tbcarros set marca = ?, modelo = ?, cor = ?, ano = ? where idcarro = ?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, carro.getMarca());
            ps.setString(2, carro.getModelo());
            ps.setString(3, carro.getCor());
            ps.setInt(4, carro.getAno());
            ps.setInt(5, carro.getId());
            ps.execute();
            BDConnection.fechaConexao();
            mensagem("Carro alterado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CarrosDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem("Erro ao alterar!");
        }
    }
    
    public void excluir(int id){
        try {
            conexao = BDConnection.getConexao();
            sql = "delete from tbcarros where idCarro = ?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            BDConnection.fechaConexao();
            mensagem("Carro excluído com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(CarrosDAO.class.getName()).log(Level.SEVERE, null, ex);
            mensagem("Erro ao excluir!");
        }
    }
    
    public List<Carros> listar(){
        try {
            conexao = BDConnection.getConexao();
            sql = "select * from tbcarros";
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            
            List<Carros> listaCarros = new ArrayList<>();
            while(rs.next()){
                Carros car = new Carros();
                car.setId(rs.getInt("idcarro"));
                car.setMarca(rs.getString("marca"));
                car.setModelo(rs.getString("modelo"));
                car.setCor(rs.getString("cor"));
                car.setAno(rs.getInt("ano"));
                listaCarros.add(car);
            }
            return listaCarros;
            
        } catch (SQLException ex) {
            Logger.getLogger(CarrosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
