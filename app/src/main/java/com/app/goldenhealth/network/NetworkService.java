package com.app.goldenhealth.network;

import com.app.goldenhealth.model.*;
import com.app.goldenhealth.model.Response;
import com.google.gson.JsonObject;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.*;
import rx.Observable;

import java.util.ArrayList;

public interface NetworkService {

    @POST("/token")
    @FormUrlEncoded
    Observable<Token> login(@Field("username") String username,
                            @Field("password") String password,
                            @Field("firebase_token") String firebaseToken,
                            @Field("grant_type") String grantType);

    @POST("/token")
    @FormUrlEncoded
    Call<JsonObject> login2(@Field("username") String username,
                            @Field("password") String password,
                            @Field("firebase_token") String firebaseToken,
                            @Field("grant_type") String grantType);

    @POST("/token")
    @FormUrlEncoded
    Call<JsonObject> loginFaceBook(@Field("username") String username,
                                   @Field("password") String password,
                                   @Field("firebase_token") String firebaseToken,
                                   @Field("grant_type") String grantType,
                                   @Field("type_account") Integer type_account);

    @POST("/token")
    @FormUrlEncoded
    Observable<Token> refreshToken(@Field("refresh_token") String refreshToken,
                                   @Field("grant_type") String grantType);

    @POST("/token")
    @FormUrlEncoded
    Call<Token> refreshToken2(@Field("refresh_token") String refreshToken,
                              @Field("grant_type") String grantType);

    @GET("api/User/getUser")
    Observable<Response<User>> getUser(@Header("Authorization") String token,
                                       @Query("uid") String uid);

    @GET("api/User/CheckExistUsername")
    Observable<Response<Boolean>> checkExistUsername(@Header("Authorization") String token,
                                                     @Query("username") String username);

    @GET("api/User/CheckExistEmail")
    Observable<Response<Boolean>> checkExistEmail(@Header("Authorization") String token,
                                                  @Query("email") String email);

    @GET("api/User/CheckExistPhone")
    Observable<Response<Boolean>> checkExistPhone(@Header("Authorization") String token,
                                                  @Query("phone") String phone);

    @POST("api/User/Register")
    @FormUrlEncoded
    Observable<Response<String>> register(@Header("Authorization") String token,
                                          @Field("Id") int id,
                                          @Field("UID") int uid,
                                          @Field("EmailID") String email,
                                          @Field("UserName") String username,
                                          @Field("Password") String pasword,
                                          @Field("RoleId") int roleId,
                                          @Field("DateCreate") int dateCreate,
                                          @Field("FullName") String fullName,
                                          @Field("Status") int status,
                                          @Field("Phone") String phone,
                                          @Field("maytecanhan") String maYTe,
                                          @Field("BirthDay") String birthday,
                                          @Field("MaBS") String maBS,
                                          @Field("BenhVienID") Integer benhVienId,
                                          @Field("DiaChi") String diaChi
    );

    @POST("api/User/Register")
    @FormUrlEncoded
    Observable<Response<String>> registerMXH(@Header("Authorization") String token,
                                             @Field("FullName") String FullName,
                                             @Field("Phone") String Phone,
                                             @Field("EmailID") String EmailID,
                                             @Field("RoleId") int roleId,
                                             @Field("Avatar") String Avatar,
                                             @Field("ID_Facebook") String ID_Facebook,
                                             @Field("ID_Google") String ID_Google,
                                             @Field("ID_Zalo") String ID_Zalo
    );

    @POST("api/User/ValidateVerifyCode")
    @FormUrlEncoded
    Observable<Response<Boolean>> validateVerifyCode(@Header("Authorization") String token,
                                                     @Field("UID") String uid,
                                                     @Field("code") String code);

    @POST("api/User/ReSendVerifyCodeRegister")
    @FormUrlEncoded
    Observable<Response<Boolean>> reSendVerifyCodeRegister(@Header("Authorization") String token,
                                                           @Field("UID") String uid);

    @POST("api/User/ForgotPassword")
    @FormUrlEncoded
    Observable<Response<String>> forgetPassword(@Header("Authorization") String token,
                                                @Field("EmailID") String email,
                                                @Field("Phone") String phone);

    @POST("api/User/ChangePassword")
    @FormUrlEncoded
    Observable<Response<Boolean>> changePassword(@Header("Authorization") String token,
                                                 @Field("UID") String uid,
                                                 @Field("Password") String password);

    @GET("api/HSSK/TomTatThongTin")
    Observable<Response<ThongTinTomTat>> getThongTinTomTat(@Header("Authorization") String token,
                                                           @Query("maytecanhan") String maYTe);

    @POST("api/HSSK/HoSoKhamLap")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateThongTinCoBan(@Header("Authorization") String token,
                                                      @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                      @Field("NHOM_MAU") String nhomMau,
                                                      @Field("CHIEU_CAO") Double chieuCao,
                                                      @Field("CAN_NANG") Double canNang
    );

    @POST("api/HSSK/UpdatePhieuKhamLap")
    @FormUrlEncoded
    Observable<Response<Boolean>> updatePhieuKhamLap(@Header("Authorization") String token,
                                                     @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                     @Field("UID") String uid,
                                                     @Field("NGAY_KHAM") String ngayKham,
                                                     @Field("BENH_SU") String benhSu,
                                                     @Field("MACH") Double mach,
                                                     @Field("NHIET_DO") Double nhietDo,
                                                     @Field("HUYET_AP_TD") Integer huyetApTD,
                                                     @Field("HUYET_AP_TT") Integer huyetApTT,
                                                     @Field("NHIP_THO") Integer nhipTho,
                                                     @Field("CAN_NANG") Double canNang,
                                                     @Field("CHIEU_CAO") Double chieuCao,
                                                     @Field("VONG_BUNG") Double vongBung,
                                                     @Field("BMI") Double BMI,
                                                     @Field("MAT_PHAI_KK") Integer matPhaiKK,
                                                     @Field("MAT_TRAI_KK") Integer matTraiKK,
                                                     @Field("MAT_PHAI_CK") Integer matPhaiCK,
                                                     @Field("MAT_TRAI_CK") Integer matTraiCK,
                                                     @Field("KHAM_DA") String KHAM_DA,
                                                     @Field("KHAM_NIEM_MAC") String KHAM_NIEM_MAC,
                                                     @Field("KHAM_TT_KHAC") String KHAM_TT_KHAC,
                                                     @Field("KHAM_TIM_MACH") String KHAM_TIM_MACH,
                                                     @Field("KHAM_HO_HAP") String KHAM_HO_HAP,
                                                     @Field("KHAM_TIET_NIEU") String KHAM_TIET_NIEU,
                                                     @Field("KHAM_TIEU_HOA") String KHAM_TIEU_HOA,
                                                     @Field("KHAM_CXK") String KHAM_CXK,
                                                     @Field("KHAM_NOI_TIET") String KHAM_NOI_TIET,
                                                     @Field("KHAM_THAN_KINH") String KHAM_THAN_KINH,
                                                     @Field("KHAM_TAM_THAN") String KHAM_TAM_THAN,
                                                     @Field("KHAM_NGOAI_KHOA") String KHAM_NGOAI_KHOA,
                                                     @Field("KHAM_SAN_PHU_KHOA") String KHAM_SAN_PHU_KHOA,
                                                     @Field("KHAM_TAI_MUI_HONG") String KHAM_TAI_MUI_HONG,
                                                     @Field("KHAM_RANG_HAM_MAT") String KHAM_RANG_HAM_MAT,
                                                     @Field("KHAM_MAT") String KHAM_MAT,
                                                     @Field("KHAM_DA_LIEU") String KHAM_DA_LIEU,
                                                     @Field("KHAM_DINH_DUONG") String KHAM_DINH_DUONG,
                                                     @Field("KHAM_VAN_DONG") String KHAM_VAN_DONG,
                                                     @Field("KHAM_CQ_KHAC") String KHAM_CQ_KHAC,
                                                     @Field("KHAM_DANH_GIA") String KHAM_DANH_GIA,
                                                     @Field("NGUY_CO_SUY_DINH_DUONG") Integer NGUY_CO_SUY_DINH_DUONG,
                                                     @Field("NGUY_CO_BEO_PHI") Integer NGUY_CO_BEO_PHI,
                                                     @Field("TU_VE_SINH_CA_NHAN") Integer TU_VE_SINH_CA_NHAN,
                                                     @Field("TU_DI_LAI") Integer TU_DI_LAI,
                                                     @Field("TU_MAC_QUAN_AO") Integer TU_MAC_QUAN_AO,
                                                     @Field("DAI_TIEU_TIEN_TC") Integer DAI_TIEU_TIEN_TC,
                                                     @Field("TU_AN_UONG") Integer TU_AN_UONG,
                                                     @Field("TU_SU_DUNG_DT") Integer TU_SU_DUNG_DT,
                                                     @Field("TU_MUA_BAN") Integer TU_MUA_BAN,
                                                     @Field("TU_NAU_AN") Integer TU_NAU_AN,
                                                     @Field("TU_DON_DEP") Integer TU_DON_DEP,
                                                     @Field("TU_GIAT_GIU") Integer TU_GIAT_GIU,
                                                     @Field("TU_UONG_HAY_CHICH_THUOC") Integer TU_UONG_HAY_CHICH_THUOC,
                                                     @Field("GIAM_TRI_NHO") Integer GIAM_TRI_NHO,
                                                     @Field("GIA_DINH_CO_NG_MAC") Integer GIA_DINH_CO_NG_MAC,
                                                     @Field("SO_LOAI_THUOC_SU_DUNG") String SO_LOAI_THUOC_SU_DUNG,
                                                     @Field("XN_NHOM_MAU_ABO") String XN_NHOM_MAU_ABO,
                                                     @Field("XN_NHOM_MAU_RH") String XN_NHOM_MAU_RH,
                                                     @Field("XN_CONG_THUC_MAU") String XN_CONG_THUC_MAU,
                                                     @Field("XN_SINH_HOA_MAU") String XN_SINH_HOA_MAU,
                                                     @Field("XN_SH_NUOC_TIEU") String XN_SH_NUOC_TIEU,
                                                     @Field("XN_SIEU_AM") String XN_SIEU_AM,
                                                     @Field("LOAI_IDCs") ArrayList<Integer> LOAI_IDCs,
                                                     @Field("ID_BENH_VIEN") Integer ID_BENH_VIEN,
                                                     @Field("BAC_SI_KHAM") String BAC_SI_KHAM,
                                                     @Field("BENH_THEO_DOIs") ArrayList<Integer> BENH_THEO_DOIs,
                                                     @Field("NGAY_HEN_KHAM") String NGAY_HEN_KHAM


    );

    @GET("api/HSSK/HoSoKhamLap")
    Observable<Response<HoSoKhamLap>> getHoSoKhamLap(@Header("Authorization") String token,
                                                     @Query("maytecanhan") String maYTe);

    @GET("api/HSSK/TinhTrangLucSinh")
    Observable<Response<TinhTrangLucSinh>> getTinhTrangLucSinh(@Header("Authorization") String token,
                                                               @Query("maytecanhan") String maYTe);

    @POST("api/HSSK/UpdateTinhTrangLucSinh")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateTinhTrangLucSinh(@Header("Authorization") String token,
                                                         @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                         @Field("DE_THUONG") Integer dethuong,
                                                         @Field("BI_NGAT") Integer biNgat,
                                                         @Field("DE_THIEU_THANG") Integer deThieuThang,
                                                         @Field("CAN_NANG") Double canNang,
                                                         @Field("CHIEU_DAI") Double chieuDai,
                                                         @Field("KHOC_KHI_SINH") Integer khocKhiSinh,
                                                         @Field("DI_TAT") String diTat,
                                                         @Field("VAN_DE_KHAC") String vanDeKhac
    );

    @GET("api/HSSK/YeuToNguyCo")
    Observable<Response<YeuToNguyCo>> getYeuToNguyCo(@Header("Authorization") String token,
                                                     @Query("maytecanhan") String maYTe);

    @GET("api/DanhMuc/getLoaiHoXis")
    Observable<Response<ArrayList<HoXi>>> getHoXi(@Header("Authorization") String token);

    @POST("api/HSSK/UpdateYeuToNguyCo")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateYeuToNguyCo(@Header("Authorization") String token,
                                                    @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                    @Field("HUT_THUOC_LAO") Integer hutThuocLao,
                                                    @Field("HUT_LIEN_TUC") Integer hutLienTuc,
                                                    @Field("DA_BO_THUOC") Integer daBoThuoc,
                                                    @Field("UONG_RUOU_BIA") Integer uongRuouBia,
                                                    @Field("DON_VI_RUOU") Double donViRuou,
                                                    @Field("DA_BO_RUOU") Integer daBoRuou,
                                                    @Field("SD_MA_TUY") Integer sdMaTuy,
                                                    @Field("SD_MT_LIEN_TUC") Integer sdMaTuyLienTuc,
                                                    @Field("DA_BO_MA_TUY") Integer daBoMaTuy,
                                                    @Field("IT_HOAT_DONG") Integer hoatDongTheLuc,
                                                    @Field("TX_TAP_TDTT") Integer thuongXuyenTapTheDuc,
                                                    @Field("MOI_TRUONG") String moiTruong,
                                                    @Field("TG_TIEP_XUC") Double tgTiepXuc,
                                                    @Field("LOAI_HO_XI_ID") Integer loaiHoXiID,
                                                    @Field("NGUY_CO_NN") String nguyCoNgheNghiep,
                                                    @Field("NGUY_CO_KHAC") String nguyCoKhac
    );

    @GET("api/HSSK/TienSuBenhTat")
    Observable<Response<TienSuBenhTat>> getTienSuBenhTat(@Header("Authorization") String token,
                                                         @Query("maytecanhan") String maYTe);

    @POST("api/HSSK/UpdateTienSuBenhTat")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateTienSuBenhTat(@Header("Authorization") String token,
                                                      @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                      @Field("TIM_MACH") Integer timMach,
                                                      @Field("DAI_THAO_DUONG") Integer daiThaoDuong,
                                                      @Field("PHOI_MAN_TINH") Integer phoiManTinh,
                                                      @Field("BUOU_CO") Integer buouCo,
                                                      @Field("TIM_BAM_SINH") Integer timBamSinh,
                                                      @Field("TU_KY") Integer tuKy,
                                                      @Field("TANG_HUYET_AP") Integer tangHuyetAp,
                                                      @Field("DA_DAY") Integer daDay,
                                                      @Field("HEN_XUYEN") Integer henXuyen,
                                                      @Field("VIEM_GAN") Integer viemGan,
                                                      @Field("TAM_THAN") Integer tamThan,
                                                      @Field("DONG_KINH") Integer dongKinh,
                                                      @Field("UNG_THU") String ungThu,
                                                      @Field("LAO") String lao,
                                                      @Field("KHAC") String khac,
                                                      @Field("DU_THUOC") String duThuoc,
                                                      @Field("DU_HOA_CHAT") String duHoaChat,
                                                      @Field("DU_THUC_PHAM") String duThucPham,
                                                      @Field("DU_KHAC") String duKhac
    );

    @GET("api/HSSK/KhuyetTat")
    Observable<Response<KhuyetTat>> getKhuyetTat(@Header("Authorization") String token,
                                                 @Query("maytecanhan") String maYTe);

    @POST("api/HSSK/UpdateKhuyetTat")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateKhuyetTat(@Header("Authorization") String token,
                                                  @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                  @Field("THINH_LUC") Integer thinhLuc,
                                                  @Field("MT_THINH_LUC") String mtThinhLuc,
                                                  @Field("THI_LUC") Integer thiLuc,
                                                  @Field("MT_THI_LUC") String mtThiLuc,
                                                  @Field("TAY") Integer tay,
                                                  @Field("MT_TAY") String mtTay,
                                                  @Field("CHAN") Integer chan,
                                                  @Field("MT_CHAN") String mtChan,
                                                  @Field("CONG_VEO_CS") Integer congVeoCS,
                                                  @Field("MT_CONG_VEO_CS") String mtCongVeo,
                                                  @Field("MOI_HO") Integer moiHo,
                                                  @Field("MT_MOI_HO") String mtMoiHo,
                                                  @Field("KHAC") String khac
    );

    @GET("api/HSSK/TienSuPhauThuats")
    Observable<Response<ArrayList<TienSuPhauThuat>>> getTienSuPhauThuats(@Header("Authorization") String token,
                                                                         @Query("maytecanhan") String maYTe);

    @GET("api/HSSK/GetTienSuPhauThuatById")
    Observable<Response<TienSuPhauThuat>> getTienSuPhauThuatById(@Header("Authorization") String token,
                                                                 @Query("maytecanhan") String maYTe,
                                                                 @Query("id") Integer id
    );

    @POST("api/HSSK/CreateTienSuPhauThuat")
    @FormUrlEncoded
    Observable<Response<Boolean>> themTienSuPhauThuat(@Header("Authorization") String token,
                                                      @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                      @Field("MA_DVKT") String maDVKT,
                                                      @Field("MA_KCB_ID") Integer maKCBID,
                                                      @Field("BO_PHAN_PHAU_THUAT") String boPhan,
                                                      @Field("NAM_THUC_HIEN") Integer namThucHien,
                                                      @Field("NGAY_THUC_HIEN") String ngayThucHien,
                                                      @Field("MT_PT") String maPT
    );

    @POST("api/HSSK/UpdateTienSuPhauThuat")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateTienSuPhauThuat(@Header("Authorization") String token,
                                                        @Field("ID") Integer id,
                                                        @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                        @Field("MA_DVKT") String maDVKT,
                                                        @Field("MA_KCB_ID") Integer maKCBID,
                                                        @Field("BO_PHAN_PHAU_THUAT") String boPhan,
                                                        @Field("NAM_THUC_HIEN") Integer namThucHien,
                                                        @Field("NGAY_THUC_HIEN") String ngayThucHien,
                                                        @Field("MT_PT") String maPT
    );

    @GET("api/HSSK/TienSuDiUngGiaDinhs")
    Observable<Response<ArrayList<TienSuDiUng>>> getTienSuDiUngGiaDinhs(@Header("Authorization") String token,
                                                                        @Query("maytecanhan") String maYTe);

    @GET("api/HSSK/GetTienSuDiUngGiaDinhById")
    Observable<Response<TienSuDiUng>> getTienSuDiUngGiaDinhById(@Header("Authorization") String token,
                                                                @Query("maytecanhan") String maYTe,
                                                                @Query("id") Integer id
    );

    @GET("api/HSSK/TienSuBenhGiaDinhs")
    Observable<Response<ArrayList<TienSuBenh>>> getTienSuBenhGiaDinhs(@Header("Authorization") String token,
                                                                      @Query("maytecanhan") String maYTe);

    @GET("api/HSSK/GetTienSuBenhGiaDinhById")
    Observable<Response<TienSuBenh>> getTienSuBenhGiaDinhById(@Header("Authorization") String token,
                                                              @Query("maytecanhan") String maYTe,
                                                              @Query("id") Integer id
    );

    @GET("api/HSSK/SKSSAndKHHGD")
    Observable<Response<SKSS_KHHGD>> getSKSSAndKHHGĐ(@Header("Authorization") String token,
                                                     @Query("maytecanhan") String maYTe);

    @POST("api/HSSK/UpdateSKSSAndKHHGD")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateSKSSAndKHHGĐ(@Header("Authorization") String token,
                                                     @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                     @Field("BPTT_IDs") ArrayList<Integer> bptts,
                                                     @Field("KY_THAI_CUOI") String thaiKyCuoi,
                                                     @Field("SO_LAN_CO_THAI") Integer soLanCoThai,
                                                     @Field("SO_LAN_SAY_THAI") Integer soLanSayThai,
                                                     @Field("SO_LAN_PHA_THAI") Integer soLanPhaThai,
                                                     @Field("SO_LAN_DE_DU_THANG") Integer soLanDeDuThang,
                                                     @Field("SO_LAN_DE_NON") Integer soLanDeNon,
                                                     @Field("SO_LAN_DE") Integer soLanDe,
                                                     @Field("DE_THUONG") Integer deThuowng,
                                                     @Field("DE_MO") Integer deMo,
                                                     @Field("DE_KHO") Integer deKho,
                                                     @Field("SO_CON_SONG") Integer soConSong,
                                                     @Field("BENH_PHU_KHOA") String benhPhuKhoa
    );

    @GET("api/HSSK/VanDeKhac")
    Observable<Response<VanDeKhac>> getVanDeKhac(@Header("Authorization") String token,
                                                 @Query("maytecanhan") String maYTe);

    @GET("api/DanhMuc/getDiUngs")
    Observable<Response<ArrayList<DiUng>>> getDanhSachDiUng(@Header("Authorization") String token);

    @GET("api/DanhMuc/getLoaiBenhs")
    Observable<Response<ArrayList<LoaiBenh>>> getDanhSachLoaiBenh(@Header("Authorization") String token);

    @GET("api/DanhMuc/getQHGiaDinhs")
    Observable<Response<ArrayList<QuanHeGiaDinh>>> getQuanHeGiaDinh(@Header("Authorization") String token);

    @POST("api/HSSK/CreateTienSuDiUngGiaDinh")
    @FormUrlEncoded
    Observable<Response<Boolean>> themTienSuDiUng(@Header("Authorization") String token,
                                                  @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                  @Field("LOAI_DI_UNG_ID") Integer loaiDiUng,
                                                  @Field("LOAI_QH_ID") Integer loaiQuanHe,
                                                  @Field("MO_TA") String moTa
    );

    @POST("api/HSSK/UpdateDiUngGiaDinh")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateTienSuDiUng(@Header("Authorization") String token,
                                                    @Field("ID") Integer id,
                                                    @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                    @Field("LOAI_DI_UNG_ID") Integer loaiDiUng,
                                                    @Field("LOAI_QH_ID") Integer loaiQuanHe,
                                                    @Field("MO_TA") String moTa
    );

    @POST("api/HSSK/CreateTienSuBenhGiaDinh")
    @FormUrlEncoded
    Observable<Response<Boolean>> themTienSuBenh(@Header("Authorization") String token,
                                                 @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                 @Field("LOAI_BENH_ID") Integer loaiBenh,
                                                 @Field("LOAI_QH_ID") Integer loaiQuanHe,
                                                 @Field("MO_TA") String moTa
    );

    @POST("api/HSSK/UpdateBenhGiaDinh")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateTienSuBenh(@Header("Authorization") String token,
                                                   @Field("ID") Integer id,
                                                   @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                   @Field("LOAI_BENH_ID") Integer loaiBenh,
                                                   @Field("LOAI_QH_ID") Integer loaiQuanHe,
                                                   @Field("MO_TA") String moTa
    );

    @POST("api/HSSK/UpdateVanDeKhac")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateVanDeKhac(@Header("Authorization") String token,
                                                  @Field("MA_Y_TE_CA_NHAN") String maYTe,
                                                  @Field("VAN_DE") String vanDe
    );

    @GET("api/HSSK/LichSuKhamChuaBenhs")
    Observable<Response<ArrayList<LichSuKhamChuaBenh>>> getLichSuKhamChuaBenhs(@Header("Authorization") String token,
                                                                               @Query("maytecanhan") String maYTe);

    @FormUrlEncoded
    @POST("api/DanhMuc/getBenhViens")
    Observable<Response<ArrayList<BenhVien>>> getBenhVien(@Header("Authorization") String token,
                                                          @Field("PageNum") Integer pageNum,
                                                          @Field("PageSize") Integer pageSize);

    @GET("api/DanhMuc/getBenhVienById")
    Observable<Response<BenhVien>> getBenhVienById(@Header("Authorization") String token,
                                                   @Query("id") Integer id);


    @GET("{path}")
    Observable<Response<ArrayList<DanhMuc>>> getListDanhMuc(@Path("path") String path,
                                                            @Header("Authorization") String token);

    @GET("{path}")
    Observable<Response<DanhMuc>> getDanhMucDetail(@Path("path") String path,
                                                   @Header("Authorization") String token,
                                                   @Query("id") String id);

    @GET("api/User/getTTcaNhan")
    Observable<Response<ThongTinCaNhan>> getTTcaNhan(@Header("Authorization") String token,
                                                     @Query("uid") String uid);

    @POST("api/User/UpdateTTCaNhan")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateTTCaNhan(@Header("Authorization") String token,
                                                 @Field("UID") String uid,
                                                 @Field("HO_TEN") String HO_TEN,
                                                 @Field("HE_ABO") String HE_ABO,
                                                 @Field("HE_RH") Integer HE_RH,
                                                 @Field("NGAY_SINH") String NGAY_SINH,
                                                 @Field("HO_TEN_BO") String HO_TEN_BO,
                                                 @Field("HO_TEN_ME") String HO_TEN_ME,
                                                 @Field("MA_YT_BO") String MA_YT_BO,
                                                 @Field("MA_YT_ME") String MA_YT_ME,
                                                 @Field("NGUOI_CHAM_SOC") String NGUOI_CHAM_SOC,
                                                 @Field("SO_CMND") String SO_CMND,
                                                 @Field("NGAY_CAP") String NGAY_CAP,
                                                 @Field("NOI_CAP") String NOI_CAP,
                                                 @Field("TT_DIA_CHI_CHI_TIET") String TT_DIA_CHI_CHI_TIET,
                                                 @Field("HT_DIA_CHI_CHI_TIET") String HT_DIA_CHI_CHI_TIET,
                                                 @Field("DIEN_THOAI_NR") String DIEN_THOAI_NR,
                                                 @Field("DIEN_THOAI_DD") String DIEN_THOAI_DD,
                                                 @Field("EMAIL") String EMAIL,
                                                 @Field("QH_NGUOI_CS_ID") Integer QH_NGUOI_CS_ID,
                                                 @Field("HOC_VAN_ID") Integer HOC_VAN_ID,
                                                 @Field("NGHE_NGHIEP_ID") Integer NGHE_NGHIEP_ID,
                                                 @Field("CHUYEN_MON_ID") Integer CHUYEN_MON_ID,
                                                 @Field("DAN_TOC_ID") Integer DAN_TOC_ID,
                                                 @Field("TT_TINH_ID") Integer TT_TINH_ID,
                                                 @Field("TT_HUYEN_ID") Integer TT_HUYEN_ID,
                                                 @Field("TT_XA_ID") Integer TT_XA_ID,
                                                 @Field("TT_THON_XOM_ID") Integer TT_THON_XOM_ID,
                                                 @Field("HT_TINH_ID") Integer HT_TINH_ID,
                                                 @Field("HT_HUYEN_ID") Integer HT_HUYEN_ID,
                                                 @Field("HT_XA_ID") Integer HT_XA_ID,
                                                 @Field("HT_THON_XOM_ID") Integer HT_THON_XOM_ID,
                                                 @Field("QUOC_TICH_ID") Integer QUOC_TICH_ID,
                                                 @Field("GIOI_TINH_ID") Integer GIOI_TINH_ID,
                                                 @Field("TT_HON_NHAN_ID") Integer TT_HON_NHAN_ID,
                                                 @Field("KS_TINH_ID") Integer KS_TINH_ID,
                                                 @Field("TON_GIAO_ID") Integer TON_GIAO_ID,
                                                 @Field("DA_LAP_HS") Integer DA_LAP_HS,
                                                 @Field("NCS_DT_NR") String NCS_DT_NR,
                                                 @Field("NCS_DT_DD") String NCS_DT_DD,
                                                 @Field("MA_THE_BHYT") String MA_THE_BHYT,
                                                 @Field("SO_MUI_ME_TIEM") Integer SO_MUI_ME_TIEM,
                                                 @Field("MA_BHXHVN") String MA_BHXHVN);


    @GET("api/DanhMuc/getTinhThanhPhos")
    Observable<Response<ArrayList<Tinh>>> getTinhThanhPho(@Header("Authorization") String token);

    @GET("api/DanhMuc/getTinhThanhPhoById")
    Observable<Response<Tinh>> getTinhThanhPhoById(@Header("Authorization") String token,
                                                   @Query("id") String id);

    @GET("api/DanhMuc/getQuanHuyens")
    Observable<Response<ArrayList<Huyen>>> getQuanHuyen(@Header("Authorization") String token);

    @GET("api/DanhMuc/getQuanHuyensByMaTinh")
    Observable<Response<ArrayList<Huyen>>> getQuanHuyensByMaTinh(@Header("Authorization") String token,
                                                                 @Query("matinh") String maTinh);

    @GET("api/DanhMuc/getQuanHuyenById")
    Observable<Response<Huyen>> getQuanHuyenById(@Header("Authorization") String token,
                                                 @Query("id") String id);

    @GET("api/DanhMuc/getXaPhuongs")
    Observable<Response<ArrayList<Xa>>> getXaPhuong(@Header("Authorization") String token);

    @GET("api/DanhMuc/getXaPhuongsByMaTinh")
    Observable<Response<ArrayList<Xa>>> getXaPhuongsByMaTinh(@Header("Authorization") String token,
                                                             @Query("matinh") String maTinh);

    @GET("api/DanhMuc/getXaPhuongsByMaHuyen")
    Observable<Response<ArrayList<Xa>>> getXaPhuongsByMaHuyen(@Header("Authorization") String token,
                                                              @Query("mahuyen") String maHuyen);

    @GET("api/DanhMuc/getXaPhuongById")
    Observable<Response<Xa>> getXaPhuongById(@Header("Authorization") String token,
                                             @Query("id") String id);

    @GET("api/DanhMuc/getThonXoms")
    Observable<Response<ArrayList<Thon>>> getThonXom(@Header("Authorization") String token);

    @GET("api/DanhMuc/getThonXomsByMaTinh")
    Observable<Response<ArrayList<Thon>>> getThonXomsByMaTinh(@Header("Authorization") String token,
                                                              @Query("matinh") String maTinh);

    @GET("api/DanhMuc/getThonXomsByMaHuyen")
    Observable<Response<ArrayList<Thon>>> getThonXomsByMaHuyen(@Header("Authorization") String token,
                                                               @Query("mahuyen") String maHuyen);

    @GET("api/DanhMuc/getThonXomsByMaXa")
    Observable<Response<ArrayList<Thon>>> getThonXomsByMaXa(@Header("Authorization") String token,
                                                            @Query("maxa") String maXa);

    @GET("api/DanhMuc/getThonXomById")
    Observable<Response<Thon>> getThonXomById(@Header("Authorization") String token,
                                              @Query("id") String id);

    @GET("api/DuonDayNong/PhanAnhs")
    Observable<Response<LienKetMangXaHoi>> getLienKetMangXaHoi(@Header("Authorization") String token);


    // 1:On ; 0:Off
    @POST("api/User/UpdateUser")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateUser(@Header("Authorization") String token,
                                             @Field("UID") String uid,
                                             @Field("Notifications") Integer isNotify,
                                             @Field("FullName") String fullName,
                                             @Field("BirthDay") String birthday,
                                             @Field("ChieuCao") Double chieuCao,
                                             @Field("CanNang") Double canNang,
                                             @Field("NhomMau") String nhomMau,
                                             @Field("EmailID") String email,
                                             @Field("Phone") String phone,
                                             @Field("MaBS") String maBS,
                                             @Field("DiaChi") String diaChi,
                                             @Field("BenhVienID") Integer benhVienId
    );

    @GET("api/AppInfo/DieuKhoanSuDung")
    Observable<Response<String>> getDieuKhoanSuDung(@Header("Authorization") String token);

    @GET("api/AppInfo/ThongTinApp")
    Observable<Response<String>> getThongTinApp(@Header("Authorization") String token);

    @GET("api/KhaoSat/getChuDeKSs")
    Observable<Response<ArrayList<ChuDeKhaoSat>>> getChuDeKS(@Header("Authorization") String token,
                                                             @Query("uid") String uid);

    @GET("api/KhaoSat/getCauHois")
    Observable<Response<ArrayList<KhaoSatCauHoi>>> getCauHoi(@Header("Authorization") String token,
                                                             @Query("id") Integer id,
                                                             @Query("uid") String uid);


    @POST("api/KhaoSat/TraLoiCauHoi")
    @FormUrlEncoded
    Observable<Response<Boolean>> traLoiCauHoi(@Header("Authorization") String token,
                                               @Field("Uid") String uid,
                                               @Field("KS_CauHoiId") Integer cauHoiId,
                                               @Field("KS_DapAnIds") ArrayList<Integer> dapAns,
                                               @Field("TraLoi") String traLoi);

    @GET("api/ThongBao/getThongBaos")
    Observable<Response<ArrayList<ThongBao>>> getThongBao(@Header("Authorization") String token,
                                                          @Query("uid") String uid);

    @POST("api/ThongBao/CountThongBaosByIsRead")
    @FormUrlEncoded
    Observable<Response<Integer>> countThongBaosByIsRead(@Header("Authorization") String token,
                                                         @Field("uid") String uid,
                                                         @Field("IsRead") Integer isRead);

    @POST("api/ThongBao/UpdateThongBao")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateThongBao(@Header("Authorization") String token,
                                                 @Field("id") Integer id,
                                                 @Field("IsRead") Integer isRead);

    @POST("api/TimKiem")
    @FormUrlEncoded
    Observable<Response<ArrayList<TimKiem>>> timKiem(@Header("Authorization") String token,
                                                     @Field("keyword") String key,
                                                     @Field("loais") ArrayList<Integer> loai,
                                                     @Field("uutien") ArrayList<Integer> uuTien);

    @GET("api/DanhMuc/getBenhViensDeXuat")
    Observable<Response<ArrayList<BenhVien>>> getBenhViensDeXuat(@Header("Authorization") String token,
                                                                 @Query("diadiem") String diaDiem);

    @GET("api/DanhMuc/getBenhViensByDiaDiem")
    Observable<Response<ArrayList<BenhVien>>> getBenhViensByDiaDiem(@Header("Authorization") String token,
                                                                    @Query("diadiem") String diaDiem);


    @POST("api/ThongBao/getThongBaosByGroupPage")
    @FormUrlEncoded
    Observable<Response<ArrayList<ThongBao>>> getThongBaosByGroupPage(@Header("Authorization") String token,
                                                                      @Field("uid") String uid,
                                                                      @Field("group") Integer group,
                                                                      @Field("PageNum") Integer pageNum,
                                                                      @Field("PageSize") Integer pageSize);

    @POST("api/DuonDayNong/CreatePhanAnh")
    @FormUrlEncoded
    Observable<Response<Integer>> createPhanAnh(@Header("Authorization") String token,
                                                @Field("UID") String uid,
                                                @Field("TIEU_DE_PA") String tieuDePA,
                                                @Field("ID_MUC_PHAN_ANH") Integer chuDe,
                                                @Field("ID_NOI_PHAN_ANH") Integer noiPhanAnh,
                                                @Field("NOI_DUNG") String noiDung,
                                                @Field("MUC_DO_CONG_KHAI_ID") Integer mucDoCongKhai,
                                                @Field("HO_TEN") String hoTen,
                                                @Field("SDT") String SDT,
                                                @Field("EMAIL") String email,
                                                @Field("DIA_CHI") String diaChi
    );

    @GET("api/DuonDayNong/PhanAnhs")
    Observable<Response<ArrayList<PhanAnh>>> getPhanAnh(@Header("Authorization") String token,
                                                        @Query("uid") String uid);

    @FormUrlEncoded
    @POST("api/DuonDayNong/getPhanAnhPage")
    Observable<Response<ArrayList<PhanAnh>>> getListPhanAnh(@Header("Authorization") String token,
                                                            @Field("UID") String uid,
                                                            @Field("Key") String key,
                                                            @Field("Muc_Cong_Khai") Integer mucCongKhai,
                                                            @Field("Id_Muc_PA") Integer mucPAID,
                                                            @Field("ID_Noi_PA") Integer noiPAID,
                                                            @Field("OrderBy") Integer orderBy,
                                                            @Field("PageNum") Integer PageNum,
                                                            @Field("PageSize") Integer PageSize
    );

    @GET("api/DuonDayNong/getPhanAnhsByIdMucPA")
    Observable<Response<ArrayList<PhanAnh>>> getPhanAnhMoiNguoi(@Header("Authorization") String token,
                                                                @Query("id") Integer id);

    @GET("api/DuonDayNong/PhanAnhCSYTs")
    Observable<Response<ArrayList<PhanAnh>>> getPhanAnhCSYT(@Header("Authorization") String token,
                                                            @Query("idbenhvien") Integer idbenhvien);

    @GET("api/DuonDayNong/getPhanAnhById")
    Observable<Response<PhanAnh>> getPhanAnhById(@Header("Authorization") String token,
                                                 @Query("uid") String uid,
                                                 @Query("id") Integer id);

    @POST("api/DuonDayNong/TLPhanAnh")
    @FormUrlEncoded
    Observable<Response<Boolean>> traLoiPhanAnh(@Header("Authorization") String token,
                                                @Field("Id") Integer id,
                                                @Field("NoiDung") String noiDung);

    @POST("api/DuonDayNong/AddComment")
    @FormUrlEncoded
    Observable<Response<Integer>> addComment(@Header("Authorization") String token,
                                             @Field("UID") String uid,
                                             @Field("IdPhanAnh") Integer id,
                                             @Field("NOI_DUNG") String noiDung,
                                             @Field("HO_TEN") String hoTen,
                                             @Field("SDT") String sdt,
                                             @Field("EMAIL") String email,
                                             @Field("DIA_CHI") String diaChi
    );

    @Multipart
    @POST("api/DuonDayNong/UploadBL")
    Observable<Response<Boolean>> uploadImageComment(@Header("Authorization") String token,
                                                     @Part("id") RequestBody id,
                                                     @Part ArrayList<MultipartBody.Part> image
    );

    @POST("api/DuonDayNong/AddDanhGia")
    @FormUrlEncoded
    Observable<Response<Boolean>> addDanhGia(@Header("Authorization") String token,
                                             @Field("UID") String uid,
                                             @Field("IdPhanAnh") Integer id,
                                             @Field("DANH_GIA") Float danhGia,
                                             @Field("HO_TEN") String hoTen,
                                             @Field("SDT") String sdt,
                                             @Field("EMAIL") String email,
                                             @Field("DIA_CHI") String diaChi
    );

    @GET("api/getLoais")
    Observable<Response<ArrayList<TimKiemLoc>>> getLoaiTimKiem(@Header("Authorization") String token);

    @GET("api/getUuTiens")
    Observable<Response<ArrayList<TimKiemLoc>>> getTimKiemUuTien(@Header("Authorization") String token);

    @GET("api/ThongKe/Dashboard")
    Observable<Response<Dashboard>> getDashboard(@Header("Authorization") String token,
                                                 @Query("uid") String uid);

    @POST("api/User/getDanhBasPage")
    @FormUrlEncoded
    Observable<Response<ArrayList<DanhBa>>> getDanhBasPage(@Header("Authorization") String token,
                                                           @Field("uid") String uid,
                                                           @Field("PageNum") Integer pageNum,
                                                           @Field("PageSize") Integer pageSize);

    @POST("api/User/getDanhBasPageByKey")
    @FormUrlEncoded
    Observable<Response<ArrayList<DanhBa>>> getDanhBasPageByKey(@Header("Authorization") String token,
                                                                @Field("uid") String uid,
                                                                @Field("Key") String key,
                                                                @Field("PageNum") Integer pageNum,
                                                                @Field("PageSize") Integer pageSize);

    @GET("api/DuonDayNong/CauHoiThuongGap")
    Observable<Response<ArrayList<CauHoiThuongGap>>> getCauHoiThuongGap(@Header("Authorization") String token);

    @POST("api/DanhMuc/UpdateBenhVien")
    @FormUrlEncoded
    Observable<Response<Boolean>> updateBenhVien(@Header("Authorization") String token,
                                                 @Field("ID") Integer id,
                                                 @Field("TEN") String ten,
                                                 @Field("DIA_CHI") String diaChi,
                                                 @Field("WEBSITE") String website,
                                                 @Field("HOTLINE") String hotline,
                                                 @Field("THOI_GIAN") String thoiGian,
                                                 @Field("EMAIL") String email,
                                                 @Field("THANH_TICH") String thanhTich,
                                                 @Field("DM_KHOAs") ArrayList<Integer> mucDoCongKhai
    );


    @Multipart
    @POST("api/DanhMuc/BenhVien/UploadAvatar")
    Observable<Response<Boolean>> updateBenhVienAvatar(@Header("Authorization") String token,
                                                       @Part("uid") RequestBody id,
                                                       @Part MultipartBody.Part image
    );


    @GET("api/HSSK/getAllHSSKByUID")
    Observable<Response<ArrayList<BenhNhan>>> getListBenhNhan(@Header("Authorization") String token,
                                                              @Query("uid") String uid);

    @GET("api/DuonDayNong/getMucPhanAnhs")
    Observable<Response<ArrayList<ChuDePhanAnh>>> getChuDePhanAnh(@Header("Authorization") String token);

    @GET("api/DuonDayNong/getDiaDiemPhanAnhs")
    Observable<Response<ArrayList<DiaDiemPhanAnh>>> getDiaDiemPhanAnh(@Header("Authorization") String token);

    @Multipart
    @POST("api/DuonDayNong/Upload")
    Observable<Response<Boolean>> updateAnhPhanAnh(@Header("Authorization") String token,
                                                   @Part("id") RequestBody id,
                                                   @Part ArrayList<MultipartBody.Part> image
    );

    @GET("api/User/CreateQCode")
    Observable<Response<String>> getQRCode(@Header("Authorization") String token,
                                           @Query("maytecanhan") String maYTCN);


}
