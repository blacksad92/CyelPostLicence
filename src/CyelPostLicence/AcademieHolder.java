package CyelPostLicence;

/**
 * Holder class for : Academie
 * 
 * @author OpenORB Compiler
 */
final public class AcademieHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Academie value
     */
    public CyelPostLicence.Academie value;

    /**
     * Default constructor
     */
    public AcademieHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AcademieHolder(CyelPostLicence.Academie initial)
    {
        value = initial;
    }

    /**
     * Read Academie from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AcademieHelper.read(istream);
    }

    /**
     * Write Academie into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AcademieHelper.write(ostream,value);
    }

    /**
     * Return the Academie TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AcademieHelper.type();
    }

}
