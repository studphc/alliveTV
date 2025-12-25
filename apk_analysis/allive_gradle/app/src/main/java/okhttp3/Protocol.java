package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1726qj;
import p000.ro2;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m5569d2 = {"Lokhttp3/Protocol;", "", "", "toString", "()Ljava/lang/String;", "Companion", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "HTTP_3", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic"),
    HTTP_3("h3");


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a */
    public final String f24077a;

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"Lokhttp3/Protocol$Companion;", "", "", "protocol", "Lokhttp3/Protocol;", "get", "(Ljava/lang/String;)Lokhttp3/Protocol;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @NotNull
        public final Protocol get(@NotNull String protocol) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (!Intrinsics.areEqual(protocol, protocol2.f24077a)) {
                protocol2 = Protocol.HTTP_1_1;
                if (!Intrinsics.areEqual(protocol, protocol2.f24077a)) {
                    protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!Intrinsics.areEqual(protocol, protocol2.f24077a)) {
                        protocol2 = Protocol.HTTP_2;
                        if (!Intrinsics.areEqual(protocol, protocol2.f24077a)) {
                            protocol2 = Protocol.SPDY_3;
                            if (!Intrinsics.areEqual(protocol, protocol2.f24077a)) {
                                protocol2 = Protocol.QUIC;
                                if (!Intrinsics.areEqual(protocol, protocol2.f24077a)) {
                                    protocol2 = Protocol.HTTP_3;
                                    if (!ro2.startsWith$default(protocol, protocol2.f24077a, false, 2, null)) {
                                        throw new IOException(AbstractC1726qj.m7038C("Unexpected protocol: ", protocol));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return protocol2;
        }
    }

    Protocol(String str) {
        this.f24077a = str;
    }

    @JvmStatic
    @NotNull
    public static final Protocol get(@NotNull String str) {
        return INSTANCE.get(str);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.f24077a;
    }
}
