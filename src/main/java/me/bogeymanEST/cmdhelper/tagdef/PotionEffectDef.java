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
 * Time: 11:18
 */
@SuppressWarnings("UnusedDeclaration")
public class PotionEffectDef implements TagDef {
    @Info("The ID of the effect.")
    public Byte Id;
    @Info("The amplifier of the effect, with 0 being level 1.")
    public Byte Amplifier;
    @Info("The duration of the effect in ticks.")
    public Integer Duration;
    @Info("1 if this is an effect provided by a beacon and therefore should be less intrusive on the screen.")
    public Boolean Ambient;

    @Override
    public String getName() {
        return "PotionEffect";
    }
}
