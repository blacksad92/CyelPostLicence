package CyelPostLicence;

/**
 * Struct definition : Universite
 * 
 * @author OpenORB Compiler
*/
public final class Universite implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numUniv
     */
    public int numUniv;

    /**
     * Struct member nomUniv
     */
    public String nomUniv;

    /**
     * Struct member academie
     */
    public CyelPostLicence.Academie academie;

    /**
     * Default constructor
     */
    public Universite()
    { }

    /**
     * Constructor with fields initialization
     * @param numUniv numUniv struct member
     * @param nomUniv nomUniv struct member
     * @param academie academie struct member
     */
    public Universite(int numUniv, String nomUniv, CyelPostLicence.Academie academie)
    {
        this.numUniv = numUniv;
        this.nomUniv = nomUniv;
        this.academie = academie;
    }

}
