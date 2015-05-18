package CyelPostLicence;

/** 
 * Helper class for : Etudiant
 *  
 * @author OpenORB Compiler
 */ 
public class EtudiantHelper
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
     * Insert Etudiant into an any
     * @param a an any
     * @param t Etudiant value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Etudiant t)
    {
        a.insert_Streamable(new CyelPostLicence.EtudiantHolder(t));
    }

    /**
     * Extract Etudiant from an any
     * @param a an any
     * @return the extracted Etudiant value
     */
    public static CyelPostLicence.Etudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.EtudiantHolder)
                    return ((CyelPostLicence.EtudiantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.EtudiantHolder h = new CyelPostLicence.EtudiantHolder(read(a.create_input_stream()));
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
     * Return the Etudiant TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[5];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "INE";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nom";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "prenom";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "licence";
                _members[3].type = CyelPostLicence.LicenceHelper.type();
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "universite";
                _members[4].type = CyelPostLicence.UniversiteHelper.type();
                _tc = orb.create_struct_tc(id(),"Etudiant",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Etudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/Etudiant:1.0";

    /**
     * Read Etudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed Etudiant value
     */
    public static CyelPostLicence.Etudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Etudiant new_one = new CyelPostLicence.Etudiant();

        new_one.INE = istream.read_long();
        new_one.nom = istream.read_string();
        new_one.prenom = istream.read_string();
        new_one.licence = CyelPostLicence.LicenceHelper.read(istream);
        new_one.universite = CyelPostLicence.UniversiteHelper.read(istream);

        return new_one;
    }

    /**
     * Write Etudiant into a marshalled stream
     * @param ostream the output stream
     * @param value Etudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Etudiant value)
    {
        ostream.write_long(value.INE);
        ostream.write_string(value.nom);
        ostream.write_string(value.prenom);
        CyelPostLicence.LicenceHelper.write(ostream,value.licence);
        CyelPostLicence.UniversiteHelper.write(ostream,value.universite);
    }

}
