package pl.marek.URLShortener.link;

import org.springframework.stereotype.Service;
import pl.marek.URLShortener.dto.LinkDto;

import java.util.HashMap;
import java.util.Map;

@Service
public class LinkServiceImpl implements LinkService {
    final Map<String, LinkDto> linkRepository = new HashMap<>();

    @Override
    public LinkDto createLink(LinkDto dto) {
        linkRepository.put(dto.getId(), dto);
        return dto;
    }

    @Override
    public LinkDto getLink(String id) {
        final LinkDto linkDto = linkRepository.get(id);
        return linkDto;
    }
}
