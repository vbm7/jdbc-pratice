
import java.util.*;
import java.sql.*;

class Main{
    static void Insertde(Connection c, Scanner op) throws SQLException {
        System.out.println("Enter id ");

        int id =op.nextInt();
        System.out.println("Enter Name");

        String name=op.next();


        String sql="insert into stud values(?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,name);
        int row =ps.executeUpdate();
        System.out.println(row+" "+"executed");
    }


    static void Searchde(Connection c,Scanner op) throws SQLException {
        System.out.println("Enter id");
        int id=op.nextInt();

        String sql="Select * from stud Where roll_no=?";

        PreparedStatement ps=c.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        if(rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }
        else{
            System.out.println("Error no data");
        }

    }
    static void Updatede(Connection c, Scanner op) throws SQLException {
        System.out.println("Enter id ");

        int id =op.nextInt();
        System.out.println("Enter Name");

        String name=op.next();


        String sql="update stud set name=? where roll_no=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,name);
        ps.setInt(2,id);
        int row =ps.executeUpdate();
        System.out.println(row+" "+"executed");
    }


    static void Deletede(Connection c, Scanner op) throws SQLException {
        System.out.println("Enter id ");

        int id =op.nextInt();



        String sql="delete from  stud  where roll_no=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1,id);
        int row =ps.executeUpdate();
        System.out.println(row+" "+"executed");
    }


    static void Viewde(Connection c) throws SQLException {

        String sql="Select * from stud";

        PreparedStatement ps=c.prepareStatement(sql);

        ResultSet rs=ps.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }
    }




    public static void main(String args[]) throws SQLException {
       Scanner op = new Scanner(System.in);

       String url="jdbc:mysql://localhost:3306/pratice";
       String Name="root";
       String Pass="psbalamurali7";
       Connection c= DriverManager.getConnection(url,Name,Pass);
       System.out.println("Connection Established");
      // ArrayList<Student> a =new ArrayList<>();
       Scanner sc=new Scanner(System.in);
       //Student s = new Student();

      /* s.setid(1);
       s.setname("balamurali");
       a.add(s);

       s = new Student();
       s.setid(2);
       s.setname("rajupoona");
       a.add(s);

       s = new Student();
       s.setid(3);
       s.setname("padhumadu");
       a.add(s);
*/



       while (true) {
           System.out.println("1  Insert");
           System.out.println("2  Search");
           System.out.println("3  Update");
           System.out.println("4  delete");
           System.out.println("5  view");
           System.out.println("6  Exit");

           int ch=op.nextInt();
           switch (ch) {
               case 1:
                  Insertde(c, op);
                   break;
               case 2:
                   Searchde(c, op);
                   break;
               case 3:
                 Updatede(c, op);
                   break;
               case 4:
                   Deletede(c, op);
                   break;
               case 5:
                   Viewde(c);
                   break;
               case 6:
                   System.exit(0);
           }


       }
   }}
