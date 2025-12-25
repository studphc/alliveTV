package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* renamed from: androidx.fragment.app.g */
/* loaded from: classes.dex */
public final class C0252g extends Lambda implements Function0 {

    /* renamed from: b */
    public final /* synthetic */ C0253h f4659b;

    /* renamed from: c */
    public final /* synthetic */ ViewGroup f4660c;

    /* renamed from: d */
    public final /* synthetic */ Object f4661d;

    /* renamed from: e */
    public final /* synthetic */ Ref.ObjectRef f4662e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0252g(C0253h c0253h, ViewGroup viewGroup, Object obj, Ref.ObjectRef objectRef) {
        super(0);
        this.f4659b = c0253h;
        this.f4660c = viewGroup;
        this.f4661d = obj;
        this.f4662e = objectRef;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, androidx.fragment.app.f] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C0253h c0253h = this.f4659b;
        FragmentTransitionImpl fragmentTransitionImpl = c0253h.f4666f;
        ViewGroup viewGroup = this.f4660c;
        Object obj = this.f4661d;
        Object controlDelayedTransition = fragmentTransitionImpl.controlDelayedTransition(viewGroup, obj);
        c0253h.f4677q = controlDelayedTransition;
        if (controlDelayedTransition != null) {
            this.f4662e.element = new C0251f(c0253h, obj, viewGroup);
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v(FragmentManager.TAG, "Started executing operations from " + c0253h.f4664d + " to " + c0253h.f4665e);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(("Unable to start transition " + obj + " for container " + viewGroup + '.').toString());
    }
}
