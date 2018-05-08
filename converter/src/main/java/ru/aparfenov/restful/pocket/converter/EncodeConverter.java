package ru.aparfenov.restful.pocket.converter;

/**
 * Created by ArtemParfenov on 08.04.2018.
 */
public class EncodeConverter {
    public static String convert(String convertFrom, String srcEncodeName, String targetCodeName) {

        return "Encode conveter result:" + convertFrom;
    }

    /**@param isSpaceASpace - space is not converted into unicode and is just a space*/
    public static String convertToUnicode(String stringToConvert, boolean isSpaceASpace) {
        StringBuilder charInUnicode = new StringBuilder();
        for (int index = 0; index < stringToConvert.length(); index++) {
            if (isSpaceASpace && (' ' == stringToConvert.charAt(index))) {
                charInUnicode.append(" ");
            } else {
                // Convert the integer to a hexadecimal code.
                String hexCode = Integer.toHexString(stringToConvert.codePointAt(index)).toUpperCase();
                // but the it must be a four number value.
                String hexCodeWithAllLeadingZeros = "0000" + hexCode;
                charInUnicode.append("\\u");
                charInUnicode.append(hexCodeWithAllLeadingZeros.substring(hexCodeWithAllLeadingZeros.length() - 4));
            }
        }
        return charInUnicode.toString();
    }
}
