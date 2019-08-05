package by.kuzmich.finaltask.command;

public enum PagePathList {
    NAME_LIST_REDIRECTED("/pages/list.html"),
    NAME_LIST_FORWARDED("/pages/list.jsp"),
    ENTER("/enter.jsp"),
    MAP("/pages/lawmap.jsp"),
    ACTION("/pages/action.jsp"),
    REGISTRATION("/"),
    LAWER_MENU("/pages/lawmenu.jsp"),
    USER_PROFILE("/pages/userInformation.jsp"),
    USER_PROFILE_REDIRECTED("/profile.html"),
    GAP(""),
    UPDATE_ACTION("/pages/actionUpdate.jsp");

    private String path;

    PagePathList(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
