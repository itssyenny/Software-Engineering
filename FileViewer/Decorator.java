public abstract class Decorator implements VisualDisplay {
    protected VisualDisplay visual;

    // "owns a " relationship
    public Decorator(VisualDisplay visual) {
        this.visual = visual;
    } 

    // delegation
    public void draw() {
        visual.draw();
    }


}