package p000;

import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class w02 implements Cancellable {

    /* renamed from: a */
    public final OnBackPressedCallback f28029a;

    /* renamed from: b */
    public final /* synthetic */ OnBackPressedDispatcher f28030b;

    public w02(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
        this.f28030b = onBackPressedDispatcher;
        this.f28029a = onBackPressedCallback;
    }

    @Override // androidx.activity.Cancellable
    public final void cancel() {
        ArrayDeque arrayDeque;
        OnBackPressedCallback onBackPressedCallback;
        OnBackPressedDispatcher onBackPressedDispatcher = this.f28030b;
        arrayDeque = onBackPressedDispatcher.f505c;
        OnBackPressedCallback onBackPressedCallback2 = this.f28029a;
        arrayDeque.remove(onBackPressedCallback2);
        onBackPressedCallback = onBackPressedDispatcher.f506d;
        if (Intrinsics.areEqual(onBackPressedCallback, onBackPressedCallback2)) {
            onBackPressedCallback2.handleOnBackCancelled();
            onBackPressedDispatcher.f506d = null;
        }
        onBackPressedCallback2.removeCancellable(this);
        Function0<Unit> enabledChangedCallback$activity_release = onBackPressedCallback2.getEnabledChangedCallback$activity_release();
        if (enabledChangedCallback$activity_release != null) {
            enabledChangedCallback$activity_release.invoke();
        }
        onBackPressedCallback2.setEnabledChangedCallback$activity_release(null);
    }
}
