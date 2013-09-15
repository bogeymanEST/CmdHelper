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
 * Time: 15:06
 */
public class ModifierDef implements TagDef {
    @Info("The modifier's name")
    public String Name;
    @Info("The amount by which this Modifier modifies the Base value in calculations.")
    public Double Amount;
    @Info("0, 1, or 2. Defines the operation this Modifier executes on the Attribute's Base value. 0: Increment X by Amount, 1: Increment Y by X * Amount, 2: Y = Y * (1 + Amount) (equivalent to Increment Y by Y * Amount). The game first sets X = Base, then executes all Operation 0 modifiers, then sets Y = X, then executes all Operation 1 modifiers, and finally executes all Operation 2 modifiers.")
    @Min(0)
    @Max(2)
    public Integer Operation;

    @Override
    public String getName() {
        return "Modifier";
    }
}
