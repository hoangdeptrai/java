
/**
 * Write a description of class Sach here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sach extends TaiLieu
{
    private String tg;
    private int st;
    
    public Sach(String maTL, String nxb, int sbph, String tg, int st){
        super(maTL, nxb, sbph);
        this.tg = tg;
        this.st = st;
    }
    
    public String thongTin(){
        String tt = super.thongTin() + "\n Tac Gia: " + tg + "\n So trang: " + st;
        return tt;
    }
    
    public String getTg(){
        return tg;
    }
    
    public int getSt(){
        return st;
    }
    
    public void setTg(String tg){
        this.tg = tg;
        
    }
    
    public void setSt(int st){
        this.st = st;
    }
}
