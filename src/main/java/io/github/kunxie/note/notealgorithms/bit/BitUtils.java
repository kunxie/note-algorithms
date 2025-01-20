package io.github.kunxie.note.notealgorithms.bit;

/**
 * Common Bit Tricks
 */
public class BitUtils {

    private BitUtils() {
    }

    public static boolean isEven(int num) {
        // odd: (num & 1) == 1;
        return (num & 1) == 0;
    }

    public static int turnOffKthBit(int num, int k) {
        return num & ~(1 << k);
    }

    public static int turnOnKthBit(int num, int k) {
        return num | (1 << k);
    }

    public static int toggleKthBit(int num, int k) {
        return num ^ (1 << k);
    }

    // turn if kth bit is set bit, otherwise false
    public static boolean checkKthBit(int num, int k) {
        return (num & (1 << k)) != 0;
    }

    public static int clearRightMostSetBit(int num) {
        return num & (num - 1);
    }

    public static int extractRightMostSetBit(int num) {
        return num & (-num);
    }

    public static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num &= num - 1; // clear right most set bit
        }
        return count;
    }

    public static boolean isPowerOfTwo(int num) {
        // after clear right most set bit, num becomes 0.
        return num > 0 && (num & (num - 1)) == 0;
    }

    public static void swap(int i, int j, int[] array) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}
