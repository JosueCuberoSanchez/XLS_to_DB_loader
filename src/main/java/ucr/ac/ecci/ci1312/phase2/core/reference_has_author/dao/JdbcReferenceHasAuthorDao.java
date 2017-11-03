package ucr.ac.ecci.ci1312.phase2.core.reference_has_author.dao;

import ucr.ac.ecci.ci1312.phase2.model.ReferenceHasAuthor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

public class JdbcReferenceHasAuthorDao implements ReferenceHasAuthorDao {
    private Connection connection;

    public JdbcReferenceHasAuthorDao(){
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
    public ReferenceHasAuthor findById(String id) {
        return null;
    }

    @Override
    public String create(ReferenceHasAuthor entity) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO reference_has_author VALUES (?, ?);");
            ps.setString(1, entity.getFkReference());
            ps.setString(2, entity.getFkAuthor());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(ReferenceHasAuthor entity) {
        /*try{
            PreparedStatement statement =
                    this.connection.prepareStatement("UPDATE reference_has_author SET " +
                            "fk_reference = ?, " +
                            "fk_author = ?," );

            statement.setString(1, entity.getFkReference());
            statement.setString(2, entity.getFkAuthor());

            statement.executeUpdate();

        }catch (SQLException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }*/
    }

    @Override
    public void remove(ReferenceHasAuthor entity) {
        try{
            PreparedStatement ps = this.connection.prepareStatement("DELETE FROM reference_has_author WHERE fk_reference = ? AND fk_author = ?");
            ps.setString(1, entity.getFkReference());
            ps.setString(2, entity.getFkAuthor());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
