package pl.marek.URLShortener.link;

import pl.marek.URLShortener.dto.LinkDto;

public interface LinkService {
    LinkDto createLink(LinkDto dto);

    LinkDto getLink(String id);
}
