package by.epam.service.parse;

import by.epam.bean.Candy;

import java.util.List;

public interface Parser {
    List<Candy> parse(String url);
}
