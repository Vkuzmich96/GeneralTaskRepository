package by.epam.controller.builder.impl;

import by.epam.bean.PartOfText;
import by.epam.controller.builder.ChainEllyment;
import by.epam.service.composit.Ellyment;
import by.epam.bean.PartOfTextKind;
import by.epam.service.composit.impl.PartOfTextContainer;


public class TextBuilder implements ChainEllyment<BuilderChainContainer> {
    private BuilderChainContainer builder;

    public Ellyment build (String text) {
        PartOfText part = new PartOfText(PartOfTextKind.TEXT, builder.build(text));
        return new PartOfTextContainer(part);
    }

    @Override
    public BuilderChainContainer linkWith(BuilderChainContainer builder) {
        this.builder = builder;
        return builder;
    }
}