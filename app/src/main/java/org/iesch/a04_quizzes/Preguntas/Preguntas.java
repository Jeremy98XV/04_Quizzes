package org.iesch.a04_quizzes.Preguntas;

public class Preguntas {
    int numero;
    String pregunta;
    String respCorrecta;
    String respIncorrecta;

    public Preguntas(int numero, String pregunta, String respCorrecta, String respIncorrecta) {
        this.numero = numero;
        this.pregunta = pregunta;
        this.respCorrecta = respCorrecta;
        this.respIncorrecta = respIncorrecta;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespCorrecta() {
        return respCorrecta;
    }

    public void setRespCorrecta(String respCorrecta) {
        this.respCorrecta = respCorrecta;
    }

    public String getRespIncorrecta() {
        return respIncorrecta;
    }

    public void setRespIncorrecta(String respIncorrecta) {
        this.respIncorrecta = respIncorrecta;
    }
}
