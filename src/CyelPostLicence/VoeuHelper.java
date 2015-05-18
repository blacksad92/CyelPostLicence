package CyelPostLicence;

/** 
 * Helper class for : Voeu
 *  
 * @author OpenORB Compiler
 */ 
public class VoeuHelper
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
     * Insert Voeu into an any
     * @param a an any
     * @param t Voeu value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Voeu t)
    {
        a.insert_Streamable(new CyelPostLicence.VoeuHolder(t));
    }

    /**
     * Extract Voeu from an any
     * @param a an any
     * @return the extracted Voeu value
     */
    public static CyelPostLicence.Voeu extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.VoeuHolder)
                    return ((CyelPostLicence.VoeuHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.VoeuHolder h = new CyelPostLicence.VoeuHolder(read(a.create_input_stream()));
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
     * Return the Voeu TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[7];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "numVoeu";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "universite";
                _members[1].type = CyelPostLicence.UniversiteHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "master";
                _members[2].type = CyelPostLicence.MasterHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "ordre";
                _members[3].type = CyelPostLicence.EnumOrdreHelper.type();
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "etatCandidature";
                _members[4].type = CyelPostLicence.EtatCandidatureHelper.type();
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "reponse";
                _members[5].type = CyelPostLicence.EnumReponseHelper.type();
                _members[6] = new org.omg.CORBA.StructMember();
                _members[6].name = "numLicence";
                _members[6].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _tc = orb.create_struct_tc(id(),"Voeu",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Voeu IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/Voeu:1.0";

    /**
     * Read Voeu from a marshalled stream
     * @param istream the input stream
     * @return the readed Voeu value
     */
    public static CyelPostLicence.Voeu read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Voeu new_one = new CyelPostLicence.Voeu();

        new_one.numVoeu = istream.read_long();
        new_one.universite = CyelPostLicence.UniversiteHelper.read(istream);
        new_one.master = CyelPostLicence.MasterHelper.read(istream);
        new_one.ordre = CyelPostLicence.EnumOrdreHelper.read(istream);
        new_one.etatCandidature = CyelPostLicence.EtatCandidatureHelper.read(istream);
        new_one.reponse = CyelPostLicence.EnumReponseHelper.read(istream);
        new_one.numLicence = istream.read_long();

        return new_one;
    }

    /**
     * Write Voeu into a marshalled stream
     * @param ostream the output stream
     * @param value Voeu value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Voeu value)
    {
        ostream.write_long(value.numVoeu);
        CyelPostLicence.UniversiteHelper.write(ostream,value.universite);
        CyelPostLicence.MasterHelper.write(ostream,value.master);
        CyelPostLicence.EnumOrdreHelper.write(ostream,value.ordre);
        CyelPostLicence.EtatCandidatureHelper.write(ostream,value.etatCandidature);
        CyelPostLicence.EnumReponseHelper.write(ostream,value.reponse);
        ostream.write_long(value.numLicence);
    }

}
