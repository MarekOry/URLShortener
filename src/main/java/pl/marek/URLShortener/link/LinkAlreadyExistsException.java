package pl.marek.URLShortener.link;

public class LinkAlreadyExistsException extends RuntimeException{
    LinkAlreadyExistsException(final String id) {
        super("Link with id: %s already exists.".formatted(id));
    }
}
