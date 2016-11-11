import java.util.Date;
/**
 * Write a description of class Bao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bao extends TaiLieu
{
    private Date nph;
    
    public Bao(String maTL, String nxb, int sbph, Date nph){
        super(maTL, nxb, sbph);
        this.nph = nph;
    }
    
    public String thongTin(){
        String tt = super.thongTin() + "\n Ngay Phat Hanh: " + nph;
        return tt;
    }
    
    // Viet them set, get
}
