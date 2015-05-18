package CyelPostLicence;

/**
 * Interface definition : GestionnaireCandidatures
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionnaireCandidaturesPOA extends org.omg.PortableServer.Servant
        implements GestionnaireCandidaturesOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionnaireCandidatures _this()
    {
        return GestionnaireCandidaturesHelper.narrow(_this_object());
    }

    public GestionnaireCandidatures _this(org.omg.CORBA.ORB orb)
    {
        return GestionnaireCandidaturesHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CyelPostLicence/GestionnaireCandidatures:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_listeMaster")) {
                return _invoke__get_listeMaster(_is, handler);
        } else if (opName.equals("_get_universite")) {
                return _invoke__get_universite(_is, handler);
        } else if (opName.equals("_set_universite")) {
                return _invoke__set_universite(_is, handler);
        } else if (opName.equals("consulterCandidatures")) {
                return _invoke_consulterCandidatures(_is, handler);
        } else if (opName.equals("enregistrerCandidatures")) {
                return _invoke_enregistrerCandidatures(_is, handler);
        } else if (opName.equals("recupererListeNotes")) {
                return _invoke_recupererListeNotes(_is, handler);
        } else if (opName.equals("validerCandidature")) {
                return _invoke_validerCandidature(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_universite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Universite arg = universite();
        _output = handler.createReply();
        CyelPostLicence.UniversiteHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_universite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Universite result = CyelPostLicence.UniversiteHelper.read(_is);

        universite(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_listeMaster(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Master[] arg = listeMaster();
        _output = handler.createReply();
        CyelPostLicence.ListeMasterHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererListeNotes(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        boolean arg1_in = _is.read_boolean();

        CyelPostLicence.Note[] _arg_result = recupererListeNotes(arg0_in, arg1_in);

        _output = handler.createReply();
        CyelPostLicence.ListeNotesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_validerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        int arg1_in = _is.read_long();

        CyelPostLicence.EtatCandidature _arg_result = validerCandidature(arg0_in, arg1_in);

        _output = handler.createReply();
        CyelPostLicence.EtatCandidatureHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Etudiant[] arg0_in = CyelPostLicence.ListeCandidaturesHelper.read(_is);
        int arg1_in = _is.read_long();

        enregistrerCandidatures(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        int arg1_in = _is.read_long();

        CyelPostLicence.Etudiant[] _arg_result = consulterCandidatures(arg0_in, arg1_in);

        _output = handler.createReply();
        CyelPostLicence.ListeCandidaturesHelper.write(_output,_arg_result);

        return _output;
    }

}
