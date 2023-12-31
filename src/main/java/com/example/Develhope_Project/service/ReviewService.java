package com.example.Develhope_Project.service;

import com.example.Develhope_Project.models.Review;
import com.example.Develhope_Project.models.Room;
import com.example.Develhope_Project.repository.ReviewRepository;
import com.example.Develhope_Project.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    RoomRepository roomRepository;


    public Review insertReview(int roomID, Review review) throws Exception {

        if (roomRepository.findById(roomID).isPresent()) {
            Room room = roomRepository.findById(roomID).orElse(null);

            review.setRoom(room);

        } else {
            throw new Exception(String.format("Room with ID %s not exist", roomID));
        }

        return reviewRepository.save(review);
    }


    public List<Review> viewAllViewsByRoom(int roomID) throws Exception {

        if (roomRepository.findById(roomID).isPresent()) {
            Room room = roomRepository.findById(roomID).orElse(null);
            List<Review> reviews;
            reviews = room.getReviewList();

            return reviews;

        } else {
            throw new Exception(String.format("Room with ID %s not exist", roomID));
        }
    }


    public Review updateReview(int id, Review updateReview) throws Exception {


        if (reviewRepository.findById(id).isPresent()) {

            Review review = reviewRepository.findById(id).get();

            if (updateReview.getRatingLocation() != 0) {
                review.setRatingLocation(updateReview.getRatingLocation());
            }

            if (updateReview.getRatingService() != 0) {
                review.setRatingService(updateReview.getRatingService());
            }

            if (updateReview.getQualityPrice() != 0) {
                review.setQualityPrice(updateReview.getQualityPrice());
            }

            if (Objects.nonNull(updateReview.getCommentReview())) {
                review.setCommentReview(updateReview.getCommentReview());
            }
            return reviewRepository.save(review);
        } else {
            throw new Exception(String.format("Review with ID %s not found", id));
        }

    }

    @Transactional
    public void deleteReview(int id){
        try {
            reviewRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }

    }


    /*
    public void deleteReview(int id) throws Exception{
        Optional<Review> optionalReview = reviewRepository.findById(id);

        if (optionalReview.isPresent()) {

            Review review = optionalReview.get();
            reviewRepository.deleteById(id);
        }
        else {
            throw new Exception(String.format("Review with ID %s not found", id));
        }

       // if (reviewRepository.findById(id).isPresent()){
        //
       //     reviewRepository.deleteById(id);
       // } else


    }


     */


    public Map<String, Double> AVGRating(int roomId) throws Exception{

        Room room = roomRepository.findById(roomId).orElse(null);

        if (room != null) {

            List<Review> reviews = room.getReviewList();
            double totalLocation = 0;
            double totalService = 0;
            double totalQualityPrice = 0;

            for (Review review : reviews) {
                totalLocation += review.getRatingLocation();
                totalService += review.getRatingService();
                totalQualityPrice += review.getQualityPrice();
            }

            Map<String, Double> avgRating = new HashMap<>();

            avgRating.put("avrRatingLocation", totalLocation / reviews.size());
            avgRating.put("avgRatingService", totalService / reviews.size());
            avgRating.put("avgQualityPrice", totalQualityPrice / reviews.size());

            return avgRating;

        } else
            throw new Exception(String.format("Room with ID %s not found", roomId));
    }


}
