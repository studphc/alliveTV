package okhttp3.internal.http1;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m5569d2 = {"Lokhttp3/internal/http1/HeadersReader;", "", "Lokio/BufferedSource;", FirebaseAnalytics.Param.SOURCE, "<init>", "(Lokio/BufferedSource;)V", "", "readLine", "()Ljava/lang/String;", "Lokhttp3/Headers;", "readHeaders", "()Lokhttp3/Headers;", "a", "Lokio/BufferedSource;", "getSource", "()Lokio/BufferedSource;", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class HeadersReader {

    /* renamed from: a, reason: from kotlin metadata */
    public final BufferedSource source;

    /* renamed from: b */
    public long f24405b;

    public HeadersReader(@NotNull BufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.f24405b = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    @NotNull
    public final BufferedSource getSource() {
        return this.source;
    }

    @NotNull
    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String readLine = readLine();
            if (readLine.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(readLine);
        }
    }

    @NotNull
    public final String readLine() {
        String readUtf8LineStrict = this.source.readUtf8LineStrict(this.f24405b);
        this.f24405b -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }
}
