package Service;
import Dao.DoctorDao;
import Model.Doctor;
import java.sql.SQLException;
import java.util.List;

public class DoctorService {
    private DoctorDao doctorDao;

    public DoctorService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }
    public void addDoctor(Doctor doctor) throws SQLException {
        doctorDao.addDoctor(doctor);
    }
    public void updateDoctor(Doctor doctor) throws SQLException {
        doctorDao.updateDoctor(doctor);
    }

    public void deleteDoctor(int doctorId) throws SQLException {
        doctorDao.deleteDoctor(doctorId);
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        return doctorDao.getAllDoctors();
    }

    public boolean getDoctorById(int id) throws SQLException {
        return doctorDao.getDoctorById(id);
    }
}
