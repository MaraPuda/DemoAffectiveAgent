/*
New irritation is described internally as an object of this class.
 */
package emotional_agent_demo;

/**
 *
 * @author Mara Pudane
 */
public class Incoming {
     public boolean IsNew;
    public double SecondsSince;
    public double DemoStrength;// Says how strong the objective emotion would be outside of an agent
    public char DemoEmotionType;
    public boolean DemoTertiary;
    public boolean Tag;
    public boolean Processed;
  
        
    public Incoming (boolean in, double ss, double ds, char det, boolean tert)
    {
    IsNew = in;
    SecondsSince = ss;
    DemoStrength = ds;
    DemoEmotionType = det;
    DemoTertiary = tert;
    Processed = false;
    
    }
    
   
}
