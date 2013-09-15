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
 * Date: 13.09.13
 * Time: 15:12
 */
public class EntityHorseDef extends MobDef {

    @Info("1 = horse has chests")
    public Byte ChestedHorse;
    @Info("1 = horse is grazing")
    public Byte EatingHaystack;
    @Info("1 = horse is tamed")
    public Byte Tame;
    @Info("0 - 100, higher values make the horse easier to tame")
    public Integer Temper;
    @Info("The type of the horse. 0 = Horse, 1= Donkey, 2= Mule, 3 = Zombie, 4 = Skeleton.")
    public Integer Type;
    @Info("The variant of the horse. Determines colors.")
    public Integer Variant;
    @Info("The name of the player who owns this horse")
    public String OwnerName;
    @Info("List of items the horse is carrying. Only effective if ChestedHorse is set to 1")
    public List<ItemDef> Items;
    @Info("The armor item")
    public ItemDef ArmorItem;
    @Info("The saddle item")
    public ItemDef SaddleItem;

    @Override
    public String getName() {
        return "Horse";
    }
}
