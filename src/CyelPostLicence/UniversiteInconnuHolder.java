package CyelPostLicence;

/**
 * Holder class for : UniversiteInconnu
 * 
 * @author OpenORB Compiler
 */
final public class UniversiteInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal UniversiteInconnu value
     */
    public CyelPostLicence.UniversiteInconnu value;

    /**
     * Default constructor
     */
    public UniversiteInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public UniversiteInconnuHolder(CyelPostLicence.UniversiteInconnu initial)
    {
        value = initial;
    }

    /**
     * Read UniversiteInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = UniversiteInconnuHelper.read(istream);
    }

    /**
     * Write UniversiteInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        UniversiteInconnuHelper.write(ostream,value);
    }

    /**
     * Return the UniversiteInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return UniversiteInconnuHelper.type();
    }

}
