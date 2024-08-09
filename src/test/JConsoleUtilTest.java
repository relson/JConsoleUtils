package test

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class JConsoleUtilTest {

    @Test
    public void printc_ShouldPrintColoredMessage() {
        // Redirecting System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test case
        JConsoleUtil.printc("Test Message", "44", "31", "1", "5");

        // Asserting the output
        assertEquals("The colored message should be printed correctly.",
                String.format("\033[44;31;1;5mTest Message\033[0m"), outContent.toString());
    }

    @Test
    public void posicionar_ShouldMoveCursorToSpecifiedPosition() {
        // Redirecting System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test case
        JConsoleUtil.posicionar(10, 37);

        // Asserting the output
        assertEquals("The cursor should move to the specified position.", String.format("\033[10;37H"),
                outContent.toString());
    }

    @Test
    public void limpar_ShouldClearConsole() {
        // Redirecting System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test case
        JConsoleUtil.limpar();

        String outpuString = outContent.toString();

        String expectedOutput = String.format("\033[2J");

        // Asserting the output
        assertEquals("The console should be cleared.", expectedOutput, outpuString);
    }
}
