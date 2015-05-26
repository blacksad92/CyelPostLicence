package CyelPostLicence;

/**
 * Holder class for : ListeGestionnairesCandidatures
 * 
 * @author OpenORB Compiler
 */
final public class ListeGestionnairesCandidaturesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeGestionnairesCandidatures value
     */
    public CyelPostLicence.GestionnaireCandidatures[] value;

    /**
     * Default constructor
     */
    public ListeGestionnairesCandidaturesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeGestionnairesCandidaturesHolder(CyelPostLicence.GestionnaireCandidatures[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeGestionnairesCandidatures from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeGestionnairesCandidaturesHelper.read(istream);
    }

    /**
     * Write ListeGestionnairesCandidatures into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeGestionnairesCandidaturesHelper.write(ostream,value);
    }

    /**
     * Return the ListeGestionnairesCandidatures TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeGestionnairesCandidaturesHelper.type();
    }

}
