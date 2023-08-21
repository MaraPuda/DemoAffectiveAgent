/*
 MAIN class that implements the affective agent.
 */
package emotional_agent_demo;


import jade.content.ContentElement;
import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mara Pudane
 */
public class EmotionalAgent extends Agent {

    public ArrayList EmotionL1PAD;
    public ArrayList MoodPAD;
    public ArrayList EmotionL2PAD;
    public ArrayList EmotionL3PAD;
    private Codec codec = new SLCodec();
    private Ontology ontology = DemoOntology.GenOnto.getInstance();

    protected void setup() //inicializaacija
    {
        Object args[] = getArguments();
        System.out.println(getLocalName() + " is in da house.");

        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontology);

        Personality p = (Personality) args[2];
        CurrentStateDescription csd = (CurrentStateDescription) args[4];
        csd.mood = p.pers;
        args[4] = csd;
        this.addBehaviour(new InterpretInput());
        this.addBehaviour(new EmotionCycle(this, 1000));
        this.EmotionL1PAD = new ArrayList();
        this.EmotionL2PAD = new ArrayList();
        this.EmotionL3PAD = new ArrayList();
        this.MoodPAD = new ArrayList();
        addPADL1Intensity(p.pers);
        addPADL2Intensity(p.pers);
        addPADMoodIntensity(p.pers);

        this.setArguments(args);

    }

    protected void takeDown() {
        
        // IF OUTPUT NECESSARY THE CODE BELOW CAN BE USED
     /*   try {
            PrintWriter writer = new PrintWriter("..." + getLocalName() + "_emotionL1PAD.csv", "UTF-8");
            outputListElement ole;

            for (int i = 0; i < EmotionL1PAD.toArray().length; i++) {
                double writeP = 0.0;
                double writeA = 0.0;
                double writeD = 0.0;
                int t;

                ole = (outputListElement) EmotionL1PAD.get(i);
                if (ole != null) {
                    writeP = ole.P;
                    writeA = ole.A;
                    writeD = ole.D;
                    t = TimeSync.getDifference(ole.t);

                    writer.println(this.getLocalName() + "," + writeP + "," + writeA + "," + writeD + "," + "t=" + t);
                }
            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PrintWriter writer = new PrintWriter("..." + getLocalName() + "_moodPAD.csv", "UTF-8");
            outputListElement ole;

            for (int i = 0; i < MoodPAD.toArray().length; i++) {
                double writeP = 0.0;
                double writeA = 0.0;
                double writeD = 0.0;
                int t;

                ole = (outputListElement) MoodPAD.get(i);

                if (ole != null) {
                    writeP = ole.P;
                    writeA = ole.A;
                    writeD = ole.D;

                    t = TimeSync.getDifference(ole.t);
                    writer.println(this.getLocalName() + "," + writeP + "," + writeA + "," + writeD + "," + t);
                }
            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PrintWriter writer = new PrintWriter("..." + getLocalName() + "_corePAD.csv", "UTF-8");
            Object args[] = this.getArguments();
            Personality p = (Personality) args[2];




            writer.println(this.getLocalName() + "," + p.pers.P + "," + p.pers.A + "," + p.pers.D);



            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PrintWriter writer = new PrintWriter("..." + getLocalName() + "_emotionL2PAD.csv", "UTF-8");
            outputListElement ole;

            for (int i = 0; i < EmotionL2PAD.toArray().length; i++) {
                double writeP = 0.0;
                double writeA = 0.0;
                double writeD = 0.0;
                int t;
                ole = (outputListElement) EmotionL2PAD.get(i);

                if (ole != null) {
                    writeP = ole.P;
                    writeA = ole.A;
                    writeD = ole.D;
                    t = TimeSync.getDifference(ole.t);


                    writer.println(this.getLocalName() + "," + writeP + "," + writeA + "," + writeD + "," + t);
                }
            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);

        }

        try {
            PrintWriter writer = new PrintWriter("..." + getLocalName() + "_emotionL3PAD.csv", "UTF-8");
            outputListElement ole;

            for (int i = 0; i < EmotionL3PAD.toArray().length; i++) {
                double writeP = 0.0;
                double writeA = 0.0;
                double writeD = 0.0;
                int t;
                ole = (outputListElement) EmotionL3PAD.get(i);

                if (ole != null) {
                    writeP = ole.P;
                    writeA = ole.A;
                    writeD = ole.D;
                    t = TimeSync.getDifference(ole.t);

                    writer.println(this.getLocalName() + "," + writeP + "," + writeA + "," + writeD + "," + t);
                }
            }

            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);

        }*/



    }

    private class InterpretInput extends CyclicBehaviour {

        @Override
        public void action() {
            ACLMessage msg = myAgent.receive();
            int mtype = 0;

            if (msg != null) {


                try {
                    ContentManager cm = myAgent.getContentManager();
                    ContentElement ce = (ContentElement) cm.extractContent(msg);
                    Object args[] = myAgent.getArguments();
                    DemoOntology.GUIMessage gm = (DemoOntology.GUIMessage) ce;
                    mtype = gm.getType();

                    Incoming n = (Incoming) args[3];
                    CurrentStateDescription csd = (CurrentStateDescription) args[4];
                    n.IsNew = false;
                    n.DemoEmotionType = ' ';
                    n.DemoStrength = 0.0;
                    n.SecondsSince = 0;

                    switch (mtype) {
                        case 1:

                            n.IsNew = true;
                            n.DemoStrength = gm.getPrimitiveEmo();
                            for (int i = 0; i < csd.emoVect.length; i++) {
                                csd.emoVect[i].Last = false;
                            }




                            System.out.println("Level one");
                            args[4] = csd;
                            args[3] = n;
                            myAgent.setArguments(args);
                            break;
                        case 2:
                            n.IsNew = true;
                            n.DemoStrength = gm.getReEval();
                            String s = gm.getEmotion();
                            n.DemoEmotionType = s.charAt(0);
                            System.out.println("Level two");
                            args[3] = n;
                            myAgent.setArguments(args);
                            break;
                        case 3:
                            SocBelDesInt sbdi = (SocBelDesInt) args[7];
                            n.IsNew = true;
                            n.DemoStrength = gm.getReEval();
                            String s1 = gm.getEmotion();
                            n.DemoEmotionType = s1.charAt(0);
                            n.DemoTertiary = true;
                            SocialBelief bsta = new SocialBelief("user", 11, gm.getStatus());
                            SocialBelief brel = new SocialBelief("user", 10, gm.getFriends());

                            sbdi.BeliefSet = SocBelDesInt.updateBeliefSet(sbdi.BeliefSet, bsta);
                            sbdi.BeliefSet = SocBelDesInt.updateBeliefSet(sbdi.BeliefSet, brel);

                            args[7] = sbdi;
                            args[3] = n;
                            myAgent.setArguments(args);
                            break;
                        case 4:
                            System.out.println("GOT YOUR YELL!!!");
                            break;
                    }




                } catch (Codec.CodecException | OntologyException ex) {
                    System.out.println(myAgent.getLocalName() + " " + msg.getContent() + " ");
                    Logger.getLogger(EmotionalAgent.class.getName()).log(Level.SEVERE, null, ex);

                }


                myAgent.addBehaviour(new PrimitiveReasoning());

            } else {


                block();
            }
        }
    }

    private class PrimitiveReasoning extends Behaviour {

        private boolean finished = false;

        public void action() {


            if (getCritical() == false) {

                Object[] args = myAgent.getArguments();
                CurrentStateDescription csd = (CurrentStateDescription) args[4];
                Incoming i = (Incoming) args[3];
                if (i.DemoEmotionType == ' ') {

                    PrimitiveEmotions b = new PrimitiveEmotions();
                    myAgent.addBehaviour(b);

                    do {
                    } while (b.done() == true);


                    showClosestEmotion(csd.currentState);

                    //the behaviours of this layer related to showing emotions

                } else {
                    myAgent.addBehaviour(new SecondaryReasoning());
                }

                finished = true;
            } else {
                block();
            }

        }

        @Override
        public boolean done() {

            return finished;
        }
    }

    private class PrimitiveEmotions extends Behaviour {

        private boolean finished = false;

        public void action() {
            if (getCritical() == false) {
                cycleOff();
                //System.out.println("Primitive emotions on!");


                double affect = primaryObjectiveEvaluation();
                calculateSubjectiveEmotion(affect); //ietver arī integrāciju PAD telpā un parametru iestatīšanu
                cycleOn();
                finished = true;



            } else {
                block();
            }
        }

        @Override
        public boolean done() {

            return finished;
        }
    }

    private class SecondaryReasoning extends Behaviour {

        private boolean finished = false;

        public void action() {

            if (getCritical() == false) {

                SecondaryEmotions b = new SecondaryEmotions();
                myAgent.addBehaviour(b);

                do {
                } while (b.done() == true);

                TertiaryReasoning b1 = new TertiaryReasoning();
                myAgent.addBehaviour(b1);

                finished = true;



                finished = true;
            } else {
                block();
            }
        }

        @Override
        public boolean done() {

            return finished;
        }
    }

    private class SecondaryEmotions extends Behaviour {

        private boolean finished = false;

        public void action() {

            if (getCritical() == false) {
                cycleOff();

                Object[] args = myAgent.getArguments();
                Incoming i = (Incoming) args[3];

                if (i.DemoTertiary == false) {
                    CurrentStateDescription csd = (CurrentStateDescription) args[4];
                    Personality p = (Personality) args[2];
                    double affect = secondaryObjectiveEvaluation();
                    double leftover;
                    char type = i.DemoEmotionType;
                    boolean isSame = isTheSame(csd.emoVect, type);
                    if (isSame == true) {
                        leftover = getCurrentSecondaryIntensityofEmotion(csd.emoVect, type);
                    } else {
                        leftover = 0;
                    }

                    double subjSecondaryEmotion = calculatesubjectiveSecondaryEmotion(affect, type, leftover, isSame);
                    csd.emoVect = nullOtherEmotions(csd.emoVect, type);
                    csd.emoVect = setNewValue(csd.emoVect, type, subjSecondaryEmotion + leftover);
                    csd.emoVect = setNewLast(csd.emoVect, type);
                    //i.DemoEmotionType = ' ';
                    i.DemoStrength = 0.0;
                    //i.IsNew = false;

                    csd.currentState = secondaryToPAD(subjSecondaryEmotion, type, csd.currentState, p.pers);

                    args[4] = csd;
                    myAgent.setArguments(args);
                }
                cycleOn();
                finished = true;

            } else {
                block();
            }
        }

        @Override
        public boolean done() {

            return finished;
        }

        private double calculatesubjectiveSecondaryEmotion(double iObj, char type, double leftover, boolean same) {
            Object[] args = myAgent.getArguments();
            Personality coreState = (Personality) args[2];
            CurrentStateDescription csd = (CurrentStateDescription) args[4];

            double N = coreState.N;
            double E = coreState.E;
            double maxY;
            double s;
            double x0;
            double DecN = 1.89444 * N - 0.06292;
            double DecSec = 15 + 20 * DecN;
            double lambda = -Math.log(0.01) / DecSec;
            double iExpr = 0;
            double iSubj = 0;

            switch (type) {

                case 'a':
                    double angON = 1.11485 * N + 0.07318;
                    double angTN = 0.95926 * N + 0.11563;
                    angTN = normalize(angTN);
                    angON = normalize(angON);
                    maxY = -0.7 * angTN + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((angTN / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, angTN, s, x0);
                        csd.emoVect[0].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;
                    } else {
                        iSubj = appraisal(iObj, angTN, s, x0);
                        csd.emoVect[0].SecLeft = Math.log(iSubj) / -lambda;
                    }

                    iExpr = expression(iSubj, angON, s, x0);
                    break;

                case 'd':
                    double disEX = 1.251748 * E - 0.1279;
                    double disAPR = 1.177632 * N + 0.104483;
                    disEX = normalize(disEX);
                    disAPR = normalize(disAPR);
                    maxY = -0.7 * disAPR + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((disAPR / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, disAPR, s, x0);
                        csd.emoVect[1].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;


                    } else {
                        iSubj = appraisal(iObj, disAPR, s, x0);
                        csd.emoVect[1].SecLeft = Math.log(iSubj) / -lambda;

                    }


                    iExpr = expression(iSubj, disEX, s, x0);

                    break;

                case 'f':
                    double feaAPR = 0.947368 * N + 0.161053;
                    double feaEX = 1.006993 * E - 0.02589;
                    feaAPR = normalize(feaAPR);
                    feaEX = normalize(feaEX);
                    maxY = -0.7 * feaAPR + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((feaAPR / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, feaAPR, s, x0);
                        csd.emoVect[2].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;

                    } else {
                        iSubj = appraisal(iObj, feaAPR, s, x0);
                        csd.emoVect[2].SecLeft = Math.log(iSubj) / -lambda;

                    }

                    iExpr = expression(iSubj, feaEX, s, x0);

                    break;
                case 'j':
                    double joyAPREX = 0.986 * E + 0.07036;
                    joyAPREX = normalize(joyAPREX);
                    maxY = -0.7 * joyAPREX + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((joyAPREX / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, joyAPREX, s, x0);
                        csd.emoVect[3].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;

                    } else {
                        iSubj = appraisal(iObj, joyAPREX, s, x0);
                        csd.emoVect[3].SecLeft = Math.log(iSubj) / -lambda;
                    }

                    iExpr = expression(iSubj, joyAPREX, s, x0);
                    break;

                case 's':
                    double sadEX = 1.006993 * E - 0.02589;
                    double sadAPR = 0.921053 * N + 0.24515;
                    sadAPR = normalize(sadAPR);
                    sadEX = normalize(sadEX);
                    maxY = -0.7 * sadAPR + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((sadAPR / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, sadAPR, s, x0);
                        csd.emoVect[4].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;


                    } else {
                        iSubj = appraisal(iObj, sadAPR, s, x0);
                        csd.emoVect[4].SecLeft = Math.log(iSubj) / -lambda;

                    }


                    iExpr = expression(iSubj, sadEX, s, x0);
                    break;
            }
            args[4] = csd;
            myAgent.setArguments(args);

            return iSubj;
        }

        private double getCurrentSecondaryIntensityofEmotion(EmotionVector[] ev, char type) {
            double current = 0;
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Type == type) {
                    current = ev[i].Value;
                }
            }

            return current;


        }

        private boolean isTheSame(EmotionVector[] ev, char type) {
            char temp = ' ';
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Last == true) {
                    temp = ev[i].Type;
                }
            }

            if (temp == type) {
                return true;
            } else {
                return false;
            }
        }

        private EmotionVector[] nullOtherEmotions(EmotionVector[] ev, char type) {
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Type != type) {
                    ev[i].Value = 0;
                    ev[i].SecLeft = 0;
                }
            }
            return ev;
        }

        private PAD secondaryToPAD(double iSubj, char type, PAD current, PAD core) {

            PAD maxEmotion = new PAD(0, 0, 0);
            double coreToMax;

            double newP, newA, newD;
            switch (type) {
                case 'a':
                    maxEmotion = new PAD(0.28, 0.86, 0.66);
                    break;
                case 'd':
                    maxEmotion = new PAD(0.2, 0.675, 0.555);
                    break;
                case 'f':
                    maxEmotion = new PAD(0.19, 0.91, 0.285);
                    break;
                case 'j':
                    maxEmotion = new PAD(0.905, 0.755, 0.73);
                    break;
                case 's':
                    maxEmotion = new PAD(0.14, 0.355, 0.295);
                    break;
            }
            int p = getProfile(maxEmotion);
            PAD ext = getExtreme(p);
            coreToMax = distance(maxEmotion, core);
            double scaled = coreToMax * iSubj;



            // double howfar = (distance(maxEmotion, current)*scaled)/coreToMax;

            if (ext.P == 0) {
                newP = current.P - Math.abs(maxEmotion.P - current.P) * scaled;
            } else {
                newP = current.P + Math.abs(maxEmotion.P - current.P) * scaled;
            }
            if (ext.A == 0) {
                newA = current.A - Math.abs(maxEmotion.A - current.A) * scaled;
            } else {
                newA = current.A + Math.abs(maxEmotion.A - current.A) * scaled;
            }
            if (ext.D == 0) {
                newD = current.D - Math.abs(maxEmotion.D - current.D) * scaled;
            } else {
                newD = current.D + Math.abs(maxEmotion.D - current.D) * scaled;
            }


            newP = normalize(newP);
            newA = normalize(newA);
            newD = normalize(newD);

            PAD newcurrent = new PAD(newP, newA, newD);
            addPADL2Intensity(newcurrent);
            return newcurrent;
        }

        private EmotionVector[] setNewValue(EmotionVector[] ev, char type, double value) {
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Type == type) {
                    ev[i].Value = value;
                }
            }
            return ev;
        }

        private EmotionVector[] setNewLast(EmotionVector[] ev, char type) {
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Type != type) {
                    ev[i].Last = false;
                } else {
                    ev[i].Last = true;
                }
            }
            return ev;
        }
    }

    private class TertiaryReasoning extends Behaviour {

        private boolean finished = false;

        public void action() {

            if (getCritical() == false) {
                TertiaryEmotions b = new TertiaryEmotions();
                myAgent.addBehaviour(b);

                do {
                } while (b.done() == true);

                finished = true;

                // System.out.println("Tertiary reasoning on!");

                finished = true;
            } else {
                block();
            }
        }

        @Override
        public boolean done() {

            return finished;
        }
    }

    private class TertiaryEmotions extends Behaviour {

        private boolean finished = false;

        public void action() {

            if (getCritical() == false) {
                cycleOff();


                Object[] args = myAgent.getArguments();
                Incoming i = (Incoming) args[3];
                SocBelDesInt sbdi = (SocBelDesInt) args[7];
                if (i.DemoTertiary == true) {
                    i.DemoTertiary = false;

                    CurrentStateDescription csd = (CurrentStateDescription) args[4];
                    Personality p = (Personality) args[2];

                    //double affect = TertiaryObjectiveEvaluation(); //te šādam vajadzētu būt, bet ne demo aģentā
                    double leftover;
                    char type = i.DemoEmotionType;

                    boolean imiSame = isTheSame(csd.emoVect, type);
                    double imileftover;
                    if (imiSame == true) {
                        imileftover = getCurrentIntensityofEmotion(csd.emoVect, type); //out of PAD space
                    } else {
                        imileftover = 0;
                    }
                    double imitationemo = calculatesubjectiveTertiaryEmotion(i.DemoStrength, type, imileftover, imiSame);
                    PAD imitationstate = tertiaryToPAD(i.DemoStrength, imitationemo, type, csd.currentState, p.pers);
                    addPADL2Intensity(imitationstate);


                    double rimpact = calculateRelationshipImpact(sbdi.BeliefSet, "user");
                    double simpact = calculateStatusImpact(sbdi.BeliefSet, "user");

                    double finalaffect = calculateObjectiveAffect(rimpact, simpact, i.DemoStrength);

                    boolean isSame = isTheSame(csd.emoVect, type);

                    if (isSame == true) {
                        leftover = getCurrentIntensityofEmotion(csd.emoVect, type); //out of PAD space
                    } else {
                        leftover = 0;
                    }

                    double subjTertiaryEmotion = calculatesubjectiveTertiaryEmotion(Math.abs(finalaffect), type, leftover, isSame);
                    System.out.println(i.DemoStrength + " " + rimpact + " " + simpact + " " + finalaffect);
                    csd.emoVect = nullOtherEmotions(csd.emoVect, type);
                    csd.emoVect = setNewValue(csd.emoVect, type, subjTertiaryEmotion + leftover);
                    csd.emoVect = setNewLast(csd.emoVect, type);
                    i.DemoStrength = 0.0;

                    csd.currentState = tertiaryToPAD(finalaffect, subjTertiaryEmotion, type, csd.currentState, p.pers);
                    addPADL3Intensity(csd.currentState);

                    args[4] = csd;
                    myAgent.setArguments(args);
                }
                cycleOn();
                finished = true;

            } else {
                block();
            }
        }

        @Override
        public boolean done() {

            return finished;
        }

        private boolean isTheSame(EmotionVector[] ev, char type) {
            char temp = ' ';
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Last == true) {
                    temp = ev[i].Type;
                }
            }

            if (temp == type) {
                return true;
            } else {
                return false;
            }
        }

        private double getCurrentIntensityofEmotion(EmotionVector[] ev, char type) {
            double current = 0;
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Type == type) {
                    current = ev[i].Value;
                }
            }

            return current;


        }

        private EmotionVector[] nullOtherEmotions(EmotionVector[] ev, char type) {
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Type != type) {
                    ev[i].Value = 0;
                    ev[i].SecLeft = 0;
                }
            }
            return ev;
        }

        private EmotionVector[] setNewValue(EmotionVector[] ev, char type, double value) {
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Type == type) {
                    ev[i].Value = value;
                }
            }
            return ev;
        }

        private EmotionVector[] setNewLast(EmotionVector[] ev, char type) {
            for (int i = 0; i < ev.length; i++) {
                if (ev[i].Type != type) {
                    ev[i].Last = false;
                } else {
                    ev[i].Last = true;
                }
            }
            return ev;
        }

        private double calculatesubjectiveTertiaryEmotion(double iObj, char type, double leftover, boolean same) {
            Object[] args = myAgent.getArguments();
            Personality coreState = (Personality) args[2];
            CurrentStateDescription csd = (CurrentStateDescription) args[4];

            double N = coreState.N;
            double E = coreState.E;
            double maxY;
            double s;
            double x0;
            double DecN = 1.89444 * N - 0.06292;
            double DecSec = 15 + 20 * DecN;
            double lambda = -Math.log(0.01) / DecSec;
            double iExpr = 0;
            double iSubj = 0;

            switch (type) {

                case 'a':
                    double angON = 1.11485 * N + 0.07318;
                    double angTN = 0.95926 * N + 0.11563;
                    angTN = normalize(angTN);
                    angON = normalize(angON);
                    maxY = -0.7 * angTN + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((angTN / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, angTN, s, x0);
                        csd.emoVect[0].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;
                    } else {
                        iSubj = appraisal(iObj, angTN, s, x0);
                        csd.emoVect[0].SecLeft = Math.log(iSubj) / -lambda;
                    }

                    iExpr = expression(iSubj, angON, s, x0);
                    break;

                case 'd':
                    double disEX = 1.251748 * E - 0.1279;
                    double disAPR = 1.177632 * N + 0.104483;
                    disEX = normalize(disEX);
                    disAPR = normalize(disAPR);
                    maxY = -0.7 * disAPR + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((disAPR / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, disAPR, s, x0);
                        csd.emoVect[1].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;


                    } else {
                        iSubj = appraisal(iObj, disAPR, s, x0);
                        csd.emoVect[1].SecLeft = Math.log(iSubj) / -lambda;

                    }


                    iExpr = expression(iSubj, disEX, s, x0);

                    break;

                case 'f':
                    double feaAPR = 0.947368 * N + 0.161053;
                    double feaEX = 1.006993 * E - 0.02589;
                    feaAPR = normalize(feaAPR);
                    feaEX = normalize(feaEX);
                    maxY = -0.7 * feaAPR + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((feaAPR / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, feaAPR, s, x0);
                        csd.emoVect[2].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;

                    } else {
                        iSubj = appraisal(iObj, feaAPR, s, x0);
                        csd.emoVect[2].SecLeft = Math.log(iSubj) / -lambda;

                    }

                    iExpr = expression(iSubj, feaEX, s, x0);

                    break;
                case 'j':
                    double joyAPREX = 0.986 * E + 0.07036;
                    joyAPREX = normalize(joyAPREX);
                    maxY = -0.7 * joyAPREX + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((joyAPREX / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, joyAPREX, s, x0);
                        csd.emoVect[3].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;

                    } else {
                        iSubj = appraisal(iObj, joyAPREX, s, x0);
                        csd.emoVect[3].SecLeft = Math.log(iSubj) / -lambda;
                    }

                    iExpr = expression(iSubj, joyAPREX, s, x0);
                    break;

                case 's':
                    double sadEX = 1.006993 * E - 0.02589;
                    double sadAPR = 0.921053 * N + 0.24515;
                    sadAPR = normalize(sadAPR);
                    sadEX = normalize(sadEX);
                    maxY = -0.7 * sadAPR + 1.2;
                    s = -maxY / (Math.log(0.001) - Math.log(999));
                    x0 = Math.log(999) * s;

                    if (same == true) {

                        double iObj2 = -(s * Math.log((sadAPR / leftover) - 1) - x0);

                        iObj = iObj + iObj2;
                        if (iObj >= 1) {
                            iObj = 1;
                        }

                        iSubj = appraisal(iObj, sadAPR, s, x0);
                        csd.emoVect[4].SecLeft = Math.log(iSubj) / -lambda;
                        iSubj = iSubj - leftover;


                    } else {
                        iSubj = appraisal(iObj, sadAPR, s, x0);
                        csd.emoVect[4].SecLeft = Math.log(iSubj) / -lambda;

                    }


                    iExpr = expression(iSubj, sadEX, s, x0);
                    break;
            }
            args[4] = csd;
            myAgent.setArguments(args);

            return iSubj;


        }

        private double calculateRelationshipImpact(List beliefset, String agent) {
            SocialBelief sb;
            double status = 0;
            double relationship = 0;
            double S;
            for (int i = 0; i < beliefset.size(); i++) {
                sb = (SocialBelief) beliefset.get(i);
                if (sb.Subject.equals(agent)) {
                    if (sb.Type == 10) {
                        relationship = sb.Number;
                    }
                }
            }

            double relationcoeff;

            if (relationship < 0) {
                relationcoeff = relationship;
            } else {
                relationcoeff = (relationship / 2) + 1;
            }

            if (relationship == 0) {
                relationcoeff = 1;
            }

            return relationcoeff;
        }

        private double calculateStatusImpact(List beliefset, String agent) {
            SocialBelief sb;
            double status = 0;
            double relationship = 0;
            double S;
            for (int i = 0; i < beliefset.size(); i++) {
                sb = (SocialBelief) beliefset.get(i);
                if (sb.Subject.equals(agent)) {
                    if (sb.Type == 11) {
                        status = sb.Number;
                    }
                }
            }


            double statuscoeff = (status / 2) + 1;
            if (status == 0) {
                statuscoeff = 1;
            }

            return statuscoeff;
        }

        private PAD tertiaryToPAD(double impact, double iSubj, char type, PAD current, PAD core) {
            PAD maxEmotion = new PAD(0, 0, 0);
            double coreToMax;
            double newP, newA, newD;
            switch (type) {
                case 'a':
                    maxEmotion = new PAD(0.28, 0.86, 0.66);
                    break;
                case 'd':
                    maxEmotion = new PAD(0.2, 0.675, 0.555);
                    break;
                case 'f':
                    maxEmotion = new PAD(0.19, 0.91, 0.285);
                    break;
                case 'j':
                    maxEmotion = new PAD(0.905, 0.755, 0.73);
                    break;
                case 's':
                    maxEmotion = new PAD(0.14, 0.355, 0.295);
                    break;
            }
            int p = getProfile(maxEmotion);
            PAD ext = getExtreme(p);
            coreToMax = distance(maxEmotion, core);
            double scaled = coreToMax * iSubj;

            if (impact >= 0) {
                if (ext.P == 0) {
                    newP = current.P - Math.abs(maxEmotion.P - current.P) * scaled;
                } else {
                    newP = current.P + Math.abs(maxEmotion.P - current.P) * scaled;
                }
                if (ext.A == 0) {
                    newA = current.A - Math.abs(maxEmotion.A - current.A) * scaled;
                } else {
                    newA = current.A + Math.abs(maxEmotion.A - current.A) * scaled;
                }
                if (ext.D == 0) {
                    newD = current.D - Math.abs(maxEmotion.D - current.D) * scaled;
                } else {
                    newD = current.D + Math.abs(maxEmotion.D - current.D) * scaled;
                }
            } else {
                if (ext.P == 0) {
                    newP = current.P + Math.abs(maxEmotion.P - current.P) * scaled;
                } else {
                    newP = current.P - Math.abs(maxEmotion.P - current.P) * scaled;
                }
                if (ext.A == 0) {
                    newA = current.A + Math.abs(maxEmotion.A - current.A) * scaled;
                } else {
                    newA = current.A - Math.abs(maxEmotion.A - current.A) * scaled;
                }
                if (ext.D == 0) {
                    newD = current.D + Math.abs(maxEmotion.D - current.D) * scaled;
                } else {
                    newD = current.D - Math.abs(maxEmotion.D - current.D) * scaled;
                }

            }

            newP = normalize(newP);
            newA = normalize(newA);
            newD = normalize(newD);
            PAD newcurrent = new PAD(newP, newA, newD);

            return newcurrent;
        }

        private double calculateObjectiveAffect(double rimpact, double simpact, double DemoStrength) {
            double affect = DemoStrength;
            double coeff = 0;
            if (rimpact < 0) {
                coeff = rimpact * (2 - simpact);
            } else {
                coeff = (simpact + rimpact) / 2;
            }
            affect = coeff * affect;
            // affect = simpact*affect;
            // affect = rimpact*affect;

            if (affect > 1) {
                affect = 1;
            }

            if (affect < -1) {
                affect = -1;
            }

            System.out.println(rimpact + " " + simpact + " " + coeff + " " + affect);

            return affect;
        }
    }

    private class EmotionCycle extends TickerBehaviour {

        public EmotionCycle(Agent a, long period) {
            super(a, period);
        }

        @Override
        protected void onTick() {
            Object[] args = myAgent.getArguments();
            Control c = (Control) args[0];
            Incoming n = (Incoming) args[3];
            CurrentStateDescription csd = (CurrentStateDescription) args[4];
            Personality core = (Personality) args[2];
            EmotionVector ev;
            boolean tag;
            char Last = ' ';
            double state = 0;
            boolean isPrimitive = false;

            if (c.Cycle == false) {
                System.out.println("EmoCycle off!");
                block();
            } else {


                if (n.IsNew == false) {

                    Last = getTheLastEmotion();

                    tag = true;
                    if (Last == 'p') {
                        tag = true;
                        isPrimitive = true;
                    }
                    if (Last == 'n') {
                        tag = false;
                        isPrimitive = true;
                    }

                    if (isPrimitive == true) {
                        state = getCurrentNegPosIntensityFromPAD(tag, core.pers, csd.currentState);




                    } else {
                        switch (Last) {

                            case 'a':
                                state = csd.emoVect[0].Value;
                                break;
                            case 'd':
                                state = csd.emoVect[1].Value;
                                break;
                            case 'f':
                                state = csd.emoVect[2].Value;
                                break;
                            case 'j':
                                state = csd.emoVect[3].Value;
                                break;
                            case 's':
                                state = csd.emoVect[4].Value;
                                break;
                        }

                    }

                    if (state > 0.011) {
                        decayLastEmotion(Last, n, state, isPrimitive);

                    } else {
                        if (state > 0.001) {
                            moodDecay(n);
                            
                        }

                    }
                } else {


                    //PRIMARY LEVEL
                    tag = true;
                    if (n.DemoEmotionType == ' ') {
                        if (csd.currentState.P > core.pers.P)
                        {
                            tag = true;
                        } else {
                            tag = false;
                        }
                        state = getCurrentNegPosIntensityFromPAD(tag, core.pers, csd.currentState);
                        isPrimitive = true;
                        n.SecondsSince = decayLastEmotion(Last, n, state, true);
                    } else {
                        isPrimitive = false;
                    }

                    csd.prevMood = csd.mood;

                    csd.mood = moodUpdate(isPrimitive, tag, csd.mood, csd.currentState, core.pers, csd.emoVect);
                    System.out.println(isPrimitive + " type: " + n.DemoEmotionType);
                    csd.moodTime = moodDecay(n);
                    n.DemoEmotionType = ' ';
                    n.IsNew = false;
                    n.SecondsSince = decayLastEmotion(Last, n, state, true);
                    args[3] = n;
                    myAgent.setArguments(args);
                }
            }

        }

        private char getTheLastEmotion() {
            char lastEmotion = ' ';
            Object[] args = myAgent.getArguments();
            EmotionVector ev;
            CurrentStateDescription csd = (CurrentStateDescription) args[4];
            Personality core = (Personality) args[2];

            //gets either actual emotion, or the last primitive affect if no emotion is tagged as last

            for (int i = 0; i < csd.emoVect.length; i++) {
                ev = csd.emoVect[i];
                if (ev.Last == true) {
                    lastEmotion = ev.Type;
                }

            }
            if (lastEmotion == ' ') {
                if (csd.currentState.P > core.pers.P) //peec tam mood
                {
                    lastEmotion = 'p';
                } else {
                    lastEmotion = 'n';
                }
            }



            return lastEmotion;
        }

        private double decayLastEmotion(char Last, Incoming I, double state, boolean isPrimitive) {

            Object[] args = myAgent.getArguments();
            Personality p = (Personality) args[2];
            CurrentStateDescription csd = (CurrentStateDescription) args[4];
            double subjInt = 0;
            double DecN = 1.89444 * p.N - 0.06292;
            double t = 0;
            if (DecN < 0.034) {
                DecN = 0.034;
            }
            double DecSec = 15 + 20 * DecN; //tikai tad, ja isnew, notiek tikai 1. līmenī
            double lambda = -Math.log(0.01) / DecSec;

            if (isPrimitive == true) {
                if (I.IsNew == true) {
                    t = Math.log(state) / -lambda;
                    I.SecondsSince = t + 1;
                } else {
                    t = I.SecondsSince;
                    I.SecondsSince = I.SecondsSince + 1;
                }

                subjInt = Math.exp(-lambda * t);
                decayIntegration(csd, p, subjInt, Last, true, state);

            }


            double prevvalue;
            switch (Last) {

                case 'a':
                    if (csd.emoVect[0].Value > 0.0001) {
                        prevvalue = csd.emoVect[0].Value;
                        csd.emoVect[0].SecLeft = csd.emoVect[0].SecLeft + 1;
                        csd.emoVect[0].Value = decay(csd.emoVect[0].SecLeft, lambda);

                        decayIntegration(csd, p, csd.emoVect[0].Value, Last, false, prevvalue);
                    }
                    break;
                case 'd':
                    if (csd.emoVect[1].Value > 0.0001) {
                        prevvalue = csd.emoVect[1].Value;
                        csd.emoVect[1].SecLeft = csd.emoVect[1].SecLeft + 1;
                        csd.emoVect[1].Value = decay(csd.emoVect[1].SecLeft, lambda);

                        decayIntegration(csd, p, csd.emoVect[1].Value, Last, false, prevvalue);
                    }
                    break;
                case 'f':
                    if (csd.emoVect[2].Value > 0.0001) {
                        prevvalue = csd.emoVect[2].Value;
                        csd.emoVect[2].SecLeft = csd.emoVect[2].SecLeft + 1;
                        csd.emoVect[2].Value = decay(csd.emoVect[2].SecLeft, lambda);

                        decayIntegration(csd, p, csd.emoVect[2].Value, Last, false, prevvalue);
                    }
                    break;
                case 'j':
                    if (csd.emoVect[3].Value > 0.0001) {
                        prevvalue = csd.emoVect[3].Value;
                        csd.emoVect[3].SecLeft = csd.emoVect[3].SecLeft + 1;
                        csd.emoVect[3].Value = decay(csd.emoVect[3].SecLeft, lambda);

                        decayIntegration(csd, p, csd.emoVect[3].Value, Last, false, prevvalue);
                    }
                    break;
                case 's':
                    if (csd.emoVect[4].Value > 0.0001) {
                        prevvalue = csd.emoVect[4].Value;
                        csd.emoVect[4].SecLeft = csd.emoVect[4].SecLeft + 1;
                        csd.emoVect[4].Value = decay(csd.emoVect[4].SecLeft, lambda);

                        decayIntegration(csd, p, csd.emoVect[4].Value, Last, false, prevvalue);
                    }
                    break;


            }


            //System.out.println(Last + " " + csd.emoVect[3].Value + " " + t);
            return I.SecondsSince;
        }

        public void decayIntegration(CurrentStateDescription Csd, Personality CoreState, double Value, char Last, boolean Primitive, double prevValue) {
            Object[] args = myAgent.getArguments();
            double maxP = 0.93 - 0.5;
            double minP = 0.5 - 0.15;
            double maxA = 0.83 - 0.5;
            double newP, newA, newD;
            PAD maxEmotion = new PAD(0, 0, 0);
            double coreToMax;


            if (Primitive == true) {
                double coreToCurrent = distance(Csd.currentState, CoreState.pers);
                double scaled = ((coreToCurrent * Value) / prevValue) / coreToCurrent;
                if (Last == 'n') {
                    Csd.currentState.P = CoreState.pers.P - scaled * Math.abs(Csd.currentState.P - CoreState.pers.P);
                    Csd.currentState.A = CoreState.pers.A + scaled * Math.abs(Csd.currentState.A - CoreState.pers.A);
                } else if (Last == 'p') {
                    Csd.currentState.P = CoreState.pers.P + scaled * Math.abs(Csd.currentState.P - CoreState.pers.P);
                    Csd.currentState.A = CoreState.pers.A + scaled * Math.abs(Csd.currentState.A - CoreState.pers.A);
                }
                addPADL1Intensity(Csd.currentState); //aizkomentēts, lai var novērtēt, kā iet kopā

            } else {

                switch (Last) {
                    case 'a':
                        maxEmotion = new PAD(0.28, 0.86, 0.66);
                        break;
                    case 'd':
                        maxEmotion = new PAD(0.2, 0.675, 0.555);
                        break;
                    case 'f':
                        maxEmotion = new PAD(0.19, 0.91, 0.285);
                        break;
                    case 'j':
                        maxEmotion = new PAD(0.905, 0.755, 0.73);
                        break;
                    case 's':
                        maxEmotion = new PAD(0.14, 0.355, 0.295);
                        break;
                }
                int p = getProfile(maxEmotion);
                PAD ext = getExtreme(p);
                coreToMax = distance(maxEmotion, CoreState.pers);
                double coreToCurrent = distance(Csd.currentState, CoreState.pers);
                //double scaled;


                double Px;
                double Ax;
                double Dx;
                Px = ((Csd.currentState.P - CoreState.pers.P) + (CoreState.pers.P * prevValue)) / prevValue;
                Ax = ((Csd.currentState.A - CoreState.pers.A) + (CoreState.pers.A * prevValue)) / prevValue;
                Dx = ((Csd.currentState.D - CoreState.pers.D) + (CoreState.pers.D * prevValue)) / prevValue;
                PAD x = new PAD(Px, Ax, Dx);


                if (Csd.currentState.P < CoreState.pers.P) {
                    newP = CoreState.pers.P - Math.abs(Px - CoreState.pers.P) * Value;
                } else {
                    newP = CoreState.pers.P + Math.abs(Px - CoreState.pers.P) * Value;
                }
                if (Csd.currentState.A < CoreState.pers.A) {
                    newA = CoreState.pers.A - Math.abs(Ax - CoreState.pers.A) * Value;
                } else {
                    newA = CoreState.pers.A + Math.abs(Ax - CoreState.pers.A) * Value;
                }
                if (Csd.currentState.D < CoreState.pers.D) {
                    newD = CoreState.pers.D - Math.abs(Dx - CoreState.pers.D) * Value;
                } else {
                    newD = CoreState.pers.D + Math.abs(Dx - CoreState.pers.D) * Value;
                }

                PAD newcurrent = new PAD(newP, newA, newD);
                Csd.currentState = newcurrent;
                addPADL2Intensity(Csd.currentState);

            }



            args[4] = Csd;
            myAgent.setArguments(args);

        }
    }

  
    public void cycleOff() {
        Object[] args = this.getArguments();
        Control c = (Control) args[0];
        c.Cycle = false;
        args[0] = c;
        this.setArguments(args);
        
    }

    public void cycleOn() {
        Object[] args = this.getArguments();
        Control c = (Control) args[0];
        c.Cycle = true;
        args[0] = c;
        this.setArguments(args);
        
    }

    public void criticalOn() {
        Object[] args = this.getArguments();
        Control c = (Control) args[0];
        c.Critical = true;
        args[0] = c;
        this.setArguments(args);
        
    }

    public boolean getCritical() {
        Object[] args = this.getArguments();
        Control c = (Control) args[0];
        return c.Critical;
    }

    public double primaryObjectiveEvaluation() //gets objective emotion from the interface, that is why very simple
    {
        Object[] args = this.getArguments();
        Incoming i = (Incoming) args[3];
        double a = i.DemoStrength;


        return a;
    }

    public double secondaryObjectiveEvaluation() //gets objective emotion and emotion type from the interface, that is why very simple
    {
        Object[] args = this.getArguments();
        Incoming i = (Incoming) args[3];
        double a = i.DemoStrength;
        return a;
    }

    public void calculateSubjectiveEmotion(double iObj) //calculates intensity of primitive affect
    {

        Object[] args = this.getArguments();
        Personality coreState = (Personality) args[2];
        CurrentStateDescription csd = (CurrentStateDescription) args[4];
        double pp; //personality impact
        boolean pos = true; //is emotion positive?

        //chooses parameter depending on emotion positivity or negativity
        if (iObj < 0) {
            pos = false;
            iObj = iObj * (-1);
        }
        // dependence on the personality
        if (pos == true) {
            pp = 1.00699 * coreState.E + 0.01839;
            
        } else {
            pp = 1.04605 * coreState.N + 0.15211;
            
        }

        pp = normalize(pp);
        //function parameter calculation 
        double maxY = pp * 0.3 + 0.7;
        double s = -maxY / (Math.log(0.001) - Math.log(999));
        double x0 = 1 - Math.log(999) * s;
        getObjectiveIrritation(pos, iObj, coreState, csd, maxY, s, x0);
    }

    public void getObjectiveIrritation(boolean Tag, double Incoming, Personality CoreState, CurrentStateDescription Csd, double maxY, double s, double x0) //adds up the irritations 
    {
        double currentI = 0.001; //current irritation form PAD space
        double leftover = 0; //objective leftover emotions
        double subjective = 0; //subjective irritation
        boolean adding = false; //Should the irritation be summed? 
        double maxDistance = 0; // maximum distance in PAD space
        double currentDistance = 0; //distance in PAD space from current state to core
        double subjectiveA = 0; //Used to calculate bell effect
        currentI = getCurrentNegPosIntensityFromPAD(Tag, CoreState.pers, Csd.currentState);


        if (Tag == true) {

            double test = maxY / currentI - 1;
            if (test < 0) {
                currentI = maxY / 1.001;
            }
            if (currentI > maxY) {
                currentI = maxY - 0.001;
            }
            if (currentI == 0) {
                leftover = 0;
            } else {
                leftover = -(s * Math.log(maxY / currentI - 1) - x0); //calculates the leftover irritation
            }
            if (Csd.currentState.P > CoreState.pers.P) {
                //if the tag is positive and person is closer to positive then get add the values to get bell efect
                Incoming = Incoming + leftover;
                if (Incoming >= 1) {
                    Incoming = 1;
                }
                subjective = maxY / (1 + Math.exp((-(Incoming - x0)) / s));
                subjectiveA = subjective;
                adding = true;

            } else {    //if the tag is positive and person is negative, no bell effect; incoming remains the same
                subjective = maxY / (1 + Math.exp((-(Incoming - x0)) / s));
                Incoming = Incoming + leftover;
                if (Incoming >= 1) {
                    Incoming = 1;
                }
                subjectiveA = maxY / (1 + Math.exp((-(Incoming - x0)) / s));
                adding = false;
            }
        } else {

            double test = maxY / currentI - 1;
            if (test < 0) {
                currentI = maxY / 1.001;
            }
            if (currentI == 0) {
                leftover = 0;
            } else {
                leftover = -(s * Math.log(maxY / currentI - 1) - x0); //calculates the leftover irritation
            }

            if (Csd.currentState.P < CoreState.pers.P) {
                //if the tag is negative and person is closer to negative then get add the values to get bell efect

                Incoming = Incoming + leftover;
                if (Incoming >= 1) {
                    Incoming = 1;
                }
                subjective = maxY / (1 + Math.exp((-(Incoming - x0)) / s));
                subjectiveA = subjective;
                adding = true;


            } else {//if the tag is negative and person is positive, no bell effect; incoming remains the same
                subjective = maxY / (1 + Math.exp((-(Incoming - x0)) / s));
                Incoming = Incoming + leftover;
                if (Incoming >= 1) {
                    Incoming = 1;
                }
                subjectiveA = maxY / (1 + Math.exp((-(Incoming - x0)) / s));
                adding = false;

            }
        }


        
        transformPrimitiveIntensityToPAD(adding, Tag, subjective, subjectiveA, Csd, CoreState, maxY);

        
    }

    public void transformPrimitiveIntensityToPAD(boolean Bell, boolean Tag, double Value, double ValueA, CurrentStateDescription Csd, Personality CoreState, double maxY) {

        Object[] args = this.getArguments();
        double maxP = 0.93 - 0.5;
        double maxA = 0.83 - 0.5;
        double minP = 0.5 - 0.15;
        double maxposEmo = maxY;

        if (Tag == true) {

            if (Bell == true) {

                Csd.currentState.P = CoreState.pers.P + Value * maxP;
                Csd.currentState.A = CoreState.pers.A + ValueA * maxA;

                if (Csd.currentState.A > maxposEmo) {
                    Csd.currentState.A = maxposEmo;
                }

            } else {
                Csd.currentState.P = CoreState.pers.P + Value * maxP;
                Csd.currentState.A = CoreState.pers.A + ValueA * maxA; 
                if (Csd.currentState.A > maxposEmo) {
                    Csd.currentState.A = maxposEmo;
                }
            }

        } else 
        {
            
            if (Bell == true) {

                Csd.currentState.P = CoreState.pers.P - Value * minP; 
                Csd.currentState.A = CoreState.pers.A + ValueA * maxA;

                if (Csd.currentState.A > maxposEmo) {
                    Csd.currentState.A = maxposEmo;
                }

            } else {
                Csd.currentState.P = CoreState.pers.P - Value * maxP;
                Csd.currentState.A = CoreState.pers.A + ValueA * maxA;

                if (Csd.currentState.A > maxposEmo) {
                    Csd.currentState.A = maxposEmo;
                }

            }
        }
      
        args[4] = Csd;
        Incoming n = (Incoming) args[3];
        n.IsNew = true;
        args[3] = n;
        Personality p = (Personality) args[2];
        addPADL1Intensity(Csd.currentState);

        //mood to arguments

        this.setArguments(args);




    }

    public double getCurrentNegPosIntensityFromPAD(boolean Tag, PAD core, PAD c) {
        double currentI = 0;
        double maxDistance = 0;
        double currentDistance = 0;

        if (Tag == true) {
            maxDistance = Math.sqrt(Math.pow((0.93 - core.P), 2) + Math.pow((0.83 - core.A), 2)); //0.93 iegūts šādi = 0.5+0.86/2 = 0.93; tāpat arī A
            currentDistance = Math.sqrt(Math.pow((c.P - core.P), 2) + Math.pow((c.A - core.A), 2));

            currentI = currentDistance / maxDistance;
            if (currentI == 0) {
                currentI = 0;
            }
        } else {
            maxDistance = Math.sqrt(Math.pow((core.P - 0.15), 2) + Math.pow((core.A - 0.17), 2)); //0.15 iegūts šādi = 1-(0.5+0.70/2) = 0.15; tāpat arī A
            currentDistance = Math.sqrt(Math.pow((c.P - core.P), 2) + Math.pow((c.A - core.A), 2));
            currentI = currentDistance / maxDistance;
            if (currentI == 0) {
                currentI = 0;
            }
        }

        return currentI;
    }

    public double integrateInPAD(boolean Tag, PAD core, PAD c) {
        double currentI = 0;
        double maxDistance = 0;
        double currentDistance = 0;

        if (Tag == true) {
            maxDistance = Math.sqrt(Math.pow((0.93 - core.P), 2) + Math.pow((0.83 - core.A), 2)); //0.93 iegūts šādi = 0.5+0.86/2 = 0.93; tāpat arī A
            currentDistance = Math.sqrt(Math.pow((c.P - core.P), 2) + Math.pow((c.A - core.A), 2));

            currentI = currentDistance / maxDistance;
            if (currentI == 0) {
                currentI = 6.82121E-06;
            }
        } else {
            maxDistance = Math.sqrt(Math.pow((core.P - 0.15), 2) + Math.pow((core.A - 0.17), 2)); //0.15 iegūts šādi = 1-(0.5+0.70/2) = 0.15; tāpat arī A
            currentDistance = Math.sqrt(Math.pow((c.P - core.P), 2) + Math.pow((c.A - core.A), 2));
            currentI = currentDistance / maxDistance;
            if (currentI == 0) {
                currentI = 6.82121E-06;
            }
        }


        return currentI;
    }

    public void addPADL1Intensity(PAD p) {

        outputListElement a = new outputListElement(p.P, p.A, p.D);
        EmotionL1PAD.add(a);

    }

    public void addPADL2Intensity(PAD p) {

        outputListElement a = new outputListElement(p.P, p.A, p.D);
        EmotionL2PAD.add(a);

    }

    public void addPADL3Intensity(PAD p) {

        outputListElement a = new outputListElement(p.P, p.A, p.D);
        EmotionL3PAD.add(a);

    }

    public void addPADMoodIntensity(PAD p) {

        outputListElement a = new outputListElement(p.P, p.A, p.D);
        MoodPAD.add(a);

    }

    public void showClosestEmotion(PAD csd) {

        double[] deltas = Personality.getDeltas(csd);
        double distance = 0.0;
        int emo = 0;
        for (int i = 0; i < deltas.length; i++) {
            if (deltas[i] > distance) {
                distance = deltas[i];
                emo = i;
            }

        }

        switch (emo) {
            case 0:
                //System.out.println("I am angry!");
                break;
            case 1:
                //System.out.println("I am disgusted!");
                break;
            case 2:
                //System.out.println("I am afraid!");
                break;
            case 3:
                //  System.out.println("I am happy!");
                break;
            case 4:
                // System.out.println("I am sad!");
                break;

        }


    }

    public PAD moodUpdate(boolean isPrimitive, boolean Tag, PAD currentmood, PAD currentstate, PAD corestate, EmotionVector[] emovec) {
        PAD mood;
        // get the octant in which currentstate is and centre of that octant
        int p = getProfile(currentstate);

        PAD ext = getExtreme(p);
        // d4 = get distance from currentmood to extreme in which the currentstate is
        double d4 = Math.sqrt(Math.pow((currentmood.P - ext.P), 2) + Math.pow((currentmood.A - ext.A), 2) + Math.pow((currentmood.D - ext.D), 2));
        double d1 = Math.sqrt(Math.pow((currentstate.P - corestate.P), 2) + Math.pow((currentstate.A - corestate.A), 2) + Math.pow((currentstate.D - corestate.D), 2));
        double d2 = 0;

       

        if (isPrimitive == true) {
            if (Tag = true) {
                d2 = Math.sqrt(Math.pow((1 - corestate.P), 2) + Math.pow((1 - corestate.A), 2) + Math.pow((corestate.D - corestate.D), 2));
            } else {
                d2 = Math.sqrt(Math.pow((0 - corestate.P), 2) + Math.pow((0 - corestate.A), 2) + Math.pow((corestate.D - corestate.D), 2));
            }


        } else {
            //in case of emotion the emotion is calculated based on last emotion
            double[] coretomax = Personality.getDeltas(corestate);
            char e = ' ';
            for (int i = 0; i < emovec.length; i++) {
                if (emovec[i].Last == true) {
                    e = emovec[i].Type;
                }
            }

            switch (e) {
                case 'a':
                    d2 = coretomax[0];
                    break;
                case 'd':
                    d2 = coretomax[1];
                    break;
                case 'f':
                    d2 = coretomax[2];
                    break;
                case 'j':
                    d2 = coretomax[3];
                    break;
                case 's':
                    d2 = coretomax[4];
                    break;
            }
        }
        // get the proportion of the distance (d1/d2) and fraction (d3)

        double prop = d1 / d2;
        double Afract = Math.abs(ext.A - currentmood.A) * prop;
        double Pfract = Math.abs(ext.P - currentmood.P) * prop;
        double Dfract = Math.abs(ext.D - currentmood.D) * prop;
        double newA;
        double newP;
        double newD;

        // get the current mood state based on fraction


        if (ext.P == 0) {
            newP = currentmood.P - Pfract;
        } else {
            newP = currentmood.P + Pfract;
        }


        if (ext.A == 0) {
            newA = currentmood.A - Afract;
        } else {
            newA = currentmood.A + Afract;
        }


        if (ext.D == 0) {
            newD = currentmood.D - Dfract;
        } else {
            newD = currentmood.D + Dfract;
        }
 

        mood = new PAD(newP, newA, newD);
        addPADMoodIntensity(mood);
        return mood;
    }

    public double moodDecay(Incoming i) {
        double newP = 0;
        double newA = 0;
        double newD = 0;

        Object[] args = this.getArguments();
        CurrentStateDescription csd = (CurrentStateDescription) args[4];
        Personality p = (Personality) args[2];
        int prof = getProfile(csd.mood);
        PAD ext = getExtreme(prof);

        PAD mextreme = p.maxExtreme;
        //how far is the core from the extreme, the value of "y", at which the emotions have just started, "x" = 0
        double maxpossible = Math.sqrt(Math.pow((mextreme.P - p.pers.P), 2) + Math.pow((mextreme.A - p.pers.A), 2) + Math.pow((mextreme.D - p.pers.D), 2)); //?
        double time = csd.moodTime;
        //if new irritation has appeared, the length of the decay must be calculated, namely, the current "y" value, and new time must be set - corresponding "x"

        if (i.IsNew == true) {
            double currentdistancetocore = Math.sqrt(Math.pow((csd.mood.P - p.pers.P), 2) + Math.pow((csd.mood.A - p.pers.A), 2) + Math.pow((csd.mood.D - p.pers.D), 2)); //d1
            time = (1200 * currentdistancetocore) / maxpossible;
            csd.moodTime = time;

        } else {
            double current = Math.sqrt(Math.pow((csd.mood.P - p.pers.P), 2) + Math.pow((csd.mood.A - p.pers.A), 2) + Math.pow((csd.mood.D - p.pers.D), 2));
            double fractionsize = maxpossible / 1200;
            double fractionNo = current / fractionsize;
            double distance = fractionsize * csd.moodTime; //distance lielajā nogrieznī, ideāli distance sākumā = current



            double max = Math.sqrt(Math.pow((ext.P - p.pers.P), 2) + Math.pow((ext.A - p.pers.A), 2) + Math.pow((ext.D - p.pers.D), 2));


            double Afract = Math.abs(p.pers.A - csd.mood.A) / fractionNo;
            double Pfract = Math.abs(p.pers.P - csd.mood.P) / fractionNo;
            double Dfract = Math.abs(p.pers.D - csd.mood.D) / fractionNo;

            System.out.println(distance + " = " + current + " Pfract " + Pfract + " Afract " + Afract + " Dfract " + Dfract);

          

            if (csd.mood.P > p.pers.P) {
                newP = csd.mood.P - Pfract;
            } else {
                newP = csd.mood.P + Pfract;
            }


            if (csd.mood.A > p.pers.A) {
                newA = csd.mood.A - Afract;
            } else {
                newA = csd.mood.A + Afract;
            }


            if (csd.mood.D > p.pers.D) {
                newD = csd.mood.D - Dfract;
            } else {
                newD = csd.mood.D + Dfract;
            }


            if (newP > 1) {
                newP = 1;
            }
            if (newA > 1) {
                newA = 1;
            }
            if (newD > 1) {
                newD = 1;
            }

            csd.mood = new PAD(newP, newA, newD);
          

            addPADMoodIntensity(csd.mood); 
        }
        if (csd.moodTime > 0) {
            csd.moodTime = csd.moodTime - 1;
        } else {
            csd.moodTime = 0;

        }
        args[4] = csd;
        this.setArguments(args);

        return time;
    }

    public int getProfile(PAD csd) //http://howie.gse.buffalo.edu/effilno/interests/math/octants/
    {
        int profile = 0;


        if (csd.P >= 0.5) {
            if (csd.A >= 0.5) {
                if (csd.D >= 0.5) {
                    //P+ A+ D+
                    profile = 1;
                } else //P+ A+ D-
                {
                    profile = 2;
                }
            } else if (csd.D >= 0.5) {
                //P+ A- D+
                profile = 3;
            } else //P+ A- D-
            {
                profile = 2;
            }
        } else {
            if (csd.A >= 0.5) {
                if (csd.D >= 0.5) {
                    //P- A+ D+
                    profile = 5;
                } else //P- A+ D-
                {
                    profile = 6;
                }
            } else if (csd.D >= 0.5) {
                //P- A- D+
                profile = 7;
            } else //P- A- D-
            {
                profile = 8;
            }
        }
        return profile;
    }

    public PAD getExtreme(int octant) //negative = 0.25, positive = 0.75, octant no: http://howie.gse.buffalo.edu/effilno/interests/math/octants/
    {
        PAD c = new PAD(0, 0, 0);
        switch (octant) 
        {
            case 1:
                c.P = 1;
                c.A = 1;
                c.D = 1;
                break;
            case 2:
                c.P = 1;
                c.A = 1;
                c.D = 0;
                break;
            case 3:
                c.P = 1;
                c.A = 0;
                c.D = 1;
                break;
            case 4:
                c.P = 1;
                c.A = 0;
                c.D = 0;
                break;
            case 5:
                c.P = 0;
                c.A = 1;
                c.D = 1;
                break;
            case 6:
                c.P = 0;
                c.A = 1;
                c.D = 0;
                break;
            case 7:
                c.P = 0;
                c.A = 0;
                c.D = 1;
                break;
            case 8:
                c.P = 0;
                c.A = 0;
                c.D = 0;
                break;

        }
      

        return c;
    }

    public double normalize(double value) {
        if (value > 1) {
            value = 1;
        }
        if (value < 0) {
            value = 0;
        }
        return value;
    }

    public double appraisal(double iObj, double traitDependence, double s, double x0) {

        double subjInt = traitDependence / (1 + Math.exp((-(iObj - x0)) / s));

        return subjInt;
    }

    public double expression(double iSubj, double traitDependence, double s, double x0) {


        double expPower = traitDependence / (1 + Math.exp(-(iSubj - (x0)) / s));
        return expPower;
    }

    public double decay(double t, double lambda) {
        double subjInt = Math.exp(-lambda * t);
        return subjInt;
    }

    public double distance(PAD p1, PAD p2) {
        double d;

        d = Math.sqrt(Math.pow((p1.P - p2.P), 2) + Math.pow((p1.A - p2.A), 2) + Math.pow((p1.D - p2.D), 2));

        return d;

    }
}
