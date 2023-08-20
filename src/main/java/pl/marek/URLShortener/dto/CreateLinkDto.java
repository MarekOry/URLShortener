package pl.marek.URLShortener.dto;

import lombok.Getter;
import lombok.Value;

import java.time.LocalDate;

@Getter
@Value
public class CreateLinkDto {
    String id;
    String email;
    String targetUrl;
    LocalDate expirationDate;

    public CreateLinkDto(String id, String email, String targetUrl, LocalDate expirationDate) {
        this.id = id;
        this.email = email;
        this.targetUrl = targetUrl;
        this.expirationDate = expirationDate;
    }

    public LinkDto toDto() {
        return LinkDto.builder()
                .id(id)
                .email(email)
                .targetUrl(targetUrl)
                .expirationDate(expirationDate)
                .visits(0)
                .build();
    }
}
