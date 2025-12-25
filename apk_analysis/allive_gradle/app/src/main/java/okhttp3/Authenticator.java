package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import okhttp3.internal.authenticator.JavaNetAuthenticator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m5569d2 = {"Lokhttp3/Authenticator;", "", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public interface Authenticator {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f23862a;

    @JvmField
    @NotNull
    public static final Authenticator NONE = new Object();

    @JvmField
    @NotNull
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(null, 1, 0 == true ? 1 : 0);

    @Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001R\u0017\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0001¨\u0006\u0007"}, m5569d2 = {"Lokhttp3/Authenticator$Companion;", "", "Lokhttp3/Authenticator;", "JAVA_NET_AUTHENTICATOR", "Lokhttp3/Authenticator;", "NONE", "okhttp3/a", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        /* renamed from: a */
        public static final /* synthetic */ Companion f23862a = new Object();
    }

    @Nullable
    Request authenticate(@Nullable Route route, @NotNull Response response);
}
