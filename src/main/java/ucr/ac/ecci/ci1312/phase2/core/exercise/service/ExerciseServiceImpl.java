package ucr.ac.ecci.ci1312.phase2.core.exercise.service;

import ucr.ac.ecci.ci1312.phase2.core.exercise.dao.ExerciseDao;
import ucr.ac.ecci.ci1312.phase2.core.exercise.dao.JdbcExerciseDao;
import ucr.ac.ecci.ci1312.phase2.model.Exercise;

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

public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseDao ed;

    public ExerciseServiceImpl(){
        this.ed = new JdbcExerciseDao();
    }

    @Override
    public Exercise findById(String id) {
        return this.ed.findById(id);
    }

    @Override
    public String create(Exercise entity) {
        return this.ed.create(entity);
    }

    @Override
    public void update(Exercise entity) {
        this.ed.update(entity);
    }

    @Override
    public void remove(Exercise entity) {
        this.ed.remove(entity);
    }
}
