package com.dy.java.core;

import java.util.EnumSet;
import java.util.Set;

public class Q13_7 {
	private enum Color {
		RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255);
		private int r;
		private int g;
		private int b;

		Color(int r, int g, int b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}

	}

	public static void drawLine(Set<Color> colors) {
		System.out.println("Requested Colors to draw lines : " + colors);
		for (Color c : colors) {
			System.out.println("drawing line in color : " + c);
		}
		
	}

	public static void main(String[] args) {
		// this will draw line in yellow color
		EnumSet<Color> yellow = EnumSet.of(Color.RED, Color.GREEN);
		drawLine(yellow);
		// RED + GREEN + BLUE = WHITE
		EnumSet<Color> white = EnumSet.of(Color.RED, Color.GREEN, Color.BLUE);
		drawLine(white);
		// RED + BLUE = PINK
		EnumSet<Color> pink = EnumSet.of(Color.RED, Color.BLUE);
		drawLine(pink);

	}
}
