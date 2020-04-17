package ca.dal.tpg;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.jdbc.JDBCClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Store {

    private static final Logger log = LoggerFactory.getLogger(Store.class);
    private JsonObject jdbcConfig;
    private Vertx vertx;
    private JDBCClient client;

    public Store(Vertx vertx, JsonObject jdbcConfig){
        this.vertx = vertx;
        this.jdbcConfig = jdbcConfig;
        client = JDBCClient.createShared(vertx, jdbcConfig);
        createTables();
    }

    public void insertFeatures(Features f){
        client.rxGetConnection().subscribe(
                connection->{

                    String sql = "INSERT INTO FEATURES (" +
                            "ID," +
                            "TIMESTAMP," +
                            "GAME_ID," +
                            "TEAM," +
                            "LEVEL," +
                            "HEALTH," +
                            "MAX_HEALTH," +
                            "HEALTH_REGEN," +
                            "MANA," +
                            "MAX_MANA," +
                            "MANA_REGEN," +
                            "BASE_MOVE_SPEED," +
                            "CURRENT_MOVE_SPEED," +
                            "BASE_DAMAGE," +
                            "DAMAGE_VARIANCE," +
                            "ATTACK_DAMAGE," +
                            "ATTACK_RANGE_BUFFER," +
                            "ATTACK_SPEED," +
                            "SECONDS_PER_ATTACK," +
                            "ATTACK_ANIMATION_POINT," +
                            "LAST_ATTACK_TIME," +
                            "ATTACK_TARGET," +
                            "STRENGTH," +
                            "AGILITY," +
                            "INTELLECT," +
                            "GOLD," +
                            "NET_WORTH," +
                            "LAST_HITS," +
                            "DENIES," +
                            "LOCATION_1," +
                            "LOCATION_2," +
                            "FACING," +
                            "VISION_RANGE," +
                            "OPP_TEAM," +
                            "OPP_LEVEL," +
                            "OPP_HEALTH," +
                            "OPP_MAX_HEALTH," +
                            "OPP_HEALTH_REGEN," +
                            "OPP_MANA," +
                            "OPP_MAX_MANA," +
                            "OPP_MANA_REGEN," +
                            "OPP_BASE_MOVE_SPEED," +
                            "OPP_CURRENT_MOVE_SPEED," +
                            "OPP_BASE_DAMAGE," +
                            "OPP_DAMAGE_VARIANCE," +
                            "OPP_ATTACK_DAMAGE," +
                            "OPP_ATTACK_RANGE_BUFFER," +
                            "OPP_ATTACK_SPEED," +
                            "OPP_SECONDS_PER_ATTACK," +
                            "OPP_ATTACK_ANIMATION_POINT," +
                            "OPP_LAST_ATTACK_TIME," +
                            "OPP_ATTACK_TARGET," +
                            "OPP_STRENGTH," +
                            "OPP_AGILITY," +
                            "OPP_INTELLECT," +
                            "OPP_LOCATION_1," +
                            "OPP_LOCATION_2," +
                            "OPP_FACING," +
                            "OPP_VISION_RANGE," +
                            "DOTA_TIME," +
                            "GOOD_TOWER_TEAM," +
                            "GOOD_TOWER_HEALTH," +
                            "GOOD_TOWER_MAX_HEALTH," +
                            "GOOD_TOWER_ATTACK_DAMAGE," +
                            "GOOD_TOWER_ATTACK_RANGE_BUFFER," +
                            "GOOD_TOWER_ATTACK_SPEED," +
                            "BAD_TOWER_TEAM," +
                            "BAD_TOWER_HEALTH," +
                            "BAD_TOWER_MAX_HEALTH," +
                            "BAD_TOWER_ATTACK_DAMAGE," +
                            "BAD_TOWER_ATTACK_RANGE_BUFFER," +
                            "BAD_TOWER_ATTACK_SPEED," +
                            "BOUNTY_1_LOCATION_1," +
                            "BOUNTY_1_LOCATION_2," +
                            "BOUNTY_2_LOCATION_1," +
                            "BOUNTY_2_LOCATION_2," +
                            "BOUNTY_3_LOCATION_1," +
                            "BOUNTY_3_LOCATION_2," +
                            "BOUNTY_4_LOCATION_1," +
                            "BOUNTY_4_LOCATION_2," +
                            "POWER_1_LOCATION_1," +
                            "POWER_1_LOCATION_2," +
                            "POWER_2_LOCATION_1," +
                            "POWER_2_LOCATION_2," +
                            "POWER_1_TYPE," +
                            "POWER_1_STATUS," +
                            "POWER_2_TYPE," +
                            "POWER_2_STATUS," +
                            "GOOD_CREEP_1_TEAM," +
                            "GOOD_CREEP_1_HEALTH," +
                            "GOOD_CREEP_1_MAX_HEALTH," +
                            "GOOD_CREEP_1_HEALTH_REGEN," +
                            "GOOD_CREEP_1_BASE_MOVE_SPEED," +
                            "GOOD_CREEP_1_CURRENT_MOVE_SPEED," +
                            "GOOD_CREEP_1_BASE_DAMAGE," +
                            "GOOD_CREEP_1_DAMAGE_VARIANCE," +
                            "GOOD_CREEP_1_ATTACK_DAMAGE," +
                            "GOOD_CREEP_1_ATTACK_RANGE_BUFFER," +
                            "GOOD_CREEP_1_ATTACK_SPEED," +
                            "GOOD_CREEP_1_SECONDS_PER_ATTACK," +
                            "GOOD_CREEP_1_LOCATION_1," +
                            "GOOD_CREEP_1_LOCATION_2," +
                            "GOOD_CREEP_2_TEAM," +
                            "GOOD_CREEP_2_HEALTH," +
                            "GOOD_CREEP_2_MAX_HEALTH," +
                            "GOOD_CREEP_2_HEALTH_REGEN," +
                            "GOOD_CREEP_2_BASE_MOVE_SPEED," +
                            "GOOD_CREEP_2_CURRENT_MOVE_SPEED," +
                            "GOOD_CREEP_2_BASE_DAMAGE," +
                            "GOOD_CREEP_2_DAMAGE_VARIANCE," +
                            "GOOD_CREEP_2_ATTACK_DAMAGE," +
                            "GOOD_CREEP_2_ATTACK_RANGE_BUFFER," +
                            "GOOD_CREEP_2_ATTACK_SPEED," +
                            "GOOD_CREEP_2_SECONDS_PER_ATTACK," +
                            "GOOD_CREEP_2_LOCATION_1," +
                            "GOOD_CREEP_2_LOCATION_2," +
                            "GOOD_CREEP_3_TEAM," +
                            "GOOD_CREEP_3_HEALTH," +
                            "GOOD_CREEP_3_MAX_HEALTH," +
                            "GOOD_CREEP_3_HEALTH_REGEN," +
                            "GOOD_CREEP_3_BASE_MOVE_SPEED," +
                            "GOOD_CREEP_3_CURRENT_MOVE_SPEED," +
                            "GOOD_CREEP_3_BASE_DAMAGE," +
                            "GOOD_CREEP_3_DAMAGE_VARIANCE," +
                            "GOOD_CREEP_3_ATTACK_DAMAGE," +
                            "GOOD_CREEP_3_ATTACK_RANGE_BUFFER," +
                            "GOOD_CREEP_3_ATTACK_SPEED," +
                            "GOOD_CREEP_3_SECONDS_PER_ATTACK," +
                            "GOOD_CREEP_3_LOCATION_1," +
                            "GOOD_CREEP_3_LOCATION_2," +
                            "GOOD_CREEP_4_TEAM," +
                            "GOOD_CREEP_4_HEALTH," +
                            "GOOD_CREEP_4_MAX_HEALTH," +
                            "GOOD_CREEP_4_HEALTH_REGEN," +
                            "GOOD_CREEP_4_BASE_MOVE_SPEED," +
                            "GOOD_CREEP_4_CURRENT_MOVE_SPEED," +
                            "GOOD_CREEP_4_BASE_DAMAGE," +
                            "GOOD_CREEP_4_DAMAGE_VARIANCE," +
                            "GOOD_CREEP_4_ATTACK_DAMAGE," +
                            "GOOD_CREEP_4_ATTACK_RANGE_BUFFER," +
                            "GOOD_CREEP_4_ATTACK_SPEED," +
                            "GOOD_CREEP_4_SECONDS_PER_ATTACK," +
                            "GOOD_CREEP_4_LOCATION_1," +
                            "GOOD_CREEP_4_LOCATION_2," +
                            "GOOD_CREEP_5_TEAM," +
                            "GOOD_CREEP_5_HEALTH," +
                            "GOOD_CREEP_5_MAX_HEALTH," +
                            "GOOD_CREEP_5_HEALTH_REGEN," +
                            "GOOD_CREEP_5_BASE_MOVE_SPEED," +
                            "GOOD_CREEP_5_CURRENT_MOVE_SPEED," +
                            "GOOD_CREEP_5_BASE_DAMAGE," +
                            "GOOD_CREEP_5_DAMAGE_VARIANCE," +
                            "GOOD_CREEP_5_ATTACK_DAMAGE," +
                            "GOOD_CREEP_5_ATTACK_RANGE_BUFFER," +
                            "GOOD_CREEP_5_ATTACK_SPEED," +
                            "GOOD_CREEP_5_SECONDS_PER_ATTACK," +
                            "GOOD_CREEP_5_LOCATION_1," +
                            "GOOD_CREEP_5_LOCATION_2," +
                            "BAD_CREEP_1_TEAM," +
                            "BAD_CREEP_1_HEALTH," +
                            "BAD_CREEP_1_MAX_HEALTH," +
                            "BAD_CREEP_1_HEALTH_REGEN," +
                            "BAD_CREEP_1_BASE_MOVE_SPEED," +
                            "BAD_CREEP_1_CURRENT_MOVE_SPEED," +
                            "BAD_CREEP_1_BASE_DAMAGE," +
                            "BAD_CREEP_1_DAMAGE_VARIANCE," +
                            "BAD_CREEP_1_ATTACK_DAMAGE," +
                            "BAD_CREEP_1_ATTACK_RANGE_BUFFER," +
                            "BAD_CREEP_1_ATTACK_SPEED," +
                            "BAD_CREEP_1_SECONDS_PER_ATTACK," +
                            "BAD_CREEP_1_LOCATION_1," +
                            "BAD_CREEP_1_LOCATION_2," +
                            "BAD_CREEP_2_TEAM," +
                            "BAD_CREEP_2_HEALTH," +
                            "BAD_CREEP_2_MAX_HEALTH," +
                            "BAD_CREEP_2_HEALTH_REGEN," +
                            "BAD_CREEP_2_BASE_MOVE_SPEED," +
                            "BAD_CREEP_2_CURRENT_MOVE_SPEED," +
                            "BAD_CREEP_2_BASE_DAMAGE," +
                            "BAD_CREEP_2_DAMAGE_VARIANCE," +
                            "BAD_CREEP_2_ATTACK_DAMAGE," +
                            "BAD_CREEP_2_ATTACK_RANGE_BUFFER," +
                            "BAD_CREEP_2_ATTACK_SPEED," +
                            "BAD_CREEP_2_SECONDS_PER_ATTACK," +
                            "BAD_CREEP_2_LOCATION_1," +
                            "BAD_CREEP_2_LOCATION_2," +
                            "BAD_CREEP_3_TEAM," +
                            "BAD_CREEP_3_HEALTH," +
                            "BAD_CREEP_3_MAX_HEALTH," +
                            "BAD_CREEP_3_HEALTH_REGEN," +
                            "BAD_CREEP_3_BASE_MOVE_SPEED," +
                            "BAD_CREEP_3_CURRENT_MOVE_SPEED," +
                            "BAD_CREEP_3_BASE_DAMAGE," +
                            "BAD_CREEP_3_DAMAGE_VARIANCE," +
                            "BAD_CREEP_3_ATTACK_DAMAGE," +
                            "BAD_CREEP_3_ATTACK_RANGE_BUFFER," +
                            "BAD_CREEP_3_ATTACK_SPEED," +
                            "BAD_CREEP_3_SECONDS_PER_ATTACK," +
                            "BAD_CREEP_3_LOCATION_1," +
                            "BAD_CREEP_3_LOCATION_2," +
                            "BAD_CREEP_4_TEAM," +
                            "BAD_CREEP_4_HEALTH," +
                            "BAD_CREEP_4_MAX_HEALTH," +
                            "BAD_CREEP_4_HEALTH_REGEN," +
                            "BAD_CREEP_4_BASE_MOVE_SPEED," +
                            "BAD_CREEP_4_CURRENT_MOVE_SPEED," +
                            "BAD_CREEP_4_BASE_DAMAGE," +
                            "BAD_CREEP_4_DAMAGE_VARIANCE," +
                            "BAD_CREEP_4_ATTACK_DAMAGE," +
                            "BAD_CREEP_4_ATTACK_RANGE_BUFFER," +
                            "BAD_CREEP_4_ATTACK_SPEED," +
                            "BAD_CREEP_4_SECONDS_PER_ATTACK," +
                            "BAD_CREEP_4_LOCATION_1," +
                            "BAD_CREEP_4_LOCATION_2," +
                            "BAD_CREEP_5_TEAM," +
                            "BAD_CREEP_5_HEALTH," +
                            "BAD_CREEP_5_MAX_HEALTH," +
                            "BAD_CREEP_5_HEALTH_REGEN," +
                            "BAD_CREEP_5_BASE_MOVE_SPEED," +
                            "BAD_CREEP_5_CURRENT_MOVE_SPEED," +
                            "BAD_CREEP_5_BASE_DAMAGE," +
                            "BAD_CREEP_5_DAMAGE_VARIANCE," +
                            "BAD_CREEP_5_ATTACK_DAMAGE," +
                            "BAD_CREEP_5_ATTACK_RANGE_BUFFER," +
                            "BAD_CREEP_5_ATTACK_SPEED," +
                            "BAD_CREEP_5_SECONDS_PER_ATTACK," +
                            "BAD_CREEP_5_LOCATION_1," +
                            "BAD_CREEP_5_LOCATION_2," +
                            "ABILITY_1_LEVEL," +
                            "ABILITY_1_MANA_COST," +
                            "ABILITY_1_ABILITY_DAMAGE," +
                            "ABILITY_1_CAST_RANGE," +
                            "ABILITY_1_COOLDOWN_TIME_REMAINING," +
                            "ABILITY_1_TARGET_TYPE," +
                            "ABILITY_1_BEHAVIOR," +
                            "ABILITY_2_LEVEL," +
                            "ABILITY_2_MANA_COST," +
                            "ABILITY_2_ABILITY_DAMAGE," +
                            "ABILITY_2_CAST_RANGE," +
                            "ABILITY_2_COOLDOWN_TIME_REMAINING," +
                            "ABILITY_2_TARGET_TYPE," +
                            "ABILITY_2_BEHAVIOR," +
                            "ABILITY_3_LEVEL," +
                            "ABILITY_3_MANA_COST," +
                            "ABILITY_3_ABILITY_DAMAGE," +
                            "ABILITY_3_CAST_RANGE," +
                            "ABILITY_3_COOLDOWN_TIME_REMAINING," +
                            "ABILITY_3_TARGET_TYPE," +
                            "ABILITY_3_BEHAVIOR," +
                            "ABILITY_4_LEVEL," +
                            "ABILITY_4_MANA_COST," +
                            "ABILITY_4_ABILITY_DAMAGE," +
                            "ABILITY_4_CAST_RANGE," +
                            "ABILITY_4_COOLDOWN_TIME_REMAINING," +
                            "ABILITY_4_TARGET_TYPE," +
                            "ABILITY_4_BEHAVIOR," +
                            "ABILITY_5_LEVEL," +
                            "ABILITY_5_MANA_COST," +
                            "ABILITY_5_ABILITY_DAMAGE," +
                            "ABILITY_5_CAST_RANGE," +
                            "ABILITY_5_COOLDOWN_TIME_REMAINING," +
                            "ABILITY_5_TARGET_TYPE," +
                            "ABILITY_5_BEHAVIOR," +
                            "ABILITY_6_LEVEL," +
                            "ABILITY_6_MANA_COST," +
                            "ABILITY_6_ABILITY_DAMAGE," +
                            "ABILITY_6_CAST_RANGE," +
                            "ABILITY_6_COOLDOWN_TIME_REMAINING," +
                            "ABILITY_6_TARGET_TYPE," +
                            "ABILITY_6_BEHAVIOR," +
                            "OPP_ABILITY_1_LEVEL," +
                            "OPP_ABILITY_1_MANA_COST," +
                            "OPP_ABILITY_1_ABILITY_DAMAGE," +
                            "OPP_ABILITY_1_CAST_RANGE," +
                            "OPP_ABILITY_1_COOLDOWN_TIME_REMAINING," +
                            "OPP_ABILITY_1_TARGET_TYPE," +
                            "OPP_ABILITY_1_BEHAVIOR," +
                            "OPP_ABILITY_2_LEVEL," +
                            "OPP_ABILITY_2_MANA_COST," +
                            "OPP_ABILITY_2_ABILITY_DAMAGE," +
                            "OPP_ABILITY_2_CAST_RANGE," +
                            "OPP_ABILITY_2_COOLDOWN_TIME_REMAINING," +
                            "OPP_ABILITY_2_TARGET_TYPE," +
                            "OPP_ABILITY_2_BEHAVIOR," +
                            "OPP_ABILITY_3_LEVEL," +
                            "OPP_ABILITY_3_MANA_COST," +
                            "OPP_ABILITY_3_ABILITY_DAMAGE," +
                            "OPP_ABILITY_3_CAST_RANGE," +
                            "OPP_ABILITY_3_COOLDOWN_TIME_REMAINING," +
                            "OPP_ABILITY_3_TARGET_TYPE," +
                            "OPP_ABILITY_3_BEHAVIOR," +
                            "OPP_ABILITY_4_LEVEL," +
                            "OPP_ABILITY_4_MANA_COST," +
                            "OPP_ABILITY_4_ABILITY_DAMAGE," +
                            "OPP_ABILITY_4_CAST_RANGE," +
                            "OPP_ABILITY_4_COOLDOWN_TIME_REMAINING," +
                            "OPP_ABILITY_4_TARGET_TYPE," +
                            "OPP_ABILITY_4_BEHAVIOR," +
                            "OPP_ABILITY_5_LEVEL," +
                            "OPP_ABILITY_5_MANA_COST," +
                            "OPP_ABILITY_5_ABILITY_DAMAGE," +
                            "OPP_ABILITY_5_CAST_RANGE," +
                            "OPP_ABILITY_5_COOLDOWN_TIME_REMAINING," +
                            "OPP_ABILITY_5_TARGET_TYPE," +
                            "OPP_ABILITY_5_BEHAVIOR," +
                            "OPP_ABILITY_6_LEVEL," +
                            "OPP_ABILITY_6_MANA_COST," +
                            "OPP_ABILITY_6_ABILITY_DAMAGE," +
                            "OPP_ABILITY_6_CAST_RANGE," +
                            "OPP_ABILITY_6_COOLDOWN_TIME_REMAINING," +
                            "OPP_ABILITY_6_TARGET_TYPE," +
                            "OPP_ABILITY_6_BEHAVIOR," +
                            "ITEM_FLASK" +
                            ") VALUES (";

                    int counter = 0; //313 values
                    while(counter < 313){
                        if(counter == 312){
                            sql += "?";
                        }else{
                            sql +="?,";
                        }
                        counter++;
                    }

                    sql += ");";

                    JsonArray params = new JsonArray()
                            .add(f.getId().toString())
                            .add(f.getTimestamp().getTime())
                            .add(f.getGameId())
                            .add(f.getTeam())
                            .add(f.getLevel())
                            .add(f.getHealth())
                            .add(f.getMaxHealth())
                            .add(f.getHealthRegen())
                            .add(f.getMana())
                            .add(f.getMaxMana())
                            .add(f.getManaRegen())
                            .add(f.getBaseMoveSpeed())
                            .add(f.getCurrentMoveSpeed())
                            .add(f.getBaseDamage())
                            .add(f.getDamageVariance())
                            .add(f.getAttackDamage())
                            .add(f.getAttackRangeBuffer())
                            .add(f.getAttackSpeed())
                            .add(f.getSecondsPerAttack())
                            .add(f.getAttackAnimationPoint())
                            .add(f.getLastAttackTime())
                            .add(f.getAttackTarget())
                            .add(f.getStrength())
                            .add(f.getAgility())
                            .add(f.getIntellect())
                            .add(f.getGold())
                            .add(f.getNetWorth())
                            .add(f.getLastHits())
                            .add(f.getDenies())
                            .add(f.getLocation1())
                            .add(f.getLocation2())
                            .add(f.getFacing())
                            .add(f.getVisionRange())
                            .add(f.getOppTeam())
                            .add(f.getOppLevel())
                            .add(f.getOppHealth())
                            .add(f.getOppMaxHealth())
                            .add(f.getOppHealthRegen())
                            .add(f.getOppMana())
                            .add(f.getOppMaxMana())
                            .add(f.getOppManaRegen())
                            .add(f.getOppBaseMoveSpeed())
                            .add(f.getOppCurrentMoveSpeed())
                            .add(f.getOppBaseDamage())
                            .add(f.getOppDamageVariance())
                            .add(f.getOppAttackDamage())
                            .add(f.getOppAttackRangeBuffer())
                            .add(f.getOppAttackSpeed())
                            .add(f.getOppSecondsPerAttack())
                            .add(f.getOppAttackAnimationPoint())
                            .add(f.getOppLastAttackTime())
                            .add(f.getOppAttackTarget())
                            .add(f.getOppStrength())
                            .add(f.getOppAgility())
                            .add(f.getOppIntellect())
                            .add(f.getOppLocation1())
                            .add(f.getOppLocation2())
                            .add(f.getOppFacing())
                            .add(f.getOppVisionRange())
                            .add(f.getDotaTime())
                            .add(f.getGoodTowerTeam())
                            .add(f.getGoodTowerHealth())
                            .add(f.getGoodTowerMaxHealth())
                            .add(f.getGoodTowerAttackDamage())
                            .add(f.getGoodTowerAttackRangeBuffer())
                            .add(f.getGoodTowerAttackSpeed())
                            .add(f.getBadTowerTeam())
                            .add(f.getBadTowerHealth())
                            .add(f.getBadTowerMaxHealth())
                            .add(f.getBadTowerAttackDamage())
                            .add(f.getBadTowerAttackRangeBuffer())
                            .add(f.getBadTowerAttackSpeed())
                            .add(f.getBounty1Location1())
                            .add(f.getBounty1Location2())
                            .add(f.getBounty2Location1())
                            .add(f.getBounty2Location2())
                            .add(f.getBounty3Location1())
                            .add(f.getBounty3Location2())
                            .add(f.getBounty4Location1())
                            .add(f.getBounty4Location2())
                            .add(f.getPower1Location1())
                            .add(f.getPower1Location2())
                            .add(f.getPower2Location1())
                            .add(f.getPower2Location2())
                            .add(f.getPower1Type())
                            .add(f.getPower1Status())
                            .add(f.getPower2Type())
                            .add(f.getPower2Status())
                            .add(f.getGoodCreep1Team())
                            .add(f.getGoodCreep1Health())
                            .add(f.getGoodCreep1MaxHealth())
                            .add(f.getGoodCreep1HealthRegen())
                            .add(f.getGoodCreep1BaseMoveSpeed())
                            .add(f.getGoodCreep1CurrentMoveSpeed())
                            .add(f.getGoodCreep1BaseDamage())
                            .add(f.getGoodCreep1DamageVariance())
                            .add(f.getGoodCreep1AttackDamage())
                            .add(f.getGoodCreep1AttackRangeBuffer())
                            .add(f.getGoodCreep1AttackSpeed())
                            .add(f.getGoodCreep1SecondsPerAttack())
                            .add(f.getGoodCreep1Location1())
                            .add(f.getGoodCreep1Location2())
                            .add(f.getGoodCreep2Team())
                            .add(f.getGoodCreep2Health())
                            .add(f.getGoodCreep2MaxHealth())
                            .add(f.getGoodCreep2HealthRegen())
                            .add(f.getGoodCreep2BaseMoveSpeed())
                            .add(f.getGoodCreep2CurrentMoveSpeed())
                            .add(f.getGoodCreep2BaseDamage())
                            .add(f.getGoodCreep2DamageVariance())
                            .add(f.getGoodCreep2AttackDamage())
                            .add(f.getGoodCreep2AttackRangeBuffer())
                            .add(f.getGoodCreep2AttackSpeed())
                            .add(f.getGoodCreep2SecondsPerAttack())
                            .add(f.getGoodCreep2Location1())
                            .add(f.getGoodCreep2Location2())
                            .add(f.getGoodCreep3Team())
                            .add(f.getGoodCreep3Health())
                            .add(f.getGoodCreep3MaxHealth())
                            .add(f.getGoodCreep3HealthRegen())
                            .add(f.getGoodCreep3BaseMoveSpeed())
                            .add(f.getGoodCreep3CurrentMoveSpeed())
                            .add(f.getGoodCreep3BaseDamage())
                            .add(f.getGoodCreep3DamageVariance())
                            .add(f.getGoodCreep3AttackDamage())
                            .add(f.getGoodCreep3AttackRangeBuffer())
                            .add(f.getGoodCreep3AttackSpeed())
                            .add(f.getGoodCreep3SecondsPerAttack())
                            .add(f.getGoodCreep3Location1())
                            .add(f.getGoodCreep3Location2())
                            .add(f.getGoodCreep4Team())
                            .add(f.getGoodCreep4Health())
                            .add(f.getGoodCreep4MaxHealth())
                            .add(f.getGoodCreep4HealthRegen())
                            .add(f.getGoodCreep4BaseMoveSpeed())
                            .add(f.getGoodCreep4CurrentMoveSpeed())
                            .add(f.getGoodCreep4BaseDamage())
                            .add(f.getGoodCreep4DamageVariance())
                            .add(f.getGoodCreep4AttackDamage())
                            .add(f.getGoodCreep4AttackRangeBuffer())
                            .add(f.getGoodCreep4AttackSpeed())
                            .add(f.getGoodCreep4SecondsPerAttack())
                            .add(f.getGoodCreep4Location1())
                            .add(f.getGoodCreep4Location2())
                            .add(f.getGoodCreep5Team())
                            .add(f.getGoodCreep5Health())
                            .add(f.getGoodCreep5MaxHealth())
                            .add(f.getGoodCreep5HealthRegen())
                            .add(f.getGoodCreep5BaseMoveSpeed())
                            .add(f.getGoodCreep5CurrentMoveSpeed())
                            .add(f.getGoodCreep5BaseDamage())
                            .add(f.getGoodCreep5DamageVariance())
                            .add(f.getGoodCreep5AttackDamage())
                            .add(f.getGoodCreep5AttackRangeBuffer())
                            .add(f.getGoodCreep5AttackSpeed())
                            .add(f.getGoodCreep5SecondsPerAttack())
                            .add(f.getGoodCreep5Location1())
                            .add(f.getGoodCreep5Location2())
                            .add(f.getBadCreep1Team())
                            .add(f.getBadCreep1Health())
                            .add(f.getBadCreep1MaxHealth())
                            .add(f.getBadCreep1HealthRegen())
                            .add(f.getBadCreep1BaseMoveSpeed())
                            .add(f.getBadCreep1CurrentMoveSpeed())
                            .add(f.getBadCreep1BaseDamage())
                            .add(f.getBadCreep1DamageVariance())
                            .add(f.getBadCreep1AttackDamage())
                            .add(f.getBadCreep1AttackRangeBuffer())
                            .add(f.getBadCreep1AttackSpeed())
                            .add(f.getBadCreep1SecondsPerAttack())
                            .add(f.getBadCreep1Location1())
                            .add(f.getBadCreep1Location2())
                            .add(f.getBadCreep2Team())
                            .add(f.getBadCreep2Health())
                            .add(f.getBadCreep2MaxHealth())
                            .add(f.getBadCreep2HealthRegen())
                            .add(f.getBadCreep2BaseMoveSpeed())
                            .add(f.getBadCreep2CurrentMoveSpeed())
                            .add(f.getBadCreep2BaseDamage())
                            .add(f.getBadCreep2DamageVariance())
                            .add(f.getBadCreep2AttackDamage())
                            .add(f.getBadCreep2AttackRangeBuffer())
                            .add(f.getBadCreep2AttackSpeed())
                            .add(f.getBadCreep2SecondsPerAttack())
                            .add(f.getBadCreep2Location1())
                            .add(f.getBadCreep2Location2())
                            .add(f.getBadCreep3Team())
                            .add(f.getBadCreep3Health())
                            .add(f.getBadCreep3MaxHealth())
                            .add(f.getBadCreep3HealthRegen())
                            .add(f.getBadCreep3BaseMoveSpeed())
                            .add(f.getBadCreep3CurrentMoveSpeed())
                            .add(f.getBadCreep3BaseDamage())
                            .add(f.getBadCreep3DamageVariance())
                            .add(f.getBadCreep3AttackDamage())
                            .add(f.getBadCreep3AttackRangeBuffer())
                            .add(f.getBadCreep3AttackSpeed())
                            .add(f.getBadCreep3SecondsPerAttack())
                            .add(f.getBadCreep3Location1())
                            .add(f.getBadCreep3Location2())
                            .add(f.getBadCreep4Team())
                            .add(f.getBadCreep4Health())
                            .add(f.getBadCreep4MaxHealth())
                            .add(f.getBadCreep4HealthRegen())
                            .add(f.getBadCreep4BaseMoveSpeed())
                            .add(f.getBadCreep4CurrentMoveSpeed())
                            .add(f.getBadCreep4BaseDamage())
                            .add(f.getBadCreep4DamageVariance())
                            .add(f.getBadCreep4AttackDamage())
                            .add(f.getBadCreep4AttackRangeBuffer())
                            .add(f.getBadCreep4AttackSpeed())
                            .add(f.getBadCreep4SecondsPerAttack())
                            .add(f.getBadCreep4Location1())
                            .add(f.getBadCreep4Location2())
                            .add(f.getBadCreep5Team())
                            .add(f.getBadCreep5Health())
                            .add(f.getBadCreep5MaxHealth())
                            .add(f.getBadCreep5HealthRegen())
                            .add(f.getBadCreep5BaseMoveSpeed())
                            .add(f.getBadCreep5CurrentMoveSpeed())
                            .add(f.getBadCreep5BaseDamage())
                            .add(f.getBadCreep5DamageVariance())
                            .add(f.getBadCreep5AttackDamage())
                            .add(f.getBadCreep5AttackRangeBuffer())
                            .add(f.getBadCreep5AttackSpeed())
                            .add(f.getBadCreep5SecondsPerAttack())
                            .add(f.getBadCreep5Location1())
                            .add(f.getBadCreep5Location2())
                            .add(f.getAbility1Level())
                            .add(f.getAbility1ManaCost())
                            .add(f.getAbility1AbilityDamage())
                            .add(f.getAbility1CastRange())
                            .add(f.getAbility1CooldownTimeRemaining())
                            .add(f.getAbility1TargetType())
                            .add(f.getAbility1Behavior())
                            .add(f.getAbility2Level())
                            .add(f.getAbility2ManaCost())
                            .add(f.getAbility2AbilityDamage())
                            .add(f.getAbility2CastRange())
                            .add(f.getAbility2CooldownTimeRemaining())
                            .add(f.getAbility2TargetType())
                            .add(f.getAbility2Behavior())
                            .add(f.getAbility3Level())
                            .add(f.getAbility3ManaCost())
                            .add(f.getAbility3AbilityDamage())
                            .add(f.getAbility3CastRange())
                            .add(f.getAbility3CooldownTimeRemaining())
                            .add(f.getAbility3TargetType())
                            .add(f.getAbility3Behavior())
                            .add(f.getAbility4Level())
                            .add(f.getAbility4ManaCost())
                            .add(f.getAbility4AbilityDamage())
                            .add(f.getAbility4CastRange())
                            .add(f.getAbility4CooldownTimeRemaining())
                            .add(f.getAbility4TargetType())
                            .add(f.getAbility4Behavior())
                            .add(f.getAbility5Level())
                            .add(f.getAbility5ManaCost())
                            .add(f.getAbility5AbilityDamage())
                            .add(f.getAbility5CastRange())
                            .add(f.getAbility5CooldownTimeRemaining())
                            .add(f.getAbility5TargetType())
                            .add(f.getAbility5Behavior())
                            .add(f.getAbility6Level())
                            .add(f.getAbility6ManaCost())
                            .add(f.getAbility6AbilityDamage())
                            .add(f.getAbility6CastRange())
                            .add(f.getAbility6CooldownTimeRemaining())
                            .add(f.getAbility6TargetType())
                            .add(f.getAbility6Behavior())
                            .add(f.getOppAbility1Level())
                            .add(f.getOppAbility1ManaCost())
                            .add(f.getOppAbility1AbilityDamage())
                            .add(f.getOppAbility1CastRange())
                            .add(f.getOppAbility1CooldownTimeRemaining())
                            .add(f.getOppAbility1TargetType())
                            .add(f.getOppAbility1Behavior())
                            .add(f.getOppAbility2Level())
                            .add(f.getOppAbility2ManaCost())
                            .add(f.getOppAbility2AbilityDamage())
                            .add(f.getOppAbility2CastRange())
                            .add(f.getOppAbility2CooldownTimeRemaining())
                            .add(f.getOppAbility2TargetType())
                            .add(f.getOppAbility2Behavior())
                            .add(f.getOppAbility3Level())
                            .add(f.getOppAbility3ManaCost())
                            .add(f.getOppAbility3AbilityDamage())
                            .add(f.getOppAbility3CastRange())
                            .add(f.getOppAbility3CooldownTimeRemaining())
                            .add(f.getOppAbility3TargetType())
                            .add(f.getOppAbility3Behavior())
                            .add(f.getOppAbility4Level())
                            .add(f.getOppAbility4ManaCost())
                            .add(f.getOppAbility4AbilityDamage())
                            .add(f.getOppAbility4CastRange())
                            .add(f.getOppAbility4CooldownTimeRemaining())
                            .add(f.getOppAbility4TargetType())
                            .add(f.getOppAbility4Behavior())
                            .add(f.getOppAbility5Level())
                            .add(f.getOppAbility5ManaCost())
                            .add(f.getOppAbility5AbilityDamage())
                            .add(f.getOppAbility5CastRange())
                            .add(f.getOppAbility5CooldownTimeRemaining())
                            .add(f.getOppAbility5TargetType())
                            .add(f.getOppAbility5Behavior())
                            .add(f.getOppAbility6Level())
                            .add(f.getOppAbility6ManaCost())
                            .add(f.getOppAbility6AbilityDamage())
                            .add(f.getOppAbility6CastRange())
                            .add(f.getOppAbility6CooldownTimeRemaining())
                            .add(f.getOppAbility6TargetType())
                            .add(f.getOppAbility6Behavior())
                            .add(f.getItemFlask());

                    log.info("params length: {}", params.size());

                    connection.rxUpdateWithParams(sql,params).doAfterTerminate(connection::close).subscribe(
                            success->{
                                log.info("Inserted new features into database!");
                            },
                            err->{
                                log.error("Error inserting new features into database!");
                                log.error(err.getMessage());
                                err.printStackTrace();
                            }
                    );


                },
                this::connectionError
        );
    }

    private void createTables(){

        client.rxGetConnection().subscribe(
                connection->{

                    String sql = "CREATE TABLE IF NOT EXISTS FEATURES (" +
                            "ID TEXT PRIMARY KEY NOT NULL," +
                            "GAME_ID TEXT NOT NULL," +
                            "TIMESTAMP INTEGER NOT NULL," +
                            "TEAM INTEGER NOT NULL," +
                            "LEVEL INTEGER NOT NULL," +
                            "HEALTH INTEGER NOT NULL," +
                            "MAX_HEALTH INTEGER NOT NULL," +
                            "HEALTH_REGEN REAL NOT NULL," +
                            "MANA INTEGER NOT NULL," +
                            "MAX_MANA INTEGER NOT NULL," +
                            "MANA_REGEN REAL NOT NULL," +
                            "BASE_MOVE_SPEED INTEGER NOT NULL," +
                            "CURRENT_MOVE_SPEED INTEGER NOT NULL," +
                            "BASE_DAMAGE INTEGER NOT NULL," +
                            "DAMAGE_VARIANCE INTEGER NOT NULL," +
                            "ATTACK_DAMAGE INTEGER NOT NULL," +
                            "ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "ATTACK_SPEED REAL NOT NULL," +
                            "SECONDS_PER_ATTACK REAL NOT NULL," +
                            "ATTACK_ANIMATION_POINT REAL NOT NULL," +
                            "LAST_ATTACK_TIME REAL NOT NULL, " +
                            "ATTACK_TARGET REAL NOT NULL," +
                            "STRENGTH REAL NOT NULL," +
                            "AGILITY REAL NOT NULL," +
                            "INTELLECT REAL NOT NULL," +
                            "GOLD INTEGER NOT NULL," +
                            "NET_WORTH INTEGER NOT NULL," +
                            "LAST_HITS INTEGER NOT NULL," +
                            "DENIES INTEGER NOT NULL," +
                            "LOCATION_1 REAL NOT NULL," +
                            "LOCATION_2 REAL NOT NULL," +
                            "FACING REAL NOT NULL," +
                            "VISION_RANGE INTEGER NOT NULL," +
                            "OPP_TEAM INTEGER NOT NULL," +
                            "OPP_LEVEL INTEGER NOT NULL," +
                            "OPP_HEALTH INTEGER NOT NULL," +
                            "OPP_MAX_HEALTH INTEGER NOT NULL," +
                            "OPP_HEALTH_REGEN REAL NOT NULL," +
                            "OPP_MANA INTEGER NOT NULL," +
                            "OPP_MAX_MANA INTEGER NOT NULL," +
                            "OPP_MANA_REGEN REAL NOT NULL," +
                            "OPP_BASE_MOVE_SPEED REAL NOT NULL," +
                            "OPP_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "OPP_BASE_DAMAGE REAL NOT NULL," +
                            "OPP_DAMAGE_VARIANCE REAL NOT NULL," +
                            "OPP_ATTACK_DAMAGE REAL NOT NULL," +
                            "OPP_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "OPP_ATTACK_SPEED REAL NOT NULL," +
                            "OPP_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "OPP_ATTACK_ANIMATION_POINT REAL NOT NULL," +
                            "OPP_LAST_ATTACK_TIME REAL NOT NULL," +
                            "OPP_ATTACK_TARGET REAL NOT NULL," +
                            "OPP_STRENGTH REAL NOT NULL," +
                            "OPP_AGILITY REAL NOT NULL," +
                            "OPP_INTELLECT REAL NOT NULL," +
                            "OPP_LOCATION_1 REAL NOT NULL," +
                            "OPP_LOCATION_2 REAL NOT NULL," +
                            "OPP_FACING REAL NOT NULL," +
                            "OPP_VISION_RANGE REAL NOT NULL," +
                            "DOTA_TIME REAL NOT NULL," +
                            "GOOD_TOWER_TEAM INTEGER NOT NULL," +
                            "GOOD_TOWER_HEALTH REAL NOT NULL," +
                            "GOOD_TOWER_MAX_HEALTH REAL NOT NULL," +
                            "GOOD_TOWER_ATTACK_DAMAGE REAL NOT NULL," +
                            "GOOD_TOWER_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "GOOD_TOWER_ATTACK_SPEED REAL NOT NULL," +
                            "BAD_TOWER_TEAM INTEGER NOT NULL," +
                            "BAD_TOWER_HEALTH REAL NOT NULL," +
                            "BAD_TOWER_MAX_HEALTH REAL NOT NULL," +
                            "BAD_TOWER_ATTACK_DAMAGE REAL NOT NULL," +
                            "BAD_TOWER_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "BAD_TOWER_ATTACK_SPEED REAL NOT NULL," +
                            "BOUNTY_1_LOCATION_1 REAL NOT NULL," +
                            "BOUNTY_1_LOCATION_2 REAL NOT NULL," +
                            "BOUNTY_2_LOCATION_1 REAL NOT NULL," +
                            "BOUNTY_2_LOCATION_2 REAL NOT NULL," +
                            "BOUNTY_3_LOCATION_1 REAL NOT NULL," +
                            "BOUNTY_3_LOCATION_2 REAL NOT NULL," +
                            "BOUNTY_4_LOCATION_1 REAL NOT NULL," +
                            "BOUNTY_4_LOCATION_2 REAL NOT NULL," +
                            "POWER_1_LOCATION_1 REAL NOT NULL," +
                            "POWER_1_LOCATION_2 REAL NOT NULL," +
                            "POWER_2_LOCATION_1 REAL NOT NULL," +
                            "POWER_2_LOCATION_2 REAL NOT NULL," +
                            "POWER_1_TYPE INTEGER NOT NULL," +
                            "POWER_1_STATUS INTEGER NOT NULL," +
                            "POWER_2_TYPE INTEGER NOT NULL," +
                            "POWER_2_STATUS INTEGER NOT NULL," +
                            "GOOD_CREEP_1_TEAM INTEGER NOT NULL," +
                            "GOOD_CREEP_1_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_1_MAX_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_1_HEALTH_REGEN REAL NOT NULL," +
                            "GOOD_CREEP_1_BASE_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_1_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_1_BASE_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_1_DAMAGE_VARIANCE REAL NOT NULL," +
                            "GOOD_CREEP_1_ATTACK_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_1_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "GOOD_CREEP_1_ATTACK_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_1_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "GOOD_CREEP_1_LOCATION_1 REAL NOT NULL," +
                            "GOOD_CREEP_1_LOCATION_2 REAL NOT NULL," +
                            "GOOD_CREEP_2_TEAM INTEGER NOT NULL," +
                            "GOOD_CREEP_2_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_2_MAX_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_2_HEALTH_REGEN REAL NOT NULL," +
                            "GOOD_CREEP_2_BASE_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_2_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_2_BASE_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_2_DAMAGE_VARIANCE REAL NOT NULL," +
                            "GOOD_CREEP_2_ATTACK_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_2_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "GOOD_CREEP_2_ATTACK_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_2_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "GOOD_CREEP_2_LOCATION_1 REAL NOT NULL," +
                            "GOOD_CREEP_2_LOCATION_2 REAL NOT NULL," +
                            "GOOD_CREEP_3_TEAM INTEGER NOT NULL," +
                            "GOOD_CREEP_3_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_3_MAX_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_3_HEALTH_REGEN REAL NOT NULL," +
                            "GOOD_CREEP_3_BASE_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_3_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_3_BASE_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_3_DAMAGE_VARIANCE REAL NOT NULL," +
                            "GOOD_CREEP_3_ATTACK_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_3_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "GOOD_CREEP_3_ATTACK_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_3_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "GOOD_CREEP_3_LOCATION_1 REAL NOT NULL," +
                            "GOOD_CREEP_3_LOCATION_2 REAL NOT NULL," +
                            "GOOD_CREEP_4_TEAM INTEGER NOT NULL," +
                            "GOOD_CREEP_4_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_4_MAX_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_4_HEALTH_REGEN REAL NOT NULL," +
                            "GOOD_CREEP_4_BASE_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_4_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_4_BASE_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_4_DAMAGE_VARIANCE REAL NOT NULL," +
                            "GOOD_CREEP_4_ATTACK_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_4_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "GOOD_CREEP_4_ATTACK_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_4_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "GOOD_CREEP_4_LOCATION_1 REAL NOT NULL," +
                            "GOOD_CREEP_4_LOCATION_2 REAL NOT NULL," +
                            "GOOD_CREEP_5_TEAM INTEGER NOT NULL," +
                            "GOOD_CREEP_5_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_5_MAX_HEALTH REAL NOT NULL," +
                            "GOOD_CREEP_5_HEALTH_REGEN REAL NOT NULL," +
                            "GOOD_CREEP_5_BASE_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_5_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_5_BASE_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_5_DAMAGE_VARIANCE REAL NOT NULL," +
                            "GOOD_CREEP_5_ATTACK_DAMAGE REAL NOT NULL," +
                            "GOOD_CREEP_5_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "GOOD_CREEP_5_ATTACK_SPEED REAL NOT NULL," +
                            "GOOD_CREEP_5_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "GOOD_CREEP_5_LOCATION_1 REAL NOT NULL," +
                            "GOOD_CREEP_5_LOCATION_2 REAL NOT NULL," +
                            "BAD_CREEP_1_TEAM INTEGER NOT NULL," +
                            "BAD_CREEP_1_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_1_MAX_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_1_HEALTH_REGEN REAL NOT NULL," +
                            "BAD_CREEP_1_BASE_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_1_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_1_BASE_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_1_DAMAGE_VARIANCE REAL NOT NULL," +
                            "BAD_CREEP_1_ATTACK_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_1_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "BAD_CREEP_1_ATTACK_SPEED REAL NOT NULL," +
                            "BAD_CREEP_1_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "BAD_CREEP_1_LOCATION_1 REAL NOT NULL," +
                            "BAD_CREEP_1_LOCATION_2 REAL NOT NULL," +
                            "BAD_CREEP_2_TEAM INTEGER NOT NULL," +
                            "BAD_CREEP_2_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_2_MAX_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_2_HEALTH_REGEN REAL NOT NULL," +
                            "BAD_CREEP_2_BASE_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_2_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_2_BASE_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_2_DAMAGE_VARIANCE REAL NOT NULL," +
                            "BAD_CREEP_2_ATTACK_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_2_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "BAD_CREEP_2_ATTACK_SPEED REAL NOT NULL," +
                            "BAD_CREEP_2_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "BAD_CREEP_2_LOCATION_1 REAL NOT NULL," +
                            "BAD_CREEP_2_LOCATION_2 REAL NOT NULL," +
                            "BAD_CREEP_3_TEAM INTEGER NOT NULL," +
                            "BAD_CREEP_3_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_3_MAX_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_3_HEALTH_REGEN REAL NOT NULL," +
                            "BAD_CREEP_3_BASE_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_3_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_3_BASE_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_3_DAMAGE_VARIANCE REAL NOT NULL," +
                            "BAD_CREEP_3_ATTACK_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_3_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "BAD_CREEP_3_ATTACK_SPEED REAL NOT NULL," +
                            "BAD_CREEP_3_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "BAD_CREEP_3_LOCATION_1 REAL NOT NULL," +
                            "BAD_CREEP_3_LOCATION_2 REAL NOT NULL," +
                            "BAD_CREEP_4_TEAM INTEGER NOT NULL," +
                            "BAD_CREEP_4_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_4_MAX_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_4_HEALTH_REGEN REAL NOT NULL," +
                            "BAD_CREEP_4_BASE_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_4_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_4_BASE_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_4_DAMAGE_VARIANCE REAL NOT NULL," +
                            "BAD_CREEP_4_ATTACK_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_4_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "BAD_CREEP_4_ATTACK_SPEED REAL NOT NULL," +
                            "BAD_CREEP_4_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "BAD_CREEP_4_LOCATION_1 REAL NOT NULL," +
                            "BAD_CREEP_4_LOCATION_2 REAL NOT NULL," +
                            "BAD_CREEP_5_TEAM INTEGER NOT NULL," +
                            "BAD_CREEP_5_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_5_MAX_HEALTH REAL NOT NULL," +
                            "BAD_CREEP_5_HEALTH_REGEN REAL NOT NULL," +
                            "BAD_CREEP_5_BASE_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_5_CURRENT_MOVE_SPEED REAL NOT NULL," +
                            "BAD_CREEP_5_BASE_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_5_DAMAGE_VARIANCE REAL NOT NULL," +
                            "BAD_CREEP_5_ATTACK_DAMAGE REAL NOT NULL," +
                            "BAD_CREEP_5_ATTACK_RANGE_BUFFER REAL NOT NULL," +
                            "BAD_CREEP_5_ATTACK_SPEED REAL NOT NULL," +
                            "BAD_CREEP_5_SECONDS_PER_ATTACK REAL NOT NULL," +
                            "BAD_CREEP_5_LOCATION_1 REAL NOT NULL," +
                            "BAD_CREEP_5_LOCATION_2 REAL NOT NULL," +
                            "ABILITY_1_LEVEL INTEGER NOT NULL," +
                            "ABILITY_1_MANA_COST REAL NOT NULL," +
                            "ABILITY_1_ABILITY_DAMAGE REAL NOT NULL," +
                            "ABILITY_1_CAST_RANGE REAL NOT NULL," +
                            "ABILITY_1_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "ABILITY_1_TARGET_TYPE INTEGER NOT NULL," +
                            "ABILITY_1_BEHAVIOR INTEGER NOT NULL," +
                            "ABILITY_2_LEVEL INTEGER NOT NULL," +
                            "ABILITY_2_MANA_COST REAL NOT NULL," +
                            "ABILITY_2_ABILITY_DAMAGE REAL NOT NULL," +
                            "ABILITY_2_CAST_RANGE REAL NOT NULL," +
                            "ABILITY_2_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "ABILITY_2_TARGET_TYPE INTEGER NOT NULL," +
                            "ABILITY_2_BEHAVIOR INTEGER NOT NULL," +
                            "ABILITY_3_LEVEL INTEGER NOT NULL," +
                            "ABILITY_3_MANA_COST REAL NOT NULL," +
                            "ABILITY_3_ABILITY_DAMAGE REAL NOT NULL," +
                            "ABILITY_3_CAST_RANGE REAL NOT NULL," +
                            "ABILITY_3_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "ABILITY_3_TARGET_TYPE INTEGER NOT NULL," +
                            "ABILITY_3_BEHAVIOR INTEGER NOT NULL," +
                            "ABILITY_4_LEVEL INTEGER NOT NULL," +
                            "ABILITY_4_MANA_COST REAL NOT NULL," +
                            "ABILITY_4_ABILITY_DAMAGE REAL NOT NULL," +
                            "ABILITY_4_CAST_RANGE REAL NOT NULL," +
                            "ABILITY_4_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "ABILITY_4_TARGET_TYPE INTEGER NOT NULL," +
                            "ABILITY_4_BEHAVIOR INTEGER NOT NULL," +
                            "ABILITY_5_LEVEL INTEGER NOT NULL," +
                            "ABILITY_5_MANA_COST REAL NOT NULL," +
                            "ABILITY_5_ABILITY_DAMAGE REAL NOT NULL," +
                            "ABILITY_5_CAST_RANGE REAL NOT NULL," +
                            "ABILITY_5_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "ABILITY_5_TARGET_TYPE INTEGER NOT NULL," +
                            "ABILITY_5_BEHAVIOR INTEGER NOT NULL," +
                            "ABILITY_6_LEVEL INTEGER NOT NULL," +
                            "ABILITY_6_MANA_COST REAL NOT NULL," +
                            "ABILITY_6_ABILITY_DAMAGE REAL NOT NULL," +
                            "ABILITY_6_CAST_RANGE REAL NOT NULL," +
                            "ABILITY_6_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "ABILITY_6_TARGET_TYPE INTEGER NOT NULL," +
                            "ABILITY_6_BEHAVIOR INTEGER NOT NULL," +
                            "OPP_ABILITY_1_LEVEL INTEGER NOT NULL," +
                            "OPP_ABILITY_1_MANA_COST REAL NOT NULL," +
                            "OPP_ABILITY_1_ABILITY_DAMAGE REAL NOT NULL," +
                            "OPP_ABILITY_1_CAST_RANGE REAL NOT NULL," +
                            "OPP_ABILITY_1_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "OPP_ABILITY_1_TARGET_TYPE INTEGER NOT NULL," +
                            "OPP_ABILITY_1_BEHAVIOR INTEGER NOT NULL," +
                            "OPP_ABILITY_2_LEVEL INTEGER NOT NULL," +
                            "OPP_ABILITY_2_MANA_COST REAL NOT NULL," +
                            "OPP_ABILITY_2_ABILITY_DAMAGE REAL NOT NULL," +
                            "OPP_ABILITY_2_CAST_RANGE REAL NOT NULL," +
                            "OPP_ABILITY_2_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "OPP_ABILITY_2_TARGET_TYPE INTEGER NOT NULL," +
                            "OPP_ABILITY_2_BEHAVIOR INTEGER NOT NULL," +
                            "OPP_ABILITY_3_LEVEL INTEGER NOT NULL," +
                            "OPP_ABILITY_3_MANA_COST REAL NOT NULL," +
                            "OPP_ABILITY_3_ABILITY_DAMAGE REAL NOT NULL," +
                            "OPP_ABILITY_3_CAST_RANGE REAL NOT NULL," +
                            "OPP_ABILITY_3_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "OPP_ABILITY_3_TARGET_TYPE INTEGER NOT NULL," +
                            "OPP_ABILITY_3_BEHAVIOR INTEGER NOT NULL," +
                            "OPP_ABILITY_4_LEVEL INTEGER NOT NULL," +
                            "OPP_ABILITY_4_MANA_COST REAL NOT NULL," +
                            "OPP_ABILITY_4_ABILITY_DAMAGE REAL NOT NULL," +
                            "OPP_ABILITY_4_CAST_RANGE REAL NOT NULL," +
                            "OPP_ABILITY_4_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "OPP_ABILITY_4_TARGET_TYPE INTEGER NOT NULL," +
                            "OPP_ABILITY_4_BEHAVIOR INTEGER NOT NULL," +
                            "OPP_ABILITY_5_LEVEL INTEGER NOT NULL," +
                            "OPP_ABILITY_5_MANA_COST REAL NOT NULL," +
                            "OPP_ABILITY_5_ABILITY_DAMAGE REAL NOT NULL," +
                            "OPP_ABILITY_5_CAST_RANGE REAL NOT NULL," +
                            "OPP_ABILITY_5_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "OPP_ABILITY_5_TARGET_TYPE INTEGER NOT NULL," +
                            "OPP_ABILITY_5_BEHAVIOR INTEGER NOT NULL," +
                            "OPP_ABILITY_6_LEVEL INTEGER NOT NULL," +
                            "OPP_ABILITY_6_MANA_COST REAL NOT NULL," +
                            "OPP_ABILITY_6_ABILITY_DAMAGE REAL NOT NULL," +
                            "OPP_ABILITY_6_CAST_RANGE REAL NOT NULL," +
                            "OPP_ABILITY_6_COOLDOWN_TIME_REMAINING REAL NOT NULL," +
                            "OPP_ABILITY_6_TARGET_TYPE INTEGER NOT NULL," +
                            "OPP_ABILITY_6_BEHAVIOR INTEGER NOT NULL," +
                            "ITEM_FLASK INTEGER NOT NULL" +
                            ");";

                    connection.rxUpdate(sql).doAfterTerminate(connection::close).subscribe(
                            success->{
                                log.info("Created tables!");
                            },
                            err->{
                                log.error("Error creating tables in database! Maybe they already exist?");
                                log.error(err.getMessage());
                                err.printStackTrace();
                            }
                    );

                },
                this::connectionError
        );

    }


    private void connectionError(Throwable err){
        log.error("Error establishing database connection!");
        log.error(err.getMessage());
        err.printStackTrace();
    }
}
