package com.github.advdrop;

import com.github.advdrop.handler.DropHandler;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class AdvDropManager {

    private Map<Material, DropHandler> materialMap = new HashMap<>();
    private DropHandler defaultDropHandler;

    public AdvDropManager(AdvDrop plugin) {

    }

    public DropHandler getHandler(Material material) {
        DropHandler handler = materialMap.get(material);
        if(handler != null) {
            return handler;
        }
        return defaultDropHandler;
    }
}
