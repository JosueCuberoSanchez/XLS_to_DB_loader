package ucr.ac.ecci.ci1312.phase2.model;
import java.util.Date;

/**
 * Universidad de Costa Rica.
 * Facultad de Ingeniería.
 * Escuela de Ciencias de la Computación e Informática.
 * Proyecto: Bases de Datos 1.
 * Profesor Rodrigo Bartels.
 * Autores:
 * Cubero Sánchez Josué B42190
 * Durán Gregory Ian B42322
 * Garita Centeno Alonso B42791
 * Primer Ciclo 2017
 */

public class Student extends User {
    private String studentId;
    private Date lastLogin;

    /**
     * Constructs a student object.
     *
     * @param studentId      the id.
     * @param email          the email.
     * @param name           the name.
     * @param lastName       the last name.
     * @param secondLastName the second last name.
     * @param birthDate      the birth date.
     * @param password       the password.
     * @param isEnabled      the enabled state.
     */
    public Student(String email, String studentId, String name, String lastName, String secondLastName,
                   Date birthDate, String password, boolean isEnabled){
        super(email, name, lastName, secondLastName, birthDate, password,  isEnabled);
        this.studentId = studentId;
        this.lastLogin = lastLogin;
    }

    /**
     * Return the student id.
     *
     * @return the student id.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Return the last login.
     *
     * @return the last login.
     */
    public Date getLastLogin() {
        return lastLogin;
    }


}

