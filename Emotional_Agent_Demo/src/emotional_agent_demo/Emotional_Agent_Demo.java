/*
Class that runs the multiagent system
 */
package emotional_agent_demo;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Mara Pudane
 */
public class Emotional_Agent_Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      RunJade r=new RunJade(false,"30000");
      ContainerController home = r.getHome();
          TimeSync.sTime();
      try {
        
            AgentController ac = RunJade.home.createNewAgent("RMAAgent", "jade.tools.rma.rma", new Object[0]);

            ac.start();
            startAgent(1, "DemoAgent");
            
             AgentController b = RunJade.home.createNewAgent("GUI", "emotional_agent_demo.GUIAgentDemo", args);
             b.start();
             
        } catch (Exception e) {
            e.printStackTrace();
    }
    }
    
    public static void startAgent(int number, String name) {

        try {

            Object[] args = new Object[9];
            Control c = new Control(false, true);
            EmotionVector[] ev = {new EmotionVector('a', 0.0, false, 0.0), new EmotionVector('d', 0.0, false, 0.0), new EmotionVector('f', 0.0, false, 0.0), new EmotionVector('j', 0.0, false, 0.0), new EmotionVector('s', 0.0, false, 0.0)};
            Personality p = new Personality(0, 0, 0.5, 0, 0.5);
            args[2] = (Object) p;
            args[3] = new Incoming(false, 0.0, 0.0, ' ', false);
            PAD m = new PAD(p.pers.P, p.pers.A, p.pers.D);
            PAD cu = new PAD(p.pers.P, p.pers.A, p.pers.D);
            PAD pm = new PAD(p.pers.P, p.pers.A, p.pers.D);
        
            args[5] = startBelDesInt(name);
           



            CurrentStateDescription csd = new CurrentStateDescription(m, cu, pm, 0, ev);

            args[0] = c;


            args[4] = csd;
            List<SocialBelief> sb  = new ArrayList<>();
            SocBelDesInt sbdi = new SocBelDesInt(sb,0,false);
            args[7] = sbdi;
            AgentController b = RunJade.home.createNewAgent(name, "emotional_agent_demo.EmotionalAgent", args);
           b.start();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static BelDesInt startBelDesInt(String Name) {

        String[] PlayerArray = {"Ana", "Alex", "Gita", "Greg", "Robert", "Maria"};
        Belief b = new Belief("a", 0);
        List<Belief> bels = new ArrayList();
        for (int i = 0; i < PlayerArray.length; i++) {
            if (!PlayerArray[i].equals(Name)) {
                b = new Belief(PlayerArray[i], 7);
                bels.add(b);

            }

        }
        BelDesInt BDI = new BelDesInt(bels, 0, true);

        return BDI;
    }

}
