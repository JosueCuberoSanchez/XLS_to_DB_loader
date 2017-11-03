package ucr.ac.ecci.ci1312.phase2.core.student.service;

import ucr.ac.ecci.ci1312.phase2.build.Encryptor;
import ucr.ac.ecci.ci1312.phase2.core.student.dao.JdbcStudentDao;
import ucr.ac.ecci.ci1312.phase2.core.student.dao.StudentDao;
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

public class StudentServiceImpl implements StudentService {

    private StudentDao sd;

    public StudentServiceImpl(){
        this.sd = new JdbcStudentDao();
    }

    @Override
    public Student findById(String id) {
        return this.sd.findById(id);
    }

    @Override
    public String create(Student entity) {
        entity.setPassword(Encryptor.encryptPassword(entity.getPassword()));
        return this.sd.create(entity);
    }

    @Override
    public void update(Student entity) {
        this.sd.update(entity);
    }

    @Override
    public void remove(Student entity) {
        this.sd.remove(entity);
    }
}
