package androidx.collection;

import com.hisona.allive.CardPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [V, K] */
@Metadata(m5568d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m5569d2 = {"androidx/collection/LruCacheKt$lruCache$4", "Landroidx/collection/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = CardPresenter.CARD_HEIGHT)
@SourceDebugExtension({"SMAP\nLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LruCache.kt\nandroidx/collection/LruCacheKt$lruCache$4\n*L\n1#1,355:1\n*E\n"})
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {

    /* renamed from: j */
    public final /* synthetic */ Function2 f1702j;

    /* renamed from: k */
    public final /* synthetic */ Function1 f1703k;

    /* renamed from: l */
    public final /* synthetic */ Function4 f1704l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(int i, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        super(i);
        this.f1702j = function2;
        this.f1703k = function1;
        this.f1704l = function4;
    }

    @Override // androidx.collection.LruCache
    @Nullable
    public V create(@NotNull K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (V) this.f1703k.invoke(key);
    }

    @Override // androidx.collection.LruCache
    public void entryRemoved(boolean evicted, @NotNull K key, @NotNull V oldValue, @Nullable V newValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        this.f1704l.invoke(Boolean.valueOf(evicted), key, oldValue, newValue);
    }

    @Override // androidx.collection.LruCache
    public int sizeOf(@NotNull K key, @NotNull V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return ((Number) this.f1702j.invoke(key, value)).intValue();
    }
}
