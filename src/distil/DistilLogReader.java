package distil;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Vijay Damera
 */
public class DistilLogReader{

    public static void main(String args[]) {

        // Input Test Data
        File testDataDirectory = new File("./testdata");
         
        List<WebRequest> list = new LinkedList<WebRequest>();
        DistilLogImplementation webServerLogImplementation = new DistilLogImplementation();

        // To read the web request logs and store into list of WebRequest type
        list = webServerLogImplementation.readInput(testDataDirectory);
        
        System.out.println("Total Number of Requests per domain:");
        System.out.println("------------------------------------");
        System.out.println(webServerLogImplementation.getTotalRequests(list)+"\n");
        
        System.out.println("Average Number of Requests per Hour per domain: ");
        System.out.println("------------------------------------------------");
        webServerLogImplementation.AverageRequests(list);
        
        
        System.out.println("\n"+ "Number of Requests for each Hour per domain: ");
        System.out.println("---------------------------------------------");
        System.out.println(webServerLogImplementation.getMaxRequestPerHour(list));
        
    }
}