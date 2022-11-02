package 每日一题;

public class p1620_bestCoordinate {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] g = new int[101][101];
        int max = 0, x = 0, y = 0;
        //遍历每个塔，将其对周围坐标的影响加到相应坐标上
        for (int[] tower : towers) {
            int a = tower[0], b = tower[1], q = tower[2];
            //遍历受当前塔影响的每个坐标点
            for (int i = Math.max(0, a - radius); i <= a + radius; i++) {
                for (int j = Math.max(0, b - radius); j <= b + radius; j++) {
                    int dis = (a - i) * (a - i) + (b - j) * (b - j);
                    //在影响范围之外，跳过
                    if (dis > radius * radius) continue;
                    g[i][j] += Math.floor(q / (1 + Math.sqrt(dis)));
                    //若坐标信号最好，得到当前坐标值
                    if (g[i][j] > max) {
                        max = g[i][j]; x = i; y = j;
                    //若坐标信号一样好，根据条件决定是否替换坐标值
                    } else if (g[i][j] == max && (i < x || (i == x && j < y))) {
                        x = i; y = j;
                    }
                }
            }
        }
        return new int[]{x, y};
    }
}
