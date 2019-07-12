package by.epam.controller.builder;

import java.util.regex.Pattern;

public class Delimiters {
    public static final Pattern PARAGRAPH = Pattern.compile("\n(\\s{4,}|\t)");
    public static final Pattern SENTENCE = Pattern.compile("[.!?]\r?");
    public static final Pattern WORD = Pattern.compile("[ ]");
    public static final Pattern TEXT = Pattern.compile("[\n\n]");
}
