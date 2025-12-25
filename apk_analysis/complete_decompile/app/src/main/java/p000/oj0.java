package p000;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: classes2.dex */
public final class oj0 extends SubscriptionArbiter implements FlowableSubscriber {
    private static final long serialVersionUID = -8158322871608889516L;

    /* renamed from: h */
    public final Subscriber f23821h;

    /* renamed from: i */
    public final Publisher[] f23822i;

    /* renamed from: j */
    public final boolean f23823j;

    /* renamed from: k */
    public final AtomicInteger f23824k;

    /* renamed from: l */
    public int f23825l;

    /* renamed from: m */
    public ArrayList f23826m;

    /* renamed from: n */
    public long f23827n;

    public oj0(Publisher[] publisherArr, boolean z, Subscriber subscriber) {
        super(false);
        this.f23821h = subscriber;
        this.f23822i = publisherArr;
        this.f23823j = z;
        this.f23824k = new AtomicInteger();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        AtomicInteger atomicInteger = this.f23824k;
        if (atomicInteger.getAndIncrement() == 0) {
            Publisher[] publisherArr = this.f23822i;
            int length = publisherArr.length;
            int i = this.f23825l;
            while (true) {
                Subscriber subscriber = this.f23821h;
                if (i == length) {
                    ArrayList arrayList = this.f23826m;
                    if (arrayList != null) {
                        if (arrayList.size() == 1) {
                            subscriber.onError((Throwable) arrayList.get(0));
                            return;
                        } else {
                            subscriber.onError(new CompositeException(arrayList));
                            return;
                        }
                    }
                    subscriber.onComplete();
                    return;
                }
                Publisher publisher = publisherArr[i];
                if (publisher == null) {
                    NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                    if (this.f23823j) {
                        ArrayList arrayList2 = this.f23826m;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList((length - i) + 1);
                            this.f23826m = arrayList2;
                        }
                        arrayList2.add(nullPointerException);
                        i++;
                    } else {
                        subscriber.onError(nullPointerException);
                        return;
                    }
                } else {
                    long j = this.f23827n;
                    if (j != 0) {
                        this.f23827n = 0L;
                        produced(j);
                    }
                    publisher.subscribe(this);
                    i++;
                    this.f23825l = i;
                    if (atomicInteger.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        if (this.f23823j) {
            ArrayList arrayList = this.f23826m;
            if (arrayList == null) {
                arrayList = new ArrayList((this.f23822i.length - this.f23825l) + 1);
                this.f23826m = arrayList;
            }
            arrayList.add(th);
            onComplete();
            return;
        }
        this.f23821h.onError(th);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(Object obj) {
        this.f23827n++;
        this.f23821h.onNext(obj);
    }
}
