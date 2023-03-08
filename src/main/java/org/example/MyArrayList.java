package org.example;

import java.util.ArrayList;

public class Array {

    private int[] items;
    private int count;

    public Array(int size) {
        this.items = new int[size];
    }

    public int max() {
        int max = -1;

        for (int i=0; i<count; i++) {
            if(items[i] > items[i+1]){
                max = items[i+1];
            } else {
                max = items[i];
            }
        }
        return max;
    }

    public void print(){
        for (int i=0; i<count; i++){
            System.out.println(items[i]);
        }
    }

    public void insert(int item) {

        if (items.length==count){

            int[] newItems = new int[count * 2];

            for(int i=0; i< count; i++){
                newItems[i] = items[i];
            }
            items = newItems;
        }

        items[count++] = item;

    }

    public void removeAt(int index) {

        //10 20 30 40 50

        if (index <0 || index >= count){
            throw new IllegalArgumentException("Given index is out of bound");
        }

        for(int i = index; i<count ; i++){

            if (i+1 != count) {
                items[i] = items[i + 1];
            }
        }
        count--;
    }

    public int indexOf(int item) {

        for(int i = 0; i<count ; i++){
          if (items[i]==item){
              return i;
          }
        }

        return -1;
    }

    public Array intersect(Array list2) {
        Array commonList = new Array(10);

        for(int i = 0; i<this.count ; i++){
            for(int j = 0; j<list2.count ; j++){

                if (this.items[i]==list2.items[j]) {
                    commonList.insert(this.items[i]);
                }
            }
        }


        return commonList;
    }

    public void reverse() {
        Array reverseList = new Array(10);

        for(int i = count-1; i >= 0 ; i--){
            reverseList.insert(items[i]);
        }
        items = reverseList.items;
    }

    public void insertAt(int item, int index) {
        int[] newItems = new int [count+1];

        for(int i = 0; i <count ; i++){
            if (i < index){
                newItems[i] = items[i];
            } else if (i == index){
                newItems[i] = item;
                newItems[i+1] = items[i];
            } else {
                newItems[i+1] = items[i];
            }
        }
        items = newItems;
        count++;
    }
}