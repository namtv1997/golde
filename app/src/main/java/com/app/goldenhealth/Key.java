package com.app.goldenhealth;

import java.util.Locale;

public interface Key {

    String APP_PREFERENCE = "app_preference";
    public static final Locale LOCALE_VN = new Locale("vi", "VN");
    String DATA_USER = "dataUser" ;
    String TOKEN = "token";
    String registerUsername = "golden_health";
    String registerPassword = "hsdkjft2783tgifg2o";
    String UID = "UID" ;
    String TITLE = "title";
    String HOTLINE = "19009095";
    String EMAIL = "duongdaynong@moh.gov.vn";
    String SEARCH_HISTORY = "duongdaynong@moh.gov.vn";

    // UserRole
    String ROLE_ID = "RoleId";
    int UNDEFINED = 0;
    int ADMIN = 1;
    int USER = 2;
    int APPLICATION = 3;
    int DOCTOR = 4;
    int FACILITY = 5;
    int MANAGER = 8;

    String IS_HOTLINE = "isHotline" ;
    String ID = "id" ;
    String CAU_HOI = "cauHoi";
    int PHAN_ANH = 1 ;
    int UNG_DUNG = 2 ;
    String NOTIFICATION_TYPE = "notification type";
    String DIA_DIEM = "dia diem";
    int CONG_KHAI = 1;
    int CA_NHAN = 2;
    String ARRIMG = "arrimg" ;
    String POSITION = "position" ;
    int NOTY_ID = 1236 ;
    String NOTIFY = "notify" ;
    String PHAN_ANH_ID = "phanAnhID";
    Integer DA_TRA_LOI = 1;
    Integer CHUA_TRA_LOI = 2;
    int RC_SIGN_IN = 001;
}
