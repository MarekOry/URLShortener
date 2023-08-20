package pl.marek.URLShortener.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/s")
public class RedirectController {

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirectLink(@PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("https://tinyurl.com/app"))
                .build();
    }
}
