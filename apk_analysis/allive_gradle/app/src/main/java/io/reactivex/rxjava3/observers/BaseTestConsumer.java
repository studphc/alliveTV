package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.VolatileSizeArrayList;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class BaseTestConsumer<T, U extends BaseTestConsumer<T, U>> {
    protected boolean checkSubscriptionOnce;
    protected long completions;
    protected Thread lastThread;
    protected CharSequence tag;
    protected boolean timeout;
    protected final List<T> values = new VolatileSizeArrayList();
    protected final List<Throwable> errors = new VolatileSizeArrayList();
    protected final CountDownLatch done = new CountDownLatch(1);

    @NonNull
    public static String valueAndClass(@Nullable Object obj) {
        if (obj != null) {
            return obj + " (class: " + obj.getClass().getSimpleName() + ")";
        }
        return "null";
    }

    /* renamed from: a */
    public final void m5303a(Predicate predicate, boolean z) {
        int size = this.errors.size();
        if (size != 0) {
            Iterator<Throwable> it = this.errors.iterator();
            while (it.hasNext()) {
                try {
                    if (predicate.test(it.next())) {
                        if (size != 1) {
                            if (z) {
                                throw fail("Error present but other errors as well");
                            }
                            throw fail("One error passed the predicate but other errors are present as well");
                        }
                        return;
                    }
                } catch (Throwable th) {
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
            if (z) {
                throw fail("Error not present");
            }
            throw fail("No error(s) passed the predicate");
        }
        throw fail("No errors");
    }

    @NonNull
    public final U assertComplete() {
        long j = this.completions;
        if (j != 0) {
            if (j <= 1) {
                return this;
            }
            throw fail("Multiple completions: " + j);
        }
        throw fail("Not completed");
    }

    @NonNull
    public final U assertEmpty() {
        return (U) assertSubscribed().assertNoValues().assertNoErrors().assertNotComplete();
    }

    @NonNull
    public final U assertError(@NonNull Throwable th) {
        m5303a(Functions.equalsWith(th), true);
        return this;
    }

    @SafeVarargs
    @NonNull
    public final U assertFailure(@NonNull Class<? extends Throwable> cls, @NonNull T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertError(cls).assertNotComplete();
    }

    @NonNull
    public final U assertNoErrors() {
        if (this.errors.size() == 0) {
            return this;
        }
        throw fail("Error(s) present: " + this.errors);
    }

    @NonNull
    public final U assertNoValues() {
        return assertValueCount(0);
    }

    @NonNull
    public final U assertNotComplete() {
        long j = this.completions;
        if (j != 1) {
            if (j <= 1) {
                return this;
            }
            throw fail("Multiple completions: " + j);
        }
        throw fail("Completed!");
    }

    @SafeVarargs
    @NonNull
    public final U assertResult(@NonNull T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertComplete();
    }

    @NonNull
    public abstract U assertSubscribed();

    @NonNull
    public final U assertValue(@NonNull T t) {
        if (this.values.size() == 1) {
            T t2 = this.values.get(0);
            if (Objects.equals(t, t2)) {
                return this;
            }
            throw fail("\nexpected: " + valueAndClass(t) + "\ngot: " + valueAndClass(t2));
        }
        throw fail("\nexpected: " + valueAndClass(t) + "\ngot: " + this.values);
    }

    @NonNull
    public final U assertValueAt(int i, @NonNull T t) {
        int size = this.values.size();
        if (size == 0) {
            throw fail("No values");
        }
        if (i >= 0 && i < size) {
            T t2 = this.values.get(i);
            if (Objects.equals(t, t2)) {
                return this;
            }
            throw fail("\nexpected: " + valueAndClass(t) + "\ngot: " + valueAndClass(t2) + "; Value at position " + i + " differ");
        }
        throw fail("Index " + i + " is out of range [0, " + size + ")");
    }

    @NonNull
    public final U assertValueCount(int i) {
        int size = this.values.size();
        if (size == i) {
            return this;
        }
        throw fail("\nexpected: " + i + "\ngot: " + size + "; Value counts differ");
    }

    @NonNull
    public final U assertValueSequence(@NonNull Iterable<? extends T> iterable) {
        boolean hasNext;
        boolean hasNext2;
        Iterator<T> it = this.values.iterator();
        Iterator<? extends T> it2 = iterable.iterator();
        int i = 0;
        while (true) {
            hasNext = it2.hasNext();
            hasNext2 = it.hasNext();
            if (!hasNext2 || !hasNext) {
                break;
            }
            T next = it2.next();
            T next2 = it.next();
            if (Objects.equals(next, next2)) {
                i++;
            } else {
                throw fail("\nexpected: " + valueAndClass(next) + "\ngot: " + valueAndClass(next2) + "; Value at position " + i + " differ");
            }
        }
        if (!hasNext2) {
            if (!hasNext) {
                return this;
            }
            throw fail("Fewer values received than expected (" + i + ")");
        }
        throw fail("More values received than expected (" + i + ")");
    }

    @SafeVarargs
    @NonNull
    public final U assertValues(@NonNull T... tArr) {
        int size = this.values.size();
        if (size == tArr.length) {
            for (int i = 0; i < size; i++) {
                T t = this.values.get(i);
                T t2 = tArr[i];
                if (!Objects.equals(t2, t)) {
                    throw fail("\nexpected: " + valueAndClass(t2) + "\ngot: " + valueAndClass(t) + "; Value at position " + i + " differ");
                }
            }
            return this;
        }
        throw fail("\nexpected: " + tArr.length + " " + Arrays.toString(tArr) + "\ngot: " + size + " " + this.values + "; Value count differs");
    }

    @SafeVarargs
    @NonNull
    public final U assertValuesOnly(@NonNull T... tArr) {
        return (U) assertSubscribed().assertValues(tArr).assertNoErrors().assertNotComplete();
    }

    @NonNull
    public final U await() {
        if (this.done.getCount() == 0) {
            return this;
        }
        this.done.await();
        return this;
    }

    @NonNull
    public final U awaitCount(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - currentTimeMillis >= 5000) {
                this.timeout = true;
                break;
            }
            if (this.done.getCount() == 0 || this.values.size() >= i) {
                break;
            }
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }

    @NonNull
    public final U awaitDone(long j, @NonNull TimeUnit timeUnit) {
        try {
            if (!this.done.await(j, timeUnit)) {
                this.timeout = true;
                dispose();
            }
            return this;
        } catch (InterruptedException e) {
            dispose();
            throw ExceptionHelper.wrapOrThrow(e);
        }
    }

    public abstract void dispose();

    @NonNull
    public final AssertionError fail(@NonNull String str) {
        StringBuilder sb = new StringBuilder(str.length() + 64);
        sb.append(str);
        sb.append(" (latch = ");
        sb.append(this.done.getCount());
        sb.append(", values = ");
        sb.append(this.values.size());
        sb.append(", errors = ");
        sb.append(this.errors.size());
        sb.append(", completions = ");
        sb.append(this.completions);
        if (this.timeout) {
            sb.append(", timeout!");
        }
        if (isDisposed()) {
            sb.append(", disposed!");
        }
        CharSequence charSequence = this.tag;
        if (charSequence != null) {
            sb.append(", tag = ");
            sb.append(charSequence);
        }
        sb.append(')');
        AssertionError assertionError = new AssertionError(sb.toString());
        if (!this.errors.isEmpty()) {
            if (this.errors.size() == 1) {
                assertionError.initCause(this.errors.get(0));
            } else {
                assertionError.initCause(new CompositeException(this.errors));
            }
        }
        return assertionError;
    }

    public abstract boolean isDisposed();

    @NonNull
    public final List<T> values() {
        return this.values;
    }

    @NonNull
    public final U withTag(@Nullable CharSequence charSequence) {
        this.tag = charSequence;
        return this;
    }

    @NonNull
    public final U assertError(@NonNull Class<? extends Throwable> cls) {
        m5303a(Functions.isInstanceOf(cls), true);
        return this;
    }

    @NonNull
    public final U assertError(@NonNull Predicate<Throwable> predicate) {
        m5303a(predicate, false);
        return this;
    }

    public final boolean await(long j, @NonNull TimeUnit timeUnit) {
        boolean z = this.done.getCount() == 0 || this.done.await(j, timeUnit);
        this.timeout = !z;
        return z;
    }

    @NonNull
    public final U assertValue(@NonNull Predicate<T> predicate) {
        assertValueAt(0, (Predicate) predicate);
        if (this.values.size() <= 1) {
            return this;
        }
        throw fail("The first value passed the predicate but this consumer received more than one value");
    }

    @NonNull
    public final U assertValueAt(int i, @NonNull Predicate<T> predicate) {
        int size = this.values.size();
        if (size == 0) {
            throw fail("No values");
        }
        if (i >= 0 && i < size) {
            T t = this.values.get(i);
            try {
                if (predicate.test(t)) {
                    return this;
                }
                throw fail("Value " + valueAndClass(t) + " at position " + i + " did not pass the predicate");
            } catch (Throwable th) {
                throw ExceptionHelper.wrapOrThrow(th);
            }
        }
        throw fail("Index " + i + " is out of range [0, " + size + ")");
    }
}
