package CyelPostLicence;

/**
 * Interface definition : GestionnaireCandidatures
 * 
 * @author OpenORB Compiler
 */
public class GestionnaireCandidaturesPOATie extends GestionnaireCandidaturesPOA
{

    //
    // Private reference to implementation object
    //
    private GestionnaireCandidaturesOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionnaireCandidaturesPOATie(GestionnaireCandidaturesOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionnaireCandidaturesPOATie(GestionnaireCandidaturesOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionnaireCandidaturesOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionnaireCandidaturesOperations delegate_)
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
     * Read accessor for universite attribute
     */
    public CyelPostLicence.Universite universite()
    {
        return _tie.universite();
    }

    /**
     * Write accessor for universite attribute
     */
    public void universite(CyelPostLicence.Universite value)
    {
        _tie.universite(value);
    }

    /**
     * Read accessor for listeMaster attribute
     */
    public CyelPostLicence.Master[] listeMaster()
    {
        return _tie.listeMaster();
    }

    /**
     * Operation recupererListeNotes
     */
    public CyelPostLicence.Note[] recupererListeNotes(int INE, boolean externe)
    {
        return _tie.recupererListeNotes( INE,  externe);
    }

    /**
     * Operation validerCandidature
     */
    public CyelPostLicence.EtatCandidature validerCandidature(int numMaster, int numLicence)
    {
        return _tie.validerCandidature( numMaster,  numLicence);
    }

    /**
     * Operation enregistrerCandidatures
     */
    public void enregistrerCandidatures(CyelPostLicence.Etudiant[] listeCandidatures, int numMaster)
    {
        _tie.enregistrerCandidatures( listeCandidatures,  numMaster);
    }

    /**
     * Operation consulterCandidatures
     */
    public CyelPostLicence.Etudiant[] consulterCandidatures(int numMaster, int numUniversite)
    {
        return _tie.consulterCandidatures( numMaster,  numUniversite);
    }

}
