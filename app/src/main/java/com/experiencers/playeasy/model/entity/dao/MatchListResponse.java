package com.experiencers.playeasy.model.entity.dao;

import com.experiencers.playeasy.model.entity.Match;
import com.experiencers.playeasy.model.entity.MatchLocation;

public class MatchListResponse {
    private Match match;
    private MatchLocation matchLocation;

    public MatchListResponse(Match match, MatchLocation matchLocation) {
        this.match = match;
        this.matchLocation = matchLocation;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public MatchLocation getMatchLocation() {
        return matchLocation;
    }

    public void setMatchLocation(MatchLocation matchLocation) {
        this.matchLocation = matchLocation;
    }
}
