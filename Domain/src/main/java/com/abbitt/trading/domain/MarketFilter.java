package com.abbitt.trading.domain;


import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class MarketFilter {

    public static final Builder builder = new Builder();

    private final String textQuery;
    private final Set<String> exchangeIds;
    private final Set<String> eventTypeIds;
    private final Set<String> eventIds;
    private final Set<String> competitionIds;
    private final Set<String> marketIds;
    private final Set<String> venues;
    private final boolean bspOnly;
    private final boolean turnInPlayEnabled;
    private final boolean inPlayOnly;
    private final Set<MarketBettingType> bettingTypes;
    private final Set<String> marketCountries;
    private final Set<String> marketTypeCodes;
    private final TimeRange marketStartTime;
    private final Set<OrderStatus> orderStatuses;

    private MarketFilter(String textQuery, Set<String> exchangeIds, Set<String> eventTypeIds, Set<String> eventIds,
                        Set<String> competitionIds, Set<String> marketIds, Set<String> venues, boolean bspOnly,
                        boolean turnInPlayEnabled, boolean inPlayOnly, Set<MarketBettingType> bettingTypes,
                        Set<String> marketCountries, Set<String> marketTypeCodes, TimeRange marketStartTime,
                        Set<OrderStatus> orderStatuses) {
        this.textQuery = textQuery;
        this.exchangeIds = exchangeIds;
        this.eventTypeIds = eventTypeIds;
        this.eventIds = eventIds;
        this.competitionIds = competitionIds;
        this.marketIds = marketIds;
        this.venues = venues;
        this.bspOnly = bspOnly;
        this.turnInPlayEnabled = turnInPlayEnabled;
        this.inPlayOnly = inPlayOnly;
        this.bettingTypes = bettingTypes;
        this.marketCountries = marketCountries;
        this.marketTypeCodes = marketTypeCodes;
        this.marketStartTime = marketStartTime;
        this.orderStatuses = orderStatuses;
    }

    public String getTextQuery() {
        return textQuery;
    }

    public Set<String> getExchangeIds() {
        return exchangeIds;
    }

    public Set<String> getEventTypeIds() {
        return eventTypeIds;
    }

    public Set<String> getEventIds() {
        return eventIds;
    }

    public Set<String> getCompetitionIds() {
        return competitionIds;
    }

    public Set<String> getMarketIds() {
        return marketIds;
    }

    public Set<String> getVenues() {
        return venues;
    }

    public boolean isBspOnly() {
        return bspOnly;
    }

    public boolean isTurnInPlayEnabled() {
        return turnInPlayEnabled;
    }

    public boolean isInPlayOnly() {
        return inPlayOnly;
    }

    public Set<MarketBettingType> getBettingTypes() {
        return bettingTypes;
    }

    public Set<String> getMarketCountries() {
        return marketCountries;
    }

    public Set<String> getMarketTypeCodes() {
        return marketTypeCodes;
    }

    public TimeRange getMarketStartTime() {
        return marketStartTime;
    }

    public Set<OrderStatus> getOrderStatuses() {
        return orderStatuses;
    }

    public static class Builder {
        private String textQuery;
        private Set<String> exchangeIds;
        private Set<String> eventTypeIds;
        private Set<String> eventIds;
        private Set<String> competitionIds;
        private Set<String> marketIds;
        private Set<String> venues;
        private boolean bspOnly;
        private boolean turnInPlayEnabled;
        private boolean inPlayOnly;
        private Set<MarketBettingType> bettingTypes;
        private Set<String> marketCountries;
        private Set<String> marketTypeCodes;
        private TimeRange marketStartTime;
        private Set<OrderStatus> orderStatuses;

        private Builder() {

        }

        public Builder withTextQuery(String text) {
            this.textQuery = text;
            return this;
        }

        public Builder withExchangeIds(String... exchangeIds) {
            this.exchangeIds = Arrays.stream(exchangeIds).collect(Collectors.toSet());
            return this;
        }

        public Builder withEventTypeIds(String... eventTypeIds) {
            this.eventTypeIds = Arrays.stream(eventTypeIds).collect(Collectors.toSet());
            return this;
        }

        public Builder withEventIds(String... eventIds) {
            this.eventIds = Arrays.stream(eventIds).collect(Collectors.toSet());
            return this;
        }

        public Builder withCompetitionIds(String... competitionIds) {
            this.competitionIds = Arrays.stream(competitionIds).collect(Collectors.toSet());
            return this;
        }

        public Builder withMarketIds(String... marketIds) {
            this.marketIds = Arrays.stream(marketIds).collect(Collectors.toSet());
            return this;
        }

        public Builder withVenues(String... venues) {
            this.venues = Arrays.stream(venues).collect(Collectors.toSet());
            return this;
        }

        public Builder withBspOnly(boolean bspOnly) {
            this.bspOnly = bspOnly;
            return this;
        }

        public Builder withTurnInPlayEnabled(boolean turnInPlayEnabled) {
            this.turnInPlayEnabled = turnInPlayEnabled;
            return this;
        }

        public Builder withInPlayOnly(boolean inPlayOnly) {
            this.inPlayOnly = inPlayOnly;
            return this;
        }

        public Builder withMarketBettingTypes(MarketBettingType... bettingTypes) {
            this.bettingTypes = Arrays.stream(bettingTypes).collect(Collectors.toSet());
            return this;
        }

        public Builder withMarketCountries(String... marketCountries) {
            this.marketCountries = Arrays.stream(marketCountries).collect(Collectors.toSet());
            return this;
        }

        public Builder withMarketTypeCodes(String... marketTypeCodes) {
            this.marketTypeCodes = Arrays.stream(marketTypeCodes).collect(Collectors.toSet());
            return this;
        }

        public Builder withMarketStartTime(Date from, Date to) {
            this.marketStartTime = new TimeRange(from, to);
            return this;
        }

        public Builder withOrders(OrderStatus... orderStatuses) {
            this.orderStatuses = Arrays.stream(orderStatuses).collect(Collectors.toSet());
            return this;
        }

        public MarketFilter build() {
            return new MarketFilter(textQuery, exchangeIds, eventTypeIds, eventIds, competitionIds, marketIds, venues,
                    bspOnly, turnInPlayEnabled, inPlayOnly, bettingTypes, marketCountries, marketTypeCodes,
                    marketStartTime, orderStatuses);
        }
    }
}
