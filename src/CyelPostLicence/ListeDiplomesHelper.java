package CyelPostLicence;

/** 
 * Helper class for : ListeDiplomes
 *  
 * @author OpenORB Compiler
 */ 
public class ListeDiplomesHelper
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
     * Insert ListeDiplomes into an any
     * @param a an any
     * @param t ListeDiplomes value
     */
    public static void insert(org.omg.CORBA.Any a, CyelPostLicence.Diplome[] t)
    {
        a.insert_Streamable(new CyelPostLicence.ListeDiplomesHolder(t));
    }

    /**
     * Extract ListeDiplomes from an any
     * @param a an any
     * @return the extracted ListeDiplomes value
     */
    public static CyelPostLicence.Diplome[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof CyelPostLicence.ListeDiplomesHolder)
                    return ((CyelPostLicence.ListeDiplomesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            CyelPostLicence.ListeDiplomesHolder h = new CyelPostLicence.ListeDiplomesHolder(read(a.create_input_stream()));
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
     * Return the ListeDiplomes TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"ListeDiplomes",orb.create_sequence_tc(0,CyelPostLicence.DiplomeHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the ListeDiplomes IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:CyelPostLicence/ListeDiplomes:1.0";

    /**
     * Read ListeDiplomes from a marshalled stream
     * @param istream the input stream
     * @return the readed ListeDiplomes value
     */
    public static CyelPostLicence.Diplome[] read(org.omg.CORBA.portable.InputStream istream)
    {
        CyelPostLicence.Diplome[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new CyelPostLicence.Diplome[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = CyelPostLicence.DiplomeHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write ListeDiplomes into a marshalled stream
     * @param ostream the output stream
     * @param value ListeDiplomes value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, CyelPostLicence.Diplome[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            CyelPostLicence.DiplomeHelper.write(ostream,value[i7]);

        }
    }

}
