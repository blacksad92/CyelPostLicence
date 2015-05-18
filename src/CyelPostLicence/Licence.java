package CyelPostLicence;

/**
 * Struct definition : Licence
 * 
 * @author OpenORB Compiler
*/
public final class Licence implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numLicence
     */
    public int numLicence;

    /**
     * Struct member nomLicence
     */
    public String nomLicence;

    /**
     * Default constructor
     */
    public Licence()
    { }

    /**
     * Constructor with fields initialization
     * @param numLicence numLicence struct member
     * @param nomLicence nomLicence struct member
     */
    public Licence(int numLicence, String nomLicence)
    {
        this.numLicence = numLicence;
        this.nomLicence = nomLicence;
    }

}
