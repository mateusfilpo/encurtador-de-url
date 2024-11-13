package br.com.mateusfilpo.encurtadorurl.bootstrap;

import br.com.mateusfilpo.encurtadorurl.domain.Url;
import br.com.mateusfilpo.encurtadorurl.repository.UrlRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Component
public class BootstrapData implements CommandLineRunner {

    private final UrlRepository urlRepository;

    public BootstrapData(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadUrlData();
    }

    private void loadUrlData() {
        Url url = new Url();
        url.setOriginalUrl("https://www.google.com");
        url.setId("123456");
        url.setExpirationDate(Instant.now().plus(7, ChronoUnit.DAYS));

        Url urlExpired = new Url();
        urlExpired.setOriginalUrl("https://www.google.com");
        urlExpired.setId("1234567");
        urlExpired.setExpirationDate(Instant.now().minus(1, ChronoUnit.DAYS));

        urlRepository.saveAll(Arrays.asList(url, urlExpired));
    }
}
