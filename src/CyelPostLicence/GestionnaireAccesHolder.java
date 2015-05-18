package CyelPostLicence;

/**
 * Holder class for : GestionnaireAcces
 * 
 * @author OpenORB Compiler
 */
final public class GestionnaireAccesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionnaireAcces value
     */
    public CyelPostLicence.GestionnaireAcces value;

    /**
     * Default constructor
     */
    public GestionnaireAccesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionnaireAccesHolder(CyelPostLicence.GestionnaireAcces initial)
    {
        value = initial;
    }

    /**
     * Read GestionnaireAcces from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionnaireAccesHelper.read(istream);
    }

    /**
     * Write GestionnaireAcces into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionnaireAccesHelper.write(ostream,value);
    }

    /**
     * Return the GestionnaireAcces TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionnaireAccesHelper.type();
    }

}
