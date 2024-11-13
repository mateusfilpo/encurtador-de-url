package br.com.mateusfilpo.encurtadorurl.service.exception;

public class UrlExpiredException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UrlExpiredException(String msg) {
        super(msg);
    }
}
