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
import model.Alumno;
import model.Curso;
import session.AlumnoFacadeLocal;
import session.CursoFacadeLocal;


/**
 *
 * @author manuel
 */
@Named(value = "aController")
@SessionScoped
public class alumnoController implements Serializable {

    @EJB
    private AlumnoFacadeLocal alumnoFacade;

    @EJB
    private CursoFacadeLocal cursoFacade;
    
    private Curso c= new Curso();
    private Alumno a = new Alumno();

    public Curso getC() {
        return c;
    }

    public void setC(Curso c) {
        this.c = c;
    }

    public Alumno getA() {
        return a;
    }

    public void setA(Alumno a) {
        this.a = a;
    }

    
    /**
     * Creates a new instance of cursoController
     */
    public alumnoController() {
    }
    
    public List<Alumno> listar(){
        return this.alumnoFacade.findAll();
    }
    
    public String agregar(){
        try{
        this.a.setCodigoCurso(c);
            System.out.println(a.getCodigoCurso());
        this.alumnoFacade.create(this.a);
        this.a = new Alumno();
        this.c = new Curso();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return "listdos";
    }
    
    public void delete(Alumno al){
        this.alumnoFacade.remove(al);
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
