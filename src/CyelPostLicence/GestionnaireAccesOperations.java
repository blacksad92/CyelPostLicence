package CyelPostLicence;

/**
 * Interface definition : GestionnaireAcces
 * 
 * @author OpenORB Compiler
 */
public interface GestionnaireAccesOperations
{
    /**
     * Read accessor for listeGestionnairesVoeux attribute
     * @return the attribute value
     */
    public CyelPostLicence.GestionnaireVoeux[] listeGestionnairesVoeux();

    /**
     * Operation identification
     */
    public CyelPostLicence.Etudiant identification(int INE, CyelPostLicence.Academie academie)
        throws CyelPostLicence.EtudiantInconnu, CyelPostLicence.AcademieIncorrecte;

    /**
     * Operation obtenirGestionnaireVoeux
     */
    public CyelPostLicence.GestionnaireVoeux obtenirGestionnaireVoeux(int numAcademie);

    /**
     * Operation obtenirGestionnaireCandidatures
     */
    public CyelPostLicence.GestionnaireCandidatures obtenirGestionnaireCandidatures(int numUniversite);

    /**
     * Operation identificationUniv
     */
    public CyelPostLicence.GestionnaireVoeux identificationUniv(String login, String password, int numAcademie)
        throws CyelPostLicence.ResponsableInconnu;

    /**
     * Operation inscriptionGestionnaireVoeux
     */
    public void inscriptionGestionnaireVoeux(CyelPostLicence.GestionnaireVoeux gestVoeux);

    /**
     * Operation inscriptionGestionnaireCandidatures
     */
    public void inscriptionGestionnaireCandidatures(CyelPostLicence.GestionnaireCandidatures gestCandidatures);

    /**
     * Operation obtenirEtudiant
     */
    public CyelPostLicence.Etudiant obtenirEtudiant(int INE);

}
