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

/**
 * User: Bogeyman
 * Date: 13.09.13
 * Time: 10:34
 */
@SuppressWarnings({"UnusedDeclaration", "MismatchedReadAndWriteOfArray"})
public abstract class EntityDef implements TagDef {
    @Tuple({"X", "Y", "Z"})
    @Info("The position of the entity")
    public Double[] Pos;
    @Tuple({"X", "Y", "Z"})
    @Info("The motion of the entity")
    public Double[] Motion;
    @Tuple({"Yaw", "Pitch"})
    @Info("The rotation of the entity")
    public Float[] Rotation;
    @Info("Distance the entity has fallen. Larger values cause more damage when the entity lands")
    public Float FallDistance;
    @Info("Number of ticks until the fire is put out. Negative values reflect how long the entity can stand in fire before burning. Default -1 when not on fire.")
    public Short Fire;
    @Info("How much air the entity has, in ticks. Fills to a maximum of 300 in air, giving 15 seconds submerged before the entity starts to drown, and a total of up to 35 seconds before the entity dies (if it has 20 health). Decreases while underwater. If 0 while underwater, the entity loses 1 health per second.")
    public Short Air;
    @Info("1 if the entity is touching the ground.")
    public Boolean OnGround;
    @Info("1 if the entity should not take damage. This applies to living and nonliving entities alike: mobs will not take damage from any source (including potion effects) and objects such as vehicles and item frames cannot be destroyed unless their supports are removed. Note that these entities also cannot be moved by fishing rods, attacks, explosions, or projectiles.")
    public Boolean Invulnerable;
    @Info("The number of ticks before which the entity may be teleported back through a portal of any kind. Initially starts at 900 ticks (45 seconds) after teleportation and counts down to 0.")
    public Integer PortalCooldown;
    @Info("The data of the entity being ridden.")
    public EntityDef Riding;
}

