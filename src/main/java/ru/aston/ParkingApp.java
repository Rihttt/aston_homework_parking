package ru.aston;

import org.h2.tools.Server;
import ru.aston.dao.SimpleDao;
import ru.aston.dao.VehicleDao;
import ru.aston.db.H2DBInitializer;
import ru.aston.model.ParkingObject;
import ru.aston.model.Vehicle;

import java.sql.SQLException;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ParkingApp {

    public static void main (String[] args) throws SQLException {

        H2DBInitializer initializer = new H2DBInitializer();
        initializer.initialize();
        VehicleDao vehicleDao = new VehicleDao();
        //ParkingTicketDao parkingTicketDao = new ParkingTicketDao и т.д.

        //для мониторинга бд в реальном времени
        Server h2WebServer = org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
        h2WebServer.start();

        while(true){

            System.out.println("Выберите таблицу: \n"+
                    "1. Пользователи\n"+
                    "2. Парковочные талоны\n"+
                    "3. Парковочные места\n"+
                    "4. Машины\n"+
                    "5. Выход\n");
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();

            switch (k){
                case 1:{
                    //displaySubMenu(userDao, k);
                    break;
                }

                case 2:{
                    //displaySubMenu(parkingTicketsDao, k);
                    break;
                }

                case 3:{
                    //displaySubMenu(parkingSpotsDao, k);
                    break;
                }

                case 4:{
                    displaySubMenu(vehicleDao, k);
                    break;
                }

                case 5: {
                    h2WebServer.stop();
                    return;
                }
                default:{System.out.println("Wrong key");}
            }
        }
    }

    public static <T extends ParkingObject> void displaySubMenu(SimpleDao<T> dao, int chosenKey) {
        while(true)  {
            System.out.println("\nВыберите действие: \n" +
                    "1. Добавить запись\n" +
                    "2. Удалить запись\n" +
                    "3. Найти запись по id\n" +
                    "4. Вывести таблицу\n"+
                    "5. Назад\n");
            Scanner scanner = new Scanner(System.in);
            int j = scanner.nextInt();

            switch (j){

                case 1:{
                    switch (chosenKey){
                        case 1:{break;}
                        case 2:{break;}
                        case 3:{break;}
                        case 4:{addNewVehicle((VehicleDao) dao);break;}
                    }
                    break;
                }

                case 2:{
                    deleteRecordById(dao);
                    break;
                }

                case 3:{
                    findRecordById(dao);
                    break;
                }

                case 4:{
                    listRecords(dao);
                    break;
                }

                case 5:{
                    return;
                }
                default:{System.out.println("Wrong key");}
            }
        }
    }

    private static void addNewVehicle(VehicleDao dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номерной знак: \n" );
        String plate = scanner.next();
        System.out.println("Введите модель машины: \n" );
        String model = scanner.next();
        System.out.println("Введите год производства: \n" );
        String year = scanner.next();

        Vehicle record = new Vehicle();
        record.setPlate(plate);
        record.setModel(model);
        record.setRelease_year(year);

        dao.save(record);
        System.out.println("Vehicle added successfully!");
    }

    private static <T extends ParkingObject> void listRecords(SimpleDao<T> dao) {
        List<T> records = dao.findAll();
        if (records.isEmpty()) {
            System.out.println("No entry found.");
        } else {
            records.stream().map(T::toString).forEach(System.out::println);
        }
    }

    private static <T> void findRecordById(SimpleDao<T> dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        int recordId = scanner.nextInt();
        Optional<T> optRecord = dao.findById(recordId);

        optRecord.ifPresentOrElse(
                item -> System.out.println(item.toString()),
                () -> System.out.println("No entry found.")
        );
    }

    private static <T> void deleteRecordById(SimpleDao<T> dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        int recordId = scanner.nextInt();
        dao.deleteById(recordId);
    }
}
