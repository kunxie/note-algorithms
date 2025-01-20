package io.github.kunxie.note.notealgorithms.bit;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BitUtilsTest {

    @Test
    void test_isEven() {
        var random = new Random();
        for (var i = 0; i < 100; i++) {
            var num = random.nextInt(1_000_000_000);
            assertEquals(BitUtils.isEven(num), num % 2 == 0);
        }
    }

    @Test
    void test_turnOffKthBit() {
        var num = 10;
        var k = 2;

        assertEquals(num & ~(1 << k), BitUtils.turnOffKthBit(num, k));
    }
}