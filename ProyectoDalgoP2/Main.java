import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int size = Integer.parseInt(br.readLine());

			for (int i = 0; i < size; i++) {
				String[] line = br.readLine().split(" ");
				int n = Integer.parseInt(line[0]);
				int m = Integer.parseInt(line[1]);

				Graph coaxial = new Graph(n);
				Graph opti = new Graph(n);

				for (int j = 0; j < m; j++) {
					String[] ejes = br.readLine().split(" ");

					if (ejes[2].equals("1")) {
						Graph.addEdge(Integer.parseInt(ejes[0]) - 1, Integer.parseInt(ejes[1]) - 1, coaxial.ad);
					} else {
						Graph.addEdge(Integer.parseInt(ejes[0]) - 1, Integer.parseInt(ejes[1]) - 1, opti.ad);

					}
					boolean b = Graph.equalSets(coaxial, opti, Integer.parseInt(ejes[0]) - 1,
							Integer.parseInt(ejes[1]) - 1, Integer.parseInt(ejes[2]));
					if (b) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
					if (j != m - 1) {
						System.out.print(" ");
					}

				}
				if (i != size - 1) {
					System.out.println();
				}

			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error al leer los datos de entrada");
		}
	}

}
