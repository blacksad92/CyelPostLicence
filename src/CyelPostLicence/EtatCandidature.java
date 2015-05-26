package CyelPostLicence;

/**
 * Enum definition : EtatCandidature
 *
 * @author OpenORB Compiler
*/
public final class EtatCandidature implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member valide value 
     */
    public static final int _valide = 0;

    /**
     * Enum member valide
     */
    public static final EtatCandidature valide = new EtatCandidature(_valide);

    /**
     * Enum member nonValide value 
     */
    public static final int _nonValide = 1;

    /**
     * Enum member nonValide
     */
    public static final EtatCandidature nonValide = new EtatCandidature(_nonValide);

    /**
     * Enum member refusee value 
     */
    public static final int _refusee = 2;

    /**
     * Enum member refusee
     */
    public static final EtatCandidature refusee = new EtatCandidature(_refusee);

    /**
     * Enum member acceptee value 
     */
    public static final int _acceptee = 3;

    /**
     * Enum member acceptee
     */
    public static final EtatCandidature acceptee = new EtatCandidature(_acceptee);

    /**
     * Enum member listeAttente value 
     */
    public static final int _listeAttente = 4;

    /**
     * Enum member listeAttente
     */
    public static final EtatCandidature listeAttente = new EtatCandidature(_listeAttente);

    /**
     * Enum member vide value 
     */
    public static final int _vide = 5;

    /**
     * Enum member vide
     */
    public static final EtatCandidature vide = new EtatCandidature(_vide);

    /**
     * Internal member value 
     */
    private final int _EtatCandidature_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    public EtatCandidature( final int value )
    {
        _EtatCandidature_value = value;
    }

    /**
     * Maintains singleton property for serialized enums.
     * Issue 4271: IDL/Java issue, Mapping for IDL enum.
     */
    public java.lang.Object readResolve() throws java.io.ObjectStreamException
    {
        return from_int( value() );
    }

    /**
     * Return the internal member value
     * @return the member value
     */
    public int value()
    {
        return _EtatCandidature_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static EtatCandidature from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return valide;
        case 1 :
            return nonValide;
        case 2 :
            return refusee;
        case 3 :
            return acceptee;
        case 4 :
            return listeAttente;
        case 5 :
            return vide;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_EtatCandidature_value)
        {
        case 0 :
            return "valide";
        case 1 :
            return "nonValide";
        case 2 :
            return "refusee";
        case 3 :
            return "acceptee";
        case 4 :
            return "listeAttente";
        case 5 :
            return "vide";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
