package br.com.mateusfilpo.encurtadorurl.controller;

import br.com.mateusfilpo.encurtadorurl.domain.Url;
import br.com.mateusfilpo.encurtadorurl.model.UrlDTO;
import br.com.mateusfilpo.encurtadorurl.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("/{id}")
    public void getOriginalUrlById(HttpServletResponse response, @PathVariable String id) throws IOException {
        UrlDTO result = urlService.getOriginalUrlById(id);

        response.sendRedirect(result.getUrl());
    }

    @PostMapping("/shorten")
    public ResponseEntity<UrlDTO> shorten(@RequestBody UrlDTO urlDTO) {
        UrlDTO result = urlService.shorten(urlDTO);
        return ResponseEntity.ok(result);
    }


}
