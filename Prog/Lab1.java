package main.java.ru.itmo.lab;

import java.util.Random;

public class Lab1 {
    public static void main(String[] args) {
        short[] w = makeW();
        float[] x = makeX();

        double[][] result = makeMatrix(w, x);

        printMatrix(result);
    }

    public static short[] makeW() {
        short[] w = new short[8];
        short value = 7;
        for (int i = 0; i < 8; i++) {
            w[i] = value;
            value += 2;
        }
        return w;
    }

    public static float[] makeX() {
        float[] x = new float[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            x[i] = -6.0f + random.nextFloat() * 11.0f;
        }
        return x;
    }

    public static double[][] makeMatrix(short[] w, float[] x) {
        double[][] arr = new double[8][20];

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < x.length; j++) {
                double xv = x[j];

                if (w[i] == 9) {
                    arr[i][j] = Math.log(Math.sqrt(Math.pow(Math.abs(xv), xv)));
                } else if (w[i] == 13 || w[i] == 15 || w[i] == 17 || w[i] == 19) {
                    arr[i][j] = Math.log(Math.pow(Math.cos(Math.tan(xv) - 1), 2));
                } else {
                    arr[i][j] = Math.pow(
                            Math.atan(
                                    Math.cos(
                                            Math.pow(
                                                    Math.pow(xv / Math.pow(2, xv) + 1, 3),
                                                    (3.0 / 4.0) * (2 + Math.pow(xv, 3))
                                            )
                                    )
                            ),
                            2
                    );
                }
            }
        }

        return arr;
    }

    public static void printMatrix(double[][] matrix) {
        int cols = matrix[0].length;
        int cellWidth = 8;

        for (double[] row : matrix) {
            for (double num : row) {
                System.out.printf("%8.2f ", num);
            }
            System.out.println();
        }
    }
}
