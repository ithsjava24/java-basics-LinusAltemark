package org.example;

import java.util.Scanner;

public class App {

    private static int[] priser = new int[24];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val;

        do {
            // Meny
            System.out.print("Elpriser\n");
            System.out.print("========\n");
            System.out.print("1. Inmatning\n");
            System.out.print("2. Min, Max och Medel\n");
            System.out.print("3. Sortera\n");
            System.out.print("4. Bästa Laddningstid (4h)\n");
            System.out.print("5. Visualisering\n");
            System.out.print("e. Avsluta\n");

            val = scanner.nextLine();

            switch (val) {
                case "1":
                    inmatning(scanner);
                    break;
                case "2":
                    minMaxMedel();
                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "e":
                case "E":
                    System.out.print("Avslutar programmet.\n");
                    break;
                default:
                    System.out.print("Ogiltligt alternativ, försök igen.\n");
            }
        } while (!val.equalsIgnoreCase("e"));

        scanner.close();
    }

    private static void inmatning(Scanner scanner) {
        System.out.print("Skriv in elpriserna för varje timme (0-23):\n");
        for (int i = 0; i < 24; i++) {
            System.out.print(i + ": ");
            priser[i] = Integer.parseInt(scanner.nextLine());
        }
    }

    private static void minMaxMedel() {
        int min = priser[0], max = priser[0];
        int minHour = 0, maxHour = 0;
        int total = 0;

        for (int i = 0; i < 24; i++) {
            total += priser[i];
            if (priser[i] < min) {
                min = priser[i];
                minHour = i;
            }
            if (priser[i] > max) {
                max = priser[i];
                maxHour = i;
            }
        }

        double medel = total / 24.0;
        System.out.printf("Lägsta pris: %d öre vid timme %02d-%02d\n", min, minHour, minHour + 1);
        System.out.printf("Högsta pris: %d öre vid timme %02d-%02d\n", max, maxHour, maxHour + 1);
        System.out.printf("Medelpriset: %.2f öre\n", medel);
    }
}
