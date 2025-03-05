package com.example.librarymanagement.dtos;

import java.time.LocalDateTime;

public class ReturnResponseDto {

    private double penalty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    private String name;


    public LocalDateTime getNotEligibleToBorrow() {
        return notEligibleToBorrow;
    }

    public void setNotEligibleToBorrow(LocalDateTime notEligibleToBorrow) {
        this.notEligibleToBorrow = notEligibleToBorrow;
    }

    private LocalDateTime notEligibleToBorrow;

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

   // private String message;


    public ReturnResponseDto(String name,double penalty,LocalDateTime notEligibleToBorrow){
        this.name=name;
       // this.message=message;
        this.penalty=penalty;
        this.notEligibleToBorrow=notEligibleToBorrow;
    }
}
