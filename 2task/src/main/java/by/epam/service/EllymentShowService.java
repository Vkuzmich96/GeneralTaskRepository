package by.epam.service;

import by.epam.service.composit.Ellyment;

public class EllymentShowService implements ShowService {

    @Override
    public String get(Ellyment ellyment) {
        return ellyment.get();
    }
}
