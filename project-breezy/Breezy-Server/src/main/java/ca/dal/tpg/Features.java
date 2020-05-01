package ca.dal.tpg;

import io.vertx.core.json.JsonArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class Features {

    private static final Logger log = LoggerFactory.getLogger(Features.class);

    private UUID id;
    private String gameId;
    private Date timestamp;
    private int team;
    private int level;
    private int health;
    private int maxHealth;
    private double healthRegen;
    private int mana;
    private int maxMana;
    private double manaRegen;
    private int baseMoveSpeed;
    private int currentMoveSpeed;
    private int baseDamage;
    private int damageVariance;
    private int attackDamage;
    private double attackRangeBuffer;
    private double attackSpeed;
    private double secondsPerAttack;
    private double attackAnimationPoint;
    private double lastAttackTime;
    private double attackTarget;
    private double strength;
    private double agility;
    private double intellect;
    private int gold;
    private int netWorth;
    private int lastHits;
    private int denies;
    private double location1;
    private double location2;
    private double facing;
    private int visionRange;
    private int oppTeam;
    private int oppLevel;
    private int oppHealth;
    private int oppMaxHealth;
    private double oppHealthRegen;
    private int oppMana;
    private int oppMaxMana;
    private double oppManaRegen;
    private int oppBaseMoveSpeed;
    private int oppCurrentMoveSpeed;
    private int oppBaseDamage;
    private int oppDamageVariance;
    private int oppAttackDamage;
    private double oppAttackRangeBuffer;
    private double oppAttackSpeed;
    private double oppSecondsPerAttack;
    private double oppAttackAnimationPoint;
    private double oppLastAttackTime;
    private double oppAttackTarget;
    private double oppStrength;
    private double oppAgility;
    private double oppIntellect;
    private double oppLocation1;
    private double oppLocation2;
    private double oppFacing;
    private int oppVisionRange;
    private double dotaTime;
    private int goodTowerTeam;
    private int goodTowerHealth;
    private int goodTowerMaxHealth;
    private int goodTowerAttackDamage;
    private int goodTowerAttackRangeBuffer;
    private double goodTowerAttackSpeed;
    private int badTowerTeam;
    private int badTowerHealth;
    private int badTowerMaxHealth;
    private int badTowerAttackDamage;
    private int badTowerAttackRangeBuffer;
    private double badTowerAttackSpeed;
    private double bounty1Location1;
    private double bounty1Location2;
    private double bounty2Location1;
    private double bounty2Location2;
    private double bounty3Location1;
    private double bounty3Location2;
    private double bounty4Location1;
    private double bounty4Location2;
    private double power1Location1;
    private double power1Location2;
    private double power2Location1;
    private double power2Location2;
    private int power1Type;
    private int power1Status;
    private int power2Type;
    private int power2Status;
    private int goodCreep1Team;
    private int goodCreep1Health;
    private int goodCreep1MaxHealth;
    private double goodCreep1HealthRegen;
    private int goodCreep1BaseMoveSpeed;
    private int goodCreep1CurrentMoveSpeed;
    private int goodCreep1BaseDamage;
    private int goodCreep1DamageVariance;
    private int goodCreep1AttackDamage;
    private double goodCreep1AttackRangeBuffer;
    private double goodCreep1AttackSpeed;
    private double goodCreep1SecondsPerAttack;
    private double goodCreep1Location1;
    private double goodCreep1Location2;
    private int goodCreep2Team;
    private int goodCreep2Health;
    private int goodCreep2MaxHealth;
    private double goodCreep2HealthRegen;
    private int goodCreep2BaseMoveSpeed;
    private int goodCreep2CurrentMoveSpeed;
    private int goodCreep2BaseDamage;
    private int goodCreep2DamageVariance;
    private int goodCreep2AttackDamage;
    private double goodCreep2AttackRangeBuffer;
    private double goodCreep2AttackSpeed;
    private double goodCreep2SecondsPerAttack;
    private double goodCreep2Location1;
    private double goodCreep2Location2;
    private int goodCreep3Team;
    private int goodCreep3Health;
    private int goodCreep3MaxHealth;
    private double goodCreep3HealthRegen;
    private int goodCreep3BaseMoveSpeed;
    private int goodCreep3CurrentMoveSpeed;
    private int goodCreep3BaseDamage;
    private int goodCreep3DamageVariance;
    private int goodCreep3AttackDamage;
    private double goodCreep3AttackRangeBuffer;
    private double goodCreep3AttackSpeed;
    private double goodCreep3SecondsPerAttack;
    private double goodCreep3Location1;
    private double goodCreep3Location2;
    private int goodCreep4Team;
    private int goodCreep4Health;
    private int goodCreep4MaxHealth;
    private double goodCreep4HealthRegen;
    private int goodCreep4BaseMoveSpeed;
    private int goodCreep4CurrentMoveSpeed;
    private int goodCreep4BaseDamage;
    private int goodCreep4DamageVariance;
    private int goodCreep4AttackDamage;
    private double goodCreep4AttackRangeBuffer;
    private double goodCreep4AttackSpeed;
    private double goodCreep4SecondsPerAttack;
    private double goodCreep4Location1;
    private double goodCreep4Location2;
    private int goodCreep5Team;
    private int goodCreep5Health;
    private int goodCreep5MaxHealth;
    private double goodCreep5HealthRegen;
    private int goodCreep5BaseMoveSpeed;
    private int goodCreep5CurrentMoveSpeed;
    private int goodCreep5BaseDamage;
    private int goodCreep5DamageVariance;
    private int goodCreep5AttackDamage;
    private double goodCreep5AttackRangeBuffer;
    private double goodCreep5AttackSpeed;
    private double goodCreep5SecondsPerAttack;
    private double goodCreep5Location1;
    private double goodCreep5Location2;
    private int badCreep1Team;
    private int badCreep1Health;
    private int badCreep1MaxHealth;
    private double badCreep1HealthRegen;
    private int badCreep1BaseMoveSpeed;
    private int badCreep1CurrentMoveSpeed;
    private int badCreep1BaseDamage;
    private int badCreep1DamageVariance;
    private int badCreep1AttackDamage;
    private double badCreep1AttackRangeBuffer;
    private double badCreep1AttackSpeed;
    private double badCreep1SecondsPerAttack;
    private double badCreep1Location1;
    private double badCreep1Location2;
    private int badCreep2Team;
    private int badCreep2Health;
    private int badCreep2MaxHealth;
    private double badCreep2HealthRegen;
    private int badCreep2BaseMoveSpeed;
    private int badCreep2CurrentMoveSpeed;
    private int badCreep2BaseDamage;
    private int badCreep2DamageVariance;
    private int badCreep2AttackDamage;
    private double badCreep2AttackRangeBuffer;
    private double badCreep2AttackSpeed;
    private double badCreep2SecondsPerAttack;
    private double badCreep2Location1;
    private double badCreep2Location2;
    private int badCreep3Team;
    private int badCreep3Health;
    private int badCreep3MaxHealth;
    private double badCreep3HealthRegen;
    private int badCreep3BaseMoveSpeed;
    private int badCreep3CurrentMoveSpeed;
    private int badCreep3BaseDamage;
    private int badCreep3DamageVariance;
    private int badCreep3AttackDamage;
    private double badCreep3AttackRangeBuffer;
    private double badCreep3AttackSpeed;
    private double badCreep3SecondsPerAttack;
    private double badCreep3Location1;
    private double badCreep3Location2;
    private int badCreep4Team;
    private int badCreep4Health;
    private int badCreep4MaxHealth;
    private double badCreep4HealthRegen;
    private int badCreep4BaseMoveSpeed;
    private int badCreep4CurrentMoveSpeed;
    private int badCreep4BaseDamage;
    private int badCreep4DamageVariance;
    private int badCreep4AttackDamage;
    private double badCreep4AttackRangeBuffer;
    private double badCreep4AttackSpeed;
    private double badCreep4SecondsPerAttack;
    private double badCreep4Location1;
    private double badCreep4Location2;
    private int badCreep5Team;
    private int badCreep5Health;
    private int badCreep5MaxHealth;
    private double badCreep5HealthRegen;
    private int badCreep5BaseMoveSpeed;
    private int badCreep5CurrentMoveSpeed;
    private int badCreep5BaseDamage;
    private int badCreep5DamageVariance;
    private int badCreep5AttackDamage;
    private double badCreep5AttackRangeBuffer;
    private double badCreep5AttackSpeed;
    private double badCreep5SecondsPerAttack;
    private double badCreep5Location1;
    private double badCreep5Location2;
    private int ability1Level;
    private int ability1ManaCost;
    private int ability1AbilityDamage;
    private int ability1CastRange;
    private double ability1CooldownTimeRemaining;
    private int ability1TargetType;
    private int ability1Behavior;
    private int ability2Level;
    private int ability2ManaCost;
    private int ability2AbilityDamage;
    private int ability2CastRange;
    private double ability2CooldownTimeRemaining;
    private int ability2TargetType;
    private int ability2Behavior;
    private int ability3Level;
    private int ability3ManaCost;
    private int ability3AbilityDamage;
    private int ability3CastRange;
    private double ability3CooldownTimeRemaining;
    private int ability3TargetType;
    private int ability3Behavior;
    private int ability4Level;
    private int ability4ManaCost;
    private int ability4AbilityDamage;
    private int ability4CastRange;
    private double ability4CooldownTimeRemaining;
    private int ability4TargetType;
    private int ability4Behavior;
    private int ability5Level;
    private int ability5ManaCost;
    private int ability5AbilityDamage;
    private int ability5CastRange;
    private double ability5CooldownTimeRemaining;
    private int ability5TargetType;
    private int ability5Behavior;
    private int ability6Level;
    private int ability6ManaCost;
    private int ability6AbilityDamage;
    private int ability6CastRange;
    private double ability6CooldownTimeRemaining;
    private int ability6TargetType;
    private int ability6Behavior;
    private int oppAbility1Level;
    private int oppAbility1ManaCost;
    private int oppAbility1AbilityDamage;
    private int oppAbility1CastRange;
    private double oppAbility1CooldownTimeRemaining;
    private int oppAbility1TargetType;
    private int oppAbility1Behavior;
    private int oppAbility2Level;
    private int oppAbility2ManaCost;
    private int oppAbility2AbilityDamage;
    private int oppAbility2CastRange;
    private double oppAbility2CooldownTimeRemaining;
    private int oppAbility2TargetType;
    private int oppAbility2Behavior;
    private int oppAbility3Level;
    private int oppAbility3ManaCost;
    private int oppAbility3AbilityDamage;
    private int oppAbility3CastRange;
    private double oppAbility3CooldownTimeRemaining;
    private int oppAbility3TargetType;
    private int oppAbility3Behavior;
    private int oppAbility4Level;
    private int oppAbility4ManaCost;
    private int oppAbility4AbilityDamage;
    private int oppAbility4CastRange;
    private double oppAbility4CooldownTimeRemaining;
    private int oppAbility4TargetType;
    private int oppAbility4Behavior;
    private int oppAbility5Level;
    private int oppAbility5ManaCost;
    private int oppAbility5AbilityDamage;
    private int oppAbility5CastRange;
    private double oppAbility5CooldownTimeRemaining;
    private int oppAbility5TargetType;
    private int oppAbility5Behavior;
    private int oppAbility6Level;
    private int oppAbility6ManaCost;
    private int oppAbility6AbilityDamage;
    private int oppAbility6CastRange;
    private double oppAbility6CooldownTimeRemaining;
    private int oppAbility6TargetType;
    private int oppAbility6Behavior;
    private int itemFlask;

    public static Features fromJsonArray(String gameId,JsonArray array){
        try{

            Features f = new Features();
            f.setId(UUID.randomUUID());
            f.setGameId(gameId);
            f.setTimestamp(Date.from(Instant.now()));
            f.setTeam(array.getInteger(0));//
            f.setLevel(array.getInteger(1));//
            f.setHealth(array.getInteger(2));//
            f.setMaxHealth(array.getInteger(3));//
            f.setHealthRegen(array.getDouble(4));//
            f.setMana(array.getInteger(5));//
            f.setMaxMana(array.getInteger(6));//
            f.setManaRegen(array.getDouble(7));//
            f.setBaseMoveSpeed(array.getInteger(8));//
            f.setCurrentMoveSpeed(array.getInteger(9));//1
            f.setBaseDamage(array.getInteger(10));
            f.setDamageVariance(array.getInteger(11));
            f.setAttackDamage(array.getInteger(12));
            f.setAttackRangeBuffer(array.getInteger(13));
            f.setAttackSpeed(array.getInteger(14));
            f.setSecondsPerAttack(array.getDouble(15));
            f.setAttackAnimationPoint(array.getDouble(16));
            f.setLastAttackTime(array.getDouble(17));
            f.setAttackTarget(array.getValue(18));
            f.setStrength(array.getDouble(19));
            f.setAgility(array.getDouble(20));
            f.setIntellect(array.getDouble(21));
            f.setGold(array.getInteger(22));
            f.setNetWorth(array.getInteger(23));
            f.setLastHits(array.getInteger(24));
            f.setDenies(array.getInteger(25));
            f.setLocation1(array.getDouble(26));
            f.setLocation2(array.getDouble(27));
            f.setFacing(array.getDouble(28));
            f.setVisionRange(array.getInteger(29));
            f.setOppTeam(array.getInteger(30));
            f.setOppLevel(array.getInteger(31));
            f.setOppHealth(array.getInteger(32));
            f.setOppMaxHealth(array.getInteger(33));
            f.setOppHealthRegen(array.getDouble(34));
            f.setOppMana(array.getInteger(35));
            f.setOppMaxMana(array.getInteger(36));
            f.setOppManaRegen(array.getDouble(37));
            f.setOppBaseMoveSpeed(array.getInteger(38));
            f.setOppCurrentMoveSpeed(array.getInteger(39));
            f.setOppBaseDamage(array.getInteger(40));
            f.setOppDamageVariance(array.getInteger(41));
            f.setOppAttackDamage(array.getInteger(42));
            f.setOppAttackRangeBuffer(array.getDouble(43));
            f.setOppAttackSpeed(array.getDouble(44));
            f.setOppSecondsPerAttack(array.getDouble(45));
            f.setOppAttackAnimationPoint(array.getDouble(46));
            f.setOppLastAttackTime(array.getDouble(47));
            f.setOppAttackTarget(array.getValue(48));
            f.setOppStrength(array.getDouble(49));
            f.setOppAgility(array.getDouble(50));
            f.setOppIntellect(array.getDouble(51));
            f.setOppLocation1(array.getDouble(52));
            f.setOppLocation2(array.getDouble(53));
            f.setOppFacing(array.getDouble(54));
            f.setOppVisionRange(array.getInteger(55));
            f.setDotaTime(array.getDouble(56));
            f.setGoodTowerTeam(array.getInteger(57));
            f.setGoodTowerHealth(array.getInteger(58));
            f.setGoodTowerMaxHealth(array.getInteger(59));
            f.setGoodTowerAttackDamage(array.getInteger(60));
            f.setGoodTowerAttackRangeBuffer(array.getInteger(61));
            f.setGoodTowerAttackSpeed(array.getDouble(62));
            f.setBadTowerTeam(array.getInteger(63));
            f.setBadTowerHealth(array.getInteger(64));
            f.setBadTowerMaxHealth(array.getInteger(65));
            f.setBadTowerAttackDamage(array.getInteger(66));
            f.setBadTowerAttackRangeBuffer(array.getInteger(67));
            f.setBadTowerAttackSpeed(array.getDouble(68));
            f.setBounty1Location1(array.getDouble(69));
            f.setBounty1Location2(array.getDouble(70));
            f.setBounty2Location1(array.getDouble(71));
            f.setBounty2Location2(array.getDouble(72));
            f.setBounty3Location1(array.getDouble(73));
            f.setBounty3Location2(array.getDouble(74));
            f.setBounty4Location1(array.getDouble(75));
            f.setBounty4Location2(array.getDouble(76));
            f.setPower1Location1(array.getDouble(77));
            f.setPower1Location2(array.getDouble(78));
            f.setPower2Location1(array.getDouble(79));
            f.setPower2Location2(array.getDouble(80));
            f.setPower1Type(array.getInteger(81));
            f.setPower1Status(array.getInteger(82));
            f.setPower2Type(array.getInteger(83));
            f.setPower2Status(array.getInteger(84));
            f.setGoodCreep1Team(array.getInteger(85));
            f.setGoodCreep1Health(array.getInteger(86));
            f.setGoodCreep1MaxHealth(array.getInteger(87));
            f.setGoodCreep1HealthRegen(array.getDouble(88));
            f.setGoodCreep1BaseMoveSpeed(array.getInteger(89));
            f.setGoodCreep1CurrentMoveSpeed(array.getInteger(90));
            f.setGoodCreep1BaseDamage(array.getInteger(91));
            f.setGoodCreep1DamageVariance(array.getInteger(92));
            f.setGoodCreep1AttackDamage(array.getInteger(93));
            f.setGoodCreep1AttackRangeBuffer(array.getDouble(94));
            f.setGoodCreep1AttackSpeed(array.getDouble(95));
            f.setGoodCreep1SecondsPerAttack(array.getDouble(96));
            f.setGoodCreep1Location1(array.getDouble(97));
            f.setGoodCreep1Location2(array.getDouble(98));
            f.setGoodCreep2Team(array.getInteger(99));
            f.setGoodCreep2Health(array.getInteger(100));
            f.setGoodCreep2MaxHealth(array.getInteger(101));
            f.setGoodCreep2HealthRegen(array.getDouble(102));
            f.setGoodCreep2BaseMoveSpeed(array.getInteger(103));
            f.setGoodCreep2CurrentMoveSpeed(array.getInteger(104));
            f.setGoodCreep2BaseDamage(array.getInteger(105));
            f.setGoodCreep2DamageVariance(array.getInteger(106));
            f.setGoodCreep2AttackDamage(array.getInteger(107));
            f.setGoodCreep2AttackRangeBuffer(array.getDouble(108));
            f.setGoodCreep2AttackSpeed(array.getDouble(109));
            f.setGoodCreep2SecondsPerAttack(array.getDouble(110));
            f.setGoodCreep2Location1(array.getDouble(111));
            f.setGoodCreep2Location2(array.getDouble(112));
            f.setGoodCreep3Team(array.getInteger(113));
            f.setGoodCreep3Health(array.getInteger(114));
            f.setGoodCreep3MaxHealth(array.getInteger(115));
            f.setGoodCreep3HealthRegen(array.getDouble(116));
            f.setGoodCreep3BaseMoveSpeed(array.getInteger(117));
            f.setGoodCreep3CurrentMoveSpeed(array.getInteger(118));
            f.setGoodCreep3BaseDamage(array.getInteger(119));
            f.setGoodCreep3DamageVariance(array.getInteger(120));
            f.setGoodCreep3AttackDamage(array.getInteger(121));
            f.setGoodCreep3AttackRangeBuffer(array.getDouble(122));
            f.setGoodCreep3AttackSpeed(array.getDouble(123));
            f.setGoodCreep3SecondsPerAttack(array.getDouble(124));
            f.setGoodCreep3Location1(array.getDouble(125));
            f.setGoodCreep3Location2(array.getDouble(126));
            f.setGoodCreep4Team(array.getInteger(127));
            f.setGoodCreep4Health(array.getInteger(128));
            f.setGoodCreep4MaxHealth(array.getInteger(129));
            f.setGoodCreep4HealthRegen(array.getDouble(130));
            f.setGoodCreep4BaseMoveSpeed(array.getInteger(131));
            f.setGoodCreep4CurrentMoveSpeed(array.getInteger(132));
            f.setGoodCreep4BaseDamage(array.getInteger(133));
            f.setGoodCreep4DamageVariance(array.getInteger(134));
            f.setGoodCreep4AttackDamage(array.getInteger(135));
            f.setGoodCreep4AttackRangeBuffer(array.getDouble(136));
            f.setGoodCreep4AttackSpeed(array.getDouble(137));
            f.setGoodCreep4SecondsPerAttack(array.getDouble(138));
            f.setGoodCreep4Location1(array.getDouble(139));
            f.setGoodCreep4Location2(array.getDouble(140));
            f.setGoodCreep5Team(array.getInteger(141));
            f.setGoodCreep5Health(array.getInteger(142));
            f.setGoodCreep5MaxHealth(array.getInteger(143));
            f.setGoodCreep5HealthRegen(array.getDouble(144));
            f.setGoodCreep5BaseMoveSpeed(array.getInteger(145));
            f.setGoodCreep5CurrentMoveSpeed(array.getInteger(146));
            f.setGoodCreep5BaseDamage(array.getInteger(147));
            f.setGoodCreep5DamageVariance(array.getInteger(148));
            f.setGoodCreep5AttackDamage(array.getInteger(149));
            f.setGoodCreep5AttackRangeBuffer(array.getDouble(150));
            f.setGoodCreep5AttackSpeed(array.getDouble(151));
            f.setGoodCreep5SecondsPerAttack(array.getDouble(152));
            f.setGoodCreep5Location1(array.getDouble(153));
            f.setGoodCreep5Location2(array.getDouble(154));
            f.setBadCreep1Team(array.getInteger(155));
            f.setBadCreep1Health(array.getInteger(156));
            f.setBadCreep1MaxHealth(array.getInteger(157));
            f.setBadCreep1HealthRegen(array.getDouble(158));
            f.setBadCreep1BaseMoveSpeed(array.getInteger(159));
            f.setBadCreep1CurrentMoveSpeed(array.getInteger(160));
            f.setBadCreep1BaseDamage(array.getInteger(161));
            f.setBadCreep1DamageVariance(array.getInteger(162));
            f.setBadCreep1AttackDamage(array.getInteger(163));
            f.setBadCreep1AttackRangeBuffer(array.getDouble(164));
            f.setBadCreep1AttackSpeed(array.getDouble(165));
            f.setBadCreep1SecondsPerAttack(array.getDouble(166));
            f.setBadCreep1Location1(array.getDouble(167));
            f.setBadCreep1Location2(array.getDouble(168));
            f.setBadCreep2Team(array.getInteger(169));
            f.setBadCreep2Health(array.getInteger(170));
            f.setBadCreep2MaxHealth(array.getInteger(171));
            f.setBadCreep2HealthRegen(array.getDouble(172));
            f.setBadCreep2BaseMoveSpeed(array.getInteger(173));
            f.setBadCreep2CurrentMoveSpeed(array.getInteger(174));
            f.setBadCreep2BaseDamage(array.getInteger(175));
            f.setBadCreep2DamageVariance(array.getInteger(176));
            f.setBadCreep2AttackDamage(array.getInteger(177));
            f.setBadCreep2AttackRangeBuffer(array.getDouble(178));
            f.setBadCreep2AttackSpeed(array.getDouble(179));
            f.setBadCreep2SecondsPerAttack(array.getDouble(180));
            f.setBadCreep2Location1(array.getDouble(181));
            f.setBadCreep2Location2(array.getDouble(182));
            f.setBadCreep3Team(array.getInteger(183));
            f.setBadCreep3Health(array.getInteger(184));
            f.setBadCreep3MaxHealth(array.getInteger(185));
            f.setBadCreep3HealthRegen(array.getDouble(186));
            f.setBadCreep3BaseMoveSpeed(array.getInteger(187));
            f.setBadCreep3CurrentMoveSpeed(array.getInteger(188));
            f.setBadCreep3BaseDamage(array.getInteger(189));
            f.setBadCreep3DamageVariance(array.getInteger(190));
            f.setBadCreep3AttackDamage(array.getInteger(191));
            f.setBadCreep3AttackRangeBuffer(array.getDouble(192));
            f.setBadCreep3AttackSpeed(array.getDouble(193));
            f.setBadCreep3SecondsPerAttack(array.getDouble(194));
            f.setBadCreep3Location1(array.getDouble(195));
            f.setBadCreep3Location2(array.getDouble(196));
            f.setBadCreep4Team(array.getInteger(197));
            f.setBadCreep4Health(array.getInteger(198));
            f.setBadCreep4MaxHealth(array.getInteger(199));
            f.setBadCreep4HealthRegen(array.getDouble(200));
            f.setBadCreep4BaseMoveSpeed(array.getInteger(201));
            f.setBadCreep4CurrentMoveSpeed(array.getInteger(202));
            f.setBadCreep4BaseDamage(array.getInteger(203));
            f.setBadCreep4DamageVariance(array.getInteger(204));
            f.setBadCreep4AttackDamage(array.getInteger(205));
            f.setBadCreep4AttackRangeBuffer(array.getDouble(206));
            f.setBadCreep4AttackSpeed(array.getDouble(207));
            f.setBadCreep4SecondsPerAttack(array.getDouble(208));
            f.setBadCreep4Location1(array.getDouble(209));
            f.setBadCreep4Location2(array.getDouble(210));
            f.setBadCreep5Team(array.getInteger(211));
            f.setBadCreep5Health(array.getInteger(212));
            f.setBadCreep5MaxHealth(array.getInteger(213));
            f.setBadCreep5HealthRegen(array.getDouble(214));
            f.setBadCreep5BaseMoveSpeed(array.getInteger(215));
            f.setBadCreep5CurrentMoveSpeed(array.getInteger(216));
            f.setBadCreep5BaseDamage(array.getInteger(217));
            f.setBadCreep5DamageVariance(array.getInteger(218));
            f.setBadCreep5AttackDamage(array.getInteger(219));
            f.setBadCreep5AttackRangeBuffer(array.getDouble(220));
            f.setBadCreep5AttackSpeed(array.getDouble(221));
            f.setBadCreep5SecondsPerAttack(array.getDouble(222));
            f.setBadCreep5Location1(array.getDouble(223));
            f.setBadCreep5Location2(array.getDouble(224));
            f.setAbility1Level(array.getInteger(225));
            f.setAbility1ManaCost(array.getInteger(226));
            f.setAbility1AbilityDamage(array.getInteger(227));
            f.setAbility1CastRange(array.getInteger(228));
            f.setAbility1CooldownTimeRemaining(array.getDouble(229));
            f.setAbility1TargetType(array.getInteger(230));
            f.setAbility1Behavior(array.getInteger(231));
            f.setAbility2Level(array.getInteger(232));
            f.setAbility2ManaCost(array.getInteger(233));
            f.setAbility2AbilityDamage(array.getInteger(234));
            f.setAbility2CastRange(array.getInteger(235));
            f.setAbility2CooldownTimeRemaining(array.getDouble(236));
            f.setAbility2TargetType(array.getInteger(237));
            f.setAbility2Behavior(array.getInteger(238));
            f.setAbility3Level(array.getInteger(239));
            f.setAbility3ManaCost(array.getInteger(240));
            f.setAbility3AbilityDamage(array.getInteger(241));
            f.setAbility3CastRange(array.getInteger(242));
            f.setAbility3CooldownTimeRemaining(array.getDouble(243));
            f.setAbility3TargetType(array.getInteger(244));
            f.setAbility3Behavior(array.getInteger(245));
            f.setAbility4Level(array.getInteger(246));
            f.setAbility4ManaCost(array.getInteger(247));
            f.setAbility4AbilityDamage(array.getInteger(248));
            f.setAbility4CastRange(array.getInteger(249));
            f.setAbility4CooldownTimeRemaining(array.getDouble(250));
            f.setAbility4TargetType(array.getInteger(251));
            f.setAbility4Behavior(array.getInteger(252));
            f.setAbility5Level(array.getInteger(253));
            f.setAbility5ManaCost(array.getInteger(254));
            f.setAbility5AbilityDamage(array.getInteger(255));
            f.setAbility5CastRange(array.getInteger(256));
            f.setAbility5CooldownTimeRemaining(array.getDouble(257));
            f.setAbility5TargetType(array.getInteger(258));
            f.setAbility5Behavior(array.getInteger(259));
            f.setAbility6Level(array.getInteger(260));
            f.setAbility6ManaCost(array.getInteger(261));
            f.setAbility6AbilityDamage(array.getInteger(262));
            f.setAbility6CastRange(array.getInteger(263));
            f.setAbility6CooldownTimeRemaining(array.getInteger(264));
            f.setAbility6TargetType(array.getInteger(265));
            f.setAbility6Behavior(array.getInteger(266));
            f.setOppAbility1Level(array.getInteger(267));
            f.setOppAbility1ManaCost(array.getInteger(268));
            f.setOppAbility1AbilityDamage(array.getInteger(269));
            f.setOppAbility1CastRange(array.getInteger(270));
            f.setOppAbility1CooldownTimeRemaining(array.getDouble(271));
            f.setOppAbility1TargetType(array.getInteger(272));
            f.setOppAbility1Behavior(array.getInteger(273));
            f.setOppAbility2Level(array.getInteger(274));
            f.setOppAbility2ManaCost(array.getInteger(275));
            f.setOppAbility2AbilityDamage(array.getInteger(276));
            f.setOppAbility2CastRange(array.getInteger(277));
            f.setOppAbility2CooldownTimeRemaining(array.getDouble(278));
            f.setOppAbility2TargetType(array.getInteger(279));
            f.setOppAbility2Behavior(array.getInteger(280));
            f.setOppAbility3Level(array.getInteger(281));
            f.setOppAbility3ManaCost(array.getInteger(282));
            f.setOppAbility3AbilityDamage(array.getInteger(283));
            f.setOppAbility3CastRange(array.getInteger(284));
            f.setOppAbility3CooldownTimeRemaining(array.getDouble(285));
            f.setOppAbility3TargetType(array.getInteger(286));
            f.setOppAbility3Behavior(array.getInteger(287));
            f.setOppAbility4Level(array.getInteger(288));
            f.setOppAbility4ManaCost(array.getInteger(289));
            f.setOppAbility4AbilityDamage(array.getInteger(290));
            f.setOppAbility4CastRange(array.getInteger(291));
            f.setOppAbility4CooldownTimeRemaining(array.getDouble(292));
            f.setOppAbility4TargetType(array.getInteger(293));
            f.setOppAbility4Behavior(array.getInteger(294));
            f.setOppAbility5Level(array.getInteger(295));
            f.setOppAbility5ManaCost(array.getInteger(296));
            f.setOppAbility5AbilityDamage(array.getInteger(297));
            f.setOppAbility5CastRange(array.getInteger(298));
            f.setOppAbility5CooldownTimeRemaining(array.getDouble(299));
            f.setOppAbility5TargetType(array.getInteger(300));
            f.setOppAbility5Behavior(array.getInteger(301));
            f.setOppAbility6Level(array.getInteger(302));
            f.setOppAbility6ManaCost(array.getInteger(303));
            f.setOppAbility6AbilityDamage(array.getInteger(304));
            f.setOppAbility6CastRange(array.getInteger(305));
            f.setOppAbility6CooldownTimeRemaining(array.getInteger(306));
            f.setOppAbility6TargetType(array.getInteger(307));
            f.setOppAbility6Behavior(array.getInteger(308));
            f.setItemFlask(array.getInteger(309));

            return f;
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }




    public double getAbility1CooldownTimeRemaining() {
        return ability1CooldownTimeRemaining;
    }

    public void setAbility1CooldownTimeRemaining(double ability1CooldownTimeRemaining) {
        this.ability1CooldownTimeRemaining = ability1CooldownTimeRemaining;
    }

    public double getAbility2CooldownTimeRemaining() {
        return ability2CooldownTimeRemaining;
    }

    public void setAbility2CooldownTimeRemaining(double ability2CooldownTimeRemaining) {
        this.ability2CooldownTimeRemaining = ability2CooldownTimeRemaining;
    }

    public double getAbility3CooldownTimeRemaining() {
        return ability3CooldownTimeRemaining;
    }

    public void setAbility3CooldownTimeRemaining(double ability3CooldownTimeRemaining) {
        this.ability3CooldownTimeRemaining = ability3CooldownTimeRemaining;
    }

    public double getAbility4CooldownTimeRemaining() {
        return ability4CooldownTimeRemaining;
    }

    public void setAbility4CooldownTimeRemaining(double ability4CooldownTimeRemaining) {
        this.ability4CooldownTimeRemaining = ability4CooldownTimeRemaining;
    }

    public double getAbility5CooldownTimeRemaining() {
        return ability5CooldownTimeRemaining;
    }

    public void setAbility5CooldownTimeRemaining(double ability5CooldownTimeRemaining) {
        this.ability5CooldownTimeRemaining = ability5CooldownTimeRemaining;
    }

    public double getOppAbility1CooldownTimeRemaining() {
        return oppAbility1CooldownTimeRemaining;
    }

    public void setOppAbility1CooldownTimeRemaining(double oppAbility1CooldownTimeRemaining) {
        this.oppAbility1CooldownTimeRemaining = oppAbility1CooldownTimeRemaining;
    }

    public double getOppAbility2CooldownTimeRemaining() {
        return oppAbility2CooldownTimeRemaining;
    }

    public void setOppAbility2CooldownTimeRemaining(double oppAbility2CooldownTimeRemaining) {
        this.oppAbility2CooldownTimeRemaining = oppAbility2CooldownTimeRemaining;
    }

    public double getOppAbility3CooldownTimeRemaining() {
        return oppAbility3CooldownTimeRemaining;
    }

    public void setOppAbility3CooldownTimeRemaining(double oppAbility3CooldownTimeRemaining) {
        this.oppAbility3CooldownTimeRemaining = oppAbility3CooldownTimeRemaining;
    }

    public double getOppAbility4CooldownTimeRemaining() {
        return oppAbility4CooldownTimeRemaining;
    }

    public void setOppAbility4CooldownTimeRemaining(double oppAbility4CooldownTimeRemaining) {
        this.oppAbility4CooldownTimeRemaining = oppAbility4CooldownTimeRemaining;
    }

    public double getOppAbility5CooldownTimeRemaining() {
        return oppAbility5CooldownTimeRemaining;
    }

    public void setOppAbility5CooldownTimeRemaining(double oppAbility5CooldownTimeRemaining) {
        this.oppAbility5CooldownTimeRemaining = oppAbility5CooldownTimeRemaining;
    }

    public double getAbility6CooldownTimeRemaining() {
        return ability6CooldownTimeRemaining;
    }

    public void setAbility6CooldownTimeRemaining(double ability6CooldownTimeRemaining) {
        this.ability6CooldownTimeRemaining = ability6CooldownTimeRemaining;
    }

    public double getOppAbility6CooldownTimeRemaining() {
        return oppAbility6CooldownTimeRemaining;
    }

    public void setOppAbility6CooldownTimeRemaining(double oppAbility6CooldownTimeRemaining) {
        this.oppAbility6CooldownTimeRemaining = oppAbility6CooldownTimeRemaining;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String runId) {
        this.gameId = runId;
    }

    public int getOppAttackDamage() {
        return oppAttackDamage;
    }

    public void setOppAttackDamage(int oppAttackDamage) {
        this.oppAttackDamage = oppAttackDamage;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public double getGoodCreep1AttackRangeBuffer() {
        return goodCreep1AttackRangeBuffer;
    }

    public void setGoodCreep1AttackRangeBuffer(double goodCreep1AttackRangeBuffer) {
        this.goodCreep1AttackRangeBuffer = goodCreep1AttackRangeBuffer;
    }

    public double getGoodCreep2AttackRangeBuffer() {
        return goodCreep2AttackRangeBuffer;
    }

    public void setGoodCreep2AttackRangeBuffer(double goodCreep2AttackRangeBuffer) {
        this.goodCreep2AttackRangeBuffer = goodCreep2AttackRangeBuffer;
    }

    public double getGoodCreep3AttackRangeBuffer() {
        return goodCreep3AttackRangeBuffer;
    }

    public void setGoodCreep3AttackRangeBuffer(double goodCreep3AttackRangeBuffer) {
        this.goodCreep3AttackRangeBuffer = goodCreep3AttackRangeBuffer;
    }

    public double getGoodCreep4AttackRangeBuffer() {
        return goodCreep4AttackRangeBuffer;
    }

    public void setGoodCreep4AttackRangeBuffer(double goodCreep4AttackRangeBuffer) {
        this.goodCreep4AttackRangeBuffer = goodCreep4AttackRangeBuffer;
    }

    public double getGoodCreep5AttackRangeBuffer() {
        return goodCreep5AttackRangeBuffer;
    }

    public void setGoodCreep5AttackRangeBuffer(double goodCreep5AttackRangeBuffer) {
        this.goodCreep5AttackRangeBuffer = goodCreep5AttackRangeBuffer;
    }

    public double getBadCreep1AttackRangeBuffer() {
        return badCreep1AttackRangeBuffer;
    }

    public void setBadCreep1AttackRangeBuffer(double badCreep1AttackRangeBuffer) {
        this.badCreep1AttackRangeBuffer = badCreep1AttackRangeBuffer;
    }

    public double getBadCreep2AttackRangeBuffer() {
        return badCreep2AttackRangeBuffer;
    }

    public void setBadCreep2AttackRangeBuffer(double badCreep2AttackRangeBuffer) {
        this.badCreep2AttackRangeBuffer = badCreep2AttackRangeBuffer;
    }

    public double getBadCreep3AttackRangeBuffer() {
        return badCreep3AttackRangeBuffer;
    }

    public void setBadCreep3AttackRangeBuffer(double badCreep3AttackRangeBuffer) {
        this.badCreep3AttackRangeBuffer = badCreep3AttackRangeBuffer;
    }

    public double getBadCreep4AttackRangeBuffer() {
        return badCreep4AttackRangeBuffer;
    }

    public void setBadCreep4AttackRangeBuffer(double badCreep4AttackRangeBuffer) {
        this.badCreep4AttackRangeBuffer = badCreep4AttackRangeBuffer;
    }

    public double getBadCreep5AttackRangeBuffer() {
        return badCreep5AttackRangeBuffer;
    }

    public void setBadCreep5AttackRangeBuffer(double badCreep5AttackRangeBuffer) {
        this.badCreep5AttackRangeBuffer = badCreep5AttackRangeBuffer;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealthRegen() {
        return healthRegen;
    }

    public void setHealthRegen(double healthRegen) {
        this.healthRegen = healthRegen;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public double getManaRegen() {
        return manaRegen;
    }

    public void setManaRegen(double manaRegen) {
        this.manaRegen = manaRegen;
    }

    public int getBaseMoveSpeed() {
        return baseMoveSpeed;
    }

    public void setBaseMoveSpeed(int baseMoveSpeed) {
        this.baseMoveSpeed = baseMoveSpeed;
    }

    public int getCurrentMoveSpeed() {
        return currentMoveSpeed;
    }

    public void setCurrentMoveSpeed(int currentMoveSpeed) {
        this.currentMoveSpeed = currentMoveSpeed;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getDamageVariance() {
        return damageVariance;
    }

    public void setDamageVariance(int damageVariance) {
        this.damageVariance = damageVariance;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public double getAttackRangeBuffer() {
        return attackRangeBuffer;
    }

    public void setAttackRangeBuffer(double attackRangeBuffer) {
        this.attackRangeBuffer = attackRangeBuffer;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getSecondsPerAttack() {
        return secondsPerAttack;
    }

    public void setSecondsPerAttack(double secondsPerAttack) {
        this.secondsPerAttack = secondsPerAttack;
    }

    public double getAttackAnimationPoint() {
        return attackAnimationPoint;
    }

    public void setAttackAnimationPoint(double attackAnimationPoint) {
        this.attackAnimationPoint = attackAnimationPoint;
    }

    public double getLastAttackTime() {
        return lastAttackTime;
    }

    public void setLastAttackTime(double lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }

    public Double getAttackTarget() {
        return attackTarget;
    }

    public void setAttackTarget(Object attackTarget) {

        if(attackTarget instanceof Integer){
            this.attackTarget = new Double((Integer)attackTarget);
        }else{
            this.attackTarget = (Double)attackTarget;
        }

    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getIntellect() {
        return intellect;
    }

    public void setIntellect(double intellect) {
        this.intellect = intellect;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(int netWorth) {
        this.netWorth = netWorth;
    }

    public int getLastHits() {
        return lastHits;
    }

    public void setLastHits(int lastHits) {
        this.lastHits = lastHits;
    }

    public int getDenies() {
        return denies;
    }

    public void setDenies(int denies) {
        this.denies = denies;
    }

    public double getLocation1() {
        return location1;
    }

    public void setLocation1(double location1) {
        this.location1 = location1;
    }

    public double getLocation2() {
        return location2;
    }

    public void setLocation2(double location2) {
        this.location2 = location2;
    }

    public double getFacing() {
        return facing;
    }

    public void setFacing(double facing) {
        this.facing = facing;
    }

    public int getVisionRange() {
        return visionRange;
    }

    public void setVisionRange(int visionRange) {
        this.visionRange = visionRange;
    }

    public int getOppTeam() {
        return oppTeam;
    }

    public void setOppTeam(int oppTeam) {
        this.oppTeam = oppTeam;
    }

    public int getOppLevel() {
        return oppLevel;
    }

    public void setOppLevel(int oppLevel) {
        this.oppLevel = oppLevel;
    }

    public int getOppHealth() {
        return oppHealth;
    }

    public void setOppHealth(int oppHealth) {
        this.oppHealth = oppHealth;
    }

    public int getOppMaxHealth() {
        return oppMaxHealth;
    }

    public void setOppMaxHealth(int oppMaxHealth) {
        this.oppMaxHealth = oppMaxHealth;
    }

    public double getOppHealthRegen() {
        return oppHealthRegen;
    }

    public void setOppHealthRegen(double oppHealthRegen) {
        this.oppHealthRegen = oppHealthRegen;
    }

    public int getOppMana() {
        return oppMana;
    }

    public void setOppMana(int oppMana) {
        this.oppMana = oppMana;
    }

    public int getOppMaxMana() {
        return oppMaxMana;
    }

    public void setOppMaxMana(int oppMaxMana) {
        this.oppMaxMana = oppMaxMana;
    }

    public double getOppManaRegen() {
        return oppManaRegen;
    }

    public void setOppManaRegen(double oppManaRegen) {
        this.oppManaRegen = oppManaRegen;
    }

    public int getOppBaseMoveSpeed() {
        return oppBaseMoveSpeed;
    }

    public void setOppBaseMoveSpeed(int oppBaseMoveSpeed) {
        this.oppBaseMoveSpeed = oppBaseMoveSpeed;
    }

    public int getOppCurrentMoveSpeed() {
        return oppCurrentMoveSpeed;
    }

    public void setOppCurrentMoveSpeed(int oppCurrentMoveSpeed) {
        this.oppCurrentMoveSpeed = oppCurrentMoveSpeed;
    }

    public int getOppBaseDamage() {
        return oppBaseDamage;
    }

    public void setOppBaseDamage(int oppBaseDamage) {
        this.oppBaseDamage = oppBaseDamage;
    }

    public int getOppDamageVariance() {
        return oppDamageVariance;
    }

    public void setOppDamageVariance(int oppDamageVariance) {
        this.oppDamageVariance = oppDamageVariance;
    }

    public double getOppAttackRangeBuffer() {
        return oppAttackRangeBuffer;
    }

    public void setOppAttackRangeBuffer(double oppAttackRangeBuffer) {
        this.oppAttackRangeBuffer = oppAttackRangeBuffer;
    }

    public double getOppAttackSpeed() {
        return oppAttackSpeed;
    }

    public void setOppAttackSpeed(double oppAttackSpeed) {
        this.oppAttackSpeed = oppAttackSpeed;
    }

    public double getOppSecondsPerAttack() {
        return oppSecondsPerAttack;
    }

    public void setOppSecondsPerAttack(double oppSecondsPerAttack) {
        this.oppSecondsPerAttack = oppSecondsPerAttack;
    }

    public double getOppAttackAnimationPoint() {
        return oppAttackAnimationPoint;
    }

    public void setOppAttackAnimationPoint(double oppAttackAnimationPoint) {
        this.oppAttackAnimationPoint = oppAttackAnimationPoint;
    }

    public double getOppLastAttackTime() {
        return oppLastAttackTime;
    }

    public void setOppLastAttackTime(double oppLastAttackTime) {
        this.oppLastAttackTime = oppLastAttackTime;
    }

    public Double getOppAttackTarget() {
        return oppAttackTarget;
    }

    public void setOppAttackTarget(Object oppAttackTarget) {

        if(oppAttackTarget instanceof Integer){
            this.oppAttackTarget = new Double(((Integer)oppAttackTarget));
        }else{
            this.oppAttackTarget = ((Double)oppAttackTarget);
        }

    }

    public double getOppStrength() {
        return oppStrength;
    }

    public void setOppStrength(double oppStrength) {
        this.oppStrength = oppStrength;
    }

    public double getOppAgility() {
        return oppAgility;
    }

    public void setOppAgility(double oppAgility) {
        this.oppAgility = oppAgility;
    }

    public double getOppIntellect() {
        return oppIntellect;
    }

    public void setOppIntellect(double oppIntellect) {
        this.oppIntellect = oppIntellect;
    }

    public double getOppLocation1() {
        return oppLocation1;
    }

    public void setOppLocation1(double oppLocation1) {
        this.oppLocation1 = oppLocation1;
    }

    public double getOppLocation2() {
        return oppLocation2;
    }

    public void setOppLocation2(double oppLocation2) {
        this.oppLocation2 = oppLocation2;
    }

    public double getOppFacing() {
        return oppFacing;
    }

    public void setOppFacing(double oppFacing) {
        this.oppFacing = oppFacing;
    }

    public int getOppVisionRange() {
        return oppVisionRange;
    }

    public void setOppVisionRange(int oppVisionRange) {
        this.oppVisionRange = oppVisionRange;
    }

    public double getDotaTime() {
        return dotaTime;
    }

    public void setDotaTime(double dotaTime) {
        this.dotaTime = dotaTime;
    }

    public int getGoodTowerTeam() {
        return goodTowerTeam;
    }

    public void setGoodTowerTeam(int goodTowerTeam) {
        this.goodTowerTeam = goodTowerTeam;
    }

    public int getGoodTowerHealth() {
        return goodTowerHealth;
    }

    public void setGoodTowerHealth(int goodTowerHealth) {
        this.goodTowerHealth = goodTowerHealth;
    }

    public int getGoodTowerMaxHealth() {
        return goodTowerMaxHealth;
    }

    public void setGoodTowerMaxHealth(int goodTowerMaxHealth) {
        this.goodTowerMaxHealth = goodTowerMaxHealth;
    }

    public int getGoodTowerAttackDamage() {
        return goodTowerAttackDamage;
    }

    public void setGoodTowerAttackDamage(int goodTowerAttackDamage) {
        this.goodTowerAttackDamage = goodTowerAttackDamage;
    }

    public int getGoodTowerAttackRangeBuffer() {
        return goodTowerAttackRangeBuffer;
    }

    public void setGoodTowerAttackRangeBuffer(int goodTowerAttackRangeBuffer) {
        this.goodTowerAttackRangeBuffer = goodTowerAttackRangeBuffer;
    }

    public double getGoodTowerAttackSpeed() {
        return goodTowerAttackSpeed;
    }

    public void setGoodTowerAttackSpeed(double goodTowerAttackSpeed) {
        this.goodTowerAttackSpeed = goodTowerAttackSpeed;
    }

    public int getBadTowerTeam() {
        return badTowerTeam;
    }

    public void setBadTowerTeam(int badTowerTeam) {
        this.badTowerTeam = badTowerTeam;
    }

    public int getBadTowerHealth() {
        return badTowerHealth;
    }

    public void setBadTowerHealth(int badTowerHealth) {
        this.badTowerHealth = badTowerHealth;
    }

    public int getBadTowerMaxHealth() {
        return badTowerMaxHealth;
    }

    public void setBadTowerMaxHealth(int badTowerMaxHealth) {
        this.badTowerMaxHealth = badTowerMaxHealth;
    }

    public int getBadTowerAttackDamage() {
        return badTowerAttackDamage;
    }

    public void setBadTowerAttackDamage(int badTowerAttackDamage) {
        this.badTowerAttackDamage = badTowerAttackDamage;
    }

    public int getBadTowerAttackRangeBuffer() {
        return badTowerAttackRangeBuffer;
    }

    public void setBadTowerAttackRangeBuffer(int badTowerAttackRangeBuffer) {
        this.badTowerAttackRangeBuffer = badTowerAttackRangeBuffer;
    }

    public double getBadTowerAttackSpeed() {
        return badTowerAttackSpeed;
    }

    public void setBadTowerAttackSpeed(double badTowerAttackSpeed) {
        this.badTowerAttackSpeed = badTowerAttackSpeed;
    }

    public double getBounty1Location1() {
        return bounty1Location1;
    }

    public void setBounty1Location1(double bounty1Location1) {
        this.bounty1Location1 = bounty1Location1;
    }

    public double getBounty1Location2() {
        return bounty1Location2;
    }

    public void setBounty1Location2(double bounty1Location2) {
        this.bounty1Location2 = bounty1Location2;
    }

    public double getBounty2Location1() {
        return bounty2Location1;
    }

    public void setBounty2Location1(double bounty2Location1) {
        this.bounty2Location1 = bounty2Location1;
    }

    public double getBounty2Location2() {
        return bounty2Location2;
    }

    public void setBounty2Location2(double bounty2Location2) {
        this.bounty2Location2 = bounty2Location2;
    }

    public double getBounty3Location1() {
        return bounty3Location1;
    }

    public void setBounty3Location1(double bounty3Location1) {
        this.bounty3Location1 = bounty3Location1;
    }

    public double getBounty3Location2() {
        return bounty3Location2;
    }

    public void setBounty3Location2(double bounty3Location2) {
        this.bounty3Location2 = bounty3Location2;
    }

    public double getBounty4Location1() {
        return bounty4Location1;
    }

    public void setBounty4Location1(double bounty4Location1) {
        this.bounty4Location1 = bounty4Location1;
    }

    public double getBounty4Location2() {
        return bounty4Location2;
    }

    public void setBounty4Location2(double bounty4Location2) {
        this.bounty4Location2 = bounty4Location2;
    }

    public double getPower1Location1() {
        return power1Location1;
    }

    public void setPower1Location1(double power1Location1) {
        this.power1Location1 = power1Location1;
    }

    public double getPower1Location2() {
        return power1Location2;
    }

    public void setPower1Location2(double power1Location2) {
        this.power1Location2 = power1Location2;
    }

    public double getPower2Location1() {
        return power2Location1;
    }

    public void setPower2Location1(double power2Location1) {
        this.power2Location1 = power2Location1;
    }

    public double getPower2Location2() {
        return power2Location2;
    }

    public void setPower2Location2(double power2Location2) {
        this.power2Location2 = power2Location2;
    }

    public int getPower1Type() {
        return power1Type;
    }

    public void setPower1Type(int power1Type) {
        this.power1Type = power1Type;
    }

    public int getPower1Status() {
        return power1Status;
    }

    public void setPower1Status(int power1Status) {
        this.power1Status = power1Status;
    }

    public int getPower2Type() {
        return power2Type;
    }

    public void setPower2Type(int power2Type) {
        this.power2Type = power2Type;
    }

    public int getPower2Status() {
        return power2Status;
    }

    public void setPower2Status(int power2Status) {
        this.power2Status = power2Status;
    }

    public int getGoodCreep1Team() {
        return goodCreep1Team;
    }

    public void setGoodCreep1Team(int goodCreep1Team) {
        this.goodCreep1Team = goodCreep1Team;
    }

    public int getGoodCreep1Health() {
        return goodCreep1Health;
    }

    public void setGoodCreep1Health(int goodCreep1Health) {
        this.goodCreep1Health = goodCreep1Health;
    }

    public int getGoodCreep1MaxHealth() {
        return goodCreep1MaxHealth;
    }

    public void setGoodCreep1MaxHealth(int goodCreep1MaxHealth) {
        this.goodCreep1MaxHealth = goodCreep1MaxHealth;
    }

    public double getGoodCreep1HealthRegen() {
        return goodCreep1HealthRegen;
    }

    public void setGoodCreep1HealthRegen(double goodCreep1HealthRegen) {
        this.goodCreep1HealthRegen = goodCreep1HealthRegen;
    }

    public int getGoodCreep1BaseMoveSpeed() {
        return goodCreep1BaseMoveSpeed;
    }

    public void setGoodCreep1BaseMoveSpeed(int goodCreep1BaseMoveSpeed) {
        this.goodCreep1BaseMoveSpeed = goodCreep1BaseMoveSpeed;
    }

    public int getGoodCreep1CurrentMoveSpeed() {
        return goodCreep1CurrentMoveSpeed;
    }

    public void setGoodCreep1CurrentMoveSpeed(int goodCreep1CurrentMoveSpeed) {
        this.goodCreep1CurrentMoveSpeed = goodCreep1CurrentMoveSpeed;
    }

    public int getGoodCreep1BaseDamage() {
        return goodCreep1BaseDamage;
    }

    public void setGoodCreep1BaseDamage(int goodCreep1BaseDamage) {
        this.goodCreep1BaseDamage = goodCreep1BaseDamage;
    }

    public int getGoodCreep1DamageVariance() {
        return goodCreep1DamageVariance;
    }

    public void setGoodCreep1DamageVariance(int goodCreep1DamageVariance) {
        this.goodCreep1DamageVariance = goodCreep1DamageVariance;
    }

    public int getGoodCreep1AttackDamage() {
        return goodCreep1AttackDamage;
    }

    public void setGoodCreep1AttackDamage(int goodCreep1AttackDamage) {
        this.goodCreep1AttackDamage = goodCreep1AttackDamage;
    }

    public double getGoodCreep1AttackSpeed() {
        return goodCreep1AttackSpeed;
    }

    public void setGoodCreep1AttackSpeed(double goodCreep1AttackSpeed) {
        this.goodCreep1AttackSpeed = goodCreep1AttackSpeed;
    }

    public double getGoodCreep1SecondsPerAttack() {
        return goodCreep1SecondsPerAttack;
    }

    public void setGoodCreep1SecondsPerAttack(double goodCreep1SecondsPerAttack) {
        this.goodCreep1SecondsPerAttack = goodCreep1SecondsPerAttack;
    }

    public double getGoodCreep1Location1() {
        return goodCreep1Location1;
    }

    public void setGoodCreep1Location1(double goodCreep1Location1) {
        this.goodCreep1Location1 = goodCreep1Location1;
    }

    public double getGoodCreep1Location2() {
        return goodCreep1Location2;
    }

    public void setGoodCreep1Location2(double goodCreep1Location2) {
        this.goodCreep1Location2 = goodCreep1Location2;
    }

    public int getGoodCreep2Team() {
        return goodCreep2Team;
    }

    public void setGoodCreep2Team(int goodCreep2Team) {
        this.goodCreep2Team = goodCreep2Team;
    }

    public int getGoodCreep2Health() {
        return goodCreep2Health;
    }

    public void setGoodCreep2Health(int goodCreep2Health) {
        this.goodCreep2Health = goodCreep2Health;
    }

    public int getGoodCreep2MaxHealth() {
        return goodCreep2MaxHealth;
    }

    public void setGoodCreep2MaxHealth(int goodCreep2MaxHealth) {
        this.goodCreep2MaxHealth = goodCreep2MaxHealth;
    }

    public double getGoodCreep2HealthRegen() {
        return goodCreep2HealthRegen;
    }

    public void setGoodCreep2HealthRegen(double goodCreep2HealthRegen) {
        this.goodCreep2HealthRegen = goodCreep2HealthRegen;
    }

    public int getGoodCreep2BaseMoveSpeed() {
        return goodCreep2BaseMoveSpeed;
    }

    public void setGoodCreep2BaseMoveSpeed(int goodCreep2BaseMoveSpeed) {
        this.goodCreep2BaseMoveSpeed = goodCreep2BaseMoveSpeed;
    }

    public int getGoodCreep2CurrentMoveSpeed() {
        return goodCreep2CurrentMoveSpeed;
    }

    public void setGoodCreep2CurrentMoveSpeed(int goodCreep2CurrentMoveSpeed) {
        this.goodCreep2CurrentMoveSpeed = goodCreep2CurrentMoveSpeed;
    }

    public int getGoodCreep2BaseDamage() {
        return goodCreep2BaseDamage;
    }

    public void setGoodCreep2BaseDamage(int goodCreep2BaseDamage) {
        this.goodCreep2BaseDamage = goodCreep2BaseDamage;
    }

    public int getGoodCreep2DamageVariance() {
        return goodCreep2DamageVariance;
    }

    public void setGoodCreep2DamageVariance(int goodCreep2DamageVariance) {
        this.goodCreep2DamageVariance = goodCreep2DamageVariance;
    }

    public int getGoodCreep2AttackDamage() {
        return goodCreep2AttackDamage;
    }

    public void setGoodCreep2AttackDamage(int goodCreep2AttackDamage) {
        this.goodCreep2AttackDamage = goodCreep2AttackDamage;
    }

    public double getGoodCreep2AttackSpeed() {
        return goodCreep2AttackSpeed;
    }

    public void setGoodCreep2AttackSpeed(double goodCreep2AttackSpeed) {
        this.goodCreep2AttackSpeed = goodCreep2AttackSpeed;
    }

    public double getGoodCreep2SecondsPerAttack() {
        return goodCreep2SecondsPerAttack;
    }

    public void setGoodCreep2SecondsPerAttack(double goodCreep2SecondsPerAttack) {
        this.goodCreep2SecondsPerAttack = goodCreep2SecondsPerAttack;
    }

    public double getGoodCreep2Location1() {
        return goodCreep2Location1;
    }

    public void setGoodCreep2Location1(double goodCreep2Location1) {
        this.goodCreep2Location1 = goodCreep2Location1;
    }

    public double getGoodCreep2Location2() {
        return goodCreep2Location2;
    }

    public void setGoodCreep2Location2(double goodCreep2Location2) {
        this.goodCreep2Location2 = goodCreep2Location2;
    }

    public int getGoodCreep3Team() {
        return goodCreep3Team;
    }

    public void setGoodCreep3Team(int goodCreep3Team) {
        this.goodCreep3Team = goodCreep3Team;
    }

    public int getGoodCreep3Health() {
        return goodCreep3Health;
    }

    public void setGoodCreep3Health(int goodCreep3Health) {
        this.goodCreep3Health = goodCreep3Health;
    }

    public int getGoodCreep3MaxHealth() {
        return goodCreep3MaxHealth;
    }

    public void setGoodCreep3MaxHealth(int goodCreep3MaxHealth) {
        this.goodCreep3MaxHealth = goodCreep3MaxHealth;
    }

    public double getGoodCreep3HealthRegen() {
        return goodCreep3HealthRegen;
    }

    public void setGoodCreep3HealthRegen(double goodCreep3HealthRegen) {
        this.goodCreep3HealthRegen = goodCreep3HealthRegen;
    }

    public int getGoodCreep3BaseMoveSpeed() {
        return goodCreep3BaseMoveSpeed;
    }

    public void setGoodCreep3BaseMoveSpeed(int goodCreep3BaseMoveSpeed) {
        this.goodCreep3BaseMoveSpeed = goodCreep3BaseMoveSpeed;
    }

    public int getGoodCreep3CurrentMoveSpeed() {
        return goodCreep3CurrentMoveSpeed;
    }

    public void setGoodCreep3CurrentMoveSpeed(int goodCreep3CurrentMoveSpeed) {
        this.goodCreep3CurrentMoveSpeed = goodCreep3CurrentMoveSpeed;
    }

    public int getGoodCreep3BaseDamage() {
        return goodCreep3BaseDamage;
    }

    public void setGoodCreep3BaseDamage(int goodCreep3BaseDamage) {
        this.goodCreep3BaseDamage = goodCreep3BaseDamage;
    }

    public int getGoodCreep3DamageVariance() {
        return goodCreep3DamageVariance;
    }

    public void setGoodCreep3DamageVariance(int goodCreep3DamageVariance) {
        this.goodCreep3DamageVariance = goodCreep3DamageVariance;
    }

    public int getGoodCreep3AttackDamage() {
        return goodCreep3AttackDamage;
    }

    public void setGoodCreep3AttackDamage(int goodCreep3AttackDamage) {
        this.goodCreep3AttackDamage = goodCreep3AttackDamage;
    }

    public double getGoodCreep3AttackSpeed() {
        return goodCreep3AttackSpeed;
    }

    public void setGoodCreep3AttackSpeed(double goodCreep3AttackSpeed) {
        this.goodCreep3AttackSpeed = goodCreep3AttackSpeed;
    }

    public double getGoodCreep3SecondsPerAttack() {
        return goodCreep3SecondsPerAttack;
    }

    public void setGoodCreep3SecondsPerAttack(double goodCreep3SecondsPerAttack) {
        this.goodCreep3SecondsPerAttack = goodCreep3SecondsPerAttack;
    }

    public double getGoodCreep3Location1() {
        return goodCreep3Location1;
    }

    public void setGoodCreep3Location1(double goodCreep3Location1) {
        this.goodCreep3Location1 = goodCreep3Location1;
    }

    public double getGoodCreep3Location2() {
        return goodCreep3Location2;
    }

    public void setGoodCreep3Location2(double goodCreep3Location2) {
        this.goodCreep3Location2 = goodCreep3Location2;
    }

    public int getGoodCreep4Team() {
        return goodCreep4Team;
    }

    public void setGoodCreep4Team(int goodCreep4Team) {
        this.goodCreep4Team = goodCreep4Team;
    }

    public int getGoodCreep4Health() {
        return goodCreep4Health;
    }

    public void setGoodCreep4Health(int goodCreep4Health) {
        this.goodCreep4Health = goodCreep4Health;
    }

    public int getGoodCreep4MaxHealth() {
        return goodCreep4MaxHealth;
    }

    public void setGoodCreep4MaxHealth(int goodCreep4MaxHealth) {
        this.goodCreep4MaxHealth = goodCreep4MaxHealth;
    }

    public double getGoodCreep4HealthRegen() {
        return goodCreep4HealthRegen;
    }

    public void setGoodCreep4HealthRegen(double goodCreep4HealthRegen) {
        this.goodCreep4HealthRegen = goodCreep4HealthRegen;
    }

    public int getGoodCreep4BaseMoveSpeed() {
        return goodCreep4BaseMoveSpeed;
    }

    public void setGoodCreep4BaseMoveSpeed(int goodCreep4BaseMoveSpeed) {
        this.goodCreep4BaseMoveSpeed = goodCreep4BaseMoveSpeed;
    }

    public int getGoodCreep4CurrentMoveSpeed() {
        return goodCreep4CurrentMoveSpeed;
    }

    public void setGoodCreep4CurrentMoveSpeed(int goodCreep4CurrentMoveSpeed) {
        this.goodCreep4CurrentMoveSpeed = goodCreep4CurrentMoveSpeed;
    }

    public int getGoodCreep4BaseDamage() {
        return goodCreep4BaseDamage;
    }

    public void setGoodCreep4BaseDamage(int goodCreep4BaseDamage) {
        this.goodCreep4BaseDamage = goodCreep4BaseDamage;
    }

    public int getGoodCreep4DamageVariance() {
        return goodCreep4DamageVariance;
    }

    public void setGoodCreep4DamageVariance(int goodCreep4DamageVariance) {
        this.goodCreep4DamageVariance = goodCreep4DamageVariance;
    }

    public int getGoodCreep4AttackDamage() {
        return goodCreep4AttackDamage;
    }

    public void setGoodCreep4AttackDamage(int goodCreep4AttackDamage) {
        this.goodCreep4AttackDamage = goodCreep4AttackDamage;
    }

    public double getGoodCreep4AttackSpeed() {
        return goodCreep4AttackSpeed;
    }

    public void setGoodCreep4AttackSpeed(double goodCreep4AttackSpeed) {
        this.goodCreep4AttackSpeed = goodCreep4AttackSpeed;
    }

    public double getGoodCreep4SecondsPerAttack() {
        return goodCreep4SecondsPerAttack;
    }

    public void setGoodCreep4SecondsPerAttack(double goodCreep4SecondsPerAttack) {
        this.goodCreep4SecondsPerAttack = goodCreep4SecondsPerAttack;
    }

    public double getGoodCreep4Location1() {
        return goodCreep4Location1;
    }

    public void setGoodCreep4Location1(double goodCreep4Location1) {
        this.goodCreep4Location1 = goodCreep4Location1;
    }

    public double getGoodCreep4Location2() {
        return goodCreep4Location2;
    }

    public void setGoodCreep4Location2(double goodCreep4Location2) {
        this.goodCreep4Location2 = goodCreep4Location2;
    }

    public int getGoodCreep5Team() {
        return goodCreep5Team;
    }

    public void setGoodCreep5Team(int goodCreep5Team) {
        this.goodCreep5Team = goodCreep5Team;
    }

    public int getGoodCreep5Health() {
        return goodCreep5Health;
    }

    public void setGoodCreep5Health(int goodCreep5Health) {
        this.goodCreep5Health = goodCreep5Health;
    }

    public int getGoodCreep5MaxHealth() {
        return goodCreep5MaxHealth;
    }

    public void setGoodCreep5MaxHealth(int goodCreep5MaxHealth) {
        this.goodCreep5MaxHealth = goodCreep5MaxHealth;
    }

    public double getGoodCreep5HealthRegen() {
        return goodCreep5HealthRegen;
    }

    public void setGoodCreep5HealthRegen(double goodCreep5HealthRegen) {
        this.goodCreep5HealthRegen = goodCreep5HealthRegen;
    }

    public int getGoodCreep5BaseMoveSpeed() {
        return goodCreep5BaseMoveSpeed;
    }

    public void setGoodCreep5BaseMoveSpeed(int goodCreep5BaseMoveSpeed) {
        this.goodCreep5BaseMoveSpeed = goodCreep5BaseMoveSpeed;
    }

    public int getGoodCreep5CurrentMoveSpeed() {
        return goodCreep5CurrentMoveSpeed;
    }

    public void setGoodCreep5CurrentMoveSpeed(int goodCreep5CurrentMoveSpeed) {
        this.goodCreep5CurrentMoveSpeed = goodCreep5CurrentMoveSpeed;
    }

    public int getGoodCreep5BaseDamage() {
        return goodCreep5BaseDamage;
    }

    public void setGoodCreep5BaseDamage(int goodCreep5BaseDamage) {
        this.goodCreep5BaseDamage = goodCreep5BaseDamage;
    }

    public int getGoodCreep5DamageVariance() {
        return goodCreep5DamageVariance;
    }

    public void setGoodCreep5DamageVariance(int goodCreep5DamageVariance) {
        this.goodCreep5DamageVariance = goodCreep5DamageVariance;
    }

    public int getGoodCreep5AttackDamage() {
        return goodCreep5AttackDamage;
    }

    public void setGoodCreep5AttackDamage(int goodCreep5AttackDamage) {
        this.goodCreep5AttackDamage = goodCreep5AttackDamage;
    }

    public double getGoodCreep5AttackSpeed() {
        return goodCreep5AttackSpeed;
    }

    public void setGoodCreep5AttackSpeed(double goodCreep5AttackSpeed) {
        this.goodCreep5AttackSpeed = goodCreep5AttackSpeed;
    }

    public double getGoodCreep5SecondsPerAttack() {
        return goodCreep5SecondsPerAttack;
    }

    public void setGoodCreep5SecondsPerAttack(double goodCreep5SecondsPerAttack) {
        this.goodCreep5SecondsPerAttack = goodCreep5SecondsPerAttack;
    }

    public double getGoodCreep5Location1() {
        return goodCreep5Location1;
    }

    public void setGoodCreep5Location1(double goodCreep5Location1) {
        this.goodCreep5Location1 = goodCreep5Location1;
    }

    public double getGoodCreep5Location2() {
        return goodCreep5Location2;
    }

    public void setGoodCreep5Location2(double goodCreep5Location2) {
        this.goodCreep5Location2 = goodCreep5Location2;
    }

    public int getBadCreep1Team() {
        return badCreep1Team;
    }

    public void setBadCreep1Team(int badCreep1Team) {
        this.badCreep1Team = badCreep1Team;
    }

    public int getBadCreep1Health() {
        return badCreep1Health;
    }

    public void setBadCreep1Health(int badCreep1Health) {
        this.badCreep1Health = badCreep1Health;
    }

    public int getBadCreep1MaxHealth() {
        return badCreep1MaxHealth;
    }

    public void setBadCreep1MaxHealth(int badCreep1MaxHealth) {
        this.badCreep1MaxHealth = badCreep1MaxHealth;
    }

    public double getBadCreep1HealthRegen() {
        return badCreep1HealthRegen;
    }

    public void setBadCreep1HealthRegen(double badCreep1HealthRegen) {
        this.badCreep1HealthRegen = badCreep1HealthRegen;
    }

    public int getBadCreep1BaseMoveSpeed() {
        return badCreep1BaseMoveSpeed;
    }

    public void setBadCreep1BaseMoveSpeed(int badCreep1BaseMoveSpeed) {
        this.badCreep1BaseMoveSpeed = badCreep1BaseMoveSpeed;
    }

    public int getBadCreep1CurrentMoveSpeed() {
        return badCreep1CurrentMoveSpeed;
    }

    public void setBadCreep1CurrentMoveSpeed(int badCreep1CurrentMoveSpeed) {
        this.badCreep1CurrentMoveSpeed = badCreep1CurrentMoveSpeed;
    }

    public int getBadCreep1BaseDamage() {
        return badCreep1BaseDamage;
    }

    public void setBadCreep1BaseDamage(int badCreep1BaseDamage) {
        this.badCreep1BaseDamage = badCreep1BaseDamage;
    }

    public int getBadCreep1DamageVariance() {
        return badCreep1DamageVariance;
    }

    public void setBadCreep1DamageVariance(int badCreep1DamageVariance) {
        this.badCreep1DamageVariance = badCreep1DamageVariance;
    }

    public int getBadCreep1AttackDamage() {
        return badCreep1AttackDamage;
    }

    public void setBadCreep1AttackDamage(int badCreep1AttackDamage) {
        this.badCreep1AttackDamage = badCreep1AttackDamage;
    }

    public double getBadCreep1AttackSpeed() {
        return badCreep1AttackSpeed;
    }

    public void setBadCreep1AttackSpeed(double badCreep1AttackSpeed) {
        this.badCreep1AttackSpeed = badCreep1AttackSpeed;
    }

    public double getBadCreep1SecondsPerAttack() {
        return badCreep1SecondsPerAttack;
    }

    public void setBadCreep1SecondsPerAttack(double badCreep1SecondsPerAttack) {
        this.badCreep1SecondsPerAttack = badCreep1SecondsPerAttack;
    }

    public double getBadCreep1Location1() {
        return badCreep1Location1;
    }

    public void setBadCreep1Location1(double badCreep1Location1) {
        this.badCreep1Location1 = badCreep1Location1;
    }

    public double getBadCreep1Location2() {
        return badCreep1Location2;
    }

    public void setBadCreep1Location2(double badCreep1Location2) {
        this.badCreep1Location2 = badCreep1Location2;
    }

    public int getBadCreep2Team() {
        return badCreep2Team;
    }

    public void setBadCreep2Team(int badCreep2Team) {
        this.badCreep2Team = badCreep2Team;
    }

    public int getBadCreep2Health() {
        return badCreep2Health;
    }

    public void setBadCreep2Health(int badCreep2Health) {
        this.badCreep2Health = badCreep2Health;
    }

    public int getBadCreep2MaxHealth() {
        return badCreep2MaxHealth;
    }

    public void setBadCreep2MaxHealth(int badCreep2MaxHealth) {
        this.badCreep2MaxHealth = badCreep2MaxHealth;
    }

    public double getBadCreep2HealthRegen() {
        return badCreep2HealthRegen;
    }

    public void setBadCreep2HealthRegen(double badCreep2HealthRegen) {
        this.badCreep2HealthRegen = badCreep2HealthRegen;
    }

    public int getBadCreep2BaseMoveSpeed() {
        return badCreep2BaseMoveSpeed;
    }

    public void setBadCreep2BaseMoveSpeed(int badCreep2BaseMoveSpeed) {
        this.badCreep2BaseMoveSpeed = badCreep2BaseMoveSpeed;
    }

    public int getBadCreep2CurrentMoveSpeed() {
        return badCreep2CurrentMoveSpeed;
    }

    public void setBadCreep2CurrentMoveSpeed(int badCreep2CurrentMoveSpeed) {
        this.badCreep2CurrentMoveSpeed = badCreep2CurrentMoveSpeed;
    }

    public int getBadCreep2BaseDamage() {
        return badCreep2BaseDamage;
    }

    public void setBadCreep2BaseDamage(int badCreep2BaseDamage) {
        this.badCreep2BaseDamage = badCreep2BaseDamage;
    }

    public int getBadCreep2DamageVariance() {
        return badCreep2DamageVariance;
    }

    public void setBadCreep2DamageVariance(int badCreep2DamageVariance) {
        this.badCreep2DamageVariance = badCreep2DamageVariance;
    }

    public int getBadCreep2AttackDamage() {
        return badCreep2AttackDamage;
    }

    public void setBadCreep2AttackDamage(int badCreep2AttackDamage) {
        this.badCreep2AttackDamage = badCreep2AttackDamage;
    }

    public double getBadCreep2AttackSpeed() {
        return badCreep2AttackSpeed;
    }

    public void setBadCreep2AttackSpeed(double badCreep2AttackSpeed) {
        this.badCreep2AttackSpeed = badCreep2AttackSpeed;
    }

    public double getBadCreep2SecondsPerAttack() {
        return badCreep2SecondsPerAttack;
    }

    public void setBadCreep2SecondsPerAttack(double badCreep2SecondsPerAttack) {
        this.badCreep2SecondsPerAttack = badCreep2SecondsPerAttack;
    }

    public double getBadCreep2Location1() {
        return badCreep2Location1;
    }

    public void setBadCreep2Location1(double badCreep2Location1) {
        this.badCreep2Location1 = badCreep2Location1;
    }

    public double getBadCreep2Location2() {
        return badCreep2Location2;
    }

    public void setBadCreep2Location2(double badCreep2Location2) {
        this.badCreep2Location2 = badCreep2Location2;
    }

    public int getBadCreep3Team() {
        return badCreep3Team;
    }

    public void setBadCreep3Team(int badCreep3Team) {
        this.badCreep3Team = badCreep3Team;
    }

    public int getBadCreep3Health() {
        return badCreep3Health;
    }

    public void setBadCreep3Health(int badCreep3Health) {
        this.badCreep3Health = badCreep3Health;
    }

    public int getBadCreep3MaxHealth() {
        return badCreep3MaxHealth;
    }

    public void setBadCreep3MaxHealth(int badCreep3MaxHealth) {
        this.badCreep3MaxHealth = badCreep3MaxHealth;
    }

    public double getBadCreep3HealthRegen() {
        return badCreep3HealthRegen;
    }

    public void setBadCreep3HealthRegen(double badCreep3HealthRegen) {
        this.badCreep3HealthRegen = badCreep3HealthRegen;
    }

    public int getBadCreep3BaseMoveSpeed() {
        return badCreep3BaseMoveSpeed;
    }

    public void setBadCreep3BaseMoveSpeed(int badCreep3BaseMoveSpeed) {
        this.badCreep3BaseMoveSpeed = badCreep3BaseMoveSpeed;
    }

    public int getBadCreep3CurrentMoveSpeed() {
        return badCreep3CurrentMoveSpeed;
    }

    public void setBadCreep3CurrentMoveSpeed(int badCreep3CurrentMoveSpeed) {
        this.badCreep3CurrentMoveSpeed = badCreep3CurrentMoveSpeed;
    }

    public int getBadCreep3BaseDamage() {
        return badCreep3BaseDamage;
    }

    public void setBadCreep3BaseDamage(int badCreep3BaseDamage) {
        this.badCreep3BaseDamage = badCreep3BaseDamage;
    }

    public int getBadCreep3DamageVariance() {
        return badCreep3DamageVariance;
    }

    public void setBadCreep3DamageVariance(int badCreep3DamageVariance) {
        this.badCreep3DamageVariance = badCreep3DamageVariance;
    }

    public int getBadCreep3AttackDamage() {
        return badCreep3AttackDamage;
    }

    public void setBadCreep3AttackDamage(int badCreep3AttackDamage) {
        this.badCreep3AttackDamage = badCreep3AttackDamage;
    }

    public double getBadCreep3AttackSpeed() {
        return badCreep3AttackSpeed;
    }

    public void setBadCreep3AttackSpeed(double badCreep3AttackSpeed) {
        this.badCreep3AttackSpeed = badCreep3AttackSpeed;
    }

    public double getBadCreep3SecondsPerAttack() {
        return badCreep3SecondsPerAttack;
    }

    public void setBadCreep3SecondsPerAttack(double badCreep3SecondsPerAttack) {
        this.badCreep3SecondsPerAttack = badCreep3SecondsPerAttack;
    }

    public double getBadCreep3Location1() {
        return badCreep3Location1;
    }

    public void setBadCreep3Location1(double badCreep3Location1) {
        this.badCreep3Location1 = badCreep3Location1;
    }

    public double getBadCreep3Location2() {
        return badCreep3Location2;
    }

    public void setBadCreep3Location2(double badCreep3Location2) {
        this.badCreep3Location2 = badCreep3Location2;
    }

    public int getBadCreep4Team() {
        return badCreep4Team;
    }

    public void setBadCreep4Team(int badCreep4Team) {
        this.badCreep4Team = badCreep4Team;
    }

    public int getBadCreep4Health() {
        return badCreep4Health;
    }

    public void setBadCreep4Health(int badCreep4Health) {
        this.badCreep4Health = badCreep4Health;
    }

    public int getBadCreep4MaxHealth() {
        return badCreep4MaxHealth;
    }

    public void setBadCreep4MaxHealth(int badCreep4MaxHealth) {
        this.badCreep4MaxHealth = badCreep4MaxHealth;
    }

    public double getBadCreep4HealthRegen() {
        return badCreep4HealthRegen;
    }

    public void setBadCreep4HealthRegen(double badCreep4HealthRegen) {
        this.badCreep4HealthRegen = badCreep4HealthRegen;
    }

    public int getBadCreep4BaseMoveSpeed() {
        return badCreep4BaseMoveSpeed;
    }

    public void setBadCreep4BaseMoveSpeed(int badCreep4BaseMoveSpeed) {
        this.badCreep4BaseMoveSpeed = badCreep4BaseMoveSpeed;
    }

    public int getBadCreep4CurrentMoveSpeed() {
        return badCreep4CurrentMoveSpeed;
    }

    public void setBadCreep4CurrentMoveSpeed(int badCreep4CurrentMoveSpeed) {
        this.badCreep4CurrentMoveSpeed = badCreep4CurrentMoveSpeed;
    }

    public int getBadCreep4BaseDamage() {
        return badCreep4BaseDamage;
    }

    public void setBadCreep4BaseDamage(int badCreep4BaseDamage) {
        this.badCreep4BaseDamage = badCreep4BaseDamage;
    }

    public int getBadCreep4DamageVariance() {
        return badCreep4DamageVariance;
    }

    public void setBadCreep4DamageVariance(int badCreep4DamageVariance) {
        this.badCreep4DamageVariance = badCreep4DamageVariance;
    }

    public int getBadCreep4AttackDamage() {
        return badCreep4AttackDamage;
    }

    public void setBadCreep4AttackDamage(int badCreep4AttackDamage) {
        this.badCreep4AttackDamage = badCreep4AttackDamage;
    }

    public double getBadCreep4AttackSpeed() {
        return badCreep4AttackSpeed;
    }

    public void setBadCreep4AttackSpeed(double badCreep4AttackSpeed) {
        this.badCreep4AttackSpeed = badCreep4AttackSpeed;
    }

    public double getBadCreep4SecondsPerAttack() {
        return badCreep4SecondsPerAttack;
    }

    public void setBadCreep4SecondsPerAttack(double badCreep4SecondsPerAttack) {
        this.badCreep4SecondsPerAttack = badCreep4SecondsPerAttack;
    }

    public double getBadCreep4Location1() {
        return badCreep4Location1;
    }

    public void setBadCreep4Location1(double badCreep4Location1) {
        this.badCreep4Location1 = badCreep4Location1;
    }

    public double getBadCreep4Location2() {
        return badCreep4Location2;
    }

    public void setBadCreep4Location2(double badCreep4Location2) {
        this.badCreep4Location2 = badCreep4Location2;
    }

    public int getBadCreep5Team() {
        return badCreep5Team;
    }

    public void setBadCreep5Team(int badCreep5Team) {
        this.badCreep5Team = badCreep5Team;
    }

    public int getBadCreep5Health() {
        return badCreep5Health;
    }

    public void setBadCreep5Health(int badCreep5Health) {
        this.badCreep5Health = badCreep5Health;
    }

    public int getBadCreep5MaxHealth() {
        return badCreep5MaxHealth;
    }

    public void setBadCreep5MaxHealth(int badCreep5MaxHealth) {
        this.badCreep5MaxHealth = badCreep5MaxHealth;
    }

    public double getBadCreep5HealthRegen() {
        return badCreep5HealthRegen;
    }

    public void setBadCreep5HealthRegen(double badCreep5HealthRegen) {
        this.badCreep5HealthRegen = badCreep5HealthRegen;
    }

    public int getBadCreep5BaseMoveSpeed() {
        return badCreep5BaseMoveSpeed;
    }

    public void setBadCreep5BaseMoveSpeed(int badCreep5BaseMoveSpeed) {
        this.badCreep5BaseMoveSpeed = badCreep5BaseMoveSpeed;
    }

    public int getBadCreep5CurrentMoveSpeed() {
        return badCreep5CurrentMoveSpeed;
    }

    public void setBadCreep5CurrentMoveSpeed(int badCreep5CurrentMoveSpeed) {
        this.badCreep5CurrentMoveSpeed = badCreep5CurrentMoveSpeed;
    }

    public int getBadCreep5BaseDamage() {
        return badCreep5BaseDamage;
    }

    public void setBadCreep5BaseDamage(int badCreep5BaseDamage) {
        this.badCreep5BaseDamage = badCreep5BaseDamage;
    }

    public int getBadCreep5DamageVariance() {
        return badCreep5DamageVariance;
    }

    public void setBadCreep5DamageVariance(int badCreep5DamageVariance) {
        this.badCreep5DamageVariance = badCreep5DamageVariance;
    }

    public int getBadCreep5AttackDamage() {
        return badCreep5AttackDamage;
    }

    public void setBadCreep5AttackDamage(int badCreep5AttackDamage) {
        this.badCreep5AttackDamage = badCreep5AttackDamage;
    }

    public double getBadCreep5AttackSpeed() {
        return badCreep5AttackSpeed;
    }

    public void setBadCreep5AttackSpeed(double badCreep5AttackSpeed) {
        this.badCreep5AttackSpeed = badCreep5AttackSpeed;
    }

    public double getBadCreep5SecondsPerAttack() {
        return badCreep5SecondsPerAttack;
    }

    public void setBadCreep5SecondsPerAttack(double badCreep5SecondsPerAttack) {
        this.badCreep5SecondsPerAttack = badCreep5SecondsPerAttack;
    }

    public double getBadCreep5Location1() {
        return badCreep5Location1;
    }

    public void setBadCreep5Location1(double badCreep5Location1) {
        this.badCreep5Location1 = badCreep5Location1;
    }

    public double getBadCreep5Location2() {
        return badCreep5Location2;
    }

    public void setBadCreep5Location2(double badCreep5Location2) {
        this.badCreep5Location2 = badCreep5Location2;
    }

    public int getAbility1Level() {
        return ability1Level;
    }

    public void setAbility1Level(int ability1Level) {
        this.ability1Level = ability1Level;
    }

    public int getAbility1ManaCost() {
        return ability1ManaCost;
    }

    public void setAbility1ManaCost(int ability1ManaCost) {
        this.ability1ManaCost = ability1ManaCost;
    }

    public int getAbility1AbilityDamage() {
        return ability1AbilityDamage;
    }

    public void setAbility1AbilityDamage(int ability1AbilityDamage) {
        this.ability1AbilityDamage = ability1AbilityDamage;
    }

    public int getAbility1CastRange() {
        return ability1CastRange;
    }

    public void setAbility1CastRange(int ability1CastRange) {
        this.ability1CastRange = ability1CastRange;
    }

    public int getAbility1TargetType() {
        return ability1TargetType;
    }

    public void setAbility1TargetType(int ability1TargetType) {
        this.ability1TargetType = ability1TargetType;
    }

    public int getAbility1Behavior() {
        return ability1Behavior;
    }

    public void setAbility1Behavior(int ability1Behavior) {
        this.ability1Behavior = ability1Behavior;
    }

    public int getAbility2Level() {
        return ability2Level;
    }

    public void setAbility2Level(int ability2Level) {
        this.ability2Level = ability2Level;
    }

    public int getAbility2ManaCost() {
        return ability2ManaCost;
    }

    public void setAbility2ManaCost(int ability2ManaCost) {
        this.ability2ManaCost = ability2ManaCost;
    }

    public int getAbility2AbilityDamage() {
        return ability2AbilityDamage;
    }

    public void setAbility2AbilityDamage(int ability2AbilityDamage) {
        this.ability2AbilityDamage = ability2AbilityDamage;
    }

    public int getAbility2CastRange() {
        return ability2CastRange;
    }

    public void setAbility2CastRange(int ability2CastRange) {
        this.ability2CastRange = ability2CastRange;
    }

    public int getAbility2TargetType() {
        return ability2TargetType;
    }

    public void setAbility2TargetType(int ability2TargetType) {
        this.ability2TargetType = ability2TargetType;
    }

    public int getAbility2Behavior() {
        return ability2Behavior;
    }

    public void setAbility2Behavior(int ability2Behavior) {
        this.ability2Behavior = ability2Behavior;
    }

    public int getAbility3Level() {
        return ability3Level;
    }

    public void setAbility3Level(int ability3Level) {
        this.ability3Level = ability3Level;
    }

    public int getAbility3ManaCost() {
        return ability3ManaCost;
    }

    public void setAbility3ManaCost(int ability3ManaCost) {
        this.ability3ManaCost = ability3ManaCost;
    }

    public int getAbility3AbilityDamage() {
        return ability3AbilityDamage;
    }

    public void setAbility3AbilityDamage(int ability3AbilityDamage) {
        this.ability3AbilityDamage = ability3AbilityDamage;
    }

    public int getAbility3CastRange() {
        return ability3CastRange;
    }

    public void setAbility3CastRange(int ability3CastRange) {
        this.ability3CastRange = ability3CastRange;
    }

    public int getAbility3TargetType() {
        return ability3TargetType;
    }

    public void setAbility3TargetType(int ability3TargetType) {
        this.ability3TargetType = ability3TargetType;
    }

    public int getAbility3Behavior() {
        return ability3Behavior;
    }

    public void setAbility3Behavior(int ability3Behavior) {
        this.ability3Behavior = ability3Behavior;
    }

    public int getAbility4Level() {
        return ability4Level;
    }

    public void setAbility4Level(int ability4Level) {
        this.ability4Level = ability4Level;
    }

    public int getAbility4ManaCost() {
        return ability4ManaCost;
    }

    public void setAbility4ManaCost(int ability4ManaCost) {
        this.ability4ManaCost = ability4ManaCost;
    }

    public int getAbility4AbilityDamage() {
        return ability4AbilityDamage;
    }

    public void setAbility4AbilityDamage(int ability4AbilityDamage) {
        this.ability4AbilityDamage = ability4AbilityDamage;
    }

    public int getAbility4CastRange() {
        return ability4CastRange;
    }

    public void setAbility4CastRange(int ability4CastRange) {
        this.ability4CastRange = ability4CastRange;
    }

    public int getAbility4TargetType() {
        return ability4TargetType;
    }

    public void setAbility4TargetType(int ability4TargetType) {
        this.ability4TargetType = ability4TargetType;
    }

    public int getAbility4Behavior() {
        return ability4Behavior;
    }

    public void setAbility4Behavior(int ability4Behavior) {
        this.ability4Behavior = ability4Behavior;
    }

    public int getAbility5Level() {
        return ability5Level;
    }

    public void setAbility5Level(int ability5Level) {
        this.ability5Level = ability5Level;
    }

    public int getAbility5ManaCost() {
        return ability5ManaCost;
    }

    public void setAbility5ManaCost(int ability5ManaCost) {
        this.ability5ManaCost = ability5ManaCost;
    }

    public int getAbility5AbilityDamage() {
        return ability5AbilityDamage;
    }

    public void setAbility5AbilityDamage(int ability5AbilityDamage) {
        this.ability5AbilityDamage = ability5AbilityDamage;
    }

    public int getAbility5CastRange() {
        return ability5CastRange;
    }

    public void setAbility5CastRange(int ability5CastRange) {
        this.ability5CastRange = ability5CastRange;
    }

    public int getAbility5TargetType() {
        return ability5TargetType;
    }

    public void setAbility5TargetType(int ability5TargetType) {
        this.ability5TargetType = ability5TargetType;
    }

    public int getAbility5Behavior() {
        return ability5Behavior;
    }

    public void setAbility5Behavior(int ability5Behavior) {
        this.ability5Behavior = ability5Behavior;
    }

    public int getAbility6Level() {
        return ability6Level;
    }

    public void setAbility6Level(int ability6Level) {
        this.ability6Level = ability6Level;
    }

    public int getAbility6ManaCost() {
        return ability6ManaCost;
    }

    public void setAbility6ManaCost(int ability6ManaCost) {
        this.ability6ManaCost = ability6ManaCost;
    }

    public int getAbility6AbilityDamage() {
        return ability6AbilityDamage;
    }

    public void setAbility6AbilityDamage(int ability6AbilityDamage) {
        this.ability6AbilityDamage = ability6AbilityDamage;
    }

    public int getAbility6CastRange() {
        return ability6CastRange;
    }

    public void setAbility6CastRange(int ability6CastRange) {
        this.ability6CastRange = ability6CastRange;
    }

    public int getAbility6TargetType() {
        return ability6TargetType;
    }

    public void setAbility6TargetType(int ability6TargetType) {
        this.ability6TargetType = ability6TargetType;
    }

    public int getAbility6Behavior() {
        return ability6Behavior;
    }

    public void setAbility6Behavior(int ability6Behavior) {
        this.ability6Behavior = ability6Behavior;
    }

    public int getOppAbility1Level() {
        return oppAbility1Level;
    }

    public void setOppAbility1Level(int oppAbility1Level) {
        this.oppAbility1Level = oppAbility1Level;
    }

    public int getOppAbility1ManaCost() {
        return oppAbility1ManaCost;
    }

    public void setOppAbility1ManaCost(int oppAbility1ManaCost) {
        this.oppAbility1ManaCost = oppAbility1ManaCost;
    }

    public int getOppAbility1AbilityDamage() {
        return oppAbility1AbilityDamage;
    }

    public void setOppAbility1AbilityDamage(int oppAbility1AbilityDamage) {
        this.oppAbility1AbilityDamage = oppAbility1AbilityDamage;
    }

    public int getOppAbility1CastRange() {
        return oppAbility1CastRange;
    }

    public void setOppAbility1CastRange(int oppAbility1CastRange) {
        this.oppAbility1CastRange = oppAbility1CastRange;
    }

    public int getOppAbility1TargetType() {
        return oppAbility1TargetType;
    }

    public void setOppAbility1TargetType(int oppAbility1TargetType) {
        this.oppAbility1TargetType = oppAbility1TargetType;
    }

    public int getOppAbility1Behavior() {
        return oppAbility1Behavior;
    }

    public void setOppAbility1Behavior(int oppAbility1Behavior) {
        this.oppAbility1Behavior = oppAbility1Behavior;
    }

    public int getOppAbility2Level() {
        return oppAbility2Level;
    }

    public void setOppAbility2Level(int oppAbility2Level) {
        this.oppAbility2Level = oppAbility2Level;
    }

    public int getOppAbility2ManaCost() {
        return oppAbility2ManaCost;
    }

    public void setOppAbility2ManaCost(int oppAbility2ManaCost) {
        this.oppAbility2ManaCost = oppAbility2ManaCost;
    }

    public int getOppAbility2AbilityDamage() {
        return oppAbility2AbilityDamage;
    }

    public void setOppAbility2AbilityDamage(int oppAbility2AbilityDamage) {
        this.oppAbility2AbilityDamage = oppAbility2AbilityDamage;
    }

    public int getOppAbility2CastRange() {
        return oppAbility2CastRange;
    }

    public void setOppAbility2CastRange(int oppAbility2CastRange) {
        this.oppAbility2CastRange = oppAbility2CastRange;
    }

    public int getOppAbility2TargetType() {
        return oppAbility2TargetType;
    }

    public void setOppAbility2TargetType(int oppAbility2TargetType) {
        this.oppAbility2TargetType = oppAbility2TargetType;
    }

    public int getOppAbility2Behavior() {
        return oppAbility2Behavior;
    }

    public void setOppAbility2Behavior(int oppAbility2Behavior) {
        this.oppAbility2Behavior = oppAbility2Behavior;
    }

    public int getOppAbility3Level() {
        return oppAbility3Level;
    }

    public void setOppAbility3Level(int oppAbility3Level) {
        this.oppAbility3Level = oppAbility3Level;
    }

    public int getOppAbility3ManaCost() {
        return oppAbility3ManaCost;
    }

    public void setOppAbility3ManaCost(int oppAbility3ManaCost) {
        this.oppAbility3ManaCost = oppAbility3ManaCost;
    }

    public int getOppAbility3AbilityDamage() {
        return oppAbility3AbilityDamage;
    }

    public void setOppAbility3AbilityDamage(int oppAbility3AbilityDamage) {
        this.oppAbility3AbilityDamage = oppAbility3AbilityDamage;
    }

    public int getOppAbility3CastRange() {
        return oppAbility3CastRange;
    }

    public void setOppAbility3CastRange(int oppAbility3CastRange) {
        this.oppAbility3CastRange = oppAbility3CastRange;
    }

    public int getOppAbility3TargetType() {
        return oppAbility3TargetType;
    }

    public void setOppAbility3TargetType(int oppAbility3TargetType) {
        this.oppAbility3TargetType = oppAbility3TargetType;
    }

    public int getOppAbility3Behavior() {
        return oppAbility3Behavior;
    }

    public void setOppAbility3Behavior(int oppAbility3Behavior) {
        this.oppAbility3Behavior = oppAbility3Behavior;
    }

    public int getOppAbility4Level() {
        return oppAbility4Level;
    }

    public void setOppAbility4Level(int oppAbility4Level) {
        this.oppAbility4Level = oppAbility4Level;
    }

    public int getOppAbility4ManaCost() {
        return oppAbility4ManaCost;
    }

    public void setOppAbility4ManaCost(int oppAbility4ManaCost) {
        this.oppAbility4ManaCost = oppAbility4ManaCost;
    }

    public int getOppAbility4AbilityDamage() {
        return oppAbility4AbilityDamage;
    }

    public void setOppAbility4AbilityDamage(int oppAbility4AbilityDamage) {
        this.oppAbility4AbilityDamage = oppAbility4AbilityDamage;
    }

    public int getOppAbility4CastRange() {
        return oppAbility4CastRange;
    }

    public void setOppAbility4CastRange(int oppAbility4CastRange) {
        this.oppAbility4CastRange = oppAbility4CastRange;
    }

    public int getOppAbility4TargetType() {
        return oppAbility4TargetType;
    }

    public void setOppAbility4TargetType(int oppAbility4TargetType) {
        this.oppAbility4TargetType = oppAbility4TargetType;
    }

    public int getOppAbility4Behavior() {
        return oppAbility4Behavior;
    }

    public void setOppAbility4Behavior(int oppAbility4Behavior) {
        this.oppAbility4Behavior = oppAbility4Behavior;
    }

    public int getOppAbility5Level() {
        return oppAbility5Level;
    }

    public void setOppAbility5Level(int oppAbility5Level) {
        this.oppAbility5Level = oppAbility5Level;
    }

    public int getOppAbility5ManaCost() {
        return oppAbility5ManaCost;
    }

    public void setOppAbility5ManaCost(int oppAbility5ManaCost) {
        this.oppAbility5ManaCost = oppAbility5ManaCost;
    }

    public int getOppAbility5AbilityDamage() {
        return oppAbility5AbilityDamage;
    }

    public void setOppAbility5AbilityDamage(int oppAbility5AbilityDamage) {
        this.oppAbility5AbilityDamage = oppAbility5AbilityDamage;
    }

    public int getOppAbility5CastRange() {
        return oppAbility5CastRange;
    }

    public void setOppAbility5CastRange(int oppAbility5CastRange) {
        this.oppAbility5CastRange = oppAbility5CastRange;
    }

    public int getOppAbility5TargetType() {
        return oppAbility5TargetType;
    }

    public void setOppAbility5TargetType(int oppAbility5TargetType) {
        this.oppAbility5TargetType = oppAbility5TargetType;
    }

    public int getOppAbility5Behavior() {
        return oppAbility5Behavior;
    }

    public void setOppAbility5Behavior(int oppAbility5Behavior) {
        this.oppAbility5Behavior = oppAbility5Behavior;
    }

    public int getOppAbility6Level() {
        return oppAbility6Level;
    }

    public void setOppAbility6Level(int oppAbility6Level) {
        this.oppAbility6Level = oppAbility6Level;
    }

    public int getOppAbility6ManaCost() {
        return oppAbility6ManaCost;
    }

    public void setOppAbility6ManaCost(int oppAbility6ManaCost) {
        this.oppAbility6ManaCost = oppAbility6ManaCost;
    }

    public int getOppAbility6AbilityDamage() {
        return oppAbility6AbilityDamage;
    }

    public void setOppAbility6AbilityDamage(int oppAbility6AbilityDamage) {
        this.oppAbility6AbilityDamage = oppAbility6AbilityDamage;
    }

    public int getOppAbility6CastRange() {
        return oppAbility6CastRange;
    }

    public void setOppAbility6CastRange(int oppAbility6CastRange) {
        this.oppAbility6CastRange = oppAbility6CastRange;
    }

    public int getOppAbility6TargetType() {
        return oppAbility6TargetType;
    }

    public void setOppAbility6TargetType(int oppAbility6TargetType) {
        this.oppAbility6TargetType = oppAbility6TargetType;
    }

    public int getOppAbility6Behavior() {
        return oppAbility6Behavior;
    }

    public void setOppAbility6Behavior(int oppAbility6Behavior) {
        this.oppAbility6Behavior = oppAbility6Behavior;
    }

    public int getItemFlask() {
        return itemFlask;
    }

    public void setItemFlask(int itemFlask) {
        this.itemFlask = itemFlask;
    }
}
