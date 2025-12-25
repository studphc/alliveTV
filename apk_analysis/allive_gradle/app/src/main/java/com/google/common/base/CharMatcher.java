package com.google.common.base;

import androidx.collection.ScatterMapKt;
import com.google.common.annotations.GwtCompatible;
import java.util.BitSet;
import p000.C0527ao;
import p000.C0564bo;
import p000.C0600co;
import p000.C1165eo;
import p000.C1202fo;
import p000.C1239go;
import p000.C1276ho;
import p000.C1313io;
import p000.C1398ko;
import p000.C1518lo;
import p000.C1555mo;
import p000.C1592no;
import p000.C1644oo;
import p000.C1694po;
import p000.C1731qo;
import p000.C1768ro;
import p000.C1805so;
import p000.C1916vo;
import p000.C1990xo;
import p000.C2027yo;
import p000.dx0;
import p000.t42;
import p000.uk2;

@GwtCompatible(emulated = true)
/* loaded from: classes.dex */
public abstract class CharMatcher implements Predicate<Character> {
    /* renamed from: a */
    public static String m3757a(char c) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static CharMatcher any() {
        return C0600co.f8430b;
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        int length = charSequence.length();
        if (length != 0) {
            if (length != 1) {
                if (length != 2) {
                    return new C1165eo(charSequence);
                }
                return new C1398ko(charSequence.charAt(0), charSequence.charAt(1), 1);
            }
            return m3759is(charSequence.charAt(0));
        }
        return none();
    }

    public static CharMatcher ascii() {
        return C1202fo.f17350b;
    }

    public static CharMatcher breakingWhitespace() {
        return C1276ho.f18109a;
    }

    /* renamed from: c */
    public static CharMatcher m3758c(int i, BitSet bitSet, String str) {
        int i2;
        if (i != 0) {
            if (i != 1) {
                int i3 = 2;
                if (i != 2) {
                    int length = bitSet.length();
                    if (i <= 1023 && length > i * 64) {
                        int cardinality = bitSet.cardinality();
                        boolean z = bitSet.get(0);
                        if (cardinality != 1) {
                            i3 = Integer.highestOneBit(cardinality - 1) << 1;
                            while (i3 * 0.5d < cardinality) {
                                i3 <<= 1;
                            }
                        }
                        char[] cArr = new char[i3];
                        int i4 = i3 - 1;
                        int nextSetBit = bitSet.nextSetBit(0);
                        long j = 0;
                        while (true) {
                            long j2 = j;
                            if (nextSetBit != -1) {
                                j = (1 << nextSetBit) | j2;
                                int rotateLeft = Integer.rotateLeft(ScatterMapKt.MurmurHashC1 * nextSetBit, 15) * 461845907;
                                while (true) {
                                    i2 = rotateLeft & i4;
                                    if (cArr[i2] == 0) {
                                        break;
                                    }
                                    rotateLeft = i2 + 1;
                                }
                                cArr[i2] = (char) nextSetBit;
                                nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
                            } else {
                                return new uk2(cArr, j2, z, str);
                            }
                        }
                    } else {
                        return new C1239go(bitSet, str);
                    }
                } else {
                    char nextSetBit2 = (char) bitSet.nextSetBit(0);
                    return new C1398ko(nextSetBit2, (char) bitSet.nextSetBit(nextSetBit2 + 1), 1);
                }
            } else {
                return m3759is((char) bitSet.nextSetBit(0));
            }
        } else {
            return none();
        }
    }

    @Deprecated
    public static CharMatcher digit() {
        return C1313io.f18479d;
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        if (predicate instanceof CharMatcher) {
            return (CharMatcher) predicate;
        }
        return new C1165eo(predicate);
    }

    public static CharMatcher inRange(char c, char c2) {
        return new C1398ko(c, c2, 0);
    }

    @Deprecated
    public static CharMatcher invisible() {
        return C1518lo.f22592d;
    }

    /* renamed from: is */
    public static CharMatcher m3759is(char c) {
        return new C1555mo(c, 0);
    }

    public static CharMatcher isNot(char c) {
        return new C1555mo(c, 1);
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return C1592no.f23428a;
    }

    public static CharMatcher javaIsoControl() {
        return C1644oo.f24844b;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return C1694po.f25237a;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return C1731qo.f25702a;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return C1768ro.f26077a;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return C1805so.f26504a;
    }

    public static CharMatcher none() {
        return C1916vo.f27895b;
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return C1990xo.f28665d;
    }

    public static CharMatcher whitespace() {
        return C2027yo.f29048c;
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new C0564bo(this, charMatcher, 0);
    }

    /* renamed from: b */
    public final String m3760b(CharSequence charSequence, int i, int i2, char c, StringBuilder sb, boolean z) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (matches(charAt)) {
                if (!z) {
                    sb.append(c);
                    z = true;
                }
            } else {
                sb.append(charAt);
                z = false;
            }
            i++;
        }
        return sb.toString();
    }

    public String collapseFrom(CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (matches(charAt)) {
                if (charAt == c && (i == length - 1 || !matches(charSequence.charAt(i + 1)))) {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i);
                    sb.append(c);
                    return m3760b(charSequence, i + 1, length, c, sb, true);
                }
            }
            i++;
        }
        return charSequence.toString();
    }

    public int countIn(CharSequence charSequence) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (matches(charSequence.charAt(i2))) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: d */
    public void mo2122d(BitSet bitSet) {
        for (int i = 65535; i >= 0; i--) {
            if (matches((char) i)) {
                bitSet.set(i);
            }
        }
    }

    public int indexIn(CharSequence charSequence) {
        return indexIn(charSequence, 0);
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean matches(char c);

    public boolean matchesAllOf(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        if (indexIn(charSequence) == -1) {
            return true;
        }
        return false;
    }

    public CharMatcher negate() {
        return new C1165eo(this);
    }

    /* renamed from: or */
    public CharMatcher mo2264or(CharMatcher charMatcher) {
        return new C0564bo(this, charMatcher, 1);
    }

    public CharMatcher precomputed() {
        String concat;
        dx0 dx0Var = t42.f26692a;
        BitSet bitSet = new BitSet();
        mo2122d(bitSet);
        int cardinality = bitSet.cardinality();
        if (cardinality * 2 <= 65536) {
            return m3758c(cardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i = 65536 - cardinality;
        String charMatcher = toString();
        if (charMatcher.endsWith(".negate()")) {
            concat = charMatcher.substring(0, charMatcher.length() - 9);
        } else {
            concat = charMatcher.concat(".negate()");
        }
        return new C0527ao(m3758c(i, bitSet, concat), charMatcher);
    }

    public String removeFrom(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        int i = 1;
        while (true) {
            indexIn++;
            while (indexIn != charArray.length) {
                if (matches(charArray[indexIn])) {
                    break;
                }
                charArray[indexIn - i] = charArray[indexIn];
                indexIn++;
            }
            return new String(charArray, 0, indexIn - i);
            i++;
        }
    }

    public String replaceFrom(CharSequence charSequence, char c) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        charArray[indexIn] = c;
        while (true) {
            indexIn++;
            if (indexIn < charArray.length) {
                if (matches(charArray[indexIn])) {
                    charArray[indexIn] = c;
                }
            } else {
                return new String(charArray);
            }
        }
    }

    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    public String toString() {
        return super.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = length - 1;
        int i2 = 0;
        while (i2 < length && matches(charSequence.charAt(i2))) {
            i2++;
        }
        int i3 = i;
        while (i3 > i2 && matches(charSequence.charAt(i3))) {
            i3--;
        }
        if (i2 == 0 && i3 == i) {
            return collapseFrom(charSequence, c);
        }
        int i4 = i3 + 1;
        return m3760b(charSequence, i2, i4, c, new StringBuilder(i4 - i2), false);
    }

    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && matches(charSequence.charAt(i))) {
            i++;
        }
        int i2 = length - 1;
        while (i2 > i && matches(charSequence.charAt(i2))) {
            i2--;
        }
        return charSequence.subSequence(i, i2 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!matches(charSequence.charAt(i))) {
                return charSequence.subSequence(i, length).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
    }

    public int indexIn(CharSequence charSequence, int i) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i, length);
        while (i < length) {
            if (matches(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        int i = 0;
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        String charSequence3 = charSequence.toString();
        int indexIn = indexIn(charSequence3);
        if (indexIn == -1) {
            return charSequence3;
        }
        int length2 = charSequence3.length();
        StringBuilder sb = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append((CharSequence) charSequence3, i, indexIn);
            sb.append(charSequence2);
            i = indexIn + 1;
            indexIn = indexIn(charSequence3, i);
        } while (indexIn != -1);
        sb.append((CharSequence) charSequence3, i, length2);
        return sb.toString();
    }
}
