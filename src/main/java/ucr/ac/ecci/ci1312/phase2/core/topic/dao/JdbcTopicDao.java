package ucr.ac.ecci.ci1312.phase2.core.topic.dao;

import ucr.ac.ecci.ci1312.phase2.model.Topic;

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

public class JdbcTopicDao implements TopicDao {
    private Connection connection;

    public JdbcTopicDao(){
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
    public Topic findById(String id) {
        Topic result = null;
        try{
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM topic WHERE artificial_key = ?;");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs != null) {
                rs.first();
                result = new Topic(rs.getString("artificial_key"), rs.getString("name"), rs.getString("fk_parent_topic"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String create(Topic entity) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO topic VALUES (?, ?, ?);");
            ps.setString(1, entity.getArtificialId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getParentTopic());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Topic entity) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("UPDATE topic SET name = ?, fk_parent_topic = ? WHERE artificial_key = ?;");
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getParentTopic());
            ps.setString(3, entity.getArtificialId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Topic entity) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("DELETE FROM topic WHERE artificial_key = ?;");
            ps.setString(1, entity.getArtificialId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
