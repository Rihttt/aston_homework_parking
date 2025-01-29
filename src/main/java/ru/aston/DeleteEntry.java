package ru.aston;

import ru.aston.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteEntry {
    Connection connection = DBConnection.getInstance().getConnection();

    public DeleteEntry() throws SQLException {
    }
}
