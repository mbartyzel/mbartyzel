package pl.bnsit.java.foundations.rownaniekwadratowe.prosterozwiazanie;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		System.out.println("az^2 + bz + c = 0");
		System.out.println();

		Scanner scanner = new Scanner(System.in);

		double a = czytajZKonsoli(scanner, "a");
		double b = czytajZKonsoli(scanner, "b");
		double c = czytajZKonsoli(scanner, "c");

		if (a == 0) {
			double x = -c / b;
			System.out.println("[Rówanie liniowe] x = " + x);

			return;
		}

		double delta = b * b - 4 * a * c;
		if (delta == 0) {
			double x0 = -b / (2 * a);
			System.out.println("[Pierwiastek podwójny] x1 = x2 = " + x0);

			return;
		}

		if (delta > 0) {
			double x1 = -b / (2 * a) - Math.sqrt(delta) / (2 * a);
			double x2 = -b / (2 * a) + Math.sqrt(delta) / (2 * a);

			System.out.print("[Dwa pierwiastki rzeczywiste] ");
			System.out.print("x1 = " + x1 + " x2 = " + x2);

			return;
		}

		if (delta < 0) {
			double re = -b / (2 * a);
			double im = Math.sqrt(Math.abs(delta)) / (2 * a);

			System.out.print("[Dwa pierwiastki zespolone] ");
			System.out.print("x1 = " + re + " + " + im + "i");
			System.out.print("x2 = " + re + " - " + im + "i");
		}
	}

	private static double czytajZKonsoli(final Scanner scanner, String param) {
		System.out.println(param + " = ");
		double a = Double.parseDouble(scanner.nextLine());
		return a;
	}

}
