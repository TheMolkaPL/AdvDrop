package com.github.advdrop.handler.random;

import com.github.advdrop.handler.DropContext;
import lombok.RequiredArgsConstructor;
import org.bukkit.enchantments.Enchantment;

@RequiredArgsConstructor
public class SilkTouchState implements DropState {

    private final DropState nextStateWithSilkTouch;
    private final DropState nextStateWithoutSiltTouch;

    @Override public DropState getNextState(DropContext context) {
        if(context.getTool().containsEnchantment(Enchantment.SILK_TOUCH)) {
            return nextStateWithSilkTouch;
        } else {
            return nextStateWithoutSiltTouch;
        }
    }
}
