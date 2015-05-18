package CyelPostLicence;

/**
 * Interface definition : GestionnaireAcces
 * 
 * @author OpenORB Compiler
 */
public class GestionnaireAccesPOATie extends GestionnaireAccesPOA
{

    //
    // Private reference to implementation object
    //
    private GestionnaireAccesOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionnaireAccesPOATie(GestionnaireAccesOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionnaireAccesPOATie(GestionnaireAccesOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionnaireAccesOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionnaireAccesOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Read accessor for listeGestionnairesVoeux attribute
     */
    public CyelPostLicence.GestionnaireVoeux[] listeGestionnairesVoeux()
    {
        return _tie.listeGestionnairesVoeux();
    }

    /**
     * Operation identification
     */
    public CyelPostLicence.Etudiant identification(int INE, CyelPostLicence.Academie academie)
        throws CyelPostLicence.EtudiantInconnu, CyelPostLicence.AcademieIncorrecte
    {
        return _tie.identification( INE,  academie);
    }

    /**
     * Operation obtenirGestionnaireVoeux
     */
    public CyelPostLicence.GestionnaireVoeux obtenirGestionnaireVoeux(int numAcademie)
    {
        return _tie.obtenirGestionnaireVoeux( numAcademie);
    }

    /**
     * Operation obtenirGestionnaireCandidatures
     */
    public CyelPostLicence.GestionnaireCandidatures obtenirGestionnaireCandidatures(int numUniversite)
    {
        return _tie.obtenirGestionnaireCandidatures( numUniversite);
    }

    /**
     * Operation identificationUniv
     */
    public CyelPostLicence.GestionnaireVoeux identificationUniv(String login, String password, int numAcademie)
        throws CyelPostLicence.ResponsableInconnu
    {
        return _tie.identificationUniv( login,  password,  numAcademie);
    }

    /**
     * Operation inscriptionGestionnaireVoeux
     */
    public void inscriptionGestionnaireVoeux(CyelPostLicence.GestionnaireVoeux gestVoeux)
    {
        _tie.inscriptionGestionnaireVoeux( gestVoeux);
    }

    /**
     * Operation inscriptionGestionnaireCandidatures
     */
    public void inscriptionGestionnaireCandidatures(CyelPostLicence.GestionnaireCandidatures gestCandidatures)
    {
        _tie.inscriptionGestionnaireCandidatures( gestCandidatures);
    }

    /**
     * Operation obtenirEtudiant
     */
    public CyelPostLicence.Etudiant obtenirEtudiant(int INE)
    {
        return _tie.obtenirEtudiant( INE);
    }

}
