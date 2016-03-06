package com.abbitt.trading.domain;


import java.util.Date;

public class Event {

    private final String id;
    private final String name;
    private final String countryCode;
    private final String timezone;
    private final String venue;
    private final Date openDate;

    public Event(String id, String name, String countryCode, String timezone, String venue, Date openDate) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.timezone = timezone;
        this.venue = venue;
        this.openDate = openDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getVenue() {
        return venue;
    }

    public Date getOpenDate() {
        return openDate;
    }
}
