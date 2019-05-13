public class BorderDecorator extends Decorator {
    public BorderDecorator(VisualDisplay visual) {
        super(visual);
    }

    @Override
    public void draw() {
        // visual.draw();
        System.out.print(" thickBlackBorder");
    }
}