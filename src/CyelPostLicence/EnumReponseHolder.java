package CyelPostLicence;

/**
 * Holder class for : EnumReponse
 * 
 * @author OpenORB Compiler
 */
final public class EnumReponseHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EnumReponse value
     */
    public CyelPostLicence.EnumReponse value;

    /**
     * Default constructor
     */
    public EnumReponseHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EnumReponseHolder(CyelPostLicence.EnumReponse initial)
    {
        value = initial;
    }

    /**
     * Read EnumReponse from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EnumReponseHelper.read(istream);
    }

    /**
     * Write EnumReponse into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EnumReponseHelper.write(ostream,value);
    }

    /**
     * Return the EnumReponse TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EnumReponseHelper.type();
    }

}
