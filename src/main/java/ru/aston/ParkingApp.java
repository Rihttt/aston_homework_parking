package ru.aston;

import org.h2.tools.Server;
import ru.aston.db.DBConnection;
import ru.aston.db.H2DBInitializer;


import java.sql.Connection;
import java.sql.SQLException;

import java.util.Scanner;

public class ParkingApp {

    public static void main (String[] args) throws SQLException {

        H2DBInitializer initializer = new H2DBInitializer();
        initializer.initialize();
        Connection connection = DBConnection.getInstance().getConnection();

        Server h2WebServer = org.h2.tools.Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
        h2WebServer.start();

        while(true){

            System.out.println("Выберите действие: \n"+
                    "1. Добавить запись\n"+
                    "2. Удалить запись\n"+
                    "3. Обновить запись\n"+
                    "4. Вывести таблицу\n"+
                    "5. Запросы\n"+
                    "6. Выход\n");
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();

            switch (k){
                case 1:{
                    new AddEntry(connection);
                    break;
                }
                case 2:{
                    new DeleteEntry(connection);
                }
                case 3:{
                    new UpdateEntry(connection);
                    break;
                }

                case 4:{
                    new PrintTable(connection);
                    break;
                }

                case 5:{
                    new QueryExecution(connection);
                    break;
                }
                case 6:
                    h2WebServer.stop();
                    return;
            }
        }


    }
}
