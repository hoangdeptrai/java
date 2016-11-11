
/**
 * Write a description of class TapChi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TapChi extends TaiLieu
{
    // instance variables - replace the example below with your own
    private int sph;
    private String tph;

    /**
     * Constructor for objects of class TapChi
     */
    public TapChi(String maTL, String nxb, int sbph, int sph, String tph){
        super(maTL, nxb, sbph);
        this.sph = sph;
        this.tph = tph;
    }

    public String thongTin(){
        String tt = super.thongTin() + "\n So Phat Hanh: " + sph + "\n Thang Phat Hanh: " + tph;
        return tt;
    }
    
    // Viet them set, get
}
