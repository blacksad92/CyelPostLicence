package CyelPostLicence;

/**
 * Struct definition : Note
 * 
 * @author OpenORB Compiler
*/
public final class Note implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member INE
     */
    public int INE;

    /**
     * Struct member semestre
     */
    public int semestre;

    /**
     * Struct member numSemestre
     */
    public int numSemestre;

    /**
     * Struct member moyenne
     */
    public int moyenne;

    /**
     * Struct member obtention
     */
    public String obtention;

    /**
     * Struct member position
     */
    public String position;

    /**
     * Struct member licence
     */
    public CyelPostLicence.Licence licence;

    /**
     * Struct member numUniversite
     */
    public int numUniversite;

    /**
     * Default constructor
     */
    public Note()
    { }

    /**
     * Constructor with fields initialization
     * @param INE INE struct member
     * @param semestre semestre struct member
     * @param numSemestre numSemestre struct member
     * @param moyenne moyenne struct member
     * @param obtention obtention struct member
     * @param position position struct member
     * @param licence licence struct member
     * @param numUniversite numUniversite struct member
     */
    public Note(int INE, int semestre, int numSemestre, int moyenne, String obtention, String position, CyelPostLicence.Licence licence, int numUniversite)
    {
        this.INE = INE;
        this.semestre = semestre;
        this.numSemestre = numSemestre;
        this.moyenne = moyenne;
        this.obtention = obtention;
        this.position = position;
        this.licence = licence;
        this.numUniversite = numUniversite;
    }

}
