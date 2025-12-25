package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1807sq;
import p000.ov2;
import p000.pv2;
import p000.qv2;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001aB\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001c\u0010\u0005\u001a\u0018\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u0007\u0012\t\u0012\u0007H\u0004¢\u0006\u0002\b\u00070\u0006H\u0007\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\tH\u0007\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\u0010\u0005\u001a \u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u0007\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u00070\u0006H\u0007\u001a>\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00010\tH\u0007¨\u0006\f"}, m5569d2 = {"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "mapFunction", "Landroidx/arch/core/util/Function;", "switchMap", "switchMapFunction", "lifecycle-livedata_release"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@JvmName(name = "Transformations")
/* loaded from: classes.dex */
public final class Transformations {
    @JvmName(name = "distinctUntilChanged")
    @NotNull
    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(@NotNull LiveData<X> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(liveData.getValue());
            booleanRef.element = false;
        }
        mediatorLiveData.addSource(liveData, new pv2(new ov2(mediatorLiveData, booleanRef)));
        return mediatorLiveData;
    }

    @JvmName(name = "map")
    @NotNull
    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(@NotNull LiveData<X> liveData, @NotNull Function1<X, Y> transform) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new pv2(new C1807sq(6, mediatorLiveData, transform)));
        return mediatorLiveData;
    }

    @JvmName(name = "switchMap")
    @NotNull
    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(@NotNull LiveData<X> liveData, @NotNull final Function1<X, LiveData<Y>> transform) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations$switchMap$1

            /* renamed from: a, reason: from kotlin metadata */
            public LiveData liveData;

            @Nullable
            public final LiveData<Y> getLiveData() {
                return this.liveData;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(X value) {
                LiveData liveData2 = (LiveData) Function1.this.invoke(value);
                LiveData liveData3 = this.liveData;
                if (liveData3 == liveData2) {
                    return;
                }
                MediatorLiveData mediatorLiveData2 = mediatorLiveData;
                if (liveData3 != null) {
                    Intrinsics.checkNotNull(liveData3);
                    mediatorLiveData2.removeSource(liveData3);
                }
                this.liveData = liveData2;
                if (liveData2 != null) {
                    Intrinsics.checkNotNull(liveData2);
                    mediatorLiveData2.addSource(liveData2, new pv2(new qv2(mediatorLiveData2, 0)));
                }
            }

            public final void setLiveData(@Nullable LiveData<Y> liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }

    @JvmName(name = "map")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function mapFunction) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(mapFunction, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new pv2(new C1807sq(7, mediatorLiveData, mapFunction)));
        return mediatorLiveData;
    }

    @JvmName(name = "switchMap")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, final Function switchMapFunction) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(switchMapFunction, "switchMapFunction");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer() { // from class: androidx.lifecycle.Transformations$switchMap$2

            /* renamed from: a, reason: from kotlin metadata */
            public LiveData liveData;

            @Nullable
            public final LiveData getLiveData() {
                return this.liveData;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(Object value) {
                LiveData liveData2 = (LiveData) Function.this.apply(value);
                LiveData liveData3 = this.liveData;
                if (liveData3 == liveData2) {
                    return;
                }
                MediatorLiveData mediatorLiveData2 = mediatorLiveData;
                if (liveData3 != null) {
                    Intrinsics.checkNotNull(liveData3);
                    mediatorLiveData2.removeSource(liveData3);
                }
                this.liveData = liveData2;
                if (liveData2 != null) {
                    Intrinsics.checkNotNull(liveData2);
                    mediatorLiveData2.addSource(liveData2, new pv2(new qv2(mediatorLiveData2, 1)));
                }
            }

            public final void setLiveData(@Nullable LiveData liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }
}
