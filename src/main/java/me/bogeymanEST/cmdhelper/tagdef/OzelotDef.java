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
 * Time: 15:14
 */
public class OzelotDef extends TameableDef {
    @Info("The ID of the skin the ocelot has. 0 is wild ocelot, 1 is tuxuedo, 2 is tabby and 3 is siamese. Does not determine an ocelot's behavior: it will be wild unless its Owner string is not empty, meaning wild ocelots can look like cats and vice versa.")
    @Min(0)
    @Max(3)
    public Integer CatType;

    @Override
    public String getName() {
        return "Ozelot";
    }
}
