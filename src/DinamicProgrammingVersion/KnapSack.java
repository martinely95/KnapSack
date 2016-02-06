package DinamicProgrammingVersion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KnapSack {
	private static int[][] A;
	
	private static int secondDimensionSize;

	private static boolean calculated = false;
	
	private static boolean isCalculated() {
		return calculated;
	}

	private static void setCalculated(boolean calculated) {
		KnapSack.calculated = calculated;
	}
	
	public static Map<String, List<Integer>> getWeightsAndValues(){
		return null;
		
	}
	
	public static void loadEmptyMatrix(int n, int w) {
		secondDimensionSize = w + 1; 
		A = new int[n + 1][w + 1];
	}
	
	public static int loadAndSolveFromFile(String location) throws IOException {
		List<String> file = readSmallTextFile(location);
		loadEmptyMatrix(file.size(), Integer.valueOf(file.get(0)));
		
		List<Integer> weights = new ArrayList<>();
		List<Integer> values = new ArrayList<>();
		for (int i = 1; i < file.size(); i++) {
			String[] line = file.get(i).split(" ");
			//item value weight
			weights.add(Integer.valueOf(line[2]));
			values.add(Integer.valueOf(line[1]));
		}
		
		return solve(weights, values, secondDimensionSize - 1);
	}
	
	public static int solve(List<Integer> weights, List<Integer> values, int w) {
		setCalculated(true);
		int n = weights.size();
		//A = new int[n + 1][w + 1];
		int curr = 0;
		//int currWeight = 0;
		int index = -1;
		
		for (int i = 1; i <= n; i++) {
			for (int x = 0; x <= w; x++) {
				curr = A[i-1][x];
				index = x - weights.get(i-1);
				//currWeight = weights.get(i);
				if (index >= 0) {
					curr = Integer.max(curr, A[i-1][index] + values.get(i-1));
				}
				A[i][x]=curr;
			}
		}
		
		return A[n][w];
	}

	public static String getLastMaxPath() {
		if (!isCalculated()) {
			return null;
		}
		Map<String, List<Integer>> result = getMaxPath();
		StringBuilder resultToReturn = new StringBuilder();
		for (int i = 0; i < A.length; i++) {
			resultToReturn.append("i: " + result.get("i").get(i));
			resultToReturn.append(" x: " + result.get("x").get(i));
			resultToReturn.append(" value: " + result.get("value").get(i));
			resultToReturn.append("\n");
		}
		return resultToReturn.toString();
	}
	
	private static Map<String, List<Integer>> getMaxPath() {
		Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
		List<Integer> n = new ArrayList<Integer>();
		List<Integer> w = new ArrayList<Integer>();
		List<Integer> values = new ArrayList<Integer>();
		 // 0: i, 1: x, 2: A[x][i]
		int x = secondDimensionSize - 1;
		for  (int i = A.length - 1; i >= 0;) { 
			n.add(i);
			w.add(x);
			values.add(A[i][x]);
			i=i-1;
			if (i>=0 && A[i][x] != A[i+1][x]) {
				x = x-i;
			}
			if (x<0) {
				break;
			}
		}
		
		result.put("i", n);
		result.put("x", w);
		result.put("value", values);
		
		return result;
	}
	
	private static List<String> readSmallTextFile(String aFileName) throws IOException {
		//Example: "C:\\Temp\\martinIsDoingHisHomework.txt"
	    Path path = Paths.get(aFileName);
	    return Files.readAllLines(path);
	  }
	
	public static void main(String[] args) throws IOException {		

	}

}
