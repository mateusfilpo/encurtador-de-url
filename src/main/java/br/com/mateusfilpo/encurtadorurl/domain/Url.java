package br.com.mateusfilpo.encurtadorurl.domain;

import br.com.mateusfilpo.encurtadorurl.model.UrlDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Objects;

@Document
public class Url {

    @Id
    private String id;
    private String originalUrl;
    private Instant expirationDate;

    public Url() {
    }

    public Url(String id, String originalUrl, Instant expirationDate) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.expirationDate = expirationDate;
    }

    public Url(UrlDTO urlDTO) {
        this.originalUrl = urlDTO.getUrl();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id='" + id + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return Objects.equals(id, url.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
