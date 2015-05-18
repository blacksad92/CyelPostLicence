package CyelPostLicence;

/**
 * Interface definition : GestionnaireReferentiel
 * 
 * @author OpenORB Compiler
 */
public interface GestionnaireReferentielOperations
{
    /**
     * Read accessor for listeAcademies attribute
     * @return the attribute value
     */
    public CyelPostLicence.Academie[] listeAcademies();

    /**
     * Read accessor for listeMasters attribute
     * @return the attribute value
     */
    public CyelPostLicence.Master[] listeMasters();

    /**
     * Read accessor for listeLicences attribute
     * @return the attribute value
     */
    public CyelPostLicence.Licence[] listeLicences();

}
