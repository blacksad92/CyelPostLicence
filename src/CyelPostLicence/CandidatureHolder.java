package CyelPostLicence;

/**
 * Holder class for : Candidature
 * 
 * @author OpenORB Compiler
 */
final public class CandidatureHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Candidature value
     */
    public CyelPostLicence.Candidature value;

    /**
     * Default constructor
     */
    public CandidatureHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CandidatureHolder(CyelPostLicence.Candidature initial)
    {
        value = initial;
    }

    /**
     * Read Candidature from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CandidatureHelper.read(istream);
    }

    /**
     * Write Candidature into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CandidatureHelper.write(ostream,value);
    }

    /**
     * Return the Candidature TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CandidatureHelper.type();
    }

}
