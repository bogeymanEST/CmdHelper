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
public class TameableDef extends MobDef {
    @Info("The name of this mob's owner")
    public String Owner;
    @Info("1 or 0 - 1 if the mob is sitting.")
    public Byte Sitting;

    @Override
    public String getName() {
        return "Tameable";
    }
}
