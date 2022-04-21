
package project;

public class GeneralMedicalHistory {

    /**
     * @return the generalID
     */
    public int getGeneralID() {
        return generalID;
    }

    /**
     * @param generalID the generalID to set
     */
    public void setGeneralID(int generalID) {
        this.generalID = generalID;
    }

    /**
     * @return the patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * @return the tobacco
     */
    public String getTobacco() {
        return tobacco;
    }

    /**
     * @param tobacco the tobacco to set
     */
    public void setTobacco(String tobacco) {
        this.tobacco = tobacco;
    }

    /**
     * @return the tobaccoQuantity
     */
    public String getTobaccoQuantity() {
        return tobaccoQuantity;
    }

    /**
     * @param tobaccoQuantity the tobaccoQuantity to set
     */
    public void setTobaccoQuantity(String tobaccoQuantity) {
        this.tobaccoQuantity = tobaccoQuantity;
    }

    /**
     * @return the tobaccoDuration
     */
    public String getTobaccoDuration() {
        return tobaccoDuration;
    }

    /**
     * @param tobaccoDuration the tobaccoDuration to set
     */
    public void setTobaccoDuration(String tobaccoDuration) {
        this.tobaccoDuration = tobaccoDuration;
    }

    /**
     * @return the alcohol
     */
    public String getAlcohol() {
        return alcohol;
    }

    /**
     * @param alcohol the alcohol to set
     */
    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    /**
     * @return the alcoholDuration
     */
    public String getAlcoholDuration() {
        return alcoholDuration;
    }

    /**
     * @param alcoholDuration the alcoholDuration to set
     */
    public void setAlcoholDuration(String alcoholDuration) {
        this.alcoholDuration = alcoholDuration;
    }

    /**
     * @return the drug
     */
    public String getDrug() {
        return drug;
    }

    /**
     * @param drug the drug to set
     */
    public void setDrug(String drug) {
        this.drug = drug;
    }

    /**
     * @return the drugType
     */
    public String getDrugType() {
        return drugType;
    }

    /**
     * @param drugType the drugType to set
     */
    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    /**
     * @return the drugDuration
     */
    public String getDrugDuration() {
        return drugDuration;
    }

    /**
     * @param drugDuration the drugDuration to set
     */
    public void setDrugDuration(String drugDuration) {
        this.drugDuration = drugDuration;
    }

    /**
     * @return the bloodType
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * @param bloodType the bloodType to set
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    /**
     * @return the rh
     */
    public String getRh() {
        return rh;
    }

    /**
     * @param rh the rh to set
     */
    public void setRh(String rh) {
        this.rh = rh;
    }

    /**
     * @return the deleted
     */
    public int getDeleted() {
        return deleted;
    }

    /**
     * @param deleted the deleted to set
     */
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    private int generalID;
    private int patientID;
    private String tobacco;
    private String tobaccoQuantity;
    private String tobaccoDuration;
    private String alcohol;
    private String alcoholDuration;
    private String drug;
    private String drugType;
    private String drugDuration;
    private String bloodType;
    private String rh;
    private int deleted;
}
