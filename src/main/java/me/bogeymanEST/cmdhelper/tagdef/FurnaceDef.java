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
 * Time: 10:38
 */
public class FurnaceDef extends ContainerDef {
    @Info("Number of ticks left before the current fuel runs out.")
    public Short BurnTime;
    @Info("Number of ticks the item has been smelting for. The item finishes smelting when this value reaches 200 (10 seconds). Is reset to 0 if BurnTime reaches 0.")
    public Short CookTime;
    @Info("Items that are in the furnace. Slot 0 = item being smelted, 1 = next item to use as fuel, 2 = result")
    public List<ItemDef> Items;

    @Override
    public String getName() {
        return "Furnace";
    }
}
