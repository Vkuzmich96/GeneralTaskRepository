package by.epam.controller.builder.impl;

import by.epam.bean.Word;
import by.epam.controller.ControllerException;
import by.epam.controller.builder.Delimiters;
import by.epam.bean.PartOfTextKind;
import by.epam.service.composit.Ellyment;

import by.epam.service.composit.impl.WordEllyment;

import java.util.ArrayList;
import java.util.List;

public class WordBuilder extends BuilderChainContainer {

    public WordBuilder() {
        super(Delimiters.WORD, PartOfTextKind.WORD);
    }

    public List<Ellyment> build(String sentence) {
        String[] strings = split(sentence);
        return createWords(strings);
    }

    private List<Ellyment> createWords(String[] strings) {
        List<Ellyment> list = new ArrayList<>();
        for (String string : strings){
            list.add(new WordEllyment(new Word(string, kind)));
        }
        return list;
    }

    public BuilderChainContainer linkWith(BuilderChainContainer builder) throws ControllerException {
        throw new ControllerException("trying use linkWith on last cain ellyment");
    }
}
