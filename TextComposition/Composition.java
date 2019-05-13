public class Composition {
    public Component[] components;
    private Compositor compositor;

    public Composition(Compositor compositor) {
        this.compositor = compositor;
    }
    
    public String arrange() {
        return compositor.compose(components);
    }
}