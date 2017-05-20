/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarymaze;

import java.util.*;

/**
 *
 * @author Andrew Whang
 */
public class BinaryMaze {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		int[][] x = {{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}};
		System.out.println(answer(x));
	}

	public static int answer(int[][] maze) {
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

		ArrayList<Node> queue = new ArrayList<>();
		map[0][0].setLength(1);
		map[0][0].visited();
		map[0][0].lowerRight();
		queue.add(map[0][0]);
		while (queue.size() > 0) {
			if (goodMove(map, queue.get(0).x + 1, queue.get(0).y)) {
				queue.add(map[queue.get(0).y][queue.get(0).x + 1]);
				map[queue.get(0).y][queue.get(0).x + 1].visited();
				map[queue.get(0).y][queue.get(0).x + 1].lowerRight();
				map[queue.get(0).y][queue.get(0).x + 1].setLength(queue.get(0).length + 1);
			}
			if (goodMove(map, queue.get(0).x - 1, queue.get(0).y)) {
				queue.add(map[queue.get(0).y][queue.get(0).x - 1]);
				map[queue.get(0).y][queue.get(0).x - 1].visited();
				map[queue.get(0).y][queue.get(0).x - 1].lowerRight();
				map[queue.get(0).y][queue.get(0).x - 1].setLength(queue.get(0).length + 1);
			}
			if (goodMove(map, queue.get(0).x, queue.get(0).y + 1)) {
				queue.add(map[queue.get(0).y + 1][queue.get(0).x]);
				map[queue.get(0).y + 1][queue.get(0).x].visited();
				map[queue.get(0).y + 1][queue.get(0).x].lowerRight();
				map[queue.get(0).y + 1][queue.get(0).x].setLength(queue.get(0).length + 1);
			}
			if (goodMove(map, queue.get(0).x, queue.get(0).y - 1)) {
				queue.add(map[queue.get(0).y - 1][queue.get(0).x]);
				map[queue.get(0).y - 1][queue.get(0).x].visited();
				map[queue.get(0).y - 1][queue.get(0).x].lowerRight();
				map[queue.get(0).y - 1][queue.get(0).x].setLength(queue.get(0).length + 1);
			}
			queue.remove(0);
		}

		if (map[maze.length - 1][maze[0].length - 1].length == 999) {
			queue.clear();
			map[maze.length - 1][maze[0].length - 1].setLength(1);
			map[maze.length - 1][maze[0].length - 1].visited();
			queue.add(map[maze.length - 1][maze[0].length - 1]);
			int low = 999;
			while (queue.size() > 0) {
				int[][] direction = {{1, -1, 0, 0}, {0, 0, 1, -1}};
				for (int i = 0; i < 4; i++) {
					if (queue.get(0).y + direction[1][i] >= 0 && queue.get(0).x + direction[0][i] >= 0 && queue.get(0).y + direction[1][i] < map.length && queue.get(0).x + direction[0][i] < map[0].length) {
						if (map[queue.get(0).y + direction[1][i]][queue.get(0).x + direction[0][i]] == null) {
							for (int k = 0; k < 4; k++) {
								if (queue.get(0).y + direction[1][i] + direction[1][k] >= 0 && queue.get(0).x + direction[0][i] + direction[0][k] >= 0 && queue.get(0).y + direction[1][i] + direction[1][k] < map.length && queue.get(0).x + direction[0][i] + direction[0][k] < map[0].length) {
									if (!(map[queue.get(0).y + direction[1][i] + direction[1][k]][queue.get(0).x + direction[0][i] + direction[0][k]] == null) && !map[queue.get(0).y + direction[1][i] + direction[1][k]][queue.get(0).x + direction[0][i] + direction[0][k]].lowerLeft) {
										int temp = map[queue.get(0).y + direction[1][i] + direction[1][k]][queue.get(0).x + direction[0][i] + direction[0][k]].length + queue.get(0).length + 1;
										if (temp < low) {
											low = temp;
										}
									}
								}
							}
						}
					}
				}
				if (goodMove(map, queue.get(0).x + 1, queue.get(0).y)) {
					queue.add(map[queue.get(0).y][queue.get(0).x + 1]);
					map[queue.get(0).y][queue.get(0).x + 1].visited();
					map[queue.get(0).y][queue.get(0).x + 1].setLength(queue.get(0).length + 1);
				}
				if (goodMove(map, queue.get(0).x - 1, queue.get(0).y)) {
					queue.add(map[queue.get(0).y][queue.get(0).x - 1]);
					map[queue.get(0).y][queue.get(0).x - 1].visited();
					map[queue.get(0).y][queue.get(0).x - 1].setLength(queue.get(0).length + 1);
				}
				if (goodMove(map, queue.get(0).x, queue.get(0).y + 1)) {
					queue.add(map[queue.get(0).y + 1][queue.get(0).x]);
					map[queue.get(0).y + 1][queue.get(0).x].visited();
					map[queue.get(0).y + 1][queue.get(0).x].setLength(queue.get(0).length + 1);
				}
				if (goodMove(map, queue.get(0).x, queue.get(0).y - 1)) {
					queue.add(map[queue.get(0).y - 1][queue.get(0).x]);
					map[queue.get(0).y - 1][queue.get(0).x].visited();
					map[queue.get(0).y - 1][queue.get(0).x].setLength(queue.get(0).length + 1);
				}
				queue.remove(0);
			}
			return low;
		}
		int shortestPath = map[maze.length - 1][maze[0].length - 1].length;
		int biggest = 0;
		for (int y = 0; y < maze.length; y++) {

			for (int x = 0; x < maze[0].length; x++) {
				if (map[y][x] == null) {}
				else {
					if(map[y][x].length >= shortestPath){
						continue;
					}
					int[][] direction = {{1, -1, 0, 0}, {0, 0, 1, -1}};
					for (int i = 0; i < 4; i++) {
						if (y + direction[1][i] >= 0 && x + direction[0][i] >= 0 && y + direction[1][i] < map.length && x + direction[0][i] < map[0].length) {
							if (map[y + direction[1][i]][x + direction[0][i]] == null) {
								for (int k = 0; k < 4; k++) {
									if (y + direction[1][i] + direction[1][k] >= 0 && x + direction[0][i] + direction[0][k] >= 0 && y + direction[1][i] + direction[1][k] < map.length && x + direction[0][i] + direction[0][k] < map[0].length) {
										if (!(map[y + direction[1][i] + direction[1][k]][x + direction[0][i] + direction[0][k]] == null) && map[y + direction[1][i] + direction[1][k]][x + direction[0][i] + direction[0][k]].length > map[y][x].length && map[y + direction[1][i] + direction[1][k]][x + direction[0][i] + direction[0][k]].length < 999){
											int temp = map[y + direction[1][i] + direction[1][k]][x + direction[0][i] + direction[0][k]].length - map[y][x].length - 2;
											System.out.println(map[y + direction[1][i] + direction[1][k]][x + direction[0][i] + direction[0][k]].y + " " + map[y + direction[1][i] + direction[1][k]][x + direction[0][i] + direction[0][k]].x);
											System.out.println(temp);
											if(temp > biggest){
												biggest = temp;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return shortestPath - biggest;
	}

	public static boolean goodMove(Node[][] map, int x, int y) {
		if (x >= map[0].length || y >= map.length || x < 0 || y < 0 || map[y][x] == null || map[y][x].visited) {
			return false;
		} else {
			return true;
		}
	}

}
