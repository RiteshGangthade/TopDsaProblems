package org.example;

import java.util.*;

public class ArrayProblems {

    //Print number of 0s and 1s in given array
    public static void zeroAndOne(int[] arr){
        int one=0;
        int zero=0;
        for(int num:arr){
            if(num==0) zero++;
            else if (num==1)one++;
        }
        System.out.println("Number of 0s is: " + zero + " and number of 1s is: " + one);
    }

    //Print minimum and maximum number from array
    public static void minAndmax(int[] arr){
        int min=arr[0];
        int max=arr[0];
        for(int num:arr){
            if(num<min) min=num;
            if(num>max) max=num;
        }

        System.out.println("Maximum number from array is: " + max + " and minimum number from array is: " + min);
    }

    //Print unique elements from array
    public static void uniqueElements(int[] arr){
        List<Integer> array=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int key:map.keySet()){
            if(map.get(key)==1){
                array.add(key);
            }
        }

        System.out.println(array);

    }

    //Print first unique element from given array
    public static void firstUniqueElement(int[] arr){
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int key:map.keySet()){
            if(map.get(key)==1){
                System.out.println("First unique element from given array is: "+key);
                break;
            }
        }
    }

    //print all the duplicate elements from the array
    public static void duplicates(int[] arr){
        Set<Integer> seen=new HashSet<>();
        Set<Integer> duplicate=new HashSet<>();
        for(int num:arr){
            if(!seen.add(num)){
                duplicate.add(num);
            }
        }
        System.out.println("Duplicate elements from array are: "+duplicate);
    }

    //Print first duplicate element from array
    public static void firstDuplicate(int[] arr){
        Set<Integer> seen=new HashSet<>();
        for(int num:arr){
            if(!seen.add(num)){
                System.out.println("First duplicate element from this array is: "+num);
                break;
            }
        }
    }

    //reverse a given array
    public static void reverse(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        System.out.println("Reversed array for given array is: "+Arrays.toString(arr));
    }















    public static void main(String[] args) {

        int[] a={0,55,55,35,76,20,16,1,1};
        ArrayProblems.zeroAndOne(a);
        ArrayProblems.minAndmax(a);
        ArrayProblems.uniqueElements(a);
        ArrayProblems.firstUniqueElement(a);
        ArrayProblems.duplicates(a);
        ArrayProblems.firstDuplicate(a);
        ArrayProblems.reverse(a);

    }
}
