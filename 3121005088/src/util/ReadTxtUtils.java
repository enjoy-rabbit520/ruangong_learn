package util;

import java.io.*;

/**
 * 接受程序命令行的参数,读写txt文件的工具类
 */
public class ReadTxtUtils {

    /**
     * 通过传入的txt文件路径读取该文件
     * @param txtPath txt文件路径
     * @return
     */
    public static String readTxt(String txtPath){
        String str = "";
        String line;
        // 创建文件对象
        File file = new File(txtPath);
        // 创建流对象
        FileInputStream fis = null;

        try{
            fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            // 进行字符串拼接
            while((line = br.readLine())!=null){
                str += line;
            }
            // 注意：关闭资源
            fis.close();
            isr.close();
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }


    public static void writeInTxt(double content,String txtPath){
        String str = Double.toString(content);
        File file = new File(txtPath);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(file, true);
            //将内容写入txt文件中
            fileWriter.write(str,0,(str.length() > 3? 4:str.length()));
            fileWriter.write("\r\n");
            //关闭资源
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
