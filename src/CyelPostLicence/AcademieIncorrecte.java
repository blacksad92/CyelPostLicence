package CyelPostLicence;

/**
 * Exception definition : AcademieIncorrecte
 * 
 * @author OpenORB Compiler
 */
public final class AcademieIncorrecte extends org.omg.CORBA.UserException
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
    public AcademieIncorrecte()
    {
        super(AcademieIncorrecteHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param id id exception member
     * @param raison raison exception member
     */
    public AcademieIncorrecte(int id, String raison)
    {
        super(AcademieIncorrecteHelper.id());
        this.id = id;
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param id id exception member
     * @param raison raison exception member
     */
    public AcademieIncorrecte(String orb_reason, int id, String raison)
    {
        super(AcademieIncorrecteHelper.id() +" " +  orb_reason);
        this.id = id;
        this.raison = raison;
    }

}
