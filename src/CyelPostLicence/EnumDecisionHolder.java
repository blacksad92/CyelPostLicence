package CyelPostLicence;

/**
 * Holder class for : EnumDecision
 * 
 * @author OpenORB Compiler
 */
final public class EnumDecisionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EnumDecision value
     */
    public CyelPostLicence.EnumDecision value;

    /**
     * Default constructor
     */
    public EnumDecisionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EnumDecisionHolder(CyelPostLicence.EnumDecision initial)
    {
        value = initial;
    }

    /**
     * Read EnumDecision from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EnumDecisionHelper.read(istream);
    }

    /**
     * Write EnumDecision into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EnumDecisionHelper.write(ostream,value);
    }

    /**
     * Return the EnumDecision TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EnumDecisionHelper.type();
    }

}
