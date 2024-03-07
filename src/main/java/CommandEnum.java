import lombok.Getter;

@Getter
public enum CommandEnum {
    ENROLL(1, 2),
    ASSIGN(1, 2),
    SHOW_COURSES(2, 0),
    LOOKUP_COURSE(2, 1),
    SHOW_STUDENTS(2, 0),
    LOOKUP_STUDENT(2, 1),
    SHOW_TEACHERS(2, 0),
    LOOKUP_TEACHER(2, 1),
    SHOW_PROFIT(2, 0);

    private final int nbArgs;
    private final int nbComms;
    CommandEnum(int i, int j) {
        this.nbArgs = i;
        this.nbComms = j;
    }
    
    public int getSize() {
        return getNbArgs() + getNbComms();
    }
}
