package Service;

import Dao.AppointmentDao;
import Model.Appointment;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class AppointmentService {
    private AppointmentDao appointmentDao;

    public AppointmentService(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        return appointmentDao.getAllAppointments();
    }

    public void bookAppointment(Appointment appointment) throws SQLException {
        appointmentDao.bookAppointment(appointment);
    }

    public boolean isDoctorAvailable(int doctorId, LocalDateTime appointmentDateTime) throws SQLException {
        return appointmentDao.isDoctorAvailable(doctorId, appointmentDateTime);
    }
}



