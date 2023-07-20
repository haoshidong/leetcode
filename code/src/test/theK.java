package test;

import java.util.ArrayList;

public class theK {
    public ArrayList<int[]> kPoints(int[][] points, int k) {
        int totalLenth = 0;
        int l = points.length;
        for (int i = 1; i <= l; i++) {
            if (points[i - 1][0] == points[i % l][0]) {
                totalLenth += Math.abs(points[i - 1][1] - points[i % l][1]);
            } else {
                totalLenth += Math.abs(points[i - 1][0] - points[i % l][0]);
            }
        }
        ArrayList<int[]> res = new ArrayList<>();
        int klen = totalLenth / k;
        for (int i = 0; i < k; i++) {
            int distance = klen * i;
            int index = 0;
            int next = index + 1;
            boolean horizental = true;
            int dir = 1;
            while (distance > 0) {
                int edge;
                if (points[next][0] == points[index][0]) {
                    edge = Math.abs(points[next][1] - points[index][1]);
                    dir = points[next][1] - points[index][1] > 0 ? 1 : -1;
                    horizental = false;
                } else {
                    edge = Math.abs(points[next][0] - points[index][0]);
                    dir = points[next][0] - points[index][0] > 0 ? 1 : -1;
                    horizental = true;
                }
                distance -= edge;
                index = (index + 1) % l;
                next = (index + 1) % l;
            }
            int[] kPoint;
            if (horizental) {
                kPoint = new int[]{points[index][0] + distance * dir, points[index][1]};
            } else {
                kPoint = new int[]{points[index][0], points[index][1] + distance * dir};
            }
            res.add(new int[]{kPoint[0], kPoint[1]});
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 0}, {0, 4}, {4, 4}, {4, 0}};
        int k = 8;
        theK tset = new theK();
        ArrayList<int[]> res = tset.kPoints(nums, k);
        for (int[] num : res) {
            System.out.println("[" + num[0] + "," + num[1] + "]");
        }
    }
}
