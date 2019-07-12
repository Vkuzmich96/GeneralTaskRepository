package by.epam.entity;

public enum Position {

    JUNIOR("junior"), MIDDLE("middle"), SENIOR("senior"), TEAM_LEAD("lead");

    String positionName;

    Position(String positionName){
        this.positionName = positionName;
    }

    public String getPositionName() {
        return positionName;
    }
}
