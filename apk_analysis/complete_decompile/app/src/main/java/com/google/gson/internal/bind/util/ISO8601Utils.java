package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public class ISO8601Utils {

    /* renamed from: a */
    public static final TimeZone f15786a = TimeZone.getTimeZone("UTC");

    /* renamed from: a */
    public static boolean m4444a(String str, int i, char c) {
        if (i < str.length() && str.charAt(i) == c) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static void m4445b(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* renamed from: c */
    public static int m4446c(int i, int i2, String str) {
        int i3;
        int i4;
        if (i >= 0 && i2 <= str.length() && i <= i2) {
            if (i < i2) {
                i4 = i + 1;
                int digit = Character.digit(str.charAt(i), 10);
                if (digit >= 0) {
                    i3 = -digit;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
                }
            } else {
                i3 = 0;
                i4 = i;
            }
            while (i4 < i2) {
                int i5 = i4 + 1;
                int digit2 = Character.digit(str.charAt(i4), 10);
                if (digit2 >= 0) {
                    i3 = (i3 * 10) - digit2;
                    i4 = i5;
                } else {
                    throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
                }
            }
            return -i3;
        }
        throw new NumberFormatException(str);
    }

    public static String format(Date date) {
        return format(date, false, f15786a);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0205  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Date parse(String str, ParsePosition parsePosition) {
        String str2;
        String message;
        int i;
        int i2;
        int i3;
        int i4;
        int length;
        char charAt;
        int length2;
        try {
            int index = parsePosition.getIndex();
            int i5 = index + 4;
            int m4446c = m4446c(index, i5, str);
            if (m4444a(str, i5, '-')) {
                i5 = index + 5;
            }
            int i6 = i5 + 2;
            int m4446c2 = m4446c(i5, i6, str);
            if (m4444a(str, i6, '-')) {
                i6 = i5 + 3;
            }
            int i7 = i6 + 2;
            int m4446c3 = m4446c(i6, i7, str);
            boolean m4444a = m4444a(str, i7, 'T');
            if (!m4444a && str.length() <= i7) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(m4446c, m4446c2 - 1, m4446c3);
                gregorianCalendar.setLenient(false);
                parsePosition.setIndex(i7);
                return gregorianCalendar.getTime();
            }
            if (m4444a) {
                int i8 = i6 + 5;
                int m4446c4 = m4446c(i6 + 3, i8, str);
                if (m4444a(str, i8, ':')) {
                    i8 = i6 + 6;
                }
                int i9 = i8 + 2;
                int m4446c5 = m4446c(i8, i9, str);
                if (m4444a(str, i9, ':')) {
                    i9 = i8 + 3;
                }
                if (str.length() > i9 && (charAt = str.charAt(i9)) != 'Z' && charAt != '+' && charAt != '-') {
                    int i10 = i9 + 2;
                    i4 = m4446c(i9, i10, str);
                    if (i4 > 59 && i4 < 63) {
                        i4 = 59;
                    }
                    if (m4444a(str, i10, '.')) {
                        int i11 = i9 + 3;
                        for (int i12 = i9 + 4; i12 < str.length(); i12++) {
                            char charAt2 = str.charAt(i12);
                            if (charAt2 >= '0' && charAt2 <= '9') {
                            }
                            length2 = i12;
                        }
                        length2 = str.length();
                        int min = Math.min(length2, i9 + 6);
                        i3 = m4446c(i11, min, str);
                        int i13 = min - i11;
                        if (i13 != 1) {
                            if (i13 == 2) {
                                i3 *= 10;
                            }
                        } else {
                            i3 *= 100;
                        }
                        i = m4446c4;
                        i7 = length2;
                        i2 = m4446c5;
                    } else {
                        i = m4446c4;
                        i7 = i10;
                        i2 = m4446c5;
                        i3 = 0;
                    }
                } else {
                    i2 = m4446c5;
                    i3 = 0;
                    i4 = 0;
                    i7 = i9;
                    i = m4446c4;
                }
            } else {
                i = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
            }
            if (str.length() > i7) {
                char charAt3 = str.charAt(i7);
                TimeZone timeZone = f15786a;
                if (charAt3 == 'Z') {
                    length = i7 + 1;
                } else {
                    if (charAt3 != '+' && charAt3 != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + charAt3 + "'");
                    }
                    String substring = str.substring(i7);
                    if (substring.length() < 5) {
                        substring = substring + "00";
                    }
                    length = i7 + substring.length();
                    if (!"+0000".equals(substring) && !"+00:00".equals(substring)) {
                        String str3 = "GMT" + substring;
                        timeZone = TimeZone.getTimeZone(str3);
                        String id = timeZone.getID();
                        if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone.getID());
                        }
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, m4446c);
                gregorianCalendar2.set(2, m4446c2 - 1);
                gregorianCalendar2.set(5, m4446c3);
                gregorianCalendar2.set(11, i);
                gregorianCalendar2.set(12, i2);
                gregorianCalendar2.set(13, i4);
                gregorianCalendar2.set(14, i3);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            throw new IllegalArgumentException("No time zone indicator");
        } catch (IllegalArgumentException e) {
            e = e;
            if (str == null) {
                str2 = null;
            } else {
                str2 = "\"" + str + Typography.quote;
            }
            message = e.getMessage();
            if (message != null || message.isEmpty()) {
                message = "(" + e.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e);
            throw parseException;
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            if (str == null) {
            }
            message = e.getMessage();
            if (message != null) {
            }
            message = "(" + e.getClass().getName() + ")";
            ParseException parseException2 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException2.initCause(e);
            throw parseException2;
        } catch (NumberFormatException e3) {
            e = e3;
            if (str == null) {
            }
            message = e.getMessage();
            if (message != null) {
            }
            message = "(" + e.getClass().getName() + ")";
            ParseException parseException22 = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException22.initCause(e);
            throw parseException22;
        }
    }

    public static String format(Date date, boolean z) {
        return format(date, z, f15786a);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        m4445b(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        m4445b(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        m4445b(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        m4445b(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        m4445b(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        m4445b(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            m4445b(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            sb.append(offset >= 0 ? '+' : '-');
            m4445b(sb, abs, 2);
            sb.append(':');
            m4445b(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
