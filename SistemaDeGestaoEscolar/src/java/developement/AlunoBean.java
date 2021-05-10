/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package developement;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
/**
 *
 * @author miguel
 */
public class AlunoBean {
    private Aluno  objAluno = new Aluno();
    private List<Aluno> listaalunos = new ArrayList<>();
    private Dao objAlunosDAO = new Dao();
    
    public void listar(){
        listaalunos = objAlunosDAO.listar();
    }
    
    public void adicionar(){
        objAlunosDAO.salvar(objAluno);
        objAluno = new Aluno();
        listar();
    }
 
    public void editar(){
        objAlunosDAO.editar(objAluno);
        objAluno = new Aluno();
        listar();
    }
    
    public void excluir(){
        objAlunosDAO.excluir(objAluno.getCodigo());
        objAluno = new Aluno();
        listar();
    }
    
    public void limpar(){
        objAluno = new Aluno();
    }
    
    public void selecionar(Aluno c){
        objAluno = c;
    }

    public Aluno getObjAluno() {
        return objAluno;
    }

    public void setObjAluno(Aluno objAluno) {
        this.objAluno = objAluno;
    }

    public List<Aluno> getListaalunos() {
        return listaalunos;
    }

    public void setListaalunos(List<Aluno> listaalunos) {
        this.listaalunos = listaalunos;
    }

    public Dao getObjAlunosDAO() {
        return objAlunosDAO;
    }

    public void setObjAlunosDAO(Dao objAlunosDAO) {
        this.objAlunosDAO = objAlunosDAO;
    }

   
    
}
