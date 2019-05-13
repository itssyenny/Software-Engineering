// A strategy that selects breaks so that each row has a fixed number
// of items. It's useful for breaking a collection of icons into rows, for example.
public class ArrayCompositor implements Compositor {
    private static String linebreak = "\n";

    @Override
    public String compose(Component[] components) {
        StringBuilder str = new StringBuilder();

        int i = 0;
        while(i < components.length) {
            int col = 0;
            while(col < 3 && i < components.length) {
                String naturalSize = "[" + components[i].naturalSize + "]";
                str.append(naturalSize).append(components[i].Content);
                if(col == 2) {
                    str.append(linebreak);
                }
                else {
                    if(i != components.length-1) {
                        str.append(" ");
                    }
                }
                i++; col++;
            }
        }

        String answer = str.toString();
        return answer;
    }
}