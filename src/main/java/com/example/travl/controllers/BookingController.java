package com.example.travl.controllers;
import com.example.travl.models.BookingService;
import com.example.travl.models.Flight;
import com.example.travl.models.Hotel;
import com.example.travl.models.services.BookingServiceDOAImp;
import com.example.travl.models.services.FlightDOAImp;
import com.example.travl.models.services.HotelDOAImp;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.hibernate.jpa.AvailableSettings.JDBC_URL;

public class BookingController {

    private static final String DB_PASSWORD = "";
    @FXML
    public ImageView imageOfPromo_p2;
    public ImageView imageOfPromo_p1;
    @FXML
    private Label price_h1 ;
    @FXML
    private Label price_h2 ;
    @FXML
    private Label price_h3 ;
    @FXML
    private Label price_h4 ;

    @FXML
    private ImageView image_h1, image_h2, image_h3, image_h4;

    @FXML
    private Label nameOfHotel_h1, nameOfHotel_h2, nameOfHotel_h3, nameOfHotel_h4;

    @FXML
    private Label location_h1, location_h2, location_h3, location_h4;

    @FXML
    private VBox promotionList;

    @FXML
    private ImageView image_p1, image_p2;

    @FXML
    private Label nameOfPromo_p1, nameOfPromo_p2;

    @FXML
    private Label descriptionOfPromo_p1,  descriptionOfPromo_p2;
    @FXML private Button viewFlightBookBtn;
    @FXML private Button viewHotelBookBtn;
    @FXML private Button viewHotelDetailsBtn1;
    @FXML private Button viewHotelDetailsBtn2;
    @FXML private Button backTOFromHotel;
    @FXML private Button backFlightListingButton;
    @FXML private Button backToHistoryListing;
    @FXML private Button bookingBtn;
    @FXML private ImageView homeIcon;
    @FXML private ImageView logoutIcon;
    @FXML private ImageView flightIcon;
    @FXML private ImageView hotelIcon;
    @FXML private ImageView historyIcon;
    @FXML private Button selectFlightBtn;
    @FXML private Button viewHotelDetailsBtn;
    @FXML private Button backHotelListingButton;
    @FXML private Button viewFlightDetailsBtn1;
    @FXML private Button viewFlightDetailsBtn2;

    @FXML private Label customerNameF;
    @FXML private Label customerPhoneF;
    @FXML private Label coustomerEmailF;
    @FXML private Label customerAddF;
    @FXML private Label checkinF;
    @FXML private Label chekoutF;
    @FXML private Label createAtF;
    @FXML private Label NkidsF;
    @FXML private Label paymentMF;
    @FXML private Label statusF;
    @FXML private Button editButton;
    ///
    @FXML private TextField customerNameTextField, customerPhoneTextField, coustomerEmailTextField, customerAddTextField, checkinTextField, chekoutTextField, createAtTextField, NkidsTextField, paymentMTextField, statusTextField;
    private boolean isEditing = false;

    @FXML private Label flightRoute;
    @FXML private Label flightTime;
    @FXML private Label airlineName;
    @FXML private Label flightNumber;
    @FXML private Label passengerName;
    @FXML private Label flightStatus;
    @FXML private Label bookingDate;
    @FXML private Label phoneNumber;
    @FXML private Label checkinTime;
    @FXML private Label checkoutTime;
    @FXML private Label price;
    @FXML private Label address;
    @FXML private Label email;
    @FXML private Label numAdults;
    @FXML private Label numKids;
    @FXML private Label paymentMethod;
    ///
    @FXML private TextField flightRouteF;
    @FXML private TextField flightTimeF;
    @FXML private TextField airlineNameF;
    @FXML private TextField flightNumberF;
    @FXML private TextField passengerNameF;
    @FXML private TextField flightStatusF;
    @FXML private TextField bookingDateF;
    @FXML private TextField phoneNumberF;
    @FXML private TextField checkinTimeF;
    @FXML private TextField checkoutTimeF;
    @FXML private TextField priceF;
    @FXML private TextField addressF;
    @FXML private TextField emailF;
    @FXML private TextField numAdultsF;
    @FXML private TextField numKidsF;
    @FXML private TextField paymentMethodF;
    @FXML
    private ImageView imagePromo1 ;
    @FXML private ImageView imagePromo2 ;
    @FXML private Label namePromo1;
    @FXML private Label namePromo2;
    @FXML
    private Label airlineName_a1;
    @FXML
    private Label ticketNo_a1;
    @FXML
    private Label takeoffTime_a1;
    @FXML
    private Label takeoffPlace_a1;
    @FXML
    private Label arrivalTime_a1;
    @FXML
    private Label destination_a1;
    @FXML
    private Label timeToLand_a1;
    @FXML
    private Label Stops_a1;

    @FXML
    private Label airlineName_a2;
    @FXML
    private Label ticketNo_a2;
    @FXML
    private Label takeoffTime_a2;
    @FXML
    private Label takeoffPlace_a2;
    @FXML
    private Label arrivalTime_a2;
    @FXML
    private Label destination_a2;
    @FXML
    private Label timeToLand_a2;
    @FXML
    private Label Stops_a2;

    @FXML
    private Label promoPlace_p1;
    @FXML
    private ImageView promoImage_p1;
    @FXML
    private Label promoPlace_p2;
    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private ImageView promoImage_p2;


    //For Hotel
    private Map<Integer, Label> nameLabels = new HashMap<>();
    private Map<Integer, Label> locationLabels = new HashMap<>();
    private Map<Integer, Label> priceLabels = new HashMap<>();
    private Map<Integer, ImageView> imageViews = new HashMap<>();

    private final String JDBC_URL = "jdbc:mysql://localhost:3306/newDB";
    private final String DB_USERNAME = "root";
    private String[] priceSorted = {"High to Low " , "Low to High"};


    //For Flight
    @FXML
    private Map<Integer, Label> airlineLabels = new HashMap<>();
    @FXML
    private Map<Integer, Label> ticketNoLabels = new HashMap<>();
    @FXML
    private Map<Integer, Label> takeoffTimeLabels = new HashMap<>();
    @FXML
    private Map<Integer, Label> takeoffPlaceLabels = new HashMap<>();
    @FXML
    private Map<Integer, Label> arrivalTimeLabels = new HashMap<>();
    @FXML
    private Map<Integer, Label> destinationLabels = new HashMap<>();
    @FXML
    private Map<Integer, Label> timeToLandLabels = new HashMap<>();
    @FXML
    private Map<Integer, Label> stopsLabels = new HashMap<>();
    @FXML private Label ticket_type_v1;
    @FXML private Label destination_history_name_v1;
    @FXML private Label takeOf_date_v1;
    @FXML private Label bookingID_v1;
    @FXML private Label status_v1;
    @FXML private Label ticketPrice_v1;

    @FXML private Label ticket_type_v2;
    @FXML private Label destination_history_name_v2;
    @FXML private Label takeOf_date_v2;
    @FXML private Label bookingID_v2;
    @FXML private Label status_v2;
    @FXML private Label ticketPrice_v2;
    private final BookingServiceDOAImp bookingServiceDAO = new BookingServiceDOAImp();
    private final FlightDOAImp flightDAO = new FlightDOAImp();
    private final HotelDOAImp hotelDAO = new HotelDOAImp();
    @FXML
    public void initialize() {
        List<BookingService> bookings = bookingServiceDAO.getAllBookings();

        if (bookings != null && bookings.size() >= 2) {
            populateBookingDetails(
                    bookings.get(0),
                    ticket_type_v1,
                    destination_history_name_v1,
                    takeOf_date_v1,
                    bookingID_v1,
                    status_v1,
                    ticketPrice_v1
            );
            populateBookingDetails(
                    bookings.get(1),
                    ticket_type_v2,
                    destination_history_name_v2,
                    takeOf_date_v2,
                    bookingID_v2,
                    status_v2,
                    ticketPrice_v2

            );
        }
        nameLabels.put(1, nameOfHotel_h1);
        nameLabels.put(2, nameOfHotel_h2);
        nameLabels.put(3, nameOfHotel_h3);
        nameLabels.put(4, nameOfHotel_h4);
        locationLabels.put(1, location_h1);
        locationLabels.put(2, location_h2);
        locationLabels.put(3, location_h3);
        locationLabels.put(4, location_h4);
        priceLabels.put(1, price_h1);
        priceLabels.put(2, price_h2);
        priceLabels.put(3, price_h3);
        priceLabels.put(4, price_h4);
        imageViews.put(1, image_h1);
        imageViews.put(2, image_h2);
        imageViews.put(3, image_h3);
        imageViews.put(4, image_h4);
        airlineLabels.put(1, airlineName_a1);
        airlineLabels.put(2, airlineName_a2);
        ticketNoLabels.put(1, ticketNo_a1);
        ticketNoLabels.put(2, ticketNo_a2);
        takeoffTimeLabels.put(1, takeoffTime_a1);
        takeoffTimeLabels.put(2, takeoffTime_a2);


        takeoffPlaceLabels.put(1, takeoffPlace_a1);
        takeoffPlaceLabels.put(2, takeoffPlace_a2);


        arrivalTimeLabels.put(1, arrivalTime_a1);
        arrivalTimeLabels.put(2, arrivalTime_a2);


        destinationLabels.put(1, destination_a1);
        destinationLabels.put(2, destination_a2);


        timeToLandLabels.put(1, timeToLand_a1);
        timeToLandLabels.put(2, timeToLand_a2);

        stopsLabels.put(1, Stops_a1);
        stopsLabels.put(2, Stops_a2);
        loadFlightData();
        loadHotelData();
        loadHotelPromotionData();
        loadFlightData();
       loadFlightPromotionData();
//        loadChoiceBox();
    }
    private void populateBookingDetails(BookingService booking, Label ticketType, Label destination, Label date, Label bookingId, Label status, Label price) {
        ticketType = ticketType != null ? ticketType : new Label();
        destination = destination != null ? destination : new Label();
        date = date != null ? date : new Label();
        bookingId = bookingId != null ? bookingId : new Label();
        status = status != null ? status : new Label();
        price = price != null ? price : new Label();

        if (booking == null) {
            ticketType.setText("Unknown Booking");
            destination.setText("Destination: N/A");
            date.setText("Date: N/A");
            bookingId.setText("Booking ID: N/A");
            status.setText("Status: N/A");
            price.setText("Price: N/A");
            return;
        }

        if (booking.getFlight() != null) {
            ticketType.setText("Flight");
            destination.setText("Destination: " + (booking.getFlight().getDestination() != null ? booking.getFlight().getDestination() : "N/A"));
            date.setText("Take-Off: " + (booking.getFlight().getDepartureDate() != null ? booking.getFlight().getDepartureDate() : "N/A"));
            bookingId.setText("Booking ID: " + booking.getId());
            status.setText("Status: Active");


            price.setText(" $" + (booking.getFlight().getTicketPrice() > 0 ? booking.getFlight().getTicketPrice() : "0.00"));

        } else if (booking.getHotel() != null) {
            ticketType.setText("Hotel");
            destination.setText("Hotel: " + (booking.getHotel().getHotelName() != null ? booking.getHotel().getHotelName() : "N/A"));
            date.setText("Check-In: " + (booking.getHotel().getCreated_at() != null ? booking.getHotel().getCreated_at() : "N/A"));
            bookingId.setText("Booking ID: " + booking.getId());
            status.setText("Status: Active");
            price.setText(" $" + (booking.getHotel().getPricePerNight() != null ? booking.getHotel().getPricePerNight() : "0.00"));
        } else {
            ticketType.setText("Unknown Booking");
            destination.setText("Destination: N/A");
            date.setText("Date: N/A");
            bookingId.setText("Booking ID: N/A");
            status.setText("Status: N/A");
            price.setText("Price: N/A");
        }
    }
    private void loadFlightData() {
        FlightDOAImp flightDOA = new FlightDOAImp();
        List<Flight> flights = flightDOA.getAll();
        int maxFlights = Math.min(flights.size(), airlineLabels.size());
        for (int i = 0; i < maxFlights; i++) {
            Flight flight = flights.get(i);
            int index = i + 1;
            if (airlineLabels.containsKey(index)) {
                Label airlineLabel = airlineLabels.get(index);
                if (airlineLabel != null) {
                    airlineLabel.setText(flight.getAirline());
                } else {
                    System.err.println("The airline label null :) : " + index);
                }
            }
            if (ticketNoLabels.containsKey(index)) {
                Label ticketNoLabel = ticketNoLabels.get(index);
                if (ticketNoLabel != null) {
                    ticketNoLabel.setText("Ticket #" + flight.getId());
                } else {
                    System.err.println("The Ticket label null :): " + index);
                }
            }
            if (takeoffTimeLabels.containsKey(index)) {
                Label takeoffTimeLabel = takeoffTimeLabels.get(index);
                if (takeoffTimeLabel != null) {
                    Date departureDate = flight.getDepartureDate();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    takeoffTimeLabel.setText(formatter.format(departureDate));

                } else {
                    System.err.println("The takeoff time  label null :): " + index);
                }
            }
            if (takeoffPlaceLabels.containsKey(index)) {
                Label takeoffPlaceLabel = takeoffPlaceLabels.get(index);
                if (takeoffPlaceLabel != null) {
                    takeoffPlaceLabel.setText(flight.getDesFrom());
                } else {
                    System.err.println("Takeoff place  label null :) : " + index);
                }

            }
            if (arrivalTimeLabels.containsKey(index)) {
                Label arrivalTimeLabel = arrivalTimeLabels.get(index);
                if (arrivalTimeLabel != null) {
                    Date departureDate = flight.getDepartureDate();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    arrivalTimeLabel.setText(formatter.format(departureDate));
                } else {
                    System.err.println("Arrival time label label null :) : " + index);
                }
            }
            if (destinationLabels.containsKey(index)) {
                Label destinationLabel = destinationLabels.get(index);
                if (destinationLabel != null) {
                    destinationLabel.setText(flight.getDestination());
                } else {
                    System.err.println("Destination label null :) : " + index);
                }
            }
            if (stopsLabels.containsKey(index)) {
                Label stopsLabel = stopsLabels.get(index);
                if (stopsLabel != null) {
                    stopsLabel.setText(flight.getStops());
                } else {
                    System.err.println("Stops label null :) : " + index);
                }
            }


            if (timeToLandLabels.containsKey(index)) {
                Label timeToLandLabel = timeToLandLabels.get(index);
                if (timeToLandLabel != null) {
                    timeToLandLabel.setText(flight.getDuration());
                } else {
                    System.err.println("Time to land label null :) : " + index);
                }
            }
        }
        if (flights.size() > maxFlights) {
            System.err.println("Warning: More flights exist in the database than UI slots. Only the first " + maxFlights + " flights are displayed.");
        }
    }

    private void loadFlightPromotionData() {
        FlightDOAImp flightDOA = new FlightDOAImp();
        List<Object[]> promotedFlights = flightDOA.getPromotedFlights();


        Label[] nameLabels = {namePromo1, namePromo2};
        ImageView[] imageViews = {imagePromo1, imagePromo2};

        int maxSlots = Math.min(promotedFlights.size(), nameLabels.length);
        for (int i = 0; i < maxSlots; i++) {
            Object[] row = promotedFlights.get(i);
            String flightName = (String) row[0];
            String airlineName = (String) row[1];
            byte[] imageBytes = (byte[]) row[2];

            System.out.println("Flight Name: " + flightName);
            System.out.println("Airline Name: " + airlineName);
            System.out.println("Image Bytes Length: " + (imageBytes != null ? imageBytes.length : "No Image"));

            Label nameLabel = nameLabels[i];
            ImageView imageView = imageViews[i];

            if (nameLabel != null) {
                nameLabel.setText(flightName + " (" + airlineName + ")");
            }
            if (imageView != null) {
                if (imageBytes != null) {
                    imageView.setImage(new Image(new ByteArrayInputStream(imageBytes)));
                } else {
                    imageView.setImage(null);
                }
            }
        }


        for (int i = maxSlots; i < nameLabels.length; i++) {
            if (nameLabels[i] != null) {
                nameLabels[i].setText("");
            }
            if (imageViews[i] != null) {
                imageViews[i].setImage(null);
            }
        }
    }


    private void loadHotelData() {
        HotelDOAImp hotelDOA = new HotelDOAImp();
        List<Hotel> hotels = hotelDOA.getAll();
        int maxHotels = Math.min(hotels.size(), nameLabels.size());

        for (int i = 0; i < maxHotels; i++) {
            Hotel hotel = hotels.get(i);
            int index = i + 1;

            if (nameLabels.containsKey(index)) {
                Label nameLabel = nameLabels.get(index);
                if (nameLabel != null) {
                    nameLabel.setText(hotel.getHotelName());
                } else {
                    System.err.println("Name label is null for index: " + index);
                }
            }

            if (locationLabels.containsKey(index)) {
                Label locationLabel = locationLabels.get(index);
                if (locationLabel != null) {
                    locationLabel.setText(hotel.getLocation());
                } else {
                    System.err.println("Location label is null for index: " + index);
                }
            }
            if (priceLabels.containsKey(index)) {
                Label priceLabel = priceLabels.get(index);
                if (priceLabel != null) {
                    priceLabel.setText("$" + hotel.getPricePerNight());
                } else {
                    System.err.println("Price label is null for index: " + index);
                }
            }

            if (imageViews.containsKey(index)) {
                ImageView imageView = imageViews.get(index);
                if (imageView != null) {
                    byte[] imageBytes = hotel.getImg();
                    if (imageBytes != null) {
                        Image image = new Image(new ByteArrayInputStream(imageBytes));
                        imageView.setImage(image);
                    } else {
                        System.err.println("Image data is null for hotel index: " + index);
                    }
                } else {
                    System.err.println("Image view is null for index: " + index);
                }
            }
        }
        if (hotels.size() > maxHotels) {
            System.err.println("Warning: More hotels exist in the database than UI slots. Only the first " + maxHotels + " hotels are displayed.");
        }
    }


    private void loadHotelPromotionData() {

        HotelDOAImp hotelDOA = new HotelDOAImp();
        List<Object[]> promotedHotels = hotelDOA.getPromotedHotels();


        Label[] nameLabels = {nameOfPromo_p1, nameOfPromo_p2};
        ImageView[] imageViews = {imageOfPromo_p1, imageOfPromo_p2};


        int maxSlots = Math.min(promotedHotels.size(), nameLabels.length);

        for (int i = 0; i < maxSlots; i++) {
            Object[] row = promotedHotels.get(i);
            String hotelName = (String) row[0];
            String location = (String) row[1];
            byte[] imageBytes = (byte[]) row[2];

            System.out.println("Hotel Name: " + hotelName);
            System.out.println("Location: " + location);
            System.out.println("Image Bytes Length: " + (imageBytes != null ? imageBytes.length : "No Image"));

            try {

                Label nameLabel = nameLabels[i];
                ImageView imageView = imageViews[i];


                if (nameLabel != null) {
                    nameLabel.setText(hotelName + " - " + location);
                }


                if (imageView != null) {
                    if (imageBytes != null) {
                        Image promoImage = new Image(new ByteArrayInputStream(imageBytes));
                        imageView.setImage(promoImage);
                    } else {
                        imageView.setImage(null);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error loading promotion image for index " + i + ": " + e.getMessage());
            }
        }


        for (int i = maxSlots; i < nameLabels.length; i++) {
            if (nameLabels[i] != null) {
                nameLabels[i].setText("");
            }
            if (imageViews[i] != null) {
                imageViews[i].setImage(null);
            }
        }
    }




    @FXML
    public void handleEditButtonClick() {
        if (isEditing) {
            customerNameF.setText(customerNameTextField.getText());
            customerPhoneF.setText(customerPhoneTextField.getText());
            coustomerEmailF.setText(coustomerEmailTextField.getText());
            customerAddF.setText(customerAddTextField.getText());
            checkinF.setText(checkinTextField.getText());
            chekoutF.setText(chekoutTextField.getText());
            createAtF.setText(createAtTextField.getText());
            NkidsF.setText(NkidsTextField.getText());
            paymentMF.setText(paymentMTextField.getText());
            statusF.setText(statusTextField.getText());
            customerNameTextField.setVisible(false);
            customerPhoneTextField.setVisible(false);
            coustomerEmailTextField.setVisible(false);
            customerAddTextField.setVisible(false);
            checkinTextField.setVisible(false);
            chekoutTextField.setVisible(false);
            createAtTextField.setVisible(false);
            NkidsTextField.setVisible(false);
            paymentMTextField.setVisible(false);
            statusTextField.setVisible(false);
            customerNameF.setVisible(true);
            customerPhoneF.setVisible(true);
            coustomerEmailF.setVisible(true);
            customerAddF.setVisible(true);
            checkinF.setVisible(true);
            chekoutF.setVisible(true);
            createAtF.setVisible(true);
            NkidsF.setVisible(true);
            paymentMF.setVisible(true);
            statusF.setVisible(true);
            editButton.setText("Edit");
        } else {
            customerNameTextField.setText(customerNameF.getText());
            customerPhoneTextField.setText(customerPhoneF.getText());
            coustomerEmailTextField.setText(coustomerEmailF.getText());
            customerAddTextField.setText(customerAddF.getText());
            checkinTextField.setText(checkinF.getText());
            chekoutTextField.setText(chekoutF.getText());
            createAtTextField.setText(createAtF.getText());
            NkidsTextField.setText(NkidsF.getText());
            paymentMTextField.setText(paymentMF.getText());
            statusTextField.setText(statusF.getText());

            customerNameTextField.setVisible(true);
            customerPhoneTextField.setVisible(true);
            coustomerEmailTextField.setVisible(true);
            customerAddTextField.setVisible(true);
            checkinTextField.setVisible(true);
            chekoutTextField.setVisible(true);
            createAtTextField.setVisible(true);
            NkidsTextField.setVisible(true);
            paymentMTextField.setVisible(true);
            statusTextField.setVisible(true);

            customerNameF.setVisible(false);
            customerPhoneF.setVisible(false);
            coustomerEmailF.setVisible(false);
            customerAddF.setVisible(false);
            checkinF.setVisible(false);
            chekoutF.setVisible(false);
            createAtF.setVisible(false);
            NkidsF.setVisible(false);
            paymentMF.setVisible(false);
            statusF.setVisible(false);

            editButton.setText("Save");
        }

        isEditing = !isEditing;
    }
    @FXML
    public void handleEditButtonClickFly() {
        if (isEditing) {
            flightRoute.setText(flightRouteF.getText());
            flightTime.setText(flightTimeF.getText());
            airlineName.setText(airlineNameF.getText());
            flightNumber.setText(flightNumberF.getText());
            passengerName.setText(passengerNameF.getText());
            flightStatus.setText(flightStatusF.getText());
            bookingDate.setText(bookingDateF.getText());
            phoneNumber.setText(phoneNumberF.getText());
            checkinTime.setText(checkinTimeF.getText());
            checkoutTime.setText(checkoutTimeF.getText());
            price.setText(priceF.getText());
            address.setText(addressF.getText());
            email.setText(emailF.getText());
            numAdults.setText(numAdultsF.getText());
            numKids.setText(numKidsF.getText());
            paymentMethod.setText(paymentMethodF.getText());

            toggleVisibility(false);

            editButton.setText("Edit");
        } else {
            flightRouteF.setText(flightRoute.getText());
            flightTimeF.setText(flightTime.getText());
            airlineNameF.setText(airlineName.getText());
            flightNumberF.setText(flightNumber.getText());
            passengerNameF.setText(passengerName.getText());
            flightStatusF.setText(flightStatus.getText());
            bookingDateF.setText(bookingDate.getText());
            phoneNumberF.setText(phoneNumber.getText());
            checkinTimeF.setText(checkinTime.getText());
            checkoutTimeF.setText(checkoutTime.getText());
            priceF.setText(price.getText());
            addressF.setText(address.getText());
            emailF.setText(email.getText());
            numAdultsF.setText(numAdults.getText());
            numKidsF.setText(numKids.getText());
            paymentMethodF.setText(paymentMethod.getText());

            toggleVisibility(true);

            editButton.setText("Save");
        }

        isEditing = !isEditing;
    }
    private void toggleVisibility(boolean showTextFields) {
        flightRoute.setVisible(!showTextFields);
        flightRouteF.setVisible(showTextFields);

        flightTime.setVisible(!showTextFields);
        flightTimeF.setVisible(showTextFields);

        airlineName.setVisible(!showTextFields);
        airlineNameF.setVisible(showTextFields);

        flightNumber.setVisible(!showTextFields);
        flightNumberF.setVisible(showTextFields);

        passengerName.setVisible(!showTextFields);
        passengerNameF.setVisible(showTextFields);

        flightStatus.setVisible(!showTextFields);
        flightStatusF.setVisible(showTextFields);

        bookingDate.setVisible(!showTextFields);
        bookingDateF.setVisible(showTextFields);

        phoneNumber.setVisible(!showTextFields);
        phoneNumberF.setVisible(showTextFields);

        checkinTime.setVisible(!showTextFields);
        checkinTimeF.setVisible(showTextFields);

        checkoutTime.setVisible(!showTextFields);
        checkoutTimeF.setVisible(showTextFields);

        price.setVisible(!showTextFields);
        priceF.setVisible(showTextFields);

        address.setVisible(!showTextFields);
        addressF.setVisible(showTextFields);

        email.setVisible(!showTextFields);
        emailF.setVisible(showTextFields);

        numAdults.setVisible(!showTextFields);
        numAdultsF.setVisible(showTextFields);

        numKids.setVisible(!showTextFields);
        numKidsF.setVisible(showTextFields);

        paymentMethod.setVisible(!showTextFields);
        paymentMethodF.setVisible(showTextFields);
    }
    @FXML
    protected void navigateHome(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/agent-dash.fxml"));

            Stage stage = (Stage) homeIcon.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML
    protected void navigateFlight(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/flight-listing.fxml"));

            Stage stage = (Stage) flightIcon.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML
    protected void navigateHotel(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/hotel-listing.fxml"));

            Stage stage = (Stage) hotelIcon.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML
    protected void navigateHistory(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/all-history-booking.fxml"));

            Stage stage = (Stage) historyIcon.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML
    protected void navigateLogout(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/log-in.fxml"));

            Stage stage = (Stage) logoutIcon.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML
    protected void navigateHotelClient(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/client-details.fxml"));

            Stage stage = (Stage) bookingBtn.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Flight details");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML
    protected void navigateClientFlight(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/travl/client-details-flight.fxml"));

            Stage stage = (Stage) bookingBtn.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Flight details");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
    @FXML
    private void handleMenuButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent newScene = null;
        if (event.getSource() == selectFlightBtn || event.getSource() == viewFlightDetailsBtn1 || event.getSource() == viewFlightDetailsBtn2) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/flight-details.fxml")));
        }
        else if (event.getSource() == viewHotelDetailsBtn || event.getSource() == viewHotelDetailsBtn1 || event.getSource() == viewHotelDetailsBtn2) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/hotel-details.fxml")));
        } else if (event.getSource() == backFlightListingButton) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/flight-listing.fxml")));
        }
        else if (event.getSource() == backTOFromHotel) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/all-history-booking.fxml")));
        }
        else if (event.getSource() == backHotelListingButton) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/hotel-listing.fxml")));
        }
        else if (event.getSource() == viewHotelBookBtn) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/hotel-book-details.fxml")));
        }
        else if (event.getSource() == viewFlightBookBtn) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/flight-book-details.fxml")));
        }
        else if (event.getSource() == backToHistoryListing) {
            newScene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/travl/all-history-booking.fxml")));
        }

        if (newScene != null) {
            Scene scene = new Scene(newScene);
            stage.setScene(scene);
            stage.setTitle("My New Scene");
            stage.show();
        }
    }


//    private void loadChoiceBox(){
//        myChoiceBox.getItems().addAll(priceSorted);
//        myChoiceBox.setValue("Price");
//    }


}
