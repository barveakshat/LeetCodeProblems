class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid[0].length;
        int m = grid.length;
        int[][] visited = grid;
        int minutes = -1;
        int freshOranges = 0;
        int rotten = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) freshOranges++;
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(freshOranges == 0){
            return 0;
        }
        if(q.isEmpty()){
            return -1;
        }

        int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] dir : dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 1) {
                        visited[i][j] = 2;
                        freshOranges--;
                        q.offer(new int[] {i, j});
                    }
                }
            }
            minutes++;
        }
        if (freshOranges == 0) return minutes;

        return -1;
    }
}