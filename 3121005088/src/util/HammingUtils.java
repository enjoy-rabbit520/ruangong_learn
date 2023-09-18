package util;

public class HammingUtils {

    /**
     * 根据输入的simHash值，计算海明距离
     * @param simHash1
     * @param simHash2
     * @return
     */

    public static int getDistance(String simHash1,String simHash2){
        int distance = 0;
        if (simHash1.length()!=simHash2.length()){
            distance = -1; //错误,返回-1
        }
        else{
            for (int i = 0;i < simHash1.length();i++){
                // 逐位比较
                if (simHash1.charAt(i)!=simHash2.charAt(i)){
                    distance++;
                }
            }
        }
        return distance;
    }

    public static double getSimilarity(String simHash1,String simHash2){
        // 调用getDistance方法，得到海明距离
        int distance = getDistance(simHash1,simHash2);
        // 计算相似度
        return 0.01 * (100 - distance * 100/128);
    }
}
