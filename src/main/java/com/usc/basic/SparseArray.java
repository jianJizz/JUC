package com.usc.basic;

import java.util.Arrays;

/**
 * 稀疏数组 保存磁盘
 */
public class SparseArray {
    public static void main(String[] args) {
        //1.创建原始的二维数组 11*11
        //0 表示没有棋子 1表示黑子 2表示蓝子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        int[][] spareArr = SparseArray.getSpareArr(chessArr);
        int[][] src = SparseArray.getSrc(spareArr);
        SparseArray.printArr(src);

    }


    /*
       转为稀疏数组
       row clo val
     0 11  11  2
     1 1   2    1
     2 2   3    2
    */
    public static int[][] getSpareArr(int[][] srcArr){
        //创建稀疏数组 需要知道数据的个数
        int count = 0;
        for (int i=0; i<srcArr.length; i++){
            for (int j=0; j<srcArr[i].length; j++){
                if (srcArr[i][j] > 0)
                        count++;
            }
        }

        int[][] spArr = new int[count+1][3];
        int k = 1;
        spArr[0][0] = 11;
        spArr[0][1] = 11;
        spArr[0][2] = count;
        for (int i = 0; i<srcArr.length; i++){
            for (int j=0; j<srcArr[i].length; j++){
                if (srcArr[i][j] > 0){
                    spArr[k][0] = i;
                    spArr[k][1] = j;
                    spArr[k][2] = srcArr[i][j];
                    k++;
                }
            }
        }

        return spArr;
    }

    //从稀释数组恢复到原来的数组
    public static int[][] getSrc(int[][] sparseArr){
        int[][] srcArr = new int[sparseArr[0][0]][sparseArr[0][1]]; // 11, 11
        for (int i=1; i < sparseArr.length; i++)
                srcArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];

        return srcArr;
    }


    public static void printArr(int[][] srcArr){
        for (int i=0; i<srcArr.length; i++){
            for (int j=0; j<srcArr[i].length; j++)
                    System.out.print(srcArr[i][j]+ "\t");
            System.out.println();
        }
    }
}
