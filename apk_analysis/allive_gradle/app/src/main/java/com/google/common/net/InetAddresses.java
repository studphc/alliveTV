package com.google.common.net;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.CheckForNull;
import kotlin.UShort;
import p000.AbstractC1726qj;
import p000.ye0;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class InetAddresses {

    /* renamed from: a */
    public static final CharMatcher f15159a = CharMatcher.m3759is('.');

    /* renamed from: b */
    public static final CharMatcher f15160b = CharMatcher.m3759is(':');

    /* renamed from: c */
    public static final Inet4Address f15161c = (Inet4Address) forString("127.0.0.1");

    /* renamed from: d */
    public static final Inet4Address f15162d = (Inet4Address) forString("0.0.0.0");

    /* loaded from: classes2.dex */
    public static final class TeredoInfo {

        /* renamed from: a */
        public final Inet4Address f15163a;

        /* renamed from: b */
        public final Inet4Address f15164b;

        /* renamed from: c */
        public final int f15165c;

        /* renamed from: d */
        public final int f15166d;

        public TeredoInfo(@CheckForNull Inet4Address inet4Address, @CheckForNull Inet4Address inet4Address2, int i, int i2) {
            boolean z;
            boolean z2 = false;
            if (i >= 0 && i <= 65535) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "port '%s' is out of range (0 <= port <= 0xffff)", i);
            if (i2 >= 0 && i2 <= 65535) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "flags '%s' is out of range (0 <= flags <= 0xffff)", i2);
            Inet4Address inet4Address3 = InetAddresses.f15162d;
            this.f15163a = (Inet4Address) MoreObjects.firstNonNull(inet4Address, inet4Address3);
            this.f15164b = (Inet4Address) MoreObjects.firstNonNull(inet4Address2, inet4Address3);
            this.f15165c = i;
            this.f15166d = i2;
        }

        public Inet4Address getClient() {
            return this.f15164b;
        }

        public int getFlags() {
            return this.f15166d;
        }

        public int getPort() {
            return this.f15165c;
        }

        public Inet4Address getServer() {
            return this.f15163a;
        }
    }

    /* renamed from: a */
    public static InetAddress m4225a(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public static InetAddress m4226b(String str) {
        int i;
        Preconditions.checkNotNull(str);
        if (str.startsWith("[") && str.endsWith("]")) {
            str = str.substring(1, str.length() - 1);
            i = 16;
        } else {
            i = 4;
        }
        byte[] m4229e = m4229e(str);
        if (m4229e != null && m4229e.length == i) {
            return m4225a(m4229e);
        }
        return null;
    }

    /* renamed from: c */
    public static InetAddress m4227c(BigInteger bigInteger, boolean z) {
        boolean z2;
        int i;
        if (bigInteger.signum() >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "BigInteger must be greater than or equal to 0");
        if (z) {
            i = 16;
        } else {
            i = 4;
        }
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i];
        int max = Math.max(0, byteArray.length - i);
        int length = byteArray.length - max;
        int i2 = i - length;
        for (int i3 = 0; i3 < max; i3++) {
            if (byteArray[i3] != 0) {
                throw new IllegalArgumentException(String.format(Locale.ROOT, "BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i), bigInteger));
            }
        }
        System.arraycopy(byteArray, max, bArr, i2, length);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    /* renamed from: d */
    public static Inet4Address m4228d(byte[] bArr) {
        boolean z;
        if (bArr.length == 4) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) m4225a(bArr);
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        boolean z;
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        if (length >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Decrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] - 1);
        return m4225a(address);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0128, code lost:
    
        r4 = (r4 << 4) | java.lang.Character.digit(r13.charAt(r8), 16);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0136, code lost:
    
        r1.putShort((short) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0142, code lost:
    
        throw new java.lang.NumberFormatException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0147, code lost:
    
        return r1.array();
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00fe, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0148, code lost:
    
        if (r2 == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x014a, code lost:
    
        if (r1 == (-1)) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x014c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0151, code lost:
    
        return m4231g(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0152, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0032, code lost:
    
        if (r3 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0037, code lost:
    
        if (r2 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        r2 = r13.lastIndexOf(58) + 1;
        r10 = r13.substring(0, r2);
        r13 = m4231g(r13.substring(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        if (r13 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007d, code lost:
    
        if (r13 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004e, code lost:
    
        r2 = java.lang.Integer.toHexString(((r13[0] & 255) << 8) | (r13[1] & 255));
        r13 = java.lang.Integer.toHexString((r13[3] & 255) | ((r13[2] & 255) << 8));
        r13 = p000.AbstractC1726qj.m7055k(p000.AbstractC1726qj.m7052h(p000.AbstractC1726qj.m7052h(p000.AbstractC1726qj.m7052h(1, r10), r2), r13), r10, r2, ":", r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
    
        if (r1 == (-1)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0082, code lost:
    
        r13 = r13.substring(0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0086, code lost:
    
        r1 = com.google.common.net.InetAddresses.f15160b.countIn(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008c, code lost:
    
        if (r1 < 2) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
    
        if (r1 <= 8) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0092, code lost:
    
        r1 = r1 + 1;
        r2 = 8 - r1;
        r10 = 0;
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009c, code lost:
    
        if (r10 >= (r13.length() - 1)) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a2, code lost:
    
        if (r13.charAt(r10) != ':') goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00aa, code lost:
    
        if (r13.charAt(r10 + 1) != ':') goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ac, code lost:
    
        if (r11 == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b0, code lost:
    
        r11 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
    
        if (r10 != 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b4, code lost:
    
        r11 = r2 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bb, code lost:
    
        if (r10 != (r13.length() - 2)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bd, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bf, code lost:
    
        r2 = r11;
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c1, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c8, code lost:
    
        if (r13.charAt(0) != ':') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ce, code lost:
    
        if (r13.charAt(1) == ':') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00db, code lost:
    
        if (r13.charAt(r13.length() - 1) != ':') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e6, code lost:
    
        if (r13.charAt(r13.length() - 2) == ':') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e9, code lost:
    
        if (r11 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00eb, code lost:
    
        if (r2 > 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ee, code lost:
    
        if (r11 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00f0, code lost:
    
        if (r1 == 8) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f3, code lost:
    
        r1 = java.nio.ByteBuffer.allocate(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00fb, code lost:
    
        if (r13.charAt(0) != ':') goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0103, code lost:
    
        if (r8 >= r13.length()) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0105, code lost:
    
        r3 = r13.indexOf(58, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0109, code lost:
    
        if (r3 != (-1)) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x010b, code lost:
    
        r3 = r13.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0113, code lost:
    
        if (r13.charAt(r8) != ':') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0115, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0116, code lost:
    
        if (r4 >= r2) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0118, code lost:
    
        r1.putShort(0);
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x013a, code lost:
    
        r8 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x011e, code lost:
    
        r4 = r3 - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0120, code lost:
    
        if (r4 <= 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0123, code lost:
    
        if (r4 > 4) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0125, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0126, code lost:
    
        if (r8 >= r3) goto L123;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] m4229e(String str) {
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int i2 = 1;
            if (i < str.length()) {
                char charAt = str.charAt(i);
                if (charAt == '.') {
                    z = true;
                } else if (charAt == ':') {
                    if (z) {
                        return null;
                    }
                    z2 = true;
                } else {
                    if (charAt == '%') {
                        break;
                    }
                    if (Character.digit(charAt, 16) == -1) {
                        return null;
                    }
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
    }

    /* renamed from: f */
    public static byte m4230f(int i, int i2, String str) {
        int i3 = i2 - i;
        if (i3 > 0 && i3 <= 3) {
            if (i3 > 1 && str.charAt(i) == '0') {
                throw new NumberFormatException();
            }
            int i4 = 0;
            while (i < i2) {
                int i5 = i4 * 10;
                int digit = Character.digit(str.charAt(i), 10);
                if (digit >= 0) {
                    i4 = i5 + digit;
                    i++;
                } else {
                    throw new NumberFormatException();
                }
            }
            if (i4 <= 255) {
                return (byte) i4;
            }
            throw new NumberFormatException();
        }
        throw new NumberFormatException();
    }

    @CanIgnoreReturnValue
    public static InetAddress forString(String str) {
        byte[] m4229e = m4229e(str);
        if (m4229e != null) {
            return m4225a(m4229e);
        }
        Locale locale = Locale.ROOT;
        throw new IllegalArgumentException(ye0.m8296p("'", str, "' is not an IP string literal."));
    }

    public static InetAddress forUriString(String str) {
        InetAddress m4226b = m4226b(str);
        if (m4226b != null) {
            return m4226b;
        }
        Locale locale = Locale.ROOT;
        throw new IllegalArgumentException(ye0.m8296p("Not a valid URI IP literal: '", str, "'"));
    }

    public static Inet4Address fromIPv4BigInteger(BigInteger bigInteger) {
        return (Inet4Address) m4227c(bigInteger, false);
    }

    public static Inet6Address fromIPv6BigInteger(BigInteger bigInteger) {
        return (Inet6Address) m4227c(bigInteger, true);
    }

    public static Inet4Address fromInteger(int i) {
        return m4228d(Ints.toByteArray(i));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[(bArr.length - i) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    /* renamed from: g */
    public static byte[] m4231g(String str) {
        if (f15159a.countIn(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int indexOf = str.indexOf(46, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            try {
                bArr[i2] = m4230f(i, indexOf, str);
                i = indexOf + 1;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", toAddrString(inet6Address));
        return m4228d(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress inetAddress) {
        boolean z;
        long j;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i = 0;
        while (true) {
            if (i < 15) {
                if (address[i] != 0) {
                    z = false;
                    break;
                }
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z && address[15] == 1) {
            return f15161c;
        }
        if (z && address[15] == 0) {
            return f15162d;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        if (hasEmbeddedIPv4ClientAddress(inet6Address)) {
            j = getEmbeddedIPv4ClientAddress(inet6Address).hashCode();
        } else {
            j = ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong();
        }
        int asInt = Hashing.murmur3_32_fixed().hashLong(j).asInt() | (-536870912);
        if (asInt == -1) {
            asInt = -2;
        }
        return m4228d(Ints.toByteArray(asInt));
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", toAddrString(inet6Address));
        return m4228d(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        String addrString = toAddrString(inet6Address);
        Locale locale = Locale.ROOT;
        throw new IllegalArgumentException(ye0.m8296p("'", addrString, "' has no embedded IPv4 address."));
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", toAddrString(inet6Address));
        return m4228d(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static TeredoInfo getTeredoInfo(Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address m4228d = m4228d(Arrays.copyOfRange(address, 4, 8));
        int readShort = ByteStreams.newDataInput(address, 8).readShort() & UShort.MAX_VALUE;
        int i = 65535 & (~ByteStreams.newDataInput(address, 10).readShort());
        byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i2 = 0; i2 < copyOfRange.length; i2++) {
            copyOfRange[i2] = (byte) (~copyOfRange[i2]);
        }
        return new TeredoInfo(m4228d, m4228d(copyOfRange), i, readShort);
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (!isCompatIPv4Address(inet6Address) && !is6to4Address(inet6Address) && !isTeredoAddress(inet6Address)) {
            return false;
        }
        return true;
    }

    public static InetAddress increment(InetAddress inetAddress) {
        boolean z;
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (true) {
            z = false;
            if (length < 0 || address[length] != -1) {
                break;
            }
            address[length] = 0;
            length--;
        }
        if (length >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z, "Incrementing %s would wrap.", inetAddress);
        address[length] = (byte) (address[length] + 1);
        return m4225a(address);
    }

    public static boolean is6to4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] != 32 || address[1] != 2) {
            return false;
        }
        return true;
    }

    public static boolean isCompatIPv4Address(Inet6Address inet6Address) {
        byte b;
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b = address[15]) == 0 || b == 1)) {
            return false;
        }
        return true;
    }

    public static boolean isInetAddress(String str) {
        if (m4229e(str) != null) {
            return true;
        }
        return false;
    }

    public static boolean isIsatapAddress(Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if ((address[8] | 3) != 3 || address[9] != 0 || address[10] != 94 || address[11] != -2) {
            return false;
        }
        return true;
    }

    public static boolean isMappedIPv4Address(String str) {
        byte[] m4229e = m4229e(str);
        if (m4229e == null || m4229e.length != 16) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i < 10) {
                if (m4229e[i] != 0) {
                    return false;
                }
                i++;
            } else {
                for (int i2 = 10; i2 < 12; i2++) {
                    if (m4229e[i2] != -1) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public static boolean isMaximum(InetAddress inetAddress) {
        for (byte b : inetAddress.getAddress()) {
            if (b != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTeredoAddress(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] != 32 || address[1] != 1 || address[2] != 0 || address[3] != 0) {
            return false;
        }
        return true;
    }

    public static boolean isUriInetAddress(String str) {
        if (m4226b(str) != null) {
            return true;
        }
        return false;
    }

    public static String toAddrString(InetAddress inetAddress) {
        boolean z;
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            int i2 = i * 2;
            iArr[i] = Ints.fromBytes((byte) 0, (byte) 0, address[i2], address[i2 + 1]);
        }
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < 9; i6++) {
            if (i6 < 8 && iArr[i6] == 0) {
                if (i5 < 0) {
                    i5 = i6;
                }
            } else if (i5 >= 0) {
                int i7 = i6 - i5;
                if (i7 > i3) {
                    i4 = i5;
                    i3 = i7;
                }
                i5 = -1;
            }
        }
        if (i3 >= 2) {
            Arrays.fill(iArr, i4, i3 + i4, -1);
        }
        StringBuilder sb = new StringBuilder(39);
        int i8 = 0;
        boolean z2 = false;
        while (i8 < 8) {
            if (iArr[i8] >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (z2) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(iArr[i8]));
            } else if (i8 == 0 || z2) {
                sb.append("::");
            }
            i8++;
            z2 = z;
        }
        return sb.toString();
    }

    public static BigInteger toBigInteger(InetAddress inetAddress) {
        return new BigInteger(1, inetAddress.getAddress());
    }

    public static String toUriString(InetAddress inetAddress) {
        if (inetAddress instanceof Inet6Address) {
            String addrString = toAddrString(inetAddress);
            return AbstractC1726qj.m7059o("[", addrString, "]", AbstractC1726qj.m7052h(2, addrString));
        }
        return toAddrString(inetAddress);
    }
}
