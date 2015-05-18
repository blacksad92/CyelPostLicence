package CyelPostLicence;

/**
 * Exception definition : UniversiteInconnu
 * 
 * @author OpenORB Compiler
 */
public final class UniversiteInconnu extends org.omg.CORBA.UserException
{
    /**
     * Exception member id
     */
    public int id;

    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public UniversiteInconnu()
    {
        super(UniversiteInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param id id exception member
     * @param raison raison exception member
     */
    public UniversiteInconnu(int id, String raison)
    {
        super(UniversiteInconnuHelper.id());
        this.id = id;
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param id id exception member
     * @param raison raison exception member
     */
    public UniversiteInconnu(String orb_reason, int id, String raison)
    {
        super(UniversiteInconnuHelper.id() +" " +  orb_reason);
        this.id = id;
        this.raison = raison;
    }

}
