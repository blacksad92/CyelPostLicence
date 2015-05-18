package CyelPostLicence;

/**
 * Struct definition : Voeu
 * 
 * @author OpenORB Compiler
*/
public final class Voeu implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numVoeu
     */
    public int numVoeu;

    /**
     * Struct member universite
     */
    public CyelPostLicence.Universite universite;

    /**
     * Struct member master
     */
    public CyelPostLicence.Master master;

    /**
     * Struct member ordre
     */
    public CyelPostLicence.EnumOrdre ordre;

    /**
     * Struct member etatCandidature
     */
    public CyelPostLicence.EtatCandidature etatCandidature;

    /**
     * Struct member reponse
     */
    public CyelPostLicence.EnumReponse reponse;

    /**
     * Struct member numLicence
     */
    public int numLicence;

    /**
     * Default constructor
     */
    public Voeu()
    { }

    /**
     * Constructor with fields initialization
     * @param numVoeu numVoeu struct member
     * @param universite universite struct member
     * @param master master struct member
     * @param ordre ordre struct member
     * @param etatCandidature etatCandidature struct member
     * @param reponse reponse struct member
     * @param numLicence numLicence struct member
     */
    public Voeu(int numVoeu, CyelPostLicence.Universite universite, CyelPostLicence.Master master, CyelPostLicence.EnumOrdre ordre, CyelPostLicence.EtatCandidature etatCandidature, CyelPostLicence.EnumReponse reponse, int numLicence)
    {
        this.numVoeu = numVoeu;
        this.universite = universite;
        this.master = master;
        this.ordre = ordre;
        this.etatCandidature = etatCandidature;
        this.reponse = reponse;
        this.numLicence = numLicence;
    }

}
