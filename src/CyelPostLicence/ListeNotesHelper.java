package CyelPostLicence;

/** 
 * Helper class for : ListeNotes
 *  
 * @author OpenORB Compiler
 */ 
public class ListeNotesHelper
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
     * Insert ListeNotes into an any
     * @param a an any
     * @param t ListeNotes value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Note[] t)
    {
        a.insert_Streamable(new CyelPostLicence.ListeNotesHolder(t));
    }

    /**
     * Extract ListeNotes from an any
     * @param a an any
     * @return the extracted ListeNotes value
     */
    public static CyelPostLicence.Note[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.ListeNotesHolder)
                    return ((CyelPostLicence.ListeNotesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.ListeNotesHolder h = new CyelPostLicence.ListeNotesHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ListeNotes TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"ListeNotes",orb.create_sequence_tc(0,CyelPostLicence.NoteHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the ListeNotes IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/ListeNotes:1.0";

    /**
     * Read ListeNotes from a marshalled stream
     * @param istream the input stream
     * @return the readed ListeNotes value
     */
    public static CyelPostLicence.Note[] read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Note[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new CyelPostLicence.Note[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = CyelPostLicence.NoteHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write ListeNotes into a marshalled stream
     * @param ostream the output stream
     * @param value ListeNotes value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Note[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            CyelPostLicence.NoteHelper.write(ostream,value[i7]);

        }
    }

}
