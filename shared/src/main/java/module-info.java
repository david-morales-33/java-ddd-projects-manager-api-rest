module shared {
    requires java.sql;
    exports com.dmx.shared.domain;
    exports com.dmx.shared.domain.bus.event;
    exports com.dmx.shared.domain.bus.query;
    exports com.dmx.shared.domain.bus.command;
    exports com.dmx.shared.domain.criteria;
    exports com.dmx.shared.exceptions;
}