package ucr.ac.ecci.ci1312.phase2.build;

import java.security.MessageDigest;
import java.util.Base64;

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

public class Encryptor {
    /**
     * Method to encrypt the given passwords for students and administrators using SHA-1 and Base64.
     * @param password the non-encrypted password.
     * @return the encrypted password.
     */
    public static String encryptPassword(String password){
        String encryptedPassword = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            encryptedPassword = Base64.getEncoder().encodeToString(crypt.digest(password.getBytes("UTF-8")));
        }catch(Exception e){
            e.printStackTrace();
        }
        return encryptedPassword;
    }
}
