package ucr.ac.ecci.ci1312.phase2.core.student.dao;

import ucr.ac.ecci.ci1312.phase2.model.Student;

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

public interface StudentDao {
    /**
     * Find a student by the id.
     * @param id the id we are looking for.
     * @return the resulting student.
     */
    Student findById(String id);
    /**
     * Create a student with all the data sent from the load.
     * @param entity the student.
     * @return
     */
    String create(Student entity);
    /**
     * Update a given student with new data.
     * @param entity the modifying student.
     */
    void update(Student entity);
    /**
     * Remove the student from the database.
     * @param entity the removing student.
     */
    void remove(Student entity);
}
