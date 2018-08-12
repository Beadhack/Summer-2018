public void deleteDB(){
        try{
            System.out.println("Starting deleteDB............");

                //Load Driver - Step #1
            Connection con=
                DriverManager.getConnection("jdbc:ucanaccess://C:/Users/"
                         + "prtaylor/Desktop/RegistrationMDB.mdb");

                //Create Statement - Step #3
            Statement stmt = con.createStatement();

                //  Execute Statement - Step #4
            String sql;
            sql = "delete from Students where ID = "+getSID();
																			 
            System.out.println(sql);
            int resultFlag; //integer returned on completion of update - should be number of lines worked on
            resultFlag = stmt.executeUpdate(sql);
			
                //Close Connection - Step #6
                con.close();

        }catch(Exception e){
            System.out.println("pp: " + e);
        }
    }//end insertDB() method

