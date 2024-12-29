package io.github.kunxie.note.notealgorithms.string;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BruteforceSubstringSearchTest {

  BruteforceSubstringSearch bruteforceSubstringSearch;

  @BeforeEach
  void setUp() {
    bruteforceSubstringSearch = new BruteforceSubstringSearch();
  }

  @Test
  void search1() {
    var result = bruteforceSubstringSearch.search1("ABRA", "ABACADABRAC");
    assertEquals(6, result);
  }

  @Test
  void search2() {
    var result = bruteforceSubstringSearch.search2("ABRA", "ABACADABRAC");
    assertEquals(6, result);
  }
}
