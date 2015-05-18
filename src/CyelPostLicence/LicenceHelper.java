package CyelPostLicence;

/** 
 * Helper class for : Licence
 *  
 * @author OpenORB Compiler
 */ 
public class LicenceHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert Licence into an any
     * @param a an any
     * @param t Licence value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Licence t)
    {
        a.insert_Streamable(new CyelPostLicence.LicenceHolder(t));
    }

    /**
     * Extract Licence from an any
     * @param a an any
     * @return the extracted Licence value
     */
    public static CyelPostLicence.Licence extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.LicenceHolder)
                    return ((CyelPostLicence.LicenceHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.LicenceHolder h = new CyelPostLicence.LicenceHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the Licence TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "numLicence";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomLicence";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Licence",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Licence IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/Licence:1.0";

    /**
     * Read Licence from a marshalled stream
     * @param istream the input stream
     * @return the readed Licence value
     */
    public static CyelPostLicence.Licence read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Licence new_one = new CyelPostLicence.Licence();

        new_one.numLicence = istream.read_long();
        new_one.nomLicence = istream.read_string();

        return new_one;
    }

    /**
     * Write Licence into a marshalled stream
     * @param ostream the output stream
     * @param value Licence value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Licence value)
    {
        ostream.write_long(value.numLicence);
        ostream.write_string(value.nomLicence);
    }

}
