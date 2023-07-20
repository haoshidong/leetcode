package test.xhs.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 10^9+7*/
public class t1 {
    static Long changCt = 0L;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        Map<Long, Long> numToCt = new HashMap<>();
        for (long i = 0L; i < n; i++) {
            Long l = in.nextLong();
            numToCt.put(l, numToCt.getOrDefault(l, 0L) + 1L);
        }
        changeCount(numToCt);
        System.out.println(changCt);
    }

    private static void changeCount(Map<Long, Long> numToCt) {
        Long mod = 1000000007L;
        Long max = 0L;
        for (Map.Entry<Long,Long> entry : numToCt.entrySet()) {
            if (max < entry.getKey()){
                max = entry.getKey();
            }
        }
        Map<Long,Long> dp = new HashMap<>();
        dp.put(0L,1L);
        for (Long i = 1L; i <= max; i++) {
            long pre = dp.get(i - 1L);
            long value = (i+1L) * pre + 1;
            dp.put(i,value);
        }

        for (Map.Entry<Long,Long> entry : numToCt.entrySet()) {
            changCt += (entry.getValue() * dp.get(entry.getKey())) % mod;
        }
    }
}
