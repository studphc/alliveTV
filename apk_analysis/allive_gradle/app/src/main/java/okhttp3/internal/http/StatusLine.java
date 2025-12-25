package okhttp3.internal.http;

import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1726qj;
import p000.qo2;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m5569d2 = {"Lokhttp3/internal/http/StatusLine;", "", "protocol", "Lokhttp3/Protocol;", "code", "", "message", "", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "toString", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class StatusLine {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public final int code;

    @JvmField
    @NotNull
    public final String message;

    @JvmField
    @NotNull
    public final Protocol protocol;

    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m5569d2 = {"Lokhttp3/internal/http/StatusLine$Companion;", "", "Lokhttp3/Response;", "response", "Lokhttp3/internal/http/StatusLine;", "get", "(Lokhttp3/Response;)Lokhttp3/internal/http/StatusLine;", "", "statusLine", "parse", "(Ljava/lang/String;)Lokhttp3/internal/http/StatusLine;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @NotNull
        public final StatusLine get(@NotNull Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        @NotNull
        public final StatusLine parse(@NotNull String statusLine) {
            Protocol protocol;
            int i;
            String str;
            Intrinsics.checkNotNullParameter(statusLine, "statusLine");
            if (ro2.startsWith$default(statusLine, "HTTP/1.", false, 2, null)) {
                i = 9;
                if (statusLine.length() >= 9 && statusLine.charAt(8) == ' ') {
                    int charAt = statusLine.charAt(7) - '0';
                    if (charAt != 0) {
                        if (charAt == 1) {
                            protocol = Protocol.HTTP_1_1;
                        } else {
                            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                        }
                    } else {
                        protocol = Protocol.HTTP_1_0;
                    }
                } else {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
            } else if (ro2.startsWith$default(statusLine, "ICY ", false, 2, null)) {
                protocol = Protocol.HTTP_1_0;
                i = 4;
            } else if (ro2.startsWith$default(statusLine, "SOURCETABLE ", false, 2, null)) {
                protocol = Protocol.HTTP_1_1;
                i = 12;
            } else {
                throw new ProtocolException(AbstractC1726qj.m7038C("Unexpected status line: ", statusLine));
            }
            int i2 = i + 3;
            if (statusLine.length() >= i2) {
                String substring = statusLine.substring(i, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                Integer intOrNull = qo2.toIntOrNull(substring);
                if (intOrNull != null) {
                    int intValue = intOrNull.intValue();
                    if (statusLine.length() > i2) {
                        if (statusLine.charAt(i2) == ' ') {
                            str = statusLine.substring(i + 4);
                            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).substring(startIndex)");
                        } else {
                            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                        }
                    } else {
                        str = "";
                    }
                    return new StatusLine(protocol, intValue, str);
                }
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            throw new ProtocolException("Unexpected status line: ".concat(statusLine));
        }
    }

    public StatusLine(@NotNull Protocol protocol, int i, @NotNull String message) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        this.protocol = protocol;
        this.code = i;
        this.message = message;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
