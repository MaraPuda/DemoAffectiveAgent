/*
GUI agent
 */
package emotional_agent_demo;

import jade.content.ContentElementList;

import jade.content.lang.Codec;

import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mara Pudane
 */
public class GUIAgentDemo extends GuiAgent {

    transient protected emotional_agent_demo.DemoInterface myGui;
    private Ontology ontology;
    private Codec codec;
  

    protected void setup() //inicializaacija
    {
        codec = new SLCodec();
        ontology = DemoOntology.GenOnto.getInstance();
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontology);
        emotional_agent_demo.DemoInterface gui = new emotional_agent_demo.DemoInterface(this);
        gui.setVisible(true);
        System.out.print("GUI agent here!");

    }

    @Override
    protected void onGuiEvent(GuiEvent ge) {
        switch (ge.getType()) {
            case 0: //primitive irritation received  
                
                double strength = (double) ge.getParameter(0);

                ACLMessage c = new ACLMessage(ACLMessage.INFORM);
                c.setLanguage(codec.getName());
                c.setOntology(ontology.getName());
                ContentElementList cel = new ContentElementList();

                DemoOntology.GUIMessage gm = new DemoOntology.GUIMessage();

                gm.setPrimitiveEmo(strength);
                gm.setEmotion("dummy");
                gm.setType(1);
                cel.add(gm);
               

                try {

                    getContentManager().fillContent(c, cel);

                } catch (Codec.CodecException | OntologyException ex) {
                    Logger.getLogger(GUIAgentDemo.class.getName()).log(Level.SEVERE, null, ex);
                }

                c.addReceiver(new AID("DemoAgent", AID.ISLOCALNAME));
                send(c);
                break;

                
            case 1: //repeated evaluation received and emotion received
                double reevaluated = (double) ge.getParameter(0);
                String emo = (String)ge.getParameter(1);

                ACLMessage c1 = new ACLMessage(ACLMessage.INFORM);
                c1.setLanguage(codec.getName());
                c1.setOntology(ontology.getName());
                ContentElementList cel1 = new ContentElementList();

                DemoOntology.GUIMessage gm1 = new DemoOntology.GUIMessage();

                gm1.setReEval(reevaluated);
                gm1.setEmotion(emo);
                gm1.setType(2);
                cel1.add(gm1);
                

                try {

                    getContentManager().fillContent(c1, cel1);

                } catch (Codec.CodecException | OntologyException ex) {
                    Logger.getLogger(GUIAgentDemo.class.getName()).log(Level.SEVERE, null, ex);
                }

                c1.addReceiver(new AID("DemoAgent", AID.ISLOCALNAME));
                send(c1);
                break;
             
            case 2://Status and friendship value received
                double impact = (double) ge.getParameter(0);
                double relationship = (double) ge.getParameter(1);
                double status = (double) ge.getParameter(2);
                String emo3 = (String)ge.getParameter(3);

                ACLMessage c2 = new ACLMessage(ACLMessage.INFORM);
                c2.setLanguage(codec.getName());
                c2.setOntology(ontology.getName());
                ContentElementList cel2 = new ContentElementList();

                DemoOntology.GUIMessage gm2 = new DemoOntology.GUIMessage();

                gm2.setReEval(impact);
                gm2.setEmotion(emo3);
                gm2.setFriends(relationship);
                gm2.setStatus(status);
                gm2.setType(3);
                cel2.add(gm2);
                

                try {

                    getContentManager().fillContent(c2, cel2);

                } catch (Codec.CodecException | OntologyException ex) {
                    Logger.getLogger(GUIAgentDemo.class.getName()).log(Level.SEVERE, null, ex);
                }

                c2.addReceiver(new AID("DemoAgent", AID.ISLOCALNAME));
                send(c2);
                break;

//To change body of generated methods, choose Tools | Templates.
        }

    }

}
