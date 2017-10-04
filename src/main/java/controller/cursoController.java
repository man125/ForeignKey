/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import model.Curso;
import session.CursoFacadeLocal;


/**
 *
 * @author manuel
 */
@Named(value = "cursoController")
@SessionScoped
public class cursoController implements Serializable {

    @EJB
    private CursoFacadeLocal cursoFacade;
    private Curso c= new Curso();

    public Curso getC() {
        return c;
    }

    public void setC(Curso c) {
        this.c = c;
    }
    

    /**
     * Creates a new instance of cursoController
     */
    public cursoController() {
    }
    
    public List<Curso> listar(){
        return this.cursoFacade.findAll();
    }
    
    public String agregar(){
        this.cursoFacade.create(this.c);
        this.c = new Curso();
        return "list";
    }
    
    public void delete(Curso cur){
        this.cursoFacade.remove(cur);
    }
    
    public String modify(){
        this.cursoFacade.edit(this.c);
         this.c = new Curso();
        return "list";
    }
    
    public String edit(Curso cur){
        this.c = cur;
        return "edit";
    }
    
}
