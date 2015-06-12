package CyelPostLicence;

/**
 * Interface definition : GestionnaireCandidatures
 * 
 * @author OpenORB Compiler
 */
public class _GestionnaireCandidaturesStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionnaireCandidatures
{
    static final String[] _ids_list =
    {
        "IDL:CyelPostLicence/GestionnaireCandidatures:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = CyelPostLicence.GestionnaireCandidaturesOperations.class;

    /**
     * Read accessor for universite attribute
     * @return the attribute value
     */
    public CyelPostLicence.Universite universite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_universite",true);
                    _input = this._invoke(_output);
                    return CyelPostLicence.UniversiteHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_universite",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireCandidaturesOperations _self = (CyelPostLicence.GestionnaireCandidaturesOperations) _so.servant;
                try
                {
                    return _self.universite();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Write accessor for universite attribute
     * @param value the attribute value
     */
    public void universite(CyelPostLicence.Universite value)
    {
        while(true)
        {
            if (!this._is_local())
            {
                    org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_set_universite",true);
                    CyelPostLicence.UniversiteHelper.write(_output,value);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_set_universite",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireCandidaturesOperations _self = (CyelPostLicence.GestionnaireCandidaturesOperations) _so.servant;
                try
                {
                    _self.universite(value);
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
     * Read accessor for listeMaster attribute
     * @return the attribute value
     */
    public CyelPostLicence.Master[] listeMaster()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_listeMaster",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_listeMaster",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireCandidaturesOperations _self = (CyelPostLicence.GestionnaireCandidaturesOperations) _so.servant;
                try
                {
                    return _self.listeMaster();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation recupererListeNotes
     */
    public CyelPostLicence.Note[] recupererListeNotes(int INE, boolean externe)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererListeNotes",true);
                    _output.write_long(INE);
                    _output.write_boolean(externe);
                    _input = this._invoke(_output);
                    CyelPostLicence.Note[] _arg_ret = CyelPostLicence.ListeNotesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererListeNotes",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireCandidaturesOperations _self = (CyelPostLicence.GestionnaireCandidaturesOperations) _so.servant;
                try
                {
                    return _self.recupererListeNotes( INE,  externe);
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
                CyelPostLicence.GestionnaireCandidaturesOperations _self = (CyelPostLicence.GestionnaireCandidaturesOperations) _so.servant;
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
     * Operation validerCandidature
     */
    public CyelPostLicence.EtatCandidature validerCandidature(int numMaster, int numLicence)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("validerCandidature",true);
                    _output.write_long(numMaster);
                    _output.write_long(numLicence);
                    _input = this._invoke(_output);
                    CyelPostLicence.EtatCandidature _arg_ret = CyelPostLicence.EtatCandidatureHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("validerCandidature",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireCandidaturesOperations _self = (CyelPostLicence.GestionnaireCandidaturesOperations) _so.servant;
                try
                {
                    return _self.validerCandidature( numMaster,  numLicence);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerCandidatures
     */
    public void enregistrerCandidatures(CyelPostLicence.Etudiant[] listeCandidatures, int numMaster)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerCandidatures",true);
                    CyelPostLicence.ListeCandidaturesHelper.write(_output,listeCandidatures);
                    _output.write_long(numMaster);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerCandidatures",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireCandidaturesOperations _self = (CyelPostLicence.GestionnaireCandidaturesOperations) _so.servant;
                try
                {
                    _self.enregistrerCandidatures( listeCandidatures,  numMaster);
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
     * Operation consulterCandidatures
     */
    public CyelPostLicence.Etudiant[] consulterCandidatures(int numMaster, int numUniversite)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterCandidatures",true);
                    _output.write_long(numMaster);
                    _output.write_long(numUniversite);
                    _input = this._invoke(_output);
                    CyelPostLicence.Etudiant[] _arg_ret = CyelPostLicence.ListeCandidaturesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterCandidatures",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireCandidaturesOperations _self = (CyelPostLicence.GestionnaireCandidaturesOperations) _so.servant;
                try
                {
                    return _self.consulterCandidatures( numMaster,  numUniversite);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerClassement
     */
    public void enregistrerClassement(int INE, int classement)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerClassement",true);
                    _output.write_long(INE);
                    _output.write_long(classement);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerClassement",_opsClass);
                if (_so == null)
                   continue;
                CyelPostLicence.GestionnaireCandidaturesOperations _self = (CyelPostLicence.GestionnaireCandidaturesOperations) _so.servant;
                try
                {
                    _self.enregistrerClassement( INE,  classement);
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
