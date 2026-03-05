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

    //reverse array in k group
    public static void reverseInK(int[] arr,int k){
        for(int i=0;i<arr.length-1;i+=k){
            int left=i;
            int right=Math.min(i+k-1,arr.length-1);
            while(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left++;
                right--;

            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Sort zero and one from array
    public static void sortZeroOne(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            while(arr[left]==0 && left<right) left++;
            while(arr[right]==1 && left<right) right--;
            if(left<right){
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //sort array of 0s,1s and 2s
    public static void sort012(int[] arr){
        int left=0;
        int mid=0;
        int high=arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                ArrayProblems.swap(arr,left++,mid++);
            }else if(arr[mid]==1){
                mid++;
            }else{
                ArrayProblems.swap(arr,mid,high--);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Shift all zeros to left side of array
    public static void shiftZeroToleft(int[] arr){
        int right=arr.length-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!=0){
                arr[right--]=arr[i];
            }
        }
        while(right>=0){
            arr[right--]=0;
        }
        System.out.println(Arrays.toString(arr));
    }

    //Rotate array to right by one
    public static void rotateRightByOne(int[] arr){
        int last=arr[arr.length-1];
        for(int i=arr.length-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=last;
        System.out.println(Arrays.toString(arr));
    }

    //Rotate array to left by one
    public static void rotateLeftByOne(int[] arr){
        int first=arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=first;
        System.out.println(Arrays.toString(arr));
    }

    //Rptate array by k positions
    public static void rotateByK(int[] arr,int k){
        int n=arr.length;
        k=k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr, k ,n-1);
        System.out.println(Arrays.toString(arr));
    }

    //find second-largest element from the array
    public static void secondLargest(int[] arr){
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        for(int num:arr){
            if(num>first){
                second=first;
                first=num;
            }else if(num>second && num!=first){
                second=num;
            }
        }
        System.out.println("Second larget element from array is:"+second);
    }

    //find second-smallest element from the array
    public static void secondSmallest(int[] arr){
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        for(int num:arr){
            if(num<first){
                second=first;
                first=num;
            }else if(num<second && num!=first){
                second=num;
            }
        }
        System.out.println("Second smallest element from array is:"+second);
    }

    //check if array is sorted or not
    public static void isSorted(int[] arr){
        boolean flag=true;
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]<arr[i-1]) flag=false;
        }
        if(flag){
            System.out.println("Array is sorted");
        }else{
            System.out.println("Array is not sorted");
        }
    }

    //To find kth largest element from array
    public static void findKthLargestElement(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:arr){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        System.out.println("K th Largest element from array is: "+pq.peek());
    }

    //To find kth smallest element from array
    public static void findKthSmallestElement(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int num:arr){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        System.out.println("K th Smallest element from array is: "+pq.peek());
    }

    //common swap method for all problems
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //common reverse method for all problems
    private static void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
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
        ArrayProblems.reverseInK(a,3);
        ArrayProblems.sortZeroOne(new int[]{1,0,1,0,0,1,1,1});
        ArrayProblems.sort012(new int[]{1,0,2,2,1,0,2,1,0,0,1,1,1});
        ArrayProblems.shiftZeroToleft(new int[]{1,0,2,2,1,0,2,1,0,0,1,1,1});
        ArrayProblems.rotateRightByOne(new int[]{8,0,2,2,1,0,2,1,0,0,1,1,1});
        ArrayProblems.rotateLeftByOne(new int[]{8,0,2,2,1,0,2,1,0,0,1,1,1});
        ArrayProblems.rotateByK(new int[]{8,0,2,2,1,0,2,1,0,0,1,1,1},1);
        ArrayProblems.secondLargest(new int[]{8,0,2,2,1,0,2,1,0,0,1,7,1,1});
        ArrayProblems.secondSmallest(new int[]{8,0,2,2,1,0,2,1,0,0,1,7,1,1});
        ArrayProblems.findKthLargestElement(new int[]{8,0,2,2,1,0,2,1,0,0,1,7,1,1},2);
        ArrayProblems.findKthSmallestElement(new int[]{8,0,2,2,1,0,2,1,0,0,1,7,1,1},2);
        ArrayProblems.isSorted(new int[]{0,1,2,3,4});

    }
}
