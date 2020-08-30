package com.usc.leetcode;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 */
public class CheckStraightLine {

    public static void main(String[] args) {
        CheckStraightLine.checkStraightLine(new int[][]{{1,0}, {2, 0}, {3, 1}});
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        int x = coordinates[0][0] - coordinates[1][0];
        int y= coordinates[0][1] - coordinates[1][1];
        if (x == 0){
            for(int i=2; i<len; i++){
                if (coordinates[i][0] != 0) return false;
            }

            return true;
        }
        double k = y/x;
        for(int i=2; i<len; i++){
            int y1 = coordinates[i][1];
            int x1 = coordinates[i][0];
            int x0 = coordinates[0][0];
            int y0 = coordinates[0][1];
            if( (double) (y1-y0) / (x1 - x0) != k) return false;
        }


        return true;
    }
}
