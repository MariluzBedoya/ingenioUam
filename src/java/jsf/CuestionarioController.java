package jsf;

import GestionCuestionario.GestionCuestionario;
import entidades.Cuestionario;
import entidades.Glosario;
import entidades.Pregunta;
import entidades.Respuesta;
import entidades.TipoPregunta;
import jsf.util.JsfUtil;
import jsf.util.JsfUtil.PersistAction;
import session.CuestionarioFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("cuestionarioController")
@SessionScoped
public class CuestionarioController implements Serializable {

    @EJB
    private session.CuestionarioFacade ejbFacade;
    @EJB
    private session.GlosarioFacade ejbGlosarioFacade;
    @EJB
    private session.PreguntaFacade ejbPreguntaFacade;

    @EJB
    private session.RespuestaFacade ejbRespuestaFacade;

    private final int TIPO_PREGUNTA_ABIERTA = 3;
    private final int TIPO_PREGUNTA_FALSO_VERDADERO = 1;
    private final int TIPO_PREGUNTA_SELECCION_MULTIPLE = 2;
    private Respuesta respuesta;
    private TipoPregunta tipoPregunta;

    private List<Cuestionario> items = null;
    private List<Pregunta> preguntasSM = new ArrayList<>();
    private List<Pregunta> preguntas1 = new ArrayList<>();
    private List<Pregunta> preguntas2 = new ArrayList<>();
    private List<Respuesta> respuestas = null;
    private List<Respuesta> respuestasTodas = null;
    private Cuestionario selected;

    public CuestionarioController() {
    }

    public Cuestionario getSelected() {
        return selected;
    }

    public void setSelected(Cuestionario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CuestionarioFacade getFacade() {
        return ejbFacade;
    }

    public Cuestionario prepareCreate() {
        selected = new Cuestionario();
        initializeEmbeddableKey();
        return selected;
    }

    public void crearPreguntas() {

        crearPreguntaSM();
        crearPreguntaFV();

        crearPreguntaAbierta();

    }

    public void crearPreguntaAbierta() {
        List<Glosario> glosarios = consultaGT();
        ArrayList<Integer> arreglo = new ArrayList<>();


        if (selected.getCantPregAb() < glosarios.size()) {
              for (int i = 0; i < selected.getCantPregAb(); i++) {
                Random rm = new Random();
                Integer numeroRm = (int) (rm.nextDouble() * (selected.getCantPregAb()) + 2);

                List<Glosario> glosarioTema = ejbGlosarioFacade.buscarGlosarioPorTema(selected.getIdTema().getId());
                ArrayList<Integer> idGlosarioTema = new ArrayList<>();

                for (int j = 0; j < glosarioTema.size(); j++) {
                    idGlosarioTema.add(glosarioTema.get(j).getId());

                }

                if (!arreglo.contains(numeroRm)) {
                    arreglo.add(numeroRm);
                    Glosario glosario = (Glosario) ejbGlosarioFacade.buscarGlosarioPorId(idGlosarioTema.get(numeroRm));
                    tipoPregunta = null;
                    tipoPregunta = new TipoPregunta(TIPO_PREGUNTA_ABIERTA);
                    Pregunta pregunta = new Pregunta(glosario.getDescripcion(), tipoPregunta, selected, selected.getIdTema());
                    ejbPreguntaFacade.create(pregunta);

                    Respuesta respuesta = new Respuesta(glosario.getPalabra(), 1, pregunta);
                    ejbRespuestaFacade.create(respuesta);

                } else {
                    i--;
                }
            }
        }
//imprimirEntrada();
    }

    public void crearPreguntaFV() {
        List<Glosario> glosarios = consultaGT();
        ArrayList<Integer> arreglo = new ArrayList<>();
        if (selected.getCantPregFv() < glosarios.size()) {
            for (int i = 0; i < selected.getCantPregFv(); i++) {

                Random rm = new Random();
                Integer enunciado = (int) (rm.nextDouble() * (selected.getCantPregFv()) + 2);
                Random rm1 = new Random();
                Integer palabra = (int) (rm1.nextDouble() * (selected.getCantPregFv()) + 2);

                List<Glosario> glosarioTema = ejbGlosarioFacade.buscarGlosarioPorTema(selected.getIdTema().getId());
                ArrayList<Integer> idGlosarioTema = new ArrayList<>();

                for (int j = 0; j < glosarioTema.size(); j++) {
                    idGlosarioTema.add(glosarioTema.get(j).getId());

                }
                if (!arreglo.contains(enunciado)) {
                    arreglo.add(enunciado);

                    Glosario glosario = (Glosario) ejbGlosarioFacade.buscarGlosarioPorId(idGlosarioTema.get(enunciado));
                    Glosario glosario1 = (Glosario) ejbGlosarioFacade.buscarGlosarioPorId(idGlosarioTema.get(palabra));

                    tipoPregunta = null;
                    tipoPregunta = new TipoPregunta(TIPO_PREGUNTA_FALSO_VERDADERO);

                    Pregunta pregunta = new Pregunta(glosario1.getPalabra() + " es: " + glosario.getDescripcion(), tipoPregunta, selected, selected.getIdTema());
                    ejbPreguntaFacade.create(pregunta);

                    Respuesta respuesta = new Respuesta(glosario.getPalabra(), 1, pregunta);
                    ejbRespuestaFacade.create(respuesta);

                } else {
                    i--;
                }
            }
        }
        //crearPreguntaSM();

    }

    public void crearPreguntaSM() {
        List<Glosario> glosarios = consultaGT();
        ArrayList<Integer> arreglo = new ArrayList<>();
        ArrayList<Integer> arreglo2 = new ArrayList<>();
        if (selected.getCantPregSm() < glosarios.size()) {
            List<Glosario> glosarioTema = ejbGlosarioFacade.buscarGlosarioPorTema(selected.getIdTema().getId());
            for (int i = 0; i < selected.getCantPregSm(); i++) {

                ArrayList<Integer> idGlosarioTema = new ArrayList<>();
                for (int j = 0; j < glosarioTema.size(); j++) {
                    idGlosarioTema.add(glosarioTema.get(j).getId());

                }
                Random rm = new Random();
                Integer enunciado = (int) (rm.nextDouble() * (selected.getCantPregSm()) + 2);

                ArrayList<Integer> opciones = generarRandomSM(enunciado);

//              
                if (!arreglo.contains(enunciado)) {
                    arreglo.add(enunciado);

                    Glosario glosario = (Glosario) ejbGlosarioFacade.buscarGlosarioPorId(idGlosarioTema.get(enunciado));
                    Glosario glosario1 = (Glosario) ejbGlosarioFacade.buscarGlosarioPorId(idGlosarioTema.get(opciones.get(0)));
                    Glosario glosario2 = (Glosario) ejbGlosarioFacade.buscarGlosarioPorId(idGlosarioTema.get(opciones.get(1)));
                    Glosario glosario3 = (Glosario) ejbGlosarioFacade.buscarGlosarioPorId(idGlosarioTema.get(opciones.get(2)));

                    tipoPregunta = null;
                    tipoPregunta = new TipoPregunta(TIPO_PREGUNTA_SELECCION_MULTIPLE);

                    Pregunta pregunta = new Pregunta(glosario.getDescripcion(), tipoPregunta, selected, selected.getIdTema());
                    ejbPreguntaFacade.create(pregunta);

                    Respuesta resp = new Respuesta(glosario.getPalabra(), 1, pregunta);
                    ejbRespuestaFacade.create(resp);

                    Respuesta resp1 = new Respuesta(glosario1.getPalabra(), 0, pregunta);
                    ejbRespuestaFacade.create(resp1);

                    Respuesta resp2 = new Respuesta(glosario2.getPalabra(), 0, pregunta);
                    ejbRespuestaFacade.create(resp2);

                    Respuesta resp3 = new Respuesta(glosario3.getPalabra(), 0, pregunta);
                    ejbRespuestaFacade.create(resp3);

                } else {
                    i--;
                }
            }
        }
        //crearPreguntaAbierta();

    }

    public ArrayList generarRandomSM(int enunciado) {

        ArrayList<Integer> random = new ArrayList<>();

        while (random.size() != 3) {
            Random rm = new Random();
            Integer opcion = (int) (rm.nextDouble() * (selected.getCantPregSm()) + 2);
            if (opcion != enunciado && !random.contains(opcion)) {
                random.add(opcion);
            }
        }
        return random;

    }

    public List consultaGT() {
        List<Glosario> glosarios = ejbGlosarioFacade.buscarGlosarioPorTema(selected.getIdTema().getId());

        for (Glosario glosario : glosarios) {
            System.out.println("GLO:" + glosario.getDescripcion());
        }
        return glosarios;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CuestionarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }

    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CuestionarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CuestionarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Cuestionario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public void imprimirEntrada() {
   
        preguntasSM = new ArrayList<>();
        preguntasSM = ejbPreguntaFacade.buscarPreguntaPorTemaCuestionario(selected.getIdTema().getId(), selected.getId(), 2);

        preguntas1 = ejbPreguntaFacade.buscarPreguntaPorTemaCuestionario(selected.getIdTema().getId(), selected.getId(), 1);
        preguntas2 = ejbPreguntaFacade.buscarPreguntaPorTemaCuestionario(selected.getIdTema().getId(), selected.getId(), 3);

        respuestas = new ArrayList<>();

        for (int i = 0; i < preguntasSM.size(); i++) {

            respuestas = ejbRespuestaFacade.buscarRespuestaPorIdPregunta(preguntasSM.get(i).getId());
     
        }

        
    }

    public List<Pregunta> getPreguntas2() {
        return preguntas2;
    }

    public List<Pregunta> getPreguntas1() {
        return preguntas1;
    }

    public List<Pregunta> getPreguntas() {

        return preguntasSM;
    }

    public List<Respuesta> getRespuestas() {

        return respuestas;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Cuestionario getCuestionario(java.lang.Integer id) {
        // consultaGT();
        return getFacade().find(id);
    }

    public List<Cuestionario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Cuestionario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Cuestionario.class)
    public static class CuestionarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CuestionarioController controller = (CuestionarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cuestionarioController");
            return controller.getCuestionario(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Cuestionario) {
                Cuestionario o = (Cuestionario) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cuestionario.class.getName()});
                return null;
            }
        }

    }

}
