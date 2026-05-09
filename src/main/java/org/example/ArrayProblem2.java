package org.example;

public class ArrayProblem2 {

    public void zerosAndOnes(int[] arr){
        int one=0;
        int zero=0;
        for(int i:arr){
            if(i==0) zero++;
            else if (i==1) {
                one++;
            }
        }
        System.out.println("Zeros: "+zero);
        System.out.println("One's: "+one);
    }

    public static void main(String[] args) {

        ArrayProblem2 arrayProblem2 =new ArrayProblem2();
        int[] arr={1,2,3,1,3,0,1,0};
        arrayProblem2.zerosAndOnes(arr);
    }
}
