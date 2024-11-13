package br.com.mateusfilpo.encurtadorurl.service.exception;

public class UrlNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UrlNotFoundException(String msg) {
        super(msg);
    }
}
