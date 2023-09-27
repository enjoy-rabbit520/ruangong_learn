package utils.generate_exercise;

/**
 * 处理分数的工具类
 */
public class FractionUtil {

    /**
     * 真分数化简
     * @param a 分子
     * @param b 分母
     * @return 化简后的分数（字符串形式）
     */
    public static String simplifiedFraction(int a, int b){
        // 分子为0，直接返回0
        if (a == 0){
            return 0+"";
        }
        // 当分母为1时，直接返回分子
        if (b==1){
            return a+"";
        }
        int simplified = simplified(a,b);
        return a/simplified + "/" + b/simplified;
    }

    /**
     * 处理假分数化简：化为真分数
     * @param a 分子
     * @param b 分母
     * @return 化简后的分数
     */
    public static String changeToProperFraction(int a,int b){
        // 当分子为0，直接返回0
        if (a == 0){
            return 0 + "";
        }
        if (b == 1){
            return a + "";
        }
        int temp = a / b;
        int t = a % b;
        if (t ==0 ){
            return temp + "";
        }
        int simplified = simplified(t,b);
        return temp+"'"+t/simplified+"/"+b/simplified;
    }

    /**
     * 递归调用，求最大公约数
     * @param a 分子
     * @param b 分母
     * @return 分子a与分母b的最大公约数
     */
    private static int simplified(int a,int b){
        if (b==0){
            return a;
        }else {
            return simplified(b,a%b);
        }
    }
}
