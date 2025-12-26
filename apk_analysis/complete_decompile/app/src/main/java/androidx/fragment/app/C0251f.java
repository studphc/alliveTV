package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p000.RunnableC0006a5;
import p000.RunnableC0583c7;

/* renamed from: androidx.fragment.app.f */
/* loaded from: classes.dex */
public final class C0251f extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ C0253h f4656b;

    /* renamed from: c */
    public final /* synthetic */ Object f4657c;

    /* renamed from: d */
    public final /* synthetic */ ViewGroup f4658d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0251f(C0253h c0253h, Object obj, ViewGroup viewGroup) {
        super(0);
        this.f4656b = c0253h;
        this.f4657c = obj;
        this.f4658d = viewGroup;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C0253h c0253h = this.f4656b;
        ArrayList arrayList = c0253h.f4663c;
        boolean z = arrayList instanceof Collection;
        FragmentTransitionImpl fragmentTransitionImpl = c0253h.f4666f;
        if (!z || !arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((C0254i) it.next()).getOperation().getIsSeeking()) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Completing animating immediately");
                    }
                    CancellationSignal cancellationSignal = new CancellationSignal();
                    fragmentTransitionImpl.setListenerForTransitionEnd(((C0254i) c0253h.f4663c.get(0)).getOperation().getFragment(), this.f4657c, cancellationSignal, new RunnableC0006a5(12, c0253h));
                    cancellationSignal.cancel();
                    return Unit.INSTANCE;
                }
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Animating to start");
        }
        Object obj = c0253h.f4677q;
        Intrinsics.checkNotNull(obj);
        fragmentTransitionImpl.animateToStart(obj, new RunnableC0583c7(12, c0253h, this.f4658d));
        return Unit.INSTANCE;
    }
}
