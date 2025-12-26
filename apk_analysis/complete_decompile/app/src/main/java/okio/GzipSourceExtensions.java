package okio;

import com.hisona.allive.HttpRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m5569d2 = {"Lokio/Source;", "Lokio/GzipSource;", HttpRequest.ENCODING_GZIP, "(Lokio/Source;)Lokio/GzipSource;", "okio"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
@JvmName(name = "-GzipSourceExtensions")
/* renamed from: okio.-GzipSourceExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class GzipSourceExtensions {
    @NotNull
    public static final GzipSource gzip(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new GzipSource(source);
    }
}
