package CyelPostLicence;

/** 
 * Helper class for : Diplome
 *  
 * @author OpenORB Compiler
 */ 
public class DiplomeHelper
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
     * Insert Diplome into an any
     * @param a an any
     * @param t Diplome value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Diplome t)
    {
        a.insert_Streamable(new CyelPostLicence.DiplomeHolder(t));
    }

    /**
     * Extract Diplome from an any
     * @param a an any
     * @return the extracted Diplome value
     */
    public static CyelPostLicence.Diplome extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.DiplomeHolder)
                    return ((CyelPostLicence.DiplomeHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.DiplomeHolder h = new CyelPostLicence.DiplomeHolder(read(a.create_input_stream()));
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
     * Return the Diplome TypeCode
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
                _members[0].name = "numDiplome";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomDiplome";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Diplome",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Diplome IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/Diplome:1.0";

    /**
     * Read Diplome from a marshalled stream
     * @param istream the input stream
     * @return the readed Diplome value
     */
    public static CyelPostLicence.Diplome read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Diplome new_one = new CyelPostLicence.Diplome();

        new_one.numDiplome = istream.read_long();
        new_one.nomDiplome = istream.read_string();

        return new_one;
    }

    /**
     * Write Diplome into a marshalled stream
     * @param ostream the output stream
     * @param value Diplome value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Diplome value)
    {
        ostream.write_long(value.numDiplome);
        ostream.write_string(value.nomDiplome);
    }

}
