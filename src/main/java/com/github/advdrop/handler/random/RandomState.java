package com.github.advdrop.handler.random;

import com.github.advdrop.handler.DropContext;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RandomState extends AbstractDropState {

    private Material material;

    public RandomState(DropState nextState, Material material) {
        super(nextState);
        this.material = material;
    }

    @Override public DropState getNextState(DropContext context) {
        if ( context.getChance() > Math.random() ) {
            context.setDrop(new ItemStack(material, 1));
            //player.giveExp(rd.getExp());
            //if (rd.getMessage() != null) {
            //    NewDrop.getMessageAdapter().sendMessage(player, rd.getMessage(), block.getLocation());
            //}
        }
        return nextState;
    }

}
