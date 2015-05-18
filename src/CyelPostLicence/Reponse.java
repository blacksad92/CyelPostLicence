package CyelPostLicence;

/**
 * Struct definition : Reponse
 * 
 * @author OpenORB Compiler
*/
public final class Reponse implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member etudiant
     */
    public CyelPostLicence.Etudiant etudiant;

    /**
     * Struct member ordre
     */
    public short ordre;

    /**
     * Default constructor
     */
    public Reponse()
    { }

    /**
     * Constructor with fields initialization
     * @param etudiant etudiant struct member
     * @param ordre ordre struct member
     */
    public Reponse(CyelPostLicence.Etudiant etudiant, short ordre)
    {
        this.etudiant = etudiant;
        this.ordre = ordre;
    }

}
