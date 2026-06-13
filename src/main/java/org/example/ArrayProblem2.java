package org.example;

import java.util.*;
import java.util.stream.Collectors;

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

    public void miniumNo(int[] arr){
        int min=arr[0];
        for(int i:arr){
            if(i<min){
                min=i;
            }
        }
        System.out.println("Minimum No from array is: "+min);
    }
    public void maxNo(int[] arr){
        int max=arr[0];
        for(int i:arr){
            if(i>max){
                max=i;
            }
        }
        System.out.println("Maximum No from array is: "+max);
    }

    public void allUniqueElements(int[] arr){
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr) map.put(num,map.getOrDefault(num,0)+1);
        for(int key:map.keySet()){
            if(map.get(key)==1){
                System.out.println(key);
            }
        }

//        List<Integer> uniques= map.keySet().stream().filter(n->map.get(n).equals(1)).collect(Collectors.toList());
//        System.out.println(uniques);
    }

    public void firstUniqueElement(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                System.out.println("First unique element from array is: "+key);
                return;
            }
        }
    }

    public void findAllDuplicates(int[] arr){
        Set<Integer> seen=new HashSet<>();
        Set<Integer> duplicates=new HashSet<>();
        for(int num:arr){
            if(!seen.add(num)){
                duplicates.add(num);
            }
        }
        System.out.println("Duplicate elements are :"+duplicates);
    }

    public void findFirstDuplicate(int[] arr){
        Set<Integer> seen=new HashSet<>();
        Set<Integer> duplicates=new HashSet<>();
        for(int num:arr){
            if(!seen.add(num)){
                 System.out.println("First duplicate elements is :"+num);
                 return;
            }
        }

    }

    public void reverseArray(int[] arr){
        int left=0; int right=arr.length-1;
        while(left<right){
            int temp=arr[right];
            arr[right]=arr[left];
            arr[left]=temp;

            left++;
            right--;

        }
        System.out.println("Reversed array is : "+ Arrays.toString(arr));
    }

    public void reverseInKGroup(int[] arr,int k){
        for(int i=0;i<arr.length;i+=k){
            int left=i;
            int right=Math.min(i+k-1,arr.length-1);
            while(left<right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;

                left++;
                right--;
            }
        }
         System.out.println("Reversed array is : "+ Arrays.toString(arr));
    }

    //Sorting array in all 0's at left and all 1's at right
    public void sort0And1(int[] arr){
        int left=0; int right=arr.length-1;
        while(left<right){
            while (arr[left]==0 && left<right) left++;
            while (arr[right]==1 && left<right) right--;
            if(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        System.out.println("Sorted array is : "+ Arrays.toString(arr));
    }
    public static void main(String[] args) {

        ArrayProblem2 arrayProblem2 =new ArrayProblem2();
        int[] arr={0,0,1,2,3,1,3,0,1,0,7,9};
        int[] arr1={1,0,1,0,0,0,1,1,0,1,0,1};
        arrayProblem2.sort0And1(arr1);

    }
}
