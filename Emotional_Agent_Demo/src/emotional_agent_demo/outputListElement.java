/*
Used to output data
 */
package emotional_agent_demo;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Mara Pudane
 */
public class outputListElement {
    public double P = 0;
    public double A = 0;
    public double D = 0;
    String t;
  
  
    
    
    public outputListElement (double p, double a, double d)
    {
    P = p;
    A = a;
    D = d;
    t = new SimpleDateFormat("HH.mm.ss").format(new Date());
    }
    
}
