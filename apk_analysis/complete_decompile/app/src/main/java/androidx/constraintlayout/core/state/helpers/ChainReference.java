package androidx.constraintlayout.core.state.helpers;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ChainReference extends HelperReference {

    /* renamed from: O */
    public HashMap f2396O;

    /* renamed from: P */
    public HashMap f2397P;
    protected float mBias;

    @NonNull
    @Deprecated
    protected HashMap<String, Float> mMapPostMargin;

    @NonNull
    @Deprecated
    protected HashMap<String, Float> mMapPreMargin;

    @NonNull
    @Deprecated
    protected HashMap<String, Float> mMapWeights;

    @NonNull
    protected State.Chain mStyle;

    public ChainReference(@NonNull State state, @NonNull State.Helper helper) {
        super(state, helper);
        this.mBias = 0.5f;
        this.mMapWeights = new HashMap<>();
        this.mMapPreMargin = new HashMap<>();
        this.mMapPostMargin = new HashMap<>();
        this.mStyle = State.Chain.SPREAD;
    }

    public void addChainElement(@NonNull String str, float f, float f2, float f3) {
        addChainElement(str, f, f2, f3, RecyclerView.f7068F0, RecyclerView.f7068F0);
    }

    /* renamed from: c */
    public final float m466c(String str) {
        HashMap hashMap = this.f2397P;
        if (hashMap != null && hashMap.containsKey(str)) {
            return ((Float) this.f2397P.get(str)).floatValue();
        }
        return RecyclerView.f7068F0;
    }

    /* renamed from: d */
    public final float m467d(String str) {
        HashMap hashMap = this.f2396O;
        if (hashMap != null && hashMap.containsKey(str)) {
            return ((Float) this.f2396O.get(str)).floatValue();
        }
        return RecyclerView.f7068F0;
    }

    public float getBias() {
        return this.mBias;
    }

    public float getPostMargin(@NonNull String str) {
        if (this.mMapPostMargin.containsKey(str)) {
            return this.mMapPostMargin.get(str).floatValue();
        }
        return RecyclerView.f7068F0;
    }

    public float getPreMargin(@NonNull String str) {
        if (this.mMapPreMargin.containsKey(str)) {
            return this.mMapPreMargin.get(str).floatValue();
        }
        return RecyclerView.f7068F0;
    }

    @NonNull
    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    public float getWeight(@NonNull String str) {
        if (this.mMapWeights.containsKey(str)) {
            return this.mMapWeights.get(str).floatValue();
        }
        return -1.0f;
    }

    @NonNull
    public ChainReference style(@NonNull State.Chain chain) {
        this.mStyle = chain;
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void addChainElement(@NonNull Object obj, float f, float f2, float f3, float f4, float f5) {
        super.add(obj);
        String obj2 = obj.toString();
        if (!Float.isNaN(f)) {
            this.mMapWeights.put(obj2, Float.valueOf(f));
        }
        if (!Float.isNaN(f2)) {
            this.mMapPreMargin.put(obj2, Float.valueOf(f2));
        }
        if (!Float.isNaN(f3)) {
            this.mMapPostMargin.put(obj2, Float.valueOf(f3));
        }
        if (!Float.isNaN(f4)) {
            if (this.f2396O == null) {
                this.f2396O = new HashMap();
            }
            this.f2396O.put(obj2, Float.valueOf(f4));
        }
        if (Float.isNaN(f5)) {
            return;
        }
        if (this.f2397P == null) {
            this.f2397P = new HashMap();
        }
        this.f2397P.put(obj2, Float.valueOf(f5));
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    @NonNull
    public ChainReference bias(float f) {
        this.mBias = f;
        return this;
    }
}
