package CyelPostLicence;

/**
 * Holder class for : ListeVoeux
 * 
 * @author OpenORB Compiler
 */
final public class ListeVoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeVoeux value
     */
    public CyelPostLicence.Voeu[] value;

    /**
     * Default constructor
     */
    public ListeVoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeVoeuxHolder(CyelPostLicence.Voeu[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeVoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeVoeuxHelper.read(istream);
    }

    /**
     * Write ListeVoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeVoeuxHelper.write(ostream,value);
    }

    /**
     * Return the ListeVoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeVoeuxHelper.type();
    }

}
