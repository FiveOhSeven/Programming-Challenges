package binarymaze2;

import java.util.ArrayList;

public class BinaryMaze2 {

	public static void main(String[] args) {
		int[][] x = {{0,0,0,0,0,0},{1,1,1,1,1,0},{0,0,0,0,0,0},{0,1,1,1,1,1},{0,1,1,1,1,1},{0,0,0,0,0,0}};
		System.out.println(answer(x));
	}

	public static int answer(int[][] maze) {
		int shortestPath = 999;
		for (int y = 0; y < maze.length; y++) {
			for (int x = 0; x < maze[0].length; x++) {
				if(maze[y][x] == 1){
					maze[y][x] = 0;
					int temp = shortestPath(newMap(maze));
					maze[y][x] = 1;
					if(temp < shortestPath){
						shortestPath = temp;
						if(shortestPath == maze.length + maze[0].length - 1){
							return shortestPath;
						}
					}
				}
			}
		}
		return shortestPath;
	}

	public static int shortestPath(Node[][] map){
		int[][] dir = {{1, -1, 0, 0}, {0, 0, 1, -1}};
		ArrayList<Node> queue = new ArrayList<>();
		map[0][0].setLength(1);
		map[0][0].visited();
		queue.add(map[0][0]);
		while (queue.size() > 0) {
			for(int vec = 0; vec < 4; vec++){
				int x = queue.get(0).x+dir[0][vec];
				int y = queue.get(0).y+dir[1][vec];
				if(x>=0 && y>=0 && x<map[0].length && y<map.length && map[y][x]!=null && !map[y][x].visited){
					queue.add(map[y][x]);
					map[y][x].visited();
					map[y][x].setLength(queue.get(0).length+1);
				}
			}
			queue.remove(0);
		}
		return map[map.length-1][map[0].length-1].length;
	}
	
	public static Node[][] newMap(int[][] maze){
		Node[][] map = new Node[maze.length][maze[0].length];
		for (int y = 0; y < maze.length; y++) {
			for (int x = 0; x < maze[0].length; x++) {
				if (maze[y][x] == 0) {
					map[y][x] = new Node(x, y);
				} else {
					map[y][x] = null;
				}
			}
		}
		return map;
	}
}
