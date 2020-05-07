function SetFeature(features, index, value, altValue, note)
    if value ~= nil then
        features[index] = value
    else 
        print('index:'..index..' value  was nil! Using alt value: '..altValue)
        print(note)
        features[index] = altValue
    end
end

function GetDireHeroes()
    local heroTable = HeroList:GetAllHeroes()
    local result = {}
    for key,value in pairs(heroTable) do
        local tempHero = value
        if tempHero:GetTeam() == DOTA_TEAM_BADGUYS then
            table.insert(result, tempHero)
        end
    end
    return result
end

function GetRadientHeroes()
    local heroTable = HeroList:GetAllHeroes()
    local result = {}
    for key,value in pairs(heroTable) do
        local tempHero = value
        if tempHero:GetTeam() == DOTA_TEAM_GOODGUYS then
            table.insert(result, tempHero)
        end
    end
    return result
end

-- origin = origin vector
function GetNearbyLaneCreeps(origin, radius, team)
    local result = {}
    local creeps = Entities:FindAllByClassnameWithin("npc_dota_creep_lane", origin, radius)

    for key,value in pairs(creeps) do

        local tempCreep = value

        if tempCreep:GetTeam() == team then
            table.insert(result, tempCreep)
        end

    end
    return result
end

function GetItem(bot, name)
    if bot:HasItemInInventory(name) == true then
        local index = 0
        while index < 6 do
            local tempItem = bot:GetItemInSlot(index)
            if(tempItem:GetAbilityName() == name) then
                return tempItem
            end
            index = index + 1
        end
    end
end

function FindItemSlot(bot, name) 
    if bot:HasItemInInventory(name) == true then
        local index = 0
        while index < 6 do
            local tempItem = bot:GetItemInSlot(index)
            if(tempItem:GetAbilityName() == name) then
                return index
            end
            index = index + 1
        end
    end
end

function GetPowerRune(index) 
    powerRunes = Entities:FindAllByName('dota_item_rune_spawner_powerup')
    return powerRunes[index]
end

function GetBountyRune(index)
    bountyRunes = Entities:FindAllByName('dota_item_rune_spawner_bounty')
	return bountyRunes[index]
end

function GetBaseDamageVariance(bot)

    local minDamage = bot:GetBaseDamageMin()
    local maxDamage = bot:GetBaseDamageMax()
    local avgDamage = (minDamage + maxDamage)/2

    local deltaMin = (minDamage - avgDamage)^2
    local deltaMax = (maxDamage - avgDamage)^2

    local variance = (deltaMin + deltaMax)/2

    return variance
end

function GetNetWorth(bot) 
    local sum = 0

    for i=0,11,1 do
        local currItem = bot:GetItemInSlot(i)

        if(currItem ~= nil) then
            sum = sum + currItem:GetCost()
        end
    end
    
    sum = sum + PlayerResource:GetGold(0)

    return sum

end

function GetRuneStatus(rune) 

    if IsLocationVisible(DOTA_TEAM_GOODGUYS, rune:GetAbsOrigin()) then

        local entityNearRuneSpawner = Entities:FindInSphere(nil, rune:GetAbsOrigin(), 100)
        if entityNearRuneSpawner ~= nil then
            print('Entity near rune')
            print(entityNearRuneSpawner:GetName() .. ' '.. entityNearRuneSpawner:GetClassname())
            if entityNearRuneSpawner:GetClassname() == 'dota_item_rune' then
                return 1
            end
            while entityNearRuneSpawner ~= nil do
                entityNearRuneSpawner = Entities:FindInSphere(entityNearRuneSpawner, rune:GetAbsOrigin(), 100)
                if entityNearRuneSpawner ~= nil then
                    print(entityNearRuneSpawner:GetName() .. ' '.. entityNearRuneSpawner:GetClassname())
                    if entityNearRuneSpawner:GetClassname() == 'dota_item_rune' then
                        return 1
                    end
                end
            end

            return 0
        end
    else
        return -1
    end

end

