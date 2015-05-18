package CyelPostLicence;

/**
 * Holder class for : GestionnaireCandidatures
 * 
 * @author OpenORB Compiler
 */
final public class GestionnaireCandidaturesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionnaireCandidatures value
     */
    public CyelPostLicence.GestionnaireCandidatures value;

    /**
     * Default constructor
     */
    public GestionnaireCandidaturesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionnaireCandidaturesHolder(CyelPostLicence.GestionnaireCandidatures initial)
    {
        value = initial;
    }

    /**
     * Read GestionnaireCandidatures from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionnaireCandidaturesHelper.read(istream);
    }

    /**
     * Write GestionnaireCandidatures into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionnaireCandidaturesHelper.write(ostream,value);
    }

    /**
     * Return the GestionnaireCandidatures TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionnaireCandidaturesHelper.type();
    }

}
