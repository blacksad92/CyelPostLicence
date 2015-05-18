package CyelPostLicence;

/** 
 * Helper class for : Note
 *  
 * @author OpenORB Compiler
 */ 
public class NoteHelper
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
     * Insert Note into an any
     * @param a an any
     * @param t Note value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Note t)
    {
        a.insert_Streamable(new CyelPostLicence.NoteHolder(t));
    }

    /**
     * Extract Note from an any
     * @param a an any
     * @return the extracted Note value
     */
    public static CyelPostLicence.Note extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.NoteHolder)
                    return ((CyelPostLicence.NoteHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.NoteHolder h = new CyelPostLicence.NoteHolder(read(a.create_input_stream()));
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
     * Return the Note TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[8];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "INE";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "semestre";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "numSemestre";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "moyenne";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "obtention";
                _members[4].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "position";
                _members[5].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[6] = new org.omg.CORBA.StructMember();
                _members[6].name = "licence";
                _members[6].type = CyelPostLicence.LicenceHelper.type();
                _members[7] = new org.omg.CORBA.StructMember();
                _members[7].name = "numUniversite";
                _members[7].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _tc = orb.create_struct_tc(id(),"Note",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Note IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/Note:1.0";

    /**
     * Read Note from a marshalled stream
     * @param istream the input stream
     * @return the readed Note value
     */
    public static CyelPostLicence.Note read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Note new_one = new CyelPostLicence.Note();

        new_one.INE = istream.read_long();
        new_one.semestre = istream.read_long();
        new_one.numSemestre = istream.read_long();
        new_one.moyenne = istream.read_long();
        new_one.obtention = istream.read_string();
        new_one.position = istream.read_string();
        new_one.licence = CyelPostLicence.LicenceHelper.read(istream);
        new_one.numUniversite = istream.read_long();

        return new_one;
    }

    /**
     * Write Note into a marshalled stream
     * @param ostream the output stream
     * @param value Note value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Note value)
    {
        ostream.write_long(value.INE);
        ostream.write_long(value.semestre);
        ostream.write_long(value.numSemestre);
        ostream.write_long(value.moyenne);
        ostream.write_string(value.obtention);
        ostream.write_string(value.position);
        CyelPostLicence.LicenceHelper.write(ostream,value.licence);
        ostream.write_long(value.numUniversite);
    }

}
