import org.junit.Before;
import org.junit.Test;
import org.zezutom.justification.TextJustifier;

import java.io.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class TextJustifierTest {

    private TextJustifier formatter;

    @Before
    public void setUp() {
        formatter = new TextJustifier();
    }

    @Test
    public void fullyJustifiedText_narrow() {
        assertFullJustification(20);
    }

    @Test
    public void fullyJustifiedText_medium() {
        assertFullJustification(50);
    }

    @Test
    public void fullyJustifiedText_wide() {
        assertFullJustification(80);
    }

    private void assertFullJustification(int width) {

        String orig = readUnformattedFile();
        String expected = readFormattedFile(width);

        assertThat(formatter.justify(orig, width), is(expected));
    }

    private String readFormattedFile(int width) {
        return readFile("lorem_ipsum_w" + width + ".txt");
    }

    private String readUnformattedFile() {
        return readFile("lorem_ipsum.txt");
    }

    private String readFile(String filename) {
        StringBuilder sb = new StringBuilder();
        try (InputStream is = getClass().getResourceAsStream(filename)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            // Remove the last character (new line)
            sb.setLength(sb.length() - 1);
        } catch (IOException e) {
            fail("Error when parsing file " + filename + ": " + e.getMessage());
        }

        return sb.toString();
    }

}
