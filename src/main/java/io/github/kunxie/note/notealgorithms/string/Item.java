package io.github.kunxie.note.notealgorithms.string;

public record Item(String name, int key) {

  @Override
  public String toString() {
    return String.format("{%s, %d}", name, key);
  }
}
