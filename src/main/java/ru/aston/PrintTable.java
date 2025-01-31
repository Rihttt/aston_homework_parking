package ru.aston;

import ru.aston.dao.VehicleDao;
import ru.aston.db.DBConnection;
import ru.aston.model.ParkingObject;
import ru.aston.model.Vehicle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PrintTable {

    public PrintTable() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        while(true)  {
            System.out.println("Вывод таблиц\n"+
                    "Выберите таблицу: \n" +
                    "1. Пользователи\n" +
                    "2. Парковочные талоны\n" +
                    "3. Парковочные места\n" +
                    "4. Машины\n"+
                    "5. Назад\n");
            Scanner scanner = new Scanner(System.in);
            int j = scanner.nextInt();

            switch (j){

                case 1:{

                    break;
                }

                case 2:{

                    break;
                }

                case 3:{

                    break;
                }

                case 4:{
                    VehicleDao vehicleDao = new VehicleDao();
                    List<Vehicle> records = vehicleDao.findAll();
                    if (records.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        records.stream().map(Vehicle::toString).forEach(System.out::println);
                    }
                    break;
                }

                case 5:{
                    return;
                }
            }
        }
    }
}
