package com.tangtang.benchmark.testsort;

import java.util.Arrays;

/**
 * @author tangwenbo
 * @date 2018/1/20
 * @since JDK1.8
 */
public class Test12 {

  public static void main(String[] args) {
    //定义数组
    int[] sortNum = { 12, 33, 28, 86, 15, 62, 9, 38 };
    //开始排序
    bubbleSort(sortNum);
    //打印结果
    System.out.println(Arrays.toString(sortNum));
  }

  /**
   * 从小到大顺序进行排列，从[前面]开始比较。。。容易理解。
   *
   * @param sortNum
   */
  private static void bubbleSort(int[] sortNum) {
    int temp = 0;
    //第一个for循环控制排序要走多少趟，最多做n-1趟排序
    for (int i = 0; i < sortNum.length - 1; i++) {
      //第2个for循环控制每趟比较多少次
      for (int j = 0; j < sortNum.length - 1 - i; j++) {
        //大的往后面排
        if (sortNum[j + 1] > sortNum[j]) {
          temp = sortNum[j];
          sortNum[j] = sortNum[j + 1];
          sortNum[j + 1] = temp;
        }
      }
    }
  }
}
