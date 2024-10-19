public abstract class GameTester {
    protected String gameTesterName; //Instance variable gameTesterName
    protected boolean fullTime; //Instance variable fullTime

    public GameTester(String gameTesterName, boolean fullTime) { //Constructor
        this.gameTesterName = gameTesterName;
        this.fullTime = fullTime;
    }

    public abstract double calcSalary(); //Abstract calcSalary method

}
