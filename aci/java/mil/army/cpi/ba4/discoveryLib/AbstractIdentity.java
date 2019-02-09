package mil.army.cpi.ba4.discoveryLib;


public abstract class AbstractIdentity{

    public int systemType;
    public int platformType;
    public int secClass;
    public int ADCONURN;
    public int OPCONURN;
    public int ORGANICURN;
    public char agency;
    public int nationality;
    public String symbolCode;

    public AbstractIdentity() {

    }
    
    protected AbstractIdentity(AbstractIdentity identity) {
        this.systemType = identity.systemType;
        this.platformType = identity.platformType;
        this.secClass = identity.secClass;
        this.ADCONURN = identity.ADCONURN;
        this.OPCONURN = identity.OPCONURN;
        this.ORGANICURN = identity.ORGANICURN;
        this.agency = identity.agency;
        this.nationality = identity.nationality;
        this.symbolCode = identity.symbolCode;
    }

    @Override
    public String toString(){
        String text = "SystemType: " + systemType;
        text += "\nPlatformType: " + platformType;
        text += "\nSecurityClass: " + secClass;
        text += "\nADCONURN: " + (long)ADCONURN;
        text += "\nOPCONURN: " + (long)OPCONURN;
        text += "\nORGANICURN: " + (long)ORGANICURN;
        text += "\nAgency: " + Character.toString(agency);
        text += "\nNationality: " + nationality;
        text += "\nSymbolCode: " + symbolCode;

        return text;
    }


    public enum PlatformType {
        NO_STATEMENT,
        FIVE_T,
        SEVEN_TON_WRECKER,
        A_10,
        AAV_C2,
        AAV_C7,
        AAV_P7,
        AAV_R7,
        A2C2S,
        ADAM_VAN,
        AH_1W,
        AH64D,
        AH64D_W_RADAR,
        AMBULANCE,
        AMBULANCE_2,
        AMBULANCE_4,
        AN_MRC_145,
        ANTI_SURFACE_BOAT,
        ANTI_TANK_ROCKET_LAUNCHER,
        APACHE,
        ASSAULT_AMPHIBIOUS,
        ASV,
        AUTOMATIC_GRENADE_LAUNCHER,
        AVENGER,
        AVLB,
        BRADLEY,
        C_23,
        C2V,
        CARGO_HEMMT,
        CH_47D_F,
        CH_53,
        DEUCE,
        DH_7,
        E_8,
        EH_60,
        EXPANDO_VAN,
        EXPANDO_VAN1,
        F_16,
        FAC,
        FAST_ATTACK,
        FORKLIFT,
        FSTV,
        GRENADIER,
        GRIZZLY,
        GROUND_DATA__TERMINAL,
        HCMTP,
        HEAVY_MACHINE_GUN_TEAM,
        HEMMT,
        HET,
        HMMWV_ARMORED,
        HMMWV_TOW,
        IAV_AMB,
        IAV_ATGM,
        IAV_CMD,
        IAV_ENGR_SQD,
        IAV_ENGR_SQD_VEH,
        IAV_FS,
        IAV_FSV,
        IAV_INF,
        IAV_MED,
        IAV_MGS,
        IAV_MTR,
        IAV_MTR_CARRIER,
        IAV_NBC,
        IAV_RECON,
        ITV,
        LAR,
        LAV_25,
        LAV_AT,
        LAV_C2,
        LAV_LIGHT,
        LAV_LOG,
        LAV_MORTAR,
        LAV_R,
        LEN,
        LMTV,
        LVS,
        M1025,
        M1026,
        M1037,
        M1038,
        M1043_M1044,
        M1045,
        M1059,
        M1064,
        M1068,
        M1068_RWS,
        M1074,
        M1075,
        M1078,
        M1079,
        M1083,
        M1084,
        M1084_5_TON_MTV,
        M1085,
        M1086,
        M1087,
        M1088,
        M1089,
        M1089_WRECKER,
        M109_VAN,
        M1091,
        M1096,
        M1097,
        M1097_RWS,
        M109A6,
        M1113,
        M1113_RWS,
        M1114,
        M1123,
        M113,
        M113_AMBULANCE,
        M114,
        M1A1,
        M1A1D,
        M1A2_SEP,
        M240_GUNNER,
        M270,
        M270A,
        M270_C2V,
        M2A2,
        M2A2_ODS,
        M2A2_ODS_E,
        M2A3,
        M3A3,
        M3A3_BFIST,
        M4,
        M548,
        M577,
        M577_AMBULANCE,
        M6,
        M60A1_AVLB,
        M7,
        M707,
        M7A1,
        M88,
        M88A1,
        M88A2,
        M88_RECOVERY,
        M9,
        M915,
        M925A2,
        M93,
        M9315T,
        M934,
        M936,
        M938,
        M939,
        M93A1,
        M977,
        M978,
        M981A2,
        M984,
        M984_WRECKER,
        M985,
        M992,
        M997,
        M997_AMBULANCE,
        M998,
        MRC_138,
        MRC_145,
        MTVR,
        MTVR_XL,
        MUAV,
        OH_58D,
        OH_817,
        OH_818,
        PANDUR,
        PATROL_BOAT,
        Q_36,
        Q_37,
        RADAR,
        RC_12,
        RECON_MARINE,
        RIFLEMAN,
        SATELLITE,
        SAW_GUNNER,
        SECM,
        SHOP_SET,
        SICPS_TENT,
        SMART_T,
        SOLDIER,
        TANKER_HEMMT,
        TENT,
        TIP,
        TRACTOR,
        TRANSIT_CASE,
        TROJAN_SPIRIT,
        TUAV,
        UAV,
        UC_35,
        UH_1N_HUEY,
        UH_60,
        WOLVERINE,
        X_COUNTRY_TRUCK,
        HMMWV,
        LIGHT_TRUCK,
        MEDIUM_TRUCK,
        HEAVY_TRUCK,
        CRANES_WRECKERS,
        STAFF_COMMAND_VEH,
        MOTOCYCLES_SCOOTERS,
        All_Terrain_Vehicle,
        TRAILERS,
        ARMY_AIRCRAFT,
        TANKS_GUN_CARRIAGES,
        ARTILLERY,
        SCOUT_CAR_APC,
        HALFTRACKS,
        EARTHMOVERS,
        MISCELLANEOUS,
        UNDEFINED
    }

    public static enum SystemType {
        UNKNOWN,
        FBCB2,
        FBCB2_JCR_VEHICLE,
        FBCB2_JCR_TSG,
        FBCB2_JCR_NOC,
        MTS_ES_PLATFORM,
        MTS_ES_CONTROL_STATION,
        FOS,
        LW,
        Maneuver_Control_System_Light,
        ASAS_L,
        AIS,
        GCSS_A,
        AMPS,
        DCARS_DCTS,
        DTSS_L,
        DTSS_H,
        RADIO_RELAY_RETRANS,
        EPLRS_GW,
        EPLRS_Grid_Reference_Unit,
        SIV,
        ABCS_TOC_SVR,
        UAV,
        SEN,
        ISYSCON,
        GROUND_TERMINAL_DATA,
        CGS,
        ASAS,
        AFATDS,
        BCS3,
        FAAD,
        MCS,
        MICAD,
        GBS,
        FAAD_SC2,
        LAN_MGR,
        MDL,
        EPLRS_Network_Manager,
        DAUVS,
        IMETS,
        TAIS,
        AMDWS,
        GCCS_A,
        MFDC,
        C2PC,
        LEGACY_MTS,
        JTCW,
        EDM,
        IFTS,
        IDM,
        C2CE_DDACT,
        CPOF_C,
        CPOF_DBRG,
        DCGS_AIOP,
        DTSS,
        MCS_GWY,
        TIS,
        FBCB2_JBCP_HH,
        FBCB2_JBCP_VEHICLE,
        FBCB2_JBCP_CONTROL_STATION,
        FBCB2_JBCP_NOC,
        FBCB2_JBCP_LOG,
        UCB_NOC,
        UCB_CP,
        FBCB2_MACE_Tablet,
        FBCB2_MACE_Vehicle,
        TIGR,
        PASS,
        DDS,
        NW,
        MCWS,
        JWARN,
        PFED,
        C2R,
        T_SOA,
        TLDHS,
        COM_WEB,
        BCCS,
        MC4,
        J_TNT,
        LCMS,
        TACAPPS,
        CP_CE
    }

    public enum ClassificationType {
        ILLEGAL,
        UNCLASSIFIED,
        CONFIDENTIAL,
        SECRET,
        TOP_SECRET,
        EFTO,
        SECRET_NOFORN,
        SECRET_RESTRICTED,
        CONFIDENTIAL_FORMERLY_RESTRICTED_DATA,
        SECRET_FORMERLY_RESTRICTED_DATA,
        UNDEFINED
    }
}