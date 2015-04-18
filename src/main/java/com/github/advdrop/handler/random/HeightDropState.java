package com.github.advdrop.handler.random;

import com.github.advdrop.handler.DropContext;

public class HeightDropState extends AbstractDropState {

    private int maxHeight; //TODO compare system

    public HeightDropState(DropState nextState, int maxHeight) {
        super(nextState);
        this.maxHeight = maxHeight;
    }

    @Override public DropState getNextState(DropContext context) {
        if(context.getBlock().getLocation().getBlockY() <= maxHeight) {
            return nextState;
        }
        return null;
    }
}
