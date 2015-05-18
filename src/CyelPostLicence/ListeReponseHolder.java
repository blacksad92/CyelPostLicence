package CyelPostLicence;

/**
 * Holder class for : ListeReponse
 * 
 * @author OpenORB Compiler
 */
final public class ListeReponseHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeReponse value
     */
    public CyelPostLicence.Reponse[] value;

    /**
     * Default constructor
     */
    public ListeReponseHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeReponseHolder(CyelPostLicence.Reponse[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeReponse from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeReponseHelper.read(istream);
    }

    /**
     * Write ListeReponse into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeReponseHelper.write(ostream,value);
    }

    /**
     * Return the ListeReponse TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeReponseHelper.type();
    }

}
