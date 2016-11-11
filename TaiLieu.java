
/**
 * Write a description of class TaiLieu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TaiLieu
{
    private String maTL;
    private String nxb;
    private int sbph;
    
    public TaiLieu(String maTL, String nxb, int sbph){
        this.maTL = maTL;
        this.nxb = nxb;
        this.sbph = sbph;
    }
    
    public String thongTin(){
        String tt = "Ma tai lieu: " + maTL + "\n Nha Xuat Ban: " + nxb + "\n So ban phat hanh: " + sbph;
        return tt;
    }
    
    public void setMaTL(String maTL){
        this.maTL = maTL;
    }
    
    public String getMaTL(){
        return maTL;
    }
    
    public void setNxb(String nxb){
        this.nxb = nxb;
    }
    
    public String getNxb(){
        return nxb;
    }
    
    public void setSbph(int sbph){
        this.sbph = sbph;
    }
    
    public int getSbph(){
        return sbph;
    }
}
