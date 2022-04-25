package Booking;

import lombok.Data;

import java.util.List;

@Data
public class TestData {
        private String destination;
        private String expArriveMonth;
        private String expArriveDate;
        private String expDepartureMonth;
        private String expDepartureDate;
        private String expCountAdult;
        private String expCountChildren;
        private List <String> expAgeChildren;
        private String expCountRoom;
        private String meals;
        private String location;
        private String expStartCarRentMonth;
        private String expStartCarRentDay;
        private String city;
        private String destinationReserve;
        private String expArriveMonthReserve;
        private String expArriveDateReserve;
        private String expDepartureMonthReserve;
        private String expDepartureDateReserve;
        private String expCountReserveRoom;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
    }
