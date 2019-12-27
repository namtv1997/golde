package com.app.goldenhealth.model;

public enum DanhMucType {
    BenhNgheNghiep, BenhVien, BienPhapTranhThai, ChuyenMon, DanToc, DoiTuong, DuongDung, GioiTinh, ICD, KhangNguyen,
    KhuVuc, KQDT, LoaiCTCSSK, LoaiKCB, MaNhom, NgheNghiep, NhomBenh, QHGiaDinh, QuanHuyen, QuocGia, TaiBien, TaiNan,
    ThonXom, TinhThanhPho, TonGiao, TinhTrangHonNhan, TTRV, VacXinTE, VacXinKhac, XaPhuong, HocVan, LoaiHoXi, LoaiDiUng, LoaiBenh,
    MucDoCongKhai;

    private String apiListPath;
    private String apiDetailPath;

    public String getApiListPath() {
        switch (this) {
            case BenhNgheNghiep: return "/api/DanhMuc/getBenhNgheNghieps";
            case BenhVien: return "/api/DanhMuc/getBenhViens";
            case BienPhapTranhThai: return "//api/DanhMuc/getBienPhapTranhThais";
            case ChuyenMon: return "/api/DanhMuc/getChuyenMons";
            case DanToc: return "/api/DanhMuc/getDanTocs";
            case DoiTuong: return "/api/DanhMuc/getDoiTuongs";
            case DuongDung: return "/api/DanhMuc/getDuongDungs";
            case GioiTinh: return "/api/DanhMuc/getGioiTinhs";
            case ICD: return "/api/DanhMuc/getICDs";
            case KhangNguyen: return "/api/DanhMuc/getKNguyens";
            case KhuVuc: return "/api/DanhMuc/getKhuVucs";
            case KQDT: return "/api/DanhMuc/getKQDTs";
            case LoaiCTCSSK: return "/api/DanhMuc/getLoaiCTCSSKs";
            case LoaiKCB: return "/api/DanhMuc/getLoai_KCBs";
            case MaNhom: return "/api/DanhMuc/getMaNhoms";
            case NgheNghiep: return "/api/DanhMuc/getNgheNghieps";
            case NhomBenh: return "/api/DanhMuc/getNhomBenhs";
            case QHGiaDinh: return "/api/DanhMuc/getQHGiaDinhs";
            case QuanHuyen: return "/api/DanhMuc/getQuanHuyensByMaTinh";
            case QuocGia: return "/api/DanhMuc/getQuocGias";
            case TaiBien: return "/api/DanhMuc/getTaiBiens";
            case TaiNan: return "/api/DanhMuc/getTaiNans";
            case ThonXom: return "/api/DanhMuc/getThonXomsByMaXa";
            case TinhThanhPho: return "/api/DanhMuc/getTinhThanhPhos";
            case TonGiao: return "/api/DanhMuc/getTonGiaos";
            case TinhTrangHonNhan: return "/api/DanhMuc/getTinhTrangHonNhans";
            case TTRV: return "/api/DanhMuc/getTTRVs";
            case VacXinTE: return "/api/DanhMuc/getVacXinTEs";
            case VacXinKhac: return "/api/DanhMuc/getVXKhacs";
            case XaPhuong: return "/api/DanhMuc/getXaPhuongsByMaHuyen";
            case HocVan: return "/api/DanhMuc/getHocVans";
            case LoaiHoXi: return "/api/DanhMuc/getLoaiHoXis";
            case LoaiDiUng: return "/api/DanhMuc/getDiUngs";
            case LoaiBenh: return "/api/DanhMuc/getLoaiBenhs";
            case MucDoCongKhai: return "/api/DanhMuc/getMucDoCongKhais";
            default: return "";
        }
    }

    public String getApiDetailPath() {
        switch (this) {
            case BenhNgheNghiep: return "/api/DanhMuc/getBenhNgheNghiepById";
            case BenhVien: return "/api/DanhMuc/getBenhVienById";
            case BienPhapTranhThai: return "/api/DanhMuc/getBienPhapTranhThaiById";
            case ChuyenMon: return "/api/DanhMuc/getChuyenMonById";
            case DanToc: return "/api/DanhMuc/getDanTocById";
            case DoiTuong: return "/api/DanhMuc/getDoiTuongById";
            case DuongDung: return "/api/DanhMuc/getDuongDungById";
            case GioiTinh: return "/api/DanhMuc/getGioiTinhById";
            case ICD: return "/api/DanhMuc/getICDById";
            case KhangNguyen: return "/api/DanhMuc/getKNguyenById";
            case KhuVuc: return "/api/DanhMuc/getKhuVucById";
            case KQDT: return "/api/DanhMuc/getKQDTById";
            case LoaiCTCSSK: return "/api/DanhMuc/getLoaiCTCSSKById";
            case LoaiKCB: return "/api/DanhMuc/getLoaiKCBById";
            case MaNhom: return "/api/DanhMuc/getMaNhomById";
            case NgheNghiep: return "/api/DanhMuc/getNgheNghiepById";
            case NhomBenh: return "/api/DanhMuc/getNhomBenhById";
            case QHGiaDinh: return "/api/DanhMuc/getQHGiaDinhById";
            case QuanHuyen: return "/api/DanhMuc/getQuanHuyenById";
            case QuocGia: return "/api/DanhMuc/getQuocGiaById";
            case TaiBien: return "/api/DanhMuc/getTaiBienId";
            case TaiNan: return "/api/DanhMuc/getTaiNanById";
            case ThonXom: return "/api/DanhMuc/getThonXomById";
            case TinhThanhPho: return "/api/DanhMuc/getTinhThanhPhoById";
            case TonGiao: return "/api/DanhMuc/getTonGiaoById";
            case TinhTrangHonNhan: return "/api/DanhMuc/getTinhTrangHonNhanById";
            case TTRV: return "/api/DanhMuc/getTTRVById";
            case VacXinTE: return "/api/DanhMuc/getVacXinTEById";
            case VacXinKhac: return "/api/DanhMuc/getVXKhacById";
            case XaPhuong: return "/api/DanhMuc/getXaPhuongById";
            case HocVan: return "/api/DanhMuc/getHocVanById";
            case LoaiHoXi: return "/api/DanhMuc/getLoaiHoXiById";
            case LoaiDiUng: return "/api/DanhMuc/getLoaiDiUngById";
            case LoaiBenh: return "/api/DanhMuc/getLoaiBenhById";
            case MucDoCongKhai: return "/api/DanhMuc/getMucDoCongKhaiById";
            default: return "";
        }
    }
}
