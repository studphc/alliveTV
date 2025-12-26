package p000;

import androidx.collection.ObjectList;
import androidx.collection.ScatterSet;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractMap;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KTypeProjection;
import kotlin.sequences.Sequence;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.sync.SemaphoreImpl;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.DiskLruCache;
import okio.ForwardingFileSystem;
import okio.Path;

/* renamed from: v */
/* loaded from: classes2.dex */
public final class C1891v extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f27557b;

    /* renamed from: c */
    public final /* synthetic */ Object f27558c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1891v(int i, Object obj) {
        super(1);
        this.f27557b = i;
        this.f27558c = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object it) {
        Throwable th;
        Throwable th2 = null;
        Object obj = this.f27558c;
        switch (this.f27557b) {
            case 0:
                if (it == ((AbstractCollection) obj)) {
                    return "(this Collection)";
                }
                return String.valueOf(it);
            case 1:
                Map.Entry it2 = (Map.Entry) it;
                Intrinsics.checkNotNullParameter(it2, "it");
                return AbstractMap.access$toString((AbstractMap) obj, it2);
            case 2:
                Throwable th3 = (Throwable) it;
                for (ReceiveChannel receiveChannel : (ReceiveChannel[]) obj) {
                    try {
                        ChannelsKt.cancelConsumed(receiveChannel, th3);
                    } catch (Throwable th4) {
                        if (th2 == null) {
                            th2 = th4;
                        } else {
                            ha0.addSuppressed(th2, th4);
                        }
                    }
                }
                if (th2 == null) {
                    return Unit.INSTANCE;
                }
                throw th2;
            case 3:
                Intrinsics.checkNotNullParameter((IOException) it, "it");
                DiskLruCache diskLruCache = (DiskLruCache) obj;
                if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                    throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
                }
                DiskLruCache.access$setHasJournalErrors$p(diskLruCache, true);
                return Unit.INSTANCE;
            case 4:
                Throwable th5 = (Throwable) it;
                ?? r4 = (Lambda) obj;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Throwable th6 = (Throwable) r4.invoke(th5);
                    if (!Intrinsics.areEqual(th5.getMessage(), th6.getMessage()) && !Intrinsics.areEqual(th6.getMessage(), th5.toString())) {
                        th6 = null;
                    }
                    th = Result.m8512constructorimpl(th6);
                } catch (Throwable th7) {
                    Result.Companion companion2 = Result.INSTANCE;
                    th = Result.m8512constructorimpl(ResultKt.createFailure(th7));
                }
                if (!Result.m8517isFailureimpl(th)) {
                    th2 = th;
                }
                return th2;
            case 5:
                Path it3 = (Path) it;
                Intrinsics.checkNotNullParameter(it3, "it");
                return ((ForwardingFileSystem) obj).onPathResult(it3, "listRecursively");
            case 6:
                Throwable th8 = (Throwable) it;
                if (th8 == null) {
                    ((CompletableFuture) obj).complete(Unit.INSTANCE);
                } else {
                    ((CompletableFuture) obj).completeExceptionally(th8);
                }
                return Unit.INSTANCE;
            case 7:
                return ((MatcherMatchResult$groups$1) obj).get(((Number) it).intValue());
            case 8:
                if (it == ((ObjectList) obj)) {
                    return "(this)";
                }
                return String.valueOf(it);
            case 9:
                Result.Companion companion3 = Result.INSTANCE;
                Unit unit = Unit.INSTANCE;
                ((CancellableContinuationImpl) obj).resumeWith(Result.m8512constructorimpl(unit));
                return unit;
            case 10:
                if (it == ((ScatterSet) obj)) {
                    return "(this)";
                }
                return String.valueOf(it);
            case 11:
                ((SemaphoreImpl) obj).release();
                return Unit.INSTANCE;
            case 12:
                Intrinsics.checkNotNullParameter(it, "it");
                return ((Function0) obj).invoke();
            case 13:
                return Boolean.valueOf(((Class) obj).isInstance(it));
            case 14:
                IndexedValue it4 = (IndexedValue) it;
                Intrinsics.checkNotNullParameter(it4, "it");
                return (Boolean) ((Function2) obj).invoke(Integer.valueOf(it4.getIndex()), it4.getValue());
            case 15:
                return Boolean.valueOf(ArraysKt___ArraysKt.contains((Object[]) obj, it));
            case 16:
                return Boolean.valueOf(((List) obj).contains(it));
            case 17:
                if (it != null) {
                    return it;
                }
                throw new IllegalArgumentException("null element found in " + ((Sequence) obj) + '.');
            default:
                KTypeProjection it5 = (KTypeProjection) it;
                Intrinsics.checkNotNullParameter(it5, "it");
                return TypeReference.access$asString((TypeReference) obj, it5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C1891v(Function1 function1) {
        super(1);
        this.f27557b = 4;
        this.f27558c = (Lambda) function1;
    }
}
