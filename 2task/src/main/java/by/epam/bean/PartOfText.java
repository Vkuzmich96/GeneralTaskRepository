package by.epam.bean;

import by.epam.service.composit.Ellyment;

import java.util.List;

public class PartOfText {
    private PartOfTextKind kind;
    private List<Ellyment> list;

    public PartOfText(PartOfTextKind kind, List<Ellyment> list) {
        this.kind = kind;
        this.list = list;
    }

    public PartOfTextKind getKind() {
        return kind;
    }

    public List<Ellyment> getList() {
        return list;
    }

    public void add (Ellyment ellyment) {
        list.add(ellyment);
    }

    public void setKind(PartOfTextKind kind) {
        this.kind = kind;
    }

    public void setList(List<Ellyment> list) {
        this.list = list;
    }
}
