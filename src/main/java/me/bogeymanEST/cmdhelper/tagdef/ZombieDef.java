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
 * Time: 15:32
 */
public class ZombieDef extends MobDef {
    @Info("1 if the zombie is a villager")
    public Boolean IsVillager;
    @Info("1 if the zombie is a baby")
    public Boolean IsBaby;
    @Info("-1 when not being converted back to a villager, positive for the number of ticks until conversion back into a villager.")
    public Integer ConversionTime;

    @Override
    public String getName() {
        return "Zombie";
    }
}
