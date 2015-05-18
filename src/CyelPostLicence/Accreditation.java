package CyelPostLicence;

/**
 * Struct definition : Accreditation
 * 
 * @author OpenORB Compiler
*/
public final class Accreditation implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member universite
     */
    public CyelPostLicence.Universite universite;

    /**
     * Struct member master
     */
    public CyelPostLicence.Master master;

    /**
     * Default constructor
     */
    public Accreditation()
    { }

    /**
     * Constructor with fields initialization
     * @param universite universite struct member
     * @param master master struct member
     */
    public Accreditation(CyelPostLicence.Universite universite, CyelPostLicence.Master master)
    {
        this.universite = universite;
        this.master = master;
    }

}
