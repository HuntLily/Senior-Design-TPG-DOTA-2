## Vectors

Global Accessor Variable: `Vector(x,y,z)`

`Vector(-6532,-6307.75, 388), -- near radiant spawn`

## Creating a unit

**CreateUnitByName**

Creates a DOTA unit by its dota_npc_units.txt name ( szUnitName, vLocation, bFindClearSpace, hNPCOwner, hUnitOwner, iTeamNumber ) 

## Associate a think function with a unit

void SetContextThink(string pszContextName, handle hThinkFunc, float flInterval) 

Example:
`bot:SetContextThink("playDota", Think(bot), 1)`

## Upgrade an Ability

Use `UpgradeAbility(hAbility)` and CDOTA_BaseNPC's `FindAbilityByName` to resolve the ability handler.

## GetFacing() Replacement
Use entity yaw as the facing value.

`GetAnglesAsVector()` Get entity pitch, yaw, roll as a vector

### Weird stuff
- CDOTA_BaseNPC:GetAttackRange is turning up nill when called on 

## Getting Nearby Creeps

Two possible methods may work here:
`handle FindByNameNearest(string name, Vector origin, float maxRadius)`

or

`handle FindByNameWithin(handle startFrom, string name, Vector origin, float maxRadius)`

This one seems to iterate, where as the first one seems to return all of them? Iterative one may be less expensive computationally...

or

`table FindAllByClassnameWithin(string string_1, Vector Vector_2, float float_3)`

## Attacking 
`void PerformAttack(handle hTarget, bool bUseCastAttackOrb, bool bProcessProcs, bool bSkipCooldown, bool bIgnoreInvis, bool bUseProjectile, bool bFakeAttack, bool bNeverMiss)`

## AddBot

`bool AddBot(string string_1, string string_2, string string_3, bool bool_4) `

**string_1** npc bot name (ie: "npc_dota_hero_nevermore")

**string_2** lane position (ie: "bot","mid","top")

**string_3** bot difficulty (ie: "passive", "easy", "medium", "hard", "unfair")

**bool_4** team (true = Radiant, false = dire)

## Using an item
Items are special forms of abilities. To use an item, retrieve it from the slot with:
`unit:GetItemInSlot(1)` and then user `CastAbility()` with the item handle. All together 
it lookds like `unit:GetItemInSlot(1):CastAbility()`.

## Runes
Work with rune spawn filter. Check out this example:

https://github.com/tontyoutoure/DOTA2-AI-Fun/blob/master/game/dota_addons/dota2_ai_fun/scripts/vscripts/gamemode.lua

### Picking them up

Walk to the spawner then search the nearby area for entities with classname `dota_item_rune` using something like `handle FindByClassnameNearest(string className, Vector origin, float maxRadius) `

Then use the handle with `PickupRune(handle hItem) `


### Rune Filters

Printing the table passed as a parameter in a rune spawn filter yields the following kinds of values:

`rune filter 4000
table: 0x001ba000
key
rune_type
value
2
key
spawner_entindex_const
value
495`

`rune filter 4000
table: 0x001ca3e8
key
rune_type
value
1
key
spawner_entindex_const
value
250`