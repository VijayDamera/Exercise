package distil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DistilLogImplementation implements DistilLogInterface{

    public List<WebRequest> readInput(File testDataDirectory) {
        List<WebRequest> list = new LinkedList<WebRequest>();
        if(testDataDirectory.isDirectory()) {
            // Set the webRequest Objects in LinkedList
            for(File file : testDataDirectory.listFiles()) {
                if(file.isFile()) {
                    try(BufferedReader br = Files.newBufferedReader(Paths.get(file.toURI()))) {
                        String line;
                        while((line = br.readLine()) != null){
                            String[] details = line.split("\t");
                            DateTime dateTime = new DateTime(Math.round((Double.parseDouble(details[0]) * 1000)));
                            String domain = details[1];
                            String requestUrl = details[2];
                            WebRequest webRequest = new WebRequest(dateTime, domain, requestUrl);
                            list.add(webRequest);
                        }
                        br.close();
                    } catch (IOException e) {
                        System.out.println("Invalid input: " + e);
                    }
                }
                else{
                    System.out.println("Not a file");
                }
            }
        } else {
            System.out.println("Not a directory");
        }
        return list;
    }

    /**
     * To find the total number of Requests per domain
     */
    @Override
    public Map<String, Long> getTotalRequests(List<WebRequest> list) {
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(WebRequest::getDomain, Collectors.counting()));
        return map;
    }

    /**
     * To find the total number of requests each hour per domain 
     */
    @Override
    public HashMap<Integer, Map<String, Long>> getMaxRequestPerHour(List<WebRequest> list) {
        HashMap<Integer, Map<String, Long>> mpMaps=new HashMap<Integer, Map<String, Long>>();
        for (int i=0;i<24;i++){
            mpMaps.put(i, RequestsPerHour(i, list));
        }
        return mpMaps;
    }

    /**
     * To find the Average Requests per hour per domain
     */
    @Override
    public void AverageRequests(List<WebRequest> list) {
        list.sort(Comparator.comparing(webRequest -> webRequest.getDateTime()));
        int days = Days.daysBetween(list.get(0).getDateTime(), list.get(list.size()-1).getDateTime()).getDays();
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(WebRequest::getDomain, Collectors.counting()));
        map.forEach((k, v) -> 
        System.out.println(k + "=" + v/(double)(24*days)));
    }

    /**
     * To find the number of requests per hour per domain
     */
    public Map<String, Long> RequestsPerHour(int i, List<WebRequest> list) {
        Map<String, Long> map = list.stream().filter(webRequest -> ((webRequest.getDateTime().getHourOfDay() > i) && (webRequest.getDateTime().getHourOfDay() <= (i+1)))).collect(Collectors.groupingBy(WebRequest::getDomain, Collectors.counting()));
        return map;
    }
}