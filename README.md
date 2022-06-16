# java_pacific_atlantic_water_flow

There is an `m x n` rectangular island that borders both the **Pacific Ocean** and **Atlantic Ocean**. The **Pacific Ocean** touches the island's left and top edges, and the **Atlantic Ocean** touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an `m x n` integer matrix `heights` where `heights[r][c]` represents the **height above sea level** of the cell at coordinate `(r, c)`.

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is **less than or equal to** the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return *a **2D list** of grid coordinates* `result` *where* `result[i] = [$r_i$, $c_i$]` *denotes that rain water can flow from cell* `($r_i$, $c_i$)` *to **both** the Pacific and Atlantic oceans*.

## Examples

**Example 1:**

![https://assets.leetcode.com/uploads/2021/06/08/waterflow-grid.jpg](https://assets.leetcode.com/uploads/2021/06/08/waterflow-grid.jpg)

```
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

```

**Example 2:**

```
Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]

```

**Constraints:**

- `m == heights.length`
- `n == heights[r].length`
- `1 <= m, n <= 200`
- `0 <= heights[r][c] <= $10^5$`

## 解析

題目 給定一個 m by n 矩陣 heights , 每個 cell  height[r][c] 代表該位置的高度

每個 cell 的假設如果上面有水會從水平以及重直方向相鄰且高度較低的 cell 流去

假設 上方還有左方代表 pacific ocean, 下方還有右方代表 atlantic ocean 

求寫出一個演算法找出可以同時流到 pacific ocean 以及 atlantic ocean 的所有 cell

直覺的作法是 從每個 cell 做 dfs 找出可以到 pacific ocean 以及 atlantic ocean 的檢查

如果只是這樣做因為每次都是從新尋找 所以複雜度會到 O($(m*n)^2$)

要優化檢查法 可以從一個觀察來看

首先最上方 還有 最左方的 cell 一定可以流到 pacific ocean 

所以從海洋的觀點出法 只要找到 cell 值大於上一個 cell 的值就代表可以流到 pacific ocean

同樣地 最下方 還有 最右方的 cell 一定可以流到 atlantic ocean

而我們只要先對可以流到兩個 ocean 的 cell 做標記

然後 loop 矩陣每個值 , 只要檢查當下 的 cell 同時有可以流到兩個 ocean 標記 就是題目所求

而個別找尋標記可以從最邊緣做 dfs 搜尋下一個可以標記的

所以最多 O(m*n)  

![](https://i.imgur.com/F1Pm1K1.png)

## 程式碼
```java
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
```
## 困難點

1. 要思考如何讓每個 cell 同時到達 pacific 還有 atlantic ocean
2. 要思考如何判斷該 cell 可以被水流過的條件

## Solve Point

- [x]  Understand what problem need to solve
- [x]  Analysis Complexity

