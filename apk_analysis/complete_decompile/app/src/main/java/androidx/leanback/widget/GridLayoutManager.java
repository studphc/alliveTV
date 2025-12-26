package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.CircularIntArray;
import androidx.collection.LruCache;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.ItemAlignmentFacet;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Map;
import p000.C1617oc;
import p000.RunnableC1104d;
import p000.jz2;
import p000.m53;
import p000.mt2;
import p000.tx0;
import p000.ux0;
import p000.vx0;
import p000.xx0;
import p000.ye0;
import p000.yx0;
import p000.zx0;

/* loaded from: classes.dex */
public final class GridLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: m0 */
    public static final Rect f5672m0 = new Rect();

    /* renamed from: n0 */
    public static final int[] f5673n0 = new int[2];

    /* renamed from: A */
    public int[] f5674A;

    /* renamed from: B */
    public AudioManager f5675B;

    /* renamed from: C */
    public RecyclerView.Recycler f5676C;

    /* renamed from: D */
    public int f5677D;

    /* renamed from: E */
    public OnChildSelectedListener f5678E;

    /* renamed from: F */
    public ArrayList f5679F;

    /* renamed from: G */
    public ArrayList f5680G;

    /* renamed from: H */
    public OnChildLaidOutListener f5681H;

    /* renamed from: I */
    public int f5682I;

    /* renamed from: J */
    public int f5683J;

    /* renamed from: K */
    public yx0 f5684K;

    /* renamed from: L */
    public zx0 f5685L;

    /* renamed from: M */
    public int f5686M;

    /* renamed from: N */
    public int f5687N;

    /* renamed from: O */
    public int f5688O;

    /* renamed from: P */
    public int f5689P;

    /* renamed from: Q */
    public int f5690Q;

    /* renamed from: R */
    public int f5691R;

    /* renamed from: S */
    public int[] f5692S;

    /* renamed from: T */
    public int f5693T;

    /* renamed from: U */
    public int f5694U;

    /* renamed from: V */
    public int f5695V;

    /* renamed from: W */
    public int f5696W;

    /* renamed from: X */
    public int f5697X;

    /* renamed from: Y */
    public int f5698Y;

    /* renamed from: Z */
    public int f5699Z;

    /* renamed from: a0 */
    public int f5700a0;

    /* renamed from: b0 */
    public ux0 f5701b0;

    /* renamed from: c0 */
    public int f5702c0;

    /* renamed from: d0 */
    public final mt2 f5703d0;

    /* renamed from: e0 */
    public final jz2 f5704e0;

    /* renamed from: f0 */
    public int f5705f0;

    /* renamed from: g0 */
    public int f5706g0;

    /* renamed from: h0 */
    public final int[] f5707h0;

    /* renamed from: i0 */
    public final C1617oc f5708i0;

    /* renamed from: j0 */
    public FacetProviderAdapter f5709j0;

    /* renamed from: k0 */
    public final RunnableC1104d f5710k0;

    /* renamed from: l0 */
    public final vx0 f5711l0;

    /* renamed from: q */
    public float f5712q;

    /* renamed from: r */
    public int f5713r;

    /* renamed from: s */
    public BaseGridView f5714s;

    /* renamed from: t */
    public int f5715t;

    /* renamed from: u */
    public OrientationHelper f5716u;

    /* renamed from: v */
    public int f5717v;

    /* renamed from: w */
    public RecyclerView.State f5718w;

    /* renamed from: x */
    public int f5719x;

    /* renamed from: y */
    public int f5720y;

    /* renamed from: z */
    public final SparseIntArray f5721z;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Object();

        /* renamed from: a */
        public int f5722a;

        /* renamed from: b */
        public Bundle f5723b;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f5722a);
            parcel.writeBundle(this.f5723b);
        }
    }

    public GridLayoutManager() {
        this(null);
    }

    /* renamed from: p */
    public static int m1394p(View view) {
        C0377q0 c0377q0;
        if (view == null || (c0377q0 = (C0377q0) view.getLayoutParams()) == null || c0377q0.isItemRemoved()) {
            return -1;
        }
        return c0377q0.getAbsoluteAdapterPosition();
    }

    /* renamed from: z */
    public static int m1395z(View view, View view2) {
        ItemAlignmentFacet itemAlignmentFacet;
        if (view != null && view2 != null && (itemAlignmentFacet = ((C0377q0) view.getLayoutParams()).f6405l) != null) {
            ItemAlignmentFacet.ItemAlignmentDef[] alignmentDefs = itemAlignmentFacet.getAlignmentDefs();
            if (alignmentDefs.length > 1) {
                while (view2 != view) {
                    int id = view2.getId();
                    if (id != -1) {
                        for (int i = 1; i < alignmentDefs.length; i++) {
                            if (alignmentDefs[i].getItemAlignmentFocusViewId() == id) {
                                return i;
                            }
                        }
                    }
                    view2 = (View) view2.getParent();
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: A */
    public final View m1396A(int i) {
        Object obj;
        FacetProviderAdapter facetProviderAdapter;
        FacetProvider facetProvider;
        View viewForPosition = this.f5676C.getViewForPosition(i);
        C0377q0 c0377q0 = (C0377q0) viewForPosition.getLayoutParams();
        RecyclerView.ViewHolder childViewHolder = this.f5714s.getChildViewHolder(viewForPosition);
        if (childViewHolder instanceof FacetProvider) {
            obj = ((FacetProvider) childViewHolder).getFacet(ItemAlignmentFacet.class);
        } else {
            obj = null;
        }
        if (obj == null && (facetProviderAdapter = this.f5709j0) != null && (facetProvider = facetProviderAdapter.getFacetProvider(childViewHolder.getItemViewType())) != null) {
            obj = facetProvider.getFacet(ItemAlignmentFacet.class);
        }
        c0377q0.f6405l = (ItemAlignmentFacet) obj;
        return viewForPosition;
    }

    /* renamed from: B */
    public final boolean m1397B() {
        if (getItemCount() != 0 && this.f5714s.findViewHolderForAdapterPosition(0) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: C */
    public final boolean m1398C() {
        int itemCount = getItemCount();
        if (itemCount == 0 || this.f5714s.findViewHolderForAdapterPosition(itemCount - 1) != null) {
            return true;
        }
        return false;
    }

    /* renamed from: D */
    public final boolean m1399D(int i) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.f5714s.findViewHolderForAdapterPosition(i);
        if (findViewHolderForAdapterPosition == null || findViewHolderForAdapterPosition.itemView.getLeft() < 0 || findViewHolderForAdapterPosition.itemView.getRight() > this.f5714s.getWidth() || findViewHolderForAdapterPosition.itemView.getTop() < 0 || findViewHolderForAdapterPosition.itemView.getBottom() > this.f5714s.getHeight()) {
            return false;
        }
        return true;
    }

    /* renamed from: E */
    public final void m1400E(View view, int i, int i2, int i3, int i4) {
        int m1427r;
        int i5;
        int m1429t;
        int i6;
        if (this.f5715t == 0) {
            m1427r = m1426q(view);
        } else {
            m1427r = m1427r(view);
        }
        int i7 = this.f5691R;
        if (i7 > 0) {
            m1427r = Math.min(m1427r, i7);
        }
        int i8 = this.f5698Y;
        int i9 = i8 & 112;
        if ((this.f5677D & 786432) != 0) {
            i5 = Gravity.getAbsoluteGravity(i8 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK, 1);
        } else {
            i5 = i8 & 7;
        }
        int i10 = this.f5715t;
        if ((i10 != 0 || i9 != 48) && (i10 != 1 || i5 != 3)) {
            if ((i10 == 0 && i9 == 80) || (i10 == 1 && i5 == 5)) {
                m1429t = m1429t(i) - m1427r;
            } else if ((i10 == 0 && i9 == 16) || (i10 == 1 && i5 == 1)) {
                m1429t = (m1429t(i) - m1427r) / 2;
            }
            i4 += m1429t;
        }
        if (this.f5715t == 0) {
            i6 = m1427r + i4;
        } else {
            int i11 = m1427r + i4;
            int i12 = i4;
            i4 = i2;
            i2 = i12;
            i6 = i3;
            i3 = i11;
        }
        C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
        layoutDecoratedWithMargins(view, i2, i4, i3, i6);
        Rect rect = f5672m0;
        super.getDecoratedBoundsWithMargins(view, rect);
        int i13 = i2 - rect.left;
        int i14 = i4 - rect.top;
        int i15 = rect.right - i3;
        int i16 = rect.bottom - i6;
        c0377q0.f6398e = i13;
        c0377q0.f6399f = i14;
        c0377q0.f6400g = i15;
        c0377q0.f6401h = i16;
        m1418W(view);
    }

    /* renamed from: F */
    public final void m1401F() {
        int i = this.f5717v - 1;
        this.f5717v = i;
        if (i == 0) {
            this.f5676C = null;
            this.f5718w = null;
            this.f5719x = 0;
            this.f5720y = 0;
        }
    }

    /* renamed from: G */
    public final void m1402G(View view) {
        int makeMeasureSpec;
        int childMeasureSpec;
        int i;
        C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
        Rect rect = f5672m0;
        calculateItemDecorationsForChild(view, rect);
        int i2 = ((ViewGroup.MarginLayoutParams) c0377q0).leftMargin + ((ViewGroup.MarginLayoutParams) c0377q0).rightMargin + rect.left + rect.right;
        int i3 = ((ViewGroup.MarginLayoutParams) c0377q0).topMargin + ((ViewGroup.MarginLayoutParams) c0377q0).bottomMargin + rect.top + rect.bottom;
        if (this.f5690Q == -2) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f5691R, 1073741824);
        }
        if (this.f5715t == 0) {
            childMeasureSpec = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i2, ((ViewGroup.MarginLayoutParams) c0377q0).width);
            i = ViewGroup.getChildMeasureSpec(makeMeasureSpec, i3, ((ViewGroup.MarginLayoutParams) c0377q0).height);
        } else {
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), i3, ((ViewGroup.MarginLayoutParams) c0377q0).height);
            childMeasureSpec = ViewGroup.getChildMeasureSpec(makeMeasureSpec, i2, ((ViewGroup.MarginLayoutParams) c0377q0).width);
            i = childMeasureSpec2;
        }
        view.measure(childMeasureSpec, i);
    }

    /* renamed from: H */
    public final void m1403H() {
        int i;
        ux0 ux0Var = this.f5701b0;
        if ((this.f5677D & 262144) != 0) {
            i = this.f5705f0 + this.f5706g0 + this.f5720y;
        } else {
            i = (-this.f5706g0) - this.f5720y;
        }
        ux0Var.mo7278m(i, false);
    }

    /* renamed from: I */
    public final void m1404I(boolean z) {
        int i;
        int i2;
        boolean z2;
        if (z) {
            if (m1398C()) {
                return;
            }
        } else if (m1397B()) {
            return;
        }
        zx0 zx0Var = this.f5685L;
        int i3 = 1;
        if (zx0Var == null) {
            if (z) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            if (this.f5699Z > 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            zx0 zx0Var2 = new zx0(this, i2, z2);
            this.f5686M = 0;
            startSmoothScroll(zx0Var2);
        } else {
            GridLayoutManager gridLayoutManager = zx0Var.f29556p;
            if (z) {
                int i4 = zx0Var.f29555o;
                if (i4 < gridLayoutManager.f5713r) {
                    zx0Var.f29555o = i4 + 1;
                }
            } else {
                int i5 = zx0Var.f29555o;
                if (i5 > (-gridLayoutManager.f5713r)) {
                    zx0Var.f29555o = i5 - 1;
                }
            }
        }
        if (this.f5715t == 0) {
            i = 4;
            if (getLayoutDirection() != 1 ? !z : z) {
                i = 3;
            }
        } else {
            if (z) {
                i3 = 2;
            }
            i = i3;
        }
        if (this.f5675B == null) {
            this.f5675B = (AudioManager) this.f5714s.getContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        }
        this.f5675B.playSoundEffect(i);
    }

    /* renamed from: J */
    public final boolean m1405J(boolean z) {
        CircularIntArray[] mo7276j;
        CircularIntArray circularIntArray;
        int size;
        int i;
        int m1427r;
        if (this.f5691R != 0 || this.f5692S == null) {
            return false;
        }
        ux0 ux0Var = this.f5701b0;
        if (ux0Var == null) {
            mo7276j = null;
        } else {
            mo7276j = ux0Var.mo7276j(ux0Var.f27517f, ux0Var.f27518g);
        }
        boolean z2 = false;
        int i2 = -1;
        for (int i3 = 0; i3 < this.f5699Z; i3++) {
            if (mo7276j == null) {
                circularIntArray = null;
            } else {
                circularIntArray = mo7276j[i3];
            }
            if (circularIntArray == null) {
                size = 0;
            } else {
                size = circularIntArray.size();
            }
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5 += 2) {
                int i6 = circularIntArray.get(i5 + 1);
                for (int i7 = circularIntArray.get(i5); i7 <= i6; i7++) {
                    View findViewByPosition = findViewByPosition(i7 - this.f5719x);
                    if (findViewByPosition != null) {
                        if (z) {
                            m1402G(findViewByPosition);
                        }
                        if (this.f5715t == 0) {
                            m1427r = m1426q(findViewByPosition);
                        } else {
                            m1427r = m1427r(findViewByPosition);
                        }
                        if (m1427r > i4) {
                            i4 = m1427r;
                        }
                    }
                }
            }
            int itemCount = this.f5718w.getItemCount();
            if (!this.f5714s.hasFixedSize() && z && i4 < 0 && itemCount > 0) {
                if (i2 < 0) {
                    int i8 = this.f5682I;
                    if (i8 < 0) {
                        i8 = 0;
                    } else if (i8 >= itemCount) {
                        i8 = itemCount - 1;
                    }
                    if (getChildCount() > 0) {
                        int layoutPosition = this.f5714s.getChildViewHolder(getChildAt(0)).getLayoutPosition();
                        int layoutPosition2 = this.f5714s.getChildViewHolder(getChildAt(getChildCount() - 1)).getLayoutPosition();
                        if (i8 >= layoutPosition && i8 <= layoutPosition2) {
                            i8 = i8 - layoutPosition <= layoutPosition2 - i8 ? layoutPosition - 1 : layoutPosition2 + 1;
                            if (i8 < 0 && layoutPosition2 < itemCount - 1) {
                                i8 = layoutPosition2 + 1;
                            } else if (i8 >= itemCount && layoutPosition > 0) {
                                i8 = layoutPosition - 1;
                            }
                        }
                    }
                    if (i8 >= 0 && i8 < itemCount) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                        View viewForPosition = this.f5676C.getViewForPosition(i8);
                        int[] iArr = this.f5707h0;
                        if (viewForPosition != null) {
                            C0377q0 c0377q0 = (C0377q0) viewForPosition.getLayoutParams();
                            Rect rect = f5672m0;
                            calculateItemDecorationsForChild(viewForPosition, rect);
                            viewForPosition.measure(ViewGroup.getChildMeasureSpec(makeMeasureSpec, getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0377q0).leftMargin + ((ViewGroup.MarginLayoutParams) c0377q0).rightMargin + rect.left + rect.right, ((ViewGroup.MarginLayoutParams) c0377q0).width), ViewGroup.getChildMeasureSpec(makeMeasureSpec2, getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0377q0).topMargin + ((ViewGroup.MarginLayoutParams) c0377q0).bottomMargin + rect.top + rect.bottom, ((ViewGroup.MarginLayoutParams) c0377q0).height));
                            iArr[0] = m1427r(viewForPosition);
                            iArr[1] = m1426q(viewForPosition);
                            this.f5676C.recycleView(viewForPosition);
                        }
                        if (this.f5715t == 0) {
                            i = iArr[1];
                        } else {
                            i = iArr[0];
                        }
                        i2 = i;
                    }
                }
                if (i2 >= 0) {
                    i4 = i2;
                }
            }
            if (i4 < 0) {
                i4 = 0;
            }
            int[] iArr2 = this.f5692S;
            if (iArr2[i3] != i4) {
                iArr2[i3] = i4;
                z2 = true;
            }
        }
        return z2;
    }

    /* renamed from: K */
    public final int m1406K(int i, boolean z) {
        int i2;
        int i3;
        int i4;
        tx0 mo7277k;
        ux0 ux0Var = this.f5701b0;
        if (ux0Var == null) {
            return i;
        }
        int i5 = this.f5682I;
        if (i5 != -1 && (mo7277k = ux0Var.mo7277k(i5)) != null) {
            i2 = mo7277k.f27011a;
        } else {
            i2 = -1;
        }
        int childCount = getChildCount();
        View view = null;
        for (int i6 = 0; i6 < childCount && i != 0; i6++) {
            if (i > 0) {
                i3 = i6;
            } else {
                i3 = (childCount - 1) - i6;
            }
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (!hasFocus() || childAt.hasFocusable())) {
                int m1394p = m1394p(getChildAt(i3));
                tx0 mo7277k2 = this.f5701b0.mo7277k(m1394p);
                if (mo7277k2 == null) {
                    i4 = -1;
                } else {
                    i4 = mo7277k2.f27011a;
                }
                if (i2 == -1) {
                    i5 = m1394p;
                    view = childAt;
                    i2 = i4;
                } else if (i4 == i2 && ((i > 0 && m1394p > i5) || (i < 0 && m1394p < i5))) {
                    i = i > 0 ? i - 1 : i + 1;
                    i5 = m1394p;
                    view = childAt;
                }
            }
        }
        if (view != null) {
            if (z) {
                if (hasFocus()) {
                    this.f5677D |= 32;
                    view.requestFocus();
                    this.f5677D &= -33;
                }
                this.f5682I = i5;
                this.f5683J = 0;
            } else {
                m1414S(view, true);
            }
        }
        return i;
    }

    /* renamed from: L */
    public final void m1407L() {
        int i;
        int i2 = this.f5677D;
        if ((65600 & i2) == 65536) {
            ux0 ux0Var = this.f5701b0;
            int i3 = this.f5682I;
            if ((i2 & 262144) != 0) {
                i = -this.f5706g0;
            } else {
                i = this.f5705f0 + this.f5706g0;
            }
            while (true) {
                int i4 = ux0Var.f27518g;
                if (i4 < ux0Var.f27517f || i4 <= i3) {
                    break;
                }
                if (!ux0Var.f27514c) {
                    if (ux0Var.f27513b.m7949d(i4) < i) {
                        break;
                    }
                    ux0Var.f27513b.m7951f(ux0Var.f27518g);
                    ux0Var.f27518g--;
                } else {
                    if (ux0Var.f27513b.m7949d(i4) > i) {
                        break;
                    }
                    ux0Var.f27513b.m7951f(ux0Var.f27518g);
                    ux0Var.f27518g--;
                }
            }
            if (ux0Var.f27518g < ux0Var.f27517f) {
                ux0Var.f27518g = -1;
                ux0Var.f27517f = -1;
            }
        }
    }

    /* renamed from: M */
    public final void m1408M() {
        int i;
        int i2 = this.f5677D;
        if ((65600 & i2) == 65536) {
            ux0 ux0Var = this.f5701b0;
            int i3 = this.f5682I;
            if ((i2 & 262144) != 0) {
                i = this.f5705f0 + this.f5706g0;
            } else {
                i = -this.f5706g0;
            }
            while (true) {
                int i4 = ux0Var.f27518g;
                int i5 = ux0Var.f27517f;
                if (i4 < i5 || i5 >= i3) {
                    break;
                }
                int m7950e = ux0Var.f27513b.m7950e(i5);
                if (!ux0Var.f27514c) {
                    if (ux0Var.f27513b.m7949d(ux0Var.f27517f) + m7950e > i) {
                        break;
                    }
                    ux0Var.f27513b.m7951f(ux0Var.f27517f);
                    ux0Var.f27517f++;
                } else {
                    if (ux0Var.f27513b.m7949d(ux0Var.f27517f) - m7950e < i) {
                        break;
                    }
                    ux0Var.f27513b.m7951f(ux0Var.f27517f);
                    ux0Var.f27517f++;
                }
            }
            if (ux0Var.f27518g < ux0Var.f27517f) {
                ux0Var.f27518g = -1;
                ux0Var.f27517f = -1;
            }
        }
    }

    /* renamed from: N */
    public final void m1409N(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i = this.f5717v;
        if (i == 0) {
            this.f5676C = recycler;
            this.f5718w = state;
            this.f5719x = 0;
            this.f5720y = 0;
        }
        this.f5717v = i + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r7 <= r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r7 >= r0) goto L21;
     */
    /* renamed from: O */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m1410O(int i) {
        boolean z;
        int i2;
        int i3 = this.f5677D;
        boolean z2 = true;
        if ((i3 & 64) == 0 && (i3 & 3) != 1) {
            mt2 mt2Var = this.f5703d0;
            if (i > 0) {
                m53 m53Var = (m53) mt2Var.f23109d;
                if (m53Var.f22806a != Integer.MAX_VALUE) {
                    i2 = m53Var.f22808c;
                }
            } else if (i < 0) {
                m53 m53Var2 = (m53) mt2Var.f23109d;
                if (m53Var2.f22807b != Integer.MIN_VALUE) {
                    i2 = m53Var2.f22809d;
                }
            }
        }
        if (i == 0) {
            return 0;
        }
        int i4 = -i;
        int childCount = getChildCount();
        if (this.f5715t == 1) {
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).offsetTopAndBottom(i4);
            }
        } else {
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).offsetLeftAndRight(i4);
            }
        }
        if ((this.f5677D & 3) == 1) {
            m1421Z();
            return i;
        }
        int childCount2 = getChildCount();
        if ((this.f5677D & 262144) == 0 ? i < 0 : i > 0) {
            m1403H();
        } else {
            m1423m();
        }
        if (getChildCount() > childCount2) {
            z = true;
        } else {
            z = false;
        }
        int childCount3 = getChildCount();
        if ((262144 & this.f5677D) == 0 ? i < 0 : i > 0) {
            m1407L();
        } else {
            m1408M();
        }
        if (getChildCount() >= childCount3) {
            z2 = false;
        }
        if (z | z2) {
            m1420Y();
        }
        this.f5714s.invalidate();
        m1421Z();
        return i;
    }

    /* renamed from: P */
    public final int m1411P(int i) {
        int i2 = 0;
        if (i == 0) {
            return 0;
        }
        int i3 = -i;
        int childCount = getChildCount();
        if (this.f5715t == 0) {
            while (i2 < childCount) {
                getChildAt(i2).offsetTopAndBottom(i3);
                i2++;
            }
        } else {
            while (i2 < childCount) {
                getChildAt(i2).offsetLeftAndRight(i3);
                i2++;
            }
        }
        this.f5689P += i;
        m1422a0();
        this.f5714s.invalidate();
        return i;
    }

    /* renamed from: Q */
    public final void m1412Q(int i, int i2, int i3, boolean z) {
        this.f5687N = i3;
        View findViewByPosition = findViewByPosition(i);
        boolean isSmoothScrolling = isSmoothScrolling();
        if (!isSmoothScrolling && !this.f5714s.isLayoutRequested() && findViewByPosition != null && m1394p(findViewByPosition) == i) {
            this.f5677D |= 32;
            m1414S(findViewByPosition, z);
            this.f5677D &= -33;
            return;
        }
        int i4 = this.f5677D;
        if ((i4 & 512) != 0 && (i4 & 64) == 0) {
            if (z && !this.f5714s.isLayoutRequested()) {
                this.f5682I = i;
                this.f5683J = i2;
                this.f5686M = Integer.MIN_VALUE;
                if (this.f5701b0 != null) {
                    xx0 xx0Var = new xx0(this);
                    xx0Var.setTargetPosition(i);
                    startSmoothScroll(xx0Var);
                    int targetPosition = xx0Var.getTargetPosition();
                    if (targetPosition != this.f5682I) {
                        this.f5682I = targetPosition;
                        this.f5683J = 0;
                        return;
                    }
                    return;
                }
                Log.w("GridLayoutManager:" + this.f5714s.getId(), "setSelectionSmooth should not be called before first layout pass");
                return;
            }
            if (isSmoothScrolling) {
                yx0 yx0Var = this.f5684K;
                if (yx0Var != null) {
                    yx0Var.f29159l = true;
                }
                this.f5714s.stopScroll();
            }
            if (!this.f5714s.isLayoutRequested() && findViewByPosition != null && m1394p(findViewByPosition) == i) {
                this.f5677D |= 32;
                m1414S(findViewByPosition, z);
                this.f5677D &= -33;
                return;
            } else {
                this.f5682I = i;
                this.f5683J = i2;
                this.f5686M = Integer.MIN_VALUE;
                this.f5677D |= 256;
                requestLayout();
                return;
            }
        }
        this.f5682I = i;
        this.f5683J = i2;
        this.f5686M = Integer.MIN_VALUE;
    }

    /* renamed from: R */
    public final void m1413R(View view, View view2, boolean z, int i, int i2) {
        if ((this.f5677D & 64) != 0) {
            return;
        }
        int m1394p = m1394p(view);
        int m1395z = m1395z(view, view2);
        if (m1394p != this.f5682I || m1395z != this.f5683J) {
            this.f5682I = m1394p;
            this.f5683J = m1395z;
            this.f5686M = 0;
            if ((this.f5677D & 3) != 1) {
                m1424n();
            }
            if (this.f5714s.m1687I()) {
                this.f5714s.invalidate();
            }
        }
        if (view == null) {
            return;
        }
        if (!view.hasFocus() && this.f5714s.hasFocus()) {
            view.requestFocus();
        }
        if ((this.f5677D & 131072) == 0 && z) {
            return;
        }
        int[] iArr = f5673n0;
        if (m1431v(view, view2, iArr) || i != 0 || i2 != 0) {
            int i3 = iArr[0] + i;
            int i4 = iArr[1] + i2;
            if ((this.f5677D & 3) == 1) {
                m1410O(i3);
                m1411P(i4);
                return;
            }
            if (this.f5715t != 0) {
                i4 = i3;
                i3 = i4;
            }
            if (z) {
                this.f5714s.smoothScrollBy(i3, i4);
            } else {
                this.f5714s.scrollBy(i3, i4);
                m1425o();
            }
        }
    }

    /* renamed from: S */
    public final void m1414S(View view, boolean z) {
        m1413R(view, view.findFocus(), z, 0, 0);
    }

    /* renamed from: T */
    public final void m1415T(int i) {
        if (i < 0 && i != -2) {
            throw new IllegalArgumentException(ye0.m8291k(i, "Invalid row height: "));
        }
        this.f5690Q = i;
    }

    /* renamed from: U */
    public final void m1416U(int i, int i2, int i3, boolean z) {
        if ((this.f5682I != i && i != -1) || i2 != this.f5683J || i3 != this.f5687N) {
            m1412Q(i, i2, i3, z);
        }
    }

    /* renamed from: V */
    public final void m1417V() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            m1418W(getChildAt(i));
        }
    }

    /* renamed from: W */
    public final void m1418W(View view) {
        C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
        ItemAlignmentFacet itemAlignmentFacet = c0377q0.f6405l;
        jz2 jz2Var = this.f5704e0;
        if (itemAlignmentFacet == null) {
            C0334f1 c0334f1 = (C0334f1) jz2Var.f20699c;
            c0377q0.f6402i = AbstractC0338g1.m1499a(view, c0334f1, c0334f1.f6296g);
            C0334f1 c0334f12 = (C0334f1) jz2Var.f20698b;
            c0377q0.f6403j = AbstractC0338g1.m1499a(view, c0334f12, c0334f12.f6296g);
            return;
        }
        int i = this.f5715t;
        ItemAlignmentFacet.ItemAlignmentDef[] alignmentDefs = itemAlignmentFacet.getAlignmentDefs();
        int[] iArr = c0377q0.f6404k;
        if (iArr == null || iArr.length != alignmentDefs.length) {
            c0377q0.f6404k = new int[alignmentDefs.length];
        }
        for (int i2 = 0; i2 < alignmentDefs.length; i2++) {
            c0377q0.f6404k[i2] = AbstractC0338g1.m1499a(view, alignmentDefs[i2], i);
        }
        if (i == 0) {
            c0377q0.f6402i = c0377q0.f6404k[0];
        } else {
            c0377q0.f6403j = c0377q0.f6404k[0];
        }
        if (this.f5715t == 0) {
            C0334f1 c0334f13 = (C0334f1) jz2Var.f20698b;
            c0377q0.f6403j = AbstractC0338g1.m1499a(view, c0334f13, c0334f13.f6296g);
        } else {
            C0334f1 c0334f14 = (C0334f1) jz2Var.f20699c;
            c0377q0.f6402i = AbstractC0338g1.m1499a(view, c0334f14, c0334f14.f6296g);
        }
    }

    /* renamed from: X */
    public final void m1419X() {
        if (getChildCount() > 0) {
            this.f5719x = this.f5701b0.f27517f - ((C0377q0) getChildAt(0).getLayoutParams()).getViewLayoutPosition();
        } else {
            this.f5719x = 0;
        }
    }

    /* renamed from: Y */
    public final void m1420Y() {
        int i = this.f5677D & (-1025);
        int i2 = 0;
        if (m1405J(false)) {
            i2 = 1024;
        }
        int i3 = i | i2;
        this.f5677D = i3;
        if ((i3 & 1024) != 0) {
            ViewCompat.postOnAnimation(this.f5714s, this.f5710k0);
        }
    }

    /* renamed from: Z */
    public final void m1421Z() {
        int i;
        int i2;
        int itemCount;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        int top;
        int i6;
        int top2;
        int i7;
        if (this.f5718w.getItemCount() == 0) {
            return;
        }
        if ((this.f5677D & 262144) == 0) {
            i3 = this.f5701b0.f27518g;
            int itemCount2 = this.f5718w.getItemCount() - 1;
            i = this.f5701b0.f27517f;
            i2 = itemCount2;
            itemCount = 0;
        } else {
            ux0 ux0Var = this.f5701b0;
            int i8 = ux0Var.f27517f;
            i = ux0Var.f27518g;
            i2 = 0;
            itemCount = this.f5718w.getItemCount() - 1;
            i3 = i8;
        }
        if (i3 >= 0 && i >= 0) {
            if (i3 == i2) {
                z = true;
            } else {
                z = false;
            }
            if (i == itemCount) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i9 = Integer.MIN_VALUE;
            int i10 = Integer.MAX_VALUE;
            mt2 mt2Var = this.f5703d0;
            if (!z) {
                m53 m53Var = (m53) mt2Var.f23109d;
                if (m53Var.f22806a == Integer.MAX_VALUE && !z2 && m53Var.f22807b == Integer.MIN_VALUE) {
                    return;
                }
            }
            int[] iArr = f5673n0;
            if (z) {
                i10 = this.f5701b0.m7785g(true, iArr);
                View findViewByPosition = findViewByPosition(iArr[1]);
                if (this.f5715t == 0) {
                    C0377q0 c0377q0 = (C0377q0) findViewByPosition.getLayoutParams();
                    c0377q0.getClass();
                    top2 = findViewByPosition.getLeft() + c0377q0.f6398e;
                    i7 = c0377q0.f6402i;
                } else {
                    C0377q0 c0377q02 = (C0377q0) findViewByPosition.getLayoutParams();
                    c0377q02.getClass();
                    top2 = findViewByPosition.getTop() + c0377q02.f6399f;
                    i7 = c0377q02.f6403j;
                }
                int i11 = top2 + i7;
                int[] iArr2 = ((C0377q0) findViewByPosition.getLayoutParams()).f6404k;
                if (iArr2 != null && iArr2.length > 0) {
                    i4 = (iArr2[iArr2.length - 1] - iArr2[0]) + i11;
                } else {
                    i4 = i11;
                }
            } else {
                i4 = Integer.MAX_VALUE;
            }
            if (z2) {
                i9 = this.f5701b0.m7786i(false, iArr);
                View findViewByPosition2 = findViewByPosition(iArr[1]);
                if (this.f5715t == 0) {
                    C0377q0 c0377q03 = (C0377q0) findViewByPosition2.getLayoutParams();
                    c0377q03.getClass();
                    top = findViewByPosition2.getLeft() + c0377q03.f6398e;
                    i6 = c0377q03.f6402i;
                } else {
                    C0377q0 c0377q04 = (C0377q0) findViewByPosition2.getLayoutParams();
                    c0377q04.getClass();
                    top = findViewByPosition2.getTop() + c0377q04.f6399f;
                    i6 = c0377q04.f6403j;
                }
                i5 = top + i6;
            } else {
                i5 = Integer.MIN_VALUE;
            }
            ((m53) mt2Var.f23109d).m6081c(i9, i10, i5, i4);
        }
    }

    /* renamed from: a0 */
    public final void m1422a0() {
        m53 m53Var = (m53) this.f5703d0.f23110e;
        int i = m53Var.f22815j - this.f5689P;
        int m1433x = m1433x() + i;
        m53Var.m6081c(i, m1433x, i, m1433x);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f5715t == 0 || this.f5699Z > 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f5715t == 1 || this.f5699Z > 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(@Nullable RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof C0377q0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, @NonNull RecyclerView.State state, @NonNull RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3;
        try {
            m1409N(null, state);
            if (this.f5715t != 0) {
                i = i2;
            }
            if (getChildCount() != 0 && i != 0) {
                if (i < 0) {
                    i3 = -this.f5706g0;
                } else {
                    i3 = this.f5705f0 + this.f5706g0;
                }
                this.f5701b0.mo7273e(i3, i, layoutPrefetchRegistry);
                m1401F();
            }
        } finally {
            m1401F();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i, @NonNull RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i2 = this.f5714s.f5593V0;
        if (i != 0 && i2 != 0) {
            int max = Math.max(0, Math.min(this.f5682I - ((i2 - 1) / 2), i - i2));
            for (int i3 = max; i3 < i && i3 < max + i2; i3++) {
                layoutPrefetchRegistry.addPosition(i3, 0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NonNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NonNull
    public RecyclerView.LayoutParams generateLayoutParams(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new RecyclerView.LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        ux0 ux0Var;
        if (this.f5715t == 1 && (ux0Var = this.f5701b0) != null) {
            return ux0Var.f27516e;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedBottom(@NonNull View view) {
        return super.getDecoratedBottom(view) - ((C0377q0) view.getLayoutParams()).f6401h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
        rect.left += c0377q0.f6398e;
        rect.top += c0377q0.f6399f;
        rect.right -= c0377q0.f6400g;
        rect.bottom -= c0377q0.f6401h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedLeft(@NonNull View view) {
        return super.getDecoratedLeft(view) + ((C0377q0) view.getLayoutParams()).f6398e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedRight(@NonNull View view) {
        return super.getDecoratedRight(view) - ((C0377q0) view.getLayoutParams()).f6400g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getDecoratedTop(@NonNull View view) {
        return super.getDecoratedTop(view) + ((C0377q0) view.getLayoutParams()).f6399f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        ux0 ux0Var;
        if (this.f5715t == 0 && (ux0Var = this.f5701b0) != null) {
            return ux0Var.f27516e;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }

    /* renamed from: m */
    public final void m1423m() {
        int i;
        ux0 ux0Var = this.f5701b0;
        if ((this.f5677D & 262144) != 0) {
            i = (-this.f5706g0) - this.f5720y;
        } else {
            i = this.f5705f0 + this.f5706g0 + this.f5720y;
        }
        ux0Var.mo7272b(i, false);
    }

    /* renamed from: n */
    public final void m1424n() {
        View findViewByPosition;
        long itemId;
        ArrayList arrayList;
        if (this.f5678E == null && ((arrayList = this.f5679F) == null || arrayList.size() <= 0)) {
            return;
        }
        int i = this.f5682I;
        if (i == -1) {
            findViewByPosition = null;
        } else {
            findViewByPosition = findViewByPosition(i);
        }
        if (findViewByPosition != null) {
            RecyclerView.ViewHolder childViewHolder = this.f5714s.getChildViewHolder(findViewByPosition);
            OnChildSelectedListener onChildSelectedListener = this.f5678E;
            if (onChildSelectedListener != null) {
                BaseGridView baseGridView = this.f5714s;
                int i2 = this.f5682I;
                if (childViewHolder == null) {
                    itemId = -1;
                } else {
                    itemId = childViewHolder.getItemId();
                }
                onChildSelectedListener.onChildSelected(baseGridView, findViewByPosition, i2, itemId);
            }
            BaseGridView baseGridView2 = this.f5714s;
            int i3 = this.f5682I;
            int i4 = this.f5683J;
            ArrayList arrayList2 = this.f5679F;
            if (arrayList2 != null) {
                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                    ((OnChildViewHolderSelectedListener) this.f5679F.get(size)).onChildViewHolderSelected(baseGridView2, childViewHolder, i3, i4);
                }
            }
        } else {
            OnChildSelectedListener onChildSelectedListener2 = this.f5678E;
            if (onChildSelectedListener2 != null) {
                onChildSelectedListener2.onChildSelected(this.f5714s, null, -1, -1L);
            }
            BaseGridView baseGridView3 = this.f5714s;
            ArrayList arrayList3 = this.f5679F;
            if (arrayList3 != null) {
                for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                    ((OnChildViewHolderSelectedListener) this.f5679F.get(size2)).onChildViewHolderSelected(baseGridView3, null, -1, 0);
                }
            }
        }
        if ((this.f5677D & 3) != 1 && !this.f5714s.isLayoutRequested()) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                if (getChildAt(i5).isLayoutRequested()) {
                    ViewCompat.postOnAnimation(this.f5714s, this.f5710k0);
                    return;
                }
            }
        }
    }

    /* renamed from: o */
    public final void m1425o() {
        View findViewByPosition;
        ArrayList arrayList = this.f5679F;
        if (arrayList != null && arrayList.size() > 0) {
            int i = this.f5682I;
            if (i == -1) {
                findViewByPosition = null;
            } else {
                findViewByPosition = findViewByPosition(i);
            }
            if (findViewByPosition != null) {
                RecyclerView.ViewHolder childViewHolder = this.f5714s.getChildViewHolder(findViewByPosition);
                BaseGridView baseGridView = this.f5714s;
                int i2 = this.f5682I;
                int i3 = this.f5683J;
                ArrayList arrayList2 = this.f5679F;
                if (arrayList2 != null) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ((OnChildViewHolderSelectedListener) this.f5679F.get(size)).onChildViewHolderSelectedAndPositioned(baseGridView, childViewHolder, i2, i3);
                    }
                    return;
                }
                return;
            }
            OnChildSelectedListener onChildSelectedListener = this.f5678E;
            if (onChildSelectedListener != null) {
                onChildSelectedListener.onChildSelected(this.f5714s, null, -1, -1L);
            }
            BaseGridView baseGridView2 = this.f5714s;
            ArrayList arrayList3 = this.f5679F;
            if (arrayList3 != null) {
                for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                    ((OnChildViewHolderSelectedListener) this.f5679F.get(size2)).onChildViewHolderSelectedAndPositioned(baseGridView2, null, -1, 0);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(@Nullable RecyclerView.Adapter adapter, @Nullable RecyclerView.Adapter adapter2) {
        if (adapter != null) {
            this.f5701b0 = null;
            this.f5692S = null;
            this.f5677D &= -1025;
            this.f5682I = -1;
            this.f5686M = 0;
            LruCache lruCache = (LruCache) this.f5708i0.f23761c;
            if (lruCache != null) {
                lruCache.evictAll();
            }
        }
        if (adapter2 instanceof FacetProviderAdapter) {
            this.f5709j0 = (FacetProviderAdapter) adapter2;
        } else {
            this.f5709j0 = null;
        }
        super.onAdapterChanged(adapter, adapter2);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d2  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull @SuppressLint({"ConcreteCollection"}) ArrayList<View> arrayList, int i, int i2) {
        int i3;
        View findViewByPosition;
        int i4;
        int i5;
        int i6;
        View childAt;
        BaseGridView baseGridView;
        View findContainingItemView;
        if ((this.f5677D & 32768) != 0) {
            return true;
        }
        if (recyclerView.hasFocus()) {
            if (this.f5685L != null) {
                return true;
            }
            int m1428s = m1428s(i);
            View findFocus = recyclerView.findFocus();
            if (findFocus != null && (baseGridView = this.f5714s) != null && findFocus != baseGridView && (findContainingItemView = findContainingItemView(findFocus)) != null) {
                int childCount = getChildCount();
                i3 = 0;
                while (i3 < childCount) {
                    if (getChildAt(i3) == findContainingItemView) {
                        break;
                    }
                    i3++;
                }
            }
            i3 = -1;
            int m1394p = m1394p(getChildAt(i3));
            if (m1394p == -1) {
                findViewByPosition = null;
            } else {
                findViewByPosition = findViewByPosition(m1394p);
            }
            if (findViewByPosition != null) {
                findViewByPosition.addFocusables(arrayList, i, i2);
            }
            if (this.f5701b0 == null || getChildCount() == 0) {
                return true;
            }
            if ((m1428s == 3 || m1428s == 2) && this.f5701b0.f27516e <= 1) {
                return true;
            }
            ux0 ux0Var = this.f5701b0;
            if (ux0Var != null && findViewByPosition != null) {
                i4 = ux0Var.mo7277k(m1394p).f27011a;
            } else {
                i4 = -1;
            }
            int size = arrayList.size();
            if (m1428s != 1 && m1428s != 3) {
                i5 = -1;
            } else {
                i5 = 1;
            }
            int childCount2 = i5 > 0 ? getChildCount() - 1 : 0;
            if (i3 == -1) {
                if (i5 > 0) {
                    i6 = 0;
                } else {
                    i6 = getChildCount() - 1;
                }
            } else {
                i6 = i3 + i5;
            }
            int i7 = i6;
            while (true) {
                if (i5 > 0) {
                    if (i7 > childCount2) {
                        break;
                    }
                    childAt = getChildAt(i7);
                    if (childAt.getVisibility() == 0 && childAt.hasFocusable()) {
                        if (findViewByPosition != null) {
                            childAt.addFocusables(arrayList, i, i2);
                            if (arrayList.size() > size) {
                                break;
                            }
                        } else {
                            int m1394p2 = m1394p(getChildAt(i7));
                            tx0 mo7277k = this.f5701b0.mo7277k(m1394p2);
                            if (mo7277k != null) {
                                int i8 = mo7277k.f27011a;
                                if (m1428s == 1) {
                                    if (i8 == i4 && m1394p2 > m1394p) {
                                        childAt.addFocusables(arrayList, i, i2);
                                        if (arrayList.size() > size) {
                                            break;
                                        }
                                    }
                                } else if (m1428s == 0) {
                                    if (i8 == i4 && m1394p2 < m1394p) {
                                        childAt.addFocusables(arrayList, i, i2);
                                        if (arrayList.size() > size) {
                                            break;
                                        }
                                    }
                                } else if (m1428s == 3) {
                                    if (i8 != i4) {
                                        if (i8 < i4) {
                                            break;
                                        }
                                        childAt.addFocusables(arrayList, i, i2);
                                    }
                                } else if (m1428s == 2 && i8 != i4) {
                                    if (i8 > i4) {
                                        break;
                                    }
                                    childAt.addFocusables(arrayList, i, i2);
                                }
                            }
                        }
                    }
                    i7 += i5;
                } else {
                    if (i7 < childCount2) {
                        break;
                    }
                    childAt = getChildAt(i7);
                    if (childAt.getVisibility() == 0) {
                        if (findViewByPosition != null) {
                        }
                    }
                    i7 += i5;
                }
            }
        } else {
            int size2 = arrayList.size();
            if (this.f5702c0 != 0) {
                m53 m53Var = (m53) this.f5703d0.f23109d;
                int i9 = m53Var.f22815j;
                int i10 = ((m53Var.f22814i - i9) - m53Var.f22816k) + i9;
                int childCount3 = getChildCount();
                for (int i11 = 0; i11 < childCount3; i11++) {
                    View childAt2 = getChildAt(i11);
                    if (childAt2.getVisibility() == 0 && this.f5716u.getDecoratedStart(childAt2) >= i9 && this.f5716u.getDecoratedEnd(childAt2) <= i10) {
                        childAt2.addFocusables(arrayList, i, i2);
                    }
                }
                if (arrayList.size() == size2) {
                    int childCount4 = getChildCount();
                    for (int i12 = 0; i12 < childCount4; i12++) {
                        View childAt3 = getChildAt(i12);
                        if (childAt3.getVisibility() == 0) {
                            childAt3.addFocusables(arrayList, i, i2);
                        }
                    }
                }
            } else {
                View findViewByPosition2 = findViewByPosition(this.f5682I);
                if (findViewByPosition2 != null) {
                    findViewByPosition2.addFocusables(arrayList, i, i2);
                }
            }
            if (arrayList.size() == size2 && recyclerView.isFocusable()) {
                arrayList.add(recyclerView);
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        m1409N(recycler, state);
        int itemCount = state.getItemCount();
        int i = this.f5677D;
        if ((262144 & i) != 0) {
            z = true;
        } else {
            z = false;
        }
        if ((i & 2048) == 0 || (itemCount > 1 && !m1399D(0))) {
            if (this.f5715t == 0) {
                if (z) {
                    accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                } else {
                    accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                }
                accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
            } else {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
            }
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        if ((this.f5677D & 4096) == 0 || (itemCount > 1 && !m1399D(itemCount - 1))) {
            if (this.f5715t == 0) {
                if (z) {
                    accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                } else {
                    accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                }
                accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
            } else {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            }
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
        m1401F();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        tx0 mo7277k;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.f5701b0 != null && (layoutParams instanceof C0377q0)) {
            int absoluteAdapterPosition = ((C0377q0) layoutParams).getAbsoluteAdapterPosition();
            int i = -1;
            if (absoluteAdapterPosition >= 0 && (mo7277k = this.f5701b0.mo7277k(absoluteAdapterPosition)) != null) {
                i = mo7277k.f27011a;
            }
            int i2 = i;
            if (i2 < 0) {
                return;
            }
            int i3 = absoluteAdapterPosition / this.f5701b0.f27516e;
            if (this.f5715t == 0) {
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i2, 1, i3, 1, false, false));
            } else {
                accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i3, 1, i2, 1, false, false));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cc  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onInterceptFocusSearch(@Nullable View view, int i) {
        View view2;
        View view3;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        if ((this.f5677D & 32768) != 0) {
            return view;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (i != 2 && i != 1) {
            view3 = focusFinder.findNextFocus(this.f5714s, view, i);
        } else {
            if (canScrollVertically()) {
                if (i == 2) {
                    i3 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
                } else {
                    i3 = 33;
                }
                view2 = focusFinder.findNextFocus(this.f5714s, view, i3);
            } else {
                view2 = null;
            }
            if (canScrollHorizontally()) {
                if (getLayoutDirection() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (i == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z ^ z2) {
                    i2 = 66;
                } else {
                    i2 = 17;
                }
                view3 = focusFinder.findNextFocus(this.f5714s, view, i2);
            } else {
                view3 = view2;
            }
        }
        if (view3 != null) {
            return view3;
        }
        if (this.f5714s.getDescendantFocusability() == 393216) {
            return this.f5714s.getParent().focusSearch(view, i);
        }
        int m1428s = m1428s(i);
        if (this.f5714s.getScrollState() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (m1428s == 1) {
            if (z3 || (this.f5677D & 4096) == 0) {
                view3 = view;
            }
            if ((this.f5677D & 131072) != 0 && !m1398C()) {
                m1404I(true);
                view3 = view;
            }
            if (view3 == null) {
                return view3;
            }
            View focusSearch = this.f5714s.getParent().focusSearch(view, i);
            if (focusSearch != null) {
                return focusSearch;
            }
            if (view == null) {
                return this.f5714s;
            }
            return view;
        }
        if (m1428s == 0) {
            if (z3 || (this.f5677D & 2048) == 0) {
                view3 = view;
            }
            if ((this.f5677D & 131072) != 0 && !m1397B()) {
                m1404I(false);
                view3 = view;
            }
            if (view3 == null) {
            }
        } else if (m1428s == 3) {
            if (view3 == null) {
            }
        } else if (view3 == null) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        ux0 ux0Var;
        int i3;
        int i4 = this.f5682I;
        if (i4 != -1 && (ux0Var = this.f5701b0) != null && ux0Var.f27517f >= 0 && (i3 = this.f5686M) != Integer.MIN_VALUE && i <= i4 + i3) {
            this.f5686M = i3 + i2;
        }
        LruCache lruCache = (LruCache) this.f5708i0.f23761c;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        this.f5686M = 0;
        LruCache lruCache = (LruCache) this.f5708i0.f23761c;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
        int i4;
        int i5 = this.f5682I;
        if (i5 != -1 && (i4 = this.f5686M) != Integer.MIN_VALUE) {
            int i6 = i5 + i4;
            if (i <= i6 && i6 < i + i3) {
                this.f5686M = (i2 - i) + i4;
            } else if (i < i6 && i2 > i6 - i3) {
                this.f5686M = i4 - i3;
            } else if (i > i6 && i2 < i6) {
                this.f5686M = i4 + i3;
            }
        }
        LruCache lruCache = (LruCache) this.f5708i0.f23761c;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        ux0 ux0Var;
        int i3;
        int i4;
        int i5 = this.f5682I;
        if (i5 != -1 && (ux0Var = this.f5701b0) != null && ux0Var.f27517f >= 0 && (i3 = this.f5686M) != Integer.MIN_VALUE && i <= (i4 = i5 + i3)) {
            if (i + i2 > i4) {
                this.f5682I = (i - i4) + i3 + i5;
                this.f5686M = Integer.MIN_VALUE;
            } else {
                this.f5686M = i3 - i2;
            }
        }
        LruCache lruCache = (LruCache) this.f5708i0.f23761c;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            C1617oc c1617oc = this.f5708i0;
            LruCache lruCache = (LruCache) c1617oc.f23761c;
            if (lruCache != null && lruCache.size() != 0) {
                ((LruCache) c1617oc.f23761c).remove(Integer.toString(i));
            }
            i++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 406
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.Recycler r24, @androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView.State r25) {
        /*
            Method dump skipped, instructions count: 1542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.GridLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(@NonNull RecyclerView.State state) {
        ArrayList arrayList = this.f5680G;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((BaseGridView.OnLayoutCompletedListener) this.f5680G.get(size)).onLayoutCompleted(state);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, int i2) {
        int size;
        int size2;
        int mode;
        int paddingLeft;
        int paddingRight;
        int i3;
        m1409N(recycler, state);
        if (this.f5715t == 0) {
            size2 = View.MeasureSpec.getSize(i);
            size = View.MeasureSpec.getSize(i2);
            mode = View.MeasureSpec.getMode(i2);
            paddingLeft = getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            size = View.MeasureSpec.getSize(i);
            size2 = View.MeasureSpec.getSize(i2);
            mode = View.MeasureSpec.getMode(i);
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        int i4 = paddingRight + paddingLeft;
        this.f5693T = size;
        int i5 = this.f5690Q;
        if (i5 == -2) {
            int i6 = this.f5700a0;
            if (i6 == 0) {
                i6 = 1;
            }
            this.f5699Z = i6;
            this.f5691R = 0;
            int[] iArr = this.f5692S;
            if (iArr == null || iArr.length != i6) {
                this.f5692S = new int[i6];
            }
            if (this.f5718w.isPreLayout()) {
                m1419X();
            }
            m1405J(true);
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode == 1073741824) {
                        size = this.f5693T;
                    } else {
                        throw new IllegalStateException("wrong spec");
                    }
                } else {
                    i3 = m1433x();
                    size = i3 + i4;
                }
            } else {
                size = Math.min(m1433x() + i4, this.f5693T);
            }
        } else {
            if (mode != Integer.MIN_VALUE) {
                if (mode != 0) {
                    if (mode != 1073741824) {
                        throw new IllegalStateException("wrong spec");
                    }
                } else {
                    if (i5 == 0) {
                        i5 = size - i4;
                    }
                    this.f5691R = i5;
                    int i7 = this.f5700a0;
                    if (i7 == 0) {
                        i7 = 1;
                    }
                    this.f5699Z = i7;
                    i3 = ((i7 - 1) * this.f5697X) + (i5 * i7);
                    size = i3 + i4;
                }
            }
            int i8 = this.f5700a0;
            if (i8 == 0 && i5 == 0) {
                this.f5699Z = 1;
                this.f5691R = size - i4;
            } else if (i8 == 0) {
                this.f5691R = i5;
                int i9 = this.f5697X;
                this.f5699Z = (size + i9) / (i5 + i9);
            } else if (i5 == 0) {
                this.f5699Z = i8;
                this.f5691R = ((size - i4) - ((i8 - 1) * this.f5697X)) / i8;
            } else {
                this.f5699Z = i8;
                this.f5691R = i5;
            }
            if (mode == Integer.MIN_VALUE) {
                int i10 = this.f5691R;
                int i11 = this.f5699Z;
                int i12 = ((i11 - 1) * this.f5697X) + (i10 * i11) + i4;
                if (i12 < size) {
                    size = i12;
                }
            }
        }
        if (this.f5715t == 0) {
            setMeasuredDimension(size2, size);
        } else {
            setMeasuredDimension(size, size2);
        }
        m1401F();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state, @NonNull View view, @Nullable View view2) {
        if ((this.f5677D & 32768) == 0 && m1394p(view) != -1 && (this.f5677D & 35) == 0) {
            m1413R(view, view2, true, 0, 0);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f5682I = savedState.f5722a;
        this.f5686M = 0;
        Bundle bundle = savedState.f5723b;
        C1617oc c1617oc = this.f5708i0;
        LruCache lruCache = (LruCache) c1617oc.f23761c;
        if (lruCache != null && bundle != null) {
            lruCache.evictAll();
            for (String str : bundle.keySet()) {
                ((LruCache) c1617oc.f23761c).put(str, bundle.getSparseParcelableArray(str));
            }
        }
        this.f5677D |= 256;
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.leanback.widget.GridLayoutManager$SavedState, java.lang.Object] */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle;
        ?? obj = new Object();
        obj.f5723b = Bundle.EMPTY;
        obj.f5722a = this.f5682I;
        C1617oc c1617oc = this.f5708i0;
        LruCache lruCache = (LruCache) c1617oc.f23761c;
        if (lruCache != null && lruCache.size() != 0) {
            Map snapshot = ((LruCache) c1617oc.f23761c).snapshot();
            bundle = new Bundle();
            for (Map.Entry entry : snapshot.entrySet()) {
                bundle.putSparseParcelableArray((String) entry.getKey(), (SparseArray) entry.getValue());
            }
        } else {
            bundle = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int m1394p = m1394p(childAt);
            if (m1394p != -1 && c1617oc.f23759a != 0) {
                String num = Integer.toString(m1394p);
                SparseArray<Parcelable> sparseArray = new SparseArray<>();
                childAt.saveHierarchyState(sparseArray);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray(num, sparseArray);
            }
        }
        obj.f5723b = bundle;
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (r5 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:
    
        r7 = 4096;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0037, code lost:
    
        if (r5 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004a, code lost:
    
        if (r7 == androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN.getId()) goto L27;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i, @Nullable Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if ((this.f5677D & 131072) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return true;
        }
        m1409N(recycler, state);
        if ((this.f5677D & 262144) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f5715t == 0) {
            if (i != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT.getId()) {
                if (i == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT.getId()) {
                }
            }
        } else {
            if (i != AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP.getId()) {
            }
            i = 8192;
        }
        int i2 = this.f5682I;
        if (i2 == 0 && i == 8192) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (i2 == state.getItemCount() - 1 && i == 4096) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z3 && !z4) {
            if (i != 4096) {
                if (i == 8192) {
                    m1404I(false);
                    m1406K(-1, false);
                }
            } else {
                m1404I(true);
                m1406K(1, false);
            }
        } else {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(4096);
            this.f5714s.onInitializeAccessibilityEvent(obtain);
            BaseGridView baseGridView = this.f5714s;
            baseGridView.requestSendAccessibilityEvent(baseGridView, obtain);
        }
        m1401F();
        return true;
    }

    /* renamed from: q */
    public final int m1426q(View view) {
        C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
        return getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) c0377q0).topMargin + ((ViewGroup.MarginLayoutParams) c0377q0).bottomMargin;
    }

    /* renamed from: r */
    public final int m1427r(View view) {
        C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
        return getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) c0377q0).leftMargin + ((ViewGroup.MarginLayoutParams) c0377q0).rightMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void removeAndRecycleAllViews(@NonNull RecyclerView.Recycler recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            removeAndRecycleViewAt(childCount, recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        if ((r9.f5677D & 262144) == 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
    
        r4 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002a, code lost:
    
        if ((r9.f5677D & 262144) == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        if ((r9.f5677D & 524288) == 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        if ((r9.f5677D & 524288) == 0) goto L18;
     */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m1428s(int i) {
        int i2 = this.f5715t;
        int i3 = 2;
        if (i2 == 0) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            i3 = 17;
                        }
                        i3 = 3;
                    }
                }
            }
            return i3;
        }
        if (i2 == 1) {
            if (i != 17) {
                if (i == 33) {
                    return 0;
                }
                if (i != 66) {
                    if (i == 130) {
                        return 1;
                    }
                }
            }
        }
        return 17;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        int m1411P;
        if ((this.f5677D & 512) != 0 && this.f5701b0 != null) {
            m1409N(recycler, state);
            this.f5677D = (this.f5677D & (-4)) | 2;
            if (this.f5715t == 0) {
                m1411P = m1410O(i);
            } else {
                m1411P = m1411P(i);
            }
            m1401F();
            this.f5677D &= -4;
            return m1411P;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        m1416U(i, 0, 0, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, @NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state) {
        int m1411P;
        int i2 = this.f5677D;
        if ((i2 & 512) != 0 && this.f5701b0 != null) {
            this.f5677D = (i2 & (-4)) | 2;
            m1409N(recycler, state);
            if (this.f5715t == 1) {
                m1411P = m1410O(i);
            } else {
                m1411P = m1411P(i);
            }
            m1401F();
            this.f5677D &= -4;
            return m1411P;
        }
        return 0;
    }

    public void setFocusOutAllowed(boolean z, boolean z2) {
        int i;
        int i2 = this.f5677D & (-6145);
        int i3 = 0;
        if (z) {
            i = 2048;
        } else {
            i = 0;
        }
        int i4 = i | i2;
        if (z2) {
            i3 = 4096;
        }
        this.f5677D = i4 | i3;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            return;
        }
        this.f5715t = i;
        this.f5716u = OrientationHelper.createOrientationHelper(this, i);
        mt2 mt2Var = this.f5703d0;
        mt2Var.getClass();
        m53 m53Var = (m53) mt2Var.f23107b;
        m53 m53Var2 = (m53) mt2Var.f23108c;
        if (i == 0) {
            mt2Var.f23109d = m53Var2;
            mt2Var.f23110e = m53Var;
        } else {
            mt2Var.f23109d = m53Var;
            mt2Var.f23110e = m53Var2;
        }
        jz2 jz2Var = this.f5704e0;
        jz2Var.getClass();
        if (i == 0) {
            jz2Var.f20700d = (C0334f1) jz2Var.f20699c;
        } else {
            jz2Var.f20700d = (C0334f1) jz2Var.f20698b;
        }
        this.f5677D |= 256;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state, int i) {
        m1416U(i, 0, 0, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void startSmoothScroll(@NonNull RecyclerView.SmoothScroller smoothScroller) {
        yx0 yx0Var = this.f5684K;
        if (yx0Var != null) {
            yx0Var.f29159l = true;
        }
        super.startSmoothScroll(smoothScroller);
        if (smoothScroller.isRunning() && (smoothScroller instanceof yx0)) {
            yx0 yx0Var2 = (yx0) smoothScroller;
            this.f5684K = yx0Var2;
            if (yx0Var2 instanceof zx0) {
                this.f5685L = (zx0) yx0Var2;
                return;
            } else {
                this.f5685L = null;
                return;
            }
        }
        this.f5684K = null;
        this.f5685L = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    /* renamed from: t */
    public final int m1429t(int i) {
        int i2 = this.f5691R;
        if (i2 != 0) {
            return i2;
        }
        int[] iArr = this.f5692S;
        if (iArr == null) {
            return 0;
        }
        return iArr[i];
    }

    /* renamed from: u */
    public final int m1430u(int i) {
        int i2 = 0;
        if ((this.f5677D & 524288) != 0) {
            for (int i3 = this.f5699Z - 1; i3 > i; i3--) {
                i2 += m1429t(i3) + this.f5697X;
            }
            return i2;
        }
        int i4 = 0;
        while (i2 < i) {
            i4 += m1429t(i2) + this.f5697X;
            i2++;
        }
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0117, code lost:
    
        if (r3 != null) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0136  */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m1431v(View view, View view2, int[] iArr) {
        int i;
        View view3;
        int i2;
        int decoratedEnd;
        int m1432w;
        int i3;
        int top;
        int i4;
        int m1395z;
        int i5 = this.f5702c0;
        mt2 mt2Var = this.f5703d0;
        if (i5 != 1 && i5 != 2) {
            m53 m53Var = (m53) mt2Var.f23109d;
            if (this.f5715t == 0) {
                C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
                c0377q0.getClass();
                top = view.getLeft() + c0377q0.f6398e;
                i4 = c0377q0.f6402i;
            } else {
                C0377q0 c0377q02 = (C0377q0) view.getLayoutParams();
                c0377q02.getClass();
                top = view.getTop() + c0377q02.f6399f;
                i4 = c0377q02.f6403j;
            }
            int m6080b = m53Var.m6080b(top + i4);
            if (view2 != null && (m1395z = m1395z(view, view2)) != 0) {
                int[] iArr2 = ((C0377q0) view.getLayoutParams()).f6404k;
                m6080b += iArr2[m1395z] - iArr2[0];
            }
            int m1432w2 = m1432w(view);
            int i6 = m6080b + this.f5687N;
            if (i6 == 0 && m1432w2 == 0) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
            iArr[0] = i6;
            iArr[1] = m1432w2;
            return true;
        }
        int m1394p = m1394p(view);
        int decoratedStart = this.f5716u.getDecoratedStart(view);
        int decoratedEnd2 = this.f5716u.getDecoratedEnd(view);
        m53 m53Var2 = (m53) mt2Var.f23109d;
        int i7 = m53Var2.f22815j;
        int i8 = (m53Var2.f22814i - i7) - m53Var2.f22816k;
        tx0 mo7277k = this.f5701b0.mo7277k(m1394p);
        if (mo7277k == null) {
            i = -1;
        } else {
            i = mo7277k.f27011a;
        }
        View view4 = null;
        if (decoratedStart < i7) {
            if (this.f5702c0 == 2) {
                View view5 = view;
                while (true) {
                    ux0 ux0Var = this.f5701b0;
                    if (ux0Var.f27514c) {
                        i3 = Integer.MIN_VALUE;
                    } else {
                        i3 = Integer.MAX_VALUE;
                    }
                    if (ux0Var.mo7278m(i3, true)) {
                        ux0 ux0Var2 = this.f5701b0;
                        CircularIntArray circularIntArray = ux0Var2.mo7276j(ux0Var2.f27517f, m1394p)[i];
                        View findViewByPosition = findViewByPosition(circularIntArray.get(0));
                        if (decoratedEnd2 - this.f5716u.getDecoratedStart(findViewByPosition) > i8) {
                            if (circularIntArray.size() > 2) {
                                view3 = null;
                                view4 = findViewByPosition(circularIntArray.get(2));
                            } else {
                                view3 = null;
                                view4 = findViewByPosition;
                            }
                        } else {
                            view5 = findViewByPosition;
                        }
                    } else {
                        view3 = null;
                        view4 = view5;
                        break;
                    }
                }
            } else {
                view3 = null;
                view4 = view;
            }
        } else if (decoratedEnd2 > i8 + i7) {
            if (this.f5702c0 != 2) {
                view3 = view;
            }
            while (true) {
                ux0 ux0Var3 = this.f5701b0;
                CircularIntArray circularIntArray2 = ux0Var3.mo7276j(m1394p, ux0Var3.f27518g)[i];
                view3 = findViewByPosition(circularIntArray2.get(circularIntArray2.size() - 1));
                if (this.f5716u.getDecoratedEnd(view3) - decoratedStart > i8) {
                    view3 = null;
                    break;
                }
                if (!this.f5701b0.m7782a()) {
                    break;
                }
            }
        } else {
            view3 = null;
        }
        if (view4 != null) {
            decoratedEnd = this.f5716u.getDecoratedStart(view4);
        } else if (view3 != null) {
            decoratedEnd = this.f5716u.getDecoratedEnd(view3);
            i7 += i8;
        } else {
            i2 = 0;
            if (view4 == null) {
                view = view4;
            } else if (view3 != null) {
                view = view3;
            }
            m1432w = m1432w(view);
            if (i2 != 0 && m1432w == 0) {
                return false;
            }
            iArr[0] = i2;
            iArr[1] = m1432w;
            return true;
        }
        i2 = decoratedEnd - i7;
        if (view4 == null) {
        }
        m1432w = m1432w(view);
        if (i2 != 0) {
        }
        iArr[0] = i2;
        iArr[1] = m1432w;
        return true;
    }

    /* renamed from: w */
    public final int m1432w(View view) {
        int left;
        int i;
        if (this.f5715t == 0) {
            C0377q0 c0377q0 = (C0377q0) view.getLayoutParams();
            c0377q0.getClass();
            left = view.getTop() + c0377q0.f6399f;
            i = c0377q0.f6403j;
        } else {
            C0377q0 c0377q02 = (C0377q0) view.getLayoutParams();
            c0377q02.getClass();
            left = view.getLeft() + c0377q02.f6398e;
            i = c0377q02.f6402i;
        }
        return ((m53) this.f5703d0.f23110e).m6080b(left + i);
    }

    /* renamed from: x */
    public final int m1433x() {
        int i;
        if ((this.f5677D & 524288) != 0) {
            i = 0;
        } else {
            i = this.f5699Z - 1;
        }
        return m1429t(i) + m1430u(i);
    }

    /* renamed from: y */
    public final int m1434y() {
        int i;
        int left;
        int right;
        if (this.f5715t == 1) {
            i = -getHeight();
            if (getChildCount() <= 0 || (left = getChildAt(0).getTop()) >= 0) {
                return i;
            }
        } else {
            if ((this.f5677D & 262144) != 0) {
                int width = getWidth();
                if (getChildCount() > 0 && (right = getChildAt(0).getRight()) > width) {
                    return right;
                }
                return width;
            }
            i = -getWidth();
            if (getChildCount() <= 0 || (left = getChildAt(0).getLeft()) >= 0) {
                return i;
            }
        }
        return i + left;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [oc, java.lang.Object] */
    public GridLayoutManager(BaseGridView baseGridView) {
        this.f5712q = 1.0f;
        this.f5713r = 10;
        this.f5715t = 0;
        this.f5716u = OrientationHelper.createHorizontalHelper(this);
        this.f5721z = new SparseIntArray();
        this.f5677D = 221696;
        this.f5678E = null;
        this.f5679F = null;
        this.f5680G = null;
        this.f5681H = null;
        this.f5682I = -1;
        this.f5683J = 0;
        this.f5686M = 0;
        this.f5698Y = 8388659;
        this.f5700a0 = 1;
        this.f5702c0 = 0;
        this.f5703d0 = new mt2(3);
        this.f5704e0 = new jz2(6);
        this.f5707h0 = new int[2];
        ?? obj = new Object();
        obj.f23759a = 0;
        obj.f23760b = 100;
        this.f5708i0 = obj;
        this.f5710k0 = new RunnableC1104d(23, this);
        this.f5711l0 = new vx0(this);
        this.f5714s = baseGridView;
        this.f5688O = -1;
        setItemPrefetchEnabled(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @NonNull
    public RecyclerView.LayoutParams generateLayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0377q0) {
            return new RecyclerView.LayoutParams((RecyclerView.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            return new RecyclerView.LayoutParams((RecyclerView.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new RecyclerView.LayoutParams(layoutParams);
    }
}
