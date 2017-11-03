package ucr.ac.ecci.ci1312.phase2.build;

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

public class Main {
    /**
     * Main method.
     * @param args command line arguments, if any.
     */
    public static void main(String... args) {
        DataLoader dl = new DataLoader();
        dl.loadWorkbook();
        System.out.println("Data Stored successfully");
    }
}
/*try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=project_db;user=testLogin;password=alonso;");
        if(conn != null){
        System.out.println("conectado");
        }

        }catch (Exception e){
        System.out.println(e.getMessage());
        }*/