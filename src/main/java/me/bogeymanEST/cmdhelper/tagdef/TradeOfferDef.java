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
 * Time: 15:25
 */
public class TradeOfferDef implements TagDef {
    @Info("The maximum number of times this trade can be used before it is disabled.")
    public Integer maxUses;
    @Info("The number of times this trade has been used. The trade becomes disabled when this is greater or equal to maxUses.")
    public Integer uses;
    @Info("The first 'cost' item, without the Slot tag.")
    public ItemDef buy;
    @Info("May not exist. The second 'cost' item, without the Slot tag.")
    public ItemDef buyB;
    @Info("The item being sold for each set of cost items, without the Slot tag.")
    public ItemDef sell;

    @Override
    public String getName() {
        return "TradeOffer";
    }
}
