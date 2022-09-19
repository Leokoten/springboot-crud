package br.com.qtivate.server.model;

public class Response {
    private final String status;
    private final String message;
    private final int code;

    public Response(String status, String message, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
