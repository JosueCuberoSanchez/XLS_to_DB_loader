package ucr.ac.ecci.ci1312.phase2.model;

import ucr.ac.ecci.ci1312.phase2.core.enums.AnswerType;

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
public class Answer {
    private String answerId;
    private String fkExercise;
    private AnswerType answerType;
    private boolean isPractical;
    private boolean isCorrect;
    private boolean isDeleted;
    private boolean isVisible;
    private String code;
    private String language;
    private String measurementUnit;
    private Double number;
    private String text;

    private String imagePath;

    /**
     * Constucts an answer object.
     * @param answerId the id.
     * @param isCorrect the correct state.
     * @param isDeleted the deleted state.
     * @param isVisible the visible state.
     * @param number the number, of number  answer type.
     * @param measurementUnit the measurement unit,  of number answer type.
     * @param text the text, of text answer type.
     * @param imagePath the image path, of image answer type.
     * @param code the source code, of code answer type.
     * @param language the language of the source code, of code answer type.
     * @param fkExercise the excercise foreign key.
     * @param isPractical the practical state.
     * @param answerType the type of answer.
     */
    public Answer(String answerId, boolean isCorrect, boolean isDeleted, boolean isVisible, Double number,
                  String measurementUnit, String text, String imagePath, String code, String language, String fkExercise,
                  boolean isPractical, AnswerType answerType){
        this.answerId = answerId;
        this.answerType = answerType;
        this.isCorrect = isCorrect;
        this.isDeleted = isDeleted;
        this.isVisible = isVisible;
        this.number = number;
        this.measurementUnit = measurementUnit;
        this.text = text;
        this.imagePath = imagePath;
        this.code = code;
        this.language = language;
        this.fkExercise = fkExercise;
        this.isPractical = isPractical;
        this.answerType = answerType;
    }

    /**
     * Return true if the answer is visible, false otherwise.
     * @return a boolean depending on answer visibility
     */
    public boolean isVisible() {
        return isVisible;
    }

    /**
     * Return true if the answer is correct
     * @return a boolean depending in correctness of an answer.
     */
    public boolean isCorrect() {
        return isCorrect;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Return the number if the answer is numerical.
     * @return the numerical answer, if the answer is numerical.
     */
    public Double getNumber() {
        return number;
    }

    /**
     * Return the measurement unit if the answer is numerical.
     * @return the measurement unit if the answer is numerical.
     */
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * Return the foreign key value from exercise.
     * @return the foreign key value from exercise.
     */
    public String getFkExercise() {
        return fkExercise;
    }

    /**
     * Return the language of the code answer, if the answer is code type.
     * @return the language of the code answer, if the answer is code type.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Return true if the answer is practical, false otherwise.
     * @return true if the answer is practical, false otherwise.
     */
    public boolean isPractical() {

        return isPractical;
    }

    /**
     * Return the type of answer.
     * @return the type of answer.
     */
    public AnswerType getAnswerType() {
        return answerType;
    }

    /**
     * Return the image path of the image answer, if the answer is image type.
     * @return the image path of the image answer, if the answer is image type.
     */
    public String getImage() {
        return imagePath;
    }

    /**
     * Return the text answer, if the answer is of text type.
     * @return the text answer, if the answer is of text type.
     */
    public String getContent() {
        return text;
    }

    /**
     * Return the source code of the answer, if answer is code type.
     * @return the source code of the answer, if answer is code type.
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the answer id.
     * @return the answer id.
     */
    public String getAnswerId() {
        return answerId;
    }

}

