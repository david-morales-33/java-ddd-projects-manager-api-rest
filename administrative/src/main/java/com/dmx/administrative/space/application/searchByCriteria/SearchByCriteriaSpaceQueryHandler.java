package com.dmx.administrative.space.application.searchByCriteria;

import com.dmx.shared.domain.bus.query.QueryHandler;
import com.dmx.shared.domain.criteria.Filters;
import com.dmx.shared.domain.criteria.Order;

import java.util.Optional;

public final class SearchByCriteriaSpaceQueryHandler implements QueryHandler<SearchByCriteriaSpaceQuery, SpaceResponse> {
    private final SpaceByCriteriaSearcher searcher;

    public SearchByCriteriaSpaceQueryHandler(SpaceByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public SpaceResponse handle(SearchByCriteriaSpaceQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order order = Order.fromValues(query.orderBy(), query.orderType());
        Optional<Integer> offset = query.offset();
        Optional<Integer> limit = query.limit();
        return this.searcher.execute(filters, order, offset, limit);
    }
}
