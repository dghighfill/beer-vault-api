package com.dh.beervaultapi.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

/**
 * Although most of the tutorials have you put things in this class, as your application grows, you'll want
 * to seperate concerns.  Sometimes it may warrant having something here, and in the original attempt at
 * implementing GraphQL, I had all the DAOs and the queries in this class.  as I found I could register the
 * resolvers from the configuration I moved to queries to their repsepctive Resolvers (e.g. beer queries went
 * to BeerQueryResolver)
 */
public class Query implements GraphQLQueryResolver {

    public Query() {
    }
}
