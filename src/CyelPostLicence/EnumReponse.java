package CyelPostLicence;

/**
 * Enum definition : EnumReponse
 *
 * @author OpenORB Compiler
*/
public final class EnumReponse implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member oui value 
     */
    public static final int _oui = 0;

    /**
     * Enum member oui
     */
    public static final EnumReponse oui = new EnumReponse(_oui);

    /**
     * Enum member ouiMais value 
     */
    public static final int _ouiMais = 1;

    /**
     * Enum member ouiMais
     */
    public static final EnumReponse ouiMais = new EnumReponse(_ouiMais);

    /**
     * Enum member non value 
     */
    public static final int _non = 2;

    /**
     * Enum member non
     */
    public static final EnumReponse non = new EnumReponse(_non);

    /**
     * Enum member nonMais value 
     */
    public static final int _nonMais = 3;

    /**
     * Enum member nonMais
     */
    public static final EnumReponse nonMais = new EnumReponse(_nonMais);

    /**
     * Enum member vide value 
     */
    public static final int _vide = 4;

    /**
     * Enum member vide
     */
    public static final EnumReponse vide = new EnumReponse(_vide);

    /**
     * Internal member value 
     */
    private final int _EnumReponse_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private EnumReponse( final int value )
    {
        _EnumReponse_value = value;
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
        return _EnumReponse_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static EnumReponse from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return oui;
        case 1 :
            return ouiMais;
        case 2 :
            return non;
        case 3 :
            return nonMais;
        case 4 :
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
        switch (_EnumReponse_value)
        {
        case 0 :
            return "oui";
        case 1 :
            return "ouiMais";
        case 2 :
            return "non";
        case 3 :
            return "nonMais";
        case 4 :
            return "vide";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
