package domain;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Search {
    private TripType tripType;
    private String origin;
    private String destination;
    private DateTime outboundDate;
    private DateTime inboundDate;

    public Search(TripType tripType, String origin, String destination, String outboundDate) {
        this.tripType = tripType;
        this.origin = origin;
        this.destination = destination;
        this.outboundDate = getDateFromString(outboundDate);
    }

    private DateTime getDateFromString(String dateText) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime dateTime = formatter.parseDateTime(dateText);

        return dateTime;
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

    public DateTime getOutboundDate() {
        return outboundDate;
    }

    public DateTime getInboundDate() {
        return inboundDate;
    }
}
