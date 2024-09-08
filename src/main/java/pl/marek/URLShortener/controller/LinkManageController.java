package pl.marek.URLShortener.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.marek.URLShortener.dto.CreateLinkDto;
import pl.marek.URLShortener.dto.LinkDto;
import pl.marek.URLShortener.link.LinkService;

@RestController
@RequestMapping("/links")
@AllArgsConstructor
public class LinkManageController {

    private final LinkService linkService;

    @PostMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
        return linkService.createLink(link.toDto());
    }
}
