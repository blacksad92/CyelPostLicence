package CyelPostLicence;

/** 
 * Helper class for : GestionnaireAcces
 *  
 * @author OpenORB Compiler
 */ 
public class GestionnaireAccesHelper
{
    /**
     * Insert GestionnaireAcces into an any
     * @param a an any
     * @param t GestionnaireAcces value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.GestionnaireAcces t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionnaireAcces from an any
     * @param a an any
     * @return the extracted GestionnaireAcces value
     */
    public static CyelPostLicence.GestionnaireAcces extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return CyelPostLicence.GestionnaireAccesHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionnaireAcces TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionnaireAcces");
        }
        return _tc;
    }

    /**
     * Return the GestionnaireAcces IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/GestionnaireAcces:1.0";

    /**
     * Read GestionnaireAcces from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionnaireAcces value
     */
    public static CyelPostLicence.GestionnaireAcces read(org.omg.CORBA.portable.InputStream istream)
    {
        return(CyelPostLicence.GestionnaireAcces)istream.read_Object(CyelPostLicence._GestionnaireAccesStub.class);
    }

    /**
     * Write GestionnaireAcces into a marshalled stream
     * @param ostream the output stream
     * @param value GestionnaireAcces value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.GestionnaireAcces value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionnaireAcces
     * @param obj the CORBA Object
     * @return GestionnaireAcces Object
     */
    public static GestionnaireAcces narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireAcces)
            return (GestionnaireAcces)obj;

        if (obj._is_a(id()))
        {
            _GestionnaireAccesStub stub = new _GestionnaireAccesStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionnaireAcces
     * @param obj the CORBA Object
     * @return GestionnaireAcces Object
     */
    public static GestionnaireAcces unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireAcces)
            return (GestionnaireAcces)obj;

        _GestionnaireAccesStub stub = new _GestionnaireAccesStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
