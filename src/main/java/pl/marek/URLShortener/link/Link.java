package pl.marek.URLShortener.link;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import pl.marek.URLShortener.dto.LinkDto;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
    class Link {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String targetUrl;

    @Column
    LocalDate expirationDate;

    @Column
    int visits;

    static Link fromDto(final LinkDto dto) {
        return Link.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .targetUrl(dto.getTargetUrl())
                .expirationDate(dto.getExpirationDate())
                .visits(dto.getVisits())
                .build();
    }

    LinkDto toDto() {
        return LinkDto.builder()
                .id(id)
                .email(email)
                .targetUrl(targetUrl)
                .expirationDate(expirationDate)
                .visits(visits)
                .build();
    }
}
