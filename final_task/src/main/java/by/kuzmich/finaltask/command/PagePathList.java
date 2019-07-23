package by.kuzmich.finaltask.command;

public enum PagePathList {
    NAME_LIST("/pages/list.jsp"),
    ENTER("/pages/enter.jsp"),
    MAP("/pages/lawmap.jsp"),
    ACTION("/pages/action.jsp");

    private String path;

    PagePathList(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
