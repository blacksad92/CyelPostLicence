package CyelPostLicence;

/**
 * Holder class for : GestionnaireReferentiel
 * 
 * @author OpenORB Compiler
 */
final public class GestionnaireReferentielHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionnaireReferentiel value
     */
    public CyelPostLicence.GestionnaireReferentiel value;

    /**
     * Default constructor
     */
    public GestionnaireReferentielHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionnaireReferentielHolder(CyelPostLicence.GestionnaireReferentiel initial)
    {
        value = initial;
    }

    /**
     * Read GestionnaireReferentiel from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionnaireReferentielHelper.read(istream);
    }

    /**
     * Write GestionnaireReferentiel into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionnaireReferentielHelper.write(ostream,value);
    }

    /**
     * Return the GestionnaireReferentiel TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionnaireReferentielHelper.type();
    }

}
