package org.example;

import java.sql.*;
import java.time.LocalDateTime;

public class DatabaseManager {

    public void insertReview(Review review) {

        String queryInsert = "INSERT INTO review(location_rating, service_rating, quality_price_rating, comment_review) VALUES(?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team_project",
                    "root",
                    "developerCamu*@");

            PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
            preparedStatement.setDouble(1, review.getRatingLocation());
            preparedStatement.setDouble(2, review.getRatingService());
            preparedStatement.setDouble(3, review.getQualityPrice());
            preparedStatement.setString(4, review.getCommentReview());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    public void insertUser(User user) {

        String queryInsert = "INSERT INTO user(name, surname, date_of_birth, email, phone_number, method_payment) VALUES(?, ?, ?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team_project",
                    "root",
                    "developerCamu*@");

            PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setDate(3, Date.valueOf(user.getDateOfBirth()));
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getTelephoneNumber());
            preparedStatement.setString(6, user.getPaymentMethod());


            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    public void insertRoom(Room room) {

        String queryInsert = "INSERT INTO room(room_number, room_type, room_guest, room_cost, room_available, room_clean) VALUES( ? , ? , ? , ? , ? , ? )";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team_project",
                    "root",
                    "Asdasd123stella.");
            PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
            preparedStatement.setInt(1, room.getRoomNumber());
            preparedStatement.setString(2, room.getRoomType());
            preparedStatement.setInt(3, room.getGuests());
            preparedStatement.setDouble(4, room.getPrice());
            preparedStatement.setBoolean(5, room.getavailable());
            preparedStatement.setBoolean(6, room.getIsClean());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }



    public void insertPrenotation(Prenotation prenotation) {

        String queryInsert = "INSERT INTO prenotation(costumers_names, number_of_people_booked, booking_date_and_time, duration_of_the_booking, price, calculate_total, extra_customer_requests, cancel_the_reservation, reservation_confirmed) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,);";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team_project",
                    "root",
                    "Maicoldevelhope12.");

            PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);

            preparedStatement.setString(1, prenotation.nomeCliente());
            preparedStatement.setInt(2, prenotation.numeroPersone());
            preparedStatement.setDate(3, Date.valueOf(prenotation.data()));
            preparedStatement.setTime(4, Time.valueOf(prenotation.time()));
            preparedStatement.setInt(5, prenotation.durataPernottamento());
            preparedStatement.setDouble(6, prenotation.price());
            preparedStatement.setBoolean(7, prenotation.calcolaTotale());
            preparedStatement.setString(8, prenotation.Comment());
            preparedStatement.setBoolean(9, prenotation.annullata());
            preparedStatement.setBoolean(10, prenotation.reservationConfirmed());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
        }
    }

    /*
    metodo per selezionare tutte le recensioni, ma dopo lo modificherò perchè
    non ha senso selezionare tutte le recensioni, ma ha più senso collegare la struttura della quale voglio
    vedere la recensione e soprattutto l'utente che ha fatto la recensione
     */

    public void selectAllFromReview(){

        String querySelect = "SELECT * FROM review WHERE data_review < NOW()";

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/team_project",
                    "root",
                    "developerCamu*@");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(querySelect);

            while (resultSet.next()){
                int reviewID = resultSet.getInt("review_id");
                double ratingLocation = resultSet.getDouble("location_rating");
                double ratingService = resultSet.getDouble("service_rating");
                double ratingQualityPrice = resultSet.getDouble("quality_price_rating");
                String commentReview = resultSet.getString("comment_review");
                Timestamp dateReview = resultSet.getTimestamp("data_review");

                System.out.println("id recensione: " + reviewID);
                System.out.println("valutazione location: " + ratingLocation);
                System.out.println("valutazione del servizio: " + ratingService);
                System.out.println("valutazione rapporto qualità - prezzo: " + ratingQualityPrice);
                System.out.println("commento del soggiorno: " + commentReview);
                System.out.println("data recensione: " + dateReview);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
