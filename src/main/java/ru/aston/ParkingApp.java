package ru.aston;

import ru.aston.dao.ParkingSpotDao;
import ru.aston.db.DatabaseInitializer;
import ru.aston.db.H2DatabaseInitializer;
import ru.aston.model.ParkingSpot;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ParkingApp
{
    public static void main( String[] args ) {
        DatabaseInitializer initializer = new H2DatabaseInitializer();
        initializer.initialize();

        ParkingSpotDao parkingSpotDao =  new ParkingSpotDao();
        displayMenu();

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.print("\n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    listParkingSpots(parkingSpotDao);
                    break;
                case 2:
                    addNewParkingSpot(parkingSpotDao);
                    break;
                case 3:
                    findByIdParkingSpot(parkingSpotDao);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. List all parking spots");
        System.out.println("2. Add a new parking spot");
        System.out.println("3. Find parking spot by Id");
        System.out.println("0. Exit");
        System.out.println("==========================");
    }

    private static void listParkingSpots(ParkingSpotDao dao) {
        List<ParkingSpot> parkingSpots = dao.findAll();
        if (parkingSpots.isEmpty()) {
            System.out.println("No parking spots found.");
        } else {
            parkingSpots.stream().map(ParkingSpot::toString).forEach(System.out::println);
        }
    }

    private static void addNewParkingSpot(ParkingSpotDao dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter spot number: ");
        int spotNumber = scanner.nextInt();

        ParkingSpot spot = new ParkingSpot();
        spot.setSpotNumber(spotNumber);
        spot.setAvailable(true);

        dao.save(spot);
        System.out.println("Parking spot added successfully!");
    }

    private static void findByIdParkingSpot(ParkingSpotDao dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parking spot id: ");
        int spotId = scanner.nextInt();
        Optional<ParkingSpot> optSpot = dao.findById(spotId);

        optSpot.ifPresentOrElse(
                spot -> System.out.println(spot.toString()),
                () -> System.out.println("No parking spots found.")
        );
    }
}
