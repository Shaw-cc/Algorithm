package com.shaw.algorithm.path;

import java.util.Random;

/**
 * 简单判断两点是否可达
 * <a href='https://tva1.sinaimg.cn/large/e6c9d24ely1h09pyhmjkuj215b0u0412.jpg'></a>
 */

public class SimpleIsReachable {

    static int[][] map = new int[3][5];

    public static void main(String[] args) {
        test();
    }

    // up
    public static boolean isReachable(int[][] map, int[] start, int[] end) {
        int x = start[0];
        int y = start[1];
        print(map, start, end);
        System.out.println();
        if (x == end[0] && y == end[1]) {
            return true;
        }
        //
        if (x - 1 >= 0 && map[x - 1][y] == 0) {
            map[x - 1][y] = -1;
            boolean reachable = isReachable(map, new int[]{x - 1, y}, end);
            if (reachable) {
                return reachable;
            }
        }
        //right
        if (y + 1 <= map[0].length - 1 && map[x][y + 1] == 0) {
            map[x][y + 1] = -1;
            boolean reachable = isReachable(map, new int[]{x, y + 1}, end);
            if (reachable) {
                return reachable;
            }
        }
        //down
        if (x + 1 <= map.length - 1 && map[x + 1][y] == 0) {
            map[x + 1][y] = -1;
            boolean reachable = isReachable(map, new int[]{x + 1, y}, end);
            if (reachable) {
                return reachable;
            }
        }

        //left
        if (y - 1 >= 0 && map[x][y - 1] == 0) {
            map[x][y - 1] = -1;
            boolean reachable = isReachable(map, new int[]{x, y - 1}, end);
            if (reachable) {
                return reachable;
            }
        }
        return false;
    }

    public static void test() {
        Random random = new Random();
        map = new int[3][5];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = random.nextInt(2);
            }
        }
        map[0][0] = 0;
        map[2][4] = 0;
        int[] start = {0, 0};
        int[] end = {2, 4};
        boolean reachable = isReachable(map, start, end);
        // todo 最短路径
        System.out.println(reachable);
    }


    public static void print(int[][] map, int[] start, int[] end) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (start[0] == i && start[1] == j) {
                    System.out.print("\033[1;31m" + map[i][j] + "\033[0m ");
                } else if (end[0] == i && end[1] == j) {
                    System.out.print("\033[1;31m" + map[i][j] + "\033[0m ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}
