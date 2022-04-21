
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    String dbURL="jdbc:mysql://localhost:3306/its340?autoReconnect=true";
       Connection conn=DBUtils.ConnectToMySQLDB(dbURL,"root","password");
       
       
       public List<Patient> findAllPatient(){
          List <Patient> patients = new ArrayList <>();
          String qry="SELECT PatientID,PtLastName,PtFirstName FROM patienttable ORDER BY PatientID";
               try{      
                   Statement stmt=conn.createStatement();
                   ResultSet rs= stmt.executeQuery(qry);
                   
                   while(rs.next()){
                       Patient temp = new Patient();
                       temp.setPatientID(rs.getInt(1));
                       temp.setLastName(rs.getString(2));
                       temp.setFirstName(rs.getString(3));
                       patients.add(temp);
                       //System.out.println("Temp: "+rs.getInt(1)+", "+rs.getString(2)+", "+rs.getString(4));
                   }
               }
               catch(Exception e){
                   e.getMessage();
               }
               return patients;
       }
       
        public Patient findPatient(String patientID){
          Patient temp = new Patient();
          String qry="SELECT * FROM patienttable WHERE PatientID= ";
               try{      
                   Statement stmt=conn.createStatement();
                   ResultSet rs= stmt.executeQuery(qry+ patientID);
                   
                   while(rs.next()){
                       
                       temp.setPatientID(rs.getInt(1));
                       temp.setLastName(rs.getString(2));
                       temp.setPrevLastname(rs.getString(3));
                       temp.setFirstName(rs.getString(4));
                       temp.setHomeAddress1(rs.getString(5));
                       temp.setHomeAddress2(rs.getString(6));
                       temp.setHomeCity(rs.getString(7));
                       temp.setHomeState(rs.getString(8));
                       temp.setHomeZip(rs.getString(9));
                       temp.setCountry(rs.getString(10));
                       temp.setCityzenship(rs.getString(11));
                       temp.setHomePhone(rs.getString(12));
                       temp.setEmergencyPhone(rs.getString(13));
                       temp.setEmail(rs.getString(14));
                       temp.setPtss(rs.getString(15));
                       temp.setDob(rs.getString(16));
                       temp.setGender(rs.getString(17));
                       temp.setEthnicAssociation(rs.getString(18));
                       temp.setMartialStatus(rs.getString(19));
                       temp.setCurrentPrimaryHCPId(rs.getString(20));
                       temp.setActive(rs.getInt(21));
                       temp.setComments(rs.getString(22));
                       temp.setSubscriberRelationship(rs.getString(23));
                       temp.setNextOfKin(rs.getString(24));
                       temp.setMiddleInitial(rs.getString(25));
                       temp.setNextOfKinRelationshipToPatient(rs.getString(26));                      
                   }
               }
               catch(Exception e){
                   e.getMessage();
               }
               return temp;
       }
        
           public int insertData(Patient p){
           int ID=0;
           try{
                  Statement stmt=conn.createStatement();
                   String qryInsert = "INSERT INTO patienttable "
                    +"(PtLastName,PtPreviousLastName,PtFirstName,HomeAddress1,HomeAddress2,HomeCity,HomeState/Province/Region,"
                           + "HomeZip,Country, Citizenship,PtHomePhone,EmergencyPhoneNumber,EmailAddress,PtSS#,DOB,"
                           + "Gender,EthnicAssociation,MartialStatus,CurrentPrimaryHCPId,Active,"
                           + "Comments,SubscriberRelationship,NextOfKin,PtMiddleInitial,NextOfKinRelationshipToPatient) "
                    +"VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                   //insert a record into patient table using prepared statement
                   PreparedStatement ps = conn.prepareStatement(qryInsert,Statement.RETURN_GENERATED_KEYS);
                   System.out.println(qryInsert); 
                   ps.setString(1,p.getLastName());
                   ps.setString(2,p.getPrevLastname());
                   ps.setString(3,p.getFirstName());
                   ps.setString(4,p.getHomeAddress1());
                   ps.setString(5,p.getHomeAddress2());
                   ps.setString(6,p.getHomeCity());
                   ps.setString(7,p.getHomeState());
                   ps.setString(8,p.getHomeZip());
                   ps.setString(9,p.getCountry());
                   ps.setString(10,p.getCityzenship());
                   ps.setString(11,p.getHomePhone());
                   ps.setString(12,p.getEmergencyPhone());
                   ps.setString(13,p.getEmail());
                   ps.setString(14,p.getPtss());
                   ps.setString(15,p.getDob());
                   ps.setString(16,p.getGender());
                   ps.setString(17,p.getEthnicAssociation());
                   ps.setString(18,p.getMartialStatus());
                   ps.setString(19,p.getCurrentPrimaryHCPId());
                   ps.setInt(20,p.getActive());
                   ps.setString(21,p.getComments());
                   ps.setString(22,p.getSubscriberRelationship());
                   ps.setString(23,p.getNextOfKin());
                   ps.setString(24,p.getMiddleInitial());
                   ps.setString(25,p.getNextOfKinRelationshipToPatient());
                    System.out.println("Hello"+qryInsert); 
                   int rowCount = ps.executeUpdate();
                   ResultSet rs=ps.getGeneratedKeys();
                   rs.next();
                   ID= rs.getInt(1);
                   System.out.println("Record inserted using prepared statement! ");                   
                   conn.close();    
                   
               }
               catch(Exception e){
                   e.getMessage();
                   System.out.println(e.getMessage());
               }
              return ID;
        }
    
}
