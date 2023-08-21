package emotional_agent_demo;

/*
Stores current intensities of all the emotions.
 */

/**
 *
 *@author Mara Pudane
 */
public class EmotionVector {
    public char Type;
    public double Value;
    public boolean Last;
    public double SecLeft;
    
    
    public EmotionVector (char t, double v, boolean l, double sl)
    {
    Type = t;
    Value = v;
    Last = l;
    SecLeft = sl;
    }
}
