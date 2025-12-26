package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class rs2 implements FlowableSubscriber {

    /* renamed from: a */
    public static final rs2 f26124a;

    /* renamed from: b */
    public static final /* synthetic */ rs2[] f26125b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [rs2, java.lang.Enum] */
    static {
        ?? r1 = new Enum("INSTANCE", 0);
        f26124a = r1;
        f26125b = new rs2[]{r1};
    }

    public static rs2 valueOf(String str) {
        return (rs2) Enum.valueOf(rs2.class, str);
    }

    public static rs2[] values() {
        return (rs2[]) f26125b.clone();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
    }

    @Override // io.reactivex.rxjava3.core.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription subscription) {
    }
}
