package DataAccess;

import java.sql.*;

public class DataAccess 
{
    public String ServerName = "localhost";
    public int Port = 3306;
    public String DBName = "tom";
   // public String Prefix = "tblog_";
    public String userName = "root";
    public String Password = "123456";
    public int rowCount = -1;
    
    private Connection con;
    private Statement st;
    
    public DataAccess() 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    private void Connect() 
    {
       
        try
        {
            String url="jdbc:mysql://%s:%s/%s?useUnicode=true&characterEncoding=UTF-8&user=%s&password=%s";
            url = String.format(url,this.ServerName,this.Port,this.DBName,this.userName,this.Password);
            con = DriverManager.getConnection(url);
            st = con.createStatement();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    private void Disconnect()
    {
        try 
        {
            st.close();
            con.close();
        }
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }
    
    public String[][] Select(String sql)
    {
        String[][] data=null;
        Connect();
        try
        {
            st.executeQuery(sql);
            try (ResultSet rs = st.getResultSet()) {
                int col=rs.getMetaData().getColumnCount();
                rs.last();
                int row = rs.getRow();
                rowCount = row;
                rs.beforeFirst();
                
                data = new String[row][col];
                int i=0;
                while(rs.next()) {
                    for(int j=0;j<col;j++) {
                        data[i][j] = rs.getString(j+1);
                    }
                    i++;
                }
            }
        }
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
        Disconnect();
        return data;
    }
    
    public void Docommand(String sql)
    {
        Connect();
        try
        {
            st.execute(sql);
        }
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
        Disconnect();
    }
    
    public int getRow()
    {
       return rowCount;
    }
}   

