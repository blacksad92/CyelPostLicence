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
     * Struct member master
     */
    public CyelPostLicence.Master master;

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
     * @param master master struct member
     * @param decision decision struct member
     */
    public Decision(CyelPostLicence.Etudiant etudiant, CyelPostLicence.Master master, CyelPostLicence.EnumDecision decision)
    {
        this.etudiant = etudiant;
        this.master = master;
        this.decision = decision;
    }

}
