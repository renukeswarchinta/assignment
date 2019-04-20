package solution2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pyramid.calculations.MaximumSumFinderException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class FindSumValueInPyramidTest {

    private FindSumValueInPyramid findSumValueInPyramid;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Before
    public void setUp() throws Exception {
        findSumValueInPyramid = new FindSumValueInPyramid();
    }

    @Test
    public void calculateMaximumSumDiagnally() throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource("input.txt").toURI());
        long sum = findSumValueInPyramid.calculateMaximumSumDiagnally(path);
        assertThat(sum,equalTo(16L));
    }
    @Test
    public void calculateMaximumSumDiagnally_ForAssignmentInput() throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource("assignmentInput.txt").toURI());
        long sum = findSumValueInPyramid.calculateMaximumSumDiagnally(path);
        assertThat(sum,equalTo(4006L));
    }
    @Test
    public void calculateMaximumSumDiagnally_CountMismatchInput() throws URISyntaxException, IOException {
        exceptionRule.expect(MaximumSumFinderException.class);
        exceptionRule.expectMessage("Input file is not correct: Count of numbers is not equal to Row number");
        Path path = Paths.get(getClass().getClassLoader().getResource("rowcountmismatchfile.txt").toURI());
        long sum = findSumValueInPyramid.calculateMaximumSumDiagnally(path);
    }
    @Test
    public void calculateMaximumSumDiagnally_Emty() throws URISyntaxException, IOException {
        exceptionRule.expect(MaximumSumFinderException.class);
        exceptionRule.expectMessage("Input file is empty");
        Path path = Paths.get(getClass().getClassLoader().getResource("empty.txt").toURI());
        long sum = findSumValueInPyramid.calculateMaximumSumDiagnally(path);
    }

}