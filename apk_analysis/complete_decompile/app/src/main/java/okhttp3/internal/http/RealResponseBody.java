package okhttp3.internal.http;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u000e¨\u0006\u000f"}, m5569d2 = {"Lokhttp3/internal/http/RealResponseBody;", "Lokhttp3/ResponseBody;", "", "contentTypeString", "", "contentLength", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "<init>", "(Ljava/lang/String;JLokio/BufferedSource;)V", "()J", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "()Lokio/BufferedSource;", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class RealResponseBody extends ResponseBody {

    /* renamed from: b */
    public final String f24400b;

    /* renamed from: c */
    public final long f24401c;

    /* renamed from: d */
    public final BufferedSource f24402d;

    public RealResponseBody(@Nullable String str, long j, @NotNull BufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f24400b = str;
        this.f24401c = j;
        this.f24402d = source;
    }

    @Override // okhttp3.ResponseBody
    /* renamed from: contentLength, reason: from getter */
    public long getF24401c() {
        return this.f24401c;
    }

    @Override // okhttp3.ResponseBody
    @Nullable
    public MediaType contentType() {
        String str = this.f24400b;
        if (str != null) {
            return MediaType.INSTANCE.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    @NotNull
    /* renamed from: source, reason: from getter */
    public BufferedSource getF24402d() {
        return this.f24402d;
    }
}
