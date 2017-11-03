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

public class Administrator extends User{
    private String idCard;

    /**
     * Constructs an administrator object.
     * @param email the email.
     * @param idCard the idCard.
     * @param firstName the first name.
     * @param lastName the last name.
     * @param secondLastName the second last name.
     * @param birthDate the birth date.
     * @param password the password.
     * @param isEnabled the enabled status.
     */
    public Administrator(String email, String idCard, String firstName, String lastName, String secondLastName, Date birthDate,
                         String password, boolean isEnabled){
        super(email, firstName, lastName, secondLastName, birthDate, password, isEnabled);
        this.idCard = idCard;
    }

    /**
     * Returns the id card of an administrator
     * @return the id card of the adminsitrator
     */
    public String getIdCard() {
        return idCard;
    }


}
