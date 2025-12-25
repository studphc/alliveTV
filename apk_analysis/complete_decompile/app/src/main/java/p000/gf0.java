package p000;

import java.util.concurrent.Flow;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class gf0 implements Publisher {

    /* renamed from: a */
    public final Flow.Publisher f17679a;

    public gf0(Flow.Publisher publisher) {
        this.f17679a = publisher;
    }

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber subscriber) {
        ef0 ef0Var;
        Flow.Publisher publisher = this.f17679a;
        if (subscriber == null) {
            ef0Var = null;
        } else {
            ef0Var = new ef0(subscriber);
        }
        publisher.subscribe(ef0Var);
    }
}
