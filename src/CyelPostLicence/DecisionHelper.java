package CyelPostLicence;

/** 
 * Helper class for : Decision
 *  
 * @author OpenORB Compiler
 */ 
public class DecisionHelper
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
     * Insert Decision into an any
     * @param a an any
     * @param t Decision value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Decision t)
    {
        a.insert_Streamable(new CyelPostLicence.DecisionHolder(t));
    }

    /**
     * Extract Decision from an any
     * @param a an any
     * @return the extracted Decision value
     */
    public static CyelPostLicence.Decision extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.DecisionHolder)
                    return ((CyelPostLicence.DecisionHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.DecisionHolder h = new CyelPostLicence.DecisionHolder(read(a.create_input_stream()));
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
     * Return the Decision TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "etudiant";
                _members[0].type = CyelPostLicence.EtudiantHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "numUniversite";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "numMaster";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "decision";
                _members[3].type = CyelPostLicence.EnumDecisionHelper.type();
                _tc = orb.create_struct_tc(id(),"Decision",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Decision IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/Decision:1.0";

    /**
     * Read Decision from a marshalled stream
     * @param istream the input stream
     * @return the readed Decision value
     */
    public static CyelPostLicence.Decision read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Decision new_one = new CyelPostLicence.Decision();

        new_one.etudiant = CyelPostLicence.EtudiantHelper.read(istream);
        new_one.numUniversite = istream.read_long();
        new_one.numMaster = istream.read_long();
        new_one.decision = CyelPostLicence.EnumDecisionHelper.read(istream);

        return new_one;
    }

    /**
     * Write Decision into a marshalled stream
     * @param ostream the output stream
     * @param value Decision value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Decision value)
    {
        CyelPostLicence.EtudiantHelper.write(ostream,value.etudiant);
        ostream.write_long(value.numUniversite);
        ostream.write_long(value.numMaster);
        CyelPostLicence.EnumDecisionHelper.write(ostream,value.decision);
    }

}
