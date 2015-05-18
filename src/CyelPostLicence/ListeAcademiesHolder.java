package CyelPostLicence;

/**
 * Holder class for : ListeAcademies
 * 
 * @author OpenORB Compiler
 */
final public class ListeAcademiesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeAcademies value
     */
    public CyelPostLicence.Academie[] value;

    /**
     * Default constructor
     */
    public ListeAcademiesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeAcademiesHolder(CyelPostLicence.Academie[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeAcademies from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeAcademiesHelper.read(istream);
    }

    /**
     * Write ListeAcademies into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeAcademiesHelper.write(ostream,value);
    }

    /**
     * Return the ListeAcademies TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeAcademiesHelper.type();
    }

}
