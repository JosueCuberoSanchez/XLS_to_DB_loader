package ucr.ac.ecci.ci1312.phase2.core.exercise_has_topic.dao;

import ucr.ac.ecci.ci1312.phase2.model.ExerciseHasTopic;

import java.sql.*;
import java.util.Properties;

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

public class JdbcExerciseHasTopicDao implements ExerciseHasTopicDao {
    private Connection connection;
    private Statement statement;

    public JdbcExerciseHasTopicDao(){
        try{
            this.connection = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "Blackfolgore666");
            this.connection = DriverManager.getConnection(
                    "jdbc:" + "mysql" + "://" +
                            "localhost" +
                            ":" + "3306" + "/xBase?autoReconnect=true&useSSL=false",
                    connectionProps);
            System.out.println("Connected to database");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ExerciseHasTopic findById(String id) {
        ExerciseHasTopic result = null;
        return result;
    }

    @Override
    public String create(ExerciseHasTopic entity) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO exercise_has_topic VALUES (?, ?);");
            ps.setString(1, entity.getFkExercise());
            ps.setString(2, entity.getFkTopic());
            ps.executeUpdate();
        }catch(Exception e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(ExerciseHasTopic entity) {

    }

    @Override
    public void remove(ExerciseHasTopic entity) {
        try {
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM exercise_has_topic WHERE fk_exercise = ? AND fk_topic = ?");
            statement.setString(1, entity.getFkExercise());
            statement.setString(2, entity.getFkTopic());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
