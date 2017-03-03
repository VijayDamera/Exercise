package distil;


import org.joda.time.DateTime;

public class WebRequest {

    private DateTime dateTime;
    private String domain;
    private String requestUrl;
    
    public WebRequest(DateTime dateTime, String domain, String requestUrl) {
        super();
        this.dateTime = dateTime;
        this.domain = domain;
        this.requestUrl = requestUrl;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
