package pl.marek.URLShortener.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.marek.URLShortener.dto.LinkDto;
import pl.marek.URLShortener.link.LinkService;

import java.net.URI;

@RestController
@RequestMapping("/s")
@AllArgsConstructor
public class RedirectController {
    private final LinkService linkService;
    @GetMapping("/{id}")
    public ResponseEntity<Void> redirectLink(@PathVariable String id) {
        LinkDto link = linkService.getLink(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(link.getTargetUrl()))
                .build();
    }
}
