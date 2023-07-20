package Hot100.p051_p100;

import javax.management.MXBean;

public class p621_leastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] countOfTask = new int[26];
        int LargestTaskNum = 0;
        for (char task : tasks) {
            countOfTask[task - 'A']++;
            LargestTaskNum = Math.max(LargestTaskNum, countOfTask[task - 'A']);
        }
        int sameLargestTaskNum = 0;
        for (int count : countOfTask) {
            if (count == LargestTaskNum) {
                sameLargestTaskNum++;
            }
        }
        return Math.max(tasks.length, (LargestTaskNum - 1) * (n + 1) + sameLargestTaskNum);
    }
}
