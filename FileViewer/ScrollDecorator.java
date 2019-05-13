public class ScrollDecorator extends Decorator {
    public ScrollDecorator(VisualDisplay visual) {
        super(visual);
    }

    @Override
    public void draw() {
        // visual.draw();
        System.out.print(" scrollBar");
    }
}