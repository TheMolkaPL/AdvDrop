package com.github.advdrop.listener;

import com.github.advdrop.AdvDrop;
import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class BlockBreakListener implements Listener {

    private AdvDrop plugin;

    @EventHandler
    public void onBlock(BlockBreakEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack tool = player.getItemInHand();

        Material material = block.getType();

        plugin.getManager().getHandler(material).breakBlock(block, player, tool);

    }

}
