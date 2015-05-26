package CyelPostLicence;

/**
 * Interface definition : GestionnaireVoeux
 * 
 * @author OpenORB Compiler
 */
public class GestionnaireVoeuxPOATie extends GestionnaireVoeuxPOA
{

    //
    // Private reference to implementation object
    //
    private GestionnaireVoeuxOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionnaireVoeuxPOATie(GestionnaireVoeuxOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionnaireVoeuxPOATie(GestionnaireVoeuxOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionnaireVoeuxOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionnaireVoeuxOperations delegate_)
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
     * Read accessor for academie attribute
     */
    public CyelPostLicence.Academie academie()
    {
        return _tie.academie();
    }

    /**
     * Write accessor for academie attribute
     */
    public void academie(CyelPostLicence.Academie value)
    {
        _tie.academie(value);
    }

    /**
     * Read accessor for periode attribute
     */
    public int periode()
    {
        return _tie.periode();
    }

    /**
     * Write accessor for periode attribute
     */
    public void periode(int value)
    {
        _tie.periode(value);
    }

    /**
     * Read accessor for listeUniversite attribute
     */
    public CyelPostLicence.Universite[] listeUniversite()
    {
        return _tie.listeUniversite();
    }

    /**
     * Operation consulterAcreditations
     */
    public CyelPostLicence.Universite[] consulterAcreditations(int numMaster, boolean externe)
    {
        return _tie.consulterAcreditations( numMaster,  externe);
    }

    /**
     * Operation enregistrerVoeux
     */
    public void enregistrerVoeux(CyelPostLicence.Etudiant etudiant, CyelPostLicence.Voeu[] listeVoeux)
    {
        _tie.enregistrerVoeux( etudiant,  listeVoeux);
    }

    /**
     * Operation consulterVoeux
     */
    public CyelPostLicence.Voeu[] consulterVoeux(int INE, boolean externe)
    {
        return _tie.consulterVoeux( INE,  externe);
    }

    /**
     * Operation cloturerPeriode
     */
    public void cloturerPeriode()
    {
        _tie.cloturerPeriode();
    }

    /**
     * Operation RAZPeriode
     */
    public void RAZPeriode()
    {
        _tie.RAZPeriode();
    }

    /**
     * Operation recupererListeCandidatures
     */
    public CyelPostLicence.Etudiant[] recupererListeCandidatures(int numMaster, int numUniversite)
    {
        return _tie.recupererListeCandidatures( numMaster,  numUniversite);
    }

    /**
     * Operation enregistrerDecisions
     */
    public void enregistrerDecisions(int numMaster, int numAcademie, CyelPostLicence.Reponse[] listeAccepte, CyelPostLicence.Reponse[] listeAttente, CyelPostLicence.Reponse[] listeRefuse)
    {
        _tie.enregistrerDecisions( numMaster,  numAcademie,  listeAccepte,  listeAttente,  listeRefuse);
    }

}
