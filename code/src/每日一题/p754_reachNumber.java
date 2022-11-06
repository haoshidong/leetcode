package 每日一题;

public class p754_reachNumber {
    public int reachNumber(int target) {
        //情况1：n步之和为n * (n + 1) / 2，和≥target，若等于target，则与target之差为0，步数为n
        //情况2：  若不等于target，且差为偶数，则将差/2的步数向左走，即可到达target，步数为n
        //情况3：      若不等于target，且差为奇数、n为偶数，则再走n+1步，此时差变为偶数，将差/2步数向左走，即可到达target，步数为n+1
        //情况4：      若不等于target，且差为奇数、n为奇数，则再走n+1步、n+2步，此时差变为偶数，将差/2步数向左走，即可到达target，步数为n+2
        //情况3和4合并为n + 1 + n % 2
        target = Math.abs(target);
        //注意8*target越过int最大值，使用double类型计算
        int n = (int) Math.ceil((Math.sqrt(8L * target + 1) - 1) / 2);
        return (n * (n + 1) / 2 - target) % 2 == 0 ? n : n + 1 + n % 2;

        /*target = Math.abs(target);
        int sum = 0,count = 0;
        while (sum < target || (sum-target)%2==1) sum += ++count;
        return count;*/
    }
}
