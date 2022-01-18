import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a description of class TSP here.
 *
 * @author Lukas Breuer
 * @version 17.01.2022
 */
public class TSP {

	private Graph germany = new Graph();
	private Vertex berlin = new Vertex("Berlin");
	private Vertex dortmund = new Vertex("Dortmund");
	private Vertex frankfurt = new Vertex("Frankfurt");
	private Vertex gelsenkirchen = new Vertex("Gelsenkirchen");
	private Vertex hamburg = new Vertex("Hamburg");
	private Vertex hannover = new Vertex("Hannover");
	private Vertex kaiserslautern = new Vertex("Kaiserslautern");
	private Vertex koeln = new Vertex("Köln");
	private Vertex leipzig = new Vertex("Leipzig");
	private Vertex muenchen = new Vertex("München");
	private Vertex nuernberg = new Vertex("Nürnberg");
	private Vertex stuttgart = new Vertex("Stuttgart");

	public TSP(String startZiel, String zwischenziel1, String zwischenziel2, String zwischenziel3, String zwischenziel4, String zwischenziel5) {
		createGraph();
		resultOutput(startZiel, zwischenziel1, zwischenziel2, zwischenziel3, zwischenziel4, zwischenziel5,
				calculate(generatePerm(new ArrayList<>(Arrays.asList(zwischenziel1, zwischenziel2, zwischenziel3, zwischenziel4, zwischenziel5))), startZiel));
	}

	private double calculate(ArrayList<ArrayList<String>> permutations, String startZiel) {
		double distance = Double.MAX_VALUE;
		Vertex start = germany.getVertex(startZiel);
		for (ArrayList<String> list : permutations) {
			Edge startEdge = germany.getEdge(start, germany.getVertex(list.get(0)));
			Edge endEdge = germany.getEdge(germany.getVertex(list.get(4)), start);
			double temp = startEdge.getWeight() + endEdge.getWeight();
			for (int i = 0; i < 4; i++) {
				Vertex v1 = germany.getVertex(list.get(i));
				Vertex v2 = germany.getVertex(list.get(i + 1));
				Edge edge = germany.getEdge(v1, v2);
				temp += edge.getWeight();
			}
			if (temp > 0 && temp < distance) {
				distance = temp;
			}
		}
		return distance;
	}

	private ArrayList<ArrayList<String>> generatePerm(ArrayList<String> list) {
		if (list.isEmpty()) {
			ArrayList<ArrayList<String>> result = new ArrayList<>();
			result.add(new ArrayList<>());
			return result;
		}
		String firstElement = list.remove(0);
		ArrayList<ArrayList<String>> returnValue = new ArrayList<>();
		ArrayList<ArrayList<String>> permutations = generatePerm(list);
		for (ArrayList<String> smallerPermutated : permutations) {
			for (int index = 0; index <= smallerPermutated.size(); index++) {
				ArrayList<String> temp = new ArrayList<>(smallerPermutated);
				temp.add(index, firstElement);
				returnValue.add(temp);
			}
		}
		return returnValue;
	}

	private void resultOutput(String startZiel, String zwischenziel1, String zwischenziel2, String zwischenziel3, String zwischenziel4, String zwischenziel5, double distance) {
		System.out.println("Der Weg von " + startZiel + " über " + zwischenziel1 + ", " + zwischenziel2 + ", "
				+ zwischenziel3 + ", " + zwischenziel4 + ", " + zwischenziel5 + " hat eine Gesamtlänge von " + distance
				+ "km.");
	}

	private void createGraph() {
		germany.addVertex(berlin);
		germany.addVertex(dortmund);
		germany.addVertex(frankfurt);
		germany.addVertex(gelsenkirchen);
		germany.addVertex(hamburg);
		germany.addVertex(hannover);
		germany.addVertex(kaiserslautern);
		germany.addVertex(koeln);
		germany.addVertex(leipzig);
		germany.addVertex(muenchen);
		germany.addVertex(nuernberg);
		germany.addVertex(stuttgart);
		germany.addEdge(new Edge(berlin, dortmund, 422));
		germany.addEdge(new Edge(berlin, frankfurt, 424));
		germany.addEdge(new Edge(berlin, gelsenkirchen, 446));
		germany.addEdge(new Edge(berlin, hamburg, 256));
		germany.addEdge(new Edge(berlin, hannover, 250));
		germany.addEdge(new Edge(berlin, koeln, 478));
		germany.addEdge(new Edge(berlin, leipzig, 150));
		germany.addEdge(new Edge(berlin, muenchen, 505));
		germany.addEdge(new Edge(berlin, nuernberg, 378));
		germany.addEdge(new Edge(berlin, stuttgart, 512));
		germany.addEdge(new Edge(dortmund, frankfurt, 175));
		germany.addEdge(new Edge(dortmund, gelsenkirchen, 26));
		germany.addEdge(new Edge(dortmund, hamburg, 284));
		germany.addEdge(new Edge(dortmund, hannover, 182));
		germany.addEdge(new Edge(dortmund, kaiserslautern, 231));
		germany.addEdge(new Edge(dortmund, koeln, 73));
		germany.addEdge(new Edge(dortmund, leipzig, 340));
		germany.addEdge(new Edge(dortmund, muenchen, 477));
		germany.addEdge(new Edge(dortmund, nuernberg, 343));
		germany.addEdge(new Edge(dortmund, stuttgart, 328));
		germany.addEdge(new Edge(frankfurt, gelsenkirchen, 189));
		germany.addEdge(new Edge(frankfurt, hamburg, 391));
		germany.addEdge(new Edge(frankfurt, hannover, 260));
		germany.addEdge(new Edge(frankfurt, kaiserslautern, 122));
		germany.addEdge(new Edge(frankfurt, koeln, 150));
		germany.addEdge(new Edge(frankfurt, leipzig, 293));
		germany.addEdge(new Edge(frankfurt, muenchen, 477));
		germany.addEdge(new Edge(frankfurt, nuernberg, 343));
		germany.addEdge(new Edge(frankfurt, stuttgart, 155));
		germany.addEdge(new Edge(gelsenkirchen, hamburg, 300));
		germany.addEdge(new Edge(gelsenkirchen, hannover, 204));
		germany.addEdge(new Edge(gelsenkirchen, kaiserslautern, 235));
		germany.addEdge(new Edge(gelsenkirchen, koeln, 64));
		germany.addEdge(new Edge(gelsenkirchen, leipzig, 366));
		germany.addEdge(new Edge(gelsenkirchen, muenchen, 494));
		germany.addEdge(new Edge(gelsenkirchen, nuernberg, 363));
		germany.addEdge(new Edge(gelsenkirchen, stuttgart, 338));
		germany.addEdge(new Edge(hamburg, hannover, 133));
		germany.addEdge(new Edge(hamburg, koeln, 357));
		germany.addEdge(new Edge(hamburg, leipzig, 294));
		germany.addEdge(new Edge(hamburg, muenchen, 612));
		germany.addEdge(new Edge(hamburg, nuernberg, 462));
		germany.addEdge(new Edge(hamburg, stuttgart, 534));
		germany.addEdge(new Edge(hannover, kaiserslautern, 353));
		germany.addEdge(new Edge(hannover, koeln, 245));
		germany.addEdge(new Edge(hannover, leipzig, 260));
		germany.addEdge(new Edge(hannover, muenchen, 489));
		germany.addEdge(new Edge(hannover, nuernberg, 338));
		germany.addEdge(new Edge(hannover, stuttgart, 401));
		germany.addEdge(new Edge(kaiserslautern, koeln, 176));
		germany.addEdge(new Edge(kaiserslautern, leipzig, 388));
		germany.addEdge(new Edge(kaiserslautern, muenchen, 314));
		germany.addEdge(new Edge(kaiserslautern, nuernberg, 239));
		germany.addEdge(new Edge(kaiserslautern, stuttgart, 127));
		germany.addEdge(new Edge(koeln, leipzig, 380));
		germany.addEdge(new Edge(koeln, muenchen, 456));
		germany.addEdge(new Edge(koeln, nuernberg, 336));
		germany.addEdge(new Edge(koeln, stuttgart, 288));
		germany.addEdge(new Edge(leipzig, muenchen, 361));
		germany.addEdge(new Edge(leipzig, nuernberg, 229));
		germany.addEdge(new Edge(leipzig, stuttgart, 365));
		germany.addEdge(new Edge(muenchen, nuernberg, 151));
		germany.addEdge(new Edge(muenchen, stuttgart, 190));
		germany.addEdge(new Edge(nuernberg, stuttgart, 157));
	}
}
