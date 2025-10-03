class Solution {
    public int trapRainWater(int[][] heightMap) {
    int m = heightMap.length, n = heightMap[0].length;
    if (m < 3 || n < 3) return 0;

    boolean[][] visited = new boolean[m][n];
    PriorityQueue<int[]> heap = new PriorityQueue<>(java.util.Comparator.comparingInt(cell -> cell[2]));

    for (int i = 0; i < m; ++i) {
        heap.offer(new int[]{i, 0, heightMap[i][0]});
        heap.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
        visited[i][0] = visited[i][n - 1] = true;
    }
    for (int j = 0; j < n; ++j) {
        heap.offer(new int[]{0, j, heightMap[0][j]});
        heap.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
        visited[0][j] = visited[m - 1][j] = true;
    }

    int res = 0, level = Integer.MIN_VALUE;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    while (!heap.isEmpty()) {
        int[] cell = heap.poll();
        int r = cell[0], c = cell[1], h = cell[2];
        level = Math.max(level, h);
        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {
                visited[nr][nc] = true;
                res += Math.max(0, level - heightMap[nr][nc]);
                heap.offer(new int[]{nr, nc, heightMap[nr][nc]});
            }
        }
    }
    return res;
    }
}