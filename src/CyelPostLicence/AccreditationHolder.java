package CyelPostLicence;

/**
 * Holder class for : Accreditation
 * 
 * @author OpenORB Compiler
 */
final public class AccreditationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Accreditation value
     */
    public CyelPostLicence.Accreditation value;

    /**
     * Default constructor
     */
    public AccreditationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AccreditationHolder(CyelPostLicence.Accreditation initial)
    {
        value = initial;
    }

    /**
     * Read Accreditation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AccreditationHelper.read(istream);
    }

    /**
     * Write Accreditation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AccreditationHelper.write(ostream,value);
    }

    /**
     * Return the Accreditation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AccreditationHelper.type();
    }

}
