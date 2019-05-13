// This strategy tries to optimize line breaks globally, that is, one paragraph at a time.
public class TexCompositor implements Compositor {
    private static String linebreak = "\n";

    @Override
    public String compose(Component[] components) {
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < components.length; i++) {
            if(components[i].Content.equals("<ParagraphEnd>") == false) {
                String naturalSize = "[" + components[i].naturalSize + "]";
                str.append(naturalSize).append(components[i].Content).append(" ");
            }
            else {
                String naturalSize = "[" + components[i].naturalSize + "]";
                str.append(naturalSize).append("<ParagraphEnd>");
                if(i != components.length-1) {
                    str.append(linebreak);
                }
            }
        }

        String answer = str.toString();
        return answer;
    }
}