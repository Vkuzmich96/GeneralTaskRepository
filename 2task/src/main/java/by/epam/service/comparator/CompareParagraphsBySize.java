package by.epam.service.comparator;

import by.epam.service.composit.Ellyment;
import by.epam.service.composit.impl.PartOfTextContainer;

import java.util.Comparator;
import java.util.List;

public class CompareParagraphsBySize implements Comparator<Ellyment> {

    @Override
    public int compare(Ellyment o1, Ellyment o2) {
        return Integer.compare( cast(o1).size(), cast(o2).size());
    }

    private List<Ellyment> cast (Ellyment ellyment){
        return ( (PartOfTextContainer) ellyment ).getList();
    }
}
