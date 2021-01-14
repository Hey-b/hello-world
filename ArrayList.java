package com.jiachunhao.list;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> implements List<T>{
    Object[] arr;
    public ArrayList() {
        arr = new Object[12];
    }

    public ArrayList(int i) {
        arr = new Object[i];
    }

    int count = 0;

    //判断下标是否有效

    boolean verifyIndex(int index){

        return index<count&&index>=0;
    }

    @Override
    public void add(T t) {
        if(count>=size()){
            arr = Arrays.copyOf(arr, size() + size() >> 1);
        }
        arr[count++]=t;
    }

    @Override
    public void remove(int index) {
        if(verifyIndex(index)){
            System.arraycopy(arr, index+1, arr, index, arr.length-index-1);

            arr[--count]=null;
        }else{
            System.out.println("下标不正确");
        }
    }

    @Override
    public void remove(T t) {
        int i = indexOf(t);
        remove(i);
    }

    @Override
    public void set(int index, T t) {
        if(verifyIndex(index)){
            arr[index]=t;

        }else{
            System.out.println("下标不正确");
        }
    }

    @Override
    public T get(int index) {
        if(verifyIndex(index)) {
            return (T) arr[index];
        }else {
            return null;
        }
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public int indexOf(T t) {
        if(t==null){
            for (int i = 0; i < count; i++) {
                if(t==arr[i]){
                    return i;
                }
            }
        }else{
            for (int i = 0; i < arr.length; i++) {
                if(t.equals(arr[i])){
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public boolean contains(T t) {

        return indexOf(t)!=-1;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public String toString() {
        String s ="[";
        for (int i = 0; i < count-1; i++) {
            s+=arr[i]+"，";
        }
        s+=arr[count-1]+"]";

        return s;
    }

    private class Itr<T> implements Iterator<T>{
        int biao;

        @Override
        public boolean hasNext() {
            return biao!=count;
        }

        @Override
        public T next() {
            return (T)arr[biao++];
        }
    }
}
