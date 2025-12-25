package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@Immutable
@GwtCompatible
/* loaded from: classes2.dex */
public final class HostAndPort implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final String f15154a;

    /* renamed from: b */
    public final int f15155b;

    /* renamed from: c */
    public final boolean f15156c;

    public HostAndPort(String str, int i, boolean z) {
        this.f15154a = str;
        this.f15155b = i;
        this.f15156c = z;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(!fromString.hasPort(), "Host has a port: %s", str);
        return fromString;
    }

    public static HostAndPort fromParts(String str, int i) {
        boolean z;
        if (i >= 0 && i <= 65535) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Port out of range: %s", i);
        HostAndPort fromString = fromString(str);
        Preconditions.checkArgument(true ^ fromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(fromString.f15154a, i, fromString.f15156c);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a6  */
    @CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HostAndPort fromString(String str) {
        boolean z;
        String str2;
        boolean z2;
        String str3;
        String substring;
        boolean z3;
        String str4;
        boolean z4;
        boolean z5;
        boolean z6;
        String[] strArr;
        Preconditions.checkNotNull(str);
        int i = -1;
        boolean z7 = true;
        if (str.startsWith("[")) {
            if (str.charAt(0) == '[') {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "Bracketed host-port string must start with a bracket: %s", str);
            int indexOf = str.indexOf(58);
            int lastIndexOf = str.lastIndexOf(93);
            if (indexOf > -1 && lastIndexOf > indexOf) {
                z5 = true;
            } else {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "Invalid bracketed host/port: %s", str);
            String substring2 = str.substring(1, lastIndexOf);
            int i2 = lastIndexOf + 1;
            if (i2 == str.length()) {
                strArr = new String[]{substring2, ""};
            } else {
                if (str.charAt(i2) == ':') {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Preconditions.checkArgument(z6, "Only a colon may follow a close bracket: %s", str);
                int i3 = lastIndexOf + 2;
                for (int i4 = i3; i4 < str.length(); i4++) {
                    Preconditions.checkArgument(Character.isDigit(str.charAt(i4)), "Port must be numeric: %s", str);
                }
                strArr = new String[]{substring2, str.substring(i3)};
            }
            substring = strArr[0];
            str3 = strArr[1];
        } else {
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0) {
                int i5 = indexOf2 + 1;
                if (str.indexOf(58, i5) == -1) {
                    substring = str.substring(0, indexOf2);
                    str3 = str.substring(i5);
                }
            }
            if (indexOf2 >= 0) {
                z = true;
            } else {
                z = false;
            }
            str2 = str;
            z2 = z;
            str3 = null;
            if (!Strings.isNullOrEmpty(str3)) {
                if (!str3.startsWith("+") && CharMatcher.ascii().matchesAllOf(str3)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "Unparseable port number: %s", str);
                try {
                    i = Integer.parseInt(str3);
                    if (i < 0 || i > 65535) {
                        z7 = false;
                    }
                    Preconditions.checkArgument(z7, "Port number out of range: %s", str);
                } catch (NumberFormatException unused) {
                    if (str.length() != 0) {
                        str4 = "Unparseable port number: ".concat(str);
                    } else {
                        str4 = new String("Unparseable port number: ");
                    }
                    throw new IllegalArgumentException(str4);
                }
            }
            return new HostAndPort(str2, i, z2);
        }
        str2 = substring;
        z2 = false;
        if (!Strings.isNullOrEmpty(str3)) {
        }
        return new HostAndPort(str2, i, z2);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        if (Objects.equal(this.f15154a, hostAndPort.f15154a) && this.f15155b == hostAndPort.f15155b) {
            return true;
        }
        return false;
    }

    public String getHost() {
        return this.f15154a;
    }

    public int getPort() {
        Preconditions.checkState(hasPort());
        return this.f15155b;
    }

    public int getPortOrDefault(int i) {
        if (hasPort()) {
            return this.f15155b;
        }
        return i;
    }

    public boolean hasPort() {
        if (this.f15155b >= 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f15154a, Integer.valueOf(this.f15155b));
    }

    @CanIgnoreReturnValue
    public HostAndPort requireBracketsForIPv6() {
        Preconditions.checkArgument(!this.f15156c, "Possible bracketless IPv6 literal: %s", this.f15154a);
        return this;
    }

    public String toString() {
        String str = this.f15154a;
        StringBuilder sb = new StringBuilder(str.length() + 8);
        if (str.indexOf(58) >= 0) {
            sb.append('[');
            sb.append(str);
            sb.append(']');
        } else {
            sb.append(str);
        }
        if (hasPort()) {
            sb.append(':');
            sb.append(this.f15155b);
        }
        return sb.toString();
    }

    public HostAndPort withDefaultPort(int i) {
        boolean z;
        if (i >= 0 && i <= 65535) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (hasPort()) {
            return this;
        }
        return new HostAndPort(this.f15154a, i, this.f15156c);
    }
}
