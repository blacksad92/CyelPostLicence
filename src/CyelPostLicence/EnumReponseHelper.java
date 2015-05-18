package CyelPostLicence;

/** 
 * Helper class for : EnumReponse
 *  
 * @author OpenORB Compiler
 */ 
public class EnumReponseHelper
{
    /**
     * Insert EnumReponse into an any
     * @param a an any
     * @param t EnumReponse value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.EnumReponse t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract EnumReponse from an any
     * @param a an any
     * @return the extracted EnumReponse value
     */
    public static CyelPostLicence.EnumReponse extract(org.omg.CORBA.Any a)
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
     * Return the EnumReponse TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[5];
            _members[0] = "oui";
            _members[1] = "ouiMais";
            _members[2] = "non";
            _members[3] = "nonMais";
            _members[4] = "vide";
            _tc = orb.create_enum_tc(id(),"EnumReponse",_members);
        }
        return _tc;
    }

    /**
     * Return the EnumReponse IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/EnumReponse:1.0";

    /**
     * Read EnumReponse from a marshalled stream
     * @param istream the input stream
     * @return the readed EnumReponse value
     */
    public static CyelPostLicence.EnumReponse read(org.omg.CORBA.portable.InputStream istream)
    {
        return EnumReponse.from_int(istream.read_ulong());
    }

    /**
     * Write EnumReponse into a marshalled stream
     * @param ostream the output stream
     * @param value EnumReponse value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.EnumReponse value)
    {
        ostream.write_ulong(value.value());
    }

}
