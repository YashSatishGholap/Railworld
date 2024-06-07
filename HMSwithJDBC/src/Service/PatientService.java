package Service;

import Dao.PatientDao;
import Model.Patient;
import java.sql.SQLException;
import java.util.List;

public class PatientService {
    private PatientDao patientDao;

    public PatientService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public void addPatient(Patient patient) throws SQLException {
        patientDao.addPatient(patient);
    }

    public void updatePatient(Patient patient) throws SQLException {
        patientDao.updatePatient(patient);
    }

    public void deletePatient(int patientId) throws SQLException {
        patientDao.deletePatient(patientId);
    }

    public List<Patient> getAllPatients() throws SQLException {
        return patientDao.getAllPatients();
    }

    public boolean getPatientById(int id) throws SQLException {
        return patientDao.getPatientById(id);
    }
}
