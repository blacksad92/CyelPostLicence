package CyelPostLicence;

/**
 * Holder class for : ResponsableInconnu
 * 
 * @author OpenORB Compiler
 */
final public class ResponsableInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ResponsableInconnu value
     */
    public CyelPostLicence.ResponsableInconnu value;

    /**
     * Default constructor
     */
    public ResponsableInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ResponsableInconnuHolder(CyelPostLicence.ResponsableInconnu initial)
    {
        value = initial;
    }

    /**
     * Read ResponsableInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ResponsableInconnuHelper.read(istream);
    }

    /**
     * Write ResponsableInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ResponsableInconnuHelper.write(ostream,value);
    }

    /**
     * Return the ResponsableInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ResponsableInconnuHelper.type();
    }

}
