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

public abstract class User {
    private String email;
    private String firstName;
    private String firstLastName;
    private String secondLastName;
    private Date birthDate;
    private String password;
    private boolean isEnabled;

    /**
     * Sets the parameters for the construction of an administrator of student object, that implements this interface.
     * @param email the email.
     * @param firstName the first name.
     * @param firstLastName the last name.
     * @param secondLastName the second last name.
     * @param birthDate the birth date.
     * @param password the password.
     * @param isEnabled the enabled state.
     */
    public User(String email, String firstName, String firstLastName, String secondLastName,Date birthDate, String password, boolean isEnabled){
        this.email = email;
        this.firstName = firstName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.password = password;
        this.isEnabled = isEnabled;
    }

    /**
     * Return the email of the user.
     * @return the email of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Return the first name of the user.
     * @return the first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return the first last name of the user.
     * @return the first last name of the user.
     */
    public String getFirstLastName() {
        return firstLastName;
    }

    /**
     * Return the second last name of the user.
     * @return the second last name of the user.
     */
    public String getSecondLastName() {
        return secondLastName;
    }

    /**
     * Return the birthdate of the user.
     * @return the birthdate of the user.
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Return the password of the user.
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Return the password of the user.
     * @return the password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Return the enabled state of the user.
     * @return the enabled state of the user.
     */
    public boolean isEnabled() {
        return isEnabled;
    }

}
