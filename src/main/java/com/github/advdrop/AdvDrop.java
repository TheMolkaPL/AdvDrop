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
package com.github.advdrop;

import com.github.advdrop.command.DropCommand;
import com.github.advdrop.listener.BlockBreakListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AdvDrop extends JavaPlugin {

    @Getter private static AdvDrop plugin;
    @Getter private AdvDropManager manager;
    
    @Override
    public void onEnable() {
        plugin = this;
        
        manager = new AdvDropManager(this);
        registerCommands();
        registerListener();
    }
    
    private void registerCommands() {
        this.getCommand("drop").setExecutor(new DropCommand());
    }

    private void registerListener() {
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(this), this);
    }
}
