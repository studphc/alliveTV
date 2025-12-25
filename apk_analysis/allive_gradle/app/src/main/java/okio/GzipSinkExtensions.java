package okio;

import com.hisona.allive.HttpRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, m5569d2 = {HttpRequest.ENCODING_GZIP, "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
@JvmName(name = "-GzipSinkExtensions")
/* renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class GzipSinkExtensions {
    @NotNull
    public static final GzipSink gzip(@NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new GzipSink(sink);
    }
}
