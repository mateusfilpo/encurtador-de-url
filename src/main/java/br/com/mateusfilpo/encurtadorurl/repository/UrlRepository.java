package br.com.mateusfilpo.encurtadorurl.repository;

import br.com.mateusfilpo.encurtadorurl.domain.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {
}
