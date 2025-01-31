package ru.aston;

import ru.aston.dao.VehicleDao;
import ru.aston.db.DBConnection;
import ru.aston.model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddEntry {

    public AddEntry() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        while(true)  {
            System.out.println("Добавление записи\n"+
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


                    scanner.nextLine();
                    break;
                }

                case 2:{
                    //По аналогии с vehicle
                    scanner.nextLine();
                    break;
                }

                case 3:{
                    //По аналогии с vehicle
                    scanner.nextLine();
                    break;
                }

                case 4:{
                    VehicleDao dao = new VehicleDao();
                    Vehicle record = new Vehicle();

                    System.out.println("Введите номерной знак: \n" );
                    String plate = scanner.next();
                    System.out.println("Введите модель машины: \n" );
                    String model = scanner.next();
                    System.out.println("Введите год производства: \n" );
                    String year = scanner.next();

                    record.setPlate(plate);
                    record.setModel(model);
                    record.setRelease_year(year);

                    dao.save(record);
                    System.out.println("Vehicle added successfully!");

                    scanner.nextLine();
                    break;
                }

                case 5:{
                    return;
                }
            }
        }
    }

}
