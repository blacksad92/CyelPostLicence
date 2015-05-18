package CyelPostLicence;

/**
 * Holder class for : ListeDecisions
 * 
 * @author OpenORB Compiler
 */
final public class ListeDecisionsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeDecisions value
     */
    public CyelPostLicence.Decision[] value;

    /**
     * Default constructor
     */
    public ListeDecisionsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeDecisionsHolder(CyelPostLicence.Decision[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeDecisions from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeDecisionsHelper.read(istream);
    }

    /**
     * Write ListeDecisions into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeDecisionsHelper.write(ostream,value);
    }

    /**
     * Return the ListeDecisions TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeDecisionsHelper.type();
    }

}
