package CyelPostLicence;

/** 
 * Helper class for : GestionnaireVoeux
 *  
 * @author OpenORB Compiler
 */ 
public class GestionnaireVoeuxHelper
{
    /**
     * Insert GestionnaireVoeux into an any
     * @param a an any
     * @param t GestionnaireVoeux value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.GestionnaireVoeux t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionnaireVoeux from an any
     * @param a an any
     * @return the extracted GestionnaireVoeux value
     */
    public static CyelPostLicence.GestionnaireVoeux extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return CyelPostLicence.GestionnaireVoeuxHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionnaireVoeux TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionnaireVoeux");
        }
        return _tc;
    }

    /**
     * Return the GestionnaireVoeux IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/GestionnaireVoeux:1.0";

    /**
     * Read GestionnaireVoeux from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionnaireVoeux value
     */
    public static CyelPostLicence.GestionnaireVoeux read(org.omg.CORBA.portable.InputStream istream)
    {
        return(CyelPostLicence.GestionnaireVoeux)istream.read_Object(CyelPostLicence._GestionnaireVoeuxStub.class);
    }

    /**
     * Write GestionnaireVoeux into a marshalled stream
     * @param ostream the output stream
     * @param value GestionnaireVoeux value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.GestionnaireVoeux value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionnaireVoeux
     * @param obj the CORBA Object
     * @return GestionnaireVoeux Object
     */
    public static GestionnaireVoeux narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireVoeux)
            return (GestionnaireVoeux)obj;

        if (obj._is_a(id()))
        {
            _GestionnaireVoeuxStub stub = new _GestionnaireVoeuxStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionnaireVoeux
     * @param obj the CORBA Object
     * @return GestionnaireVoeux Object
     */
    public static GestionnaireVoeux unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireVoeux)
            return (GestionnaireVoeux)obj;

        _GestionnaireVoeuxStub stub = new _GestionnaireVoeuxStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
