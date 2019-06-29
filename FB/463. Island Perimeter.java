
// loop over the matrix and count the number of islands;
// if the current dot is an island, count if it has any right neighbour or down neighbour;
// the result is islands * 4 - neighbours * 2

class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i ][j] == 1) {
                    islands++;//count islands
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        neighbours++;
                    }//count right neighbours
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        neighbours++;
                    }//count down neighbours
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
}
