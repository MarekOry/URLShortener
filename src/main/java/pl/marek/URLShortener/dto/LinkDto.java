package pl.marek.URLShortener.dto;

import lombok.Builder;
import lombok.Value;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

@Value
@Builder
public class LinkDto {
    String id;
    String email;
    String targetUrl;
    LocalDate expirationDate;
    int visits;

    public String getShortenedLink() {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/s/{id}")
                .buildAndExpand(id)
                .toUriString();
    }
}
