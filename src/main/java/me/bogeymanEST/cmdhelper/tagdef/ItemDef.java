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
 * Time: 10:49
 */
@SuppressWarnings("UnusedDeclaration")
public class ItemDef implements TagDef {
    @Info("The slot ID this item occupies in containers")
    public Byte Slot;
    @Info("The name or block ID of this item")
    public String id;
    @Info("The damage value")
    public Short Damage;
    @Info("The number of items in the stack")
    public Byte Count;
    @Info("Additional information about the item")
    public ItemTagDef tag;

    @Override
    public String getName() {
        return "Item";
    }
}
