import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    int vertices;
    List<List<Integer>> ad;
    int[] components;

    public static void addEdge(int from, int to, List<List<Integer>> g) {
        g.get(from).add(to);
        g.get(to).add(from);
    }

    Graph(int v) {
        vertices = v;
        ad = new ArrayList<>();
        components = new int[v];
        for (int i = 0; i < v; i++) {
            ad.add(i, new LinkedList<>());
            components[i] = -1;
        }
    }

    public void union(int from, int to) {
        if (components[to] == -1) {
            components[to] = components[from];
        } else if (components[from] < components[to]) {
            for (int i = 0; i < vertices; i++) {
                if (components[i] == components[to]) {
                    components[i] = components[from];
                }
            }
        } else {
            for (int i = 0; i < vertices; i++) {
                if (components[i] == components[from]) {
                    components[i] = components[to];
                }
            }
        }
    }

    public static boolean equalSets(Graph coax, Graph optic, int src, int dst, int type) {
        if (type == 1) {
            if (coax.components[src] == -1) {
                coax.components[src] = src;
            }
            coax.union(src, dst);
        } else {
            if (optic.components[src] == -1) {
                optic.components[src] = src;
            }
            optic.union(src, dst);
        }

        for (int i = 0; i < coax.vertices; i++) {
            if (coax.components[i] != optic.components[i]) {
                return false;
            }
        }
        return true;

    }
}
