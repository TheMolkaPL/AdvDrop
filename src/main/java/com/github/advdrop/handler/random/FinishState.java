package com.github.advdrop.handler.random;

import com.github.advdrop.handler.DropContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FinishState implements DropState {

    public static final DropState INSTANCE = new FinishState();

    @Override public DropState getNextState(DropContext context) {
        return null;
    }
}
