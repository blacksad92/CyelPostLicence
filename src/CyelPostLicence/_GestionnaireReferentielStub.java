package CyelPostLicence;

/**
 * Interface definition : GestionnaireReferentiel
 * 
 * @author OpenORB Compiler
 */
public class _GestionnaireReferentielStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionnaireReferentiel
{
    static final String[] _ids_list =
    {
        "IDL:CyelPostLicence/GestionnaireReferentiel:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = CyelPostLicence.GestionnaireReferentielOperations.class;

    /**
     * Read accessor for listeAcademies attribute
     * @return the attribute value
     */
    public CyelPostLicence.Academie[] listeAcademies()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_listeAcademies",true);
                    _input = this._invoke(_output);
                    return CyelPostLicence.ListeAcademiesHelper.read(_input);
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_listeAcademies",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireReferentielOperations _self = (CyelPostLicence.GestionnaireReferentielOperations) _so.servant;
                try
                {
                    return _self.listeAcademies();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for listeMasters attribute
     * @return the attribute value
     */
    public CyelPostLicence.Master[] listeMasters()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_listeMasters",true);
                    _input = this._invoke(_output);
                    return CyelPostLicence.ListeMasterHelper.read(_input);
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_listeMasters",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireReferentielOperations _self = (CyelPostLicence.GestionnaireReferentielOperations) _so.servant;
                try
                {
                    return _self.listeMasters();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for listeLicences attribute
     * @return the attribute value
     */
    public CyelPostLicence.Licence[] listeLicences()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_listeLicences",true);
                    _input = this._invoke(_output);
                    return CyelPostLicence.ListeLicencesHelper.read(_input);
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_listeLicences",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireReferentielOperations _self = (CyelPostLicence.GestionnaireReferentielOperations) _so.servant;
                try
                {
                    return _self.listeLicences();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
