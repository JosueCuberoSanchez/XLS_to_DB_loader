package ucr.ac.ecci.ci1312.phase2.model;

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

public class Topic {
    private String artificialId;
    private String name;
    private String parentTopic;

    /**
     * Constructs a topic object.
     * @param artificialId the id.
     * @param name the name.
     * @param parentTopic the parent topic.
     */
    public Topic(String artificialId, String name, String parentTopic){
        this.artificialId = artificialId;
        this.name = name;
        this.parentTopic = parentTopic;
    }

    /**
     * Return the id of the topic.
     * @return the id of the topic.
     */
    public String getArtificialId() {
        return artificialId;
    }

    /**
     * Return the name of the topic.
     * @return the name of the topic.
     */
    public String getName() {
        return name;
    }

    /**
     * Return the parent topic id.
     * @return the parent topic id.
     */
    public String getParentTopic() {
        return parentTopic;
    }

}
