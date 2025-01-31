package io.github.kunxie.note.notealgorithms.graph;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GraphProviders {

    /**
     * Provide the graph from Figure 20.3 on CLRS.
     *
     * @return The graph map in Java
     */
    public static Map<Character, Set<Character>> graph_20_3() {
        return Map.of(
            's', Set.of('r', 'v', 'u'),
            'r', Set.of('w', 's', 't'),
            'u', Set.of('t', 's', 'y'),
            'v', Set.of('s', 'y', 'w'),
            't', Set.of('u', 'r'),
            'y', Set.of('u', 'v', 'x'),
            'w', Set.of('r', 'v', 'x', 'z'),
            'x', Set.of('w', 'y', 'z'),
            'z', Set.of('w', 'x')
        );
    }
}
