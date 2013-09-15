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
 * Time: 11:22
 */
public class ExplosionDef implements TagDef {
    @Info("1 or 0 - 1 if this explosion will have the Twinkle effect (glowstone dust)")
    public Byte Flicker;
    @Info("1 or 0 - 1 if this explosion will have the Trail effect (diamond).")
    public Byte Trail;
    @Info("The shape of this firework's explosion. 0 = Small Ball, 1 = Large Ball, 2 = Star-shaped, 3 = Creeper-shaped, 4 = Burst. Other values will be named \"Unknown Shape\" and render as Small Ball.")
    public Byte Type;
    @Info("List of primary colors")
    public List<Integer> Colors;
    @Info("List of fade colors")
    public List<Integer> FadeColors;

    @Override
    public String getName() {
        return "Explosion";
    }
}
