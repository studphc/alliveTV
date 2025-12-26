package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class Timed<T> {

    /* renamed from: a */
    public final Object f20094a;

    /* renamed from: b */
    public final long f20095b;

    /* renamed from: c */
    public final TimeUnit f20096c;

    public Timed(@NonNull T t, long j, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(t, "value is null");
        this.f20094a = t;
        this.f20095b = j;
        Objects.requireNonNull(timeUnit, "unit is null");
        this.f20096c = timeUnit;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!Objects.equals(this.f20094a, timed.f20094a) || this.f20095b != timed.f20095b || !Objects.equals(this.f20096c, timed.f20096c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.f20094a.hashCode() * 31;
        long j = this.f20095b;
        return this.f20096c.hashCode() + ((hashCode + ((int) (j ^ (j >>> 31)))) * 31);
    }

    public long time() {
        return this.f20095b;
    }

    public String toString() {
        return "Timed[time=" + this.f20095b + ", unit=" + this.f20096c + ", value=" + this.f20094a + "]";
    }

    @NonNull
    public TimeUnit unit() {
        return this.f20096c;
    }

    @NonNull
    public T value() {
        return (T) this.f20094a;
    }

    public long time(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.f20095b, this.f20096c);
    }
}
