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
 * Date: 13.09.13
 * Time: 11:16
 */
@SuppressWarnings({"UnusedDeclaration", "MismatchedReadAndWriteOfArray"})
public abstract class MobDef extends EntityDef {
    @Info("Amount of health the entity has. A value of 1 is half a heart. Ignored if HealF is set.")
    public Short Health;
    @Info("A float value of health. If it's set, Health is ignored.")
    public Float HealF;
    @Info("Amount of extra health added by Absorption effect.")
    public Float AbsorbtionAmount;
    @Info("Number of ticks the mob's \"invincibility shield\" lasts after the mob was last struck. 0 when not recently hit.")
    public Short AttackTime;
    @Info("Number of ticks the mob turns red for after being hit. 0 when not recently hit.")
    public Short HurtTime;
    @Info("Number of ticks the mob has been dead for. Controls death animations. 0 when alive.")
    public Short DeathTime;
    @Info("A list of Attributes for this mob. These are used for many purposes in internal calculations, and can be considered a mob's \"statistics\".")
    public List<AttributeDef> Attributes;
    @Info("The list of potion effects on this mob.")
    public List<PotionEffectDef> ActiveEffects;
    @Tuple({"Hand", "Feet", "Legs", "Chest", "Head"})
    @Info("List of equipment this mob has")
    public ItemDef[] Equipment;
    @Tuple({"Hand", "Feet", "Legs", "Chest", "Head"})
    @Info("List of float values (0.0 to 1.0) representing chance to drop the corresponding equipment item.")
    public Float[] DropChances;
    @Info("1 if the mob can pick up loot (wear armor it picks up, use weapons it picks up).")
    public Boolean CanPickUpLoot;
    @Info("1 if the mob must not despawn naturally.")
    public Boolean PersistenceRequired;
    @Info("The custom name of this entity. Appears in player death messages and villager trading interfaces, as well as above the mob's head when your cursor is over it.")
    public String CustomName;
    @Info("if 1, and this mob has a custom name, it will always appear above their head, whether or not the cursor is pointing at it.")
    public Boolean CustomNameVisible;

    @Override
    public String getName() {
        return "Mob";
    }
}
