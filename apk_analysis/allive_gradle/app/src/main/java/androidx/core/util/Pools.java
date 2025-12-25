package androidx.core.util;

import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, m5569d2 = {"Landroidx/core/util/Pools;", "", "Pool", "SimplePool", "SynchronizedPool", "core_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class Pools {

    @Metadata(m5568d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, m5569d2 = {"Landroidx/core/util/Pools$Pool;", ExifInterface.GPS_DIRECTION_TRUE, "", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "core_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NotNull T instance);
    }

    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m5569d2 = {"Landroidx/core/util/Pools$SimplePool;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/core/util/Pools$Pool;", "", "maxPoolSize", "<init>", "(I)V", "acquire", "()Ljava/lang/Object;", "instance", "", "release", "(Ljava/lang/Object;)Z", "core_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SimplePool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    /* loaded from: classes.dex */
    public static class SimplePool<T> implements Pool<T> {

        /* renamed from: a */
        public final Object[] f3827a;

        /* renamed from: b */
        public int f3828b;

        public SimplePool(@IntRange(from = 1) int i) {
            if (i > 0) {
                this.f3827a = new Object[i];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        @Override // androidx.core.util.Pools.Pool
        @Nullable
        public T acquire() {
            int i = this.f3828b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.f3827a;
            T t = (T) objArr[i2];
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
            objArr[i2] = null;
            this.f3828b--;
            return t;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NotNull T instance) {
            Object[] objArr;
            boolean z;
            Intrinsics.checkNotNullParameter(instance, "instance");
            int i = this.f3828b;
            int i2 = 0;
            while (true) {
                objArr = this.f3827a;
                if (i2 < i) {
                    if (objArr[i2] == instance) {
                        z = true;
                        break;
                    }
                    i2++;
                } else {
                    z = false;
                    break;
                }
            }
            if (!z) {
                int i3 = this.f3828b;
                if (i3 >= objArr.length) {
                    return false;
                }
                objArr[i3] = instance;
                this.f3828b = i3 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    @Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m5569d2 = {"Landroidx/core/util/Pools$SynchronizedPool;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/core/util/Pools$SimplePool;", "", "maxPoolSize", "<init>", "(I)V", "acquire", "()Ljava/lang/Object;", "instance", "", "release", "(Ljava/lang/Object;)Z", "core_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nPools.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pools.kt\nandroidx/core/util/Pools$SynchronizedPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
    /* loaded from: classes.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {

        /* renamed from: c */
        public final Object f3829c;

        public SynchronizedPool(int i) {
            super(i);
            this.f3829c = new Object();
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        @Nullable
        public T acquire() {
            T t;
            synchronized (this.f3829c) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // androidx.core.util.Pools.SimplePool, androidx.core.util.Pools.Pool
        public boolean release(@NotNull T instance) {
            boolean release;
            Intrinsics.checkNotNullParameter(instance, "instance");
            synchronized (this.f3829c) {
                release = super.release(instance);
            }
            return release;
        }
    }
}
