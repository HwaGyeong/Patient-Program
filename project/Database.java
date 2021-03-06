
package project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Database {
    String dbURL="jdbc:mysql://localhost:3306/its340?autoReconnect=true";
       Connection conn=DBUtils.ConnectToMySQLDB(dbURL,"root","password");
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
       
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
                       temp.setDob(dateFormat.format(rs.getDate(16)));
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
        
           public int insertPatient(Patient p){
           int ID=0;
           try{
                  Statement stmt=conn.createStatement();
                   String qryInsert = "INSERT INTO patienttable "
                    +"(PtLastName,PtPreviousLastName,PtFirstName,HomeAddress1,HomeAddress2,HomeCity,HomeState,"
                           + "HomeZip,Country, Citizenship,PtHomePhone,EmergencyPhoneNumber,EmailAddress,PtSSN,DOB,"
                           + "Gender,EthnicAssociation,MaritalStatus,CurrentPrimaryHCPId,Active,"
                           + "Comments,SubscriberRelationship,NextOfKin,PtMiddleInitial,NextOfKinRelationshipToPatient) "
                    +"VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                   //insert a record into patient table using prepared statement
                   PreparedStatement ps = conn.prepareStatement(qryInsert,Statement.RETURN_GENERATED_KEYS);
                   
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
                   ps.setDate(15, new Date(dateFormat.parse(p.getDob()).getTime()));
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
                   int rowCount = ps.executeUpdate();
                   ResultSet rs=ps.getGeneratedKeys();
                   rs.next();
                   ID= rs.getInt(1);
                   System.out.println("Record inserted using prepared statement! ");                   
                      
                   
               }
               catch(Exception e){
                   e.getMessage();
                   System.out.println(e.getMessage());
               }
              return ID;
        }
           
          public void deletePatient(String patientID){
          Patient temp = new Patient();
          String qry="DELETE FROM patienttable WHERE PatientID= ";
               try{      
                   Statement stmt=conn.createStatement();
                   stmt.executeUpdate(qry+ patientID);
               }
               catch(Exception e){
                   e.getMessage();
               }               
       }
          
          public int updatePatient(Patient p){
           try{
                  Statement stmt=conn.createStatement();
                   String qryInsert = "UPDATE patienttable set "
                    +"PtLastName=?,PtPreviousLastName=?, PtFirstName=?,HomeAddress1=?,HomeAddress2=?,HomeCity=?,HomeState=?,"
                           + "HomeZip=?,Country=?, Citizenship=?,PtHomePhone=?,EmergencyPhoneNumber=?,EmailAddress=?,PtSSN=?,DOB=?,"
                           + "Gender=?,EthnicAssociation=?,MaritalStatus=?,CurrentPrimaryHCPId=?,Active=?,"
                           + "Comments=?,SubscriberRelationship=?,NextOfKin=?,PtMiddleInitial=?,NextOfKinRelationshipToPatient=? WHERE PatientID=? ";
                   //insert a record into patient table using prepared statement
                   PreparedStatement ps = conn.prepareStatement(qryInsert);
                   System.out.println(p.getPatientID()); 
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
                   ps.setDate(15, new Date(dateFormat.parse(p.getDob()).getTime()));
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
                   ps.setInt(26,p.getPatientID());
                   int rowCount = ps.executeUpdate();

                   System.out.println("Record updated using prepared statement! ");                   
                                       
               }
               catch(Exception e){
                   e.getMessage();
                   System.out.println(e.getMessage());
               }
              return p.getPatientID();
        }
          
        //for GeneralMediclaHistory Table
          
        public int insertMedicalHistory(GeneralMedicalHistory g){
           int ID=0;
           try{
                  Statement stmt=conn.createStatement();
                   String qryInsert = "INSERT INTO generalmedicalhistorytable"
                    +"(PatientID, Tobacco, TobaccoQuantity,Tobaccoduraton,"
                           + "Alcohol,AlcoholQuantity,Alcoholduration,"
                           +"Drug,DrugType,Drugduration,BloodType,Rh,deleted)"
                    +"VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                   //insert a record into patient table using prepared statement
                   PreparedStatement ps = conn.prepareStatement(qryInsert,Statement.RETURN_GENERATED_KEYS);
                   
                   ps.setInt(1,Integer.valueOf(g.getPatientID()));
                   ps.setString(2,g.getTobacco());
                   ps.setString(3,g.getTobaccoQuantity());
                   ps.setString(4,g.getTobaccoDuration());
                   ps.setString(5,g.getAlcohol());
                   ps.setString(6,g.getAlcoholQuantity());
                   ps.setString(7,g.getAlcoholDuration());
                   ps.setString(8,g.getDrug());
                   ps.setString(9,g.getDrugType());
                   ps.setString(10,g.getDrugDuration());
                   ps.setString(11,g.getBloodType());
                   ps.setString(12,g.getRh());
                   ps.setInt(13,g.getDeleted());

                   int rowCount = ps.executeUpdate();
                   ResultSet rs=ps.getGeneratedKeys();
                   rs.next();
                   ID= rs.getInt(1);
                   System.out.println("Record inserted using prepared statement! ");                   
                   
                   
               }
               catch(Exception e){
                   e.getMessage();
                   System.out.println(e.getMessage());
               }
              return ID;
        }
        public GeneralMedicalHistory findGeneralMediclaHistory (String patientID){
          GeneralMedicalHistory temp = new GeneralMedicalHistory();
          String qry="SELECT * FROM generalmedicalhistorytable WHERE PatientID= ";
               try{      
                   Statement stmt=conn.createStatement();
                   ResultSet rs= stmt.executeQuery(qry+ patientID);
                   
                   while(rs.next()){
                       temp.setGeneralID(rs.getInt(1));
                       temp.setPatientID(rs.getInt(2));
                       temp.setTobacco(rs.getString(3));
                       temp.setTobaccoQuantity(rs.getString(4));
                       temp.setTobaccoDuration(rs.getString(5));
                       temp.setAlcohol(rs.getString(6));
                       temp.setAlcoholQuantity(rs.getString(7));
                       temp.setAlcoholDuration(rs.getString(8));
                       temp.setDrug(rs.getString(9));
                       temp.setDrugType(rs.getString(10));
                       temp.setDrugDuration(rs.getString(11));
                       temp.setBloodType(rs.getString(12));
                       temp.setRh(rs.getString(13));
                       temp.setDeleted(Integer.valueOf(rs.getString(14)));                      
                   }
               }
               catch(Exception e){
                   e.getMessage();
               }
               System.out.println("Selection complete "+"and selection"+ patientID+"," +temp.getPatientID()+"and "+temp.getGeneralID());
               return temp;
       }
        
        public void deleteGeneralHistory(String patientID){
          GeneralMedicalHistory temp = new GeneralMedicalHistory();
          String qry="DELETE FROM generalmedicalhistorytable WHERE PatientID= ";
               try{      
                   Statement stmt=conn.createStatement();
                   stmt.executeUpdate(qry+ patientID);
               }
               catch(Exception e){
                   e.getMessage();
               }               
       }
      public int updateGeneralHistory(GeneralMedicalHistory g){
           try{
                  Statement stmt=conn.createStatement();
                   String qryInsert = "UPDATE generalmedicalhistorytable set "
                         +"Tobacco=?, TobaccoQuantity=?,Tobaccoduraton=?,"
                           + "Alcohol=?,AlcoholQuantity=?,Alcoholduration=?,"
                           +"Drug=?,DrugType=?,Drugduration=?,BloodType=?,Rh=?,deleted=?"
                    +" WHERE PatientID=?";
                   //insert a record into patient table using prepared statement
                   PreparedStatement ps = conn.prepareStatement(qryInsert);
                   
                   ps.setString(1,g.getTobacco());
                   ps.setString(2,g.getTobaccoQuantity());
                   ps.setString(3,g.getTobaccoDuration());
                   ps.setString(4,g.getAlcohol());
                   ps.setString(5,g.getAlcoholQuantity());
                   ps.setString(6,g.getAlcoholDuration());
                   ps.setString(7,g.getDrug());
                   ps.setString(8,g.getDrugType());
                   ps.setString(9,g.getDrugDuration());
                   ps.setString(10,g.getBloodType());
                   ps.setString(11,g.getRh());
                   ps.setInt(12,g.getDeleted());
                   ps.setInt(13,Integer.valueOf(g.getPatientID()));
                   int rowCount = ps.executeUpdate();

                   System.out.println("Record updated using prepared statement! ");                   
                   conn.close();                      
               }
               catch(Exception e){
                   e.getMessage();
                   System.out.println(e.getMessage());
               }
              return g.getPatientID();
        }
          
}
