package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1155ee;
import p000.C1192fe;
import p000.C1229ge;
import p000.b51;

@Metadata(m5568d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m5569d2 = {"awaitAll", "", ExifInterface.GPS_DIRECTION_TRUE, "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,127:1\n37#2,2:128\n13579#3,2:130\n1855#4,2:132\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n*L\n42#1:128,2\n54#1:130,2\n66#1:132,2\n*E\n"})
/* loaded from: classes2.dex */
public final class AwaitKt {
    @Nullable
    public static final <T> Object awaitAll(@NotNull Deferred<? extends T>[] deferredArr, @NotNull Continuation<? super List<? extends T>> continuation) {
        return deferredArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new C1155ee(deferredArr).m4691a(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object joinAll(@NotNull Collection<? extends Job> collection, @NotNull Continuation<? super Unit> continuation) {
        C1229ge c1229ge;
        int i;
        Iterator it;
        if (continuation instanceof C1229ge) {
            C1229ge c1229ge2 = (C1229ge) continuation;
            int i2 = c1229ge2.f17657f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1229ge2.f17657f = i2 - Integer.MIN_VALUE;
                c1229ge = c1229ge2;
                Object obj = c1229ge.f17656e;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1229ge.f17657f;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    it = collection.iterator();
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = c1229ge.f17655d;
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    Job job = (Job) it.next();
                    c1229ge.f17655d = it;
                    c1229ge.f17657f = 1;
                    if (job.join(c1229ge) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        c1229ge = new ContinuationImpl(continuation);
        Object obj2 = c1229ge.f17656e;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1229ge.f17657f;
        if (i != 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public static final <T> Object awaitAll(@NotNull Collection<? extends Deferred<? extends T>> collection, @NotNull Continuation<? super List<? extends T>> continuation) {
        return collection.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : new C1155ee((Deferred[]) collection.toArray(new Deferred[0])).m4691a(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0052 -> B:10:0x0055). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object joinAll(@NotNull Job[] jobArr, @NotNull Continuation<? super Unit> continuation) {
        C1192fe c1192fe;
        int i;
        int i2;
        Object[] objArr;
        int length;
        if (continuation instanceof C1192fe) {
            C1192fe c1192fe2 = (C1192fe) continuation;
            int i3 = c1192fe2.f17232h;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c1192fe2.f17232h = i3 - Integer.MIN_VALUE;
                c1192fe = c1192fe2;
                Object obj = c1192fe.f17231g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1192fe.f17232h;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    i2 = 0;
                    objArr = jobArr;
                    length = jobArr.length;
                    if (i2 < length) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    length = c1192fe.f17230f;
                    i2 = c1192fe.f17229e;
                    Job[] jobArr2 = (Job[]) c1192fe.f17228d;
                    ResultKt.throwOnFailure(obj);
                    Job[] jobArr3 = jobArr2;
                    i2++;
                    objArr = jobArr3;
                    if (i2 < length) {
                        JobImpl jobImpl = objArr[i2];
                        c1192fe.f17228d = objArr;
                        c1192fe.f17229e = i2;
                        c1192fe.f17230f = length;
                        c1192fe.f17232h = 1;
                        jobArr3 = objArr;
                        if (jobImpl.join(c1192fe) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i2++;
                        objArr = jobArr3;
                        if (i2 < length) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        c1192fe = new ContinuationImpl(continuation);
        Object obj2 = c1192fe.f17231g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1192fe.f17232h;
        if (i != 0) {
        }
    }
}
