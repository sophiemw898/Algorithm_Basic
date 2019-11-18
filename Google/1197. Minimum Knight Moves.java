class Coordinate {
    int x; 
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    int[] dirX = new int[] {1, 2, 1, 2, -1, -2, -1, -2};
    int[] dirY = new int[] {2, 1, -2, -1, 2, 1, -2, -1};
        
    public int minKnightMoves(int x, int y) {
        int steps = 0;
        
        Queue<Coordinate> queue = new LinkedList<>();
        Map<Integer, Map<Integer, Integer>> visited = new HashMap();
        
        queue.offer(new Coordinate(0, 0));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        visited.put(0, map);
        
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            if (curr.x == x && curr.y == y) {
                return visited.get(x).get(y);
            }
                
            for (int index = 0; index < 8; index++) { 
                int newX = curr.x + dirX[index];
                int newY = curr.y + dirY[index];
                Coordinate node = new Coordinate(newX, newY);
                int dist = visited.get(curr.x).get(curr.y) + 1;
                    
                if(visited.containsKey(newX) && visited.get(newX).containsKey(newY)) {
                    continue;
                }
                if(!visited.containsKey(newX)) {
                    visited.put(newX, new HashMap());
                }
                visited.get(newX).put(newY, dist); 
                
                queue.offer(node);
                }
            }
        
        return -1;
    }
}

class Coordinate {
    int x; 
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}



class Solution {
    
    int[] dirX = new int[] {1, 2, 1, 2, -1, -2, -1, -2};
    int[] dirY = new int[] {2, 1, -2, -1, 2, 1, -2, -1};
        
    public int minKnightMoves(int x, int y) {
        int steps = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        queue.offer(new Coordinate(0, 0));
        set.add(0);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate curr = queue.poll();
                if (curr.x == x && curr.y == y) {
                    return steps;
                }
                
                for (int index = 0; index < 8; index++) { 
                    Coordinate node = new Coordinate(curr.x + dirX[index], curr.y + dirY[index]);
                    int hash = 1001 * node.x + node.y;
                    
                    if (Math.abs(node.x) + Math.abs(node.y) <= 300 && !set.contains(hash)) {
                        queue.offer(node);
                        set.add(hash);
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}
