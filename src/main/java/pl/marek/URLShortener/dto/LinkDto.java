package pl.marek.URLShortener.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class LinkDto {
    String id;
    String email;
    String targetUrl;
    LocalDate expirationDate;
    int visits;
}
