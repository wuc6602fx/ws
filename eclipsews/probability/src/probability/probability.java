package probability;


import java.util.Scanner;


public class probability {
	public static void main (String[] argc) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		double[] p = new double[20];
		int[] n = new int[20];
		int[] I = new int[20];
		for(int i = 0;i<count;i++) {
			n[i] = scanner.nextInt();
			p[i] = scanner.nextDouble();
			I[i] = scanner.nextInt();
		}
		scanner.close();
		for(int i = 0;i<count;i++) {
			double ans = (Math.pow(1-p[i],I[i]-1) * p[i]) / (1-Math.pow(1-p[i],n[i]));
			System.out.println(String.format("%.4f",ans));
		}
		
		
		
	}
}
