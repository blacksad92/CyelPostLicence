package CyelPostLicence;

/**
 * Struct definition : Etudiant
 * 
 * @author OpenORB Compiler
*/
public final class Etudiant implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member INE
     */
    public int INE;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member prenom
     */
    public String prenom;

    /**
     * Struct member licence
     */
    public CyelPostLicence.Licence licence;

    /**
     * Struct member universite
     */
    public CyelPostLicence.Universite universite;

    /**
     * Default constructor
     */
    public Etudiant()
    { }

    /**
     * Constructor with fields initialization
     * @param INE INE struct member
     * @param nom nom struct member
     * @param prenom prenom struct member
     * @param licence licence struct member
     * @param universite universite struct member
     */
    public Etudiant(int INE, String nom, String prenom, CyelPostLicence.Licence licence, CyelPostLicence.Universite universite)
    {
        this.INE = INE;
        this.nom = nom;
        this.prenom = prenom;
        this.licence = licence;
        this.universite = universite;
    }

}
