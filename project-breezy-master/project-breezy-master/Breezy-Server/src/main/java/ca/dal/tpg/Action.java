package ca.dal.tpg;

public enum Action {
    DO_NOTHING(0, "Do Nothing"),
    MOVE_N(1, "Move North"),
    MOVE_NE(2, "Move North East"),
    MOVE_E(3, "Move East"),
    MOVE_SE(4, "Move South East"),
    MOVE_S(5, "Move South"),
    MOVE_SW(6, "Move South West"),
    MOVE_W(7, "Move West"),
    MOVE_NW(8, "Move North West"),
    GET_BOUNTY_RUNE_1(9, "Get Bounty Rune 1"),
    GET_BOUNTY_RUNE_3(10, "Get Bounty Rune 3"),
    GET_TOP_POWERUP_RUNE(11, "Get Top Powerup Rune"),
    GET_BOTTOM_POWERUP_RUNE(12, "Get Bottom Powerup Rune" ),
    ATTACK_ENEMY_HERO(13, "Attack Enemy Hero"),
    ATTACK_ENEMY_TOWER(14, "Attack Enemy Tower"),
    ATTACK_CREEP_0(15, "Attack Creep 0"),
    ATTACK_CREEP_1(16, "Attack Creep 1"),
    ATTACK_CREEP_2(17, "Attack Creep 2"),
    ATTACK_CREEP_3(18, "Attack Creep 3"),
    ATTACK_CREEP_4(19, "Attack Creep 4"),
    ATTACK_CREEP_5(20, "Attack Creep 5"),
    ATTACK_CREEP_6(21, "Attack Creep 6"),
    ATTACK_CREEP_7(22, "Attack Creep 7"),
    ATTACK_CREEP_8(23, "Attack Creep 8"),
    ATTACK_CREEP_9(24, "Attack Creep 9"),
    CAST_SHADOWRAZE_1(25, "Cast Shadow Raze 1"),
    CAST_SHADOWRAZE_2(26, "Cast Shadow Raze 2"),
    CAST_SHADOWRAZE_3(27, "Cast Shadow Raze 3"),
    CAST_REQUIEM_OF_SOULS(28, "Cast Requiem of Souls"),
    USE_SALVE(29, "Use Salve");

    private int code;
    private String friendlyName;

    Action(int code, String friendlyName){
        this.code = code;
        this.friendlyName = friendlyName;
    }

    public int code(){
        return this.code;
    }

    public String friendlyName(){
        return this.friendlyName;
    }

}
