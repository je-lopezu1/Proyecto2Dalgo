public class Graph {
    int vertices;
    int edges;
    Edge[] ad;

    class Edge {
        int src, dst;
    }

    Graph(int v, int e) {
        vertices = v;
        edges = e;
        ad = new Edge[e];
        for (int i = 0; i < e; i++) {
            ad[i] = new Edge();
        }
    }

    public int find(int parent[], int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public void union (int parent[], int x, int y) {
        parent[x] = y;
    }

    public boolean equalSets (Graph coax, Graph optic) {
        int[] coaxSet = new int[coax.vertices];
        int[] opticSet = new int[optic.vertices];

        for (int i = 0; i < coax.vertices; i++) {
            coaxSet[i] = i;
            opticSet[i] = i;
        }

        for (int i = 0; i < coax.edges; i++) {
            int x = coax.find(coaxSet, coax.ad[i].src);
            int y = coax.find(coaxSet, coax.ad[i].dst);

            coax.union(coaxSet, x, y);
        }

        for (int i = 0; i < optic.edges; i++) {
            int x = optic.find(opticSet, optic.ad[i].src);
            int y = optic.find(opticSet, optic.ad[i].dst);

            optic.union(opticSet, x, y);
        }

        for (int i = 0; i < coaxSet.length; i++) {
            if (coaxSet[i] == opticSet[i]) {
                return true;
            }
        }
        return false;
    }
}
