package com.github.advdrop.handler.random;

import com.github.advdrop.handler.DropContext;

public abstract class AbstractDropState implements DropState {

    protected DropState nextState;

    public AbstractDropState(DropState nextState) {
        this.nextState = nextState;
    }

    @Override public abstract DropState getNextState(DropContext context);

    @Override
    public String toString() {
        String prefix = "{ " + getClass().getSimpleName() + "";
        if(nextState != null) {
            prefix = prefix + ": " + nextState.toString();
        }
        prefix = prefix + " }";
        return prefix;
    }
}
