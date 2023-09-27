package utils;

import java.io.*;
import java.math.BigDecimal;

/**
 * 将题目以及答案存储进文本文件中
 */
public class SaveUtil {

    // 生成题目的文件路径
    private static final String exerciseFile = "exercise.txt";
    // 答案的文件路径
    private static final String answerFile = "answer.txt";

    public static void insertAnswer(String[] answer){
        File file = new File(answerFile);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            for (int i = 1; i < answer.length - 1; i++) {
                bw.write("答案"+i+":"+" "+answer[i]+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (osw!=null){
                try {
                    osw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void insertAnswer(double[] answer) {
        File file = new File(answerFile);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        BigDecimal format = null;
        double result = 0;
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            for (int i = 1; i < answer.length; i++) {
                // 转化为两位小数
                format = new BigDecimal(answer[i]);
                result = format.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                bw.write("答案"+i+": "+result+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void insertExercise(String[] exercise) {
        File file = new File(exerciseFile);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos);
            bw = new BufferedWriter(osw);
            for (int i = 1; i < exercise.length; i++) {
                bw.write(i+".四则运算题目"+i+": "+exercise[i]+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
          if (bw != null){
              try {
                  bw.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          if (osw != null){
              try {
                  osw.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          if (fos != null){
              try {
                  fos.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        }

    }
}
