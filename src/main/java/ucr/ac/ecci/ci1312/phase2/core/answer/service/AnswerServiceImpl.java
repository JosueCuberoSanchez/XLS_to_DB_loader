package ucr.ac.ecci.ci1312.phase2.core.answer.service;

import ucr.ac.ecci.ci1312.phase2.core.answer.dao.AnswerDao;
import ucr.ac.ecci.ci1312.phase2.core.answer.dao.JdbcAnswerDao;
import ucr.ac.ecci.ci1312.phase2.model.Answer;

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

public class AnswerServiceImpl implements AnswerService {

    private AnswerDao ad;

    public AnswerServiceImpl(){
        this.ad = new JdbcAnswerDao();
    }

    @Override
    public Answer findById(String id) {
        return this.ad.findById(id);
    }

    @Override
    public String create(Answer entity) {
        return this.ad.create(entity);
    }

    @Override
    public void update(Answer entity) {
        this.ad.update(entity);
    }

    @Override
    public void remove(Answer entity) {
        this.ad.remove(entity);
    }
}
