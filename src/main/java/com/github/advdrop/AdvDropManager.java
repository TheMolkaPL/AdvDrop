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

import com.github.advdrop.handler.DefaultDropHandler;
import com.github.advdrop.handler.DropHandler;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public class AdvDropManager {
    @Getter private final Map<Material, DropHandler> materialMap = new HashMap<>();
    private final DropHandler defaultDropHandler;

    public AdvDropManager(AdvDrop plugin) {
        this.defaultDropHandler = new DefaultDropHandler();
    }

    public DropHandler getHandler(Material material) {
        DropHandler handler = this.materialMap.get(material);
        if(handler != null) {
            return handler;
        }
        return this.defaultDropHandler;
    }
    
    public void setHandler(Material material, DropHandler handler) {
        this.materialMap.put(material, handler);
    }
}
