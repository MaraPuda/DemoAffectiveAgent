/*
Ensures architecture state "Critical" and whether emotion cyclic processing is on.
 */
package emotional_agent_demo;

/**
 *
 * @author Mara Pudane
 */
public class Control {
    public boolean Critical;
    public boolean Cycle;
  
        
    public Control (boolean critical, boolean cycle)
    {
    Critical = critical;
    Cycle = cycle;
    }
    
}
