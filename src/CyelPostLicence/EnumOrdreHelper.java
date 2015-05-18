package CyelPostLicence;

/** 
 * Helper class for : EnumOrdre
 *  
 * @author OpenORB Compiler
 */ 
public class EnumOrdreHelper
{
    /**
     * Insert EnumOrdre into an any
     * @param a an any
     * @param t EnumOrdre value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.EnumOrdre t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract EnumOrdre from an any
     * @param a an any
     * @return the extracted EnumOrdre value
     */
    public static CyelPostLicence.EnumOrdre extract(org.omg.CORBA.Any a)
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
     * Return the EnumOrdre TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[6];
            _members[0] = "un";
            _members[1] = "deux";
            _members[2] = "trois";
            _members[3] = "quatre";
            _members[4] = "cinq";
            _members[5] = "vide";
            _tc = orb.create_enum_tc(id(),"EnumOrdre",_members);
        }
        return _tc;
    }

    /**
     * Return the EnumOrdre IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/EnumOrdre:1.0";

    /**
     * Read EnumOrdre from a marshalled stream
     * @param istream the input stream
     * @return the readed EnumOrdre value
     */
    public static CyelPostLicence.EnumOrdre read(org.omg.CORBA.portable.InputStream istream)
    {
        return EnumOrdre.from_int(istream.read_ulong());
    }

    /**
     * Write EnumOrdre into a marshalled stream
     * @param ostream the output stream
     * @param value EnumOrdre value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.EnumOrdre value)
    {
        ostream.write_ulong(value.value());
    }

}
