package CyelPostLicence;

/** 
 * Helper class for : GestionnaireReferentiel
 *  
 * @author OpenORB Compiler
 */ 
public class GestionnaireReferentielHelper
{
    /**
     * Insert GestionnaireReferentiel into an any
     * @param a an any
     * @param t GestionnaireReferentiel value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.GestionnaireReferentiel t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionnaireReferentiel from an any
     * @param a an any
     * @return the extracted GestionnaireReferentiel value
     */
    public static CyelPostLicence.GestionnaireReferentiel extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return CyelPostLicence.GestionnaireReferentielHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionnaireReferentiel TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionnaireReferentiel");
        }
        return _tc;
    }

    /**
     * Return the GestionnaireReferentiel IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/GestionnaireReferentiel:1.0";

    /**
     * Read GestionnaireReferentiel from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionnaireReferentiel value
     */
    public static CyelPostLicence.GestionnaireReferentiel read(org.omg.CORBA.portable.InputStream istream)
    {
        return(CyelPostLicence.GestionnaireReferentiel)istream.read_Object(CyelPostLicence._GestionnaireReferentielStub.class);
    }

    /**
     * Write GestionnaireReferentiel into a marshalled stream
     * @param ostream the output stream
     * @param value GestionnaireReferentiel value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.GestionnaireReferentiel value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionnaireReferentiel
     * @param obj the CORBA Object
     * @return GestionnaireReferentiel Object
     */
    public static GestionnaireReferentiel narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireReferentiel)
            return (GestionnaireReferentiel)obj;

        if (obj._is_a(id()))
        {
            _GestionnaireReferentielStub stub = new _GestionnaireReferentielStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionnaireReferentiel
     * @param obj the CORBA Object
     * @return GestionnaireReferentiel Object
     */
    public static GestionnaireReferentiel unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionnaireReferentiel)
            return (GestionnaireReferentiel)obj;

        _GestionnaireReferentielStub stub = new _GestionnaireReferentielStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
