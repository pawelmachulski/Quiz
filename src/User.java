public class User {
    private int numberOfPoints;


    public User(){}

    public User(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberofPoints() {
        return numberOfPoints;
    }

    public void addPoint(){
        numberOfPoints++;
    }


}
