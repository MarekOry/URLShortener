package pl.marek.URLShortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.marek.URLShortener.dto.CreateLinkDto;
import pl.marek.URLShortener.dto.LinkDto;

@RestController
@RequestMapping("/links/")
public class LinkManageController {

    @PostMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLing(@RequestBody CreateLinkDto link) {
        return link.toDto();
    }
}
