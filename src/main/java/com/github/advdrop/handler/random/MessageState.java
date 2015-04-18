package com.github.advdrop.handler.random;

import com.github.advdrop.handler.DropContext;

public class MessageState extends AbstractDropState {

    private String message; //TODO

    public MessageState(DropState nextState, String message) {
        super(nextState);
        this.message = message;
    }

    @Override public DropState getNextState(DropContext context) {
        context.getPlayer().sendMessage(
                message.replace("%AMOUNT%", context.getDrop().getAmount() + "")
                        .replace("%NAME%", context.getDrop().getType().name().toLowerCase()) //TODO
        );
        return nextState;
    }
}
