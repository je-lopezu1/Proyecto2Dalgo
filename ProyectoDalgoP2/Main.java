import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		try {
			File file = new File("prueba.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			int size = Integer.parseInt(br.readLine());
			Map<Integer, ArrayList<ArrayList<Integer>>> casos = new HashMap<>();
			for (int i = 0; i < size; i++) {
				String[] line = br.readLine().split(" ");
				int n = Integer.parseInt(line[0]);
				int m = Integer.parseInt(line[1]);
				ArrayList<ArrayList<ArrayList<Integer>>> caso = Main.crearListasAdyacencia(n);
				for (int j = 0; j < m; j++) {
					String[] ejes = br.readLine().split(" ");
					if (ejes[2].equals("1")) {
						caso.get(0).get(Integer.parseInt(ejes[0]) - 1).add(Integer.parseInt(ejes[1]) - 1);
						caso.get(0).get(Integer.parseInt(ejes[1]) - 1).add(Integer.parseInt(ejes[0]) - 1);
					} else {
						caso.get(1).get(Integer.parseInt(ejes[0]) - 1).add(Integer.parseInt(ejes[1]) - 1);
						caso.get(1).get(Integer.parseInt(ejes[1]) - 1).add(Integer.parseInt(ejes[0]) - 1);
					}
					bfs(caso);
				}
				System.out.println(caso, n);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error al abrir el archivo");
		}
	}

	private int bfs(Map<Integer, ArrayList<ArrayList<Integer>>> casos, int n) {
		int[] visitadosOptica = new int[n];
		int[] visitadosCoaxial = new int[n];

		for (int i = 0; i < n; i++) {
			for (int i = 0; i < n; i++) {
				visitadosOptica[i] = 0;
				visitadosCoaxial[i] = 0;
			}
			ArrayList<Integer> cola = new ArrayList<>();
			colaOptica.append(n);
			colaCoaxial.append(n);
			visitadosOptica[n] = 1;
			visitadosCoaxial[n] = 1;
			while (!colaOptica.isEmpty()) {
				int nodo = colaOptica.pop();
				for (int i = 0; i < casos.get(0).get(nodo).size(); i++) {
					if (visitadosOptica[casos.get(0).get(nodo).get(i)] == 0) {
						visitadosOptica[casos.get(0).get(nodo).get(i)] = 1;
						cola.append(casos.get(0).get(nodo).get(i));
					}
				}
			}
			while (!colaCoaxial.isEmpty()) {
				int nodo = colaCoaxial.pop();
				for (int i = 0; i < casos.get(1).get(nodo).size(); i++) {
					if (visitadosCoaxial[casos.get(1).get(nodo).get(i)] == 0) {
						visitadosCoaxial[casos.get(1).get(nodo).get(i)] = 1;
						cola.append(casos.get(1).get(nodo).get(i));
					}
				}
			}
		}
	}

	private static ArrayList<ArrayList<ArrayList<Integer>>> crearListasAdyacencia(int n) {
		ArrayList<ArrayList<ArrayList<Integer>>> caso = new ArrayList<>(n);
		ArrayList<ArrayList<Integer>> coaxial = new ArrayList<>(n);
		ArrayList<ArrayList<Integer>> optica = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			coaxial.add(new ArrayList<Integer>());
			optica.add(new ArrayList<Integer>());
		}
		caso.add(optica);
		caso.add(coaxial);
		return caso;
	}
}
