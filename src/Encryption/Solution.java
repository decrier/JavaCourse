package Encryption;

import java.util.Arrays;

public class Solution {

    public static int[] cript(int[] data, int password) {
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[i] ^ password;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 9, 11};
        int password = 8597;

        System.out.println("------------------------------------------");
        System.out.println("Quelle: " + Arrays.toString(data));
        System.out.println();

        int[] encrypted = cript(data, password);
        System.out.println("Verschlüsselt : " + Arrays.toString(encrypted));
        System.out.println();

        int[] decrypted = cript(encrypted, password);
        System.out.println("Entschlüsselt : " + Arrays.toString(decrypted));
    }
}
