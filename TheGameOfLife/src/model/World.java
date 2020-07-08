package model;

import java.util.Random;

public class World {
	private int rows;
	private int columns;
	private boolean[][] grid;
	
	public World(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		grid = new boolean[rows][columns];
	}
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public boolean getCell(int row, int col) {
		return grid[row][col];
	}
	
	public void setCell(int row, int col, boolean status) {
		grid[row][col] = status;
	}

	public void randomize() {
		Random random = new Random();
		int randomNumRows = random.nextInt(this.rows)+1;
		int randomNumCols = random.nextInt(this.columns)+1;
		int[] rows = new int[randomNumRows];
		int[] cols = new int[randomNumCols];
		
		for(int i = 0; i< rows.length; i++) {
			rows[i] = random.nextInt(randomNumRows);
		}
		
		for(int i = 0; i < cols.length; i++) {
			cols[i] = random.nextInt(randomNumCols);
		}
		
		for (int col = random.nextInt(randomNumRows); col < cols.length; col++) {
			for (int row = random.nextInt(randomNumRows); row < rows.length; row++) {
				setCell(row, col, true);
			}
		}
		
	}

	public void clear() {
		for (int col = 0; col < getColumns(); col++) {
			for (int row = 0; row < getRows(); row++) {
				setCell(row, col, false);
			}
		}
		
	}
}
