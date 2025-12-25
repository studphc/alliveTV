package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CircularFlow extends VirtualLayout {

    /* renamed from: n */
    public static int f2633n;

    /* renamed from: o */
    public static float f2634o;

    /* renamed from: d */
    public ConstraintLayout f2635d;

    /* renamed from: e */
    public int f2636e;

    /* renamed from: f */
    public float[] f2637f;

    /* renamed from: g */
    public int[] f2638g;

    /* renamed from: h */
    public int f2639h;

    /* renamed from: i */
    public int f2640i;

    /* renamed from: j */
    public String f2641j;

    /* renamed from: k */
    public String f2642k;

    /* renamed from: l */
    public Float f2643l;

    /* renamed from: m */
    public Integer f2644m;

    public CircularFlow(Context context) {
        super(context);
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.f2640i = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                m535f(str.substring(i).trim());
                return;
            } else {
                m535f(str.substring(i, indexOf).trim());
                i = indexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        this.f2639h = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                m536g(str.substring(i).trim());
                return;
            } else {
                m536g(str.substring(i, indexOf).trim());
                i = indexOf + 1;
            }
        }
    }

    public void addViewToCircularFlow(View view, int i, float f) {
        if (containsId(view.getId())) {
            return;
        }
        addView(view);
        this.f2640i++;
        float[] angles = getAngles();
        this.f2637f = angles;
        angles[this.f2640i - 1] = f;
        this.f2639h++;
        int[] radius = getRadius();
        this.f2638g = radius;
        radius[this.f2639h - 1] = (int) (i * this.myContext.getResources().getDisplayMetrics().density);
        m537h();
    }

    /* renamed from: f */
    public final void m535f(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.myContext == null || (fArr = this.f2637f) == null) {
            return;
        }
        if (this.f2640i + 1 > fArr.length) {
            this.f2637f = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.f2637f[this.f2640i] = Integer.parseInt(str);
        this.f2640i++;
    }

    /* renamed from: g */
    public final void m536g(String str) {
        int[] iArr;
        if (str == null || str.length() == 0 || this.myContext == null || (iArr = this.f2638g) == null) {
            return;
        }
        if (this.f2639h + 1 > iArr.length) {
            this.f2638g = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f2638g[this.f2639h] = (int) (Integer.parseInt(str) * this.myContext.getResources().getDisplayMetrics().density);
        this.f2639h++;
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f2637f, this.f2640i);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f2638g, this.f2639h);
    }

    /* renamed from: h */
    public final void m537h() {
        this.f2635d = (ConstraintLayout) getParent();
        for (int i = 0; i < this.mCount; i++) {
            View viewById = this.f2635d.getViewById(this.mIds[i]);
            if (viewById != null) {
                int i2 = f2633n;
                float f = f2634o;
                int[] iArr = this.f2638g;
                if (iArr != null && i < iArr.length) {
                    i2 = iArr[i];
                } else {
                    Integer num = this.f2644m;
                    if (num != null && num.intValue() != -1) {
                        this.f2639h++;
                        if (this.f2638g == null) {
                            this.f2638g = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f2638g = radius;
                        radius[this.f2639h - 1] = i2;
                    } else {
                        Log.e("CircularFlow", "Added radius to view with id: " + this.mMap.get(Integer.valueOf(viewById.getId())));
                    }
                }
                float[] fArr = this.f2637f;
                if (fArr != null && i < fArr.length) {
                    f = fArr[i];
                } else {
                    Float f2 = this.f2643l;
                    if (f2 != null && f2.floatValue() != -1.0f) {
                        this.f2640i++;
                        if (this.f2637f == null) {
                            this.f2637f = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f2637f = angles;
                        angles[this.f2640i - 1] = f;
                    } else {
                        Log.e("CircularFlow", "Added angle to view with id: " + this.mMap.get(Integer.valueOf(viewById.getId())));
                    }
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.circleAngle = f;
                layoutParams.circleConstraint = this.f2636e;
                layoutParams.circleRadius = i2;
                viewById.setLayoutParams(layoutParams);
            }
        }
        applyLayoutFeatures();
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f2636e = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f2641j = string;
                    setAngles(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f2642k = string2;
                    setRadius(string2);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, f2634o));
                    this.f2643l = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, f2633n));
                    this.f2644m = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isUpdatable(View view) {
        if (!containsId(view.getId()) || indexFromId(view.getId()) == -1) {
            return false;
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f2641j;
        if (str != null) {
            this.f2637f = new float[1];
            setAngles(str);
        }
        String str2 = this.f2642k;
        if (str2 != null) {
            this.f2638g = new int[1];
            setRadius(str2);
        }
        Float f = this.f2643l;
        if (f != null) {
            setDefaultAngle(f.floatValue());
        }
        Integer num = this.f2644m;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        m537h();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public int removeView(View view) {
        int removeView = super.removeView(view);
        if (removeView == -1) {
            return removeView;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.f2635d);
        constraintSet.clear(view.getId(), 8);
        constraintSet.applyTo(this.f2635d);
        float[] fArr = this.f2637f;
        if (removeView < fArr.length) {
            if (fArr != null && removeView >= 0 && removeView < this.f2640i) {
                float[] fArr2 = new float[fArr.length - 1];
                int i = 0;
                for (int i2 = 0; i2 < fArr.length; i2++) {
                    if (i2 != removeView) {
                        fArr2[i] = fArr[i2];
                        i++;
                    }
                }
                fArr = fArr2;
            }
            this.f2637f = fArr;
            this.f2640i--;
        }
        int[] iArr = this.f2638g;
        if (removeView < iArr.length) {
            if (iArr != null && removeView >= 0 && removeView < this.f2639h) {
                int[] iArr2 = new int[iArr.length - 1];
                int i3 = 0;
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    if (i4 != removeView) {
                        iArr2[i3] = iArr[i4];
                        i3++;
                    }
                }
                iArr = iArr2;
            }
            this.f2638g = iArr;
            this.f2639h--;
        }
        m537h();
        return removeView;
    }

    public void setDefaultAngle(float f) {
        f2634o = f;
    }

    public void setDefaultRadius(int i) {
        f2633n = i;
    }

    public void updateAngle(View view, float f) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.f2637f.length) {
            return;
        }
        float[] angles = getAngles();
        this.f2637f = angles;
        angles[indexFromId] = f;
        m537h();
    }

    public void updateRadius(View view, int i) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update radius to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId > this.f2638g.length) {
            return;
        }
        int[] radius = getRadius();
        this.f2638g = radius;
        radius[indexFromId] = (int) (i * this.myContext.getResources().getDisplayMetrics().density);
        m537h();
    }

    public void updateReference(View view, int i, float f) {
        if (!isUpdatable(view)) {
            Log.e("CircularFlow", "It was not possible to update radius and angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (getAngles().length > indexFromId) {
            float[] angles = getAngles();
            this.f2637f = angles;
            angles[indexFromId] = f;
        }
        if (getRadius().length > indexFromId) {
            int[] radius = getRadius();
            this.f2638g = radius;
            radius[indexFromId] = (int) (i * this.myContext.getResources().getDisplayMetrics().density);
        }
        m537h();
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
