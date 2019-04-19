package solution2;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class FindSumValueInPyramidTest {

    private FindSumValueInPyramid findSumValueInPyramid;

    @Before
    public void setUp() throws Exception {
        findSumValueInPyramid = new FindSumValueInPyramid();
    }
    @Test
    public void testInput() throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource("assignmentInput.txt").toURI());
        long sum = findSumValueInPyramid.calculateMaximumSumDiagnally(path);
        assertThat(sum,equalTo(8186L));
    }
    @Test
    public void calculateMaximumSumDiagnally() throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource("input.txt").toURI());
        long sum = findSumValueInPyramid.calculateMaximumSumDiagnally(path);
        assertThat(sum,equalTo(16L));
    }


}