import java.util.ArrayList;
import java.util.Arrays;

public class Dfs {
    
    private ArrayList<ArrayList<Integer>> adjList;
    private int[] visited;
    private int[] component;
    private int componentsCount;
    
    public void findConnectedComponents(ArrayList<ArrayList<Integer>> adjList) {
        this.adjList = adjList;
        int n = adjList.size();
        visited = new int[n];
        component = new int[n];
        componentsCount = 0;
        
        Arrays.fill(visited, -1);
        Arrays.fill(component, -1);
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                dfs(i, componentsCount);
                componentsCount++;
            }
        }
    }
    
    private void dfs(int node, int comp) {
        visited[node] = 1;
        component[node] = comp;
        
        for (int neighbor : adjList.get(node)) {
            if (visited[neighbor] == -1) {
                dfs(neighbor, comp);
            }
        }

        if (node != component[node]) {
            component[node] = component[component[node]];
        }
    }
    
    public int[] getComponents() {
        return component;
    }
    
    public int getComponentsCount() {
        return componentsCount;
    }
}