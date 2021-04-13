package com.company;

import java.util.Comparator;

public class  Searching  {


    public static void main(String[] args) {
        //binarySearch
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int index = binarySearch(array1, 2, 0, array1.length-1);
        System.out.println("Index: " + index);


        int inter = interpolation(array1, 2, 0, array1.length-1);
        System.out.println("Interpol: " + inter);

    }


    public static int binarySearch(int[] array, int wantedInt, int l, int r) {
        if(r >= l){

        int middle = l+  (r - l) / 2;

        if (wantedInt == array[middle]) return middle;
        if (wantedInt < array[middle]) return binarySearch(array, wantedInt, 0, middle - 1);
        if (wantedInt > array[middle]) return binarySearch(array, wantedInt, middle + 1, r);

        }
        return -1;

    }

    public static int interpolation(int[] array, int wantedInt, int l, int r){
        if( r >= l){
            int middle = l + (r - l) * ((wantedInt- array[l])/(array[r] -  array[l] ));


            if(wantedInt == array[middle]) return middle;
            if(wantedInt < array[middle]) return interpolation(array, wantedInt, 0, middle-1 );
            if(wantedInt > array[middle]) return interpolation(array, wantedInt, middle+1, r );




        }

        return -1;
    }




}
