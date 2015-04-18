/*
 * Copyright 2015 TheMolkaPL.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.advdrop.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DropCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || args.length > 0 && args[0].equals("-nogui")) {
            this.asCUI(sender);
        } else {
            this.asGUI((Player) sender);
        }
        return false;
    }
    
    private void asGUI(Player player) {
        
    }
    
    private void asCUI(CommandSender sender) {
        String title = ChatColor.DARK_AQUA + " = = = = = = = ";
        sender.sendMessage(title + ChatColor.RED + " = Aktualny drop = " + title);
        
    }
}
