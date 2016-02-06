package DinamicProgrammingVersionTests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import DinamicProgrammingVersion.KnapSack;

public class KnapSackTest {
	private List<Integer> weights;
	private List<Integer> values;
	private int w;
	

	@Test
	public void test1() {
		weights = new ArrayList<>(Arrays.asList(4, 3, 2, 3));
		values = new ArrayList<>(Arrays.asList(3, 2, 4, 4));
		w = 6;

		KnapSack.loadEmptyMatrix(weights.size(), w);
		assertEquals(8, KnapSack.solve(weights, values, w));
	}
	
	@Test
	public void test2() {
		weights = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
		values = new ArrayList<>(Arrays.asList(3, 7, 2, 9));
		w = 5;
		KnapSack.loadEmptyMatrix(weights.size(), w);
		assertEquals(10, KnapSack.solve(weights, values, w));
	}
	
	@Test
	public void test3() {
		weights = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
		values = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
		w = 5;
		KnapSack.loadEmptyMatrix(weights.size(), w);
		//System.out.println(solve(weights, values, w));
		assertEquals(7, KnapSack.solve(weights, values, w));
	}
	
	@Test
	public void test4() {
		weights = new ArrayList<>(Arrays.asList(5, 2, 2, 1, 3));
		values = new ArrayList<>(Arrays.asList(4, 4, 5, 2, 8));
		w = 5;
		KnapSack.loadEmptyMatrix(weights.size(), w);
		//System.out.println(solve(weights, values, w));
		assertEquals(13, KnapSack.solve(weights, values, w));
	}
	
	@Test
	public void test5() {
		weights = new ArrayList<>(Arrays.asList(9, 10));
		values = new ArrayList<>(Arrays.asList(5, 4));
		w = 20;
		KnapSack.loadEmptyMatrix(weights.size(), w);
		//System.out.println(solve(weights, values, w));
		assertEquals(9, KnapSack.solve(weights, values, w));
	}
	
	@Test
	public void testSolveFromFile() throws IOException {
		String fileLocation = "martinIsDoingHisHomework.txt";
		assertEquals(10, KnapSack.loadAndSolveFromFile(fileLocation));
	}

}
