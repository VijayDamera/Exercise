package distil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DistilLogInterface {

    public Map<String, Long> getTotalRequests(List<WebRequest> list);

    public HashMap<Integer, Map<String, Long>> getMaxRequestPerHour(List<WebRequest> list);

    public void AverageRequests(List<WebRequest> list);

}