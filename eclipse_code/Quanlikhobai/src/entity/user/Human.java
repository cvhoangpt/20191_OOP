package entity.user;

/**
 * Lớp khai báo đối tượng Human
 * @author hoangcv
 *
 */
public class Human 
{
	protected String tenChuXe;
	
	public Human() {}
	public Human(String tenChuXe)
	{
		this.tenChuXe = tenChuXe;
	}
	public void setTenChuXe(String tenChuXe)
	{
		this.tenChuXe = tenChuXe;
	}
	public String getTenChuXe()
	{
		return tenChuXe;
	}
}
