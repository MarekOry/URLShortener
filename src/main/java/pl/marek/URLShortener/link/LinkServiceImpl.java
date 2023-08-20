package pl.marek.URLShortener.link;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.marek.URLShortener.dto.LinkDto;


@Service
@AllArgsConstructor
public class LinkServiceImpl implements LinkService {
    private final LinkRepository linkRepository;

    @Override
    @Transactional
    public LinkDto createLink(LinkDto dto) throws LinkAlreadyExistsException{
        if(linkRepository.existsById(dto.getId())) {
            throw new LinkAlreadyExistsException(dto.getId());
        } else {
            linkRepository.save(Link.fromDto(dto));
            return dto;
        }
    }

    @Override
    @Transactional
    public LinkDto getLink(String id) throws LinkNotFoundException{
        final Link link = linkRepository.findById(id)
                .orElseThrow(() -> new LinkNotFoundException(id));
        link.setVisits(link.getVisits() + 1);
        return link.toDto();
    }
}
