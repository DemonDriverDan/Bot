package com.abbitt.trading.domain.stream;


import com.abbitt.trading.domain.betting.EventTypeIds;
import com.abbitt.trading.domain.betting.MarketBettingType;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMarketFilter {

    private final Set<String> marketCodes;
    private final Set<MarketBettingType> bettingTypes;
    private final boolean turnInPlayEnabled;
    private final Set<String> marketTypes;
    private final Set<String> venues;
    private final Set<String> marketIds;
    private final Set<String> eventTypeIds;
    private final Set<String> eventIds;
    private final boolean bspMarket;

    public StreamMarketFilter(Set<String> marketCodes, Set<MarketBettingType> bettingTypes,
                              boolean turnInPlayEnabled, Set<String> marketTypes, Set<String> venues,
                              Set<String> marketIds, Set<String> eventTypeIds, Set<String> eventIds, boolean bspMarket) {
        this.marketCodes = marketCodes;
        this.bettingTypes = bettingTypes;
        this.turnInPlayEnabled = turnInPlayEnabled;
        this.marketTypes = marketTypes;
        this.venues = venues;
        this.marketIds = marketIds;
        this.eventTypeIds = eventTypeIds;
        this.eventIds = eventIds;
        this.bspMarket = bspMarket;
    }

    public Set<String> getMarketCodes() {
        return marketCodes;
    }

    public Set<MarketBettingType> getBettingTypes() {
        return bettingTypes;
    }

    public boolean isTurnInPlayEnabled() {
        return turnInPlayEnabled;
    }

    public Set<String> getMarketTypes() {
        return marketTypes;
    }

    public Set<String> getVenues() {
        return venues;
    }

    public Set<String> getMarketIds() {
        return marketIds;
    }

    public Set<String> getEventTypeIds() {
        return eventTypeIds;
    }

    public Set<String> getEventIds() {
        return eventIds;
    }

    public boolean isBspMarket() {
        return bspMarket;
    }

    public class Builder {
        private Set<String> marketCodes;
        private Set<MarketBettingType> bettingTypes;
        private boolean turnInPlayEnabled = true;
        private Set<String> marketTypes;
        private Set<String> venues;
        private Set<String> marketIds;
        private Set<String> eventTypeIds;
        private Set<String> eventIds;
        private boolean bspMarket = true;

        public Builder withMarketCodes(String... marketCodes) {
            this.marketCodes = Arrays.stream(marketCodes).collect(Collectors.toSet());
            return this;
        }

        public Builder withBettingTypes(MarketBettingType... bettingTypes) {
            this.bettingTypes = Arrays.stream(bettingTypes).collect(Collectors.toSet());
            return this;
        }

        public Builder withTurnInPlayEnabled(boolean turnInPlayEnabled) {
            this.turnInPlayEnabled = turnInPlayEnabled;
            return this;
        }

        public Builder withMarketTypes(String... marketTypes) {
            this.marketTypes = Arrays.stream(marketTypes).collect(Collectors.toSet());
            return this;
        }

        public Builder withVenues(String... venues) {
            this.venues = Arrays.stream(venues).collect(Collectors.toSet());
            return this;
        }

        public Builder withMarketIds(String... marketIds) {
            this.marketIds = Arrays.stream(marketIds).collect(Collectors.toSet());
            return this;
        }

        public Builder withEventTypeIds(String... eventTypeIds) {
            this.eventTypeIds = Arrays.stream(eventTypeIds).collect(Collectors.toSet());
            return this;
        }

        public Builder withEventTypeIds(EventTypeIds... eventTypeIds) {
            this.eventTypeIds = Arrays.stream(eventTypeIds).map(EventTypeIds::getValue).collect(Collectors.toSet());
            return this;
        }

        public Builder withEventIds(String... eventIds) {
            this.eventIds = Arrays.stream(eventIds).collect(Collectors.toSet());
            return this;
        }

        public Builder withBspMarket(boolean bspMarket) {
            this.bspMarket = bspMarket;
            return this;
        }

        public StreamMarketFilter build() {
            return new StreamMarketFilter(marketCodes, bettingTypes, turnInPlayEnabled, marketTypes, venues,
                    marketIds, eventTypeIds, eventIds, bspMarket);
        }
    }
}
