package CyelPostLicence;

/**
 * Interface definition : GestionnaireVoeux
 * 
 * @author OpenORB Compiler
 */
public interface GestionnaireVoeuxOperations
{
    /**
     * Read accessor for academie attribute
     * @return the attribute value
     */
    public CyelPostLicence.Academie academie();

    /**
     * Write accessor for academie attribute
     * @param value the attribute value
     */
    public void academie(CyelPostLicence.Academie value);

    /**
     * Read accessor for periode attribute
     * @return the attribute value
     */
    public int periode();

    /**
     * Write accessor for periode attribute
     * @param value the attribute value
     */
    public void periode(int value);

    /**
     * Read accessor for listeUniversite attribute
     * @return the attribute value
     */
    public CyelPostLicence.Universite[] listeUniversite();

    /**
     * Operation consulterAcreditations
     */
    public CyelPostLicence.Universite[] consulterAcreditations(int numMaster, boolean externe);

    /**
     * Operation enregistrerVoeux
     */
    public void enregistrerVoeux(CyelPostLicence.Etudiant etudiant, CyelPostLicence.Voeu[] listeVoeux);

    /**
     * Operation repondreVoeu
     */
    public void repondreVoeu(int INE, CyelPostLicence.Voeu voeu);

    /**
     * Operation consulterVoeux
     */
    public CyelPostLicence.Voeu[] consulterVoeux(int INE, boolean externe);

    /**
     * Operation cloturerPeriode
     */
    public void cloturerPeriode();

    /**
     * Operation RAZPeriode
     */
    public void RAZPeriode();

    /**
     * Operation recupererListeCandidatures
     */
    public CyelPostLicence.Etudiant[] recupererListeCandidatures(int numMaster, int numUniversite);

    /**
     * Operation enregistrerDecision
     */
    public void enregistrerDecision(CyelPostLicence.Decision decision);

}
