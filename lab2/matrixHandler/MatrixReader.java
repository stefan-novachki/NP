package lab2.matrixHandler;

import java.io.InputStream;
import java.util.*;

public class MatrixReader {
    public static DoubleMatrix read(InputStream input) throws InsufficientElementsException {
        Scanner scanner = new Scanner(input);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int len = m * n;

        double [] arr = new double[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextDouble();
        }

        return new DoubleMatrix(arr, m, n);
    }
}