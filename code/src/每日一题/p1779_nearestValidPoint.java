package 每日一题;

public class p1779_nearestValidPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int d = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (d < minDis) {
                    minDis = d;
                    ans = i;
                }
            }
        }
        return ans;
    }
}
