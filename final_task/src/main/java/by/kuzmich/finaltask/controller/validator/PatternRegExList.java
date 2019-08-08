package by.kuzmich.finaltask.controller.validator;

final public class PatternRegExList {
    public final static String
            EMAIL = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$",
            PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$",
            STRING_WITH_NUMBERS = "^[а-яА-ЯёЁa-zA-Z0-9]+$",
            NUMBERS = "$";
}
