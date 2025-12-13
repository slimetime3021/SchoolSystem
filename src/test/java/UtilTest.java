import org.derick.Util;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilTest {

    @Test
    @DisplayName("java -> Java")
    void toTitleCaseTest1() {
        String input = "java";
        String expected = "Java";

        String result = Util.toTitleCase(input);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("computer science and math -> Computer Science And Math")
    void toTitleCaseTest2() {
        String input = "computer science and math";
        String expected = "Computer Science And Math";

        String result = Util.toTitleCase(input);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("jAvA pROgraMMing -> Java Programming")
    void toTitleCaseTest3() {
        String input = "jAvA pROgraMMing";
        String expected = "Java Programming";

        String result = Util.toTitleCase(input);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Data Structures -> Data Structures")
    void toTitleCaseTest4() {
        String input = "Data Structures";
        String expected = "Data Structures";

        String result = Util.toTitleCase(input);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName(" null -> null")
    void toTitleCaseTest5() {
        String input = null;
        String expected = null;

        String result = Util.toTitleCase(input);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("  ->  ")
    void toTitleCaseTest6() {
        String input = "";
        String expected = "";

        String result = Util.toTitleCase(input);

        assertEquals(expected, result);
    }
}
