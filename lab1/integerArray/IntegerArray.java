package lab1.integerArray;

import java.util.Arrays;

public final class IntegerArray {
    public final int[] arr;

    public IntegerArray(int[] arr) {
        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public int length(){
        return this.arr.length;
    }

    public int getElementAt(int i){
        return arr[i];
    }

    public int sum() { return Arrays.stream(arr).sum(); }

    public double average() {
        return (double) sum() / length();
    }

    public IntegerArray getSorted() {
        int[] sortedArray = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int j = 0; j < sortedArray.length - 1 - i; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        return new IntegerArray(sortedArray);
    }


    public IntegerArray concat(IntegerArray ia) {
        int[] newArr = new int[length() + ia.length()];

        System.arraycopy(arr, 0, newArr, 0, length());
        System.arraycopy(ia.arr, 0, newArr, length(), ia.length());

        return new IntegerArray(newArr);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < length(); i++) {
            if(i < length() - 1){
                string.append(arr[i]).append(", ");
            } else {
                string.append(arr[i]).append("]");
            }
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() { return Arrays.hashCode(arr); }
}
