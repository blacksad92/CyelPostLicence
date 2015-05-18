package CyelPostLicence;

/**
 * Holder class for : EtatCandidature
 * 
 * @author OpenORB Compiler
 */
final public class EtatCandidatureHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtatCandidature value
     */
    public CyelPostLicence.EtatCandidature value;

    /**
     * Default constructor
     */
    public EtatCandidatureHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtatCandidatureHolder(CyelPostLicence.EtatCandidature initial)
    {
        value = initial;
    }

    /**
     * Read EtatCandidature from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtatCandidatureHelper.read(istream);
    }

    /**
     * Write EtatCandidature into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtatCandidatureHelper.write(ostream,value);
    }

    /**
     * Return the EtatCandidature TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtatCandidatureHelper.type();
    }

}
