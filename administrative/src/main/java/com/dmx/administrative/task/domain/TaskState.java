package com.dmx.administrative.task.domain;

import com.dmx.shared.domain.BooleanValueObject;

public final class TaskState extends BooleanValueObject {
    public TaskState(boolean value) {
        super(value);
    }
}