package CyelPostLicence;

/**
 * Holder class for : ListeUniversites
 * 
 * @author OpenORB Compiler
 */
final public class ListeUniversitesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeUniversites value
     */
    public CyelPostLicence.Universite[] value;

    /**
     * Default constructor
     */
    public ListeUniversitesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeUniversitesHolder(CyelPostLicence.Universite[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeUniversites from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeUniversitesHelper.read(istream);
    }

    /**
     * Write ListeUniversites into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeUniversitesHelper.write(ostream,value);
    }

    /**
     * Return the ListeUniversites TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeUniversitesHelper.type();
    }

}
