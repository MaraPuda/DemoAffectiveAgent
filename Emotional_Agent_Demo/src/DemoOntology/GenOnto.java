/*
Ontology necessary for JADE agents.
 */
package DemoOntology;

import jade.content.onto.*;
import jade.content.schema.*;

/**
 *
 * @author Mara Pudane
 */
public class GenOnto extends Ontology{
    public static final String ONTOLOGY_NAME = "DemoOntology";
    public static final String PRIMITIVE = "PrimitiveEmo";
    public static final String REEVAL = "ReEval";
    public static final String EMOTIONTYPE = "Emotion";
    public static final String FRIENDVALUE = "Friends";
    public static final String STATUSVALUE = "Status"; 
    public static final String MESSAGE = "GUIMessage";
    public static final String MESSTYPE = "Type";
    private static Ontology theInstance = new GenOnto();
    
    public static Ontology getInstance()
    {
        return theInstance;
    }
    
    private GenOnto()
    {
    super(ONTOLOGY_NAME, BasicOntology.getInstance());
    
    
        try {
           
            add(new PredicateSchema (MESSAGE), GUIMessage.class);
            
            PredicateSchema ms = (PredicateSchema) getSchema(MESSAGE);
            
            ms.add(PRIMITIVE, (PrimitiveSchema) getSchema(BasicOntology.FLOAT));
            ms.add(REEVAL,    (PrimitiveSchema) getSchema(BasicOntology.FLOAT));
            ms.add(EMOTIONTYPE, (PrimitiveSchema) getSchema(BasicOntology.STRING));
            ms.add(FRIENDVALUE, (PrimitiveSchema) getSchema(BasicOntology.FLOAT));
            ms.add(STATUSVALUE, (PrimitiveSchema) getSchema(BasicOntology.FLOAT));
            ms.add(MESSTYPE, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
        } 
        catch (OntologyException ex) {
           ex.printStackTrace();
        }
    
    }
    
    
    
}
