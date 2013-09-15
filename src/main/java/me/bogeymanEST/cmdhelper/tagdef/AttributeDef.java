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
 * Time: 11:17
 */
public class AttributeDef implements TagDef {
    @Info("The name of this Attribute.")
    public String Name;
    @Info("The base value of this Attribute.")
    public Double Base;
    @Info("A list of Modifiers acting on this Attribute. Modifiers alter the Base value in internal calculations, without changing the original copy.\nNote that a Modifier will never modify Base to be higher than its maximum or lower than its minimum for a given Attribute.")
    public List<ModifierDef> Modifiers;

    @Override
    public String getName() {
        return "Attribute";
    }
}
