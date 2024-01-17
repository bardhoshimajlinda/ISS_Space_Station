import utils.DatabaseUtils;

public class IssSpaceStationApp {
    public static void main(String[] args) {

        if (DatabaseUtils.testConnection()) {
            System.out.println("Database connection is okay.");
        } else {
            System.out.println("Error: Unable to connect to the database.");
        }
    }
}