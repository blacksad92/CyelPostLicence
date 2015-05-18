package CyelPostLicence;

/**
 * Holder class for : Decision
 * 
 * @author OpenORB Compiler
 */
final public class DecisionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Decision value
     */
    public CyelPostLicence.Decision value;

    /**
     * Default constructor
     */
    public DecisionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DecisionHolder(CyelPostLicence.Decision initial)
    {
        value = initial;
    }

    /**
     * Read Decision from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DecisionHelper.read(istream);
    }

    /**
     * Write Decision into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DecisionHelper.write(ostream,value);
    }

    /**
     * Return the Decision TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DecisionHelper.type();
    }

}
