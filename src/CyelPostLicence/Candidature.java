package CyelPostLicence;

/**
 * Struct definition : Candidature
 * 
 * @author OpenORB Compiler
*/
public final class Candidature implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member etudiant
     */
    public CyelPostLicence.Etudiant etudiant;

    /**
     * Struct member classement
     */
    public int classement;

    /**
     * Default constructor
     */
    public Candidature()
    { }

    /**
     * Constructor with fields initialization
     * @param etudiant etudiant struct member
     * @param classement classement struct member
     */
    public Candidature(CyelPostLicence.Etudiant etudiant, int classement)
    {
        this.etudiant = etudiant;
        this.classement = classement;
    }

}
