package me.isaiah.multiworld.fabric;

import me.isaiah.multiworld.ICreator;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;

import xyz.nucleoid.fantasy.Fantasy;
import xyz.nucleoid.fantasy.RuntimeWorldConfig;
import xyz.nucleoid.fantasy.RuntimeWorldHandle;

import net.minecraft.util.Identifier;
import me.isaiah.multiworld.MultiworldMod;

public class FabricWorldCreator implements ICreator {
    
    public static void init() {
        MultiworldMod.setICreator(new FabricWorldCreator());
    }
    
    public ServerWorld create_world(String id, RegistryKey<DimensionType> dim, ChunkGenerator gen, Difficulty dif, GameRules gr) {
        RuntimeWorldConfig config = new RuntimeWorldConfig()
                .setDimensionType(dim)
                .setGenerator(gen)
                .setDifficulty(dif)
                .setGameRule(GameRules.RANDOM_TICK_SPEED, gr.getInt(GameRules.RANDOM_TICK_SPEED))
                .setGameRule(GameRules.DO_FIRE_TICK, gr.getBoolean(GameRules.DO_FIRE_TICK))
                .setGameRule(GameRules.DO_MOB_SPAWNING, gr.getBoolean(GameRules.DO_MOB_SPAWNING))
                .setGameRule(GameRules.DO_DAYLIGHT_CYCLE, gr.getBoolean(GameRules.DO_DAYLIGHT_CYCLE))
                ;

        
        Fantasy fantasy = Fantasy.get(MultiworldMod.mc);
        RuntimeWorldHandle worldHandle = fantasy.getOrOpenPersistentWorld(new Identifier(id), config);
        return worldHandle.asWorld();
    }
    
    public void delete_world(String id) {
        Fantasy fantasy = Fantasy.get(MultiworldMod.mc);
        RuntimeWorldHandle worldHandle = fantasy.getOrOpenPersistentWorld(new Identifier(id), null);
        worldHandle.delete();
    }

}