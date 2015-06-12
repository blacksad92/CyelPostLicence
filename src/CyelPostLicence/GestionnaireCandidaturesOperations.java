package CyelPostLicence;

/**
 * Interface definition : GestionnaireCandidatures
 * 
 * @author OpenORB Compiler
 */
public interface GestionnaireCandidaturesOperations
{
    /**
     * Read accessor for universite attribute
     * @return the attribute value
     */
    public CyelPostLicence.Universite universite();

    /**
     * Write accessor for universite attribute
     * @param value the attribute value
     */
    public void universite(CyelPostLicence.Universite value);

    /**
     * Read accessor for listeMaster attribute
     * @return the attribute value
     */
    public CyelPostLicence.Master[] listeMaster();

    /**
     * Operation recupererListeNotes
     */
    public CyelPostLicence.Note[] recupererListeNotes(int INE, boolean externe);

    /**
     * Operation RAZPeriode
     */
    public void RAZPeriode();

    /**
     * Operation validerCandidature
     */
    public CyelPostLicence.EtatCandidature validerCandidature(int numMaster, int numLicence);

    /**
     * Operation enregistrerCandidatures
     */
    public void enregistrerCandidatures(CyelPostLicence.Etudiant etudiant, int numMaster);

    /**
     * Operation consulterCandidatures
     */
    public CyelPostLicence.Candidature[] consulterCandidatures(int numMaster, int numUniversite);

    /**
     * Operation enregistrerClassement
     */
    public void enregistrerClassement(int INE, int classement);

}
