package CyelPostLicence;

/**
 * Holder class for : GestionnaireVoeux
 * 
 * @author OpenORB Compiler
 */
final public class GestionnaireVoeuxHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionnaireVoeux value
     */
    public CyelPostLicence.GestionnaireVoeux value;

    /**
     * Default constructor
     */
    public GestionnaireVoeuxHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionnaireVoeuxHolder(CyelPostLicence.GestionnaireVoeux initial)
    {
        value = initial;
    }

    /**
     * Read GestionnaireVoeux from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionnaireVoeuxHelper.read(istream);
    }

    /**
     * Write GestionnaireVoeux into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionnaireVoeuxHelper.write(ostream,value);
    }

    /**
     * Return the GestionnaireVoeux TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionnaireVoeuxHelper.type();
    }

}
