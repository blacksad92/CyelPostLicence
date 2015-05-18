package CyelPostLicence;

/**
 * Struct definition : Diplome
 * 
 * @author OpenORB Compiler
*/
public final class Diplome implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numDiplome
     */
    public int numDiplome;

    /**
     * Struct member nomDiplome
     */
    public String nomDiplome;

    /**
     * Default constructor
     */
    public Diplome()
    { }

    /**
     * Constructor with fields initialization
     * @param numDiplome numDiplome struct member
     * @param nomDiplome nomDiplome struct member
     */
    public Diplome(int numDiplome, String nomDiplome)
    {
        this.numDiplome = numDiplome;
        this.nomDiplome = nomDiplome;
    }

}
