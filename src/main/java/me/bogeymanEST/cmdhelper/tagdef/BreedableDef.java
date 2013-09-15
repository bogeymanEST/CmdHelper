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
 * Time: 15:09
 */
public class BreedableDef extends MobDef {
    @Info("Number of ticks until the mob loses its breeding hearts and stops searching for a mate. 0 when not searching for a mate.")
    public Integer InLove;
    @Info("Represents the age of the mob in ticks; when negative, the mob is a baby. When 0 or above, the mob is an adult. When above 0, represents the number of ticks before this mob can breed again.")
    public Integer Age;

    @Override
    public String getName() {
        return "BreedableMob";
    }
}
