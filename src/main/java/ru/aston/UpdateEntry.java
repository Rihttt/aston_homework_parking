package ru.aston;

import ru.aston.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class UpdateEntry {

    public UpdateEntry() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
    }
}
