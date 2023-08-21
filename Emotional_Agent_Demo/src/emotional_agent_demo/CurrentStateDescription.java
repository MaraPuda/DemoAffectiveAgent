/*
 Class object describes the current state and parameters necessary for emotion calculation.
 */
package emotional_agent_demo;

import java.util.ArrayList;

/**
 *
 * @author Mara Pudane
 */
public class CurrentStateDescription {
    public PAD currentState;
    public PAD mood;
    public double moodTime;
    public PAD prevMood;
    public EmotionVector [] emoVect;
    
    
    public CurrentStateDescription (PAD cs, PAD m, PAD pm, double mt, EmotionVector [] ev)
    {
    currentState = cs;
    mood = m;
    moodTime = mt;
    emoVect = ev;
    prevMood = pm;
    }
}    
  

