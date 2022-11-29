import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.task.OutputManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTests {

    static OutputManager outputManager;

    @BeforeAll
    @DisplayName("Create OutputManager object")
    static void creatObject() {
        outputManager = new OutputManager();
    }


    List<Integer> numbersInInputFile() {
        return List.of(1, 234, 2, 56, 76, 986, 11, 76, 45);
    }

    @ParameterizedTest
    @CsvSource({"input.txt, ''"})
    void checkNumsInArray(String firstParameter, String secondParameter) {
        outputManager.addNumsToArray(firstParameter, secondParameter);
        assertEquals(numbersInInputFile(), outputManager.nums);
    }

    @ParameterizedTest
    @ValueSource(strings = {"input.txt"})
    @DisplayName("Check valid file name for validity")
    void validFileName(String fileName) {
        outputManager.setNewInputFile(fileName);
        assertTrue(outputManager.isFirstPath());
    }

}
