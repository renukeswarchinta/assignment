package solution3;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import solution2.FindSumValueInPyramid;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class MaximumPathFinderTest {

    private MaximumPathFinder maximumPathFinder;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Before
    public void setUp() throws Exception {
        maximumPathFinder = new MaximumPathFinder();
    }

    @Test
    public void calculateMaximumSumDiagnally() throws URISyntaxException, IOException {
        Path path = Paths.get(getClass().getClassLoader().getResource("input.txt").toURI());
        long sum = maximumPathFinder.findMaximumPath(path);
        assertThat(sum,equalTo(23L));
    }

}