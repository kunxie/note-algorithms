package io.github.kunxie.note.notealgorithms.string;

public record Item(int key, String name) {

  @Override
  public String toString() {
    return String.format("{%d, %s}", key, name);
  }
}
