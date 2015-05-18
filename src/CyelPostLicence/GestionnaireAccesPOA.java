package CyelPostLicence;

/**
 * Interface definition : GestionnaireAcces
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionnaireAccesPOA extends org.omg.PortableServer.Servant
        implements GestionnaireAccesOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionnaireAcces _this()
    {
        return GestionnaireAccesHelper.narrow(_this_object());
    }

    public GestionnaireAcces _this(org.omg.CORBA.ORB orb)
    {
        return GestionnaireAccesHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CyelPostLicence/GestionnaireAcces:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_listeGestionnairesVoeux")) {
                return _invoke__get_listeGestionnairesVoeux(_is, handler);
        } else if (opName.equals("identification")) {
                return _invoke_identification(_is, handler);
        } else if (opName.equals("identificationUniv")) {
                return _invoke_identificationUniv(_is, handler);
        } else if (opName.equals("inscriptionGestionnaireCandidatures")) {
                return _invoke_inscriptionGestionnaireCandidatures(_is, handler);
        } else if (opName.equals("inscriptionGestionnaireVoeux")) {
                return _invoke_inscriptionGestionnaireVoeux(_is, handler);
        } else if (opName.equals("obtenirEtudiant")) {
                return _invoke_obtenirEtudiant(_is, handler);
        } else if (opName.equals("obtenirGestionnaireCandidatures")) {
                return _invoke_obtenirGestionnaireCandidatures(_is, handler);
        } else if (opName.equals("obtenirGestionnaireVoeux")) {
                return _invoke_obtenirGestionnaireVoeux(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_listeGestionnairesVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.GestionnaireVoeux[] arg = listeGestionnairesVoeux();
        _output = handler.createReply();
        CyelPostLicence.ListeGestionnairesVoeuxHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_identification(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        CyelPostLicence.Academie arg1_in = CyelPostLicence.AcademieHelper.read(_is);

        try
        {
            CyelPostLicence.Etudiant _arg_result = identification(arg0_in, arg1_in);

            _output = handler.createReply();
            CyelPostLicence.EtudiantHelper.write(_output,_arg_result);

        }
        catch (CyelPostLicence.EtudiantInconnu _exception)
        {
            _output = handler.createExceptionReply();
            CyelPostLicence.EtudiantInconnuHelper.write(_output,_exception);
        }
        catch (CyelPostLicence.AcademieIncorrecte _exception)
        {
            _output = handler.createExceptionReply();
            CyelPostLicence.AcademieIncorrecteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_obtenirGestionnaireVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        CyelPostLicence.GestionnaireVoeux _arg_result = obtenirGestionnaireVoeux(arg0_in);

        _output = handler.createReply();
        CyelPostLicence.GestionnaireVoeuxHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_obtenirGestionnaireCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        CyelPostLicence.GestionnaireCandidatures _arg_result = obtenirGestionnaireCandidatures(arg0_in);

        _output = handler.createReply();
        CyelPostLicence.GestionnaireCandidaturesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_identificationUniv(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        int arg2_in = _is.read_long();

        try
        {
            CyelPostLicence.GestionnaireVoeux _arg_result = identificationUniv(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            CyelPostLicence.GestionnaireVoeuxHelper.write(_output,_arg_result);

        }
        catch (CyelPostLicence.ResponsableInconnu _exception)
        {
            _output = handler.createExceptionReply();
            CyelPostLicence.ResponsableInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_inscriptionGestionnaireVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.GestionnaireVoeux arg0_in = CyelPostLicence.GestionnaireVoeuxHelper.read(_is);

        inscriptionGestionnaireVoeux(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_inscriptionGestionnaireCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.GestionnaireCandidatures arg0_in = CyelPostLicence.GestionnaireCandidaturesHelper.read(_is);

        inscriptionGestionnaireCandidatures(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_obtenirEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        CyelPostLicence.Etudiant _arg_result = obtenirEtudiant(arg0_in);

        _output = handler.createReply();
        CyelPostLicence.EtudiantHelper.write(_output,_arg_result);

        return _output;
    }

}
