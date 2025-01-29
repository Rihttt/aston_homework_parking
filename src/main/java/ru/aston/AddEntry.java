package ru.aston;

import ru.aston.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddEntry {

    public AddEntry() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        while(true)  {
            System.out.println("Выберите таблицу: \n" +
                    "1. Пользователи\n" +
                    "2. Парковочные талоны\n" +
                    "3. Парковочные места\n" +
                    "4. Машины\n"+
                    "5. Назад\n");
            Scanner scanner = new Scanner(System.in);
            int j = scanner.nextInt();

            switch (j){

                case 1:{

                    System.out.println("Введите имя: \n" );
                    String name = scanner.next();
                    System.out.println("Введите фамилию: \n" );
                    String lastName = scanner.next();

                    String sql = "INSERT INTO users (first_name, last_name) VALUES (?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, lastName);

                        int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Пользователь успешно добавлен.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    scanner.nextLine();
                    break;
                }

                case 2:{

                    System.out.println("Введите id пользователя(INT): \n" );
                    int id = scanner.nextInt();
                    System.out.println("Введите имя пользователя: \n" );
                    String name = scanner.next();
                    System.out.println("Введите id парковочного места: \n" );
                    int place_id = scanner.nextInt();
                    System.out.println("Введите id машины: \n" );
                    int vehicle_id = scanner.nextInt();
                    System.out.println("Введите дату получения талона в формате 'ГГГГ-ММ-ДД 00:00': \n" );
                    String ac_date = scanner.next();
                    System.out.println("Введите дату окончания талона в формате 'ГГГГ-ММ-ДД 00:00': \n" );
                    String exp_date = scanner.next();

                    String sql = "INSERT INTO parking_ticket (user_id, user_name, place_id, vehicle_id, acquire_date, expire_date) VALUES (?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setInt(1, id);
                        preparedStatement.setString(2, name);
                        preparedStatement.setInt(3, place_id);
                        preparedStatement.setInt(4, vehicle_id);
                        preparedStatement.setString(5, ac_date);
                        preparedStatement.setString(6, exp_date);

                        int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Талон успешно добавлен.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    scanner.nextLine();
                    break;
                }

                case 3:{

                    System.out.println("Введите этаж(1-4): \n" );
                    int floor = scanner.nextInt();
                    System.out.println("Введите номер места(1-30): \n" );
                    int place = scanner.nextInt();
                    System.out.println("Занято ли место: \n" );
                    boolean isEmpty = scanner.nextBoolean();

                    String sql = "INSERT INTO parking_place (floor, place_number, isEmpty) VALUES (?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setInt(1, floor);
                        preparedStatement.setInt(2, place);
                        preparedStatement.setBoolean(3, isEmpty);

                        int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Парковочное место успешно добавлено.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    scanner.nextLine();
                    break;
                }

                case 4:{

                    System.out.println("Введите номерной знак: \n" );
                    String plate = scanner.next();
                    System.out.println("Введите модель машины: \n" );
                    String model = scanner.next();
                    System.out.println("Введите год производства: \n" );
                    String year = scanner.next();

                    String sql = "INSERT INTO parking_place (plate, model, release_year) VALUES (?, ?, ?)";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, plate);
                        preparedStatement.setString(2, model);
                        preparedStatement.setString(3, year);

                        int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Машина успешно добавлена.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

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
