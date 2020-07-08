package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;

import model.World;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final static int CELLSIZE = 100;
	private final static Color backgroundColor = Color.BLACK;
	private final static Color foregroundColor = Color.GREEN;
	private final static Color gridColor = Color.GRAY;
	private int topBottomMargin;
	private int leftRightMargin;
	private World world;

	public MainPanel() {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				int[] cellCoords = convertCoords(x, y);
				int row = cellCoords[0];
				int col = cellCoords[1];

				if (row >= world.getRows() || row < 0 || col >= world.getColumns() || col < 0) {
					return;
				}

				if (world.getCell(row, col)) {
					world.setCell(row, col, false);
				} else {
					world.setCell(row, col, true);
				}

				repaint();
			}
		});

	}

	protected void clear() {
		world.clear();
		
		repaint();
	}

	protected void randomize() {
		world.randomize();
		
		repaint();
	}

	protected void next() {

	}

	protected int[] convertCoords(int x, int y) {

		int row = -1;
		int col = -1;
		int i = leftRightMargin;

		while (i <= x) {
			col++;
			i += CELLSIZE;
		}

		int j = topBottomMargin;

		while (j <= y) {
			row++;
			j += CELLSIZE;
		}

		return new int[] { row, col };
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		leftRightMargin = ((width % CELLSIZE) + CELLSIZE) / 2;
		topBottomMargin = ((height % CELLSIZE) + CELLSIZE) / 2;

		int numOfRows = (height - topBottomMargin * 2) / CELLSIZE;
		int numOfCols = (width - leftRightMargin * 2) / CELLSIZE;

		if (world == null) {
			world = new World(numOfRows, numOfCols);
		}

		g2.setColor(backgroundColor);
		g2.fillRect(0, 0, width, height);

		drawGrid(g2, width, height);

		for (int col = 0; col < numOfCols; col++) {
			for (int row = 0; row < numOfRows; row++) {
				boolean status = world.getCell(row, col);
				fillCell(g2, row, col, status);
			}
		}

	}

	private void fillCell(Graphics2D g2, int row, int col, boolean status) {
		Color color = status ? foregroundColor : backgroundColor;
		g2.setColor(color);

		int x = leftRightMargin + col * CELLSIZE;
		int y = topBottomMargin + row * CELLSIZE;
		g2.fillRect(x + 1, y + 1, CELLSIZE - 2, CELLSIZE - 2);
	}

	private void drawGrid(Graphics2D g2, int width, int height) {
		g2.setColor(gridColor);

		for (int x = leftRightMargin; x <= width - leftRightMargin; x += CELLSIZE) {
			g2.drawLine(x, topBottomMargin, x, height - topBottomMargin);
		}

		for (int y = topBottomMargin; y <= height - topBottomMargin; y += CELLSIZE) {
			g2.drawLine(leftRightMargin, y, width - leftRightMargin, y);
		}

	}
}
