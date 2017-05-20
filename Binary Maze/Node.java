/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarymaze;

/**
 *
 * @author Andrew Whang
 */
public class Node {

	int x;
	int y;
	int length;
	boolean visited;
	boolean lowerLeft;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		length = 999;
		visited = false;
		lowerLeft = true;
	}

	public void visited() {
		visited = true;
	}

	public void lowerRight() {
		lowerLeft = false;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
