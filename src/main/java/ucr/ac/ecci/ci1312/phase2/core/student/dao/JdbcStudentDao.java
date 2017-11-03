package ucr.ac.ecci.ci1312.phase2.core.student.dao;

import ucr.ac.ecci.ci1312.phase2.model.Student;

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

public class JdbcStudentDao implements StudentDao {
    private Connection connection;

    public JdbcStudentDao(){
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
    public Student findById(String id) {
        Student result = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM student WHERE student_id = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                rs.first();
                result = new Student(rs.getString("email"),
                                     rs.getString("student_id"),
                                     rs.getString("name"),
                                     rs.getString("last_name"),
                                     rs.getString("second_last_name"),
                                     rs.getDate("birth_date"),
                                     rs.getString("password"),
                                     rs.getBoolean("enabled"));
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public String create(Student entity) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO student VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, entity.getEmail());
            ps.setString(2, entity.getStudentId());
            ps.setString(3, entity.getFirstName());
            ps.setString(4, entity.getFirstLastName());
            ps.setString(5, entity.getSecondLastName());
            ps.setDate(6, new Date(entity.getBirthDate().getTime()));
            ps.setString(7, entity.getPassword());
            ps.setBoolean(8, entity.isEnabled());
            ps.setDate(9, new Date(entity.getBirthDate().getTime()));
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(Student entity) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("UPDATE student SET email = ?, name = ?, last_name = ?, second_last_name = ?, " +
                    "birth_date = ?, password = ?, enabled = ?, last_login = ? WHERE student_id = ?;");
            ps.setString(1, entity.getEmail());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getFirstLastName());
            ps.setString(4, entity.getSecondLastName());
            ps.setDate(5, new Date(entity.getBirthDate().getTime()));
            ps.setString(6, entity.getPassword());
            ps.setBoolean(7, entity.isEnabled());
            ps.setDate(8, new Date(entity.getLastLogin().getTime()));
            ps.setString(9, entity.getStudentId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(Student entity) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("DELETE FROM student WHERE student_id = ?;");
            ps.setString(1, entity.getStudentId());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
