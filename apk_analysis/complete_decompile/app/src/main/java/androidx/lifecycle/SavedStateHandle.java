package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.RestrictTo;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1597nt;
import p000.lh1;
import p000.th2;

@Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001f\b\u0016\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0011\u0010\u0014J+\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00018\u0000H\u0087\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010!\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b!\u0010\u001cJ\u001f\u0010#\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\bH\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\u0003H\u0007¢\u0006\u0004\b%\u0010&¨\u0006)"}, m5569d2 = {"Landroidx/lifecycle/SavedStateHandle;", "", "", "", "initialState", "<init>", "(Ljava/util/Map;)V", "()V", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateProvider", "()Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "key", "", "contains", "(Ljava/lang/String;)Z", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "getLiveData", "(Ljava/lang/String;)Landroidx/lifecycle/MutableLiveData;", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "", "keys", "()Ljava/util/Set;", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "value", "", "set", "(Ljava/lang/String;Ljava/lang/Object;)V", "remove", "provider", "setSavedStateProvider", "(Ljava/lang/String;Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;)V", "clearSavedStateProvider", "(Ljava/lang/String;)V", "Companion", "SavingStateLiveData", "lifecycle-viewmodel-savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSavedStateHandle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,450:1\n361#2,3:451\n364#2,4:455\n1#3:454\n*S KotlinDebug\n*F\n+ 1 SavedStateHandle.kt\nandroidx/lifecycle/SavedStateHandle\n*L\n198#1:451,3\n198#1:455,4\n*E\n"})
/* loaded from: classes.dex */
public final class SavedStateHandle {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f */
    public static final Class[] f6532f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a */
    public final LinkedHashMap f6533a;

    /* renamed from: b */
    public final LinkedHashMap f6534b;

    /* renamed from: c */
    public final LinkedHashMap f6535c;

    /* renamed from: d */
    public final LinkedHashMap f6536d;

    /* renamed from: e */
    public final SavedStateRegistry.SavedStateProvider f6537e;

    @Metadata(m5568d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, m5569d2 = {"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "Landroid/os/Bundle;", "restoredState", "defaultState", "Landroidx/lifecycle/SavedStateHandle;", "createHandle", "(Landroid/os/Bundle;Landroid/os/Bundle;)Landroidx/lifecycle/SavedStateHandle;", "value", "", "validateValue", "(Ljava/lang/Object;)Z", "", "Ljava/lang/Class;", "ACCEPTABLE_CLASSES", "[Ljava/lang/Class;", "", "KEYS", "Ljava/lang/String;", "VALUES", "lifecycle-viewmodel-savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public final SavedStateHandle createHandle(@Nullable Bundle restoredState, @Nullable Bundle defaultState) {
            if (restoredState == null) {
                if (defaultState == null) {
                    return new SavedStateHandle();
                }
                HashMap hashMap = new HashMap();
                for (String key : defaultState.keySet()) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    hashMap.put(key, defaultState.get(key));
                }
                return new SavedStateHandle(hashMap);
            }
            ArrayList parcelableArrayList = restoredState.getParcelableArrayList("keys");
            ArrayList parcelableArrayList2 = restoredState.getParcelableArrayList("values");
            if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int size = parcelableArrayList.size();
                for (int i = 0; i < size; i++) {
                    Object obj = parcelableArrayList.get(i);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
                }
                return new SavedStateHandle(linkedHashMap);
            }
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final boolean validateValue(@Nullable Object value) {
            if (value == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.f6532f) {
                Intrinsics.checkNotNull(cls);
                if (cls.isInstance(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    public SavedStateHandle(@NotNull Map<String, ? extends Object> initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f6533a = linkedHashMap;
        this.f6534b = new LinkedHashMap();
        this.f6535c = new LinkedHashMap();
        this.f6536d = new LinkedHashMap();
        this.f6537e = new C1597nt(3, this);
        linkedHashMap.putAll(initialState);
    }

    /* renamed from: a */
    public static Bundle m1535a(SavedStateHandle this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        for (Map.Entry entry : lh1.toMap(this$0.f6534b).entrySet()) {
            this$0.set((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
        }
        LinkedHashMap linkedHashMap = this$0.f6533a;
        Set<String> keySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str : keySet) {
            arrayList.add(str);
            arrayList2.add(linkedHashMap.get(str));
        }
        return BundleKt.bundleOf(TuplesKt.m5575to("keys", arrayList), TuplesKt.m5575to("values", arrayList2));
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final SavedStateHandle createHandle(@Nullable Bundle bundle, @Nullable Bundle bundle2) {
        return INSTANCE.createHandle(bundle, bundle2);
    }

    /* renamed from: b */
    public final MutableLiveData m1536b(boolean z, String str, Object obj) {
        MutableLiveData mutableLiveData;
        SavingStateLiveData savingStateLiveData;
        LinkedHashMap linkedHashMap = this.f6535c;
        Object obj2 = linkedHashMap.get(str);
        if (obj2 instanceof MutableLiveData) {
            mutableLiveData = (MutableLiveData) obj2;
        } else {
            mutableLiveData = null;
        }
        if (mutableLiveData != null) {
            return mutableLiveData;
        }
        LinkedHashMap linkedHashMap2 = this.f6533a;
        if (linkedHashMap2.containsKey(str)) {
            savingStateLiveData = new SavingStateLiveData(this, str, linkedHashMap2.get(str));
        } else if (z) {
            linkedHashMap2.put(str, obj);
            savingStateLiveData = new SavingStateLiveData(this, str, obj);
        } else {
            savingStateLiveData = new SavingStateLiveData(this, str);
        }
        linkedHashMap.put(str, savingStateLiveData);
        return savingStateLiveData;
    }

    @MainThread
    public final void clearSavedStateProvider(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f6534b.remove(key);
    }

    @MainThread
    public final boolean contains(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f6533a.containsKey(key);
    }

    @MainThread
    @Nullable
    public final <T> T get(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return (T) this.f6533a.get(key);
        } catch (ClassCastException unused) {
            remove(key);
            return null;
        }
    }

    @MainThread
    @NotNull
    public final <T> MutableLiveData<T> getLiveData(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        MutableLiveData<T> m1536b = m1536b(false, key, null);
        Intrinsics.checkNotNull(m1536b, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<T of androidx.lifecycle.SavedStateHandle.getLiveData>");
        return m1536b;
    }

    @MainThread
    @NotNull
    public final <T> StateFlow<T> getStateFlow(@NotNull String key, T initialValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        LinkedHashMap linkedHashMap = this.f6536d;
        Object obj = linkedHashMap.get(key);
        if (obj == null) {
            LinkedHashMap linkedHashMap2 = this.f6533a;
            if (!linkedHashMap2.containsKey(key)) {
                linkedHashMap2.put(key, initialValue);
            }
            obj = StateFlowKt.MutableStateFlow(linkedHashMap2.get(key));
            linkedHashMap.put(key, obj);
            linkedHashMap.put(key, obj);
        }
        StateFlow<T> asStateFlow = FlowKt.asStateFlow((MutableStateFlow) obj);
        Intrinsics.checkNotNull(asStateFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.SavedStateHandle.getStateFlow>");
        return asStateFlow;
    }

    @MainThread
    @NotNull
    public final Set<String> keys() {
        return th2.plus(th2.plus(this.f6533a.keySet(), (Iterable) this.f6534b.keySet()), (Iterable) this.f6535c.keySet());
    }

    @MainThread
    @Nullable
    public final <T> T remove(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this.f6533a.remove(key);
        SavingStateLiveData savingStateLiveData = (SavingStateLiveData) this.f6535c.remove(key);
        if (savingStateLiveData != null) {
            savingStateLiveData.detach();
        }
        this.f6536d.remove(key);
        return t;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    /* renamed from: savedStateProvider, reason: from getter */
    public final SavedStateRegistry.SavedStateProvider getF6537e() {
        return this.f6537e;
    }

    @MainThread
    public final <T> void set(@NotNull String key, @Nullable T value) {
        MutableLiveData mutableLiveData;
        Intrinsics.checkNotNullParameter(key, "key");
        if (INSTANCE.validateValue(value)) {
            Object obj = this.f6535c.get(key);
            if (obj instanceof MutableLiveData) {
                mutableLiveData = (MutableLiveData) obj;
            } else {
                mutableLiveData = null;
            }
            if (mutableLiveData != null) {
                mutableLiveData.setValue(value);
            } else {
                this.f6533a.put(key, value);
            }
            MutableStateFlow mutableStateFlow = (MutableStateFlow) this.f6536d.get(key);
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(value);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder("Can't put value with type ");
        Intrinsics.checkNotNull(value);
        sb.append(value.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }

    @MainThread
    public final void setSavedStateProvider(@NotNull String key, @NotNull SavedStateRegistry.SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f6534b.put(key, provider);
    }

    @MainThread
    @NotNull
    public final <T> MutableLiveData<T> getLiveData(@NotNull String key, T initialValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return m1536b(true, key, initialValue);
    }

    @Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B#\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m5569d2 = {"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/SavedStateHandle;", "handle", "", "key", "value", "<init>", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "", "setValue", "(Ljava/lang/Object;)V", "detach", "()V", "lifecycle-viewmodel-savedstate_release"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes.dex */
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {

        /* renamed from: l */
        public final String f6538l;

        /* renamed from: m */
        public SavedStateHandle f6539m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavingStateLiveData(@Nullable SavedStateHandle savedStateHandle, @NotNull String key, T t) {
            super(t);
            Intrinsics.checkNotNullParameter(key, "key");
            this.f6538l = key;
            this.f6539m = savedStateHandle;
        }

        public final void detach() {
            this.f6539m = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T value) {
            SavedStateHandle savedStateHandle = this.f6539m;
            if (savedStateHandle != null) {
                Map map = savedStateHandle.f6533a;
                String str = this.f6538l;
                map.put(str, value);
                MutableStateFlow mutableStateFlow = (MutableStateFlow) savedStateHandle.f6536d.get(str);
                if (mutableStateFlow != null) {
                    mutableStateFlow.setValue(value);
                }
            }
            super.setValue(value);
        }

        public SavingStateLiveData(@Nullable SavedStateHandle savedStateHandle, @NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f6538l = key;
            this.f6539m = savedStateHandle;
        }
    }

    public SavedStateHandle() {
        this.f6533a = new LinkedHashMap();
        this.f6534b = new LinkedHashMap();
        this.f6535c = new LinkedHashMap();
        this.f6536d = new LinkedHashMap();
        this.f6537e = new C1597nt(3, this);
    }
}
