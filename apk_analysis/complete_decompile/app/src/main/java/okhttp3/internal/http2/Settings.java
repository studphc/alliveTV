package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J \u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0011J\u0015\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u000fJ\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u000fJ\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011¨\u0006 "}, m5569d2 = {"Lokhttp3/internal/http2/Settings;", "", "<init>", "()V", "", "clear", "", "id", "value", "set", "(II)Lokhttp3/internal/http2/Settings;", "", "isSet", "(I)Z", "get", "(I)I", "size", "()I", "defaultValue", "getEnablePush", "(Z)Z", "getMaxConcurrentStreams", "getMaxFrameSize", "getMaxHeaderListSize", "other", "merge", "(Lokhttp3/internal/http2/Settings;)V", "getHeaderTableSize", "headerTableSize", "getInitialWindowSize", "initialWindowSize", "Companion", "okhttp"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class Settings {
    public static final int COUNT = 10;
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;

    /* renamed from: a */
    public int f24524a;

    /* renamed from: b */
    public final int[] f24525b = new int[10];

    public final void clear() {
        this.f24524a = 0;
        ArraysKt___ArraysJvmKt.fill$default(this.f24525b, 0, 0, 0, 6, (Object) null);
    }

    public final int get(int id) {
        return this.f24525b[id];
    }

    public final boolean getEnablePush(boolean defaultValue) {
        if ((this.f24524a & 4) != 0) {
            if (this.f24525b[2] == 1) {
                return true;
            }
            return false;
        }
        return defaultValue;
    }

    public final int getHeaderTableSize() {
        if ((this.f24524a & 2) != 0) {
            return this.f24525b[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        if ((this.f24524a & 128) != 0) {
            return this.f24525b[7];
        }
        return 65535;
    }

    public final int getMaxConcurrentStreams() {
        if ((this.f24524a & 16) != 0) {
            return this.f24525b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int getMaxFrameSize(int defaultValue) {
        if ((this.f24524a & 32) != 0) {
            return this.f24525b[5];
        }
        return defaultValue;
    }

    public final int getMaxHeaderListSize(int defaultValue) {
        if ((this.f24524a & 64) != 0) {
            return this.f24525b[6];
        }
        return defaultValue;
    }

    public final boolean isSet(int id) {
        if (((1 << id) & this.f24524a) != 0) {
            return true;
        }
        return false;
    }

    public final void merge(@NotNull Settings other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (int i = 0; i < 10; i++) {
            if (other.isSet(i)) {
                set(i, other.get(i));
            }
        }
    }

    @NotNull
    public final Settings set(int id, int value) {
        if (id >= 0) {
            int[] iArr = this.f24525b;
            if (id < iArr.length) {
                this.f24524a = (1 << id) | this.f24524a;
                iArr[id] = value;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.f24524a);
    }
}
