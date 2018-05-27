package domain;

public class Search {
    private TripType tripType;
    private String origin;
    private String destination;
    private String outboundDate;
    private String inboundDate;
    private SearchPaxs searchPaxs;

    public Search(TripType tripType, String origin, String destination, String outboundDate, String inboundDate, SearchPaxs searchPaxs) {
        this.tripType = tripType;
        this.origin = origin;
        this.destination = destination;
        this.outboundDate = outboundDate;
        this.inboundDate = inboundDate;
        this.searchPaxs = searchPaxs;
    }

    public Search(TripType tripType, String origin, String destination, String outboundDate, SearchPaxs searchPaxs) {
        this.tripType = tripType;
        this.origin = origin;
        this.destination = destination;
        this.outboundDate = outboundDate;
        this.searchPaxs = searchPaxs;
    }

    public TripType getTripType() {
        return tripType;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public SearchPaxs getSearchPaxs() {
        return searchPaxs;
    }
}
