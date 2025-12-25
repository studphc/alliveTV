package androidx.activity;

import androidx.annotation.MainThread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0006H'¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0014\u0010\u0013R*\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028G@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0005R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, m5569d2 = {"Landroidx/activity/OnBackPressedCallback;", "", "", "enabled", "<init>", "(Z)V", "", "remove", "()V", "Landroidx/activity/BackEventCompat;", "backEvent", "handleOnBackStarted", "(Landroidx/activity/BackEventCompat;)V", "handleOnBackProgressed", "handleOnBackPressed", "handleOnBackCancelled", "Landroidx/activity/Cancellable;", "cancellable", "addCancellable", "(Landroidx/activity/Cancellable;)V", "removeCancellable", "value", "a", "Z", "isEnabled", "()Z", "setEnabled", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "getEnabledChangedCallback$activity_release", "()Lkotlin/jvm/functions/Function0;", "setEnabledChangedCallback$activity_release", "(Lkotlin/jvm/functions/Function0;)V", "enabledChangedCallback", "activity_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nOnBackPressedCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,115:1\n1855#2,2:116\n*S KotlinDebug\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n*L\n67#1:116,2\n*E\n"})
/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {

    /* renamed from: a, reason: from kotlin metadata */
    public boolean isEnabled;

    /* renamed from: b */
    public final CopyOnWriteArrayList f501b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: from kotlin metadata */
    public Function0 enabledChangedCallback;

    public OnBackPressedCallback(boolean z) {
        this.isEnabled = z;
    }

    @JvmName(name = "addCancellable")
    public final void addCancellable(@NotNull Cancellable cancellable) {
        Intrinsics.checkNotNullParameter(cancellable, "cancellable");
        this.f501b.add(cancellable);
    }

    @Nullable
    public final Function0<Unit> getEnabledChangedCallback$activity_release() {
        return this.enabledChangedCallback;
    }

    @MainThread
    public void handleOnBackCancelled() {
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public void handleOnBackProgressed(@NotNull BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
    }

    @MainThread
    public void handleOnBackStarted(@NotNull BackEventCompat backEvent) {
        Intrinsics.checkNotNullParameter(backEvent, "backEvent");
    }

    @MainThread
    /* renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator it = this.f501b.iterator();
        while (it.hasNext()) {
            ((Cancellable) it.next()).cancel();
        }
    }

    @JvmName(name = "removeCancellable")
    public final void removeCancellable(@NotNull Cancellable cancellable) {
        Intrinsics.checkNotNullParameter(cancellable, "cancellable");
        this.f501b.remove(cancellable);
    }

    @MainThread
    public final void setEnabled(boolean z) {
        this.isEnabled = z;
        Function0 function0 = this.enabledChangedCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setEnabledChangedCallback$activity_release(@Nullable Function0<Unit> function0) {
        this.enabledChangedCallback = function0;
    }
}
