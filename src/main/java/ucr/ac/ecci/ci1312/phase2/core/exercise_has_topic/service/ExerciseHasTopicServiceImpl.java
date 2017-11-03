package ucr.ac.ecci.ci1312.phase2.core.exercise_has_topic.service;

import ucr.ac.ecci.ci1312.phase2.core.exercise_has_topic.dao.ExerciseHasTopicDao;
import ucr.ac.ecci.ci1312.phase2.core.exercise_has_topic.dao.JdbcExerciseHasTopicDao;
import ucr.ac.ecci.ci1312.phase2.model.ExerciseHasTopic;

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

public class ExerciseHasTopicServiceImpl implements ExerciseHasTopicService {

    private ExerciseHasTopicDao ehtd;

    public ExerciseHasTopicServiceImpl(){
        this.ehtd = new JdbcExerciseHasTopicDao();
    }

    @Override
    public ExerciseHasTopic findById(String id) {
        return this.ehtd.findById(id);
    }

    @Override
    public String create(ExerciseHasTopic entity) {
        return this.ehtd.create(entity);
    }

    @Override
    public void update(ExerciseHasTopic entity) {
        this.ehtd.update(entity);
    }

    @Override
    public void remove(ExerciseHasTopic entity) {
        this.ehtd.remove(entity);
    }
}
