package br.com.mateusfilpo.encurtadorurl.model;

import br.com.mateusfilpo.encurtadorurl.domain.Url;

public class UrlDTO {
    private String url;

    public UrlDTO() {}

    public UrlDTO(String url) {
        this.url = url;
    }

    public UrlDTO(Url url) {
        this.url = "http://localhost:8080/" + url.getId();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UrlDTO{" +
                "url='" + url + '\'' +
                '}';
    }
}
