/*
Ontologies used in communication with the interface.
 */
package DemoOntology;

import jade.content.Predicate;

/**
 *
 * @author Mara Pudane
 */
public class GUIMessage implements Predicate{
 
    private double PrimitiveEmo;
    private double ReEval;
    private String Emotion;
    private double Friends;
    private double Status;
    private int Type;
    
    public double getPrimitiveEmo()
    {
    return PrimitiveEmo;
    }
    public void setPrimitiveEmo(double primitiveemo)
    {
    this.PrimitiveEmo = primitiveemo;
    }
    
     public double getReEval()
    {
    return ReEval;
    }
    public void setReEval(double reeval)
    {
    this.ReEval = reeval;
    }
     
     public String getEmotion()
    {
    return Emotion;
    }
    public void setEmotion(String emotion)
    {
    this.Emotion = emotion;
    }
    
     public double getFriends()
    {
    return Friends;
    }
    public void setFriends (double friends)
    {
    this.Friends = friends;
    }
    
     public double getStatus()
    {
    return Status;
    }
    public void setStatus(double status)
    {
    this.Status = status;
    }
      
     public int getType()
    {
    return Type;
    }
    public void setType(int type)
    {
    this.Type = type;
    }
    
}
