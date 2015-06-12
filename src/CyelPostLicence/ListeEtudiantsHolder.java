package CyelPostLicence;

/**
 * Holder class for : ListeEtudiants
 * 
 * @author OpenORB Compiler
 */
final public class ListeEtudiantsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeEtudiants value
     */
    public CyelPostLicence.Etudiant[] value;

    /**
     * Default constructor
     */
    public ListeEtudiantsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeEtudiantsHolder(CyelPostLicence.Etudiant[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeEtudiants from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeEtudiantsHelper.read(istream);
    }

    /**
     * Write ListeEtudiants into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeEtudiantsHelper.write(ostream,value);
    }

    /**
     * Return the ListeEtudiants TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeEtudiantsHelper.type();
    }

}
