package CyelPostLicence;

/** 
 * Helper class for : EnumDecision
 *  
 * @author OpenORB Compiler
 */ 
public class EnumDecisionHelper
{
    /**
     * Insert EnumDecision into an any
     * @param a an any
     * @param t EnumDecision value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.EnumDecision t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract EnumDecision from an any
     * @param a an any
     * @return the extracted EnumDecision value
     */
    public static CyelPostLicence.EnumDecision extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the EnumDecision TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[6];
            _members[0] = "valide";
            _members[1] = "nonValide";
            _members[2] = "refusee";
            _members[3] = "acceptee";
            _members[4] = "listeAttente";
            _members[5] = "vide";
            _tc = orb.create_enum_tc(id(),"EnumDecision",_members);
        }
        return _tc;
    }

    /**
     * Return the EnumDecision IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/EnumDecision:1.0";

    /**
     * Read EnumDecision from a marshalled stream
     * @param istream the input stream
     * @return the readed EnumDecision value
     */
    public static CyelPostLicence.EnumDecision read(org.omg.CORBA.portable.InputStream istream)
    {
        return EnumDecision.from_int(istream.read_ulong());
    }

    /**
     * Write EnumDecision into a marshalled stream
     * @param ostream the output stream
     * @param value EnumDecision value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.EnumDecision value)
    {
        ostream.write_ulong(value.value());
    }

}
