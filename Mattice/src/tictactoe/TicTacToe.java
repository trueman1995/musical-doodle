/**
 * 
 */
package tictactoe;

import java.util.Scanner;

import common.*;

/**
 * @author Felix Armbruster felix_armbruster@t-online.de
 *
 */
public class TicTacToe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Matchbox field = new Matchbox();
		boolean player = false;
		System.out.println(field.toString());
		System.out.println("-------\n");

		while (!field.finished()) {

			setzen(player, field);
			player = !player;

			System.out.println(field.toString());
			System.out.println("-------\n");
		}

		if (field.hasWinner()) {

			if (field.getWinner() == 1) {
				System.out.println("Der Computer hat gewonnen\n");
			} else {
				System.out.println("der menschliche Spieler hat gewonnen\n");
			}

		} else {
			System.out.println("unentschieden\n");
		}
		
	}

	private static void setzen(boolean player, Matchbox field) {

		if (!player) {
			System.out.println("Computer zieht\n");
			setzenRandom(field);
		} else {
			System.out.println("Spieler zieht\n");
			setzenPlayer(field);
		}
	}

	private static void setzenRandom(Matchbox field) {

		int tmp = (int) (Math.random() * 9);
		int i = tmp % 3;
		int j = (tmp - i) / 3;

		if (field.getPlayerAt(i, j) == 0) {
			field.setField(new Field(1), i, j);
		} else {
			setzenRandom(field);
		}
	}

	private static void setzenPlayer(Matchbox field) {

		int tmp = getInputfromConsole();
		int i = tmp % 3;
		int j = (tmp - i) / 3;

		if (field.getPlayerAt(i, j) == 0) {
			field.setField(new Field(2), i, j);
		} else {
			setzenPlayer(field);
		}
	}

	@SuppressWarnings("resource")
	private static int getInputfromConsole() {

		System.out.println("bitte Eingabe tätigen\n");

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int tmp = Integer.parseInt(s);

		return tmp;
	}
}