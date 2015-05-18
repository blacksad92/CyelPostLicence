package CyelPostLicence;

/**
 * Interface definition : GestionnaireReferentiel
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionnaireReferentielPOA extends org.omg.PortableServer.Servant
        implements GestionnaireReferentielOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionnaireReferentiel _this()
    {
        return GestionnaireReferentielHelper.narrow(_this_object());
    }

    public GestionnaireReferentiel _this(org.omg.CORBA.ORB orb)
    {
        return GestionnaireReferentielHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CyelPostLicence/GestionnaireReferentiel:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_listeAcademies")) {
                return _invoke__get_listeAcademies(_is, handler);
        } else if (opName.equals("_get_listeLicences")) {
                return _invoke__get_listeLicences(_is, handler);
        } else if (opName.equals("_get_listeMasters")) {
                return _invoke__get_listeMasters(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_listeAcademies(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Academie[] arg = listeAcademies();
        _output = handler.createReply();
        CyelPostLicence.ListeAcademiesHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_listeMasters(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Master[] arg = listeMasters();
        _output = handler.createReply();
        CyelPostLicence.ListeMasterHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_listeLicences(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Licence[] arg = listeLicences();
        _output = handler.createReply();
        CyelPostLicence.ListeLicencesHelper.write(_output,arg);
        return _output;
    }

}
