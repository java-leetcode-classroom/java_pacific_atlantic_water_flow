import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    final private Solution sol = new Solution();
    @Test
    void pacificAtlanticExample1() {
        assertEquals(List.of(
                List.of(0,4),
                List.of(1,3),
                List.of(1,4),
                List.of(2,2),
                List.of(3,0),
                List.of(3,1),
                List.of(4,0)
        ), sol.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }

    @Test
    void pacificAtlanticExample2() {
        assertEquals(List.of(
                List.of(0,0),
                List.of(0,1),
                List.of(1,0),
                List.of(1,1)
        ), sol.pacificAtlantic(new int[][]{
                {2,1},
                {1,2}
        }));
    }
}