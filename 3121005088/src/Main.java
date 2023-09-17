import util.ReadTxtUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

      // 接受从命令行输入的参数读取对应的文件
        // 原文文件
        String originStr = ReadTxtUtils.readTxt(args[0]);
        // 抄袭版文件
        String copyStr = ReadTxtUtils.readTxt(args[1]);


    }
}
