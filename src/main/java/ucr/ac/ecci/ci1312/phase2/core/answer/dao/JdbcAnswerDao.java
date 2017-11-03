package ucr.ac.ecci.ci1312.phase2.core.answer.dao;

import ucr.ac.ecci.ci1312.phase2.core.enums.AnswerType;
import ucr.ac.ecci.ci1312.phase2.model.Answer;

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

public class JdbcAnswerDao implements AnswerDao {
    private Connection connection;
    private Statement statement;

    public JdbcAnswerDao(){
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
    public Answer findById(String id) {
        Answer result = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM answer WHERE answer_id = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs != null){
                rs.first();
                result = new Answer(rs.getString("answer_id"), rs.getBoolean("is_correct"),
                        rs.getBoolean("is_deleted"), rs.getBoolean("is_visible"), rs.getDouble("numerical_answer"),
                        rs.getString("unit"), rs.getString("content"), rs.getString("image_path"),
                        rs.getString("source_code"), rs.getString("programming_language"),
                        rs.getString("fk_exercise"), rs.getBoolean("isPractical"),
                        AnswerType.valueOf(rs.getString("answer_type")));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public String create(Answer entity) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("INSERT INTO answer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, entity.getAnswerId());
            statement.setBoolean(2, entity.isCorrect());
            statement.setBoolean(3, entity.isDeleted());
            statement.setBoolean(4, entity.isVisible());
            if(entity.getNumber() != null) {
                statement.setDouble(5, entity.getNumber());
            }else{
                statement.setNull(5, Types.DECIMAL);
            }
            if(!entity.getMeasurementUnit().equalsIgnoreCase("null")) {
                statement.setString(6, entity.getMeasurementUnit());
            }else{
                statement.setNull(6, Types.VARCHAR);
            }
            if(!entity.getContent().equalsIgnoreCase("null")) {
                statement.setString(7, entity.getContent());
            }else{
                statement.setNull(7, Types.VARCHAR);
            }
            if(!entity.getImage().equalsIgnoreCase("null")) {
                statement.setString(8, entity.getImage());
            }else{
                statement.setNull(8, Types.VARCHAR);
            }
            if(!entity.getCode().equalsIgnoreCase("null")) {
                statement.setString(9, entity.getCode());
            }else{
                statement.setNull(9, Types.VARCHAR);
            }
            if(!entity.getLanguage().equalsIgnoreCase("null")) {
                statement.setString(10, entity.getLanguage());
            }else{
                statement.setNull(10, Types.VARCHAR);
            }
            statement.setString(11, entity.getFkExercise());
            statement.setBoolean(12, entity.isPractical());
            statement.setString(13, entity.getAnswerType().name());
            /*Asumiendo que a la sentencia ocupa la enum en forma de string*/
            //TODO: REVISAR ESTO

            statement.executeUpdate();
        }catch ( Exception e){
            //e.getMessage();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Answer entity) {
        try {
            PreparedStatement statement =
                    this.connection.prepareStatement("UPDATE answer SET " +
                            "is_correct = ?," +
                            "is_deleted = ?," +
                            "is_visible = ?," +
                            "numerical_answer = ?," +
                            "unit = ?," +
                            "content = ?," +
                            "image_path = ?," +
                            "source_code = ?," +
                            "programming_language = ?," +
                            "fk_exercise = ?," +
                            "is_practical = ?," +
                            "answer_type = ?" +
                            "WHERE answer_id = ?");

            statement.setBoolean(1, entity.isCorrect());
            statement.setBoolean(2, entity.isDeleted());
            statement.setBoolean(3, entity.isVisible());
            statement.setDouble(4, entity.getNumber());
            statement.setString(5, entity.getMeasurementUnit());
            statement.setString(6, entity.getContent());
            statement.setString(7, entity.getImage());
            statement.setString(8, entity.getCode());
            statement.setString(9, entity.getLanguage());
            statement.setString(10, entity.getFkExercise());
            statement.setBoolean(11, entity.isPractical());
            statement.setString(12, entity.getAnswerType().name());
            statement.setString(13, String.valueOf(entity.getAnswerId()));

            statement.executeUpdate();
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Answer entity) {
        try{
            PreparedStatement statement = this.connection.prepareStatement("DELETE FROM answer WHERE answer_id = ?");
            statement.setString(1, String.valueOf(entity.getAnswerId()));
            statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
