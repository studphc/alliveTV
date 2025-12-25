package p000;

import java.util.concurrent.Flow;
import org.reactivestreams.Publisher;

/* loaded from: classes2.dex */
public final class cf0 implements Flow.Publisher {

    /* renamed from: a */
    public final Publisher f8351a;

    public cf0(Publisher publisher) {
        this.f8351a = publisher;
    }

    @Override // java.util.concurrent.Flow.Publisher
    public final void subscribe(Flow.Subscriber subscriber) {
        if0 if0Var;
        Publisher publisher = this.f8351a;
        if (subscriber == null) {
            if0Var = null;
        } else {
            if0Var = new if0(subscriber);
        }
        publisher.subscribe(if0Var);
    }
}
