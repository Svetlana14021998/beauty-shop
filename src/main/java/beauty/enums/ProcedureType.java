package beauty.enums;

public enum ProcedureType {
    NAIL("Ногти"),
    HAIR("Волосы"),
    SKIN("Уход за кожей");

    private final String name;

    ProcedureType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
