/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataAccess.DataAccess;
import Helper.Tools;

/**
 *
 * @author afshin
 */
public class User {

    DataAccess da = new DataAccess();

    public int id;
    public String first_name;
    public String last_name;
    public String username;
    public String crate_time  = Tools.currentTime();
    public String update_time = Tools.currentTime();
    public String password;

    public Boolean Insert() {

        String sql = "INSERT INTO  `tblog_user` (`id`, `first_name`, `last_name`, `username`, `create_time`, `update_time`, `password`)"
                + "VALUES (NULL ,'%s', '%s', '%s', '%s', '%s', '%s');";
        sql = String.format(sql,this.first_name, this.last_name, this.username, this.crate_time, this.update_time, this.password);
        da.Docommand(sql);
        return true;
    }

    public Boolean Update() {

        String sql = "UPDATE `tblog_user` SET `first_name` = '%s' , `last_name` = '%s' , `username`  = '%s' , `update_time` = '%s' , `password`='%s'  WHERE `tblog_user`.`id` =  %s ;";
          
        sql = String.format(sql,this.first_name, this.last_name, this.username, this.update_time, this.password, this.id);
        da.Docommand(sql);
        return true;
    }

    public Boolean Delete() {

        String sql = "DELETE FROM `tblog_user` WHERE `tblog_user`.`id` = " + this.id + "";
        da.Docommand(sql);
        return true;
    }

}
