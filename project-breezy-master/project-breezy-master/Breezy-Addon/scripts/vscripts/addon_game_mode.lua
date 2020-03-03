local oppBotAdded = 0



if GameMode == nil then
	GameMode = class({})
end

-- Generated from template

if CAddonTemplateGameMode == nil then
	CAddonTemplateGameMode = class({})
end

function Precache( context )
	--[[
		Precache things we know we'll use.  Possible file types include (but not limited to):
			PrecacheResource( "model", "*.vmdl", context )
			PrecacheResource( "soundfile", "*.vsndevts", context )
			PrecacheResource( "particle", "*.vpcf", context )
			PrecacheResource( "particle_folder", "particles/folder", context )
	]]
	require ("bots/bot_nevermore_script")
end

-- Create the game mode when we activate
function Activate()
	GameRules.AddonTemplate = CAddonTemplateGameMode()
	GameRules.AddonTemplate:InitGameMode()
end

function CAddonTemplateGameMode:InitGameMode()
	botSpawned = false

	print( "Template addon is loaded." )

	GameRules:GetGameModeEntity():SetThink( "OnThink", self, "GlobalThink", 2 )
	--GameRules:SetCustomGameSetupTimeout(0)
	GameRules:GetGameModeEntity():SetFreeCourierModeEnabled(true)
	GameRules:GetGameModeEntity():SetStashPurchasingDisabled(false)
	GameRules:SetCustomGameSetupRemainingTime(0)
	GameRules:EnableCustomGameSetupAutoLaunch(true)
	GameRules:SetPreGameTime(0)
	GameRules:SetShowcaseTime(0)
	GameRules:SetCustomGameSetupAutoLaunchDelay(0)
	GameRules:SetHeroSelectionTime(0)
	GameRules:SetSameHeroSelectionEnabled(true) -- Allow duplicate heroes
	GameRules:SetStrategyTime(0)

	GameRules:GetGameModeEntity():SetRuneSpawnFilter( Dynamic_Wrap( GameMode, "FilterRune" ), self )

	SendToServerConsole("r_always_render_all_windows 1")
	SendToServerConsole("engine_no_focus_sleep_vconsole_suppress 1")
	SendToServerConsole("r_vconsole_foregroundforcerender 1")
	
end

-- Evaluate the state of the game
function CAddonTemplateGameMode:OnThink()
	
	if GameRules:State_Get() == DOTA_GAMERULES_STATE_GAME_IN_PROGRESS then
		print( "Template addon script is running." )

		local hero = PlayerResource:GetPlayer(0):GetAssignedHero()
		local endingGame = false
		
		if botSpawned == false and PlayerResource:GetPlayer(0):GetAssignedHero() ~= nil then

			print("In botspawn")

			-- Generate pseudo-unique id
			gameId = GetSystemTime() .. tostring(math.random(9999))
			local requestBody = '{"gameId":"' .. gameId .. '","state":"start"}'
		
			print(gameId)
			print(requestBody)
		
			local runRequest = CreateHTTPRequest("POST", "http://localhost:8085/run/client")
			runRequest:SetHTTPRequestRawPostBody("application/json", requestBody)
			runRequest:Send(function(result)
				print("Run Id Sent!")
			end 
			)

			-- Remove top and bottom creep spawners
			local radientTopCreepSpawner = Entities:FindByClassname(nil, "npc_dota_spawner_good_top")
			radientTopCreepSpawner:RemoveSelf()

			local radientBottomCreepSpawner = Entities:FindByClassname(nil, "npc_dota_spawner_good_bot")
			radientBottomCreepSpawner:RemoveSelf()

			local direTopCreepSpawner = Entities:FindByClassname(nil, "npc_dota_spawner_bad_top")
			direTopCreepSpawner:RemoveSelf()

			local direBottomCreepSpawner = Entities:FindByClassname(nil, "npc_dota_spawner_bad_bot")
			direBottomCreepSpawner:RemoveSelf()

			--GameRules:GetGameModeEntity():SetRuneSpawnFilter(Dynamic_Wrap( GameMode, "FilterRune" ), self)

		

			GameRules:GetGameModeEntity():SetBotThinkingEnabled(true)
			print("Allegedly added bot!")
			print(oppBotAdded)
			if oppBotAdded then
				print('I really think i did')
			end

			botSpawned = true
			
			if hero == nil then
				hero = PlayerResource:GetPlayer(0):GetAssignedHero()
			end


			

			print("Hero name")
			print(PlayerResource:GetPlayer(0):GetAssignedHero():GetName())			
			
			print("hero -BOT", PlayerResource:GetPlayer(0):GetAssignedHero())

			SendToServerConsole("host_timescale 10")
			SendToServerConsole("+dota_camera_center_on_hero")

			
			
		end
		
		print("Passed botspawn")
		-- 1v1 Rules

		-- The first player to achieve two kills wins
		local radiantKills = GetTeamHeroKills(2)
		local direKills = GetTeamHeroKills(3)
		rKills = radiantKills
		dKills = direKills

		if radiantKills == 2 then
			GameRules:SetGameWinner(2)
			winner = "Radiant"
			endingGame = true
		end	

		if direKills == 2 then
			GameRules:SetGameWinner(3)
			winner = "Dire"
			endingGame = true
		end


		-- The first player to destroy an enemy tower wins
		local direTower = Entities:FindByName(nil, "dota_badguys_tower1_mid")
		local radientTower = Entities:FindByName(nil, "dota_goodguys_tower1_mid")

		print("Checking dire tower")
		if direTower == nil then
			GameRules:SetGameWinner(2) -- Radient wins
			winner = "Radient"
			endingGame = true
		end

		print("Checking radiant tower")
		if radientTower == nil then
			GameRules:SetGameWinner(3) -- Dire wins
			winner = "Dire"
			endingGame = true
		end

		-- Side towers are invulnerable
		local direTower1top = Entities:FindByName(nil, "dota_badguys_tower1_top")
		direTower1top:SetInvulnCount(1)

		local direTower1bot = Entities:FindByName(nil, "dota_badguys_tower1_bot")
		direTower1bot:SetInvulnCount(1)

		local radientTower1top = Entities:FindByName(nil,"dota_goodguys_tower1_top")
		radientTower1top:SetInvulnCount(1)

		local radientTower1bot = Entities:FindByName(nil,"dota_goodguys_tower1_bot")
		radientTower1bot:SetInvulnCount(1)

		if PlayerResource:GetPlayer(0):GetAssignedHero() ~= nil and endingGame == false then
			PlayerResource:GetPlayer(0):GetAssignedHero():SetContextThink("playDota", function()
				Think(PlayerResource:GetPlayer(0):GetAssignedHero(),gameId, self)
				return 0
			end, 0)
		end
		
	
		

	elseif GameRules:State_Get() == DOTA_GAMERULES_STATE_POST_GAME then
		local hero = PlayerResource:GetPlayer(0):GetAssignedHero()

		PlayerResource:GetPlayer(0):GetAssignedHero():SetContextThink("playDota", function()
			return
		end,0)

		print("preparing end game request")



		local endRequestBody = '{"gameId":"'.. gameId ..'", "state":"end", "winner":"'.. winner ..'", "direKills":"'.. tostring(dKills) .. '", "radiantKills":"'.. tostring(rKills) .. '", "deaths":"'.. tostring(PlayerResource:GetDeaths(0)) ..'" }'

		print(endRequestBody)

		local endRequest = CreateHTTPRequest("POST", "http://localhost:8085/run/client")
		endRequest:SetHTTPRequestRawPostBody("application/json", endRequestBody)
		endRequest:Send(function(result)
			print("End game notification sent!")
		end	
		)

		GameRules:ResetToCustomGameSetup()
		
		--return nil

		
	elseif GameRules:State_Get() == DOTA_GAMERULES_STATE_HERO_SELECTION then	
		print("In hero selection")
		oppBotAdded = Tutorial:AddBot("npc_dota_hero_nevermore", "mid", "hard", false)
		PlayerResource:GetPlayer(0):SetSelectedHero("npc_dota_hero_nevermore")
		--PlayerResource:GetPlayer(0):MakeRandomHeroSelection()
		GameRules:FinishCustomGameSetup() 

	elseif GameRules:State_Get() == DOTA_GAMERULES_STATE_CUSTOM_GAME_SETUP  then
		--print("in setup")

		local waitingToStartRequestBody = '{"state":"waiting"}'
		local waitingRequest = CreateHTTPRequest("POST", "http://localhost:8085/run/client")
		waitingRequest:SetHTTPRequestRawPostBody("application/json", waitingToStartRequestBody)
		waitingRequest:Send(function(result)
			local flag = tonumber(result["Body"])
			if flag == 1 then
				SendToServerConsole("restart")
			else
				print("still waiting to start")
			end
		end
		)

	end
	return 1
end
-- Inspired from https://github.com/tontyoutoure/DOTA2-AI-Fun/blob/master/game/dota_addons/dota2_ai_fun/scripts/vscripts/gamemode.lua
local bFirstRuneShouldSpawned = false
local bFirstRuneActuallySpawned = false

local tPossibleRunes = {
	DOTA_RUNE_DOUBLEDAMAGE,
	DOTA_RUNE_HASTE,
	DOTA_RUNE_ILLUSION,
	DOTA_RUNE_INVISIBILITY,
	DOTA_RUNE_REGENERATION,
	DOTA_RUNE_ARCANE
}

local tLastRunes = {}

function GameMode:FilterRune(tRuneFilter) 

	print("rune filter 4000")
	print(tRuneFilter)

	for key,value in pairs(tRuneFilter) do
		print(key .. "-" .. value)
	end

	if GameRules:GetGameTime() > 120 then

		-- This is power1 in the freature vector, and the top power up rune on the map
		print('spawner:' ..tRuneFilter.spawner_entindex_const..' '.. type(tRuneFilter.spawner_entindex_const))
		if tRuneFilter.spawner_entindex_const == 674 then
			tRuneFilter.rune_type = tPossibleRunes[RandomInt(1, 6)]
			self.powerRune1_674 = tRuneFilter.rune_type
			return true
		end

		-- This is power2 in the freature vector, and the bottom power up rune on the map
		if tRuneFilter.spawner_entindex_const == 678 then
			tRuneFilter.rune_type = tPossibleRunes[RandomInt(1, 6)]
			self.powerRune2_678 = tRuneFilter.rune_type
			return true
		end

		return true
	end
end