package com.github.advdrop;

import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class AdvDropUtil {

    private static Random RANDOM = new Random(new Random().nextLong());

    private AdvDropUtil() { }

    public static void giveItems(Player player, List<ItemStack> items, Block block) {
        Inventory inv = player.getInventory();
        Collection<ItemStack> dropToWorld = inv.addItem(items.toArray(new ItemStack[items.size()])).values();
        for (ItemStack drop : dropToWorld) {
            block.getWorld().dropItemNaturally(block.getLocation(), drop);
        }
    }

    public static void recalculateDurability(Player player, ItemStack item) {
        if (item.getType().getMaxDurability() == 0) return;

        int enchantLevel = item.getEnchantmentLevel(Enchantment.DURABILITY);
        short d = item.getDurability();

        if (enchantLevel > 0) {
            if ((100 / (enchantLevel + 1)) > RANDOM.nextInt(100)) {
                if (d == item.getType().getMaxDurability()) {
                    player.getInventory().clear(player.getInventory().getHeldItemSlot());
                    player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.0F);
                } else {
                    item.setDurability((short) (d + 1));
                }
            }
        } else {
            if (d == item.getType().getMaxDurability()) {
                player.getInventory().clear(player.getInventory().getHeldItemSlot());
                player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1.0F, 1.0F);
            } else {
                item.setDurability((short) (d + 1));
            }
        }
    }
}
