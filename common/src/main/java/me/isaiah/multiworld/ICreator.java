package me.isaiah.multiworld;

import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;

public interface ICreator {
    
    public ServerWorld create_world(String id, RegistryKey<DimensionType> dim, ChunkGenerator gen, Difficulty dif, GameRules gr);

}