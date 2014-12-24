import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

// http://forums.anandtech.com/showthread.php?t=1001858
public class TextFormatter {

    public String format(String text, int width) {
        // Split the text into lines of a fixed width
        return linesAsText(splitToLines(width, text));
    }

    private String linesAsText(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());

            if (iterator.hasNext()) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private List<String> splitToLines(int width, String text) {
        List<String> lines = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(text);
        StringBuilder sb = new StringBuilder();

        while (tokenizer.hasMoreElements()) {
            String word = (String) tokenizer.nextElement();
            if (sb.length() + word.length() > width) {
                lines.add(getPaddedLine(sb, width));
                sb.setLength(0);
            }
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) {
            lines.add(getPaddedLine(sb, width));
        }
        return lines;
    }

    private String getPaddedLine(StringBuilder sb, int width) {

        String text = sb.toString().trim();

        text = addPadding(0, width, text);

        return text;
    }

    private String addPadding(int index, int width, String text) {

        StringTokenizer st = new StringTokenizer(text);

        // Limit reached or there is a single word on the line.
        if (isMaxLength(text, width) || st.countTokens() < 2) return text;

        // Start from scratch, if the last word was reached, yet the line length is still insufficient.
        if (index >= st.countTokens() - 1) index = 0;

        if (isMaxLength(text, width) || index >= st.countTokens() - 1) return text;

        StringBuilder sb = new StringBuilder();

        String word = null;
        for (int i = 0; i <= index; i++) {
            if (st.hasMoreElements()) {
                word = (String) st.nextElement();
            } else {
                word = null;
            }
        }

        if (word == null) {
            // Shouldn't happen, but if anything goes wrong it's time to wrap it up.
            return text;
        }

        sb.append(word).append(" ");
        return addPadding(++index, width, text.replace(word, sb.toString()));
    }

    private boolean isMaxLength(String text, int width) {
        return text.length() >= width;
    }

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ornare non massa id sodales. Nunc in erat suscipit, rutrum leo eu, molestie elit. Nullam id risus nulla. Cras varius libero at ultrices rutrum. Sed imperdiet eleifend massa sed tincidunt. Phasellus vulputate nisl ex, quis varius risus pellentesque in. Aenean hendrerit velit vitae nisi rhoncus dignissim. Integer in rutrum turpis. Donec in sodales est. Sed eros magna, egestas vitae varius vitae, viverra eget lacus. Donec vel magna non neque convallis congue sed eget urna.";

        System.out.println(new TextFormatter().format(text, 30));
    }
}
