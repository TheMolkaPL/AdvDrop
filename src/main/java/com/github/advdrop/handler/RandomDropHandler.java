package com.github.advdrop.handler;

import com.github.advdrop.AdvDropUtil;
import com.github.advdrop.RandomDropData;
import com.github.advdrop.handler.random.DropState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class RandomDropHandler implements DropHandler {

    private List<RandomDropData> drops;

    @Override public void breakBlock(Block block, Player player, ItemStack tool) {

        List<ItemStack> droppedItems = new ArrayList<>();

        for(RandomDropData data : drops) {
            DropContext context = new DropContext(player, block, tool);
            DropState localState = data.getFirstState();
            while (localState != null) {
                localState = localState.getNextState(context);
            }

            droppedItems.add(context.getDrop());
        }

        AdvDropUtil.giveItems(player, droppedItems, block);
        AdvDropUtil.recalculateDurability(player, tool);
    }

}
