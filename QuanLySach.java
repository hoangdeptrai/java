import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Write a description of class QuanLySach here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuanLySach
{
    private ArrayList<TaiLieu> ds = new ArrayList<TaiLieu>();
    
    public void nhapTaiLieuTuBanPhim(Scanner sc) throws Exception{
        
        char c;
        while (true){ // Lap cho den khi bam phim ESC (Escape)
            System.out.print("Loai tai lieu ban muon nhap (Sach: S, Bao: B, TapChi: T): ");
            c = sc.nextLine().charAt(0);
            switch (c){
                case 'S': case 's': {// Gop 2 truong hop chu Hoa, chu Thuong do cùng cách xu ly
                    ds.add(nhapSach(sc));// Sau khi nhap thong tin thi them vao danh sach ArrayList
                    break;
                }
                case 'B': case 'b': {
                    ds.add(nhapBao(sc));
                    break;
                }
                case 'T': case 't': {
                    ds.add(nhapTapChi(sc));
                    break;
                }
            }
            System.out.print("Ban muon nhap tiep khong (Y/N): ");
            c = sc.nextLine().charAt(0);
            if(c == 'n' || c == 'N'){
                System.out.println("Ket thuc nhap du lieu. So tai lieu da nhap: " + ds.size());
                break; // Thoat khoi vong lap while
            }
            
        }
        System.out.println("-------------------------------");
        
    }
    public TaiLieu nhapSach(Scanner sc){
        System.out.print("Nhap ma tai lieu: "); String maTL = sc.nextLine();
        System.out.print("Nhap nha xuat ban: "); String nxb = sc.nextLine();
        System.out.print("Nhap so ban phat hanh: "); int sbph = sc.nextInt();sc.nextLine();// Một số trường hợp cần thêm
                                                       // lệnh sc.nextLine() để khử phím Enter trong bộ nhớ đệm
        System.out.print("Nhap tac gia: "); String tg = sc.nextLine();
        System.out.print("Nhap so trang: "); int st = sc.nextInt();sc.nextLine();
        return new Sach(maTL, nxb, sbph, tg, st);
    }
    public TaiLieu nhapBao(Scanner sc)throws Exception{
        System.out.print("Nhap ma tai lieu: "); String maTL = sc.nextLine();
        System.out.print("Nhap nha xuat ban: "); String nxb = sc.nextLine();
        System.out.print("Nhap so ban phat hanh: "); int sbph = sc.nextInt();sc.nextLine();
        
        System.out.print("Nhap ngay phat hanh (dd-mm-yyyy): "); String nph = sc.nextLine(); // Dinh dang dd-MM-yyyy
        DateFormat df = new SimpleDateFormat ("dd-MM-yyyy"); 
        Date ngayph = df.parse(nph); // Neu khong dung dinh dang Java se tra ve mot ngoai le (Exception)
                                        // Vi vay o ten phuong thuc phai khai bao 'throws Exception' (day là 1 cach xu ly)
                                        // Cac phuong thuc nao ma goi den phuong thuc nay cung phai 'throws Exception'
        
        return new Bao(maTL, nxb, sbph, ngayph);
    }
    public TaiLieu nhapTapChi(Scanner sc){
        System.out.print("Nhap ma tai lieu: "); String maTL = sc.nextLine();
        System.out.print("Nhap nha xuat ban: "); String nxb = sc.nextLine();
        System.out.print("Nhap so ban phat hanh: "); int sbph = sc.nextInt();sc.nextLine();
        System.out.print("So phat hanh: "); int sph = sc.nextInt();sc.nextLine();
        System.out.print("Thang phat hanh: "); String tph = sc.nextLine(); // Dinh dang thang/nam vi du 9/2009
        return new TapChi(maTL, nxb, sbph, sph, tph);
    }
    
    public void nhapTaiLieu(){
        TaiLieu tl1 = new Sach("S001","KHKT", 300, "Nguyen Cong Hoan", 400);
        TaiLieu tl2 = new Sach("S002","KHKT", 300, "Nguyen Cong Hoan", 400);
        TaiLieu tl3 = new Sach("S003","KHKT", 500, "Nguyen Cong Hoan", 400);
        
        TaiLieu tl4 = new Bao("B001","KHKT", 300, new Date());
        TaiLieu tl5 = new Bao("B002","KHKT", 300, new Date());
        TaiLieu tl6 = new TapChi("TC001","KHKT", 300, 5, "9/2014");
        TaiLieu tl7 = new TapChi("TC002","KHKT", 300, 6, "10/2014");
        TaiLieu tl8 = new TapChi("TC003","KHKT", 300, 8, "9/2015");
        
        ds.add(tl1);
        ds.add(tl2);
        ds.add(tl3);
        ds.add(tl4);
        ds.add(tl5);
        ds.add(tl6);
        ds.add(tl7);
        ds.add(tl8);
        
    }
    
    public void timKiemTheoLoai(Scanner sc){
        System.out.print("Nhap loai tai lieu muon tim (Sach, Bao, TapChi): ");
        String loai = sc.nextLine();
        for (int i=0; i<ds.size();i++){
            if(loai.equals("Sach")){ // Dể không bắt người dùng phải nhập chính xác hoa thường, có thể dùng hàm equalsIgnoreCase
                if(ds.get(i) instanceof Sach){
                System.out.println(ds.get(i).thongTin());
                }
            }else if(loai.equals("Bao")){
                if(ds.get(i) instanceof Bao){
                System.out.println(ds.get(i).thongTin());
                }
            }else{
                if(ds.get(i) instanceof TapChi){
                System.out.println(ds.get(i).thongTin());
                }
            }    
            
        }
        System.out.println("-------------------------------");
    }
    
    public void timKiemTheoMa(Scanner sc){
        System.out.print("Nhap ma tai lieu muon tim: ");
        String maTL = sc.nextLine();// Sinh vien có thể mở rộng cho phép người dùng chỉ nhập một phần của mã và tìm các
        // tài liệu có mã gần giống (chuyển tất cả mã về chữ thường (hàm toLowerCase), 
        // kiểm tra xâu con có trong xâu mẹ không (dùng hàm indexOf của lớp String)
        for (int i=0; i<ds.size();i++){
           String tg = ds.get(i).getMaTL();
           if(tg.equals(maTL)){
               System.out.println(ds.get(i).thongTin());
            }
        }
        System.out.println("-------------------------------");
    }
    
    public static void main(String[] args) throws Exception{
        QuanLySach qls = new QuanLySach();
        Scanner sc = new Scanner(System.in);
        qls.nhapTaiLieuTuBanPhim(sc);
        //qls.timKiem("Bao", 1);
        qls.timKiemTheoLoai(sc);
        qls.timKiemTheoMa(sc);
    }
}
