package by.epam.service;

import by.epam.bean.Candy;
import by.epam.service.parse.Parser;

import java.util.List;

public class Service {
    private Parser dom;
    private Parser sax;
    private Parser stax;

    public Service(Parser dom, Parser sax, Parser stax) {
        this.dom = dom;
        this.sax = sax;
        this.stax = stax;
    }

    public List<Candy> parseByDom(String url) {
        return dom.parse(url);
    }

    public List<Candy> parseBySax(String url) {
        return sax.parse(url);
    }

    public List<Candy> parseByStaX(String url) {
        return stax.parse(url);
    }
}
