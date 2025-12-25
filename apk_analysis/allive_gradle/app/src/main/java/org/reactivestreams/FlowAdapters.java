package org.reactivestreams;

import java.util.Objects;
import java.util.concurrent.Flow;
import p000.AbstractC1673p3;
import p000.cf0;
import p000.df0;
import p000.ef0;
import p000.gf0;
import p000.hf0;
import p000.if0;

/* loaded from: classes2.dex */
public final class FlowAdapters {
    public static <T, U> Flow.Processor<T, U> toFlowProcessor(Processor<? super T, ? extends U> processor) {
        Objects.requireNonNull(processor, "reactiveStreamsProcessor");
        if (processor instanceof hf0) {
            return ((hf0) processor).f18045a;
        }
        if (AbstractC1673p3.m6827x(processor)) {
            return AbstractC1673p3.m6810g(processor);
        }
        return new df0(processor);
    }

    public static <T> Flow.Publisher<T> toFlowPublisher(Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "reactiveStreamsPublisher");
        if (publisher instanceof gf0) {
            return ((gf0) publisher).f17679a;
        }
        if (AbstractC1673p3.m6828y(publisher)) {
            return AbstractC1673p3.m6811h(publisher);
        }
        return new cf0(publisher);
    }

    public static <T> Flow.Subscriber<T> toFlowSubscriber(Subscriber<T> subscriber) {
        Objects.requireNonNull(subscriber, "reactiveStreamsSubscriber");
        if (subscriber instanceof if0) {
            return ((if0) subscriber).f18393a;
        }
        if (AbstractC1673p3.m6829z(subscriber)) {
            return AbstractC1673p3.m6812i(subscriber);
        }
        return new ef0(subscriber);
    }

    public static <T, U> Processor<T, U> toProcessor(Flow.Processor<? super T, ? extends U> processor) {
        Objects.requireNonNull(processor, "flowProcessor");
        if (processor instanceof df0) {
            return ((df0) processor).f16355a;
        }
        if (processor instanceof Processor) {
            return (Processor) processor;
        }
        return new hf0(processor);
    }

    public static <T> Publisher<T> toPublisher(Flow.Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "flowPublisher");
        if (publisher instanceof cf0) {
            return ((cf0) publisher).f8351a;
        }
        if (publisher instanceof Publisher) {
            return (Publisher) publisher;
        }
        return new gf0(publisher);
    }

    public static <T> Subscriber<T> toSubscriber(Flow.Subscriber<T> subscriber) {
        Objects.requireNonNull(subscriber, "flowSubscriber");
        if (subscriber instanceof ef0) {
            return ((ef0) subscriber).f16784a;
        }
        if (subscriber instanceof Subscriber) {
            return (Subscriber) subscriber;
        }
        return new if0(subscriber);
    }
}
