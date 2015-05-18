package CyelPostLicence;

/**
 * Exception definition : ResponsableInconnu
 * 
 * @author OpenORB Compiler
 */
public final class ResponsableInconnu extends org.omg.CORBA.UserException
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
    public ResponsableInconnu()
    {
        super(ResponsableInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param id id exception member
     * @param raison raison exception member
     */
    public ResponsableInconnu(int id, String raison)
    {
        super(ResponsableInconnuHelper.id());
        this.id = id;
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param id id exception member
     * @param raison raison exception member
     */
    public ResponsableInconnu(String orb_reason, int id, String raison)
    {
        super(ResponsableInconnuHelper.id() +" " +  orb_reason);
        this.id = id;
        this.raison = raison;
    }

}
