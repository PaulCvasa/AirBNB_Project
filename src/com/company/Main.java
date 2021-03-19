//AirBNB Simulator - Subgroup 4 Homework
//Paul Cvasa - Group 2 Subgroup 4

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Homeowner[] homeownerList = new Homeowner[100]; // A list of all homeowners
    public static SharedRoom[] sharedRoomsList = new SharedRoom[100]; // A list of all Shared Rooms
    public static PrivateRoom[] privateRoomsList = new PrivateRoom[100]; // A list of all Private Rooms
    public static WholePlace[] wholePlacesList = new WholePlace[100]; //A list of all Whole Places
    public static Renter[] rentersList = new Renter[100]; // A list of all renters
    public static int countHomeowners = 0, countSharedRooms = 0, countPrivateRooms = 0, countWholePlaces = 0, countRenters = 0; // Number of objects

    public static Date convertDate(String strDate) // transforms date formatted as String to Date
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try{
            Date date = format.parse(strDate);
            //String finalDate = format.format(date);
            return date;
        }catch (ParseException e)
        {

        }
        return null;
    }

    public static void menu() {

        Scanner scan = new Scanner(System.in);
        System.out.println("\n\tWelcome to AirBNB Simulator\n~This program was made by Paul Cvasa ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please choose an option: ");
        System.out.println("\n0 -> Start program");
        System.out.println("1 -> Restore the last saved state");
        System.out.println("2 -> Exit");
        int chooseState = -1;
        chooseState = scan.nextInt();
        if (chooseState == 0) {
            while (chooseState == 0) { // This loop is used to maintain the menu so you can add/make multiple rooms and reservations
                System.out.println("\nChoose an option: ");
                System.out.println("0 -> Add Homeowner");
                System.out.println("1 -> Add Room/Place");
                System.out.println("2 -> Add Renter");
                System.out.println("3 -> Make a reservation");
                System.out.println("4 -> Save and Exit");
                System.out.println("5 -> Display all data");
                chooseState = scan.nextInt();
                String[] input = new String[3]; //these variables are used to read the data from the user
                int id = 0, nrBeds = 0;
                switch (chooseState) { // this switch converts the data from user to our objects
                    case 0: // to add a new homeowner
                        System.out.println("\nHomeowner's First Name: ");
                        input[0] = scan.next();
                        System.out.println("\nHomeowner's Last Name: ");
                        input[1] = scan.next();
                        System.out.println("\nHomeowner ID: ");
                        id = scan.nextInt();
                        System.out.println("\nHomeowner's Phone Number: ");
                        input[2] = scan.next();
                        homeownerList[countHomeowners] = new Homeowner(input[0], input[1], id, input[2]);
                        countHomeowners++;
                        System.out.println("\n~~~ Homeowner added successfully ! ~~~");
                        break;
                    case 1: //to add a new room
                        System.out.println("\nChoose what type of room you want to add: ");
                        System.out.println("\n1 -> Shared Room");
                        System.out.println("2 -> Private Room");
                        System.out.println("3 -> Whole Place");
                        chooseState = scan.nextInt();
                        switch (chooseState) { //for each type of room
                            case 1: //shared room
                                System.out.println("\nOwner's ID: ");
                                id = scan.nextInt();
                                System.out.println("\nCity: ");
                                input[0] = scan.next();
                                System.out.println("\nAddress: ");
                                input[1] = scan.next();
                                System.out.println("\nNumber of beds: ");
                                nrBeds = scan.nextInt();
                                sharedRoomsList[countSharedRooms] = new SharedRoom(id, input[0], input[1], nrBeds);
                                countSharedRooms++;
                                System.out.println("\n~~~ Shared Room added successfully ! ~~~");
                                chooseState = 0;
                                break;
                            case 2: //private room
                                System.out.println("\nOwner's ID: ");
                                id = scan.nextInt();
                                System.out.println("\nCity: ");
                                input[0] = scan.next();
                                System.out.println("\nAddress: ");
                                input[1] = scan.next();
                                System.out.println("\nNumber of beds: ");
                                nrBeds = scan.nextInt();
                                privateRoomsList[countPrivateRooms] = new PrivateRoom(id, input[0], input[1], nrBeds);
                                countPrivateRooms++;
                                System.out.println("\n~~~ Private Room added successfully ! ~~~");
                                chooseState = 0;
                                break;
                            case 3: //whole place
                                System.out.println("\nOwner's ID: ");
                                id = scan.nextInt();
                                System.out.println("\nCity: ");
                                input[0] = scan.next();
                                System.out.println("\nAddress: ");
                                input[1] = scan.next();
                                System.out.println("\nNumber of beds: ");
                                nrBeds = scan.nextInt();
                                wholePlacesList[countWholePlaces] = new WholePlace(id, input[0], input[1], nrBeds);
                                wholePlacesList[countWholePlaces].privateBathroom();
                                countWholePlaces++;
                                System.out.println("\n~~~ Whole Place added successfully ! ~~~");
                                chooseState = 0;
                                break;
                        }
                        break;
                    case 2: //to add a new renter
                        System.out.println("\nRenter's First Name: ");
                        input[0] = scan.next();
                        System.out.println("\nRenter's Last Name: ");
                        input[1] = scan.next();
                        System.out.println("\nRenter's Phone Number: ");
                        input[2] = scan.next();
                        rentersList[countRenters] = new Renter(input[0], input[1], input[2]);
                        countRenters++;
                        System.out.println("\n~~~ Renter added successfully ! ~~~");
                        chooseState = 0;
                        break;
                    case 3: // here we schedule a reservation
                        System.out.println("\nEnter city name in which you want a reservation(!cAsE sEnSiTiVe!): ");
                        String city = new String(); //city in which we are interested to book
                        city = scan.next();
                        System.out.println("\n Which type of room are you interested in? ");
                        System.out.println("\n 1 -> Shared Room");
                        System.out.println("2 -> Private Room");
                        System.out.println("3 -> Whole Place");
                        int room = 0;
                        room = scan.nextInt(); //to remember the type of room we search for
                        int choice = -1; //the room we will reserve
                        String checkinDate = new String();
                        String checkoutDate = new String();
                        boolean noRooms = true; //flag to check if there are no rooms available
                        if (room == 1) { //shared rooms
                            System.out.println("\nShared rooms available: ");
                            for (int i = 0; i < countSharedRooms; i++)
                                if ((sharedRoomsList[i].city).equals(city)) { //displays the rooms/places which are in the selected city
                                    System.out.println("Room no. " + i + " : " + sharedRoomsList[i]);
                                    noRooms = false;
                                }
                            if(!noRooms) { // if we have rooms
                                System.out.println("\nRoom number chosen: ");
                                choice = scan.nextInt();
                                System.out.println("\nEnter Check-in Date(format: YYYY-MM-DD): ");
                                checkinDate = scan.next();
                                sharedRoomsList[choice].setCheckinDates(checkinDate);
                                System.out.println("\nEnter Check-Out Date(format: YYYY-MM-DD): ");
                                checkoutDate = scan.next();
                                sharedRoomsList[choice].setCheckoutDates(checkoutDate);
                                sharedRoomsList[choice].addedReservation();
                                System.out.println("\n ~~~ Room reserved successfully! ~~~");
                            }
                            else {
                                System.out.println("\n~~~ No rooms available in that city ~~~");
                            }
                        } else if (room == 2) { //private rooms
                            System.out.println("\nPrivate rooms available: ");
                            for (int i = 0; i < countPrivateRooms; i++)
                                if ((privateRoomsList[i].city).equals(city)) { //displays the rooms/places which are in the selected city
                                    System.out.println("Room no. " + i + " : " + privateRoomsList[i]);
                                    noRooms = false;
                                }
                            if(!noRooms) { //if we have rooms
                                System.out.println("\nRoom number chosen: ");
                                choice = scan.nextInt();
                                System.out.println("\nEnter Check-in Date(format: YYYY-MM-DD): ");
                                checkinDate = scan.next();
                                privateRoomsList[choice].setCheckinDates(checkinDate);
                                System.out.println("\nEnter Check-Out Date(format: YYYY-MM-DD): ");
                                checkoutDate = scan.next();
                                privateRoomsList[choice].setCheckoutDates(checkoutDate);
                                privateRoomsList[choice].addedReservation();
                                System.out.println("\n ~~~ Room reserved successfully! ~~~");
                            }
                            else {
                                System.out.println("\n~~~ No rooms available in that city ~~~");
                            }
                        } else if (room == 3) { //whole places
                            System.out.println("\nWhole places available: ");
                            for (int i = 0; i < countWholePlaces; i++)
                                if ((wholePlacesList[i].city).equals(city)) { //displays the rooms/places which are in the selected city
                                    System.out.println("Room no. " + i + " : " + wholePlacesList[i]);
                                    noRooms = false;
                                }
                            if(!noRooms) //if we have rooms
                            {
                                System.out.println("\nRoom number chosen: ");
                                choice = scan.nextInt();
                                System.out.println("\nEnter Check-in Date(format: YYYY-MM-DD): ");
                                checkinDate = scan.next();
                                wholePlacesList[choice].setCheckinDates(checkinDate);
                                System.out.println("\nEnter Check-Out Date(format: YYYY-MM-DD): ");
                                checkoutDate = scan.next();
                                wholePlacesList[choice].setCheckoutDates(checkoutDate);
                                wholePlacesList[choice].addedReservation();
                                System.out.println("\n ~~~ Room reserved successfully! ~~~");
                            }
                            else {
                                System.out.println("\n~~~ No rooms available in that city ~~~");
                            }
                        }
                        chooseState = 0;
                        break;
                    case 4:
                        try {
                            FileWriter outputFile = new FileWriter("saved.txt");
                            outputFile.write(countHomeowners + "\n");
                            for (int i = 0; i < countHomeowners; i++) //writes owners data
                            {
                                outputFile.write(homeownerList[i].firstName + " "); //firstname
                                outputFile.write(homeownerList[i].lastName + " "); //lastname
                                outputFile.write(homeownerList[i].ownerID + " "); // id
                                outputFile.write(homeownerList[i].phoneNumber + "\n"); // phone number
                            }
                            outputFile.write(countSharedRooms + "\n"); //writes number of shared rooms
                            for (int i = 0; i < countSharedRooms; i++) { //writes shared rooms data
                                outputFile.write(sharedRoomsList[i].ownerID + " "); //ownerID
                                outputFile.write(sharedRoomsList[i].city + " "); //city
                                outputFile.write(sharedRoomsList[i].address + " "); //address
                                outputFile.write(sharedRoomsList[i].nrOfBeds + "\n"); //number of beds
                                outputFile.write(sharedRoomsList[i].nrOfReservations + " "); //number of reservations
                                for(int j = 0; j < sharedRoomsList[i].getNrOfReservations(); j++) {
                                    outputFile.write(sharedRoomsList[i].checkinDates.get(j) + " "); //check-in dates
                                    outputFile.write(sharedRoomsList[i].checkoutDates.get(j) + "\n"); //check-out dates
                                }
                                outputFile.write("\n");
                            }
                            outputFile.write(countPrivateRooms + "\n"); //writes number of private rooms
                            for (int i = 0; i < countPrivateRooms; i++) { //writes private rooms data
                                outputFile.write(privateRoomsList[i].ownerID + " "); //ownerID
                                outputFile.write(privateRoomsList[i].city + " "); //city
                                outputFile.write(privateRoomsList[i].address + " "); //address
                                outputFile.write(privateRoomsList[i].nrOfBeds + "\n"); //number of beds
                                outputFile.write(privateRoomsList[i].nrOfReservations + " "); //number of reservations
                                System.out.println(privateRoomsList[i].getNrOfReservations() + "~~~");
                                System.out.println(privateRoomsList[i]+"\n");
                                for(int j = 0; j < privateRoomsList[i].getNrOfReservations(); j++) {
                                    outputFile.write(privateRoomsList[i].checkinDates.get(j) + " "); //check-in dates
                                    outputFile.write(privateRoomsList[i].checkoutDates.get(j) + "\n"); //check-out dates
                                }
                                outputFile.write("\n");
                            }
                            outputFile.write(countWholePlaces + "\n"); //writes number of whole places
                            for (int i = 0; i < countWholePlaces; i++) { //writes whole places data
                                outputFile.write(wholePlacesList[i].ownerID + " "); //ownerID
                                outputFile.write(wholePlacesList[i].city + " "); //city
                                outputFile.write(wholePlacesList[i].address + " "); //address
                                outputFile.write(wholePlacesList[i].nrOfBeds + "\n"); //number of beds
                                outputFile.write(wholePlacesList[i].nrOfReservations + " "); //number of reservations
                                for(int j = 0; j < wholePlacesList[i].getNrOfReservations(); j++) {
                                    outputFile.write(wholePlacesList[i].checkinDates.get(j) + " "); //check-in dates
                                    outputFile.write(wholePlacesList[i].checkoutDates.get(j) + "\n"); //check-out dates
                                }
                                outputFile.write("\n");
                            }
                            outputFile.write(countRenters + "\n"); //writes number of renters
                            for(int i = 0; i < countRenters; i++) {
                                outputFile.write(rentersList[i].firstName + " "); //first name
                                outputFile.write(rentersList[i].lastName + " "); //last name
                                outputFile.write(rentersList[i].phoneNumber + "\n"); //phone number
                            }

                            outputFile.close();
                            System.out.println("\n~~~ Successfully saved all owners, renters and rooms/places ! ~~~ ");
                            chooseState = -1;
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("ERROR: WRITING TO FILE");
                        }
                        break;
                    case 5:
                        System.out.println("\nNumber of homeowners: " + countHomeowners);
                        for (int i = 0; i < countHomeowners; i++) //writes owners data
                        {
                            System.out.println("\nFirst name: " + homeownerList[i].getFirstName()); //firstname
                            System.out.println("Last name: " + homeownerList[i].getLastName()); //lastname
                            System.out.println("Owner ID: " + homeownerList[i].getOwnerID()); // id
                            System.out.println("Phone number: " + homeownerList[i].getPhoneNumber()); // phone number
                        }
                        System.out.println("\nNumber of shared rooms: " + countSharedRooms); //writes number of shared rooms
                        for (int i = 0; i < countSharedRooms; i++) { //writes shared rooms data
                            System.out.println("\nOwner ID: " + sharedRoomsList[i].getOwnerID()); //ownerID
                            System.out.println("City: " + sharedRoomsList[i].getCity()); //city
                            System.out.println("Address: " + sharedRoomsList[i].getAddress()); //address
                            System.out.println("Number of beds: " + sharedRoomsList[i].getNrOfBeds()); //number of beds
                            System.out.println("Number of reservations: " + sharedRoomsList[i].nrOfReservations); //number of reservations
                            System.out.println("Check-in dates: " + sharedRoomsList[i].checkinDates); //check-in dates
                            System.out.println("Check-out dates: " + sharedRoomsList[i].checkoutDates); //check-out dates
                        }
                        System.out.println("\nNumber of private rooms: " + countPrivateRooms); //writes number of private rooms
                        for (int i = 0; i < countPrivateRooms; i++) { //writes private rooms data
                            System.out.println("\nOwner ID: " + privateRoomsList[i].getOwnerID()); //ownerID
                            System.out.println("City: " + privateRoomsList[i].getCity()); //city
                            System.out.println("Address: " + privateRoomsList[i].getAddress()); //address
                            System.out.println("Number of beds: " + privateRoomsList[i].getNrOfBeds()); //number of beds
                            System.out.println("Number of reservations: " + privateRoomsList[i].nrOfReservations); //number of reservations
                            System.out.println("Check-in dates: " + privateRoomsList[i].checkinDates); //check-in dates
                            System.out.println("Check-out dates: " + privateRoomsList[i].checkoutDates); //check-out dates
                        }
                        System.out.println("\nNumber of whole places: " + countWholePlaces); //writes number of whole places
                        for (int i = 0; i < countWholePlaces; i++) { //writes whole places data
                            System.out.println("\nOwner ID: " + wholePlacesList[i].getOwnerID()); //ownerID
                            System.out.println("City: " + wholePlacesList[i].getCity()); //city
                            System.out.println("Address: " + wholePlacesList[i].getAddress()); //address
                            System.out.println("Number of beds: " + wholePlacesList[i].getNrOfBeds()); //number of beds
                            System.out.println("Number of reservations: " + wholePlacesList[i].nrOfReservations); //number of reservations
                            System.out.println("Check-in dates: " + wholePlacesList[i].checkinDates); //check-in dates
                            System.out.println("Check-out dates: " + wholePlacesList[i].checkoutDates); //check-out dates
                        }
                        System.out.println("\nNumber of renters: " + countRenters); //writes number of renters
                        for(int i = 0; i < countRenters; i++) {
                            System.out.println("First name: " + rentersList[i].firstName);
                            System.out.println("Last name: " + rentersList[i].lastName);
                            System.out.println("Phone number: " + rentersList[i].phoneNumber);
                        }
                        chooseState = 0;
                        break;
                }
            }
        } else if (chooseState == 1) { //this restores the saved state
            File saveFile = new File("saved.txt"); //select save file
            Scanner inputScan = null;
            try {
                inputScan = new Scanner(saveFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("ERROR: FILENOTFOUND");
            }
            countHomeowners = inputScan.nextInt(); //reads number of owners
            String[] input = new String[3];
            int id = 0, nrBeds = 0, reservations = 0;
            String date;
            for (int i = 0; i < countHomeowners; i++) //reads all owners + their data
            {
                input[0] = inputScan.next(); //firstname
                input[1] = inputScan.next(); //lastname
                id = inputScan.nextInt(); // id
                input[2] = inputScan.next(); // phone number
                homeownerList[i] = new Homeowner(input[0], input[1], id, input[2]); // adds the owner to the list of owners
            }
            countSharedRooms = inputScan.nextInt(); //reads number of shared rooms
            for (int i = 0; i < countSharedRooms; i++) { //reads all shared rooms + their data
                id = inputScan.nextInt(); //ownerID
                input[0] = inputScan.next(); //city
                input[1] = inputScan.next(); //address
                nrBeds = inputScan.nextInt(); //number of beds
                sharedRoomsList[i] = new SharedRoom(id, input[0], input[1], nrBeds); //adds the room to the list of shared rooms
                reservations = inputScan.nextInt();
                sharedRoomsList[i].setNrOfReservations(reservations);
                for(int j = 0; j < reservations; j++)
                {
                    date = inputScan.next();
                    sharedRoomsList[i].setCheckinDates(date);
                    date = inputScan.next();
                    sharedRoomsList[i].setCheckoutDates(date);
                }
            }
            countPrivateRooms = inputScan.nextInt(); //reads number of private rooms
            for (int i = 0; i < countPrivateRooms; i++) { //reads all private rooms + their data
                id = inputScan.nextInt(); //ownerID
                input[0] = inputScan.next(); //city
                input[1] = inputScan.next(); //address
                nrBeds = inputScan.nextInt(); //number of beds
                privateRoomsList[i] = new PrivateRoom(id, input[0], input[1], nrBeds); //adds the room to the list of private rooms
                reservations = inputScan.nextInt();
                privateRoomsList[i].setNrOfReservations(reservations);
                for(int j = 0; j < reservations; j++)
                {
                    date = inputScan.next();
                    privateRoomsList[i].setCheckinDates(date);
                    date = inputScan.next();
                    privateRoomsList[i].setCheckoutDates(date);
                }
            }
            countWholePlaces = inputScan.nextInt(); //reads number of whole places
            for (int i = 0; i < countWholePlaces; i++) { //reads all whole places + their data
                id = inputScan.nextInt(); //ownerID
                input[0] = inputScan.next(); //city
                input[1] = inputScan.next(); //address
                nrBeds = inputScan.nextInt(); //number of beds
                wholePlacesList[i] = new WholePlace(id, input[0], input[1], nrBeds); //adds place to the list of whole places
                reservations = inputScan.nextInt();
                wholePlacesList[i].setNrOfReservations(reservations);
                for(int j = 0; j < reservations; j++)
                {
                    date = inputScan.next();
                    wholePlacesList[i].setCheckinDates(date);
                    date = inputScan.next();
                    wholePlacesList[i].setCheckoutDates(date);
                }
            }
            countRenters = inputScan.nextInt(); //reads number of renters
            for(int i = 0; i < countRenters; i++) { //reads all renters + their data
                input[0] = inputScan.next(); //first name
                input[1] = inputScan.next(); //last name
                input[2] = inputScan.next(); //phone number
                rentersList[i] = new Renter(input[0], input[1], input[2]);
            }
            inputScan.close();
            System.out.println("\n\t\t\t~~~~~~ SAVE STATE RESTORED ! ~~~~~~ \n~~~~~~~~~ SELECT 0 TO BEGIN FROM THE SAVED STATE ~~~~~~~~~");
            menu(); //starts the program with the saved state
        }
    }
    public static void main(String[] args) {
        //Homeowner paul = new Homeowner("Paul", "Cvasa", 1, "0742459683");
        //System.out.println(paul);
        //SharedRoom paul_room = new SharedRoom(1, "Timisoara", "Str. C. Negruzzi Nr. 31", 2);
        //System.out.println(paul_room);


        menu();


    }
}
