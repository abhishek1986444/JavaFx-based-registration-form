package com.example;

import java.sql.SQLException;

import java.sql.*;

import java.sql.PreparedStatement; 



@SuppressWarnings(  "unused" )
public class controller {

    private struct object ;


public  controller () throws Exception{

    DBconnection connection = new DBconnection() ;

    object = connection.getConnection();



}
 


public  void  register() throws SQLException  // add register function in the controller.java file 

 
{


String userinput = " insert into userrecord (userid , mailid , password, username ) values ( ?, ? , ?  , ? )  ;   " ; 

PreparedStatement ps = object.connection.prepareStatement(userinput);


String  user_id = "" , mail_id = "" , password = "" , username = "" ;





ps.setString( 1,user_id );
ps.setString( 2,mail_id);

ps.setString( 3, password);

ps.setString( 4, username );


System.out.println(ps.executeUpdate());

ps.close();

object.connection.close();



}


public  void main ( String [] arg ) throws SQLException
{

    register();

    System.out.println("function is executed succesfully !! ");


}

    
}



