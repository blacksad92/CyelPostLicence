package CyelPostLicence;

/**
 * Holder class for : EnumOrdre
 * 
 * @author OpenORB Compiler
 */
final public class EnumOrdreHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EnumOrdre value
     */
    public CyelPostLicence.EnumOrdre value;

    /**
     * Default constructor
     */
    public EnumOrdreHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EnumOrdreHolder(CyelPostLicence.EnumOrdre initial)
    {
        value = initial;
    }

    /**
     * Read EnumOrdre from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EnumOrdreHelper.read(istream);
    }

    /**
     * Write EnumOrdre into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EnumOrdreHelper.write(ostream,value);
    }

    /**
     * Return the EnumOrdre TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EnumOrdreHelper.type();
    }

}
