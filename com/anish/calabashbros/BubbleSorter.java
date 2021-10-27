package com.anish.calabashbros;

public class BubbleSorter<T extends Comparable<T>> implements Sorter<T> {

    private T[][] a;

    @Override
    public void load(T[][] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        T temp;
        temp = a[i/16][i%16];
        a[i/16][i%16] = a[j/16][j%16];
        a[j/16][j%16] = temp;
        plan += "" + a[i/16][i%16] + "<->" + a[j/16][j%16] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < 256 - 1; i++) {
                if (a[i/16][i%16].compareTo(a[(i+1)/16][(i+1)%16]) > 0) {
                    swap(i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}