/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.*;

/**
 *
 * @author Joonas
 */
class QueryBuilder {

    Matcher matcher = new All();

    public QueryBuilder() {
        matcher = new And();
    }

    public Matcher build() {
        Matcher match = matcher;
        matcher = new All();
        return match;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int amount, String type) {
        this.matcher = new And(matcher, new HasAtLeast(amount, type));
        return this;
    }

    public QueryBuilder hasFewerThan(int amount, String type) {
        this.matcher = new And(matcher, new HasFewerThan(amount, type));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new And(matcher, new Or(matchers));
        return this;
    }
}
