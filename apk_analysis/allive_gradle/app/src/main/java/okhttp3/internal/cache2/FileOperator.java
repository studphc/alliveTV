package okhttp3.internal.cache2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, m5569d2 = {"Lokhttp3/internal/cache2/FileOperator;", "", "Ljava/nio/channels/FileChannel;", "fileChannel", "<init>", "(Ljava/nio/channels/FileChannel;)V", "", "pos", "Lokio/Buffer;", FirebaseAnalytics.Param.SOURCE, "byteCount", "", "write", "(JLokio/Buffer;J)V", "sink", "read", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class FileOperator {

    /* renamed from: a */
    public final FileChannel f24232a;

    public FileOperator(@NotNull FileChannel fileChannel) {
        Intrinsics.checkNotNullParameter(fileChannel, "fileChannel");
        this.f24232a = fileChannel;
    }

    public final void read(long pos, @NotNull Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            while (byteCount > 0) {
                long transferTo = this.f24232a.transferTo(pos, byteCount, sink);
                pos += transferTo;
                byteCount -= transferTo;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void write(long pos, @NotNull Buffer source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (byteCount >= 0 && byteCount <= source.size()) {
            while (byteCount > 0) {
                long transferFrom = this.f24232a.transferFrom(source, pos, byteCount);
                pos += transferFrom;
                byteCount -= transferFrom;
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
