package CyelPostLicence;

/**
 * Holder class for : AcademieIncorrecte
 * 
 * @author OpenORB Compiler
 */
final public class AcademieIncorrecteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AcademieIncorrecte value
     */
    public CyelPostLicence.AcademieIncorrecte value;

    /**
     * Default constructor
     */
    public AcademieIncorrecteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AcademieIncorrecteHolder(CyelPostLicence.AcademieIncorrecte initial)
    {
        value = initial;
    }

    /**
     * Read AcademieIncorrecte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AcademieIncorrecteHelper.read(istream);
    }

    /**
     * Write AcademieIncorrecte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AcademieIncorrecteHelper.write(ostream,value);
    }

    /**
     * Return the AcademieIncorrecte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AcademieIncorrecteHelper.type();
    }

}
