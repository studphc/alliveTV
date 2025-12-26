package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Function5;
import io.reactivex.rxjava3.functions.Function6;
import io.reactivex.rxjava3.functions.Function7;
import io.reactivex.rxjava3.functions.Function8;
import io.reactivex.rxjava3.functions.Function9;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;
import p000.C1540m9;
import p000.C1741qy;
import p000.C1995xt;
import p000.a80;
import p000.b01;
import p000.cn0;
import p000.dx0;
import p000.ev0;
import p000.fp0;
import p000.hn0;
import p000.hv0;
import p000.jz2;
import p000.mv0;
import p000.nj0;
import p000.nv0;
import p000.pv0;
import p000.qv0;
import p000.rv0;
import p000.tm0;
import p000.wd0;

/* loaded from: classes2.dex */
public final class Functions {

    /* renamed from: a */
    public static final nv0 f18517a = new Object();
    public static final Runnable EMPTY_RUNNABLE = new a80(1);
    public static final Action EMPTY_ACTION = new Object();

    /* renamed from: b */
    public static final hv0 f18518b = new hv0(0);
    public static final Consumer<Throwable> ERROR_CONSUMER = new hv0(1);
    public static final Consumer<Throwable> ON_ERROR_MISSING = new hv0(3);
    public static final LongConsumer EMPTY_LONG_CONSUMER = new Object();

    /* renamed from: c */
    public static final dx0 f18519c = new dx0(17);

    /* renamed from: d */
    public static final wd0 f18520d = new wd0(17);

    /* renamed from: e */
    public static final fp0 f18521e = new fp0(1);
    public static final Consumer<Subscription> REQUEST_MAX = new hv0(2);

    /* loaded from: classes2.dex */
    public static class BoundedConsumer implements Consumer<Subscription> {

        /* renamed from: a */
        public final int f18522a;

        public BoundedConsumer(int i) {
            this.f18522a = i;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Subscription subscription) {
            subscription.request(this.f18522a);
        }
    }

    public static <T> Consumer<T> actionConsumer(Action action) {
        return new tm0(2, action);
    }

    @NonNull
    public static <T> Predicate<T> alwaysFalse() {
        return f18520d;
    }

    @NonNull
    public static <T> Predicate<T> alwaysTrue() {
        return f18519c;
    }

    public static <T> Consumer<T> boundedConsumer(int i) {
        return new BoundedConsumer(i);
    }

    @NonNull
    public static <T, U> Function<T, U> castFunction(@NonNull Class<U> cls) {
        return new nj0(10, cls);
    }

    public static <T> Supplier<List<T>> createArrayList(int i) {
        return new ev0(i);
    }

    public static <T> Supplier<Set<T>> createHashSet() {
        return mv0.f23135a;
    }

    public static <T> Consumer<T> emptyConsumer() {
        return f18518b;
    }

    public static <T> Predicate<T> equalsWith(T t) {
        return new C1741qy(t);
    }

    @NonNull
    public static Action futureAction(@NonNull Future<?> future) {
        return new hn0(1, future);
    }

    @NonNull
    public static <T> Function<T, T> identity() {
        return f18517a;
    }

    public static <T, U> Predicate<T> isInstanceOf(Class<U> cls) {
        return new C1995xt(cls);
    }

    @NonNull
    public static <T> Callable<T> justCallable(@NonNull T t) {
        return new pv0(t);
    }

    @NonNull
    public static <T, U> Function<T, U> justFunction(@NonNull U u) {
        return new pv0(u);
    }

    @NonNull
    public static <T> Supplier<T> justSupplier(@NonNull T t) {
        return new pv0(t);
    }

    public static <T> Function<List<T>, List<T>> listSorter(Comparator<? super T> comparator) {
        return new nj0(11, comparator);
    }

    public static <T> Comparator<T> naturalComparator() {
        return qv0.f25768a;
    }

    public static <T> Action notificationOnComplete(Consumer<? super Notification<T>> consumer) {
        return new hn0(2, consumer);
    }

    public static <T> Consumer<Throwable> notificationOnError(Consumer<? super Notification<T>> consumer) {
        return new rv0(consumer, 0);
    }

    public static <T> Consumer<T> notificationOnNext(Consumer<? super Notification<T>> consumer) {
        return new rv0(consumer, 1);
    }

    @NonNull
    public static <T> Supplier<T> nullSupplier() {
        return f18521e;
    }

    public static <T> Predicate<T> predicateReverseFor(BooleanSupplier booleanSupplier) {
        return new b01(17, booleanSupplier);
    }

    public static <T> Function<T, Timed<T>> timestampWith(TimeUnit timeUnit, Scheduler scheduler) {
        return new cn0(2, timeUnit, scheduler);
    }

    @NonNull
    public static <T1, T2, R> Function<Object[], R> toFunction(@NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        return new nj0(2, biFunction);
    }

    public static <T, K> BiConsumer<Map<K, T>, T> toMapKeySelector(Function<? super T, ? extends K> function) {
        return new b01(18, function);
    }

    public static <T, K, V> BiConsumer<Map<K, V>, T> toMapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return new C1540m9(12, function2, function);
    }

    public static <T, K, V> BiConsumer<Map<K, Collection<V>>, T> toMultimapKeyValueSelector(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Function<? super K, ? extends Collection<? super V>> function3) {
        return new jz2(function3, function2, function, 3);
    }

    @NonNull
    public static <T1, T2, T3, R> Function<Object[], R> toFunction(@NonNull Function3<T1, T2, T3, R> function3) {
        return new nj0(3, function3);
    }

    @NonNull
    public static <T1, T2, T3, T4, R> Function<Object[], R> toFunction(@NonNull Function4<T1, T2, T3, T4, R> function4) {
        return new nj0(4, function4);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, R> Function<Object[], R> toFunction(@NonNull Function5<T1, T2, T3, T4, T5, R> function5) {
        return new nj0(5, function5);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, R> Function<Object[], R> toFunction(@NonNull Function6<T1, T2, T3, T4, T5, T6, R> function6) {
        return new nj0(6, function6);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, R> Function<Object[], R> toFunction(@NonNull Function7<T1, T2, T3, T4, T5, T6, T7, R> function7) {
        return new nj0(7, function7);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Function<Object[], R> toFunction(@NonNull Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function8) {
        return new nj0(8, function8);
    }

    @NonNull
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Function<Object[], R> toFunction(@NonNull Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function9) {
        return new nj0(9, function9);
    }
}
