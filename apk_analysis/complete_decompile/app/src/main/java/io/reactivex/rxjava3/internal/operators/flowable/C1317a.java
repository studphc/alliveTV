package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.flowables.GroupedFlowable;
import org.reactivestreams.Subscriber;

/* renamed from: io.reactivex.rxjava3.internal.operators.flowable.a */
/* loaded from: classes2.dex */
public final class C1317a extends GroupedFlowable {

    /* renamed from: d */
    public static final /* synthetic */ int f19099d = 0;

    /* renamed from: c */
    public final C1318b f19100c;

    public C1317a(Object obj, C1318b c1318b) {
        super(obj);
        this.f19100c = c1318b;
    }

    @Override // io.reactivex.rxjava3.core.Flowable
    public final void subscribeActual(Subscriber subscriber) {
        this.f19100c.subscribe(subscriber);
    }
}
