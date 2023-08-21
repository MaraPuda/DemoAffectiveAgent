/*
Class us used to define BDI concepts
 */
package emotional_agent_demo;


import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Mara Pudane
 * 
 */
public class BelDesInt {
       public List <Belief> BeliefSet;
       public int Desire;
       public boolean Intention = true;
       public static int TESTTICK = 0;
  
        
    public BelDesInt (List beliefset, int desire, boolean intention)
    {
    BeliefSet = beliefset;
    Desire = desire;
   Intention = intention;
    }
    }
    

