package CyelPostLicence;

/**
 * Interface definition : GestionnaireReferentiel
 * 
 * @author OpenORB Compiler
 */
public class GestionnaireReferentielPOATie extends GestionnaireReferentielPOA
{

    //
    // Private reference to implementation object
    //
    private GestionnaireReferentielOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionnaireReferentielPOATie(GestionnaireReferentielOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionnaireReferentielPOATie(GestionnaireReferentielOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionnaireReferentielOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionnaireReferentielOperations delegate_)
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
     * Read accessor for listeAcademies attribute
     */
    public CyelPostLicence.Academie[] listeAcademies()
    {
        return _tie.listeAcademies();
    }

    /**
     * Read accessor for listeMasters attribute
     */
    public CyelPostLicence.Master[] listeMasters()
    {
        return _tie.listeMasters();
    }

    /**
     * Read accessor for listeLicences attribute
     */
    public CyelPostLicence.Licence[] listeLicences()
    {
        return _tie.listeLicences();
    }

}
