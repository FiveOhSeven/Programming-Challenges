package binarymaze2;

public class Node {
	int x;
	int y;
	int length;
	boolean visited;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		length = 999;
		visited = false;
	}

	public void visited() {
		visited = true;
	}

	public void setLength(int length) {
		this.length = length;
	}
}