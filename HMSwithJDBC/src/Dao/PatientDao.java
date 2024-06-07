package Dao;
import Model.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {
    private Connection connection;

    public PatientDao(Connection connection) {
        this.connection = connection;
    }

    public void addPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patients (name, age, gender) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, patient.getName());
        preparedStatement.setInt(2, patient.getAge());
        preparedStatement.setString(3, patient.getGender());
        preparedStatement.executeUpdate();
    }

    public void updatePatient(Patient patient) throws SQLException {
        String query = "UPDATE patients SET name = ?, age = ?, gender = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, patient.getName());
        preparedStatement.setInt(2, patient.getAge());
        preparedStatement.setString(3, patient.getGender());
        preparedStatement.setInt(4, patient.getId());
        preparedStatement.executeUpdate();
    }

    public void deletePatient(int patientId) throws SQLException {
        String query = "DELETE FROM patients WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, patientId);
        preparedStatement.executeUpdate();
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patients";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Patient patient = new Patient();
            patient.setId(resultSet.getInt("id"));
            patient.setName(resultSet.getString("name"));
            patient.setAge(resultSet.getInt("age"));
            patient.setGender(resultSet.getString("gender"));
            patients.add(patient);
        }
        return patients;
    }

    public boolean getPatientById(int id) throws SQLException {
        String query = "SELECT * FROM patients WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}



