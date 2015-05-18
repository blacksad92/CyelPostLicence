package CyelPostLicence;

/** 
 * Helper class for : Accreditation
 *  
 * @author OpenORB Compiler
 */ 
public class AccreditationHelper
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
     * Insert Accreditation into an any
     * @param a an any
     * @param t Accreditation value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Accreditation t)
    {
        a.insert_Streamable(new CyelPostLicence.AccreditationHolder(t));
    }

    /**
     * Extract Accreditation from an any
     * @param a an any
     * @return the extracted Accreditation value
     */
    public static CyelPostLicence.Accreditation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.AccreditationHolder)
                    return ((CyelPostLicence.AccreditationHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.AccreditationHolder h = new CyelPostLicence.AccreditationHolder(read(a.create_input_stream()));
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
     * Return the Accreditation TypeCode
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
                _members[0].name = "universite";
                _members[0].type = CyelPostLicence.UniversiteHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "master";
                _members[1].type = CyelPostLicence.MasterHelper.type();
                _tc = orb.create_struct_tc(id(),"Accreditation",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Accreditation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/Accreditation:1.0";

    /**
     * Read Accreditation from a marshalled stream
     * @param istream the input stream
     * @return the readed Accreditation value
     */
    public static CyelPostLicence.Accreditation read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Accreditation new_one = new CyelPostLicence.Accreditation();

        new_one.universite = CyelPostLicence.UniversiteHelper.read(istream);
        new_one.master = CyelPostLicence.MasterHelper.read(istream);

        return new_one;
    }

    /**
     * Write Accreditation into a marshalled stream
     * @param ostream the output stream
     * @param value Accreditation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Accreditation value)
    {
        CyelPostLicence.UniversiteHelper.write(ostream,value.universite);
        CyelPostLicence.MasterHelper.write(ostream,value.master);
    }

}
