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
     * Struct member numUniversite
     */
    public int numUniversite;

    /**
     * Struct member numMaster
     */
    public int numMaster;

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
     * @param numUniversite numUniversite struct member
     * @param numMaster numMaster struct member
     * @param classement classement struct member
     */
    public Candidature(CyelPostLicence.Etudiant etudiant, int numUniversite, int numMaster, int classement)
    {
        this.etudiant = etudiant;
        this.numUniversite = numUniversite;
        this.numMaster = numMaster;
        this.classement = classement;
    }

}
