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
 * Time: 11:29
 */
public class ItemTagsDef extends ItemTagDef {
    //Book
    @Info("Book: the title of the book")
    public String title;
    @Info("Book: the author of the book")
    public String author;
    @Info("Book: list of pages in the book")
    public List<String> pages;

    //Skull
    @Info("Skull: name of the player this is a skuall of.")
    public String SkullOwner;

    //Potion
    @Info("Potion: list of potion effects")
    public List<PotionEffectDef> CustomPotionEffects;

    //Enchantment
    @Info("List of enchantments that affect the way the item works.")
    public List<EnchantmentDef> ench;
    @Info("Enchantments stored in an enchated book")
    public List<EnchantmentDef> StoredEnchantments;
    @Info("Number of enchantment levels to add to the base level cost when repairing, combining, or renaming this item with an Anvil.")
    public Integer RepairCost;

    //Display
    @Info("Display properties")
    public DisplayDef display;

    //Fireworks
    @Info("Used on a firework star.")
    public ExplosionDef Explosion;
    @Info("Used on a firework rocket.")
    public FireworksDef Fireworks;

    @Override
    public String getName() {
        return "Item Tags";
    }
}
