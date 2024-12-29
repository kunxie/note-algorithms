package io.github.kunxie.note.notealgorithms.string;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BruteforceSubstringSearch {

  /**
   * find the first match of pattern in the text - brute force implementation.
   *
   * @param pattern The substring that we are searching for in the text.
   * @param text    The string in which we are searching for the pattern.
   * @return The first index where the pattern starts in the text. If there is no match, it returns the length of the text.
   */
  public int search1(String pattern, String text) {
    final var M = pattern.length();
    final var N = text.length();
    assert N >= M;

    for (var i = 0; i < N - M; i++) {
      var j = 0;
      for (; j < M; j++) {
        if (text.charAt(i + j) != pattern.charAt(j)) {
          break;
        }
      }
      if (j == M) {
        return i;
      }
    }
    return N;
  }

  /**
   * Find the first match of pattern in the text - a modified brute force implementation.
   *
   * @param pattern The substring that we are searching for in the text.
   * @param text    The string in which we are searching for the pattern.
   * @return The first index where the pattern starts in the text. If there is no match, it returns the length of the text.
   */
  public int search2(String pattern, String text) {
    final var M = pattern.length();
    final var N = text.length();
    assert N >= M;

    int i, j;
    for (i = 0, j = 0; i < N && j < M; i++) {
      if (text.charAt(i) == pattern.charAt(j)) {
        j++;
      } else {
        i -= j;
        j = 0;
      }
    }
    if (j == M) {
      return i - M;
    } else {
      return N;
    }
  }
}
