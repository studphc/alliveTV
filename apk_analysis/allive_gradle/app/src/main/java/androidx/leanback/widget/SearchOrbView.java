package androidx.leanback.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import p000.jf2;

/* loaded from: classes.dex */
public class SearchOrbView extends FrameLayout implements View.OnClickListener {

    /* renamed from: s */
    public static final /* synthetic */ int f6153s = 0;

    /* renamed from: a */
    public View.OnClickListener f6154a;

    /* renamed from: b */
    public final View f6155b;

    /* renamed from: c */
    public final View f6156c;

    /* renamed from: d */
    public final ImageView f6157d;

    /* renamed from: e */
    public Drawable f6158e;

    /* renamed from: f */
    public Colors f6159f;

    /* renamed from: g */
    public final float f6160g;

    /* renamed from: h */
    public final int f6161h;

    /* renamed from: i */
    public final int f6162i;

    /* renamed from: j */
    public final float f6163j;

    /* renamed from: k */
    public final float f6164k;

    /* renamed from: l */
    public ValueAnimator f6165l;

    /* renamed from: m */
    public boolean f6166m;

    /* renamed from: n */
    public boolean f6167n;

    /* renamed from: o */
    public final ArgbEvaluator f6168o;

    /* renamed from: p */
    public final jf2 f6169p;

    /* renamed from: q */
    public ValueAnimator f6170q;

    /* renamed from: r */
    public final jf2 f6171r;

    /* loaded from: classes.dex */
    public static class Colors {

        @ColorInt
        public int brightColor;

        @ColorInt
        public int color;

        @ColorInt
        public int iconColor;

        public Colors(@ColorInt int i) {
            this(i, i);
        }

        public static int getBrightColor(int i) {
            return Color.argb((int) ((Color.alpha(i) * 0.85f) + 38.25f), (int) ((Color.red(i) * 0.85f) + 38.25f), (int) ((Color.green(i) * 0.85f) + 38.25f), (int) ((Color.blue(i) * 0.85f) + 38.25f));
        }

        public Colors(@ColorInt int i, @ColorInt int i2) {
            this(i, i2, 0);
        }

        public Colors(@ColorInt int i, @ColorInt int i2, @ColorInt int i3) {
            this.color = i;
            this.brightColor = i2 == i ? getBrightColor(i) : i2;
            this.iconColor = i3;
        }
    }

    public SearchOrbView(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m1484a(boolean z) {
        float f = 1.0f;
        if (z) {
            f = this.f6160g;
        }
        ViewPropertyAnimator scaleY = this.f6155b.animate().scaleX(f).scaleY(f);
        long j = this.f6162i;
        scaleY.setDuration(j).start();
        if (this.f6170q == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(RecyclerView.f7068F0, 1.0f);
            this.f6170q = ofFloat;
            ofFloat.addUpdateListener(this.f6171r);
        }
        if (z) {
            this.f6170q.start();
        } else {
            this.f6170q.reverse();
        }
        this.f6170q.setDuration(j);
        enableOrbColorAnimation(z);
    }

    /* renamed from: b */
    public final void m1485b() {
        ValueAnimator valueAnimator = this.f6165l;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f6165l = null;
        }
        if (this.f6166m && this.f6167n) {
            ValueAnimator ofObject = ValueAnimator.ofObject(this.f6168o, Integer.valueOf(this.f6159f.color), Integer.valueOf(this.f6159f.brightColor), Integer.valueOf(this.f6159f.color));
            this.f6165l = ofObject;
            ofObject.setRepeatCount(-1);
            this.f6165l.setDuration(this.f6161h * 2);
            this.f6165l.addUpdateListener(this.f6169p);
            this.f6165l.start();
        }
    }

    public void enableOrbColorAnimation(boolean z) {
        this.f6166m = z;
        m1485b();
    }

    public float getFocusedZoom() {
        return this.f6160g;
    }

    public int getLayoutResourceId() {
        return androidx.leanback.R.layout.lb_search_orb;
    }

    @ColorInt
    public int getOrbColor() {
        return this.f6159f.color;
    }

    @Nullable
    public Colors getOrbColors() {
        return this.f6159f;
    }

    @Nullable
    public Drawable getOrbIcon() {
        return this.f6158e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6167n = true;
        m1485b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f6154a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f6167n = false;
        m1485b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        super.onFocusChanged(z, i, rect);
        m1484a(z);
    }

    public void setOnOrbClickedListener(@Nullable View.OnClickListener onClickListener) {
        this.f6154a = onClickListener;
    }

    public void setOrbColor(int i) {
        setOrbColors(new Colors(i, i, 0));
    }

    public void setOrbColors(@NonNull Colors colors) {
        this.f6159f = colors;
        this.f6157d.setColorFilter(colors.iconColor);
        if (this.f6165l == null) {
            setOrbViewColor(this.f6159f.color);
        } else {
            enableOrbColorAnimation(true);
        }
    }

    public void setOrbIcon(@NonNull Drawable drawable) {
        this.f6158e = drawable;
        this.f6157d.setImageDrawable(drawable);
    }

    public void setOrbViewColor(int i) {
        View view = this.f6156c;
        if (view.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) view.getBackground()).setColor(i);
        }
    }

    public void setSearchOrbZ(float f) {
        float f2 = this.f6164k;
        float f3 = this.f6163j;
        ViewCompat.setZ(this.f6156c, ((f2 - f3) * f) + f3);
    }

    public SearchOrbView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.searchOrbViewStyle);
    }

    @Deprecated
    public void setOrbColor(@ColorInt int i, @ColorInt int i2) {
        setOrbColors(new Colors(i, i2, 0));
    }

    @SuppressLint({"CustomViewStyleable"})
    public SearchOrbView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6168o = new ArgbEvaluator();
        this.f6169p = new jf2(this, 0);
        this.f6171r = new jf2(this, 1);
        Resources resources = context.getResources();
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResourceId(), (ViewGroup) this, true);
        this.f6155b = inflate;
        this.f6156c = inflate.findViewById(androidx.leanback.R.id.search_orb);
        ImageView imageView = (ImageView) inflate.findViewById(androidx.leanback.R.id.icon);
        this.f6157d = imageView;
        this.f6160g = context.getResources().getFraction(androidx.leanback.R.fraction.lb_search_orb_focused_zoom, 1, 1);
        this.f6161h = context.getResources().getInteger(androidx.leanback.R.integer.lb_search_orb_pulse_duration_ms);
        this.f6162i = context.getResources().getInteger(androidx.leanback.R.integer.lb_search_orb_scale_duration_ms);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_orb_focused_z);
        this.f6164k = dimensionPixelSize;
        this.f6163j = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_orb_unfocused_z);
        int[] iArr = androidx.leanback.R.styleable.lbSearchOrbView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbIcon);
        setOrbIcon(drawable == null ? resources.getDrawable(androidx.leanback.R.drawable.lb_ic_in_app_search) : drawable);
        int color = obtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbColor, resources.getColor(androidx.leanback.R.color.lb_default_search_color));
        setOrbColors(new Colors(color, obtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbBrightColor, color), obtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbIconColor, 0)));
        obtainStyledAttributes.recycle();
        setFocusable(true);
        setClipChildren(false);
        setOnClickListener(this);
        setSoundEffectsEnabled(false);
        setSearchOrbZ(RecyclerView.f7068F0);
        ViewCompat.setZ(imageView, dimensionPixelSize);
    }
}
