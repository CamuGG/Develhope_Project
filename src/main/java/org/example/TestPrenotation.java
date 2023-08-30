package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class TestPrenotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuti nel nostro Hotel!");

        System.out.println("Inserisca il suo nome e cognome: ");
        String nomeCliente = scanner.nextLine();

        System.out.println("in quanti alloggierete?: ");
        int numberPerson = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Inserisci il prezzo della camera: ");
        double prezzoInserito = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Durata pernottamento giorni: ");
        int durata = scanner.nextInt();
        scanner.nextLine();

        System.out.println("conferma o annulla? per confermare la prenotazione scrivere true, sennò false");
        boolean reservationConfirmed = scanner.nextBoolean();

        LocalDate data = LocalDate.now();

        // Ottieni l'orario corrente
        LocalTime currentTime = LocalTime.now();

        scanner.close();

        Prenotation prenotazioneEffettuata = new Prenotation(data, nomeCliente, numberPerson, reservationConfirmed, currentTime, prezzoInserito, durata);

        prenotazioneEffettuata.printDetails();
    }
}
