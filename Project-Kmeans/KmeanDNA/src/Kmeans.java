import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


import mpi.*; 

@SuppressWarnings("unused")
public class Kmeans {
	
	static Boolean n=true;

	@SuppressWarnings({"unchecked"})
	public static void main(String[] args) throws Exception {
		
//		 long startTime = System.currentTimeMillis();
		 long start;
		 double t1, t2; 
		
		
		 
		MPI.Init(args);
		start=(long) MPI.Wtime();
		int numClusters = 5;
		String outputFileP = "./outputPoints.csv";
		String inputFileP = "./input/data_points.csv";
		ArrayList<Point> points = new ArrayList<Point>();
		
		ReadCSV readCSVP = new ReadCSV(inputFileP, Kmeans.point);
		points = readCSVP.read();
		new ClusterPoints(points, outputFileP, numClusters);

		String inputFileD = "./input/dna_strands.csv";
		String outputFileD = "./outputDNA.csv";
//		String outputFileD = "./hello.csv";
		ArrayList<String> dnaStrands = new ArrayList<String>();
		
		ReadCSV readCSVD = new ReadCSV(inputFileD, Kmeans.dna);
		
		dnaStrands = readCSVD.read();
		
		 t1 = MPI.Wtime(); 
		new ClusterDNA(dnaStrands, outputFileD, numClusters);
		t2 = MPI.Wtime(); 
		
		System.out.println( "Elapsed time is "+ String.valueOf(t2 - t1) ); 
		MPI.Finalize(); 
//		System.out.println(startTime);
//		 long stopTime = System.currentTimeMillis();
//	      long elapsedTime = stopTime - startTime;
//	      System.out.println("Elasped"+elapsedTime);
	      
//	      FileWriter writer = new FileWriter("./hello.csv");
//		
//					writer.append("" + elapsedTime);
//					writer.append(',');
//					writer.append("");
//					writer.append('\n');
//					writer.flush();
//				
//			writer.close();
	      
		
	}
	
	public static final char point = 'p';
	public static final char dna = 'd';


}
