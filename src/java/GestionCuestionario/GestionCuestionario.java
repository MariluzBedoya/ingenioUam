/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCuestionario;

import entidades.Cuestionario;
import entidades.Glosario;
import entidades.Pregunta;
import entidades.Respuesta;
import entidades.TipoPregunta;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.swing.JOptionPane;
import jsf.CuestionarioController;

/**
 *
 * @author mariluz
 */
public class GestionCuestionario {

    // private session.PreguntaFacade ejbCuestionarioFacade;
    private session.GlosarioFacade ejbGlosarioFacade;
    private session.PreguntaFacade ejbPreguntaFacade;
    private session.RespuestaFacade ejbRespuestaFacade;
    private Cuestionario selected;
    private Respuesta respuesta;
    private TipoPregunta tipoPregunta;
    private static int TIPO_PREGUNTA_ABIERTA = 3;

    public GestionCuestionario(Cuestionario selected, session.GlosarioFacade ejbGlosarioFacade, session.PreguntaFacade ejbPreguntaFacade) {
        this.ejbGlosarioFacade = this.ejbGlosarioFacade;
        this.ejbPreguntaFacade = this.ejbPreguntaFacade;
        this.selected = this.selected;

    }

//    public void crearPreguntaAbierta() {
////        List<Glosario> glosarios = consultaGT();
////        ArrayList<Integer> arreglo = new ArrayList<>();
////        
////        System.out.println("gosarios "+ glosarios.size());
////        //JOptionPane.showMessageDialog(glosarios.size(), this);
////        if (selected.getCantPregAb() < glosarios.size()) {
////            System.out.println("Debe contestar la pregunta a la cual se esta referiendo los siguientes enunciados");
////            for (int i = 0; i < selected.getCantPregAb(); i++) {
////                Random rm = new Random();
////                Integer numeroRm = (int) (rm.nextDouble() * (selected.getCantPregAb()) +2);
////              //  if (!arreglo.contains(numeroRm)) {
////                //    arreglo.add(numeroRm);
////                    Glosario glosario = (Glosario)ejbGlosarioFacade.buscarGlosarioPorId(numeroRm);
////                    tipoPregunta=new TipoPregunta(TIPO_PREGUNTA_ABIERTA);
////                    Pregunta pregunta = new Pregunta(glosario.getDescripcion(), tipoPregunta, selected);
////                    ejbPreguntaFacade.create(pregunta);
////                   
////                    
////                    
////                    Respuesta respuesta= new Respuesta(glosario.getPalabra(), 1, pregunta);
////                    ejbRespuestaFacade.create(respuesta);
////                    
////
////                //}
////            }
////        }
//        tipoPregunta = new TipoPregunta(TIPO_PREGUNTA_ABIERTA);
//        
//        Pregunta pregunta = new Pregunta("", tipoPregunta, selected);
//         ejbPreguntaFacade.create(pregunta);
//    }

    public List consultaGT() {
        List<Glosario> glosarios = ejbGlosarioFacade.buscarGlosarioPorTema(selected.getIdTema().getId());

        for (Glosario glosario : glosarios) {
            System.out.println("GLO:" + glosario.getDescripcion());
        }
        return glosarios;
    }

}
