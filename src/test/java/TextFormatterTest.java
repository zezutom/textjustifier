import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class TextFormatterTest {

    private TextFormatter formatter;

    @Before
    public void setUp() {
        formatter = new TextFormatter();
    }

    @Test
    public void fullyJustifiedText() {
        String orig = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

        String expected = "Lorem ipsum dolor sit\namet,     consectetur\nadipiscing      elit.";
        String actual = formatter.format(orig, 21);
        System.out.println(actual);

        assertThat(actual, is(expected));
    }

}
