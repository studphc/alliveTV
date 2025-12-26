package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import p000.o63;
import p000.tc2;

/* loaded from: classes.dex */
public class ShadowOverlayContainer extends FrameLayout {
    public static final int SHADOW_DYNAMIC = 3;
    public static final int SHADOW_NONE = 1;
    public static final int SHADOW_STATIC = 2;

    /* renamed from: j */
    public static final Rect f6187j = new Rect();

    /* renamed from: a */
    public boolean f6188a;

    /* renamed from: b */
    public Object f6189b;

    /* renamed from: c */
    public View f6190c;

    /* renamed from: d */
    public boolean f6191d;

    /* renamed from: e */
    public int f6192e;

    /* renamed from: f */
    public float f6193f;

    /* renamed from: g */
    public float f6194g;

    /* renamed from: h */
    public Paint f6195h;

    /* renamed from: i */
    public int f6196i;

    public ShadowOverlayContainer(Context context) {
        this(context, null, 0);
    }

    public static void prepareParentForShadow(ViewGroup viewGroup) {
        viewGroup.setLayoutMode(1);
    }

    public static boolean supportsDynamicShadow() {
        return true;
    }

    public static boolean supportsShadow() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [un2, java.lang.Object] */
    /* renamed from: a */
    public final void m1487a(int i, int i2, boolean z) {
        boolean z2;
        if (!this.f6188a) {
            this.f6188a = true;
            if (i2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f6191d = z2;
            this.f6192e = i;
            if (i != 2) {
                if (i == 3) {
                    this.f6189b = o63.m6462a(this, this.f6193f, this.f6194g, i2);
                }
            } else {
                setLayoutMode(1);
                LayoutInflater.from(getContext()).inflate(androidx.leanback.R.layout.lb_shadow, (ViewGroup) this, true);
                ?? obj = new Object();
                obj.f27394a = findViewById(androidx.leanback.R.id.lb_shadow_normal);
                obj.f27395b = findViewById(androidx.leanback.R.id.lb_shadow_focused);
                this.f6189b = obj;
            }
            if (z) {
                setWillNotDraw(false);
                this.f6196i = 0;
                Paint paint = new Paint();
                this.f6195h = paint;
                paint.setColor(this.f6196i);
                this.f6195h.setStyle(Paint.Style.FILL);
                return;
            }
            setWillNotDraw(true);
            this.f6195h = null;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.f6195h != null && this.f6196i != 0) {
            canvas.drawRect(this.f6190c.getLeft(), this.f6190c.getTop(), this.f6190c.getRight(), this.f6190c.getBottom(), this.f6195h);
        }
    }

    public int getShadowType() {
        return this.f6192e;
    }

    public View getWrappedView() {
        return this.f6190c;
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Deprecated
    public void initialize(boolean z, boolean z2) {
        initialize(z, z2, true);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        super.onLayout(z, i, i2, i3, i4);
        if (z && (view = this.f6190c) != null) {
            int pivotX = (int) view.getPivotX();
            Rect rect = f6187j;
            rect.left = pivotX;
            rect.top = (int) this.f6190c.getPivotY();
            offsetDescendantRectToMyCoords(this.f6190c, rect);
            setPivotX(rect.left);
            setPivotY(rect.top);
        }
    }

    public void setOverlayColor(@ColorInt int i) {
        Paint paint = this.f6195h;
        if (paint != null && i != this.f6196i) {
            this.f6196i = i;
            paint.setColor(i);
            invalidate();
        }
    }

    public void setShadowFocusLevel(float f) {
        Object obj = this.f6189b;
        if (obj != null) {
            ShadowOverlayHelper.m1488a(obj, this.f6192e, f);
        }
    }

    public void useDynamicShadow() {
        useDynamicShadow(getResources().getDimension(androidx.leanback.R.dimen.lb_material_shadow_normal_z), getResources().getDimension(androidx.leanback.R.dimen.lb_material_shadow_focused_z));
    }

    public void useStaticShadow() {
        if (!this.f6188a) {
            if (supportsShadow()) {
                this.f6192e = 2;
                return;
            }
            return;
        }
        throw new IllegalStateException("Already initialized");
    }

    public void wrap(View view) {
        int i;
        if (this.f6188a && this.f6190c == null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
                int i2 = -2;
                if (layoutParams.width == -1) {
                    i = -1;
                } else {
                    i = -2;
                }
                layoutParams.width = i;
                if (layoutParams.height == -1) {
                    i2 = -1;
                }
                layoutParams.height = i2;
                setLayoutParams(layoutParams);
                addView(view, layoutParams2);
            } else {
                addView(view);
            }
            if (this.f6191d && this.f6192e != 3) {
                tc2.m7490a(this, true);
            }
            this.f6190c = view;
            return;
        }
        throw new IllegalStateException();
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public void initialize(boolean z, boolean z2, boolean z3) {
        m1487a(!z ? 1 : this.f6192e, z3 ? getContext().getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_rounded_rect_corner_radius) : 0, z2);
    }

    public ShadowOverlayContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6192e = 1;
        useStaticShadow();
        useDynamicShadow();
    }

    public void useDynamicShadow(float f, float f2) {
        if (!this.f6188a) {
            if (supportsDynamicShadow()) {
                this.f6192e = 3;
                this.f6193f = f;
                this.f6194g = f2;
                return;
            }
            return;
        }
        throw new IllegalStateException("Already initialized");
    }
}
