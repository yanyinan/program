## 装水问题

有一个 异形 容器，用一个 `n * n `的二维数组来表示。其中` 1 `表示容器实心部分，` 0 `表示空心部分。现使用此容器装水，能装多少水（每个元素都表示一份水，只有有挡板的部分

能装水）？

容器示意图：

![image-20230811193353922](https://s2.loli.net/2023/08/11/ZkmBbt2anlrGYqT.png)

以上容器能装水 4

>思考：若是使用一个一维数组来表示实心部分高度该如何计算？

## ![image-20230811193421608](https://s2.loli.net/2023/08/11/hPdosAelVzCpxu6.png)

```java
package com.kfm.base.arrays;

public class Exer08 {

    public static void main(String[] args) {

        int[][] nums = {
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1},
        };

        int water = 0;
        outer: for (int i = nums.length - 2; i >= 0; i --) {
            int left = 0;
            int right = nums[i].length - 1;
            // 从左侧找到边界 1
            while(left < right){
                if (nums[i][left] == 1 && nums[i][left + 1] == 0){
                    break;
                }
                left ++;
            }

            // 从右边找边界 1
            while(left < right){
                if (nums[i][right] == 1 && nums[i][right - 1] == 0){
                    break;
                }
                right --;
            }

            // 一种情况 left = right, 说明只有一个 1
            if (left != right){
                water += right - left - 1;

                for (int j = left + 1; j < right; j++) {
                    if (nums[i][j] == 1){
                        water --;
                    }
                }
            }

        }
        System.out.println("能存" + water + "水");
    }
}
```

## 迷宫游戏【拓展】

在一个二维数组中，0 表示空地，1 表示墙壁，9 表示目标点。你的任务是从起始点 (0, 0)

出发，判断是否能够到达目标点，不能斜着移动。

```java
00000
11010 
00000
01111 
00009
```

要判断是否能够从起始点 (0, 0) 到达目标点，可以使用深度优先搜索(DFS)或广度优先搜索(BFS)算法。这里我们使用 BFS 算法来实现。

解析：
1. 创建一个队列，将起始点 (0, 0) 加入队列。
2. 当队列不为空时，执行以下操作：
   a. 弹出队列的第一个元素。
   b. 如果该元素是目标点，返回 true。
   c. 否则，遍历该元素的上下左右四个相邻位置，如果相邻位置是空地且未被访问过，则将其加入队列并标记为已访问。
3. 当队列为空且没有找到目标点时，返回 false。

代码实现：

```java
import java.util.LinkedList;
import java.util.Queue;

public class MazeGame {
    private static final int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 9}
    };

    public static void main(String[] args) {
        System.out.println(canReachTarget());
    }

    public static boolean canReachTarget() {
        int startX = 0;
        int startY = 0;
        int targetX = maze.length - 1;
        int targetY = maze[0].length - 1;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == targetX && current[1] == targetY) {
                return true;
            }
            for (int i = Math.max(0, current[0] - 1); i <= Math.min(current[0] + 1, maze.length - 1); i++) {
                for (int j = Math.max(0, current[1] - 1); j <= Math.min(current[1] + 1, maze[0].length - 1); j++) {
                    int newX = i;
                    int newY = j;
                    if (i == current[0] || j == current[1]) continue;
                    if (maze[newX][newY] == 1 || visited[newX][newY]) continue;
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }
}
```