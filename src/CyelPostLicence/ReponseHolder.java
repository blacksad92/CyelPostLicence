package CyelPostLicence;

/**
 * Holder class for : Reponse
 * 
 * @author OpenORB Compiler
 */
final public class ReponseHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Reponse value
     */
    public CyelPostLicence.Reponse value;

    /**
     * Default constructor
     */
    public ReponseHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ReponseHolder(CyelPostLicence.Reponse initial)
    {
        value = initial;
    }

    /**
     * Read Reponse from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ReponseHelper.read(istream);
    }

    /**
     * Write Reponse into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ReponseHelper.write(ostream,value);
    }

    /**
     * Return the Reponse TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ReponseHelper.type();
    }

}
