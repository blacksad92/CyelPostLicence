package CyelPostLicence;

/** 
 * Helper class for : GestionnaireCandidatures
 *  
 * @author OpenORB Compiler
 */ 
public class GestionnaireCandidaturesHelper
{
    /**
     * Insert GestionnaireCandidatures into an any
     * @param a an any
     * @param t GestionnaireCandidatures value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.GestionnaireCandidatures t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionnaireCandidatures from an any
     * @param a an any
     * @return the extracted GestionnaireCandidatures value
     */
    public static CyelPostLicence.GestionnaireCandidatures extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return CyelPostLicence.GestionnaireCandidaturesHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionnaireCandidatures TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionnaireCandidatures");
        }
        return _tc;
    }

    /**
     * Return the GestionnaireCandidatures IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/GestionnaireCandidatures:1.0";

    /**
     * Read GestionnaireCandidatures from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionnaireCandidatures value
     */
    public static CyelPostLicence.GestionnaireCandidatures read(org.omg.CORBA.portable.InputStream istream)
    {
        return(CyelPostLicence.GestionnaireCandidatures)istream.read_Object(CyelPostLicence._GestionnaireCandidaturesStub.class);
    }

    /**
     * Write GestionnaireCandidatures into a marshalled stream
     * @param ostream the output stream
     * @param value GestionnaireCandidatures value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.GestionnaireCandidatures value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionnaireCandidatures
     * @param obj the CORBA Object
     * @return GestionnaireCandidatures Object
     */
    public static GestionnaireCandidatures narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireCandidatures)
            return (GestionnaireCandidatures)obj;

        if (obj._is_a(id()))
        {
            _GestionnaireCandidaturesStub stub = new _GestionnaireCandidaturesStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionnaireCandidatures
     * @param obj the CORBA Object
     * @return GestionnaireCandidatures Object
     */
    public static GestionnaireCandidatures unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireCandidatures)
            return (GestionnaireCandidatures)obj;

        _GestionnaireCandidaturesStub stub = new _GestionnaireCandidaturesStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
