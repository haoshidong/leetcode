package 剑指offer;

import java.util.Arrays;
import java.util.List;

public class p035_findMinDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        int i = 0;
        for (String str : timePoints) {
            int minute = (str.charAt(0) * 10 + str.charAt(1)) * 60 + str.charAt(3) * 10 + str.charAt(4);
            minutes[i] = minute;
            i++;
        }
        Arrays.sort(minutes);
        int x = 24 * 60;
        int differ = minutes[minutes.length - 1] - minutes[0];
        int min = differ < x / 2 ? differ : x - differ;
        for (int j = 0; j < minutes.length - 1; j++) {
            differ = minutes[j + 1] - minutes[j] < x / 2 ? minutes[j + 1] - minutes[j] : x - (minutes[j + 1] - minutes[j]);
            min = Math.min(min, differ);
        }
        return min;
    }
}
