package CyelPostLicence;

/**
 * Holder class for : ListeDiplomes
 * 
 * @author OpenORB Compiler
 */
final public class ListeDiplomesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeDiplomes value
     */
    public CyelPostLicence.Diplome[] value;

    /**
     * Default constructor
     */
    public ListeDiplomesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeDiplomesHolder(CyelPostLicence.Diplome[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeDiplomes from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeDiplomesHelper.read(istream);
    }

    /**
     * Write ListeDiplomes into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeDiplomesHelper.write(ostream,value);
    }

    /**
     * Return the ListeDiplomes TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeDiplomesHelper.type();
    }

}
