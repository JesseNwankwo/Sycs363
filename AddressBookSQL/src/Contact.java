
import java.util.*;
import java.sql.*;

public class Contact{      
	private ArrayList personsList;
	public Connection myconn;
	
	 String url = "jdbc:mysql://localhost:3306/addressbook";
	 String user = "jesse";
	 String password = "bustaman";
	 	
	 	// constructor 
		public Contact(){
			personsList = new ArrayList();
			getConnection();		//Create Connection to the Oracle Database
		}

		public Connection getConnection(){
					
			try {
				myconn = DriverManager.getConnection(url, user, password);

				} catch(SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
			return myconn;
		}
	public ArrayList searchPerson(String name)
	{
		try	{
			String sql = "SELECT * FROM Person WHERE name like '%"+name+"%'";

			// Create a prepared statement
 			Statement s = myconn.createStatement();

			ResultSet rs = s.executeQuery("select * from person");

            String pname = "";
            String address = "";
            String email = "";
            String phone = "";

			while(rs.next())
			{
				pname = rs.getString("name");
				address = rs.getString("address");
				phone = rs.getString("phone");
				email = rs.getString("email");

				//Create a PersonInfo object
				PersonInfo person = new PersonInfo(pname, address, phone, email);
				//Add the person object to array list
				personsList.add(person);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
           
		return personsList;

	} 

	public void savePerson(PersonInfo person){
		try
		{
			String sql = "INSERT INTO Person(name, address, " +
							"phone, email) VALUES (?,?,?,?) ";

			// Create a Prepared statement
 			PreparedStatement ps = myconn.prepareStatement(sql);
			ps.setString(1, person.getName());
			ps.setString(2, person.getAddress());
			ps.setString(3, person.getPhone());
			ps.setString(4, person.getEmail());
			ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public void updatePerson(PersonInfo person)
	{
		try
		{
			String sql = "UPDATE Person SET name = ?, address=? , " +
					"phone=? , email=? where id=?";

			// Create a Prepared statement
 			PreparedStatement ps = myconn.prepareStatement(sql);
	
			ps.setString(1 , person.getName());		
			ps.setString(2 , person.getAddress());
			ps.setString(3 , person.getPhone());
			ps.setString(4 , person.getEmail());
			ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public int removePerson(String name){
        int no = 0;
		try{
			String sql = "DELETE FROM Person WHERE name = ?";
			// Create a Prepared statement
 			PreparedStatement ps = myconn.prepareStatement(sql);
			ps.setString(1, name);
			no = ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return no;
	}

}