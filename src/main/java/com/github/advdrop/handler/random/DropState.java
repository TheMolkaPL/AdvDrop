package com.github.advdrop.handler.random;

import com.github.advdrop.handler.DropContext;

public interface DropState {

    public DropState getNextState(DropContext context);

}
