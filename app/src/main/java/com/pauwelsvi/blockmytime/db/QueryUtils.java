package com.pauwelsvi.blockmytime.db;

import nl.qbusict.cupboard.QueryResultIterable;

import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    public static <T extends Object> List<T> getListFromQueryResultIterator(QueryResultIterable<T> iter) {
        final List<T> items = new ArrayList<>();
        for (T item : iter) {
            items.add(item);
        }
        iter.close();

        return items;
    }
}
