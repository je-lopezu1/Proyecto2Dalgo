import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		try {
			File file = new File("prueba.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			int size = Integer.parseInt(br.readLine());
			// Map<Integer, ArrayList<ArrayList<Integer>>> casos = new HashMap<>();
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
					Dfs dfsOptica = new Dfs();
					Dfs dfsCoaxial = new Dfs();
					dfsOptica.findConnectedComponents(caso.get(0));
					dfsCoaxial.findConnectedComponents(caso.get(1));
					System.out.println(Arrays.toString(dfsOptica.getComponents()));
					System.out.println(Arrays.toString(dfsCoaxial.getComponents()));

					System.out.println(caso);
				}

			}
			br.close();
		} catch (Exception e) {
			System.out.println("Error al abrir el archivo");
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
