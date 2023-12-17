package lab2.matrixHandler;

import java.util.*;

public final class DoubleMatrix {
    private final double [][] matrix;
    public final double arr[];
    public int m;
    public int n;

    public DoubleMatrix(double [] a, int m, int n) throws InsufficientElementsException {
        this.m = m;
        this.n = n;
        if(a.length < m * n) {
            throw new InsufficientElementsException();
        }

        this.arr = Arrays.copyOfRange(a, a.length - m * n, a.length);
        matrix = new double[m][n];

        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arr[idx++];
            }
        }
    }

    public String getDimensions(){
        return String.format("[" + m  + " x " + n  + "]");
    }

    public int rows(){
        return m;
    }

    public int columns(){
        return n;
    }

    public double maxElementAtRow(int row) throws InvalidRowNumberException {
        if(row < 1 || row > m) {
            throw new InvalidRowNumberException();
        }

        double max = matrix[row - 1][0];
        for(int i = 1; i < n; i++) {
            if(matrix[row - 1][i] > max) {
                max = matrix[row - 1][i];
            }
        }
        return max;
    }

    public double maxElementAtColumn(int column) throws InvalidColumnNumberException {
        if(column < 1 || column > n) {
            throw new InvalidColumnNumberException();
        }


        double max = matrix[0][column - 1];
        for(int i = 1; i < m; i++) {
            if(matrix[i][column - 1] > max) {
                max = matrix[i][column - 1];
            }
        }
        return max;
    }

    public double sum() {
        double sum = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public double[] toSortedArray() {
        double[] sortedArrAsc = Arrays.copyOf(arr, arr.length);
        double[] sortedArrDsc = new double[arr.length];

        Arrays.sort(sortedArrAsc);
        int len = sortedArrAsc.length;

        for (int i = len - 1; i >= 0; i--) {
            sortedArrDsc[len - 1 - i] = sortedArrAsc[i];
        }

        return sortedArrDsc;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result.append(String.format("%.2f", matrix[i][j]));
                if (j < n - 1) {
                    result.append('\t');
                }
            }
            if (i < m - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleMatrix that = (DoubleMatrix) o;
        return m == that.m && n == that.n && Arrays.equals(arr, that.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(m, n);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }
}