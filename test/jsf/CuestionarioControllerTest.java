/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import entidades.Cuestionario;
import entidades.Pregunta;
import entidades.Respuesta;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mariluz
 */
public class CuestionarioControllerTest {
    
    public CuestionarioControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSelected method, of class CuestionarioController.
     */
    @Test
    public void testGetSelected() {
    
        CuestionarioController instance = new CuestionarioController();
        Cuestionario expResult = null;
        Cuestionario result = instance.getSelected();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setSelected method, of class CuestionarioController.
     */
    @Test
    public void testSetSelected() {
      
        Cuestionario selected = null;
        CuestionarioController instance = new CuestionarioController();
        instance.setSelected(selected);

       
    }

    /**
     * Test of setEmbeddableKeys method, of class CuestionarioController.
     */
    @Test
    public void testSetEmbeddableKeys() {
      
        CuestionarioController instance = new CuestionarioController();
        instance.setEmbeddableKeys();
  
    }

    /**
     * Test of initializeEmbeddableKey method, of class CuestionarioController.
     */
    @Test
    public void testInitializeEmbeddableKey() {
        
        CuestionarioController instance = new CuestionarioController();
        instance.initializeEmbeddableKey();
    
    }

    /**
     * Test of prepareCreate method, of class CuestionarioController.
     */
    @Test
    public void testPrepareCreate() {
   
        CuestionarioController instance = new CuestionarioController();
        Cuestionario expResult = null;
        Cuestionario result = instance.prepareCreate();
        assertEquals(expResult, result);

    }

    /**
     * Test of crearPreguntas method, of class CuestionarioController.
     */
    @Test
    public void testCrearPreguntas() {
        
        CuestionarioController instance = new CuestionarioController();
        instance.crearPreguntas();
     
    }

    /**
     * Test of crearPreguntaAbierta method, of class CuestionarioController.
     */
    @Test
    public void testCrearPreguntaAbierta() {

        CuestionarioController instance = new CuestionarioController();
        instance.crearPreguntaAbierta();
    
       
    }

    /**
     * Test of crearPreguntaFV method, of class CuestionarioController.
     */
    @Test
    public void testCrearPreguntaFV() {
 
        CuestionarioController instance = new CuestionarioController();
        instance.crearPreguntaFV();

    }

    /**
     * Test of crearPreguntaSM method, of class CuestionarioController.
     */
    @Test
    public void testCrearPreguntaSM() {
        
        CuestionarioController instance = new CuestionarioController();
        instance.crearPreguntaSM();

    }

    /**
     * Test of generarRandomSM method, of class CuestionarioController.
     */
    @Test
    public void testGenerarRandomSM() {
    
        int enunciado = 0;
        CuestionarioController instance = new CuestionarioController();
        ArrayList expResult = null;
        ArrayList result = instance.generarRandomSM(enunciado);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of consultaGT method, of class CuestionarioController.
     */
    @Test
    public void testConsultaGT() {
    
        CuestionarioController instance = new CuestionarioController();
        List expResult = null;
        List result = instance.consultaGT();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of create method, of class CuestionarioController.
     */
    @Test
    public void testCreate() {
      
        CuestionarioController instance = new CuestionarioController();
        instance.create();

    }

    /**
     * Test of update method, of class CuestionarioController.
     */
    @Test
    public void testUpdate() {
       
        CuestionarioController instance = new CuestionarioController();
        instance.update();

    }

    /**
     * Test of destroy method, of class CuestionarioController.
     */
    @Test
    public void testDestroy() {
      
        CuestionarioController instance = new CuestionarioController();
        instance.destroy();

    }

    /**
     * Test of getItems method, of class CuestionarioController.
     */
    @Test
    public void testGetItems() {
     
        CuestionarioController instance = new CuestionarioController();
        List<Cuestionario> expResult = null;
        List<Cuestionario> result = instance.getItems();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of imprimirEntrada method, of class CuestionarioController.
     */
    @Test
    public void testImprimirEntrada() {
 
        CuestionarioController instance = new CuestionarioController();
        instance.imprimirEntrada();

    }

    /**
     * Test of getPreguntas2 method, of class CuestionarioController.
     */
    @Test
    public void testGetPreguntas2() {
      
        CuestionarioController instance = new CuestionarioController();
        List<Pregunta> expResult = null;
        List<Pregunta> result = instance.getPreguntas2();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of getPreguntas1 method, of class CuestionarioController.
     */
    @Test
    public void testGetPreguntas1() {
        
        CuestionarioController instance = new CuestionarioController();
        List<Pregunta> expResult = null;
        List<Pregunta> result = instance.getPreguntas1();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of getPreguntas method, of class CuestionarioController.
     */
    @Test
    public void testGetPreguntas() {
      
        CuestionarioController instance = new CuestionarioController();
        List<Pregunta> expResult = null;
        List<Pregunta> result = instance.getPreguntas();
        assertEquals(expResult, result);
    
    }

    /**
     * Test of getRespuestas method, of class CuestionarioController.
     */
    @Test
    public void testGetRespuestas() {
      
        CuestionarioController instance = new CuestionarioController();
        List<Respuesta> expResult = null;
        List<Respuesta> result = instance.getRespuestas();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCuestionario method, of class CuestionarioController.
     */
    @Test
    public void testGetCuestionario() {
    
        Integer id = null;
        CuestionarioController instance = new CuestionarioController();
        Cuestionario expResult = null;
        Cuestionario result = instance.getCuestionario(id);
        assertEquals(expResult, result);
  
    }

    /**
     * Test of getItemsAvailableSelectMany method, of class CuestionarioController.
     */
    @Test
    public void testGetItemsAvailableSelectMany() {
      
        CuestionarioController instance = new CuestionarioController();
        List<Cuestionario> expResult = null;
        List<Cuestionario> result = instance.getItemsAvailableSelectMany();
        assertEquals(expResult, result);

    }

    /**
     * Test of getItemsAvailableSelectOne method, of class CuestionarioController.
     */
    @Test
    public void testGetItemsAvailableSelectOne() {
    
        CuestionarioController instance = new CuestionarioController();
        List<Cuestionario> expResult = null;
        List<Cuestionario> result = instance.getItemsAvailableSelectOne();
        assertEquals(expResult, result);
     
    }
    
}
