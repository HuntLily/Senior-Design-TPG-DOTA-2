require ("bots/utility")
local bit = require "bots/numberlua"
local value = true
local action = 0
local count = 1 
local thinkCount = 1
local ack = true
local dropped = 0
local abilityCursor = 1
local itemCursor = 1

DO_NOTHING              = 0
MOVE_N                  = 1
MOVE_NE                 = 2
MOVE_E                  = 3
MOVE_SE                 = 4
MOVE_S                  = 5
MOVE_SW                 = 6
MOVE_W                  = 7
MOVE_NW                 = 8
GET_BOUNTY_RUNE_1       = 9
GET_BOUNTY_RUNE_3       = 10
GET_TOP_POWERUP_RUNE    = 11
GET_BOTTOM_POWERUP_RUNE = 12
ATTACK_ENEMY_HERO       = 13
ATTACK_ENEMY_TOWER      = 14
ATTACK_CREEP_0          = 15
ATTACK_CREEP_1          = 16
ATTACK_CREEP_2          = 17
ATTACK_CREEP_3          = 18
ATTACK_CREEP_4          = 19
ATTACK_CREEP_5          = 20
ATTACK_CREEP_6          = 21
ATTACK_CREEP_7          = 22
ATTACK_CREEP_8          = 23
ATTACK_CREEP_9          = 24
CAST_SHADOWRAZE_1       = 25
CAST_SHADOWRAZE_2       = 26
CAST_SHADOWRAZE_3       = 27
CAST_REQUIEM_OF_SOULS   = 28
USE_SALVE               = 29

abilitiesOrder = { "nevermore_shadowraze1",
                   "nevermore_necromastery",
                   "nevermore_shadowraze1",
                   "nevermore_necromastery",
                   "nevermore_shadowraze1",
                   "nevermore_necromastery",
                   "nevermore_shadowraze1",
                   "nevermore_necromastery",
                   "nevermore_requiem",
                   "special_bonus_spell_amplify_8",
                   "nevermore_dark_lord",
                   "nevermore_requiem",
                   "nevermore_dark_lord",
                   "nevermore_dark_lord",
                   "special_bonus_movement_speed_30",
                   "nevermore_dark_lord",
                   "nevermore_requiem",
                   "special_bonus_unique_nevermore_2",
				   "special_bonus_cooldown_reduction_40" }
				   
itemsOrder = { "item_branches",
				"item_branches",
				"item_slippers",
				"item_circlet",
				"item_recipe_wraith_band",
				"item_boots",
				"item_gloves",
				"item_belt_of_strength",
				"item_yasha",
				"item_sange",
				"item_force_staff",
				"item_dragon_lance",
				"item_recipe_hurricane_pike"
			}
----------------------------------------------------------------------------------------------------
function Think(unit, gameId, addon)
	-- If the previously requested action has not been received, wait.
	if ack == false then
		dropped = dropped + 1
		return		
	end
	
	print("DROPPED " .. dropped)
	dropped = 0
	
	-- Re-lock the Think() function
	ack = false
	
	-- Only complete the previous Think() logic if there was a previous frame. 
	if count ~= 1 then
		-- If ack has been set, we can apply the action we received.
		applyAction(action, count, unit)
		
		-- Print verify the action was applied
		print("YAR " .. count .. " " .. thinkCount .. " " .. action)
		
		-- Verify the end of the previous 
		print("END " .. count .. " " .. thinkCount)
	end
	
	-- Update the Think() counters
	count = thinkCount
	thinkCount = thinkCount + 1
	
	-- Verify the beginning of feature evaluation logic.
	print("BEG " .. count .. " " .. thinkCount)
	
	-- If the bot has not yet learned an initial ability, give it one here.
	if value then
		print("Upgrade initial ability, buy flask and activate courier")
		unit:UpgradeAbility(unit:FindAbilityByName("nevermore_shadowraze1"))
		unit:AddItemByName("item_flask") -- TODO: Subtract appropriate gold?
		PlayerResource:SpendGold(0, unit:GetItemInSlot(0):GetCost(), DOTA_ModifyGold_PurchaseItem )
		value = false
	end

	-- Upgrade abilities as possible
	if unit:GetAbilityPoints() > 0 and abilityCursor < 18 then
		if unit:HasAbility(abilitiesOrder[abilityCursor]) then
			unit:UpgradeAbility(unit:FindAbilityByName(abilitiesOrder[abilityCursor]))
		end
		abilityCursor = abilityCursor + 1
	end

	-- Get the talents at level 20 aand 25
	if unit:GetLevel() == 20 or unit:GetLevel() == 25 then
		if unit:HasAbility(abilitiesOrder[abilityCursor]) then
			unit:UpgradeAbility(unit:FindAbilityByName(abilitiesOrder[abilityCursor]))
		end
		abilityCursor = abilityCursor + 1
	end	

	-- Buy items as possible
	if itemCursor < 14 and GetItemCost(itemsOrder[itemCursor]) < unit:GetGold() then

		print("Enough item space")
		print(unit:GetNumItemsInInventory())

		if unit:GetNumItemsInInventory() > 5 then
			local ironBranch = unit:FindItemInInventory("item_branches")
			print("iron branch?")
			print(ironBranch)
			if ironBranch ~= nil then
				unit:RemoveItem(ironBranch)
			end
		end

		unit:AddItemByName(itemsOrder[itemCursor])
		PlayerResource:SpendGold(0, GetItemCost(itemsOrder[itemCursor]), DOTA_ModifyGold_PurchaseItem)
		itemCursor = itemCursor + 1


		
	end
	
	-- Retrieve the feature set from the environment.
	local featureSet = getFeatures(unit,addon)	

	-- Create a JSON string containing the features header label.
	local featureString = '{ "gameId": "'.. gameId .. '","state":"in-progress", "features": ['
	
	-- Add all of the feature values to the JSON string
	for k,v in pairs(featureSet) do			
		featureString = featureString .. v .. ", "
	end
	
	-- Add the terminal brackets to the JSON string
	featureString = featureString:sub(0, featureString:len()-2) .. "]}"
	
	-- Create a new HTTP Request
	local request = CreateHTTPRequestScriptVM("POST", "http://localhost:8085/dota2/")
	
	-- Add the JSON string to the HTTP Request as the body
	request:SetHTTPRequestRawPostBody("application/json", featureString)

	print("featureString", featureString)
	
	-- Send the HTTP Request and set the reply logic.
	request:Send( 
		function(result) 
			action = tonumber(result["Body"]) 
			print("result[Body]", result["Body"])
			print(result)
			
			print("ACT " .. count .. " " .. thinkCount .. " ".. action)
			ack = true 
			
		end 
	)
	
	print("think done")
	
end

function applyAction(action, c, bot)
	print("APPLY " .. c .. " " .. thinkCount .. " " .. action)
	
	if action == nil then 
		print("NIL")
		return
	end
	
	print("POST " .. c .. " " .. thinkCount .. " " .. action)
	
	if     action == MOVE_N                  then moveOffset(bot, 100 ,  100)
	elseif action == MOVE_NE                 then moveOffset(bot, 100 ,    0)
	elseif action == MOVE_E                  then moveOffset(bot, 100 , -100)
	elseif action == MOVE_SE                 then moveOffset(bot, 0   , -100)
	elseif action == MOVE_S                  then moveOffset(bot, -100, -100)
	elseif action == MOVE_SW                 then moveOffset(bot, -100,   -0)
	elseif action == MOVE_W                  then moveOffset(bot, -100,  100)
	elseif action == MOVE_NW                 then moveOffset(bot, 0   ,  100)
	elseif action == GET_BOUNTY_RUNE_1       then getRune(bot,GetBountyRune(1))
	elseif action == GET_BOUNTY_RUNE_3       then getRune(bot,GetBountyRune(3))
	elseif action == GET_TOP_POWERUP_RUNE    then getRune(bot,GetPowerRune(1))
	elseif action == GET_BOTTOM_POWERUP_RUNE then getRune(bot,GetPowerRune(2))
	elseif action == ATTACK_ENEMY_HERO       then attackEnemyHero(bot)
	elseif action == ATTACK_ENEMY_TOWER      then attackEnemyTower(bot)
	elseif action == ATTACK_CREEP_0          then attackCreep(bot,1, true)
	elseif action == ATTACK_CREEP_1          then attackCreep(bot,2, true)
	elseif action == ATTACK_CREEP_2          then attackCreep(bot,3, true)
	elseif action == ATTACK_CREEP_3          then attackCreep(bot,4, true)
	elseif action == ATTACK_CREEP_4          then attackCreep(bot,5, true)
	elseif action == ATTACK_CREEP_5          then attackCreep(bot,1, false)
	elseif action == ATTACK_CREEP_6          then attackCreep(bot,2, false)
	elseif action == ATTACK_CREEP_7          then attackCreep(bot,3, false)
	elseif action == ATTACK_CREEP_8          then attackCreep(bot,4, false)
	elseif action == ATTACK_CREEP_9          then attackCreep(bot,5, false)
	elseif action == CAST_SHADOWRAZE_1       then castSpell(bot,"nevermore_shadowraze1")
	elseif action == CAST_SHADOWRAZE_2       then castSpell(bot,"nevermore_shadowraze2")
	elseif action == CAST_SHADOWRAZE_3       then castSpell(bot,"nevermore_shadowraze3")
	elseif action == CAST_REQUIEM_OF_SOULS   then castSpell(bot,"nevermore_requiem")
	elseif action == USE_SALVE               then useItemOnSelf(bot,"item_flask")
	end	

	print("Action " .. action .. " applied.")	
end

function moveOffset(bot, x, y)
	local bot = bot
	local location = bot:GetAbsOrigin()
	bot:MoveToPosition(Vector(location[1]+x, location[2]+y, location[3]))
end

function getRune(bot, rune)
	print("rune:", rune)
	if rune ~= nil then


		local bot = bot
		local location = rune:GetAbsOrigin()
		if CalcDistanceBetweenEntityOBB( bot, rune ) > 100 then
			bot:MoveToPosition(Vector(location[1], location[2], location[3]))
		else
			local runeEntity = Entities:FindByClassnameNearest("dota_item_rune", location, 100)
			bot:PickupRune(runeEntity)
		end
	end
end

function attackEnemyHero(bot)
	local bot = bot
	local opp = GetDireHeroes()
	if opp ~= nil then
		if CalcDistanceBetweenEntityOBB(bot, opp[1]) > bot:GetBaseAttackRange() then
			bot:MoveToNPC(opp[1])
		else
			bot:PerformAttack(opp[1], false, true, false, false, true, false, false)
		end
	end
end

function attackEnemyTower(bot)
	local bot = bot
	local tower = Entities:FindByName(nil, "dota_badguys_tower1_mid")
	if tower ~= nil then	
		if CalcDistanceBetweenEntityOBB(bot, tower) > bot:GetBaseAttackRange() then
			bot:MoveToNPC(tower)
		else
			bot:PerformAttack(tower, false, true, false, false, true, false, false)
		end
	end
end

function attackCreep(bot, index, enemy)
	local bot = bot
	local creeps = {unpack(GetNearbyLaneCreeps(bot:GetAbsOrigin(), 1599, DOTA_TEAM_BADGUYS), 1, 5)} 
	if GameRules:GetDOTATime(false,true) > 30.0 and table.getn(creeps) == 0 then
		moveOffset(bot, 100 ,  100) -- Move north
		return
	end
	if table.getn(creeps) >= index then
		if bot:GetAttackRangeBuffer() == 0 then
			bot:MoveToNPC(creeps[index])
		else
			--bot:PerformAttack(creeps[index], true, true, false, false, true, false, false)
			bot:MoveToTargetToAttack(creeps[index])
		end
	end
end

function castSpell(bot, spell)
	local bot = bot
	local ability = bot:FindAbilityByName(spell)
	bot:CastAbilityNoTarget(ability,0) -- CastAbilityNoTarget(handle ability, int playerIndex) 
end

function useItemOnSelf(bot, item)
	local bot = bot
	local ability = GetItem(bot, item)
	bot:CastAbilityOnTarget(bot, ability, 0) -- CastAbilityOnTarget(handle target, handle ability, int playerIndex) 
end 

function getFeatures(unit,addon)
	local sTime = Time()
	local features = {}
	local bot = unit
	local opp = GetDireHeroes()

	GetRadientHeroes()

	if table.getn(opp) > 0 then 
		opp = opp[1]
	else 
		opp = nil 
	end
	
	-- Self

	SetFeature(features, 0, bot:GetTeam(), '-0', 'team')
	SetFeature(features, 1, bot:GetLevel(), -1, 'level')
	SetFeature(features, 2, bot:GetHealth(), -2, 'health')
	SetFeature(features, 3, bot:GetMaxHealth(), -3, 'maxHealth')
	SetFeature(features, 4, bot:GetHealthRegen(), -4, 'healthRegen')
	SetFeature(features, 5, bot:GetMana(), -5, 'mana')
	SetFeature(features, 6, bot:GetMaxMana(), -6, 'maxMana')
	SetFeature(features, 7, bot:GetManaRegen(), -7, 'manaRegen')
	SetFeature(features, 8, bot:GetBaseMoveSpeed(), -8, 'baseMoveSpeed')
	SetFeature(features, 9, bot:GetVelocity():Length2D(), -9, 'CurrentMoveSpeed') -- ? Replacement for getCurrentMouvmentSpeed
	SetFeature(features, 10, (bot:GetBaseDamageMin() + bot:GetBaseDamageMax())/2, -10, 'avgDamage') -- ? Replacement for GetBaseDamage
	SetFeature(features, 11, GetBaseDamageVariance(bot), -11, 'damageVar') -- ! Need replacement for bot:GetBaseDamageVariance()
	SetFeature(features, 12, bot:GetAttackDamage(), -12, 'attackDamage')
	SetFeature(features, 13, bot:GetAttackRangeBuffer(), -13, 'attackRangeBuffer') -- ? Replacement for GetAttackRange()
	SetFeature(features, 14, bot:GetAttackSpeed(), -14, 'attackSpeed')
	SetFeature(features, 15, bot:GetSecondsPerAttack(), -15, 'secondsPerAttack')
	SetFeature(features, 16, bot:GetAttackAnimationPoint(), -16, 'attackAnimationPoint')
	SetFeature(features, 17, bot:GetLastAttackTime(), -17, 'attackTime')

	if bot:GetAttackTarget() == nil then
		SetFeature(features, 18, 0, -18, 'attackTarget')
	else
		SetFeature(features, 18, hashString(bot:GetAttackTarget():GetName()), -18, 'attackTarget')
	end
	SetFeature(features, 19, bot:GetStrength(), -19, 'strength') --? Replacement for bot:GetAttributeValue(ATTRIBUTE_STRENGTH)
	SetFeature(features, 20, bot:GetAgility(), -20, 'agility') -- ? Replacement for bot:GetAttributeValue(ATTRIBUTE_AGILITY)
	SetFeature(features, 21, bot:GetIntellect(), -21, 'intellect') -- ? Replacement for bot:GetAttributeValue(ATTRIBUTE_INTELLECT)
	SetFeature(features, 22, bot:GetGold(), -22, 'gold')
	SetFeature(features, 23, GetNetWorth(bot), -23, 'netWorth') -- ! Need replacement for bot:GetNetWorth(), likely iterate through inventory, summing item values + getGold()
	SetFeature(features, 24, bot:GetLastHits(), -24, 'lastHits')
	SetFeature(features, 25, bot:GetDenies(), -25, 'denies')
	SetFeature(features, 26, bot:GetAbsOrigin()[1], -26, 'location[1]') -- ? Replacement for bot:GetLocation()[1]
	SetFeature(features, 27, bot:GetAbsOrigin()[2], -27, 'location[2]') -- ? Replacement for bot:GetLocation()[2]
	SetFeature(features, 28, bot:GetAnglesAsVector()[1], -28, 'facing') -- ? Replacement for bot:GetFacing()
	SetFeature(features, 29, bot:GetCurrentVisionRange(), -29, 'visionRange')

	-- Opponent
	if opp ~= nil then
		SetFeature(features,30,opp:GetTeam(), -30, 'opp team')
		SetFeature(features,31,opp:GetLevel(), -31, 'opp level')
		SetFeature(features,32,opp:GetHealth(), -32, 'opp health')
		SetFeature(features,33,opp:GetMaxHealth(), -33, 'opp maxHealth')
		SetFeature(features,34,opp:GetHealthRegen(), -34, 'oppHealthRegen')
		SetFeature(features,35,opp:GetMana(), -35, 'oppMana')
		SetFeature(features,36,opp:GetMaxMana(), -36, 'oppMaxMana')
		SetFeature(features,37,opp:GetManaRegen(), -37, 'oppManaRegen')
		SetFeature(features,38,opp:GetBaseMoveSpeed(), -38, 'oppBaseMoveSpeed')
		SetFeature(features,39,opp:GetVelocity():Length2D(),-39,'oppCurrMoveSpeed') -- ? Replacement for getCurrentMouvmentSpeed
		SetFeature(features,40,(opp:GetBaseDamageMin() + opp:GetBaseDamageMax())/2,-40,'oppBaseDamage')
		SetFeature(features,41,GetBaseDamageVariance(opp), -41, 'oppBaseDamageVariance') -- ! Need replacement for opp:GetBaseDamageVariance()
		SetFeature(features,42,opp:GetAttackDamage(), -42, 'oppAttackDamage')
		SetFeature(features,43,opp:GetAttackRangeBuffer(),-43, 'oppAttackRangeBuffer') -- ? Replacement for GetAttackRange()
		SetFeature(features,44,opp:GetAttackSpeed(), -44, 'oppAttackSpeed')
		SetFeature(features,45,opp:GetSecondsPerAttack(), -45, 'oppSecondsPerAttack')
		SetFeature(features,46,opp:GetAttackAnimationPoint(), -46, 'oppAttackAnimationPoint')
		SetFeature(features,47, opp:GetLastAttackTime(), -47, 'oppLastAttackTime')
		if opp:GetAttackTarget() == nil then
			SetFeature(features,48,0,-48,'oppAttackTarget')
		else
			SetFeature(features,48, hashString(opp:GetAttackTarget():GetUnitName()), -48, 'oppAttackTarget')			
			print("features[48]")
			print(features[48])
		end
		SetFeature(features,49,opp:GetStrength(), -49, 'oppStrength')
		SetFeature(features,50,opp:GetAgility(), -50, 'oppAgility')
		SetFeature(features,51,opp:GetIntellect(), -51, 'oppIntellect')
		SetFeature(features,52,opp:GetAbsOrigin()[1], -52, 'oppLocation1')
		SetFeature(features,53,opp:GetAbsOrigin()[2], -53, 'oppLocation2')
		SetFeature(features,54,opp:GetAnglesAsVector()[1], -54, 'oppFacing') -- ? Replacement for bot:GetFacing()
		SetFeature(features,55, opp:GetCurrentVisionRange(), -55, 'oppVisionRange')
	else
		for i=30,55 do
			SetFeature(features,i,-i,-i,'auto-fill')
		end
	end
	
	-- Match
	SetFeature(features,56, GameRules:GetDOTATime(false, false), -56, 'DOTATime' ) -- param1 = includePregameTime param2 = includeNegativeTime

	-- Towers
	local tower = Entities:FindByName(nil, "dota_goodguys_tower1_mid") -- ? Replacement for GetTower(TEAM_RADIANT, TOWER_MID_1)

	if tower ~= nil then
		SetFeature(features, 57, tower:GetTeam(), -57, "tower team")
		SetFeature(features, 58, tower:GetHealth(), -58, "tower health")
		SetFeature(features, 59, tower:GetMaxHealth(), -59, "tower max health")
		SetFeature(features, 60, tower:GetAttackDamage(), -60, "tower attack damage")
		SetFeature(features, 61, tower:GetAttackRangeBuffer(), -61, "tower attack range buffer") -- ? Replacement for GetAttackRange()
		SetFeature(features, 62, tower:GetAttackSpeed(), -62, "tower attack speed")
	else
		SetFeature(features, 57,-57,-57, "tower team")
		SetFeature(features, 58, -58, -58, "tower health")
		SetFeature(features, 59, -59, -59, "tower max health")
		SetFeature(features, 60, -60, -60, "tower attack damage")
		SetFeature(features, 61, -61, -61, "tower attack range buffer") -- ? Replacement for GetAttackRange()
		SetFeature(features, 62, -62, -62, "tower attack speed")
	end

	tower = Entities:FindByName(nil, "dota_badguys_tower1_mid") -- ? Replacement for GetTower(TEAM_DIRE, TOWER_MID_1)

	if tower ~= nil then
		SetFeature(features, 63, tower:GetTeam(), -63, "tower team")
		SetFeature(features, 64, tower:GetHealth(), -64, "tower health")
		SetFeature(features, 65, tower:GetMaxHealth(), -65, "tower max health")
		SetFeature(features, 66, tower:GetAttackDamage(), -66, "tower attack damage")
		SetFeature(features, 67, tower:GetAttackRangeBuffer(), -67, "tower attack range buffer") -- ? Replacement for GetAttackRange()
		SetFeature(features, 68, tower:GetAttackSpeed(), -68, "tower attack speed")
	else
		SetFeature(features, 63, -63, -63, "tower team")
		SetFeature(features, 64, -64, -64, "tower health")
		SetFeature(features, 65, -65, -65, "tower max health")
		SetFeature(features, 66, -66, -66, "tower attack damage")
		SetFeature(features, 67, -67, -67, "tower attack range buffer") -- ? Replacement for GetAttackRange()
		SetFeature(features, 68, -68, -68, "tower attack speed")
	end

	-- Runes

	bountyRunes = Entities:FindAllByName('dota_item_rune_spawner_bounty')
	powerRunes = Entities:FindAllByName('dota_item_rune_spawner_powerup')

	print("bountyRunes size: " .. table.getn(bountyRunes))
	print("powerRunes size: " .. table.getn(powerRunes))

	local bounty1 = bountyRunes[1]
	local bounty2 = bountyRunes[2]
	local bounty3 = bountyRunes[3]
	local bounty4 = bountyRunes[4]
	local power1  = powerRunes[1]
	local power2  = powerRunes[2]


	SetFeature(features,69,bounty1[1],-69.0,'bounty1location1')
	SetFeature(features,70,bounty1[2],-70.0,'bounty1location2')
	SetFeature(features,71,bounty2[1],-71.0,'bounty2location1')
	SetFeature(features,72,bounty2[2],-72.0,'bounty2location2')
	SetFeature(features,73,bounty3[1],-73.0,'bounty3location1')
	SetFeature(features,74,bounty3[2],-74.0,'bounty3location2')
	SetFeature(features,75,bounty4[1],-75.0,'bounty4location1')
	SetFeature(features,76,bounty4[2],-76.0,'bounty4location2')
	SetFeature(features,77,power1[1],-77.0,'power1location1')
	SetFeature(features,78,power1[2],-78.0,'power1location2')
	SetFeature(features,79,power2[1],-79.0,'power2Location1')
	SetFeature(features,80,power2[2],-80.0,'power2Location2')

	--Compute Power Rune 1 Status
	print('power rune 1 status: ' .. GetRuneStatus(power1))
	print('power rune 2 status: ' .. GetRuneStatus(power2))

	if addon.powerRune1_674 ~= nil then
		print("powerRune1_674:".. addon.powerRune1_674)
	else
		print("powerRune1_674: nil")
	end

	if addon.powerRune2_678 ~= nil then
		print("powerRune2_678:".. addon.powerRune2_678)
	else
		print("powerRune2_678: nil")
	end

	if GetRuneStatus(power1) == 1 then
		-- If the rune is available, return its type
		SetFeature(features,81,addon.powerRune1_674,-81,'runePowerUp1Type') -- ! Need Replacement for GetRuneType(RUNE_POWERUP_1)
	else
		-- If the rune is unknown or missing (status = -1 or 0) return rune type -1.
		SetFeature(features,81,-1,-81,'runePowerUp1Type') -- ! Need Replacement for GetRuneType(RUNE_POWERUP_1)
	end

	SetFeature(features,82,GetRuneStatus(power1),-82,'runePowerUp1Status') -- ! Need Replacement for GetRuneStatus(RUNE_POWERUP_1)
	
	if GetRuneStatus(power2) == 1 then
		-- If the rune is available, return its type
		SetFeature(features,83,addon.powerRune2_678,-83,'runePowerUp2Type') -- ! Need Replacement for GetRuneType(RUNE_POWERUP_2)
	else
		-- If the rune is unknown or missing (status = -1 or 0) return rune type -1
		SetFeature(features,83,-1,-83,'runePowerUp2Type') -- ! Need Replacement for GetRuneType(RUNE_POWERUP_2)
	end

	SetFeature(features,84,GetRuneStatus(power2),-84,'runePowerUp2Status') -- ! Need Replacement for GetRuneStatus(RUNE_POWERUP_2)

	-- Five Nearest Friendly Creeps

	local n = 84

	local creeps = {unpack(GetNearbyLaneCreeps(bot:GetAbsOrigin(),1599, DOTA_TEAM_GOODGUYS ), 1, 5)}
	
	local nullCreeps = 0
	
	for k,v in pairs(creeps) do
		SetFeature(features, n+1, v:GetTeam(), -(n+1), 'creepTeam')
		SetFeature(features, n+2, v:GetHealth(), -(n+2), 'creepHealth')
		SetFeature(features, n+3, v:GetMaxHealth(), -(n+3), 'creepMaxHealth')
		SetFeature(features, n+4, v:GetHealthRegen(), -(n+4), 'creepHealthRegen')
		SetFeature(features, n+5, v:GetBaseMoveSpeed(), -(n+5), 'creepBaseMoveSpeed')
		SetFeature(features, n+6, v:GetVelocity():Length2D(), -(n+6), 'creepCurrentMoveSpeed')
		SetFeature(features, n+7, ((v:GetBaseDamageMin() + v:GetBaseDamageMax())/2), -(n+7), 'creepBaseDamage')
		SetFeature(features, n+8, GetBaseDamageVariance(v), -(n+8), 'creepDamageVariance')
		SetFeature(features, n+9, v:GetAttackDamage(), -(n+9), 'creepAttackDamage')
		SetFeature(features, n+10,v:GetAttackRangeBuffer(), -(n+10), 'creepAttackRangeBuffer')
		SetFeature(features, n+11,v:GetAttackSpeed(), -(n+11), 'creepAttackSpeed')
		SetFeature(features, n+12,v:GetSecondsPerAttack(), -(n+12), 'creepSecondsPerAttack')
		SetFeature(features, n+13,v:GetAbsOrigin()[1], -(n+13), 'creepLocation1')
		SetFeature(features, n+14,v:GetAbsOrigin()[2], -(n+14), 'creepLocation2')
		n = n + 14
	end
	
	local creepCount = table.getn(creeps)
	
	for i=n+1,n+((5-creepCount+nullCreeps)*14) do
		SetFeature(features,i,-1,-i,'autofill-creep-good')
	end
	
	n = n + ((5-creepCount+nullCreeps)*14)
	
	-- Five Nearest Enemy Creeps

	creeps = {unpack(GetNearbyLaneCreeps(bot:GetAbsOrigin(), 1599, DOTA_TEAM_BADGUYS ), 1, 5)}
	
	nullCreeps = 0
	
	for k,v in pairs(creeps) do
		SetFeature(features, n+1, v:GetTeam(), -(n+1), 'creepTeam')
		SetFeature(features, n+2, v:GetHealth(), -(n+2), 'creepHealth')
		SetFeature(features, n+3, v:GetMaxHealth(), -(n+3), 'creepMaxHealth')
		SetFeature(features, n+4, v:GetHealthRegen(), -(n+4), 'creepHealthRegen')
		SetFeature(features, n+5, v:GetBaseMoveSpeed(), -(n+5), 'creepBaseMoveSpeed')
		SetFeature(features, n+6, v:GetVelocity():Length2D(), -(n+6), 'creepCurrentMoveSpeed')
		SetFeature(features, n+7, ((v:GetBaseDamageMin() + v:GetBaseDamageMax())/2), -(n+7), 'creepBaseDamage')
		SetFeature(features, n+8, GetBaseDamageVariance(v), -(n+8), 'creepDamageVariance')
		SetFeature(features, n+9, v:GetAttackDamage(), -(n+9), 'creepAttackDamage')
		SetFeature(features, n+10,v:GetAttackRangeBuffer(), -(n+10), 'creepAttackRangeBuffer')
		SetFeature(features, n+11,v:GetAttackSpeed(), -(n+11), 'creepAttackSpeed')
		SetFeature(features, n+12,v:GetSecondsPerAttack(), -(n+12), 'creepSecondsPerAttack')
		SetFeature(features, n+13,v:GetAbsOrigin()[1], -(n+13), 'creepLocation1')
		SetFeature(features, n+14,v:GetAbsOrigin()[2], -(n+14), 'creepLocation2')
		n = n + 14
	end

	creepCount = table.getn(creeps)
	
	for i=n+1,n+((5-creepCount+nullCreeps)*14) do
		SetFeature(features,i,-1,-i,'autofill-creep-bad')
	end
	
	n = n + ((5-creepCount+nullCreeps)*14)
	
	-- Self Abilities (6)

	local ability = nil

	for i=0,5 do
		ability = bot:GetAbilityByIndex(i)
		SetFeature(features,n+1,ability:GetLevel(),-(n+1),'abilityLevel')
		SetFeature(features,n+2,ability:GetManaCost(ability:GetLevel()),-(n+2),'abilityManaCost') 
		SetFeature(features,n+3, ability:GetAbilityDamage(),-(n+3),'abilityDamage') 
		SetFeature(features,n+4,ability:GetCastRange(),-(n+4),'abilityCastRange') 
		SetFeature(features,n+5,ability:GetCooldownTimeRemaining(),-(n+5),'abilityCooldownTimeRemaining') 
		SetFeature(features,n+6,ability:GetAbilityTargetType(),-(n+6),'abilityTargetType') 
		SetFeature(features,n+7,bit.band(ability:GetBehavior(), DOTA_ABILITY_BEHAVIOR_AOE ),-(n+7),'abilityBehavior')  
		n = n + 7
	end

	-- Opponent Abilities (6)
	if opp ~= nil then
		for i=0,5 do
			ability = opp:GetAbilityByIndex(i)
			SetFeature(features,n+1,ability:GetLevel(),-(n+1),'abilityLevel')
			SetFeature(features,n+2,ability:GetManaCost(ability:GetLevel()),-(n+2),'abilityManaCost') 
			SetFeature(features,n+3, ability:GetAbilityDamage(),-(n+3),'abilityDamage') 
			SetFeature(features,n+4,ability:GetCastRange(),-(n+4),'abilityCastRange') 
			SetFeature(features,n+5,ability:GetCooldownTimeRemaining(),-(n+5),'abilityCooldownTimeRemaining') 
			SetFeature(features,n+6,ability:GetAbilityTargetType(),-(n+6),'abilityTargetType') 
			SetFeature(features,n+7,bit.band(ability:GetBehavior(), DOTA_ABILITY_BEHAVIOR_AOE ),-(n+7),'abilityBehavior') 
			n = n + 7
		end
	else
		for i=0,5 do
			for j=n,n+7 do
				SetFeature(features,j,-j,-j,'opponent ability autofill')
			end
			n = n + 7
		end
	end	
	
	-- Set Salve Status
	if bot:HasItemInInventory("item_flask") == true then
		SetFeature(features,n+1,1,-(n+1), 'itemFlask')
	else
		SetFeature(features,n+1,-1,-(n+1), 'itemFlask')
	end

	local eTime = Time()
	print("build feature vector time: " .. (eTime-sTime))
	
	return features
end

function hashString(inString)
	local hash = 7;
	
	for i=0,inString:len() do
		hash = hash * 31 + string.byte(inString:sub(i)) 
	end
	
	return hash
end
----------------------------------------------------------------------------------------------------
