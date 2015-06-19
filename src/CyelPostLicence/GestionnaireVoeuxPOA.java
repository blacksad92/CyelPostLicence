package CyelPostLicence;

/**
 * Interface definition : GestionnaireVoeux
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionnaireVoeuxPOA extends org.omg.PortableServer.Servant
        implements GestionnaireVoeuxOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionnaireVoeux _this()
    {
        return GestionnaireVoeuxHelper.narrow(_this_object());
    }

    public GestionnaireVoeux _this(org.omg.CORBA.ORB orb)
    {
        return GestionnaireVoeuxHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:CyelPostLicence/GestionnaireVoeux:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("RAZPeriode",
                    new Operation_RAZPeriode());
            operationMap.put("_get_academie",
                    new Operation__get_academie());
            operationMap.put("_get_listeUniversite",
                    new Operation__get_listeUniversite());
            operationMap.put("_get_periode",
                    new Operation__get_periode());
            operationMap.put("_set_academie",
                    new Operation__set_academie());
            operationMap.put("_set_periode",
                    new Operation__set_periode());
            operationMap.put("cloturerPeriode",
                    new Operation_cloturerPeriode());
            operationMap.put("consulterAcreditations",
                    new Operation_consulterAcreditations());
            operationMap.put("consulterAcreditationsExternes",
                    new Operation_consulterAcreditationsExternes());
            operationMap.put("consulterVoeux",
                    new Operation_consulterVoeux());
            operationMap.put("enregistrerDecision",
                    new Operation_enregistrerDecision());
            operationMap.put("enregistrerVoeux",
                    new Operation_enregistrerVoeux());
            operationMap.put("recupererListeCandidatures",
                    new Operation_recupererListeCandidatures());
            operationMap.put("repondreVoeu",
                    new Operation_repondreVoeu());
            operationMap.put("supprimerVoeux",
                    new Operation_supprimerVoeux());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_academie(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Academie arg = academie();
        _output = handler.createReply();
        CyelPostLicence.AcademieHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_academie(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Academie result = CyelPostLicence.AcademieHelper.read(_is);

        academie(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_periode(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg = periode();
        _output = handler.createReply();
        _output.write_long(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__set_periode(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int result = _is.read_long();

        periode(result);
        _output = handler.createReply();
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke__get_listeUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Universite[] arg = listeUniversite();
        _output = handler.createReply();
        CyelPostLicence.ListeUniversitesHelper.write(_output,arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterAcreditations(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        CyelPostLicence.Universite[] _arg_result = consulterAcreditations(arg0_in);

        _output = handler.createReply();
        CyelPostLicence.ListeUniversitesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterAcreditationsExternes(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();

        CyelPostLicence.Universite[] _arg_result = consulterAcreditationsExternes(arg0_in);

        _output = handler.createReply();
        CyelPostLicence.ListeUniversitesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Etudiant arg0_in = CyelPostLicence.EtudiantHelper.read(_is);
        CyelPostLicence.Voeu[] arg1_in = CyelPostLicence.ListeVoeuxHelper.read(_is);

        enregistrerVoeux(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_repondreVoeu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        CyelPostLicence.Voeu arg1_in = CyelPostLicence.VoeuHelper.read(_is);

        repondreVoeu(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        boolean arg1_in = _is.read_boolean();

        CyelPostLicence.Voeu[] _arg_result = consulterVoeux(arg0_in, arg1_in);

        _output = handler.createReply();
        CyelPostLicence.ListeVoeuxHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_cloturerPeriode(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        cloturerPeriode();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_RAZPeriode(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        RAZPeriode();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererListeCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        int arg1_in = _is.read_long();

        CyelPostLicence.Etudiant[] _arg_result = recupererListeCandidatures(arg0_in, arg1_in);

        _output = handler.createReply();
        CyelPostLicence.ListeEtudiantsHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerDecision(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Decision arg0_in = CyelPostLicence.DecisionHelper.read(_is);

        enregistrerDecision(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        int arg1_in = _is.read_long();

        supprimerVoeux(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                GestionnaireVoeuxPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_academie extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_academie(_is, handler);
        }
    }

    private static final class Operation__set_academie extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__set_academie(_is, handler);
        }
    }

    private static final class Operation__get_periode extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_periode(_is, handler);
        }
    }

    private static final class Operation__set_periode extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__set_periode(_is, handler);
        }
    }

    private static final class Operation__get_listeUniversite extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_listeUniversite(_is, handler);
        }
    }

    private static final class Operation_consulterAcreditations extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_consulterAcreditations(_is, handler);
        }
    }

    private static final class Operation_consulterAcreditationsExternes extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_consulterAcreditationsExternes(_is, handler);
        }
    }

    private static final class Operation_enregistrerVoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_enregistrerVoeux(_is, handler);
        }
    }

    private static final class Operation_repondreVoeu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_repondreVoeu(_is, handler);
        }
    }

    private static final class Operation_consulterVoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_consulterVoeux(_is, handler);
        }
    }

    private static final class Operation_cloturerPeriode extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_cloturerPeriode(_is, handler);
        }
    }

    private static final class Operation_RAZPeriode extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_RAZPeriode(_is, handler);
        }
    }

    private static final class Operation_recupererListeCandidatures extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_recupererListeCandidatures(_is, handler);
        }
    }

    private static final class Operation_enregistrerDecision extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_enregistrerDecision(_is, handler);
        }
    }

    private static final class Operation_supprimerVoeux extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireVoeuxPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_supprimerVoeux(_is, handler);
        }
    }

}
