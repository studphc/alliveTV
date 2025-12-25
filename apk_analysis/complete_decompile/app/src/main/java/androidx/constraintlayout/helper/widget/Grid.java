package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public class Grid extends VirtualLayout {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: d */
    public View[] f2646d;

    /* renamed from: e */
    public ConstraintLayout f2647e;

    /* renamed from: f */
    public int f2648f;

    /* renamed from: g */
    public int f2649g;

    /* renamed from: h */
    public int f2650h;

    /* renamed from: i */
    public int f2651i;

    /* renamed from: j */
    public String f2652j;

    /* renamed from: k */
    public String f2653k;

    /* renamed from: l */
    public String f2654l;

    /* renamed from: m */
    public String f2655m;

    /* renamed from: n */
    public float f2656n;

    /* renamed from: o */
    public float f2657o;

    /* renamed from: p */
    public int f2658p;

    /* renamed from: q */
    public int f2659q;

    /* renamed from: r */
    public boolean[][] f2660r;

    /* renamed from: s */
    public final HashSet f2661s;

    /* renamed from: t */
    public int[] f2662t;

    public Grid(Context context) {
        super(context);
        this.f2659q = 0;
        this.f2661s = new HashSet();
    }

    /* renamed from: f */
    public static void m538f(View view) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        layoutParams.horizontalWeight = -1.0f;
        layoutParams.leftToRight = -1;
        layoutParams.leftToLeft = -1;
        layoutParams.rightToLeft = -1;
        layoutParams.rightToRight = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: g */
    public static void m539g(View view) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        layoutParams.verticalWeight = -1.0f;
        layoutParams.topToBottom = -1;
        layoutParams.topToTop = -1;
        layoutParams.bottomToTop = -1;
        layoutParams.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = -1;
        view.setLayoutParams(layoutParams);
    }

    private int getNextPosition() {
        boolean z = false;
        int i = 0;
        while (!z) {
            i = this.f2659q;
            if (i >= this.f2648f * this.f2650h) {
                return -1;
            }
            int m545k = m545k(i);
            int m544j = m544j(this.f2659q);
            boolean[] zArr = this.f2660r[m545k];
            if (zArr[m544j]) {
                zArr[m544j] = false;
                z = true;
            }
            this.f2659q++;
        }
        return i;
    }

    /* renamed from: o */
    public static int[][] m540o(String str) {
        String[] split = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, split.length, 3);
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            String[] split3 = split2[1].split("x");
            iArr[i][0] = Integer.parseInt(split2[0]);
            iArr[i][1] = Integer.parseInt(split3[0]);
            iArr[i][2] = Integer.parseInt(split3[1]);
        }
        return iArr;
    }

    /* renamed from: p */
    public static float[] m541p(int i, String str) {
        float[] fArr = null;
        if (str != null && !str.trim().isEmpty()) {
            String[] split = str.split(",");
            if (split.length != i) {
                return null;
            }
            fArr = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                fArr[i2] = Float.parseFloat(split[i2].trim());
            }
        }
        return fArr;
    }

    public String getColumnWeights() {
        return this.f2655m;
    }

    public int getColumns() {
        return this.f2651i;
    }

    public float getHorizontalGaps() {
        return this.f2656n;
    }

    public int getOrientation() {
        return this.f2658p;
    }

    public String getRowWeights() {
        return this.f2654l;
    }

    public int getRows() {
        return this.f2649g;
    }

    public String getSkips() {
        return this.f2653k;
    }

    public String getSpans() {
        return this.f2652j;
    }

    public float getVerticalGaps() {
        return this.f2657o;
    }

    /* renamed from: h */
    public final void m542h(View view, int i, int i2, int i3, int i4) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        int[] iArr = this.f2662t;
        layoutParams.leftToLeft = iArr[i2];
        layoutParams.topToTop = iArr[i];
        layoutParams.rightToRight = iArr[(i2 + i4) - 1];
        layoutParams.bottomToBottom = iArr[(i + i3) - 1];
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: i */
    public final void m543i(boolean z) {
        int i;
        int i2;
        int[][] m540o;
        int[][] m540o2;
        if (this.f2647e != null && this.f2648f >= 1 && this.f2650h >= 1) {
            HashSet hashSet = this.f2661s;
            if (z) {
                for (int i3 = 0; i3 < this.f2660r.length; i3++) {
                    int i4 = 0;
                    while (true) {
                        boolean[][] zArr = this.f2660r;
                        if (i4 < zArr[0].length) {
                            zArr[i3][i4] = true;
                            i4++;
                        }
                    }
                }
                hashSet.clear();
            }
            this.f2659q = 0;
            int max = Math.max(this.f2648f, this.f2650h);
            View[] viewArr = this.f2646d;
            if (viewArr == null) {
                this.f2646d = new View[max];
                int i5 = 0;
                while (true) {
                    View[] viewArr2 = this.f2646d;
                    if (i5 >= viewArr2.length) {
                        break;
                    }
                    viewArr2[i5] = m548n();
                    i5++;
                }
            } else if (max != viewArr.length) {
                View[] viewArr3 = new View[max];
                for (int i6 = 0; i6 < max; i6++) {
                    View[] viewArr4 = this.f2646d;
                    if (i6 < viewArr4.length) {
                        viewArr3[i6] = viewArr4[i6];
                    } else {
                        viewArr3[i6] = m548n();
                    }
                }
                int i7 = max;
                while (true) {
                    View[] viewArr5 = this.f2646d;
                    if (i7 >= viewArr5.length) {
                        break;
                    }
                    this.f2647e.removeView(viewArr5[i7]);
                    i7++;
                }
                this.f2646d = viewArr3;
            }
            this.f2662t = new int[max];
            int i8 = 0;
            while (true) {
                View[] viewArr6 = this.f2646d;
                if (i8 >= viewArr6.length) {
                    break;
                }
                this.f2662t[i8] = viewArr6[i8].getId();
                i8++;
            }
            int id = getId();
            int max2 = Math.max(this.f2648f, this.f2650h);
            float[] m541p = m541p(this.f2648f, this.f2654l);
            if (this.f2648f == 1) {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2646d[0].getLayoutParams();
                m539g(this.f2646d[0]);
                layoutParams.topToTop = id;
                layoutParams.bottomToBottom = id;
                this.f2646d[0].setLayoutParams(layoutParams);
            } else {
                int i9 = 0;
                while (true) {
                    i = this.f2648f;
                    if (i9 >= i) {
                        break;
                    }
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2646d[i9].getLayoutParams();
                    m539g(this.f2646d[i9]);
                    if (m541p != null) {
                        layoutParams2.verticalWeight = m541p[i9];
                    }
                    if (i9 > 0) {
                        layoutParams2.topToBottom = this.f2662t[i9 - 1];
                    } else {
                        layoutParams2.topToTop = id;
                    }
                    if (i9 < this.f2648f - 1) {
                        layoutParams2.bottomToTop = this.f2662t[i9 + 1];
                    } else {
                        layoutParams2.bottomToBottom = id;
                    }
                    if (i9 > 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) this.f2656n;
                    }
                    this.f2646d[i9].setLayoutParams(layoutParams2);
                    i9++;
                }
                while (i < max2) {
                    ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f2646d[i].getLayoutParams();
                    m539g(this.f2646d[i]);
                    layoutParams3.topToTop = id;
                    layoutParams3.bottomToBottom = id;
                    this.f2646d[i].setLayoutParams(layoutParams3);
                    i++;
                }
            }
            int id2 = getId();
            int max3 = Math.max(this.f2648f, this.f2650h);
            float[] m541p2 = m541p(this.f2650h, this.f2655m);
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f2646d[0].getLayoutParams();
            if (this.f2650h == 1) {
                m538f(this.f2646d[0]);
                layoutParams4.leftToLeft = id2;
                layoutParams4.rightToRight = id2;
                this.f2646d[0].setLayoutParams(layoutParams4);
            } else {
                int i10 = 0;
                while (true) {
                    i2 = this.f2650h;
                    if (i10 >= i2) {
                        break;
                    }
                    ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f2646d[i10].getLayoutParams();
                    m538f(this.f2646d[i10]);
                    if (m541p2 != null) {
                        layoutParams5.horizontalWeight = m541p2[i10];
                    }
                    if (i10 > 0) {
                        layoutParams5.leftToRight = this.f2662t[i10 - 1];
                    } else {
                        layoutParams5.leftToLeft = id2;
                    }
                    if (i10 < this.f2650h - 1) {
                        layoutParams5.rightToLeft = this.f2662t[i10 + 1];
                    } else {
                        layoutParams5.rightToRight = id2;
                    }
                    if (i10 > 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = (int) this.f2656n;
                    }
                    this.f2646d[i10].setLayoutParams(layoutParams5);
                    i10++;
                }
                while (i2 < max3) {
                    ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f2646d[i2].getLayoutParams();
                    m538f(this.f2646d[i2]);
                    layoutParams6.leftToLeft = id2;
                    layoutParams6.rightToRight = id2;
                    this.f2646d[i2].setLayoutParams(layoutParams6);
                    i2++;
                }
            }
            String str = this.f2653k;
            if (str != null && !str.trim().isEmpty() && (m540o2 = m540o(this.f2653k)) != null) {
                for (int i11 = 0; i11 < m540o2.length; i11++) {
                    int m545k = m545k(m540o2[i11][0]);
                    int m544j = m544j(m540o2[i11][0]);
                    int[] iArr = m540o2[i11];
                    if (!m547m(m545k, m544j, iArr[1], iArr[2])) {
                        break;
                    }
                }
            }
            String str2 = this.f2652j;
            if (str2 != null && !str2.trim().isEmpty() && (m540o = m540o(this.f2652j)) != null) {
                int[] iArr2 = this.mIds;
                View[] views = getViews(this.f2647e);
                for (int i12 = 0; i12 < m540o.length; i12++) {
                    int m545k2 = m545k(m540o[i12][0]);
                    int m544j2 = m544j(m540o[i12][0]);
                    int[] iArr3 = m540o[i12];
                    if (!m547m(m545k2, m544j2, iArr3[1], iArr3[2])) {
                        break;
                    }
                    View view = views[i12];
                    int[] iArr4 = m540o[i12];
                    m542h(view, m545k2, m544j2, iArr4[1], iArr4[2]);
                    hashSet.add(Integer.valueOf(iArr2[i12]));
                }
            }
            View[] views2 = getViews(this.f2647e);
            for (int i13 = 0; i13 < this.mCount; i13++) {
                if (!hashSet.contains(Integer.valueOf(this.mIds[i13]))) {
                    int nextPosition = getNextPosition();
                    int m545k3 = m545k(nextPosition);
                    int m544j3 = m544j(nextPosition);
                    if (nextPosition != -1) {
                        m542h(views2[i13], m545k3, m544j3, 1, 1);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Grid);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Grid_grid_rows) {
                    this.f2649g = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_columns) {
                    this.f2651i = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_spans) {
                    this.f2652j = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_skips) {
                    this.f2653k = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_rowWeights) {
                    this.f2654l = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_columnWeights) {
                    this.f2655m = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_orientation) {
                    this.f2658p = obtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.Grid_grid_horizontalGaps) {
                    this.f2656n = obtainStyledAttributes.getDimension(index, RecyclerView.f7068F0);
                } else if (index == R.styleable.Grid_grid_verticalGaps) {
                    this.f2657o = obtainStyledAttributes.getDimension(index, RecyclerView.f7068F0);
                } else if (index == R.styleable.Grid_grid_validateInputs) {
                    obtainStyledAttributes.getBoolean(index, false);
                } else if (index == R.styleable.Grid_grid_useRtl) {
                    obtainStyledAttributes.getBoolean(index, false);
                }
            }
            m549q();
            m546l();
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: j */
    public final int m544j(int i) {
        if (this.f2658p == 1) {
            return i / this.f2648f;
        }
        return i % this.f2650h;
    }

    /* renamed from: k */
    public final int m545k(int i) {
        if (this.f2658p == 1) {
            return i % this.f2648f;
        }
        return i / this.f2650h;
    }

    /* renamed from: l */
    public final void m546l() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.f2648f, this.f2650h);
        this.f2660r = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
    }

    /* renamed from: m */
    public final boolean m547m(int i, int i2, int i3, int i4) {
        for (int i5 = i; i5 < i + i3; i5++) {
            for (int i6 = i2; i6 < i2 + i4; i6++) {
                boolean[][] zArr = this.f2660r;
                if (i5 < zArr.length && i6 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i5];
                    if (zArr2[i6]) {
                        zArr2[i6] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: n */
    public final View m548n() {
        View view = new View(getContext());
        view.setId(View.generateViewId());
        view.setVisibility(4);
        this.f2647e.addView(view, new ConstraintLayout.LayoutParams(0, 0));
        return view;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2647e = (ConstraintLayout) getParent();
        m543i(false);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode()) {
            return;
        }
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStyle(Paint.Style.STROKE);
        int top = getTop();
        int left = getLeft();
        int bottom = getBottom();
        int right = getRight();
        View[] viewArr = this.f2646d;
        int length = viewArr.length;
        int i = 0;
        while (i < length) {
            View view = viewArr[i];
            int left2 = view.getLeft() - left;
            int top2 = view.getTop() - top;
            int right2 = view.getRight() - left;
            int bottom2 = view.getBottom() - top;
            canvas.drawRect(left2, RecyclerView.f7068F0, right2, bottom - top, paint);
            canvas.drawRect(RecyclerView.f7068F0, top2, right - left, bottom2, paint);
            i++;
            top = top;
        }
    }

    /* renamed from: q */
    public final void m549q() {
        int i;
        int i2 = this.f2649g;
        if (i2 != 0 && (i = this.f2651i) != 0) {
            this.f2648f = i2;
            this.f2650h = i;
            return;
        }
        int i3 = this.f2651i;
        if (i3 > 0) {
            this.f2650h = i3;
            this.f2648f = ((this.mCount + i3) - 1) / i3;
        } else if (i2 > 0) {
            this.f2648f = i2;
            this.f2650h = ((this.mCount + i2) - 1) / i2;
        } else {
            int sqrt = (int) (Math.sqrt(this.mCount) + 1.5d);
            this.f2648f = sqrt;
            this.f2650h = ((this.mCount + sqrt) - 1) / sqrt;
        }
    }

    public void setColumnWeights(String str) {
        String str2 = this.f2655m;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f2655m = str;
        m543i(true);
        invalidate();
    }

    public void setColumns(int i) {
        if (i > 50 || this.f2651i == i) {
            return;
        }
        this.f2651i = i;
        m549q();
        m546l();
        m543i(false);
        invalidate();
    }

    public void setHorizontalGaps(float f) {
        if (f < RecyclerView.f7068F0 || this.f2656n == f) {
            return;
        }
        this.f2656n = f;
        m543i(true);
        invalidate();
    }

    public void setOrientation(int i) {
        if ((i != 0 && i != 1) || this.f2658p == i) {
            return;
        }
        this.f2658p = i;
        m543i(true);
        invalidate();
    }

    public void setRowWeights(String str) {
        String str2 = this.f2654l;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f2654l = str;
        m543i(true);
        invalidate();
    }

    public void setRows(int i) {
        if (i > 50 || this.f2649g == i) {
            return;
        }
        this.f2649g = i;
        m549q();
        m546l();
        m543i(false);
        invalidate();
    }

    public void setSkips(String str) {
        String str2 = this.f2653k;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f2653k = str;
        m543i(true);
        invalidate();
    }

    public void setSpans(CharSequence charSequence) {
        String str = this.f2652j;
        if (str != null && str.contentEquals(charSequence)) {
            return;
        }
        this.f2652j = charSequence.toString();
        m543i(true);
        invalidate();
    }

    public void setVerticalGaps(float f) {
        if (f < RecyclerView.f7068F0 || this.f2657o == f) {
            return;
        }
        this.f2657o = f;
        m543i(true);
        invalidate();
    }

    public Grid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2659q = 0;
        this.f2661s = new HashSet();
    }

    public Grid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2659q = 0;
        this.f2661s = new HashSet();
    }
}
