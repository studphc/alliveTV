package okhttp3.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a)\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m5569d2 = {"", "", "canParseAsIpAddress", "(Ljava/lang/String;)Z", "containsInvalidLabelLengths", "containsInvalidHostnameAsciiCodes", "input", "", "pos", "limit", "", "decodeIpv6", "(Ljava/lang/String;II)[B", "address", "addressOffset", "decodeIpv4Suffix", "(Ljava/lang/String;II[BI)Z", "inet6AddressToAscii", "([B)Ljava/lang/String;", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _HostnamesCommonKt {

    /* renamed from: a */
    public static final Regex f24144a = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean canParseAsIpAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return f24144a.matches(str);
    }

    public static final boolean containsInvalidHostnameAsciiCodes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0 || StringsKt__StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", charAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean containsInvalidLabelLengths(@NotNull String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        if (1 <= length && length < 254) {
            int i2 = 0;
            while (true) {
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '.', i2, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    i = str.length() - i2;
                } else {
                    i = indexOf$default - i2;
                }
                if (1 > i || i >= 64) {
                    break;
                }
                if (indexOf$default == -1 || indexOf$default == str.length() - 1) {
                    break;
                }
                i2 = indexOf$default + 1;
            }
            return false;
        }
        return true;
    }

    public static final boolean decodeIpv4Suffix(@NotNull String input, int i, int i2, @NotNull byte[] address, int i3) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(address, "address");
        int i4 = i3;
        while (i < i2) {
            if (i4 == address.length) {
                return false;
            }
            if (i4 != i3) {
                if (input.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = input.charAt(i5);
                if (Intrinsics.compare((int) charAt, 48) < 0 || Intrinsics.compare((int) charAt, 57) > 0) {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            address[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        if (i4 != i3 + 4) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009a, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final byte[] decodeIpv6(@NotNull String input, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(input, "input");
        byte[] bArr = new byte[16];
        int i4 = i;
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        while (true) {
            if (i4 < i2) {
                if (i7 == 16) {
                    return null;
                }
                int i8 = i4 + 2;
                if (i8 <= i2 && ro2.startsWith$default(input, "::", i4, false, 4, null)) {
                    if (i5 != -1) {
                        return null;
                    }
                    i7 += 2;
                    if (i8 == i2) {
                        i5 = i7;
                        break;
                    }
                    i6 = i8;
                    i5 = i7;
                    i4 = i6;
                    int i9 = 0;
                    while (i4 < i2) {
                    }
                    i3 = i4 - i6;
                    if (i3 == 0) {
                        break;
                    }
                    break;
                }
                if (i7 != 0) {
                    if (ro2.startsWith$default(input, ":", i4, false, 4, null)) {
                        i4++;
                    } else {
                        if (!ro2.startsWith$default(input, ".", i4, false, 4, null) || !decodeIpv4Suffix(input, i6, i2, bArr, i7 - 2)) {
                            return null;
                        }
                        i7 += 2;
                    }
                }
                i6 = i4;
                i4 = i6;
                int i92 = 0;
                while (i4 < i2) {
                    int parseHexDigit = _UtilCommonKt.parseHexDigit(input.charAt(i4));
                    if (parseHexDigit == -1) {
                        break;
                    }
                    i92 = (i92 << 4) + parseHexDigit;
                    i4++;
                }
                i3 = i4 - i6;
                if (i3 == 0 || i3 > 4) {
                    break;
                }
                int i10 = i7 + 1;
                bArr[i7] = (byte) ((i92 >>> 8) & 255);
                i7 += 2;
                bArr[i10] = (byte) (i92 & 255);
            } else {
                break;
            }
        }
        if (i7 != 16) {
            if (i5 == -1) {
                return null;
            }
            ArraysKt___ArraysJvmKt.copyInto(bArr, bArr, 16 - (i7 - i5), i5, i7);
            ArraysKt___ArraysJvmKt.fill(bArr, (byte) 0, i5, (16 - i7) + i5);
        }
        return bArr;
    }

    @NotNull
    public static final String inet6AddressToAscii(@NotNull byte[] address) {
        Intrinsics.checkNotNullParameter(address, "address");
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < address.length) {
            int i5 = i3;
            while (i5 < 16 && address[i5] == 0 && address[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i2 < address.length) {
            if (i2 == i) {
                buffer.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((_UtilCommonKt.and(address[i2], 255) << 8) | _UtilCommonKt.and(address[i2 + 1], 255));
                i2 += 2;
            }
        }
        return buffer.readUtf8();
    }
}
