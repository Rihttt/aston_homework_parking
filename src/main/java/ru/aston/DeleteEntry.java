package ru.aston;

import ru.aston.dao.VehicleDao;
import ru.aston.db.DBConnection;
import ru.aston.model.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEntry {

    public DeleteEntry() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        while(true)  {
            System.out.println("Удаление записи\n"+
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
                    System.out.println("Введите id записи, которую хотите удалить:\n");
                    int id = scanner.nextInt();
                    dao.deleteById(id);
                    break;
                }

                case 5:{
                    return;
                }
            }
        }
    }
}
