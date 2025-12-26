package okhttp3.logging.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import p000.r82;

@Metadata(m5568d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m5569d2 = {"isProbablyUtf8", "", "Lokio/Buffer;", "logging-interceptor"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, r82.coerceAtMost(buffer.size(), 64L));
            for (int i = 0; i < 16; i++) {
                if (!buffer2.exhausted()) {
                    int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                    if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                        return false;
                    }
                } else {
                    return true;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
