package com.github.advdrop.handler.random;

import com.github.advdrop.handler.DropContext;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;

import java.util.Map;

public class PermissionState extends AbstractDropState {

    private Map<String, Double> permissions;

    public PermissionState(DropState nextState, Map<String, Double> permissions) {
        super(nextState);
        this.permissions = permissions;
    }

    @Override public DropState getNextState(DropContext context) {

        Player player = context.getPlayer();
        for(Map.Entry<String, Double> record : permissions.entrySet()) {
            if(player.hasPermission("advdrop.drop." + record.getKey())) {
                context.addChance(record.getValue());
            }
        }

        return nextState;
    }

}
