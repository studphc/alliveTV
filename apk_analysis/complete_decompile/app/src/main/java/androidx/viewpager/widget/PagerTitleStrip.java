package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;

@ViewPager.DecorView
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: o */
    public static final int[] f7600o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: p */
    public static final int[] f7601p = {R.attr.textAllCaps};

    /* renamed from: a */
    public ViewPager f7602a;

    /* renamed from: b */
    public final TextView f7603b;

    /* renamed from: c */
    public final TextView f7604c;

    /* renamed from: d */
    public final TextView f7605d;

    /* renamed from: e */
    public int f7606e;

    /* renamed from: f */
    public float f7607f;

    /* renamed from: g */
    public int f7608g;

    /* renamed from: h */
    public int f7609h;

    /* renamed from: i */
    public boolean f7610i;

    /* renamed from: j */
    public boolean f7611j;

    /* renamed from: k */
    public final C0524a f7612k;

    /* renamed from: l */
    public WeakReference f7613l;

    /* renamed from: m */
    public int f7614m;

    /* renamed from: n */
    public int f7615n;

    public PagerTitleStrip(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [w12, android.text.method.SingleLineTransformationMethod, android.text.method.TransformationMethod] */
    private static void setSingleLineAllCaps(TextView textView) {
        Context context = textView.getContext();
        ?? singleLineTransformationMethod = new SingleLineTransformationMethod();
        singleLineTransformationMethod.f28042a = context.getResources().getConfiguration().locale;
        textView.setTransformationMethod(singleLineTransformationMethod);
    }

    /* renamed from: a */
    public final void m1929a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        C0524a c0524a = this.f7612k;
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(c0524a);
            this.f7613l = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(c0524a);
            this.f7613l = new WeakReference(pagerAdapter2);
        }
        ViewPager viewPager = this.f7602a;
        if (viewPager != null) {
            this.f7606e = -1;
            this.f7607f = -1.0f;
            m1930b(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    /* renamed from: b */
    public final void m1930b(int i, PagerAdapter pagerAdapter) {
        int i2;
        CharSequence charSequence;
        CharSequence charSequence2;
        if (pagerAdapter != null) {
            i2 = pagerAdapter.getCount();
        } else {
            i2 = 0;
        }
        this.f7610i = true;
        CharSequence charSequence3 = null;
        if (i >= 1 && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i - 1);
        } else {
            charSequence = null;
        }
        TextView textView = this.f7603b;
        textView.setText(charSequence);
        TextView textView2 = this.f7604c;
        if (pagerAdapter != null && i < i2) {
            charSequence2 = pagerAdapter.getPageTitle(i);
        } else {
            charSequence2 = null;
        }
        textView2.setText(charSequence2);
        int i3 = i + 1;
        if (i3 < i2 && pagerAdapter != null) {
            charSequence3 = pagerAdapter.getPageTitle(i3);
        }
        TextView textView3 = this.f7605d;
        textView3.setText(charSequence3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        textView.measure(makeMeasureSpec, makeMeasureSpec2);
        textView2.measure(makeMeasureSpec, makeMeasureSpec2);
        textView3.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f7606e = i;
        if (!this.f7611j) {
            mo1928c(i, false, this.f7607f);
        }
        this.f7610i = false;
    }

    /* renamed from: c */
    public void mo1928c(int i, boolean z, float f) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (i != this.f7606e) {
            m1930b(i, this.f7602a.getAdapter());
        } else if (!z && f == this.f7607f) {
            return;
        }
        this.f7611j = true;
        TextView textView = this.f7603b;
        int measuredWidth = textView.getMeasuredWidth();
        TextView textView2 = this.f7604c;
        int measuredWidth2 = textView2.getMeasuredWidth();
        TextView textView3 = this.f7605d;
        int measuredWidth3 = textView3.getMeasuredWidth();
        int i6 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i7 = paddingRight + i6;
        int i8 = (width - (paddingLeft + i6)) - i7;
        float f2 = f + 0.5f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i9 = ((width - i7) - ((int) (i8 * f2))) - i6;
        int i10 = measuredWidth2 + i9;
        int baseline = textView.getBaseline();
        int baseline2 = textView2.getBaseline();
        int baseline3 = textView3.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i11 = max - baseline;
        int i12 = max - baseline2;
        int i13 = max - baseline3;
        int max2 = Math.max(Math.max(textView.getMeasuredHeight() + i11, textView2.getMeasuredHeight() + i12), textView3.getMeasuredHeight() + i13);
        int i14 = this.f7609h & 112;
        if (i14 != 16) {
            if (i14 != 80) {
                i3 = i11 + paddingTop;
                i4 = i12 + paddingTop;
                i5 = paddingTop + i13;
                textView2.layout(i9, i4, i10, textView2.getMeasuredHeight() + i4);
                int min = Math.min(paddingLeft, (i9 - this.f7608g) - measuredWidth);
                textView.layout(min, i3, measuredWidth + min, textView.getMeasuredHeight() + i3);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.f7608g);
                textView3.layout(max3, i5, max3 + measuredWidth3, textView3.getMeasuredHeight() + i5);
                this.f7607f = f;
                this.f7611j = false;
            }
            i2 = (height - paddingBottom) - max2;
        } else {
            i2 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        }
        i3 = i11 + i2;
        i4 = i12 + i2;
        i5 = i2 + i13;
        textView2.layout(i9, i4, i10, textView2.getMeasuredHeight() + i4);
        int min2 = Math.min(paddingLeft, (i9 - this.f7608g) - measuredWidth);
        textView.layout(min2, i3, measuredWidth + min2, textView.getMeasuredHeight() + i3);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.f7608g);
        textView3.layout(max32, i5, max32 + measuredWidth3, textView3.getMeasuredHeight() + i5);
        this.f7607f = f;
        this.f7611j = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f7608g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        PagerAdapter pagerAdapter;
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            PagerAdapter adapter = viewPager.getAdapter();
            C0524a c0524a = this.f7612k;
            viewPager.f7641V = c0524a;
            viewPager.addOnAdapterChangeListener(c0524a);
            this.f7602a = viewPager;
            WeakReference weakReference = this.f7613l;
            if (weakReference != null) {
                pagerAdapter = (PagerAdapter) weakReference.get();
            } else {
                pagerAdapter = null;
            }
            m1929a(pagerAdapter, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f7602a;
        if (viewPager != null) {
            m1929a(viewPager.getAdapter(), null);
            ViewPager viewPager2 = this.f7602a;
            ViewPager.OnPageChangeListener onPageChangeListener = viewPager2.f7641V;
            viewPager2.f7641V = null;
            viewPager2.removeOnAdapterChangeListener(this.f7612k);
            this.f7602a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f7602a != null) {
            float f = this.f7607f;
            if (f < RecyclerView.f7068F0) {
                f = 0.0f;
            }
            mo1928c(this.f7606e, true, f);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int max;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
            int size = View.MeasureSpec.getSize(i);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, (int) (size * 0.2f), -2);
            this.f7603b.measure(childMeasureSpec2, childMeasureSpec);
            TextView textView = this.f7604c;
            textView.measure(childMeasureSpec2, childMeasureSpec);
            this.f7605d.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                max = View.MeasureSpec.getSize(i2);
            } else {
                max = Math.max(getMinHeight(), textView.getMeasuredHeight() + paddingBottom);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(max, i2, textView.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f7610i) {
            super.requestLayout();
        }
    }

    public void setGravity(int i) {
        this.f7609h = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, m152to = 1.0d) float f) {
        int i = ((int) (f * 255.0f)) & 255;
        this.f7614m = i;
        int i2 = (i << 24) | (this.f7615n & ViewCompat.MEASURED_SIZE_MASK);
        this.f7603b.setTextColor(i2);
        this.f7605d.setTextColor(i2);
    }

    public void setTextColor(@ColorInt int i) {
        this.f7615n = i;
        this.f7604c.setTextColor(i);
        int i2 = (this.f7614m << 24) | (this.f7615n & ViewCompat.MEASURED_SIZE_MASK);
        this.f7603b.setTextColor(i2);
        this.f7605d.setTextColor(i2);
    }

    public void setTextSize(int i, float f) {
        this.f7603b.setTextSize(i, f);
        this.f7604c.setTextSize(i, f);
        this.f7605d.setTextSize(i, f);
    }

    public void setTextSpacing(int i) {
        this.f7608g = i;
        requestLayout();
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7606e = -1;
        this.f7607f = -1.0f;
        this.f7612k = new C0524a(this);
        TextView textView = new TextView(context);
        this.f7603b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f7604c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f7605d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7600o);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(textView, resourceId);
            TextViewCompat.setTextAppearance(textView2, resourceId);
            TextViewCompat.setTextAppearance(textView3, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            textView.setTextColor(color);
            textView2.setTextColor(color);
            textView3.setTextColor(color);
        }
        this.f7609h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f7615n = textView2.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView2.setEllipsize(truncateAt);
        textView3.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f7601p);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(textView);
            setSingleLineAllCaps(textView2);
            setSingleLineAllCaps(textView3);
        } else {
            textView.setSingleLine();
            textView2.setSingleLine();
            textView3.setSingleLine();
        }
        this.f7608g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
