package ucr.ac.ecci.ci1312.phase2.core.exercise_has_reference.service;

import ucr.ac.ecci.ci1312.phase2.core.exercise_has_reference.dao.ExerciseHasReferenceDao;
import ucr.ac.ecci.ci1312.phase2.core.exercise_has_reference.dao.JdbcExerciseHasReferenceDao;
import ucr.ac.ecci.ci1312.phase2.model.ExerciseHasReference;

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

public class ExerciseHasReferenceServiceImpl implements ExerciseHasReferenceService {

    private ExerciseHasReferenceDao ehrd;

    public ExerciseHasReferenceServiceImpl(){
        this.ehrd = new JdbcExerciseHasReferenceDao();
    }

    @Override
    public ExerciseHasReference findById(String id) {
        return this.ehrd.findById(id);
    }

    @Override
    public String create(ExerciseHasReference entity) {
        return this.ehrd.create(entity);
    }

    @Override
    public void update(ExerciseHasReference entity) {
        this.ehrd.update(entity);
    }

    @Override
    public void remove(ExerciseHasReference entity) {
        this.ehrd.remove(entity);
    }
}
