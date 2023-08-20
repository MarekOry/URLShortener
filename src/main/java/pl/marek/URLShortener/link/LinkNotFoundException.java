package pl.marek.URLShortener.link;

public class LinkNotFoundException extends RuntimeException{
    LinkNotFoundException(final String id) {
        super("Link with id: %s cannot be found.".formatted(id));
    }
}
