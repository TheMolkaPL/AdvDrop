package com.github.advdrop;

import com.github.advdrop.handler.RandomDropHandler;
import com.github.advdrop.handler.random.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.Material;

import java.util.*;

@Getter
@RequiredArgsConstructor
public class RandomBuilder {

    private final Material material;
    private Set<Material> neededTools = new HashSet<>();

    @Setter
    private int neededHeight = 0; //TODO

    @Setter
    private double defaultChance = 0.0D;

    private Map<String, Double> permissionChance = new HashMap<>();

    @Setter
    private Material silkTouchMaterial;

    /*
     * State order:
     *   height
     *   neededTools
     *   permission
     *   silktouch
     *   random
     *   message
     *
     */

    public RandomDropData build() {

        DropState next = FinishState.INSTANCE;
        next = new MessageState(next, "Dostales %AMOUNT% %NAME%");

        if(silkTouchMaterial != null && material != silkTouchMaterial) {
            next = new SilkTouchState(new RandomState(next, material), new RandomState(next, silkTouchMaterial));
        } else {
            next = new RandomState(next, material);
        }

        next = buildPermsState(next);
        next = buildNeededToolsState(next);
        next = buildHeightState(next);

        return new RandomDropData(next);
    }

    private DropState buildHeightState(DropState next) {
        if(neededHeight > 0) {
            return new HeightDropState(next, neededHeight);
        }
        return next;
    }

    private DropState buildPermsState(DropState next) {
        if(permissionChance != null) {
            return new PermissionState(next, permissionChance);
        }
        return next;
    }

    private DropState buildNeededToolsState(DropState next) {
        //TODO
        return next;
    }


}
