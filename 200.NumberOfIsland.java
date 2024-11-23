class Solution {
    public int numIslands(char[][] grid) {
        int island=0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    grid[i][j]='0';//visited
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i,j});

                    while(!q.isEmpty()){
                        int[] cur = q.poll();

                        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
                        for(int[] dir : directions){
                            int r = dir[0] + cur[0];
                            int c = dir[1] + cur[1];

                            if(r>=0 && c>=0 && r<row && c<col && grid[r][c]=='1'){
                                q.add(new int[] {r, c});
                                grid[r][c]='0'; // visisted
                            }
                        }
                    }
                    island++;
                }
            }
        }
        return island;
    }
}
//TC: O(r*c)
//SC: O(r*c)
