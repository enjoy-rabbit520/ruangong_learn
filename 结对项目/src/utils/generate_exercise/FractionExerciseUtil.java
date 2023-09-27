package utils.generate_exercise;

import utils.MarkUtil;
import utils.SaveUtil;

public class FractionExerciseUtil {

    /**
     * 生成题目
     * @param n 题目数量
     * @param x 数值范围
     */
    public static void getExercise(int n,int x){
        // 对传参的判断
        if (n < 1){
            System.out.println("题目数量输入错误！（1<=n<=10000）");
            return;
        }
        // 结果
        int sum = 0;
        // 题目数量
        int count = 0;
        // 数值，运算符，运算符个数
        int a,b,c,d,e,f,g,h,operator1,operator2,operator3,num;
        // 存储题目以及答案
        String[] exercise = new String[n + 1];
        String[] results = new String[n + 1];
        // 随机运算符：+ - * /,
        // 0表示+, 1表示-, 2表示*, 3表示/
        while (count<=n){
            operator1 = (int) (Math.random()*4);
            operator2 = (int) (Math.random()*4);
            operator3 = (int) (Math.random()*4);
            a = (int) (Math.random() * x);
            b = (int) (Math.random() * x);
            c = (int) (Math.random() * x);
            d = (int) (Math.random() * x);
            e = (int) (Math.random() * x);
            f = (int) (Math.random() * x);
            g = (int) (Math.random() * x);
            h = (int) (Math.random() * x);
            num = (int) (Math.random() * 3);
            // 一个运算符的情况下
            if (b != 0 && d!= 0&& num == 0){
                if (operator1 == 0){
                    exercise[++count] = a + "/" + b + " + " + c + "/" + d + " =";
                    // 存储临时值，方便化简
                    sum = a * d + b * c;
                    b = b * d;
                    // 判断是否为假分数，下同
                    if (sum > b){
                        // 将其转换成带分数，下同
                        results[count] = FractionUtil.changeToProperFraction(sum,b);
                    }else {
                        // 将分数化简,下同
                        results[count] = FractionUtil.simplifiedFraction(sum,b);
                    }
                } else if (operator1 == 1) {
                    if ((a/b) > (c/d)){
                        exercise[++count] = a + "/" + b + " - " + c + "/" + d + " =";
                        // 储存临时值，方便化简
                        sum = a * d - b * c;
                        b *= d;
                        if (sum > b){
                            results[count] = FractionUtil.changeToProperFraction(sum,b);
                        }else {
                            results[count] = FractionUtil.simplifiedFraction(sum,b);
                        }
                    }
                } else if (operator1 == 2) {
                    exercise[++count] = a + "/" + b + " * " + c + "/" + d + " =";
                    // 储存临时值，方便化简
                    sum = a * c;
                    b *= d;
                    if (sum > b){
                        results[count] = FractionUtil.changeToProperFraction(sum,b);
                    } else {
                        results[count] = FractionUtil.simplifiedFraction(sum,b);
                    }
                } else if (operator1 == 3) {
                    // 防止分母为0
                    if (c == 0){
                        continue;
                    }
                    exercise[++count] = a + "/" + b + " ÷ " + c + "/" + d + " =";
                    sum = a * d;
                    b *= c;
                    if (sum > b){
                        results[count] = FractionUtil.changeToProperFraction(sum,b);
                    } else {
                        results[count] = FractionUtil.simplifiedFraction(sum,b);
                    }
                }
                // 有两个运算符的情况下
            } else if (b != 0&& d != 0 && f != 0 && num ==1) {
                if (operator1 == 0) {
                    if (operator2 == 0){
                        exercise[++count] = a + "/" + b + " + " + c + "/" + d + " + " + e + "/" + f + " =";
                        sum = a*d*f + c*b*f + e*b*d;
                        b = b * d * f;
                        if (sum > b){
                            results[count] = FractionUtil.changeToProperFraction(sum,b);
                        }else {
                            results[count] = FractionUtil.simplifiedFraction(sum,b);
                        }
                    } else if (operator2 == 1) {
                        // TODO 保证不会生成结果为负数的题目
                        if (a/b + c/d - e/f > 0){
                            exercise[++count] = a + "/" + b + " + " + c + "/" + d + " - " + e + "/" + f + " =";
                            sum = a*d*f + c*b*f + e*b*d;
                            b = b * d * f;
                            if (sum > b){
                                results[count] = FractionUtil.changeToProperFraction(sum,b);
                            }else {
                                results[count] = FractionUtil.simplifiedFraction(sum,b);
                            }
                        }
                    } else if (operator2 == 2) {
                        exercise[++count] = a + "/" + b + " + " + c + "/" + d + " * " + e + "/" + f + " =";
                        sum = b*c*e + a*d*f;
                        b = b * d * f;
                        if (sum > b){
                            results[count] = FractionUtil.changeToProperFraction(sum,b);
                        }else {
                            results[count] = FractionUtil.simplifiedFraction(sum,b);
                        }
                    } else if (operator3 == 3 && e != 0) {
                        exercise[++count] = a + "/" + b + " + " + c + "/" + d + " + " + e + " ÷ " + f + " =";
                        sum = a*d*e + b*c*f;
                        b = b * d * e;
                        if (sum > b){
                            results[count] = FractionUtil.changeToProperFraction(sum,b);
                        }else {
                            results[count] = FractionUtil.simplifiedFraction(sum,b);
                        }
                    }
                }
            }
        }

        // 将生成的题目和答案存入txt文本文件
        SaveUtil.insertExercise(exercise);
        SaveUtil.insertAnswer(results);
        // 将答案存起来
        MarkUtil.setResults(results);

    }

}
