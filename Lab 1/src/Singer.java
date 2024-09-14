public class Singer {

    //The 5 instance variables
    private int singerID;
    private String singerName;
    private String singerAddress;
    private String singerDOB;
    private int albumsPublished;

    //Constructor with no arguments
    public Singer() {
        this.singerID = 0;
        this.singerName = "";
        this.singerAddress = "";
        this.singerDOB = "";
        this.albumsPublished = 0;
    }

    //Constructor with 1 argument
    public Singer(int singerID){
        this.singerID = singerID;
    }

    //Constructor with 2 arguments
    public Singer(int singerID, String singerName){
        this.singerID = singerID;
        this.singerName = singerName;
    }

    //Constructor with 3 arguments
    public Singer(int singerID, String singerName, String singerAddress){
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
    }

    //Constructor with 4 arguments
    public Singer(int singerID, String singerName, String singerAddress, String singerDOB){
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.singerDOB = singerDOB;
    }

    //Constructor with 5 arguments
    public Singer(int singerID, String singerName, String singerAddress, String singerDOB, int albumsPublished){
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.singerDOB = singerDOB;
        this.albumsPublished = albumsPublished;
    }

    //Singer ID getter
    public int getSingerID() {
        return singerID;
    }

    //Singer ID setter
    public void setSingerID(int singerID) {
        this.singerID = singerID;
    }

    //Singer Name getter
    public String getSingerName() {
        return singerName;
    }

    //Singer Name setter
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    //Singer Address getter
    public String getSingerAddress() {
        return singerAddress;
    }

    //Singer Address setter
    public void setSingerAddress(String singerAddress) {
        this.singerAddress = singerAddress;
    }

    //Singer date of birth getter
    public String getSingerDOB() {
        return singerDOB;
    }

    //Singer date of birth setter
    public void setSingerDOB(String singerDOB) {
        this.singerDOB = singerDOB;
    }

    //Number of album published getter
    public int getAlbumsPublished() {
        return albumsPublished;
    }

    //Number of album published setter
    public void setAlbumsPublished(int albumsPublished) {
        this.albumsPublished = albumsPublished;
    }

    //Setter to set all values
    public void setAllValues(int singerID, String singerName, String singerAddress, String singerDOB, int albumsPublished) {
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerAddress = singerAddress;
        this.singerDOB = singerDOB;
        this.albumsPublished = albumsPublished;
    }

    //Function to display all the values of a singer object
    public void displaySingerInfo(){
        System.out.println("Singer ID: " + this.singerID);
        System.out.println("Singer Name: " + this.singerName);
        System.out.println("Singer Address: " + this.singerAddress);
        System.out.println("Singer DOB: " + this.singerDOB);
        System.out.println("Albums Published: " + this.albumsPublished);
    }

}
