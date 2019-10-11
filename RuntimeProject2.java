import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RuntimeProject2 {

	public static void main(String[] args) throws FileNotFoundException {
		File test = new File("line1.txt");
		Scanner tester = new Scanner(test);
		
		//starting main
		int[][][] cor1 = cordinateSystem(tester);
		char[][] graph1 = graph(tester, cor1);
		print(graph1);
		
		//closing files and scanners
		tester.close();
	}
	
	//creates cord system
	public static int[][][] cordinateSystem(Scanner q){

		//making base variables
		int xo;
		int yo;
		int size;
		
		//making Array
		xo = q.nextInt();
		yo = q.nextInt();
		size = q.nextInt();
		
		int[][][] corSystem = new int[size][size][2];
		
		for(int j=0; j<size; j++) {
			for(int i=0; size-i>0; i++) {
				corSystem[size-1-i][j][1] = yo + i;
				corSystem[size-1-i][j][0] = xo + j;
			}
		}
		return corSystem;
	}
	
	//creates graph gui
	public static char[][] graph(Scanner q, int[][][] corSystem){
		
		//making line
		int xi = q.nextInt();
		int yi = q.nextInt();
		int xGrow = q.nextInt();
		int yGrow = q.nextInt();
		
		int[] baseline = new int[2];
		baseline[0] = xi;
		baseline[1] = yi;
		
		while(baseline[0] > corSystem[corSystem.length-1][0][0]) {
			while(baseline[1] > corSystem[corSystem.length-1][0][1]) {
				baseline[1] = baseline[1] - yGrow;
			}
			baseline[0] = baseline[0] - xGrow;
		}
		
		char[][] graph = new char[corSystem.length][corSystem.length];
		
		//building graph
		for(int j=0; baseline[0]<corSystem[0][corSystem.length-1][0]; j++) {
			for(int i=0; baseline[1]<corSystem[0][corSystem.length-1][1] ; i++) {
				if((corSystem[i][j][0]==baseline[0]) && (corSystem[i][j][1]==baseline[1])) {
					graph[i][j] = '*';
				}
				else if(corSystem[i][j][0]==0) {
					graph[i][j] = '|';
				}
				else if(corSystem[i][j][1]==0) {
					graph[i][j] = '_';
				}
				else if((corSystem[i][j][0]==0) && (corSystem[i][j][1]==0)) {
					graph[i][j] = '0';
				}
				else {
					graph[i][j] = '-';
				}
				baseline[1] = baseline[1] + yGrow;
			}
			baseline[0] = baseline[0] + xGrow;
		}
		return graph;
	}
	
	//printing out the graph
	public static void print(char[][] graph) {
		for(int j=0; j<graph.length; j++) {
			System.out.println();
			for(int i=0; i<graph.length; i++) {
				System.out.print(graph[i][j]);
			}
		}
	}
}
