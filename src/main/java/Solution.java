import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Solution {
    static class Pair {
        private int col;
        private int row;

        public Pair(int col, int row) {
            this.col = col;
            this.row = row;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return col == pair.col && row == pair.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(col, row);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROW = heights.length;
        int COL = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Pair> pacific = new HashSet<>();
        HashSet<Pair> atlantic = new HashSet<>();

        for (int row = 0; row < ROW; row++) {
            dfs(row, 0, heights,heights[row][0], pacific);
            dfs(row, COL -1, heights, heights[row][COL-1], atlantic);
        }
        for (int col = 0; col < COL; col++) {
            dfs(0, col, heights, heights[0][col], pacific);
            dfs(ROW-1, col, heights, heights[ROW-1][col], atlantic);
        }
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                Pair cell = new Pair(row, col);
                if (pacific.contains(cell)&&atlantic.contains(cell)) {
                    result.add(List.of(row, col));
                }
            }
        }
        return result;
    }
    public void dfs(int row, int col, int[][] heights, int prevHight, HashSet<Pair> visit) {
        int ROW = heights.length;
        int COL = heights[0].length;
        if (row < 0 || row >= ROW || col < 0 || col >= COL || prevHight > heights[row][col]) {
            return;
        }
        Pair cell = new Pair(row, col);
        if (visit.contains(cell)) {
            return;
        }
        visit.add(cell);
        dfs(row-1, col, heights, heights[row][col], visit);
        dfs(row+1, col, heights, heights[row][col], visit);
        dfs(row, col-1, heights, heights[row][col], visit);
        dfs(row, col+1, heights, heights[row][col], visit);
    }
}
