package okhttp3;

import com.google.android.gms.actions.SearchIntents;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p000.C1294i5;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0003\b\t\nJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, m5569d2 = {"Lokhttp3/AsyncDns;", "", SearchIntents.EXTRA_QUERY, "", "hostname", "", "callback", "Lokhttp3/AsyncDns$Callback;", "Callback", "Companion", "DnsClass", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public interface AsyncDns {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f23856a;
    public static final int TYPE_A = 1;
    public static final int TYPE_AAAA = 28;

    @Metadata(m5568d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&J\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, m5569d2 = {"Lokhttp3/AsyncDns$Callback;", "", "onFailure", "", "hostname", "", "e", "Ljava/io/IOException;", "Lokio/IOException;", "onResponse", "addresses", "", "Ljava/net/InetAddress;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public interface Callback {
        void onFailure(@NotNull String hostname, @NotNull IOException e);

        void onResponse(@NotNull String hostname, @NotNull List<? extends InetAddress> addresses);
    }

    @Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\f"}, m5569d2 = {"Lokhttp3/AsyncDns$Companion;", "", "", "Lokhttp3/AsyncDns;", "asyncDns", "Lokhttp3/Dns;", "toDns", "([Lokhttp3/AsyncDns;)Lokhttp3/Dns;", "", "TYPE_A", "I", "TYPE_AAAA", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static final int TYPE_A = 1;
        public static final int TYPE_AAAA = 28;

        /* renamed from: a */
        public static final /* synthetic */ Companion f23856a = new Object();

        @NotNull
        public final Dns toDns(@NotNull AsyncDns... asyncDns) {
            Intrinsics.checkNotNullParameter(asyncDns, "asyncDns");
            return new C1294i5(1, asyncDns);
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m5569d2 = {"Lokhttp3/AsyncDns$DnsClass;", "", "", "a", "I", "getType", "()I", "type", "IPV4", "IPV6", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public enum DnsClass {
        IPV4(1),
        IPV6(28);


        /* renamed from: a, reason: from kotlin metadata */
        public final int type;

        DnsClass(int i) {
            this.type = i;
        }

        public final int getType() {
            return this.type;
        }
    }

    void query(@NotNull String hostname, @NotNull Callback callback);
}
