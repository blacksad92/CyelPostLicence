package CyelPostLicence;

/**
 * Holder class for : ListeCandidatures
 * 
 * @author OpenORB Compiler
 */
final public class ListeCandidaturesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeCandidatures value
     */
    public CyelPostLicence.Etudiant[] value;

    /**
     * Default constructor
     */
    public ListeCandidaturesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeCandidaturesHolder(CyelPostLicence.Etudiant[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeCandidatures from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeCandidaturesHelper.read(istream);
    }

    /**
     * Write ListeCandidatures into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeCandidaturesHelper.write(ostream,value);
    }

    /**
     * Return the ListeCandidatures TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeCandidaturesHelper.type();
    }

}
