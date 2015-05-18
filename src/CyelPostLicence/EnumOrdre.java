package CyelPostLicence;

/**
 * Enum definition : EnumOrdre
 *
 * @author OpenORB Compiler
*/
public final class EnumOrdre implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member un value 
     */
    public static final int _un = 0;

    /**
     * Enum member un
     */
    public static final EnumOrdre un = new EnumOrdre(_un);

    /**
     * Enum member deux value 
     */
    public static final int _deux = 1;

    /**
     * Enum member deux
     */
    public static final EnumOrdre deux = new EnumOrdre(_deux);

    /**
     * Enum member trois value 
     */
    public static final int _trois = 2;

    /**
     * Enum member trois
     */
    public static final EnumOrdre trois = new EnumOrdre(_trois);

    /**
     * Enum member quatre value 
     */
    public static final int _quatre = 3;

    /**
     * Enum member quatre
     */
    public static final EnumOrdre quatre = new EnumOrdre(_quatre);

    /**
     * Enum member cinq value 
     */
    public static final int _cinq = 4;

    /**
     * Enum member cinq
     */
    public static final EnumOrdre cinq = new EnumOrdre(_cinq);

    /**
     * Enum member vide value 
     */
    public static final int _vide = 5;

    /**
     * Enum member vide
     */
    public static final EnumOrdre vide = new EnumOrdre(_vide);

    /**
     * Internal member value 
     */
    private final int _EnumOrdre_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    public EnumOrdre( final int value )
    {
        _EnumOrdre_value = value;
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
        return _EnumOrdre_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static EnumOrdre from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return un;
        case 1 :
            return deux;
        case 2 :
            return trois;
        case 3 :
            return quatre;
        case 4 :
            return cinq;
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
        switch (_EnumOrdre_value)
        {
        case 0 :
            return "un";
        case 1 :
            return "deux";
        case 2 :
            return "trois";
        case 3 :
            return "quatre";
        case 4 :
            return "cinq";
        case 5 :
            return "vide";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
