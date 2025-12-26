package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.dx0;
import p000.tu0;

/* loaded from: classes.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;

    /* renamed from: a */
    public final dx0 f3275a;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void add(@NonNull Activity activity) {
        this.f3275a.mo4625a(activity);
    }

    @Nullable
    public SparseIntArray[] getMetrics() {
        return this.f3275a.mo4627f();
    }

    @Nullable
    public SparseIntArray[] remove(@NonNull Activity activity) {
        return this.f3275a.mo4629k(activity);
    }

    @Nullable
    public SparseIntArray[] reset() {
        return this.f3275a.mo4630l();
    }

    @Nullable
    public SparseIntArray[] stop() {
        return this.f3275a.mo4631m();
    }

    public FrameMetricsAggregator(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f3275a = new tu0(i);
        } else {
            this.f3275a = new dx0(16);
        }
    }
}
