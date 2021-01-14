package com.jiachunhao.demo;

public class Test {
    public static void main(String[] args) {




        /*long sum = 0;//2561327494111820313
                       //2561327494111820313
        for(int i=1;i<=20;i++){
            long s = 1;
            for(int j=1;j<=i;j++){
                s*=j;
            }
            sum+=s;
        }
        System.out.println(sum);*/




    }

    static long f(int n){
        long sum = 0;
        if(n==1){
            sum += 1;
        }else if(n>1){
            sum += n + f(n-1);
        }
        return sum;


    }
}






