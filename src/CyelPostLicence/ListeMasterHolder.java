package CyelPostLicence;

/**
 * Holder class for : ListeMaster
 * 
 * @author OpenORB Compiler
 */
final public class ListeMasterHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeMaster value
     */
    public CyelPostLicence.Master[] value;

    /**
     * Default constructor
     */
    public ListeMasterHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeMasterHolder(CyelPostLicence.Master[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeMaster from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeMasterHelper.read(istream);
    }

    /**
     * Write ListeMaster into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeMasterHelper.write(ostream,value);
    }

    /**
     * Return the ListeMaster TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeMasterHelper.type();
    }

}
