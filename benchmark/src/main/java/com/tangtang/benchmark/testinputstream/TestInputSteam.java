package com.tangtang.benchmark.testinputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 * @author tangwenbo
 * @date 2018/1/17
 * @since JDK1.8
 */
public class TestInputSteam {

  /**
   * 将文件作为流进行读写
   */
  @Test
  public void fileStreamTest() {
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    try {
      fileInputStream = new FileInputStream("D:\\userData.txt");
      fileOutputStream = new FileOutputStream("D:\\userData.txt");
      byte[] bytes = new byte[1024];
      while (fileInputStream.read(bytes) != -1) {
        fileOutputStream.write(bytes);
      }
      System.err.println("fileStreamTest: " + fileOutputStream.toString());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (fileInputStream != null) {
          fileInputStream.close();
        }
        if (fileOutputStream != null) {
          fileOutputStream.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }


}
