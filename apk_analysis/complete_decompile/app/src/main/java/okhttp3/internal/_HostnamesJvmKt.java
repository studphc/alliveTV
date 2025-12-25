package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001¨\u0006\u0002"}, m5569d2 = {"toCanonicalHost", "", "okhttp"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _HostnamesJvmKt {
    @Nullable
    public static final String toCanonicalHost(@NotNull String str) {
        byte[] decodeIpv6;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            if (ro2.startsWith$default(str, "[", false, 2, null) && ro2.endsWith$default(str, "]", false, 2, null)) {
                decodeIpv6 = _HostnamesCommonKt.decodeIpv6(str, 1, str.length() - 1);
            } else {
                decodeIpv6 = _HostnamesCommonKt.decodeIpv6(str, 0, str.length());
            }
            if (decodeIpv6 == null) {
                return null;
            }
            InetAddress byAddress = InetAddress.getByAddress(decodeIpv6);
            byte[] address = byAddress.getAddress();
            if (address.length == 16) {
                Intrinsics.checkNotNullExpressionValue(address, "address");
                return _HostnamesCommonKt.inet6AddressToAscii(address);
            }
            if (address.length == 4) {
                return byAddress.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        try {
            String ascii = IDN.toASCII(str);
            Intrinsics.checkNotNullExpressionValue(ascii, "toASCII(host)");
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowercase = _UtilJvmKt.lowercase(ascii, US);
            if (lowercase.length() != 0 && !_HostnamesCommonKt.containsInvalidHostnameAsciiCodes(lowercase)) {
                if (_HostnamesCommonKt.containsInvalidLabelLengths(lowercase)) {
                    return null;
                }
                return lowercase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
