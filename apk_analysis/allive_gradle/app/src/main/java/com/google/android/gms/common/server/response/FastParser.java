package com.google.android.gms.common.server.response;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.C0643C;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.text.Typography;
import okio.internal._BufferKt;
import p000.ye0;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class FastParser<T extends FastJsonResponse> {

    /* renamed from: g */
    public static final char[] f13580g = {'u', 'l', 'l'};

    /* renamed from: h */
    public static final char[] f13581h = {'r', 'u', 'e'};

    /* renamed from: i */
    public static final char[] f13582i = {'r', 'u', 'e', Typography.quote};

    /* renamed from: j */
    public static final char[] f13583j = {'a', 'l', 's', 'e'};

    /* renamed from: k */
    public static final char[] f13584k = {'a', 'l', 's', 'e', Typography.quote};

    /* renamed from: l */
    public static final char[] f13585l = {'\n'};

    /* renamed from: m */
    public static final C0762a f13586m = new Object();

    /* renamed from: n */
    public static final C0763b f13587n = new Object();

    /* renamed from: o */
    public static final C0764c f13588o = new Object();

    /* renamed from: p */
    public static final C0765d f13589p = new Object();

    /* renamed from: q */
    public static final C0766e f13590q = new Object();

    /* renamed from: r */
    public static final C0767f f13591r = new Object();

    /* renamed from: s */
    public static final C0768g f13592s = new Object();

    /* renamed from: t */
    public static final C0769h f13593t = new Object();

    /* renamed from: a */
    public final char[] f13594a = new char[1];

    /* renamed from: b */
    public final char[] f13595b = new char[32];

    /* renamed from: c */
    public final char[] f13596c = new char[1024];

    /* renamed from: d */
    public final StringBuilder f13597d = new StringBuilder(32);

    /* renamed from: e */
    public final StringBuilder f13598e = new StringBuilder(1024);

    /* renamed from: f */
    public final Stack f13599f = new Stack();

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class ParseException extends Exception {
        public ParseException(@NonNull String str) {
            super(str);
        }

        public ParseException(@NonNull String str, @NonNull Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(@NonNull Throwable th) {
            super(th);
        }
    }

    /* renamed from: a */
    public static final String m3180a(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z = false;
        boolean z2 = false;
        loop0: while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                int i = 0;
                while (i < read) {
                    char c = cArr[i];
                    if (!Character.isISOControl(c) || (cArr2 != null && cArr2[0] == c)) {
                        int i2 = i + 1;
                        if (c == '\"') {
                            if (!z) {
                                sb.append(cArr, 0, i);
                                bufferedReader.reset();
                                bufferedReader.skip(i2);
                                if (z2) {
                                    return JsonUtils.unescapeString(sb.toString());
                                }
                                return sb.toString();
                            }
                        } else if (c == '\\') {
                            z = !z;
                            z2 = true;
                            i = i2;
                        }
                        z = false;
                        i = i2;
                    }
                }
                sb.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        return r0[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:
    
        if (r5.read(r0) != (-1)) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (java.lang.Character.isWhitespace(r0[0]) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r5.read(r0) != (-1)) goto L14;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final char m3181b(BufferedReader bufferedReader) {
        char[] cArr = this.f13594a;
    }

    /* renamed from: c */
    public final int m3182c(BufferedReader bufferedReader) {
        int i;
        int i2;
        int i3;
        int i4;
        char[] cArr = this.f13596c;
        int m3183d = m3183d(bufferedReader, cArr);
        if (m3183d == 0) {
            return 0;
        }
        if (m3183d > 0) {
            char c = cArr[0];
            if (c == '-') {
                i = Integer.MIN_VALUE;
            } else {
                i = C0643C.RATE_UNSET_INT;
            }
            if (c == '-') {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 < m3183d) {
                i4 = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit >= 0) {
                    i3 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                i3 = 0;
                i4 = i2;
            }
            while (i4 < m3183d) {
                int i5 = i4 + 1;
                int digit2 = Character.digit(cArr[i4], 10);
                if (digit2 >= 0) {
                    if (i3 >= -214748364) {
                        int i6 = i3 * 10;
                        if (i6 >= i + digit2) {
                            i3 = i6 - digit2;
                            i4 = i5;
                        } else {
                            throw new ParseException("Number too large");
                        }
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            }
            if (i2 != 0) {
                if (i4 <= 1) {
                    throw new ParseException("No digits to parse");
                }
                return i3;
            }
            return -i3;
        }
        throw new ParseException("No number to parse");
    }

    /* renamed from: d */
    public final int m3183d(BufferedReader bufferedReader, char[] cArr) {
        int i;
        char m3181b = m3181b(bufferedReader);
        if (m3181b != 0) {
            if (m3181b != ',') {
                if (m3181b == 'n') {
                    m3191l(bufferedReader, f13580g);
                    return 0;
                }
                bufferedReader.mark(1024);
                if (m3181b == '\"') {
                    i = 0;
                    boolean z = false;
                    while (i < 1024 && bufferedReader.read(cArr, i, 1) != -1) {
                        char c = cArr[i];
                        if (!Character.isISOControl(c)) {
                            int i2 = i + 1;
                            if (c == '\"') {
                                if (!z) {
                                    bufferedReader.reset();
                                    bufferedReader.skip(i2);
                                    return i;
                                }
                            } else if (c == '\\') {
                                z = !z;
                                i = i2;
                            }
                            z = false;
                            i = i2;
                        } else {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                    }
                } else {
                    cArr[0] = m3181b;
                    i = 1;
                    while (i < 1024 && bufferedReader.read(cArr, i, 1) != -1) {
                        char c2 = cArr[i];
                        if (c2 != '}' && c2 != ',' && !Character.isWhitespace(c2) && cArr[i] != ']') {
                            i++;
                        } else {
                            bufferedReader.reset();
                            bufferedReader.skip(i - 1);
                            cArr[i] = 0;
                            return i;
                        }
                    }
                }
                if (i == 1024) {
                    throw new ParseException("Absurdly long value");
                }
                throw new ParseException("Unexpected EOF");
            }
            throw new ParseException("Missing value");
        }
        throw new ParseException("Unexpected EOF");
    }

    /* renamed from: e */
    public final long m3184e(BufferedReader bufferedReader) {
        long j;
        long j2;
        int i;
        char[] cArr = this.f13596c;
        int m3183d = m3183d(bufferedReader, cArr);
        if (m3183d == 0) {
            return 0L;
        }
        if (m3183d > 0) {
            int i2 = 0;
            char c = cArr[0];
            if (c == '-') {
                j = Long.MIN_VALUE;
            } else {
                j = C0643C.TIME_UNSET;
            }
            if (c == '-') {
                i2 = 1;
            }
            if (i2 < m3183d) {
                i = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit >= 0) {
                    j2 = -digit;
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            } else {
                j2 = 0;
                i = i2;
            }
            while (i < m3183d) {
                int i3 = i + 1;
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 >= 0) {
                    if (j2 >= _BufferKt.OVERFLOW_ZONE) {
                        long j3 = j2 * 10;
                        char[] cArr2 = cArr;
                        long j4 = digit2;
                        if (j3 >= j + j4) {
                            j2 = j3 - j4;
                            i = i3;
                            cArr = cArr2;
                        } else {
                            throw new ParseException("Number too large");
                        }
                    } else {
                        throw new ParseException("Number too large");
                    }
                } else {
                    throw new ParseException("Unexpected non-digit character");
                }
            }
            if (i2 != 0) {
                if (i <= 1) {
                    throw new ParseException("No digits to parse");
                }
                return j2;
            }
            return -j2;
        }
        throw new ParseException("No number to parse");
    }

    /* renamed from: f */
    public final String m3185f(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) {
        char m3181b = m3181b(bufferedReader);
        if (m3181b != '\"') {
            if (m3181b == 'n') {
                m3191l(bufferedReader, f13580g);
                return null;
            }
            throw new ParseException("Expected string");
        }
        return m3180a(bufferedReader, cArr, sb, cArr2);
    }

    /* renamed from: g */
    public final String m3186g(BufferedReader bufferedReader) {
        Stack stack = this.f13599f;
        stack.push(2);
        char m3181b = m3181b(bufferedReader);
        if (m3181b != '\"') {
            if (m3181b != ']') {
                if (m3181b == '}') {
                    m3190k(2);
                    return null;
                }
                throw new ParseException("Unexpected token: " + m3181b);
            }
            m3190k(2);
            m3190k(1);
            m3190k(5);
            return null;
        }
        stack.push(3);
        String m3180a = m3180a(bufferedReader, this.f13595b, this.f13597d, null);
        m3190k(3);
        if (m3181b(bufferedReader) == ':') {
            return m3180a;
        }
        throw new ParseException("Expected key/value separator");
    }

    /* renamed from: h */
    public final String m3187h(BufferedReader bufferedReader) {
        bufferedReader.mark(1024);
        char m3181b = m3181b(bufferedReader);
        int i = 1;
        if (m3181b != '\"') {
            if (m3181b != ',') {
                Stack stack = this.f13599f;
                if (m3181b != '[') {
                    if (m3181b != '{') {
                        bufferedReader.reset();
                        m3183d(bufferedReader, this.f13596c);
                    } else {
                        stack.push(1);
                        bufferedReader.mark(32);
                        char m3181b2 = m3181b(bufferedReader);
                        if (m3181b2 == '}') {
                            m3190k(1);
                        } else if (m3181b2 == '\"') {
                            bufferedReader.reset();
                            m3186g(bufferedReader);
                            do {
                            } while (m3187h(bufferedReader) != null);
                            m3190k(1);
                        } else {
                            throw new ParseException("Unexpected token " + m3181b2);
                        }
                    }
                } else {
                    stack.push(5);
                    bufferedReader.mark(32);
                    if (m3181b(bufferedReader) == ']') {
                        m3190k(5);
                    } else {
                        bufferedReader.reset();
                        boolean z = false;
                        boolean z2 = false;
                        while (i > 0) {
                            char m3181b3 = m3181b(bufferedReader);
                            if (m3181b3 != 0) {
                                if (!Character.isISOControl(m3181b3)) {
                                    if (m3181b3 == '\"') {
                                        if (!z2) {
                                            z = !z;
                                        }
                                        m3181b3 = '\"';
                                    }
                                    if (m3181b3 == '[') {
                                        if (!z) {
                                            i++;
                                        }
                                        m3181b3 = '[';
                                    }
                                    if (m3181b3 == ']' && !z) {
                                        i--;
                                    }
                                    if (m3181b3 == '\\' && z) {
                                        z2 = !z2;
                                    } else {
                                        z2 = false;
                                    }
                                } else {
                                    throw new ParseException("Unexpected control character while reading array");
                                }
                            } else {
                                throw new ParseException("Unexpected EOF while parsing array");
                            }
                        }
                        m3190k(5);
                    }
                }
            } else {
                throw new ParseException("Missing value");
            }
        } else {
            char[] cArr = this.f13594a;
            if (bufferedReader.read(cArr) != -1) {
                char c = cArr[0];
                boolean z3 = false;
                do {
                    if (c == '\"') {
                        if (z3) {
                            z3 = true;
                            c = '\"';
                        }
                    }
                    if (c == '\\') {
                        z3 = !z3;
                    } else {
                        z3 = false;
                    }
                    if (bufferedReader.read(cArr) != -1) {
                        c = cArr[0];
                    } else {
                        throw new ParseException("Unexpected EOF while parsing string");
                    }
                } while (!Character.isISOControl(c));
                throw new ParseException("Unexpected control character while reading string");
            }
            throw new ParseException("Unexpected EOF while parsing string");
        }
        char m3181b4 = m3181b(bufferedReader);
        if (m3181b4 != ',') {
            if (m3181b4 == '}') {
                m3190k(2);
                return null;
            }
            throw new ParseException("Unexpected token " + m3181b4);
        }
        m3190k(2);
        return m3186g(bufferedReader);
    }

    /* renamed from: i */
    public final ArrayList m3188i(BufferedReader bufferedReader, InterfaceC0770i interfaceC0770i) {
        char m3181b = m3181b(bufferedReader);
        if (m3181b == 'n') {
            m3191l(bufferedReader, f13580g);
            return null;
        }
        if (m3181b == '[') {
            this.f13599f.push(5);
            ArrayList arrayList = new ArrayList();
            while (true) {
                bufferedReader.mark(1024);
                char m3181b2 = m3181b(bufferedReader);
                if (m3181b2 != 0) {
                    if (m3181b2 != ',') {
                        if (m3181b2 != ']') {
                            bufferedReader.reset();
                            arrayList.add(interfaceC0770i.mo3199a(this, bufferedReader));
                        } else {
                            m3190k(5);
                            return arrayList;
                        }
                    }
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    /* renamed from: j */
    public final ArrayList m3189j(BufferedReader bufferedReader, FastJsonResponse.Field field) {
        ArrayList arrayList = new ArrayList();
        char m3181b = m3181b(bufferedReader);
        if (m3181b != ']') {
            if (m3181b != 'n') {
                if (m3181b == '{') {
                    Stack stack = this.f13599f;
                    stack.push(1);
                    while (true) {
                        try {
                            FastJsonResponse zad = field.zad();
                            if (m3193n(bufferedReader, zad)) {
                                arrayList.add(zad);
                                char m3181b2 = m3181b(bufferedReader);
                                if (m3181b2 != ',') {
                                    if (m3181b2 == ']') {
                                        m3190k(5);
                                        return arrayList;
                                    }
                                    throw new ParseException("Unexpected token: " + m3181b2);
                                }
                                if (m3181b(bufferedReader) == '{') {
                                    stack.push(1);
                                } else {
                                    throw new ParseException("Expected start of next object in array");
                                }
                            } else {
                                return arrayList;
                            }
                        } catch (IllegalAccessException e) {
                            throw new ParseException("Error instantiating inner object", e);
                        } catch (InstantiationException e2) {
                            throw new ParseException("Error instantiating inner object", e2);
                        }
                    }
                } else {
                    throw new ParseException("Unexpected token: " + m3181b);
                }
            } else {
                m3191l(bufferedReader, f13580g);
                m3190k(5);
                return null;
            }
        } else {
            m3190k(5);
            return arrayList;
        }
    }

    /* renamed from: k */
    public final void m3190k(int i) {
        Stack stack = this.f13599f;
        if (!stack.isEmpty()) {
            int intValue = ((Integer) stack.pop()).intValue();
            if (intValue == i) {
                return;
            } else {
                throw new ParseException(ye0.m8293m(i, "Expected state ", " but had ", intValue));
            }
        }
        throw new ParseException(ye0.m8292l(i, "Expected state ", " but had empty stack"));
    }

    /* renamed from: l */
    public final void m3191l(BufferedReader bufferedReader, char[] cArr) {
        int i = 0;
        while (true) {
            int length = cArr.length;
            if (i < length) {
                char[] cArr2 = this.f13595b;
                int read = bufferedReader.read(cArr2, 0, length - i);
                if (read != -1) {
                    for (int i2 = 0; i2 < read; i2++) {
                        if (cArr[i2 + i] != cArr2[i2]) {
                            throw new ParseException("Unexpected character");
                        }
                    }
                    i += read;
                } else {
                    throw new ParseException("Unexpected EOF");
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: m */
    public final boolean m3192m(BufferedReader bufferedReader, boolean z) {
        char[] cArr;
        char[] cArr2;
        char m3181b = m3181b(bufferedReader);
        if (m3181b != '\"') {
            if (m3181b != 'f') {
                if (m3181b != 'n') {
                    if (m3181b == 't') {
                        if (z) {
                            cArr2 = f13582i;
                        } else {
                            cArr2 = f13581h;
                        }
                        m3191l(bufferedReader, cArr2);
                        return true;
                    }
                    throw new ParseException("Unexpected token: " + m3181b);
                }
                m3191l(bufferedReader, f13580g);
                return false;
            }
            if (z) {
                cArr = f13584k;
            } else {
                cArr = f13583j;
            }
            m3191l(bufferedReader, cArr);
            return false;
        }
        if (!z) {
            return m3192m(bufferedReader, true);
        }
        throw new ParseException("No boolean value found in string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0040. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x02a9  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m3193n(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) {
        String str;
        BigInteger bigInteger;
        float parseFloat;
        double parseDouble;
        BigDecimal bigDecimal;
        HashMap hashMap;
        int i;
        char m3181b;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String m3186g = m3186g(bufferedReader);
        boolean z = true;
        if (m3186g != null) {
            while (m3186g != null) {
                FastJsonResponse.Field<?, ?> field = fieldMappings.get(m3186g);
                if (field == null) {
                    m3186g = m3187h(bufferedReader);
                } else {
                    Stack stack = this.f13599f;
                    stack.push(4);
                    int i2 = field.zaa;
                    char[] cArr = f13585l;
                    StringBuilder sb = this.f13598e;
                    char[] cArr2 = this.f13596c;
                    StringBuilder sb2 = this.f13597d;
                    char[] cArr3 = this.f13595b;
                    char[] cArr4 = f13580g;
                    switch (i2) {
                        case 0:
                            str = null;
                            if (field.zab) {
                                fastJsonResponse.zav(field, m3188i(bufferedReader, f13586m));
                            } else {
                                fastJsonResponse.zau(field, m3182c(bufferedReader));
                            }
                            i = 4;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                                if (m3181b == '}') {
                                    m3186g = str;
                                } else {
                                    throw new ParseException("Expected end of object or field separator, but found: " + m3181b);
                                }
                            } else {
                                m3186g = m3186g(bufferedReader);
                            }
                            z = true;
                            break;
                        case 1:
                            str = null;
                            if (field.zab) {
                                fastJsonResponse.zag(field, m3188i(bufferedReader, f13592s));
                            } else {
                                int m3183d = m3183d(bufferedReader, cArr2);
                                if (m3183d == 0) {
                                    bigInteger = null;
                                } else {
                                    bigInteger = new BigInteger(new String(cArr2, 0, m3183d));
                                }
                                fastJsonResponse.zae(field, bigInteger);
                            }
                            i = 4;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        case 2:
                            str = null;
                            if (field.zab) {
                                fastJsonResponse.zay(field, m3188i(bufferedReader, f13587n));
                            } else {
                                fastJsonResponse.zax(field, m3184e(bufferedReader));
                            }
                            i = 4;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        case 3:
                            str = null;
                            if (field.zab) {
                                fastJsonResponse.zas(field, m3188i(bufferedReader, f13588o));
                            } else {
                                int m3183d2 = m3183d(bufferedReader, cArr2);
                                if (m3183d2 == 0) {
                                    parseFloat = RecyclerView.f7068F0;
                                } else {
                                    parseFloat = Float.parseFloat(new String(cArr2, 0, m3183d2));
                                }
                                fastJsonResponse.zaq(field, parseFloat);
                            }
                            i = 4;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        case 4:
                            str = null;
                            if (field.zab) {
                                fastJsonResponse.zao(field, m3188i(bufferedReader, f13589p));
                            } else {
                                int m3183d3 = m3183d(bufferedReader, cArr2);
                                if (m3183d3 == 0) {
                                    parseDouble = 0.0d;
                                } else {
                                    parseDouble = Double.parseDouble(new String(cArr2, 0, m3183d3));
                                }
                                fastJsonResponse.zam(field, parseDouble);
                            }
                            i = 4;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        case 5:
                            str = null;
                            if (field.zab) {
                                fastJsonResponse.zac(field, m3188i(bufferedReader, f13593t));
                            } else {
                                int m3183d4 = m3183d(bufferedReader, cArr2);
                                if (m3183d4 == 0) {
                                    bigDecimal = null;
                                } else {
                                    bigDecimal = new BigDecimal(new String(cArr2, 0, m3183d4));
                                }
                                fastJsonResponse.zaa(field, bigDecimal);
                            }
                            i = 4;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        case 6:
                            str = null;
                            if (field.zab) {
                                fastJsonResponse.zaj(field, m3188i(bufferedReader, f13590q));
                            } else {
                                fastJsonResponse.zai(field, m3192m(bufferedReader, false));
                            }
                            i = 4;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        case 7:
                            if (field.zab) {
                                fastJsonResponse.zaC(field, m3188i(bufferedReader, f13591r));
                                i = 4;
                                str = null;
                                m3190k(i);
                                m3190k(2);
                                m3181b = m3181b(bufferedReader);
                                if (m3181b == ',') {
                                }
                                z = true;
                                break;
                            } else {
                                str = null;
                                fastJsonResponse.zaA(field, m3185f(bufferedReader, cArr3, sb2, null));
                                i = 4;
                                m3190k(i);
                                m3190k(2);
                                m3181b = m3181b(bufferedReader);
                                if (m3181b == ',') {
                                }
                                z = true;
                            }
                            break;
                        case 8:
                            fastJsonResponse.zal(field, Base64Utils.decode(m3185f(bufferedReader, cArr2, sb, cArr)));
                            i = 4;
                            str = null;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        case 9:
                            fastJsonResponse.zal(field, Base64Utils.decodeUrlSafe(m3185f(bufferedReader, cArr2, sb, cArr)));
                            i = 4;
                            str = null;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        case 10:
                            char m3181b2 = m3181b(bufferedReader);
                            if (m3181b2 == 'n') {
                                m3191l(bufferedReader, cArr4);
                                hashMap = null;
                            } else if (m3181b2 == '{') {
                                stack.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char m3181b3 = m3181b(bufferedReader);
                                    if (m3181b3 != 0) {
                                        if (m3181b3 != '\"') {
                                            if (m3181b3 == '}') {
                                                m3190k(1);
                                            }
                                        } else {
                                            String m3180a = m3180a(bufferedReader, cArr3, sb2, null);
                                            if (m3181b(bufferedReader) == ':') {
                                                if (m3181b(bufferedReader) == '\"') {
                                                    hashMap.put(m3180a, m3180a(bufferedReader, cArr3, sb2, null));
                                                    char m3181b4 = m3181b(bufferedReader);
                                                    if (m3181b4 != ',') {
                                                        if (m3181b4 == '}') {
                                                            m3190k(1);
                                                        } else {
                                                            throw new ParseException("Unexpected character while parsing string map: " + m3181b4);
                                                        }
                                                    }
                                                } else {
                                                    throw new ParseException("Expected String value for key ".concat(String.valueOf(m3180a)));
                                                }
                                            } else {
                                                throw new ParseException("No map value found for key ".concat(String.valueOf(m3180a)));
                                            }
                                        }
                                        i = 4;
                                        str = null;
                                        m3190k(i);
                                        m3190k(2);
                                        m3181b = m3181b(bufferedReader);
                                        if (m3181b == ',') {
                                        }
                                        z = true;
                                        break;
                                    } else {
                                        throw new ParseException("Unexpected EOF");
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse.zaB(field, hashMap);
                            i = 4;
                            str = null;
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        case 11:
                            if (field.zab) {
                                char m3181b5 = m3181b(bufferedReader);
                                if (m3181b5 == 'n') {
                                    m3191l(bufferedReader, cArr4);
                                    str = null;
                                    fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
                                    i = 4;
                                } else {
                                    stack.push(5);
                                    if (m3181b5 == '[') {
                                        fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, m3189j(bufferedReader, field));
                                        i = 4;
                                        str = null;
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char m3181b6 = m3181b(bufferedReader);
                                if (m3181b6 == 'n') {
                                    m3191l(bufferedReader, cArr4);
                                    str = null;
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
                                    i = 4;
                                } else {
                                    stack.push(1);
                                    if (m3181b6 == '{') {
                                        try {
                                            FastJsonResponse zad = field.zad();
                                            m3193n(bufferedReader, zad);
                                            fastJsonResponse.addConcreteTypeInternal(field, field.zae, zad);
                                            i = 4;
                                            str = null;
                                        } catch (IllegalAccessException e) {
                                            throw new ParseException("Error instantiating inner object", e);
                                        } catch (InstantiationException e2) {
                                            throw new ParseException("Error instantiating inner object", e2);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                            m3190k(i);
                            m3190k(2);
                            m3181b = m3181b(bufferedReader);
                            if (m3181b == ',') {
                            }
                            z = true;
                            break;
                        default:
                            throw new ParseException(ye0.m8291k(i2, "Invalid field type "));
                    }
                }
            }
            boolean z2 = z;
            m3190k(z2 ? 1 : 0);
            return z2;
        }
        m3190k(1);
        return false;
    }

    @KeepForSdk
    public void parse(@NonNull InputStream inputStream, @NonNull T t) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        Stack stack = this.f13599f;
        try {
            try {
                stack.push(0);
                char m3181b = m3181b(bufferedReader);
                if (m3181b != 0) {
                    if (m3181b != '[') {
                        if (m3181b == '{') {
                            stack.push(1);
                            m3193n(bufferedReader, t);
                        } else {
                            throw new ParseException("Unexpected token: " + m3181b);
                        }
                    } else {
                        stack.push(5);
                        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                        if (fieldMappings.size() == 1) {
                            FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                            t.addConcreteTypeArrayInternal(value, value.zae, m3189j(bufferedReader, value));
                        } else {
                            throw new ParseException("Object array response class must have a single Field");
                        }
                    }
                    m3190k(0);
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException unused) {
                        Log.w("FastParser", "Failed to close reader while parsing.");
                        return;
                    }
                }
                throw new ParseException("No data to parse");
            } catch (IOException e) {
                throw new ParseException(e);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
