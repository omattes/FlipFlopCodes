package dev.ossenbeck.puzzle03;

import dev.ossenbeck.common.Util;

public enum BushLabel {
    RED(5),
    GREEN(2),
    BLUE(4),
    SPECIAL(10);

    private final int pointers;

    BushLabel(int pointers) {
        this.pointers = pointers;
    }

    public int pointers() {
        return pointers;
    }

    public static BushLabel fromRgb(String rgb) {
        var rgbValues = Util.parseNumbersAsArray(rgb);
        if (rgbValues[0] == rgbValues[1] || rgbValues[1] == rgbValues[2] || rgbValues[0] == rgbValues[2]) {
            return SPECIAL;
        }
        var max = rgbValues[0] > rgbValues[1] && rgbValues[0] > rgbValues[2] ? 0
                : rgbValues[1] > rgbValues[2] ? 1 : 2;
        return values()[max];
    }
}
