//create the new class to compare
class node {
    int dist;
    int bike;
    int worker;
    public node(int dist, int worker, int  bike) {
        this.dist = dist;
        this.bike = bike;
        this.worker = worker;
    }
}

class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        int count = 0;
        boolean[] used =  new boolean[bikes.length];
        //sort the dist based on rules
        PriorityQueue<node> pq = new PriorityQueue<node>(new Comparator<node>() {
            public int compare(node n1, node n2) {
                if (n1.dist == n2.dist) {
                    if (n1.worker == n2.worker) { 
                        return n1.bike - n2.bike;
                    } else {
                        return n1.worker - n2.worker;
                    }
                } else {
                    return n1.dist - n2.dist;
                }
            }
        });
        //offer all node in the pq  
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = calc(workers[i], bikes[j]);
                node n = new node(dist, i, j);
                pq.offer(n);
            }
        }
        
        //get the result
        while (count < workers.length) {
            node n = pq.poll();
            if (res[n.worker] == -1 && !used[n.bike]) {
                res[n.worker] = n.bike;
                used[n.bike] = true;
                count++;
            }
        }
        
        return res;
    }
    
    private int calc (int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
