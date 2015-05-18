package CyelPostLicence;

/**
 * Struct definition : Academie
 * 
 * @author OpenORB Compiler
*/
public final class Academie implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numAcademie
     */
    public int numAcademie;

    /**
     * Struct member nomAcademie
     */
    public String nomAcademie;

    /**
     * Default constructor
     */
    public Academie()
    { }

    /**
     * Constructor with fields initialization
     * @param numAcademie numAcademie struct member
     * @param nomAcademie nomAcademie struct member
     */
    public Academie(int numAcademie, String nomAcademie)
    {
        this.numAcademie = numAcademie;
        this.nomAcademie = nomAcademie;
    }

}
