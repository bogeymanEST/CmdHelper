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
 * Time: 11:00
 */
public class SignDef extends TileEntityDef {
    @Info("Text on the first line")
    public String Text1;
    @Info("Text on the second line")
    public String Text2;
    @Info("Text on the third line")
    public String Text3;
    @Info("Text on the fourth line")
    public String Text4;

    @Override
    public String getName() {
        return "Sign";
    }
}
