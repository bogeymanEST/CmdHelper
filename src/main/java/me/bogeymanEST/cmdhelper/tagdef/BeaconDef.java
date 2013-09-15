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
 * Time: 10:33
 */
public class BeaconDef extends TileEntityDef {
    @Info("The number of levels available from the pyramid")
    public Integer Levels;
    @Info("Potion effect ID of the primary selected power. 0 = none")
    public Integer Primary;
    @Info("Potion effect ID of the secondary selected power. 0 = none")
    public Integer Secondary;

    @Override
    public String getName() {
        return "Beacon";
    }
}
