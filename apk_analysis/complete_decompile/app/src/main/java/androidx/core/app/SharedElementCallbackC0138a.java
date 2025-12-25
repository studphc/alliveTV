package androidx.core.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;
import p000.C1294i5;

/* renamed from: androidx.core.app.a */
/* loaded from: classes.dex */
public final class SharedElementCallbackC0138a extends android.app.SharedElementCallback {

    /* renamed from: a */
    public final SharedElementCallback f3513a;

    public SharedElementCallbackC0138a(SharedElementCallback sharedElementCallback) {
        this.f3513a = sharedElementCallback;
    }

    @Override // android.app.SharedElementCallback
    public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        return this.f3513a.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
        return this.f3513a.onCreateSnapshotView(context, parcelable);
    }

    @Override // android.app.SharedElementCallback
    public final void onMapSharedElements(List list, Map map) {
        this.f3513a.onMapSharedElements(list, map);
    }

    @Override // android.app.SharedElementCallback
    public final void onRejectSharedElements(List list) {
        this.f3513a.onRejectSharedElements(list);
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementEnd(List list, List list2, List list3) {
        this.f3513a.onSharedElementEnd(list, list2, list3);
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementStart(List list, List list2, List list3) {
        this.f3513a.onSharedElementStart(list, list2, list3);
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementsArrived(List list, List list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f3513a.onSharedElementsArrived(list, list2, new C1294i5(0, onSharedElementsReadyListener));
    }
}
