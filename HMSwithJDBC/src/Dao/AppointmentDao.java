package Dao;

import Model.Appointment;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
    private Connection connection;

    public AppointmentDao(Connection connection) {
        this.connection = connection;
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Appointment appointment = new Appointment();
            appointment.setId(resultSet.getInt("id"));
            appointment.setPatientId(resultSet.getInt("patient_id"));
            appointment.setDoctorId(resultSet.getInt("doctor_id"));
            appointment.setAppointmentDateTime(resultSet.getTimestamp("appointment_date_time").toLocalDateTime());
            appointments.add(appointment);
        }
        return appointments;
    }

    public void bookAppointment(Appointment appointment) throws SQLException {
        String query = "INSERT INTO appointments (patient_id, doctor_id, appointment_date_time) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, appointment.getPatientId());
        preparedStatement.setInt(2, appointment.getDoctorId());
        preparedStatement.setTimestamp(3, Timestamp.valueOf(appointment.getAppointmentDateTime()));
        preparedStatement.executeUpdate();
    }

    public boolean isDoctorAvailable(int doctorId, LocalDateTime appointmentDateTime) throws SQLException {
        String query = "SELECT COUNT(*) FROM appointments WHERE doctor_id = ? AND appointment_date_time = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, doctorId);
        preparedStatement.setTimestamp(2, Timestamp.valueOf(appointmentDateTime));
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1) == 0;
    }
}

