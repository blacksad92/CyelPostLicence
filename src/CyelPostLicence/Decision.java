package CyelPostLicence;

/**
 * Struct definition : Decision
 * 
 * @author OpenORB Compiler
*/
public final class Decision implements org.omg.CORBA.portable.IDLEntity
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
     * Struct member decision
     */
    public CyelPostLicence.EnumDecision decision;

    /**
     * Default constructor
     */
    public Decision()
    { }

    /**
     * Constructor with fields initialization
     * @param etudiant etudiant struct member
     * @param numUniversite numUniversite struct member
     * @param numMaster numMaster struct member
     * @param decision decision struct member
     */
    public Decision(CyelPostLicence.Etudiant etudiant, int numUniversite, int numMaster, CyelPostLicence.EnumDecision decision)
    {
        this.etudiant = etudiant;
        this.numUniversite = numUniversite;
        this.numMaster = numMaster;
        this.decision = decision;
    }

}
