package io.github.kunxie.note.notealgorithms.string;

public class KnuthMorrisPrattAlgorithm {



  public int[] generateLPSArray(String pattern) {
    int[] lps = new int[pattern.length()];

    int len = 0; // length of prefix-suffix
    int i = 1;
    while (i < lps.length) {
      if (pattern.charAt(i) == pattern.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      }
      else {
        if (len != 0) {
          // most important logic here, need to prove the correctness.
          len = lps[len - 1];
        }
        else {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }
}
