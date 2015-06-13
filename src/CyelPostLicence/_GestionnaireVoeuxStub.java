package CyelPostLicence;

/**
 * Interface definition : GestionnaireVoeux
 * 
 * @author OpenORB Compiler
 */
public class _GestionnaireVoeuxStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionnaireVoeux
{
    static final String[] _ids_list =
    {
        "IDL:CyelPostLicence/GestionnaireVoeux:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = CyelPostLicence.GestionnaireVoeuxOperations.class;

    /**
     * Read accessor for academie attribute
     * @return the attribute value
     */
    public CyelPostLicence.Academie academie()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_academie",true);
                    _input = this._invoke(_output);
                    return CyelPostLicence.AcademieHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_academie",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    return _self.academie();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Write accessor for academie attribute
     * @param value the attribute value
     */
    public void academie(CyelPostLicence.Academie value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_academie",true);
                    CyelPostLicence.AcademieHelper.write(_output,value);
                    _input = this._invoke(_output);
                    return;
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_academie",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    _self.academie(value);
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
     * Read accessor for periode attribute
     * @return the attribute value
     */
    public int periode()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_periode",true);
                    _input = this._invoke(_output);
                    return _input.read_long();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_periode",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    return _self.periode();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Write accessor for periode attribute
     * @param value the attribute value
     */
    public void periode(int value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_periode",true);
                    _output.write_long(value);
                    _input = this._invoke(_output);
                    return;
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_periode",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    _self.periode(value);
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
     * Read accessor for listeUniversite attribute
     * @return the attribute value
     */
    public CyelPostLicence.Universite[] listeUniversite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_listeUniversite",true);
                    _input = this._invoke(_output);
                    return CyelPostLicence.ListeUniversitesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_listeUniversite",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    return _self.listeUniversite();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation consulterAcreditations
     */
    public CyelPostLicence.Universite[] consulterAcreditations(int numMaster, boolean externe)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterAcreditations",true);
                    _output.write_long(numMaster);
                    _output.write_boolean(externe);
                    _input = this._invoke(_output);
                    CyelPostLicence.Universite[] _arg_ret = CyelPostLicence.ListeUniversitesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterAcreditations",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    return _self.consulterAcreditations( numMaster,  externe);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerVoeux
     */
    public void enregistrerVoeux(CyelPostLicence.Etudiant etudiant, CyelPostLicence.Voeu[] listeVoeux)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerVoeux",true);
                    CyelPostLicence.EtudiantHelper.write(_output,etudiant);
                    CyelPostLicence.ListeVoeuxHelper.write(_output,listeVoeux);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerVoeux",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    _self.enregistrerVoeux( etudiant,  listeVoeux);
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
     * Operation repondreVoeu
     */
    public void repondreVoeu(int INE, CyelPostLicence.Voeu voeu)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("repondreVoeu",true);
                    _output.write_long(INE);
                    CyelPostLicence.VoeuHelper.write(_output,voeu);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("repondreVoeu",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    _self.repondreVoeu( INE,  voeu);
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
     * Operation consulterVoeux
     */
    public CyelPostLicence.Voeu[] consulterVoeux(int INE, boolean externe)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterVoeux",true);
                    _output.write_long(INE);
                    _output.write_boolean(externe);
                    _input = this._invoke(_output);
                    CyelPostLicence.Voeu[] _arg_ret = CyelPostLicence.ListeVoeuxHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterVoeux",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    return _self.consulterVoeux( INE,  externe);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation cloturerPeriode
     */
    public void cloturerPeriode()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("cloturerPeriode",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("cloturerPeriode",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    _self.cloturerPeriode();
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
     * Operation RAZPeriode
     */
    public void RAZPeriode()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("RAZPeriode",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("RAZPeriode",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    _self.RAZPeriode();
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
     * Operation recupererListeCandidatures
     */
    public CyelPostLicence.Etudiant[] recupererListeCandidatures(int numMaster, int numUniversite)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererListeCandidatures",true);
                    _output.write_long(numMaster);
                    _output.write_long(numUniversite);
                    _input = this._invoke(_output);
                    CyelPostLicence.Etudiant[] _arg_ret = CyelPostLicence.ListeEtudiantsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererListeCandidatures",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    return _self.recupererListeCandidatures( numMaster,  numUniversite);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerDecision
     */
    public void enregistrerDecision(CyelPostLicence.Decision decision)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerDecision",true);
                    CyelPostLicence.DecisionHelper.write(_output,decision);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerDecision",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireVoeuxOperations _self = (CyelPostLicence.GestionnaireVoeuxOperations) _so.servant;
                try
                {
                    _self.enregistrerDecision( decision);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
