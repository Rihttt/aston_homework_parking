package ru.aston;

import ru.aston.dao.VehicleDao;
import ru.aston.db.DBConnection;
import ru.aston.model.Vehicle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEntry {

    public UpdateEntry() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        while(true)  {
            System.out.println("Обновление записи\n"+
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
                    VehicleDao dao = new VehicleDao();
                    Vehicle record = new Vehicle();

                    System.out.println("Введите id записи, которую хотите изменить:\n");
                    int id = scanner.nextInt();
                    System.out.println("Введите новый номерной знак: \n" );
                    String plate = scanner.next();
                    System.out.println("Введите новую модель машины: \n" );
                    String model = scanner.next();
                    System.out.println("Введите новый год производства: \n" );
                    String year = scanner.next();


                    record.setPlate(plate);
                    record.setModel(model);
                    record.setRelease_year(year);

                    dao.update(record, id);

                    break;
                }

                case 5:{
                    return;
                }
            }
        }
    }
}
