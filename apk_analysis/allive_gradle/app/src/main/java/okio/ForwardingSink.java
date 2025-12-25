package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0002\u0010\u0016¨\u0006\u0019"}, m5569d2 = {"Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "<init>", "(Lokio/Sink;)V", "Lokio/Buffer;", FirebaseAnalytics.Param.SOURCE, "", "byteCount", "", "write", "(Lokio/Buffer;J)V", "flush", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "close", "", "toString", "()Ljava/lang/String;", "-deprecated_delegate", "()Lokio/Sink;", "a", "Lokio/Sink;", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public abstract class ForwardingSink implements Sink {

    /* renamed from: a, reason: from kotlin metadata */
    public final Sink delegate;

    public ForwardingSink(@NotNull Sink delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "delegate", imports = {}))
    @JvmName(name = "-deprecated_delegate")
    @NotNull
    /* renamed from: -deprecated_delegate, reason: not valid java name and from getter */
    public final Sink getDelegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @JvmName(name = "delegate")
    @NotNull
    public final Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // okio.Sink
    @NotNull
    /* renamed from: timeout */
    public Timeout getF24673a() {
        return this.delegate.getF24673a();
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // okio.Sink
    public void write(@NotNull Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.write(source, byteCount);
    }
}
