package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.InflaterSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m5569d2 = {"Lokhttp3/internal/ws/MessageInflater;", "Ljava/io/Closeable;", "", "noContextTakeover", "<init>", "(Z)V", "Lokio/Buffer;", "buffer", "", "inflate", "(Lokio/Buffer;)V", "close", "()V", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class MessageInflater implements Closeable {

    /* renamed from: a */
    public final boolean f24589a;

    /* renamed from: b */
    public final Buffer f24590b;

    /* renamed from: c */
    public final Inflater f24591c;

    /* renamed from: d */
    public final InflaterSource f24592d;

    public MessageInflater(boolean z) {
        this.f24589a = z;
        Buffer buffer = new Buffer();
        this.f24590b = buffer;
        Inflater inflater = new Inflater(true);
        this.f24591c = inflater;
        this.f24592d = new InflaterSource((Source) buffer, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f24592d.close();
    }

    public final void inflate(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Buffer buffer2 = this.f24590b;
        if (buffer2.size() == 0) {
            boolean z = this.f24589a;
            Inflater inflater = this.f24591c;
            if (z) {
                inflater.reset();
            }
            buffer2.writeAll(buffer);
            buffer2.writeInt(65535);
            long size = buffer2.size() + inflater.getBytesRead();
            do {
                this.f24592d.readOrInflate(buffer, Long.MAX_VALUE);
            } while (inflater.getBytesRead() < size);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }
}
