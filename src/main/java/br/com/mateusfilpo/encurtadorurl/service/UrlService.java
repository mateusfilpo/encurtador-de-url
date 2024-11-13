package br.com.mateusfilpo.encurtadorurl.service;

import br.com.mateusfilpo.encurtadorurl.domain.Url;
import br.com.mateusfilpo.encurtadorurl.model.UrlDTO;
import br.com.mateusfilpo.encurtadorurl.repository.UrlRepository;
import br.com.mateusfilpo.encurtadorurl.service.exception.UrlExpiredException;
import br.com.mateusfilpo.encurtadorurl.service.exception.UrlNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public UrlDTO getOriginalUrlById(String id) {
        Url url = urlRepository.findById(id).orElseThrow(() -> new UrlNotFoundException("Url de id: " + id + " não existe."));

        if (Instant.now().isAfter(url.getExpirationDate())) {
            throw new UrlExpiredException("Url de id: " + id + " está expirada");
        }

        return new UrlDTO(url.getOriginalUrl());
    }

    public UrlDTO shorten(UrlDTO urlDTO) {
        Url url = new Url(urlDTO);
        url.setId(generateRandomLengthUUID());
        url.setExpirationDate(Instant.now().plus(7, ChronoUnit.DAYS));

        urlRepository.save(url);

        return new UrlDTO(url);
    }

    private String generateRandomLengthUUID() {
        int minLength = 5;
        int maxLength = 10;

        Random random = new Random();
        int length = random.nextInt(maxLength - minLength + 1) + minLength;

        String uuid = generateUUID();

        while (urlRepository.existsById(uuid)) {
            uuid = generateUUID();
        }

        return uuid.substring(0, length);
    }

    private String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
