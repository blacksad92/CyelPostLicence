package CyelPostLicence;

/**
 * Holder class for : ListeGestionnairesVoeux
 * 
 * @author OpenORB Compiler
 */
final public class ListeGestionnairesVoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeGestionnairesVoeux value
     */
    public CyelPostLicence.GestionnaireVoeux[] value;

    /**
     * Default constructor
     */
    public ListeGestionnairesVoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeGestionnairesVoeuxHolder(CyelPostLicence.GestionnaireVoeux[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeGestionnairesVoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeGestionnairesVoeuxHelper.read(istream);
    }

    /**
     * Write ListeGestionnairesVoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeGestionnairesVoeuxHelper.write(ostream,value);
    }

    /**
     * Return the ListeGestionnairesVoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeGestionnairesVoeuxHelper.type();
    }

}
