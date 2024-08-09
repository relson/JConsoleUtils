pakage test

import info.relson.lib.console.util;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JConsoleUtilTest {

    // Placeholder for batch 1 tests
            @Test
        public void printc_ShouldPrintColoredMessage() {
            // Redirecting System.out to capture the output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
    
            // Test case
            JConsoleUtil.printc("Test Message", "44", "31", "1", "5");
    
            // Asserting the output
            assertEquals("\033[44;31;1;5mTest Message\033[0m", outContent.toString(), "The colored message should be printed correctly.");
        }
    
        @Test
        public void posicionar_ShouldMoveCursorToSpecifiedPosition() {
            // Redirecting System.out to capture the output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
    
            // Test case
            JConsoleUtil.posicionar(10, 37);
    
            // Asserting the output
            assertEquals("\033[10;37H", outContent.toString(), "The cursor should move to the specified position.");
        }
    
        @Test
        public void limpar_ShouldClearConsole() {
            // Redirecting System.out to capture the output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
    
            // Test case
            JConsoleUtil.limpar();
    
            // Asserting the output
            assertEquals("\033[2J", outContent.toString(), "The console should be cleared.");
        }

}
