
/*
 * You are given a rows * cols chessboard and a knight that moves like in normal chess.
Currently knight is at starting position denoted by start_row th row and start_col th col, and want to reach at ending position denoted by 
end_row th row and end_col th col.  
The goal is to calculate the minimum number of moves that the knight needs to take to get from starting position to ending position.
start_row, start_col, end_row and end_col are 0-indexed. 

 */
import java.util.*;

public class KnightTour {

	public class Vertex {
		int row;
		int col;
		int distance = 0;

		public Vertex(int r, int c) {
			row = r;
			col = c;
		}
	}

	public void find_min_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
		Queue<Vertex> q = new ArrayDeque<Vertex>();
		// int count = 0;
		boolean[][] visited = new boolean[rows][cols];

		q.add(new Vertex(start_row, start_col));
		visited[start_row][start_col] = true;
		int dist = bfs(q, visited, end_row, end_col, rows, cols);

	}

	public int bfs(Queue<Vertex> q, boolean[][] visited, int end_row, int end_col, int rows, int cols) {
		while (!q.isEmpty()) {
			Vertex v = q.poll();
			if (v.row == end_row && v.col == end_col)
				return v.distance;
			for (Vertex neighbor : findNeigbors(v.row, v.col, visited, rows, cols)) {
				if (!visited[neighbor.row][neighbor.col] == true) {
					visited[neighbor.row][neighbor.col] = true;
					q.add(neighbor);
					neighbor.distance = v.distance + 1;
				}
			}
		}
		return 0;
	}

	public List<Vertex> findNeigbors(int r, int c, boolean[][] visited, int rows, int cols) {
		List<Vertex> vertices = new ArrayList<Vertex>();
		int rowNbr[] = new int[] { -2, -2, -1, 1, -1, 1, 2, 2 };
		int colNbr[] = new int[] { -1, 1, -2, -2, 2, 2, -1, 1 };

		for (int k = 0; k < 8; ++k) {
			if (isValid(rows, cols, r + rowNbr[k], c + colNbr[k]))
				vertices.add(new Vertex(r + rowNbr[k], c + colNbr[k]));
		}

		return vertices;
	}

	public boolean isValid(int rows, int cols, int r, int c) {
		return ((r >= 0 && r < rows && c >= 0 && c < cols) ? true : false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
