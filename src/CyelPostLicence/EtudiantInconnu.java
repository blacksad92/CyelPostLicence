package CyelPostLicence;

/**
 * Exception definition : EtudiantInconnu
 * 
 * @author OpenORB Compiler
 */
public final class EtudiantInconnu extends org.omg.CORBA.UserException
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
    public EtudiantInconnu()
    {
        super(EtudiantInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param id id exception member
     * @param raison raison exception member
     */
    public EtudiantInconnu(int id, String raison)
    {
        super(EtudiantInconnuHelper.id());
        this.id = id;
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param id id exception member
     * @param raison raison exception member
     */
    public EtudiantInconnu(String orb_reason, int id, String raison)
    {
        super(EtudiantInconnuHelper.id() +" " +  orb_reason);
        this.id = id;
        this.raison = raison;
    }

}
