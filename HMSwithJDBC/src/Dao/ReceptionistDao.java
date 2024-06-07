package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReceptionistDao {
    private Connection connection;

    public ReceptionistDao(Connection connection) {
        this.connection = connection;
    }

    public void recordTransaction(int doctorId, double fee) throws SQLException {
        String query = "INSERT INTO transactions (doctor_id, fee) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, doctorId);
        preparedStatement.setDouble(2, fee);
        preparedStatement.executeUpdate();
    }
}
