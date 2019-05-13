public class Component {
    public int ComponentID;
    public int naturalSize;
    public int stretchability; 
    public int shrinkability; 
    public String Content; 
    
    public Component(int ComponentID, int naturalSize, int stretchability, int shrinkability, String Content) {
        this.ComponentID = ComponentID;
        this.naturalSize = naturalSize;
        this.stretchability = stretchability;
        this.shrinkability = shrinkability;
        this.Content = Content;
    }
}