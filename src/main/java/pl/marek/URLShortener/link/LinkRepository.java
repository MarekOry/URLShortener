package pl.marek.URLShortener.link;

import org.springframework.data.repository.CrudRepository;

interface LinkRepository extends CrudRepository<Link, String> {

}
