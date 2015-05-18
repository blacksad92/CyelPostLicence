package CyelPostLicence;

/**
 * Struct definition : Master
 * 
 * @author OpenORB Compiler
*/
public final class Master implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numMaster
     */
    public int numMaster;

    /**
     * Struct member nomMaster
     */
    public String nomMaster;

    /**
     * Default constructor
     */
    public Master()
    { }

    /**
     * Constructor with fields initialization
     * @param numMaster numMaster struct member
     * @param nomMaster nomMaster struct member
     */
    public Master(int numMaster, String nomMaster)
    {
        this.numMaster = numMaster;
        this.nomMaster = nomMaster;
    }

}
