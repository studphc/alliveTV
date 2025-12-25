package androidx.core.os;

import android.os.Handler;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import p000.ExecutorC2014yb;

/* loaded from: classes.dex */
public final class ExecutorCompat {
    @NonNull
    public static Executor create(@NonNull Handler handler) {
        return new ExecutorC2014yb(1, handler);
    }
}
