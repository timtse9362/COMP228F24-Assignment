public abstract class GameTester {
    protected String gameTesterName;
    protected boolean fullTime;

    public GameTester(String gameTesterName, boolean fullTime) {
        this.gameTesterName = gameTesterName;
        this.fullTime = fullTime;
    }

    public abstract double calcSalary();

}
