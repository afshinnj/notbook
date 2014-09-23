/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataAccess.DataAccess;
import Helper.BCrypt;



/**
 *
 * @author afshin
 */
public class Login {
 
   
    DataAccess da = new DataAccess();
    public int id;
    public String first_name;
    public String last_name;
    public String username;
    public String password;

    public enum ColumnIndex {

        id(0), first_name(1), last_name(2), username(3), password(6);
        private final int Code;

        ColumnIndex(int code) {
            Code = code;
        }

        public int getCode() {
            return Code;
        }
    }
// and epassword='%s'
    public boolean CanLogin() {
        boolean r = false;
        
        String sql = "select * from tblog_user where username='%s'";
        sql = String.format(sql, this.username);
        String[][] data = da.Select(sql);
        if (data != null) {
            if (data.length > 0) {
                this.username = data[0][ColumnIndex.username.getCode()];
                r = BCrypt.checkpw(password, data[0][ColumnIndex.password.getCode()]);
            }
        }
        return r;
    }
    
}
