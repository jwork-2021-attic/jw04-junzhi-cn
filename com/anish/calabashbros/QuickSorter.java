package com.anish.calabashbros;

public class QuickSorter<T extends Comparable<T>> implements Sorter<T> {

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
        QuickSort(0, 255);
    }
    private void QuickSort(int left, int right) {
		if(left>=right) {
			return;
		}
		T key=a[left/16][left%16];
		int i=left;
		int j=right;
		while(i<j){
			while((a[j/16][j%16].compareTo(key) >= 0) && i<j){
				j--;
			}
			while((a[i/16][i%16].compareTo(key) <= 0) && i<j){
				i++;
			}
			if(i<j){
				swap(i,j);
			}
		}
       // if (i!=left)
        swap(i,left);
		QuickSort(left,i-1);
		QuickSort(i+1,right);
	}
    @Override
    public String getPlan() {
        return this.plan;
    }

}