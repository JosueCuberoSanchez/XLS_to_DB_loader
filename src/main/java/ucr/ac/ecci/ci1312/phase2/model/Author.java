package ucr.ac.ecci.ci1312.phase2.model;
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

public class Author {
    private String id;
    private String firstName;
    private String lastName;
    private String secondLastName;

    public Author(String id, String firstName, String lastName, String secondLastName){
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

}

