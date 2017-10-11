package sw.pro.SDS_PRO_6_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source3 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Piece start = new Piece(0, '-', null);
		Piece end = start;

		char[] testcase = br.readLine().toCharArray();
		int i;
		for (i = 1; i <= n; i++) {
			end.next = new Piece(i, testcase[i - 1], null);
			end.next.previous = end;
			end = end.next;
		}
		end.next = new Piece(500, '-', null);
		end.next.previous = end;
		end = end.next;
		br.close();
		i = 1;
		Piece head = start.next;
		Piece tail = end.previous;
		int total = 0;
		while (start.next.index != end.index) {
			// start = start.next; System.out.print(start.color + "->");
			
			if (head.index >= tail.index) {
				i++;
				head = start.next;
				tail = end.previous;
				continue;
			} else {
				if (tail.color == tail.previous.color) {
					tail = tail.previous;
				} else {
					total += (i << 1) + (tail.index - tail.previous.index);
					//System.out.print(tail.previous.index + "-" + tail.index + ",("+i+")|" + total);
					tail.previous.previous.next = tail.next;
					tail.next.previous = tail.previous.previous;
					tail = tail.previous.previous;
					//System.out.println(",tail:"+tail.index);
				}
			}

		}
		System.out.println(total);
	}

	static class Piece {
		int		index;
		char	color;
		Piece	next;
		Piece	previous;

		Piece(final int i, final char c, final Piece n) {
			index = i;
			color = c;
			next = n;
		}
	}
}
