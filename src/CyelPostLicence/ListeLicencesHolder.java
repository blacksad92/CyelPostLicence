package CyelPostLicence;

/**
 * Holder class for : ListeLicences
 * 
 * @author OpenORB Compiler
 */
final public class ListeLicencesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeLicences value
     */
    public CyelPostLicence.Licence[] value;

    /**
     * Default constructor
     */
    public ListeLicencesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeLicencesHolder(CyelPostLicence.Licence[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeLicences from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeLicencesHelper.read(istream);
    }

    /**
     * Write ListeLicences into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeLicencesHelper.write(ostream,value);
    }

    /**
     * Return the ListeLicences TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeLicencesHelper.type();
    }

}
