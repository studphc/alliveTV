package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p000.AbstractC1497l3;
import p000.C1382k8;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;

    /* renamed from: a */
    public boolean f1263a;

    /* renamed from: b */
    public int f1264b;

    /* renamed from: c */
    public int f1265c;

    /* renamed from: d */
    public int f1266d;

    /* renamed from: e */
    public int f1267e;

    /* renamed from: f */
    public int f1268f;

    /* renamed from: g */
    public float f1269g;

    /* renamed from: h */
    public boolean f1270h;

    /* renamed from: i */
    public int[] f1271i;

    /* renamed from: j */
    public int[] f1272j;

    /* renamed from: k */
    public Drawable f1273k;

    /* renamed from: l */
    public int f1274l;

    /* renamed from: m */
    public int f1275m;

    /* renamed from: n */
    public int f1276n;

    /* renamed from: o */
    public int f1277o;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a */
        public boolean f1278a = false;

        /* renamed from: b */
        public int f1279b;

        /* renamed from: c */
        public int f1280c;

        /* renamed from: d */
        public int f1281d;

        /* renamed from: e */
        public int f1282e;

        /* renamed from: f */
        public int f1283f;

        /* renamed from: g */
        public int f1284g;

        /* renamed from: h */
        public int f1285h;

        /* renamed from: i */
        public int f1286i;

        /* renamed from: j */
        public int f1287j;

        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapBoolean;
            int mapInt;
            int mapGravity;
            int mapIntEnum;
            int mapFloat;
            int mapObject;
            int mapInt2;
            int mapBoolean2;
            int mapIntFlag;
            mapBoolean = propertyMapper.mapBoolean("baselineAligned", R.attr.baselineAligned);
            this.f1279b = mapBoolean;
            mapInt = propertyMapper.mapInt("baselineAlignedChildIndex", R.attr.baselineAlignedChildIndex);
            this.f1280c = mapInt;
            mapGravity = propertyMapper.mapGravity("gravity", R.attr.gravity);
            this.f1281d = mapGravity;
            mapIntEnum = propertyMapper.mapIntEnum("orientation", R.attr.orientation, new C1382k8(2));
            this.f1282e = mapIntEnum;
            mapFloat = propertyMapper.mapFloat("weightSum", R.attr.weightSum);
            this.f1283f = mapFloat;
            mapObject = propertyMapper.mapObject("divider", androidx.appcompat.R.attr.divider);
            this.f1284g = mapObject;
            mapInt2 = propertyMapper.mapInt("dividerPadding", androidx.appcompat.R.attr.dividerPadding);
            this.f1285h = mapInt2;
            mapBoolean2 = propertyMapper.mapBoolean("measureWithLargestChild", androidx.appcompat.R.attr.measureWithLargestChild);
            this.f1286i = mapBoolean2;
            mapIntFlag = propertyMapper.mapIntFlag("showDividers", androidx.appcompat.R.attr.showDividers, new C1382k8(3));
            this.f1287j = mapIntFlag;
            this.f1278a = true;
        }

        public void readProperties(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull PropertyReader propertyReader) {
            if (this.f1278a) {
                propertyReader.readBoolean(this.f1279b, linearLayoutCompat.isBaselineAligned());
                propertyReader.readInt(this.f1280c, linearLayoutCompat.getBaselineAlignedChildIndex());
                propertyReader.readGravity(this.f1281d, linearLayoutCompat.getGravity());
                propertyReader.readIntEnum(this.f1282e, linearLayoutCompat.getOrientation());
                propertyReader.readFloat(this.f1283f, linearLayoutCompat.getWeightSum());
                propertyReader.readObject(this.f1284g, linearLayoutCompat.getDividerDrawable());
                propertyReader.readInt(this.f1285h, linearLayoutCompat.getDividerPadding());
                propertyReader.readBoolean(this.f1286i, linearLayoutCompat.isMeasureWithLargestChildEnabled());
                propertyReader.readIntFlag(this.f1287j, linearLayoutCompat.getShowDividers());
                return;
            }
            throw AbstractC1497l3.m5831i();
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m249a(Canvas canvas, int i) {
        this.f1273k.setBounds(getPaddingLeft() + this.f1277o, i, (getWidth() - getPaddingRight()) - this.f1277o, this.f1275m + i);
        this.f1273k.draw(canvas);
    }

    /* renamed from: b */
    public final void m250b(Canvas canvas, int i) {
        this.f1273k.setBounds(i, getPaddingTop() + this.f1277o, this.f1274l + i, (getHeight() - getPaddingBottom()) - this.f1277o);
        this.f1273k.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f1264b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.f1264b;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.f1264b == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i3 = this.f1265c;
            if (this.f1266d == 1 && (i = this.f1267e & 112) != 48) {
                if (i != 16) {
                    if (i == 80) {
                        i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1268f;
                    }
                } else {
                    i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1268f) / 2;
                }
            }
            return i3 + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1264b;
    }

    public Drawable getDividerDrawable() {
        return this.f1273k;
    }

    public int getDividerPadding() {
        return this.f1277o;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.f1274l;
    }

    @GravityInt
    public int getGravity() {
        return this.f1267e;
    }

    public int getOrientation() {
        return this.f1266d;
    }

    public int getShowDividers() {
        return this.f1276n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1269g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            if ((this.f1276n & 1) == 0) {
                return false;
            }
            return true;
        }
        if (i == getChildCount()) {
            if ((this.f1276n & 4) == 0) {
                return false;
            }
            return true;
        }
        if ((this.f1276n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.f1263a;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.f1270h;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int bottom;
        if (this.f1273k == null) {
            return;
        }
        int i2 = 0;
        if (this.f1266d == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i2 < virtualChildCount) {
                View childAt = getChildAt(i2);
                if (childAt != null && childAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                    m249a(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin) - this.f1275m);
                }
                i2++;
            }
            if (hasDividerBeforeChildAt(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                if (childAt2 == null) {
                    bottom = (getHeight() - getPaddingBottom()) - this.f1275m;
                } else {
                    bottom = childAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) childAt2.getLayoutParams())).bottomMargin;
                }
                m249a(canvas, bottom);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        while (i2 < virtualChildCount2) {
            View childAt3 = getChildAt(i2);
            if (childAt3 != null && childAt3.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                if (isLayoutRtl) {
                    left2 = childAt3.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else {
                    left2 = (childAt3.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.f1274l;
                }
                m250b(canvas, left2);
            }
            i2++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 == null) {
                if (isLayoutRtl) {
                    right = getPaddingLeft();
                } else {
                    left = getWidth() - getPaddingRight();
                    i = this.f1274l;
                    right = left - i;
                }
            } else {
                LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                if (isLayoutRtl) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i = this.f1274l;
                    right = left - i;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            }
            m250b(canvas, right);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018c  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int paddingTop;
        int i15;
        int i16;
        int i17;
        int i18 = 8;
        if (this.f1266d == 1) {
            int paddingLeft2 = getPaddingLeft();
            int i19 = i3 - i;
            int paddingRight = i19 - getPaddingRight();
            int paddingRight2 = (i19 - paddingLeft2) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i20 = this.f1267e;
            int i21 = i20 & 112;
            int i22 = 8388615 & i20;
            if (i21 != 16) {
                if (i21 != 80) {
                    paddingTop = getPaddingTop();
                } else {
                    paddingTop = ((getPaddingTop() + i4) - i2) - this.f1268f;
                }
            } else {
                paddingTop = getPaddingTop() + (((i4 - i2) - this.f1268f) / 2);
            }
            int i23 = 0;
            while (i23 < virtualChildCount) {
                View childAt = getChildAt(i23);
                if (childAt != null && childAt.getVisibility() != i18) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i24 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i24 < 0) {
                        i24 = i22;
                    }
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(i24, getLayoutDirection()) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i17 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft2;
                            if (hasDividerBeforeChildAt(i23)) {
                                paddingTop += this.f1275m;
                            }
                            int i25 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                            childAt.layout(i17, i25, measuredWidth + i17, i25 + measuredHeight);
                            paddingTop = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i25;
                        } else {
                            i15 = paddingRight - measuredWidth;
                            i16 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        }
                    } else {
                        i15 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        i16 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i17 = i15 - i16;
                    if (hasDividerBeforeChildAt(i23)) {
                    }
                    int i252 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    childAt.layout(i17, i252, measuredWidth + i17, i252 + measuredHeight);
                    paddingTop = measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i252;
                }
                i23++;
                i18 = 8;
            }
            return;
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop2 = getPaddingTop();
        int i26 = i4 - i2;
        int paddingBottom = i26 - getPaddingBottom();
        int paddingBottom2 = (i26 - paddingTop2) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i27 = this.f1267e;
        int i28 = 8388615 & i27;
        int i29 = i27 & 112;
        boolean z2 = this.f1263a;
        int[] iArr = this.f1271i;
        int[] iArr2 = this.f1272j;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(i28, getLayoutDirection());
        if (absoluteGravity2 != 1) {
            if (absoluteGravity2 != 5) {
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f1268f;
            }
        } else {
            paddingLeft = getPaddingLeft() + (((i3 - i) - this.f1268f) / 2);
        }
        if (isLayoutRtl) {
            i6 = virtualChildCount2 - 1;
            i5 = -1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i30 = 0;
        while (i30 < virtualChildCount2) {
            int i31 = (i5 * i30) + i6;
            View childAt2 = getChildAt(i31);
            if (childAt2 == null) {
                i7 = i6;
            } else {
                i7 = i6;
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight2 = childAt2.getMeasuredHeight();
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    i8 = i5;
                    if (z2) {
                        i9 = virtualChildCount2;
                        if (((LinearLayout.LayoutParams) layoutParams2).height != -1) {
                            i10 = childAt2.getBaseline();
                            i11 = ((LinearLayout.LayoutParams) layoutParams2).gravity;
                            if (i11 < 0) {
                                i11 = i29;
                            }
                            i12 = i11 & 112;
                            i13 = i29;
                            if (i12 == 16) {
                                if (i12 != 48) {
                                    if (i12 != 80) {
                                        i14 = paddingTop2;
                                    } else {
                                        i14 = (paddingBottom - measuredHeight2) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                                        if (i10 != -1) {
                                            i14 -= iArr2[2] - (childAt2.getMeasuredHeight() - i10);
                                        }
                                    }
                                } else {
                                    i14 = ((LinearLayout.LayoutParams) layoutParams2).topMargin + paddingTop2;
                                    if (i10 != -1) {
                                        i14 = (iArr[1] - i10) + i14;
                                    }
                                }
                            } else {
                                i14 = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop2) + ((LinearLayout.LayoutParams) layoutParams2).topMargin) - ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                            }
                            if (hasDividerBeforeChildAt(i31)) {
                                paddingLeft += this.f1274l;
                            }
                            int i32 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                            childAt2.layout(i32, i14, i32 + measuredWidth2, i14 + measuredHeight2);
                            paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i32;
                            i30++;
                            i6 = i7;
                            i5 = i8;
                            virtualChildCount2 = i9;
                            i29 = i13;
                        }
                    } else {
                        i9 = virtualChildCount2;
                    }
                    i10 = -1;
                    i11 = ((LinearLayout.LayoutParams) layoutParams2).gravity;
                    if (i11 < 0) {
                    }
                    i12 = i11 & 112;
                    i13 = i29;
                    if (i12 == 16) {
                    }
                    if (hasDividerBeforeChildAt(i31)) {
                    }
                    int i322 = paddingLeft + ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    childAt2.layout(i322, i14, i322 + measuredWidth2, i14 + measuredHeight2);
                    paddingLeft = measuredWidth2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + i322;
                    i30++;
                    i6 = i7;
                    i5 = i8;
                    virtualChildCount2 = i9;
                    i29 = i13;
                }
            }
            i8 = i5;
            i9 = virtualChildCount2;
            i13 = i29;
            i30++;
            i6 = i7;
            i5 = i8;
            virtualChildCount2 = i9;
            i29 = i13;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:173:0x02e0, code lost:
    
        if (((android.widget.LinearLayout.LayoutParams) r13).width == (-1)) goto L148;
     */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:352:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x06b4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        boolean z;
        char c;
        int i3;
        int max;
        float f;
        int i4;
        int i5;
        int i6;
        int i7;
        char c2;
        int i8;
        int i9;
        int i10;
        int i11;
        float f2;
        int i12;
        boolean z2;
        int i13;
        boolean z3;
        int baseline;
        int i14;
        int i15;
        float f3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z4;
        boolean z5;
        LayoutParams layoutParams;
        boolean z6;
        int i22;
        boolean z7;
        int i23;
        int i24;
        boolean z8;
        int baseline2;
        int i25;
        int i26;
        int i27;
        boolean z9;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        boolean z10;
        LayoutParams layoutParams2;
        boolean z11;
        int i35;
        boolean z12;
        int max2;
        boolean z13;
        int i36 = this.f1266d;
        int i37 = -2;
        int i38 = 1073741824;
        int i39 = 8;
        int i40 = Integer.MIN_VALUE;
        float f4 = RecyclerView.f7068F0;
        boolean z14 = true;
        if (i36 == 1) {
            this.f1268f = 0;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i41 = this.f1264b;
            boolean z15 = this.f1270h;
            boolean z16 = true;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            boolean z17 = false;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            boolean z18 = false;
            float f5 = 0.0f;
            while (i42 < virtualChildCount) {
                View childAt = getChildAt(i42);
                if (childAt == null) {
                    this.f1268f = this.f1268f;
                } else if (childAt.getVisibility() != i39) {
                    if (hasDividerBeforeChildAt(i42)) {
                        this.f1268f += this.f1275m;
                    }
                    LayoutParams layoutParams3 = (LayoutParams) childAt.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    f5 += f6;
                    if (mode2 == i38 && ((LinearLayout.LayoutParams) layoutParams3).height == 0 && f6 > f4) {
                        int i48 = this.f1268f;
                        this.f1268f = Math.max(i48, ((LinearLayout.LayoutParams) layoutParams3).topMargin + i48 + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        i31 = i41;
                        i32 = mode2;
                        i33 = mode;
                        i34 = virtualChildCount;
                        layoutParams2 = layoutParams3;
                        z11 = true;
                        z10 = true;
                    } else {
                        if (((LinearLayout.LayoutParams) layoutParams3).height == 0 && f6 > f4) {
                            ((LinearLayout.LayoutParams) layoutParams3).height = i37;
                            i29 = 0;
                        } else {
                            i29 = i40;
                        }
                        if (f5 == f4) {
                            i30 = this.f1268f;
                        } else {
                            i30 = 0;
                        }
                        i31 = i41;
                        i32 = mode2;
                        i33 = mode;
                        i34 = virtualChildCount;
                        z10 = true;
                        layoutParams2 = layoutParams3;
                        measureChildWithMargins(childAt, i, 0, i2, i30);
                        if (i29 != i40) {
                            ((LinearLayout.LayoutParams) layoutParams2).height = i29;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i49 = this.f1268f;
                        this.f1268f = Math.max(i49, i49 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin);
                        int i50 = i45;
                        if (z15) {
                            i45 = Math.max(measuredHeight, i50);
                        }
                        z11 = z17;
                    }
                    if (i31 >= 0 && i31 == i42 + 1) {
                        this.f1265c = this.f1268f;
                    }
                    if (i42 >= i31 || ((LinearLayout.LayoutParams) layoutParams2).weight <= RecyclerView.f7068F0) {
                        i35 = i33;
                        if (i35 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams2).width == -1) {
                            z12 = z10;
                            z18 = z12;
                        } else {
                            z12 = false;
                        }
                        int i51 = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                        int measuredWidth = childAt.getMeasuredWidth() + i51;
                        max2 = Math.max(i46, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i47, childAt.getMeasuredState());
                        if (z16 && ((LinearLayout.LayoutParams) layoutParams2).width == -1) {
                            z13 = z10;
                        } else {
                            z13 = false;
                        }
                        if (((LinearLayout.LayoutParams) layoutParams2).weight > RecyclerView.f7068F0) {
                            if (!z12) {
                                i51 = measuredWidth;
                            }
                            i44 = Math.max(i44, i51);
                        } else {
                            int i52 = i44;
                            if (!z12) {
                                i51 = measuredWidth;
                            }
                            i43 = Math.max(i43, i51);
                            i44 = i52;
                        }
                        z17 = z11;
                        i47 = combineMeasuredStates;
                        z16 = z13;
                        i42++;
                        mode = i35;
                        i46 = max2;
                        i41 = i31;
                        z14 = z10;
                        mode2 = i32;
                        virtualChildCount = i34;
                        i37 = -2;
                        i38 = 1073741824;
                        i39 = 8;
                        i40 = Integer.MIN_VALUE;
                        f4 = RecyclerView.f7068F0;
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i31 = i41;
                i32 = mode2;
                i35 = mode;
                i34 = virtualChildCount;
                max2 = i46;
                z10 = true;
                i42++;
                mode = i35;
                i46 = max2;
                i41 = i31;
                z14 = z10;
                mode2 = i32;
                virtualChildCount = i34;
                i37 = -2;
                i38 = 1073741824;
                i39 = 8;
                i40 = Integer.MIN_VALUE;
                f4 = RecyclerView.f7068F0;
            }
            int i53 = mode2;
            int i54 = mode;
            int i55 = virtualChildCount;
            boolean z19 = z14;
            int i56 = i43;
            int i57 = i44;
            int i58 = i45;
            int i59 = i46;
            int i60 = i47;
            if (this.f1268f > 0 && hasDividerBeforeChildAt(i55)) {
                this.f1268f += this.f1275m;
            }
            int i61 = i53;
            if (z15 && (i61 == Integer.MIN_VALUE || i61 == 0)) {
                this.f1268f = 0;
                for (int i62 = 0; i62 < i55; i62++) {
                    View childAt2 = getChildAt(i62);
                    if (childAt2 == null) {
                        this.f1268f = this.f1268f;
                    } else if (childAt2.getVisibility() != 8) {
                        LayoutParams layoutParams4 = (LayoutParams) childAt2.getLayoutParams();
                        int i63 = this.f1268f;
                        this.f1268f = Math.max(i63, i63 + i58 + ((LinearLayout.LayoutParams) layoutParams4).topMargin + ((LinearLayout.LayoutParams) layoutParams4).bottomMargin);
                    }
                }
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop() + this.f1268f;
            this.f1268f = paddingBottom;
            int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, 0);
            int i64 = (16777215 & resolveSizeAndState) - this.f1268f;
            if (!z17 && (i64 == 0 || f5 <= RecyclerView.f7068F0)) {
                i56 = Math.max(i56, i57);
                if (z15 && i61 != 1073741824) {
                    for (int i65 = 0; i65 < i55; i65++) {
                        View childAt3 = getChildAt(i65);
                        if (childAt3 != null && childAt3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) childAt3.getLayoutParams())).weight > RecyclerView.f7068F0) {
                            childAt3.measure(View.MeasureSpec.makeMeasureSpec(childAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i58, 1073741824));
                        }
                    }
                }
            } else {
                float f7 = this.f1269g;
                if (f7 > RecyclerView.f7068F0) {
                    f5 = f7;
                }
                this.f1268f = 0;
                int i66 = 0;
                while (i66 < i55) {
                    View childAt4 = getChildAt(i66);
                    if (childAt4.getVisibility() == 8) {
                        i26 = i61;
                    } else {
                        LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                        float f8 = ((LinearLayout.LayoutParams) layoutParams5).weight;
                        if (f8 > RecyclerView.f7068F0) {
                            int i67 = (int) ((i64 * f8) / f5);
                            f5 -= f8;
                            int i68 = i64 - i67;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin, ((LinearLayout.LayoutParams) layoutParams5).width);
                            if (((LinearLayout.LayoutParams) layoutParams5).height == 0) {
                                i28 = 1073741824;
                                if (i61 == 1073741824) {
                                    if (i67 <= 0) {
                                        i67 = 0;
                                    }
                                    childAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i67, 1073741824));
                                    i60 = View.combineMeasuredStates(i60, childAt4.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                    i64 = i68;
                                }
                            } else {
                                i28 = 1073741824;
                            }
                            int measuredHeight2 = childAt4.getMeasuredHeight() + i67;
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            childAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i28));
                            i60 = View.combineMeasuredStates(i60, childAt4.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                            i64 = i68;
                        }
                        int i69 = ((LinearLayout.LayoutParams) layoutParams5).leftMargin + ((LinearLayout.LayoutParams) layoutParams5).rightMargin;
                        int measuredWidth2 = childAt4.getMeasuredWidth() + i69;
                        int max3 = Math.max(i59, measuredWidth2);
                        if (i54 != 1073741824) {
                            i26 = i61;
                            i27 = -1;
                        } else {
                            i26 = i61;
                            i27 = -1;
                        }
                        i69 = measuredWidth2;
                        i56 = Math.max(i56, i69);
                        if (z16 && ((LinearLayout.LayoutParams) layoutParams5).width == i27) {
                            z9 = z19;
                        } else {
                            z9 = false;
                        }
                        int i70 = this.f1268f;
                        this.f1268f = Math.max(i70, childAt4.getMeasuredHeight() + i70 + ((LinearLayout.LayoutParams) layoutParams5).topMargin + ((LinearLayout.LayoutParams) layoutParams5).bottomMargin);
                        z16 = z9;
                        i59 = max3;
                    }
                    i66++;
                    i61 = i26;
                }
                this.f1268f = getPaddingBottom() + getPaddingTop() + this.f1268f;
            }
            int i71 = i59;
            if (z16 || i54 == 1073741824) {
                i56 = i71;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + i56, getSuggestedMinimumWidth()), i, i60), resolveSizeAndState);
            if (z18) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                for (int i72 = 0; i72 < i55; i72++) {
                    View childAt5 = getChildAt(i72);
                    if (childAt5.getVisibility() != 8) {
                        LayoutParams layoutParams6 = (LayoutParams) childAt5.getLayoutParams();
                        if (((LinearLayout.LayoutParams) layoutParams6).width == -1) {
                            int i73 = ((LinearLayout.LayoutParams) layoutParams6).height;
                            ((LinearLayout.LayoutParams) layoutParams6).height = childAt5.getMeasuredHeight();
                            measureChildWithMargins(childAt5, makeMeasureSpec, 0, i2, 0);
                            ((LinearLayout.LayoutParams) layoutParams6).height = i73;
                        }
                    }
                }
                return;
            }
            return;
        }
        this.f1268f = 0;
        int virtualChildCount2 = getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i);
        int mode4 = View.MeasureSpec.getMode(i2);
        if (this.f1271i == null || this.f1272j == null) {
            this.f1271i = new int[4];
            this.f1272j = new int[4];
        }
        int[] iArr = this.f1271i;
        int[] iArr2 = this.f1272j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z20 = this.f1263a;
        boolean z21 = this.f1270h;
        if (mode3 == 1073741824) {
            z = true;
        } else {
            z = false;
        }
        boolean z22 = true;
        int i74 = 0;
        float f9 = RecyclerView.f7068F0;
        int i75 = 0;
        int i76 = 0;
        int i77 = 0;
        int i78 = 0;
        int i79 = 0;
        boolean z23 = false;
        boolean z24 = false;
        while (i76 < virtualChildCount2) {
            View childAt6 = getChildAt(i76);
            if (childAt6 == null) {
                this.f1268f = this.f1268f;
                i21 = i76;
                z4 = z21;
                z5 = z20;
            } else {
                int i80 = i74;
                int i81 = i75;
                if (childAt6.getVisibility() == 8) {
                    z5 = z20;
                    i74 = i80;
                    i75 = i81;
                    i21 = i76;
                    z4 = z21;
                } else {
                    if (hasDividerBeforeChildAt(i76)) {
                        this.f1268f += this.f1274l;
                    }
                    LayoutParams layoutParams7 = (LayoutParams) childAt6.getLayoutParams();
                    float f10 = ((LinearLayout.LayoutParams) layoutParams7).weight;
                    float f11 = f9 + f10;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams7).width == 0 && f10 > RecyclerView.f7068F0) {
                        if (z) {
                            i25 = i76;
                            this.f1268f = ((LinearLayout.LayoutParams) layoutParams7).leftMargin + ((LinearLayout.LayoutParams) layoutParams7).rightMargin + this.f1268f;
                        } else {
                            i25 = i76;
                            int i82 = this.f1268f;
                            this.f1268f = Math.max(i82, ((LinearLayout.LayoutParams) layoutParams7).leftMargin + i82 + ((LinearLayout.LayoutParams) layoutParams7).rightMargin);
                        }
                        if (z20) {
                            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt6.measure(makeMeasureSpec2, makeMeasureSpec2);
                            layoutParams = layoutParams7;
                            i18 = i80;
                            i19 = i81;
                            i21 = i25;
                            z4 = z21;
                            z5 = z20;
                        } else {
                            layoutParams = layoutParams7;
                            i18 = i80;
                            i19 = i81;
                            i21 = i25;
                            i22 = 1073741824;
                            z4 = z21;
                            z5 = z20;
                            z6 = true;
                            if (mode4 == i22 && ((LinearLayout.LayoutParams) layoutParams).height == -1) {
                                z7 = true;
                                z24 = true;
                            } else {
                                z7 = false;
                            }
                            i23 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            int measuredHeight3 = childAt6.getMeasuredHeight() + i23;
                            int combineMeasuredStates2 = View.combineMeasuredStates(i77, childAt6.getMeasuredState());
                            if (!z5 && (baseline2 = childAt6.getBaseline()) != -1) {
                                int i83 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                                if (i83 < 0) {
                                    i83 = this.f1267e;
                                }
                                int i84 = (((i83 & 112) >> 4) & (-2)) >> 1;
                                i24 = i23;
                                iArr[i84] = Math.max(iArr[i84], baseline2);
                                iArr2[i84] = Math.max(iArr2[i84], measuredHeight3 - baseline2);
                            } else {
                                i24 = i23;
                            }
                            int max4 = Math.max(i19, measuredHeight3);
                            if (!z22 && ((LinearLayout.LayoutParams) layoutParams).height == -1) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            if (((LinearLayout.LayoutParams) layoutParams).weight <= RecyclerView.f7068F0) {
                                if (z7) {
                                    measuredHeight3 = i24;
                                }
                                i79 = Math.max(i79, measuredHeight3);
                                i74 = i18;
                            } else {
                                if (z7) {
                                    measuredHeight3 = i24;
                                }
                                i74 = Math.max(i18, measuredHeight3);
                            }
                            i75 = max4;
                            i77 = combineMeasuredStates2;
                            z23 = z6;
                            z22 = z8;
                            f9 = f11;
                        }
                    } else {
                        int i85 = i76;
                        if (((LinearLayout.LayoutParams) layoutParams7).width == 0) {
                            f3 = RecyclerView.f7068F0;
                            if (f10 > RecyclerView.f7068F0) {
                                ((LinearLayout.LayoutParams) layoutParams7).width = -2;
                                i16 = 0;
                                if (f11 != f3) {
                                    i17 = this.f1268f;
                                } else {
                                    i17 = 0;
                                }
                                i18 = i80;
                                i19 = i81;
                                i20 = i16;
                                i21 = i85;
                                z4 = z21;
                                z5 = z20;
                                measureChildWithMargins(childAt6, i, i17, i2, 0);
                                if (i20 == Integer.MIN_VALUE) {
                                    layoutParams = layoutParams7;
                                    ((LinearLayout.LayoutParams) layoutParams).width = i20;
                                } else {
                                    layoutParams = layoutParams7;
                                }
                                int measuredWidth3 = childAt6.getMeasuredWidth();
                                if (!z) {
                                    this.f1268f = ((LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams).rightMargin + this.f1268f;
                                } else {
                                    int i86 = this.f1268f;
                                    this.f1268f = Math.max(i86, i86 + measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                                }
                                if (z4) {
                                    i78 = Math.max(measuredWidth3, i78);
                                }
                            }
                        } else {
                            f3 = RecyclerView.f7068F0;
                        }
                        i16 = Integer.MIN_VALUE;
                        if (f11 != f3) {
                        }
                        i18 = i80;
                        i19 = i81;
                        i20 = i16;
                        i21 = i85;
                        z4 = z21;
                        z5 = z20;
                        measureChildWithMargins(childAt6, i, i17, i2, 0);
                        if (i20 == Integer.MIN_VALUE) {
                        }
                        int measuredWidth32 = childAt6.getMeasuredWidth();
                        if (!z) {
                        }
                        if (z4) {
                        }
                    }
                    z6 = z23;
                    i22 = 1073741824;
                    if (mode4 == i22) {
                    }
                    z7 = false;
                    i23 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    int measuredHeight32 = childAt6.getMeasuredHeight() + i23;
                    int combineMeasuredStates22 = View.combineMeasuredStates(i77, childAt6.getMeasuredState());
                    if (!z5) {
                    }
                    i24 = i23;
                    int max42 = Math.max(i19, measuredHeight32);
                    if (!z22) {
                    }
                    z8 = false;
                    if (((LinearLayout.LayoutParams) layoutParams).weight <= RecyclerView.f7068F0) {
                    }
                    i75 = max42;
                    i77 = combineMeasuredStates22;
                    z23 = z6;
                    z22 = z8;
                    f9 = f11;
                }
            }
            i76 = i21 + 1;
            z21 = z4;
            z20 = z5;
        }
        int i87 = i75;
        boolean z25 = z21;
        boolean z26 = z20;
        if (this.f1268f > 0 && hasDividerBeforeChildAt(virtualChildCount2)) {
            this.f1268f += this.f1274l;
        }
        int i88 = iArr[1];
        if (i88 == -1 && iArr[0] == -1 && iArr[2] == -1) {
            c = 3;
            if (iArr[3] == -1) {
                max = i87;
                i3 = i77;
                if (z25 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
                    this.f1268f = 0;
                    for (i15 = 0; i15 < virtualChildCount2; i15++) {
                        View childAt7 = getChildAt(i15);
                        if (childAt7 == null) {
                            this.f1268f = this.f1268f;
                        } else if (childAt7.getVisibility() != 8) {
                            LayoutParams layoutParams8 = (LayoutParams) childAt7.getLayoutParams();
                            if (z) {
                                this.f1268f = ((LinearLayout.LayoutParams) layoutParams8).leftMargin + i78 + ((LinearLayout.LayoutParams) layoutParams8).rightMargin + this.f1268f;
                            } else {
                                int i89 = this.f1268f;
                                this.f1268f = Math.max(i89, i89 + i78 + ((LinearLayout.LayoutParams) layoutParams8).leftMargin + ((LinearLayout.LayoutParams) layoutParams8).rightMargin);
                            }
                        }
                    }
                }
                int paddingRight = getPaddingRight() + getPaddingLeft() + this.f1268f;
                this.f1268f = paddingRight;
                int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, 0);
                int i90 = (16777215 & resolveSizeAndState2) - this.f1268f;
                if (z23 && (i90 == 0 || f9 <= RecyclerView.f7068F0)) {
                    i74 = Math.max(i74, i79);
                    if (z25 && mode3 != 1073741824) {
                        for (int i91 = 0; i91 < virtualChildCount2; i91++) {
                            View childAt8 = getChildAt(i91);
                            if (childAt8 != null && childAt8.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) childAt8.getLayoutParams())).weight > RecyclerView.f7068F0) {
                                childAt8.measure(View.MeasureSpec.makeMeasureSpec(i78, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt8.getMeasuredHeight(), 1073741824));
                            }
                        }
                    }
                    i5 = i2;
                    i6 = virtualChildCount2;
                    i8 = 0;
                } else {
                    f = this.f1269g;
                    if (f > RecyclerView.f7068F0) {
                        f9 = f;
                    }
                    iArr[3] = -1;
                    iArr[2] = -1;
                    iArr[1] = -1;
                    iArr[0] = -1;
                    iArr2[3] = -1;
                    iArr2[2] = -1;
                    iArr2[1] = -1;
                    iArr2[0] = -1;
                    this.f1268f = 0;
                    int i92 = i3;
                    max = -1;
                    i4 = 0;
                    while (i4 < virtualChildCount2) {
                        View childAt9 = getChildAt(i4);
                        if (childAt9 == null || childAt9.getVisibility() == 8) {
                            i9 = i90;
                            i10 = virtualChildCount2;
                        } else {
                            LayoutParams layoutParams9 = (LayoutParams) childAt9.getLayoutParams();
                            float f12 = ((LinearLayout.LayoutParams) layoutParams9).weight;
                            if (f12 > RecyclerView.f7068F0) {
                                i10 = virtualChildCount2;
                                int i93 = (int) ((i90 * f12) / f9);
                                float f13 = f9 - f12;
                                int i94 = i90 - i93;
                                int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) layoutParams9).topMargin + ((LinearLayout.LayoutParams) layoutParams9).bottomMargin, ((LinearLayout.LayoutParams) layoutParams9).height);
                                if (((LinearLayout.LayoutParams) layoutParams9).width == 0) {
                                    i14 = 1073741824;
                                    if (mode3 == 1073741824) {
                                        if (i93 <= 0) {
                                            i93 = 0;
                                        }
                                        childAt9.measure(View.MeasureSpec.makeMeasureSpec(i93, 1073741824), childMeasureSpec2);
                                        i92 = View.combineMeasuredStates(i92, childAt9.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                                        f9 = f13;
                                        i11 = i94;
                                    }
                                } else {
                                    i14 = 1073741824;
                                }
                                int measuredWidth4 = childAt9.getMeasuredWidth() + i93;
                                if (measuredWidth4 < 0) {
                                    measuredWidth4 = 0;
                                }
                                childAt9.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i14), childMeasureSpec2);
                                i92 = View.combineMeasuredStates(i92, childAt9.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                                f9 = f13;
                                i11 = i94;
                            } else {
                                i11 = i90;
                                i10 = virtualChildCount2;
                            }
                            if (z) {
                                f2 = f9;
                                this.f1268f = childAt9.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams9).leftMargin + ((LinearLayout.LayoutParams) layoutParams9).rightMargin + this.f1268f;
                                i12 = i11;
                            } else {
                                f2 = f9;
                                int i95 = this.f1268f;
                                i12 = i11;
                                this.f1268f = Math.max(i95, childAt9.getMeasuredWidth() + i95 + ((LinearLayout.LayoutParams) layoutParams9).leftMargin + ((LinearLayout.LayoutParams) layoutParams9).rightMargin);
                            }
                            if (mode4 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams9).height == -1) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            int i96 = ((LinearLayout.LayoutParams) layoutParams9).topMargin + ((LinearLayout.LayoutParams) layoutParams9).bottomMargin;
                            int measuredHeight4 = childAt9.getMeasuredHeight() + i96;
                            max = Math.max(max, measuredHeight4);
                            if (!z2) {
                                i96 = measuredHeight4;
                            }
                            i74 = Math.max(i74, i96);
                            if (z22) {
                                i13 = -1;
                                if (((LinearLayout.LayoutParams) layoutParams9).height == -1) {
                                    z3 = true;
                                    if (!z26 && (baseline = childAt9.getBaseline()) != i13) {
                                        int i97 = ((LinearLayout.LayoutParams) layoutParams9).gravity;
                                        if (i97 < 0) {
                                            i97 = this.f1267e;
                                        }
                                        int i98 = (((i97 & 112) >> 4) & (-2)) >> 1;
                                        iArr[i98] = Math.max(iArr[i98], baseline);
                                        iArr2[i98] = Math.max(iArr2[i98], measuredHeight4 - baseline);
                                    }
                                    z22 = z3;
                                    i9 = i12;
                                    f9 = f2;
                                }
                            } else {
                                i13 = -1;
                            }
                            z3 = false;
                            if (!z26) {
                            }
                            z22 = z3;
                            i9 = i12;
                            f9 = f2;
                        }
                        i4++;
                        i90 = i9;
                        virtualChildCount2 = i10;
                    }
                    i5 = i2;
                    i6 = virtualChildCount2;
                    this.f1268f = getPaddingRight() + getPaddingLeft() + this.f1268f;
                    i7 = iArr[1];
                    if (i7 != -1 && iArr[0] == -1 && iArr[2] == -1) {
                        c2 = 3;
                        if (iArr[3] == -1) {
                            i8 = 0;
                            i3 = i92;
                        }
                    } else {
                        c2 = 3;
                    }
                    i8 = 0;
                    max = Math.max(max, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(i7, iArr[2]))));
                    i3 = i92;
                }
                if (!z22 || mode4 == 1073741824) {
                    i74 = max;
                }
                setMeasuredDimension((i3 & ViewCompat.MEASURED_STATE_MASK) | resolveSizeAndState2, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i74, getSuggestedMinimumHeight()), i5, i3 << 16));
                if (!z24) {
                    int makeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
                    int i99 = i6;
                    while (i8 < i99) {
                        View childAt10 = getChildAt(i8);
                        if (childAt10.getVisibility() != 8) {
                            LayoutParams layoutParams10 = (LayoutParams) childAt10.getLayoutParams();
                            if (((LinearLayout.LayoutParams) layoutParams10).height == -1) {
                                int i100 = ((LinearLayout.LayoutParams) layoutParams10).width;
                                ((LinearLayout.LayoutParams) layoutParams10).width = childAt10.getMeasuredWidth();
                                measureChildWithMargins(childAt10, i, 0, makeMeasureSpec3, 0);
                                ((LinearLayout.LayoutParams) layoutParams10).width = i100;
                            }
                        }
                        i8++;
                    }
                    return;
                }
                return;
            }
        } else {
            c = 3;
        }
        i3 = i77;
        max = Math.max(i87, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c], Math.max(iArr[0], Math.max(i88, iArr[2]))));
        if (z25) {
            this.f1268f = 0;
            while (i15 < virtualChildCount2) {
            }
        }
        int paddingRight2 = getPaddingRight() + getPaddingLeft() + this.f1268f;
        this.f1268f = paddingRight2;
        int resolveSizeAndState22 = View.resolveSizeAndState(Math.max(paddingRight2, getSuggestedMinimumWidth()), i, 0);
        int i902 = (16777215 & resolveSizeAndState22) - this.f1268f;
        if (z23) {
        }
        f = this.f1269g;
        if (f > RecyclerView.f7068F0) {
        }
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        this.f1268f = 0;
        int i922 = i3;
        max = -1;
        i4 = 0;
        while (i4 < virtualChildCount2) {
        }
        i5 = i2;
        i6 = virtualChildCount2;
        this.f1268f = getPaddingRight() + getPaddingLeft() + this.f1268f;
        i7 = iArr[1];
        if (i7 != -1) {
        }
        c2 = 3;
        i8 = 0;
        max = Math.max(max, Math.max(iArr2[c2], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[c2], Math.max(iArr[0], Math.max(i7, iArr[2]))));
        i3 = i922;
        if (!z22) {
        }
        i74 = max;
        setMeasuredDimension((i3 & ViewCompat.MEASURED_STATE_MASK) | resolveSizeAndState22, View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + i74, getSuggestedMinimumHeight()), i5, i3 << 16));
        if (!z24) {
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f1263a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f1264b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1273k) {
            return;
        }
        this.f1273k = drawable;
        boolean z = false;
        if (drawable != null) {
            this.f1274l = drawable.getIntrinsicWidth();
            this.f1275m = drawable.getIntrinsicHeight();
        } else {
            this.f1274l = 0;
            this.f1275m = 0;
        }
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f1277o = i;
    }

    public void setGravity(@GravityInt int i) {
        if (this.f1267e != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f1267e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.f1267e;
        if ((8388615 & i3) != i2) {
            this.f1267e = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1270h = z;
    }

    public void setOrientation(int i) {
        if (this.f1266d != i) {
            this.f1266d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f1276n) {
            requestLayout();
        }
        this.f1276n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.f1267e;
        if ((i3 & 112) != i2) {
            this.f1267e = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f1269g = Math.max(RecyclerView.f7068F0, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.f1266d;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1263a = true;
        this.f1264b = -1;
        this.f1265c = 0;
        this.f1267e = 8388659;
        int[] iArr = androidx.appcompat.R.styleable.LinearLayoutCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.f1269g = obtainStyledAttributes.getFloat(androidx.appcompat.R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1264b = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1270h = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.LinearLayoutCompat_divider));
        this.f1276n = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f1277o = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
