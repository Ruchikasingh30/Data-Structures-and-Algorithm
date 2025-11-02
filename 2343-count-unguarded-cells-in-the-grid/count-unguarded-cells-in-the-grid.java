//assisted

public class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n]; // 0 = empty, 1 = guard, 2 = wall
        boolean[][] guarded = new boolean[m][n];

        // Mark guards and walls on grid
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        // Directions: up, down, left, right
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        // For each guard, mark visible cells
        for (int[] guard : guards) {
            for (int[] dir : directions) {
                int r = guard[0] + dir[0];
                int c = guard[1] + dir[1];
                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 2 && grid[r][c] != 1) {
                    guarded[r][c] = true;
                    r += dir[0];
                    c += dir[1];
                }
            }
        }

        int count = 0;
        // Count unguarded empty cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !guarded[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
