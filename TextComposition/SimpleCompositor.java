// A simple strategy that determines line breaks one at a time.
public class SimpleCompositor implements Compositor{
    private static String linebreak = "\n";

    @Override
    public String compose(Component[] components) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < components.length; i++) {
            String naturalSize = "[" + components[i].naturalSize + "]";
            str.append(naturalSize).append(components[i].Content);
            
            if(i != components.length-1) {
                str.append(linebreak);
            }
        }

        String answer = str.toString();
        return answer;
    }
}