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

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("RAZPeriode",
                    new Operation_RAZPeriode());
            operationMap.put("_get_listeMaster",
                    new Operation__get_listeMaster());
            operationMap.put("_get_universite",
                    new Operation__get_universite());
            operationMap.put("_set_universite",
                    new Operation__set_universite());
            operationMap.put("consulterCandidatures",
                    new Operation_consulterCandidatures());
            operationMap.put("enregistrerCandidatures",
                    new Operation_enregistrerCandidatures());
            operationMap.put("enregistrerClassement",
                    new Operation_enregistrerClassement());
            operationMap.put("finPeriodeDecision",
                    new Operation_finPeriodeDecision());
            operationMap.put("majListe",
                    new Operation_majListe());
            operationMap.put("recupererListeNotes",
                    new Operation_recupererListeNotes());
            operationMap.put("validerCandidature",
                    new Operation_validerCandidature());
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

    private org.omg.CORBA.portable.OutputStream _invoke_RAZPeriode(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        RAZPeriode();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_validerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        int arg1_in = _is.read_long();

        CyelPostLicence.EnumDecision _arg_result = validerCandidature(arg0_in, arg1_in);

        _output = handler.createReply();
        CyelPostLicence.EnumDecisionHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        CyelPostLicence.Etudiant arg0_in = CyelPostLicence.EtudiantHelper.read(_is);
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

        CyelPostLicence.Candidature[] _arg_result = consulterCandidatures(arg0_in, arg1_in);

        _output = handler.createReply();
        CyelPostLicence.ListeCandidaturesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerClassement(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        int arg1_in = _is.read_long();

        enregistrerClassement(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_finPeriodeDecision(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        finPeriodeDecision();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_majListe(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = _is.read_long();
        CyelPostLicence.Voeu arg1_in = CyelPostLicence.VoeuHelper.read(_is);

        majListe(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                GestionnaireCandidaturesPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_universite extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_universite(_is, handler);
        }
    }

    private static final class Operation__set_universite extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__set_universite(_is, handler);
        }
    }

    private static final class Operation__get_listeMaster extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_listeMaster(_is, handler);
        }
    }

    private static final class Operation_recupererListeNotes extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_recupererListeNotes(_is, handler);
        }
    }

    private static final class Operation_RAZPeriode extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_RAZPeriode(_is, handler);
        }
    }

    private static final class Operation_validerCandidature extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_validerCandidature(_is, handler);
        }
    }

    private static final class Operation_enregistrerCandidatures extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_enregistrerCandidatures(_is, handler);
        }
    }

    private static final class Operation_consulterCandidatures extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_consulterCandidatures(_is, handler);
        }
    }

    private static final class Operation_enregistrerClassement extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_enregistrerClassement(_is, handler);
        }
    }

    private static final class Operation_finPeriodeDecision extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_finPeriodeDecision(_is, handler);
        }
    }

    private static final class Operation_majListe extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final GestionnaireCandidaturesPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_majListe(_is, handler);
        }
    }

}
