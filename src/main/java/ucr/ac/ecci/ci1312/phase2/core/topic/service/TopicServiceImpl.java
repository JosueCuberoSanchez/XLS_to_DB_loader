package ucr.ac.ecci.ci1312.phase2.core.topic.service;

import ucr.ac.ecci.ci1312.phase2.core.topic.dao.JdbcTopicDao;
import ucr.ac.ecci.ci1312.phase2.core.topic.dao.TopicDao;
import ucr.ac.ecci.ci1312.phase2.model.Topic;

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

public class TopicServiceImpl implements TopicService{
    private TopicDao topicDao;

    public TopicServiceImpl(){
        this.topicDao = new JdbcTopicDao();
    }
    @Override
    public Topic findById(String id) {
        return this.topicDao.findById(id);
    }

    @Override
    public String create(Topic entity) {
        return this.topicDao.create(entity);
    }

    @Override
    public void update(Topic entity) {
        this.topicDao.update(entity);
    }

    @Override
    public void remove(Topic entity) {
        this.topicDao.remove(entity);
    }
}
