package CyelPostLicence;

/**
 * Interface definition : GestionnaireAcces
 * 
 * @author OpenORB Compiler
 */
public class _GestionnaireAccesStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionnaireAcces
{
    static final String[] _ids_list =
    {
        "IDL:CyelPostLicence/GestionnaireAcces:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = CyelPostLicence.GestionnaireAccesOperations.class;

    /**
     * Read accessor for listeGestionnairesVoeux attribute
     * @return the attribute value
     */
    public CyelPostLicence.GestionnaireVoeux[] listeGestionnairesVoeux()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_listeGestionnairesVoeux",true);
                    _input = this._invoke(_output);
                    return CyelPostLicence.ListeGestionnairesVoeuxHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_listeGestionnairesVoeux",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireAccesOperations _self = (CyelPostLicence.GestionnaireAccesOperations) _so.servant;
                try
                {
                    return _self.listeGestionnairesVoeux();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for ListeGestionnairesCandidatures attribute
     * @return the attribute value
     */
    public CyelPostLicence.GestionnaireCandidatures[] ListeGestionnairesCandidatures()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_ListeGestionnairesCandidatures",true);
                    _input = this._invoke(_output);
                    return CyelPostLicence.ListeGestionnairesCandidaturesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_ListeGestionnairesCandidatures",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireAccesOperations _self = (CyelPostLicence.GestionnaireAccesOperations) _so.servant;
                try
                {
                    return _self.ListeGestionnairesCandidatures();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation identification
     */
    public CyelPostLicence.Etudiant identification(int INE, CyelPostLicence.Academie academie)
        throws CyelPostLicence.EtudiantInconnu, CyelPostLicence.AcademieIncorrecte
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("identification",true);
                    _output.write_long(INE);
                    CyelPostLicence.AcademieHelper.write(_output,academie);
                    _input = this._invoke(_output);
                    CyelPostLicence.Etudiant _arg_ret = CyelPostLicence.EtudiantHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(CyelPostLicence.EtudiantInconnuHelper.id()))
                    {
                        throw CyelPostLicence.EtudiantInconnuHelper.read(_exception.getInputStream());
                    }

                    if (_exception_id.equals(CyelPostLicence.AcademieIncorrecteHelper.id()))
                    {
                        throw CyelPostLicence.AcademieIncorrecteHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("identification",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireAccesOperations _self = (CyelPostLicence.GestionnaireAccesOperations) _so.servant;
                try
                {
                    return _self.identification( INE,  academie);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation obtenirGestionnaireVoeux
     */
    public CyelPostLicence.GestionnaireVoeux obtenirGestionnaireVoeux(int numAcademie)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("obtenirGestionnaireVoeux",true);
                    _output.write_long(numAcademie);
                    _input = this._invoke(_output);
                    CyelPostLicence.GestionnaireVoeux _arg_ret = CyelPostLicence.GestionnaireVoeuxHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("obtenirGestionnaireVoeux",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireAccesOperations _self = (CyelPostLicence.GestionnaireAccesOperations) _so.servant;
                try
                {
                    return _self.obtenirGestionnaireVoeux( numAcademie);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation obtenirGestionnaireCandidatures
     */
    public CyelPostLicence.GestionnaireCandidatures obtenirGestionnaireCandidatures(int numUniversite)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("obtenirGestionnaireCandidatures",true);
                    _output.write_long(numUniversite);
                    _input = this._invoke(_output);
                    CyelPostLicence.GestionnaireCandidatures _arg_ret = CyelPostLicence.GestionnaireCandidaturesHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("obtenirGestionnaireCandidatures",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireAccesOperations _self = (CyelPostLicence.GestionnaireAccesOperations) _so.servant;
                try
                {
                    return _self.obtenirGestionnaireCandidatures( numUniversite);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation identificationUniv
     */
    public CyelPostLicence.GestionnaireVoeux identificationUniv(String login, String password, int numAcademie)
        throws CyelPostLicence.ResponsableInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("identificationUniv",true);
                    _output.write_string(login);
                    _output.write_string(password);
                    _output.write_long(numAcademie);
                    _input = this._invoke(_output);
                    CyelPostLicence.GestionnaireVoeux _arg_ret = CyelPostLicence.GestionnaireVoeuxHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(CyelPostLicence.ResponsableInconnuHelper.id()))
                    {
                        throw CyelPostLicence.ResponsableInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("identificationUniv",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireAccesOperations _self = (CyelPostLicence.GestionnaireAccesOperations) _so.servant;
                try
                {
                    return _self.identificationUniv( login,  password,  numAcademie);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation inscriptionGestionnaireVoeux
     */
    public void inscriptionGestionnaireVoeux(CyelPostLicence.GestionnaireVoeux gestVoeux)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionGestionnaireVoeux",true);
                    CyelPostLicence.GestionnaireVoeuxHelper.write(_output,gestVoeux);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionGestionnaireVoeux",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireAccesOperations _self = (CyelPostLicence.GestionnaireAccesOperations) _so.servant;
                try
                {
                    _self.inscriptionGestionnaireVoeux( gestVoeux);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation inscriptionGestionnaireCandidatures
     */
    public void inscriptionGestionnaireCandidatures(CyelPostLicence.GestionnaireCandidatures gestCandidatures)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("inscriptionGestionnaireCandidatures",true);
                    CyelPostLicence.GestionnaireCandidaturesHelper.write(_output,gestCandidatures);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("inscriptionGestionnaireCandidatures",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireAccesOperations _self = (CyelPostLicence.GestionnaireAccesOperations) _so.servant;
                try
                {
                    _self.inscriptionGestionnaireCandidatures( gestCandidatures);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation obtenirEtudiant
     */
    public CyelPostLicence.Etudiant obtenirEtudiant(int INE)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("obtenirEtudiant",true);
                    _output.write_long(INE);
                    _input = this._invoke(_output);
                    CyelPostLicence.Etudiant _arg_ret = CyelPostLicence.EtudiantHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("obtenirEtudiant",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireAccesOperations _self = (CyelPostLicence.GestionnaireAccesOperations) _so.servant;
                try
                {
                    return _self.obtenirEtudiant( INE);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
