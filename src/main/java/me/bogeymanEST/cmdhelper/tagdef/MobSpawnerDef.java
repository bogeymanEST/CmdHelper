/*
 * CmdHelper
 * Copyright (C) 2013 bogeymanEST
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package me.bogeymanEST.cmdhelper.tagdef;

import java.util.List;

/**
 * User: Bogeyman
 * Date: 14.09.13
 * Time: 10:40
 */
public class MobSpawnerDef extends TileEntityDef {
    @Info("List of possible entities to spawn.")
    public List<PotentialSpawnDef> SpawnPotentials;
    @Info("The Entity ID of the next entity(s) to spawn. If SpawnPotentials exists, this will be overwritten next time an entity is spawned.")
    public String EntityId;
    @Info("Tags to copy to the next spawned entity(s) after spawning. If SpawnPotentials exists, this will be overwritten next time an entity is spawned.")
    public TagDef SpawnData;
    @Info("How many mobs to attempt to spawn each time.")
    public Short SpawnCount;
    @Info("The radius around which the spawner attempts to place mobs randomly.")
    public Short SpawnRange;
    @Info("Ticks until next spawn. If 0, it will spawn immediately when a player enters its range.")
    public Short Delay;
    @Info("Minimum random delay for the next spawn delay.")
    public Short MinSpawnDelay;
    @Info("Maximum random delay for the nexy spawn delay.")
    public Short MaxSpawnDelay;
    @Info("Overrides the maximum number of nearby entities whose IDs match this spawner's entity ID.")
    public Short MaxNearbyEntities;
    @Info("Overrides the radius a player must be in for the spawner to activate.")
    public Short RequiredPlayerRange;

    @Override
    public String getName() {
        return "MobSpawner";
    }
}
