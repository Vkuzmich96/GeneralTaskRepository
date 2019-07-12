package by.epam.service.composit.impl;

import by.epam.bean.PartOfText;
import by.epam.service.composit.Container;
import by.epam.service.composit.Ellyment;
import by.epam.service.sorter.Sorter;

import java.util.List;
import java.util.stream.Collectors;

public class PartOfTextContainer implements Container {
    private PartOfText text;

    public PartOfTextContainer(PartOfText text) {
        this.text = text;
    }

    public void sort(Sorter sorter) {
        sorter.sort(text.getList());
    }

    public List<Ellyment> getList(){
        return text.getList();
    }

    @Override
    public void add(Ellyment ellyment) {
        text.add(ellyment);
    }

    @Override
    public String get() {
        return text.getList().stream()
                             .map(Ellyment::get)
                             .collect(Collectors.joining(" "))
                             +text.getKind().getSplitter();
    }
}
