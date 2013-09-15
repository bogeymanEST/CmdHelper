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
 * Date: 14.09.13
 * Time: 10:23
 */
public class FallingSandDef extends DynamicTileDef {
    @Info("The block ID")
    public Integer TileID;
    @Info("Tile entity data")
    public TileEntityDef TileEntityData;
    @Info("The block data")
    public Byte Data;
    @Info("The number of ticks the entity has existed. If set to 0, the moment it ticks to 1, it will vanish if the block at its location has a different ID than the entity's TileID. If the block at its location has the same ID as its TileID when Time ticks from 0 to 1, the block will instead be deleted, and the entity will continue to fall, having overwritten it.")
    public Byte Time;
    @Info("1 if the block should drop an item when broken")
    public Boolean DropItem;
    @Info("1 if the block should hurt entities it falls on")
    public Boolean HurtEntites;
    @Info("The maximum number of hitpoints of damage to inflict on entities that intersect this FallingSand.")
    public Integer FallHurtMax;
    @Info("Multiplied by the FallDistance to calculate the amount of damage to inflict.")
    public Float FallHurtAmount;

    @Override
    public String getName() {
        return "FallingSand";
    }
}
