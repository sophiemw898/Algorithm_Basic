class Solution {
    public int leastInterval(char[] tasks, int n) {
        //考虑数量出现最多的任务A，以它描绘最大的框架
        //AxxxAxxxA 至少需要（countA - 1) * (n + 1) + 1个位置
        //最后的num为和A一样出现同样最多任务的个数，取与tasks.length相比的较小值
        int[] counts = new int[26];
        for (char c : tasks) {
            counts[c - 'A']++;
        }
        int maxCount = 0;
        int num = 0;//记录最大count出现的次数
        for (int count : counts) {
            if (count > maxCount) {
                maxCount = count;
                num = 1;
            } else if (count== maxCount) {
                num++;
            }
        }
        
        return Math.max((maxCount - 1) * (n + 1) + num, tasks.length);
        //["A","A","A","B","B","B"] n = 0
        //return (maxCount - 1) * (n + 1) + num;
    }
}
