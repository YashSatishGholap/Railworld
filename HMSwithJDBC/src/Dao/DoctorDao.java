package Dao;
import Model.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {
    private Connection connection;

    public DoctorDao(Connection connection) {
        this.connection = connection;
    }

    public void addDoctor(Doctor doctor) throws SQLException {
        String query = "INSERT INTO doctors (name, specialization) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, doctor.getName());
        preparedStatement.setString(2, doctor.getSpecialization());
        preparedStatement.executeUpdate();
    }

    public void updateDoctor(Doctor doctor) throws SQLException {
        String query = "UPDATE doctors SET name = ?, specialization = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, doctor.getName());
        preparedStatement.setString(2, doctor.getSpecialization());
        preparedStatement.setInt(3, doctor.getId());
        preparedStatement.executeUpdate();
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctors";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Doctor doctor = new Doctor();
            doctor.setId(resultSet.getInt("id"));
            doctor.setName(resultSet.getString("name"));
            doctor.setSpecialization(resultSet.getString("specialization"));
            doctors.add(doctor);
        }
        return doctors;
    }

    public boolean getDoctorById(int id) throws SQLException {
        String query = "SELECT * FROM doctors WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public void deleteDoctor(int doctorId) throws SQLException {
        String query = "DELETE FROM doctors WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, doctorId);
        preparedStatement.executeUpdate();
    }

}





