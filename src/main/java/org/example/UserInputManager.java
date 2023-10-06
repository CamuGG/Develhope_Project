package org.example;

import java.util.Date;
import java.util.Scanner;

public class UserInputManager {

    /*
       questo metodo permette all'utente di creare una recensione e poi la inserisce direttamente nella tabella mySQL
       sicuramente da rivedere perchè vorrei inserire delle eccezioni, ma il metodo funziona
    */

    public void createReview(){
        DatabaseManager databaseManager = new DatabaseManager();

        Review review = new Review();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci una valutazione da 1 a 5 per la location:");
        double valutationLocation = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Inserisci una valutazione da 1 a 5 per il servizio:");
        double valutationService = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Inserisci una valutazione da 1 a 5 per il rapporto qualità prezzo:");
        double valutationQualityPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Lasciaci un commento per descrivere la tua vancanza:");
        String commentReview = scanner.nextLine();

        review.setRatingLocation(valutationLocation);
        review.setRatingService(valutationService);
        review.setQualityPrice(valutationQualityPrice);
        review.setCommentReview(commentReview);

        databaseManager.insertReview(review);

        scanner.close();
    }
}