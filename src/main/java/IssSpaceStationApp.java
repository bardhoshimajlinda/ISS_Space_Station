import dao.PeopleDao;
import dao.StationDao;
import services.PeopleService;
import services.StationService;
import utils.DatabaseUtils;

import java.util.Scanner;

public class IssSpaceStationApp {
    public static void main(String[] args) {

//        if (DatabaseUtils.testConnection()) {
//            System.out.println("Database connection is okay.");
//        } else {
//            System.out.println("Error: Unable to connect to the database.");
//        }

        StationService stationService = new StationService(new StationDao());
        stationService.syncDatabaseWithWebService();
        PeopleService peopleService = new PeopleService(new PeopleDao());

        while (true) {

            System.out.println("1 - ISS location");
            System.out.println("2 - People in space");
            System.out.println("3 - Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Show locaiton");
                stationService.printIssLocation();
            }
            else if( choice == 2) {
                System.out.println("Show people");
                peopleService.printPeopleInSpace();
            }
            else if (choice == 3){
                break;
            }
            else {
                System.out.println("Wrong choice");
            }
        }
    }
}