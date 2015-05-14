
public class PersonInfo
{
	private String name,address,email,phone;

      // default constructor
      public PersonInfo()
      {       
         name = "";
         address = "";
         email = "";
         phone = "";
      }

	public PersonInfo( String name, String address, String phone, String email)
	{
       // this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
 
      // setters
	public void setName(String n)
	{
		name=n;		
	}
	public void setAddress(String a)
	{
		address=a;
	}
	public void setPhone(String ph)
	{
		phone=ph;
	}
	public void setEmail(String e)
	{
		email=e;
	}
      // getters
	public String getName()
	{
		return name;
	}

	public String getAddress()
	{
		return address;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getEmail()
	{
		return email;
	}

}