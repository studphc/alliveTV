package androidx.activity;

import android.window.BackEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(34)
@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0003\u0010\fJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0004\u0010\fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0007\u0010\r¨\u0006\u000e"}, m5569d2 = {"Landroidx/activity/Api34Impl;", "", "", "touchX", "touchY", "progress", "", "swipeEdge", "Landroid/window/BackEvent;", "createOnBackEvent", "(FFFI)Landroid/window/BackEvent;", "backEvent", "(Landroid/window/BackEvent;)F", "(Landroid/window/BackEvent;)I", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class Api34Impl {

    @NotNull
    public static final Api34Impl INSTANCE = new Object();

    @DoNotInline
    @NotNull
    public final BackEvent createOnBackEvent(float touchX, float touchY, float progress, int swipeEdge) {
        return new BackEvent(touchX, touchY, progress, swipeEdge);
    }

    @DoNotInline
    public final float progress(@NotNull BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    @DoNotInline
    public final int swipeEdge(@NotNull BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    @DoNotInline
    public final float touchX(@NotNull BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    @DoNotInline
    public final float touchY(@NotNull BackEvent backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
