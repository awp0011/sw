package sw.pro.the3nplus1;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int i, j, answer = 0;
		int start,end;
		long num = 0;
		int middle_result = 0;
		int[] result_table = new int[1000_000];
		while (sc.hasNextInt()) {
			i = sc.nextInt();
			j = sc.nextInt();
			if(j<i){
				start = j;
				end = i;
			}else{
				start = i;
				end = j;
			}
			answer = 0;
			
			for (int n = start; n <= end; n++) {
				num = n;
				middle_result = 1;
				if (result_table[n] > 0) {
					middle_result = result_table[n];
				} else {
					while (num != 1) {
						num = ((num & 1) == 0) ? num = (num >> 1) : (num * 3 + 1);
						middle_result++;
					}
					result_table[n] = middle_result;
				}
				answer = middle_result > answer ? middle_result : answer;
			}
			
			System.out.println(i + " " + j + " " + answer);
		}
		sc.close();
	}
	
}