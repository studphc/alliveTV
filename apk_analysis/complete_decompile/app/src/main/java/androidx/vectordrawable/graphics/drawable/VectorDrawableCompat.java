package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000.f13;
import p000.h13;
import p000.i13;
import p000.k13;
import p000.l13;
import p000.m13;
import p000.n13;
import p000.yy2;

/* loaded from: classes.dex */
public class VectorDrawableCompat extends f13 {

    /* renamed from: j */
    public static final PorterDuff.Mode f7557j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    public m13 f7558b;

    /* renamed from: c */
    public PorterDuffColorFilter f7559c;

    /* renamed from: d */
    public ColorFilter f7560d;

    /* renamed from: e */
    public boolean f7561e;

    /* renamed from: f */
    public boolean f7562f;

    /* renamed from: g */
    public final float[] f7563g;

    /* renamed from: h */
    public final Matrix f7564h;

    /* renamed from: i */
    public final Rect f7565i;

    /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.drawable.Drawable$ConstantState, m13] */
    public VectorDrawableCompat() {
        this.f7562f = true;
        this.f7563g = new float[9];
        this.f7564h = new Matrix();
        this.f7565i = new Rect();
        ?? constantState = new Drawable.ConstantState();
        constantState.f22759c = null;
        constantState.f22760d = f7557j;
        constantState.f22758b = new l13();
        this.f7558b = constantState;
    }

    @Nullable
    public static VectorDrawableCompat create(@NonNull Resources resources, @DrawableRes int i, @Nullable Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f17083a = ResourcesCompat.getDrawable(resources, i, theme);
            new n13(vectorDrawableCompat.f17083a.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    /* renamed from: a */
    public final PorterDuffColorFilter m1918a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.canApplyTheme(drawable);
            return false;
        }
        return false;
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f7565i;
        copyBounds(rect);
        if (rect.width() > 0 && rect.height() > 0) {
            ColorFilter colorFilter = this.f7560d;
            if (colorFilter == null) {
                colorFilter = this.f7559c;
            }
            Matrix matrix = this.f7564h;
            canvas.getMatrix(matrix);
            float[] fArr = this.f7563g;
            matrix.getValues(fArr);
            float abs = Math.abs(fArr[0]);
            float abs2 = Math.abs(fArr[4]);
            float abs3 = Math.abs(fArr[1]);
            float abs4 = Math.abs(fArr[3]);
            if (abs3 != RecyclerView.f7068F0 || abs4 != RecyclerView.f7068F0) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int width = (int) (rect.width() * abs);
            int min = Math.min(2048, width);
            int min2 = Math.min(2048, (int) (rect.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate(rect.left, rect.top);
                if (isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1) {
                    canvas.translate(rect.width(), RecyclerView.f7068F0);
                    canvas.scale(-1.0f, 1.0f);
                }
                rect.offsetTo(0, 0);
                m13 m13Var = this.f7558b;
                Bitmap bitmap = m13Var.f22762f;
                if (bitmap == null || min != bitmap.getWidth() || min2 != m13Var.f22762f.getHeight()) {
                    m13Var.f22762f = Bitmap.createBitmap(min, min2, Bitmap.Config.ARGB_8888);
                    m13Var.f22767k = true;
                }
                if (!this.f7562f) {
                    m13 m13Var2 = this.f7558b;
                    m13Var2.f22762f.eraseColor(0);
                    Canvas canvas2 = new Canvas(m13Var2.f22762f);
                    l13 l13Var = m13Var2.f22758b;
                    l13Var.m5816a(l13Var.f22290g, l13.f22283p, canvas2, min, min2);
                } else {
                    m13 m13Var3 = this.f7558b;
                    if (m13Var3.f22767k || m13Var3.f22763g != m13Var3.f22759c || m13Var3.f22764h != m13Var3.f22760d || m13Var3.f22766j != m13Var3.f22761e || m13Var3.f22765i != m13Var3.f22758b.getRootAlpha()) {
                        m13 m13Var4 = this.f7558b;
                        m13Var4.f22762f.eraseColor(0);
                        Canvas canvas3 = new Canvas(m13Var4.f22762f);
                        l13 l13Var2 = m13Var4.f22758b;
                        l13Var2.m5816a(l13Var2.f22290g, l13.f22283p, canvas3, min, min2);
                        m13 m13Var5 = this.f7558b;
                        m13Var5.f22763g = m13Var5.f22759c;
                        m13Var5.f22764h = m13Var5.f22760d;
                        m13Var5.f22765i = m13Var5.f22758b.getRootAlpha();
                        m13Var5.f22766j = m13Var5.f22761e;
                        m13Var5.f22767k = false;
                    }
                }
                m13 m13Var6 = this.f7558b;
                if (m13Var6.f22758b.getRootAlpha() >= 255 && colorFilter == null) {
                    paint = null;
                } else {
                    if (m13Var6.f22768l == null) {
                        Paint paint2 = new Paint();
                        m13Var6.f22768l = paint2;
                        paint2.setFilterBitmap(true);
                    }
                    m13Var6.f22768l.setAlpha(m13Var6.f22758b.getRootAlpha());
                    m13Var6.f22768l.setColorFilter(colorFilter);
                    paint = m13Var6.f22768l;
                }
                canvas.drawBitmap(m13Var6.f22762f, (Rect) null, rect, paint);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.f7558b.f22758b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f7558b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.f7560d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f17083a != null && Build.VERSION.SDK_INT >= 24) {
            return new n13(this.f17083a.getConstantState());
        }
        this.f7558b.f22757a = getChangingConfigurations();
        return this.f7558b;
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f7558b.f22758b.f22292i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f7558b.f22758b.f22291h;
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        l13 l13Var;
        m13 m13Var = this.f7558b;
        if (m13Var != null && (l13Var = m13Var.f22758b) != null) {
            float f = l13Var.f22291h;
            if (f != RecyclerView.f7068F0) {
                float f2 = l13Var.f22292i;
                if (f2 != RecyclerView.f7068F0) {
                    float f3 = l13Var.f22294k;
                    if (f3 != RecyclerView.f7068F0) {
                        float f4 = l13Var.f22293j;
                        if (f4 != RecyclerView.f7068F0) {
                            return Math.min(f4 / f, f3 / f2);
                        }
                        return 1.0f;
                    }
                    return 1.0f;
                }
                return 1.0f;
            }
            return 1.0f;
        }
        return 1.0f;
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.f7558b.f22761e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            m13 m13Var = this.f7558b;
            if (m13Var != null) {
                l13 l13Var = m13Var.f22758b;
                if (l13Var.f22297n == null) {
                    l13Var.f22297n = Boolean.valueOf(l13Var.f22290g.mo5030a());
                }
                if (l13Var.f22297n.booleanValue() || ((colorStateList = this.f7558b.f22759c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.Drawable$ConstantState, m13] */
    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f7561e && super.mutate() == this) {
            m13 m13Var = this.f7558b;
            ?? constantState = new Drawable.ConstantState();
            constantState.f22759c = null;
            constantState.f22760d = f7557j;
            if (m13Var != null) {
                constantState.f22757a = m13Var.f22757a;
                l13 l13Var = new l13(m13Var.f22758b);
                constantState.f22758b = l13Var;
                if (m13Var.f22758b.f22288e != null) {
                    l13Var.f22288e = new Paint(m13Var.f22758b.f22288e);
                }
                if (m13Var.f22758b.f22287d != null) {
                    constantState.f22758b.f22287d = new Paint(m13Var.f22758b.f22287d);
                }
                constantState.f22759c = m13Var.f22759c;
                constantState.f22760d = m13Var.f22760d;
                constantState.f22761e = m13Var.f22761e;
            }
            this.f7558b = constantState;
            this.f7561e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        m13 m13Var = this.f7558b;
        ColorStateList colorStateList = m13Var.f22759c;
        if (colorStateList != null && (mode = m13Var.f22760d) != null) {
            this.f7559c = m1918a(colorStateList, mode);
            invalidateSelf();
            z = true;
        } else {
            z = false;
        }
        l13 l13Var = m13Var.f22758b;
        if (l13Var.f22297n == null) {
            l13Var.f22297n = Boolean.valueOf(l13Var.f22290g.mo5030a());
        }
        if (l13Var.f22297n.booleanValue()) {
            boolean mo5031b = m13Var.f22758b.f22290g.mo5031b(iArr);
            m13Var.f22767k |= mo5031b;
            if (mo5031b) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f7558b.f22758b.getRootAlpha() != i) {
            this.f7558b.f22758b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.f7558b.f22761e = z;
        }
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        m13 m13Var = this.f7558b;
        if (m13Var.f22759c != colorStateList) {
            m13Var.f22759c = colorStateList;
            this.f7559c = m1918a(colorStateList, m13Var.f22760d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        m13 m13Var = this.f7558b;
        if (m13Var.f22760d != mode) {
            m13Var.f22760d = mode;
            this.f7559c = m1918a(m13Var.f22759c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f7560d = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX WARN: Type inference failed for: r5v28, types: [h13, k13] */
    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        l13 l13Var;
        boolean z;
        int i;
        int i2;
        ArrayDeque arrayDeque;
        int i3;
        ArrayDeque arrayDeque2;
        ArrayMap arrayMap;
        Paint.Cap cap;
        TypedArray typedArray;
        h13 h13Var;
        char c;
        Paint.Join join;
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        m13 m13Var = this.f7558b;
        m13Var.f22758b = new l13();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, yy2.f29177a);
        m13 m13Var2 = this.f7558b;
        l13 l13Var2 = m13Var2.f22758b;
        int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i4 = 3;
        if (namedInt == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (namedInt != 5) {
            if (namedInt != 9) {
                switch (namedInt) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        m13Var2.f22760d = mode;
        int i5 = 1;
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(obtainAttributes, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            m13Var2.f22759c = namedColorStateList;
        }
        m13Var2.f22761e = TypedArrayUtils.getNamedBoolean(obtainAttributes, xmlPullParser, "autoMirrored", 5, m13Var2.f22761e);
        l13Var2.f22293j = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "viewportWidth", 7, l13Var2.f22293j);
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "viewportHeight", 8, l13Var2.f22294k);
        l13Var2.f22294k = namedFloat;
        float f = l13Var2.f22293j;
        float f2 = RecyclerView.f7068F0;
        if (f <= RecyclerView.f7068F0) {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (namedFloat > RecyclerView.f7068F0) {
            l13Var2.f22291h = obtainAttributes.getDimension(3, l13Var2.f22291h);
            int i6 = 2;
            float dimension = obtainAttributes.getDimension(2, l13Var2.f22292i);
            l13Var2.f22292i = dimension;
            if (l13Var2.f22291h <= RecyclerView.f7068F0) {
                throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > RecyclerView.f7068F0) {
                l13Var2.setAlpha(TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "alpha", 4, l13Var2.getAlpha()));
                boolean z2 = false;
                String string = obtainAttributes.getString(0);
                if (string != null) {
                    l13Var2.f22296m = string;
                    l13Var2.f22298o.put(string, l13Var2);
                }
                obtainAttributes.recycle();
                m13Var.f22757a = getChangingConfigurations();
                m13Var.f22767k = true;
                m13 m13Var3 = this.f7558b;
                l13 l13Var3 = m13Var3.f22758b;
                ArrayDeque arrayDeque3 = new ArrayDeque();
                arrayDeque3.push(l13Var3.f22290g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z3 = true;
                while (eventType != i5 && (xmlPullParser.getDepth() >= depth || eventType != i4)) {
                    if (eventType == i6) {
                        String name = xmlPullParser.getName();
                        i13 i13Var = (i13) arrayDeque3.peek();
                        boolean equals = "path".equals(name);
                        ArrayMap arrayMap2 = l13Var3.f22298o;
                        if (equals) {
                            ?? k13Var = new k13();
                            k13Var.f17922e = f2;
                            k13Var.f17924g = 1.0f;
                            k13Var.f17925h = 1.0f;
                            k13Var.f17926i = f2;
                            k13Var.f17927j = 1.0f;
                            k13Var.f17928k = f2;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            k13Var.f17929l = cap2;
                            Paint.Join join2 = Paint.Join.MITER;
                            k13Var.f17930m = join2;
                            k13Var.f17931n = 4.0f;
                            TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, yy2.f29179c);
                            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                                ArrayDeque arrayDeque4 = arrayDeque3;
                                String string2 = obtainAttributes2.getString(0);
                                if (string2 != null) {
                                    k13Var.f20719b = string2;
                                }
                                String string3 = obtainAttributes2.getString(2);
                                if (string3 != null) {
                                    k13Var.f20718a = PathParser.createNodesFromPathData(string3);
                                }
                                arrayDeque2 = arrayDeque4;
                                l13Var = l13Var3;
                                i = depth;
                                arrayMap = arrayMap2;
                                k13Var.f17923f = TypedArrayUtils.getNamedComplexColor(obtainAttributes2, xmlPullParser, theme, "fillColor", 1, 0);
                                k13Var.f17925h = TypedArrayUtils.getNamedFloat(obtainAttributes2, xmlPullParser, "fillAlpha", 12, k13Var.f17925h);
                                int namedInt2 = TypedArrayUtils.getNamedInt(obtainAttributes2, xmlPullParser, "strokeLineCap", 8, -1);
                                Paint.Cap cap3 = k13Var.f17929l;
                                if (namedInt2 == 0) {
                                    cap = cap2;
                                } else if (namedInt2 != 1) {
                                    cap = namedInt2 != 2 ? cap3 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                k13Var.f17929l = cap;
                                int namedInt3 = TypedArrayUtils.getNamedInt(obtainAttributes2, xmlPullParser, "strokeLineJoin", 9, -1);
                                Paint.Join join3 = k13Var.f17930m;
                                if (namedInt3 != 0) {
                                    if (namedInt3 != 1) {
                                        c = 2;
                                        if (namedInt3 != 2) {
                                            join2 = join3;
                                        } else {
                                            join = Paint.Join.BEVEL;
                                        }
                                    } else {
                                        c = 2;
                                        join = Paint.Join.ROUND;
                                    }
                                    join2 = join;
                                }
                                k13Var.f17930m = join2;
                                k13Var.f17931n = TypedArrayUtils.getNamedFloat(obtainAttributes2, xmlPullParser, "strokeMiterLimit", 10, k13Var.f17931n);
                                typedArray = obtainAttributes2;
                                h13Var = k13Var;
                                h13Var.f17921d = TypedArrayUtils.getNamedComplexColor(obtainAttributes2, xmlPullParser, theme, "strokeColor", 3, 0);
                                h13Var.f17924g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, h13Var.f17924g);
                                h13Var.f17922e = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, h13Var.f17922e);
                                h13Var.f17927j = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, h13Var.f17927j);
                                h13Var.f17928k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, h13Var.f17928k);
                                h13Var.f17926i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, h13Var.f17926i);
                                h13Var.f20720c = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, h13Var.f20720c);
                            } else {
                                arrayDeque2 = arrayDeque3;
                                l13Var = l13Var3;
                                h13Var = k13Var;
                                i = depth;
                                arrayMap = arrayMap2;
                                typedArray = obtainAttributes2;
                            }
                            typedArray.recycle();
                            i13Var.f18257b.add(h13Var);
                            if (h13Var.getPathName() != null) {
                                arrayMap.put(h13Var.getPathName(), h13Var);
                            }
                            m13Var3.f22757a = m13Var3.f22757a;
                            arrayDeque = arrayDeque2;
                            z = false;
                            i2 = 1;
                            z3 = false;
                        } else {
                            ArrayDeque arrayDeque5 = arrayDeque3;
                            l13Var = l13Var3;
                            i = depth;
                            if ("clip-path".equals(name)) {
                                k13 k13Var2 = new k13();
                                if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                                    TypedArray obtainAttributes3 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, yy2.f29180d);
                                    z = false;
                                    String string4 = obtainAttributes3.getString(0);
                                    if (string4 != null) {
                                        k13Var2.f20719b = string4;
                                    }
                                    String string5 = obtainAttributes3.getString(1);
                                    if (string5 != null) {
                                        k13Var2.f20718a = PathParser.createNodesFromPathData(string5);
                                    }
                                    k13Var2.f20720c = TypedArrayUtils.getNamedInt(obtainAttributes3, xmlPullParser, "fillType", 2, 0);
                                    obtainAttributes3.recycle();
                                } else {
                                    z = false;
                                }
                                i13Var.f18257b.add(k13Var2);
                                if (k13Var2.getPathName() != null) {
                                    arrayMap2.put(k13Var2.getPathName(), k13Var2);
                                }
                                m13Var3.f22757a = m13Var3.f22757a;
                            } else {
                                z = false;
                                if ("group".equals(name)) {
                                    i13 i13Var2 = new i13();
                                    TypedArray obtainAttributes4 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, yy2.f29178b);
                                    i13Var2.f18258c = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, Key.ROTATION, 5, i13Var2.f18258c);
                                    i2 = 1;
                                    i13Var2.f18259d = obtainAttributes4.getFloat(1, i13Var2.f18259d);
                                    i13Var2.f18260e = obtainAttributes4.getFloat(2, i13Var2.f18260e);
                                    i13Var2.f18261f = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, "scaleX", 3, i13Var2.f18261f);
                                    i13Var2.f18262g = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, "scaleY", 4, i13Var2.f18262g);
                                    i13Var2.f18263h = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, "translateX", 6, i13Var2.f18263h);
                                    i13Var2.f18264i = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlPullParser, "translateY", 7, i13Var2.f18264i);
                                    String string6 = obtainAttributes4.getString(0);
                                    if (string6 != null) {
                                        i13Var2.f18266k = string6;
                                    }
                                    i13Var2.m5147c();
                                    obtainAttributes4.recycle();
                                    i13Var.f18257b.add(i13Var2);
                                    arrayDeque = arrayDeque5;
                                    arrayDeque.push(i13Var2);
                                    if (i13Var2.getGroupName() != null) {
                                        arrayMap2.put(i13Var2.getGroupName(), i13Var2);
                                    }
                                    m13Var3.f22757a = m13Var3.f22757a;
                                }
                            }
                            arrayDeque = arrayDeque5;
                            i2 = 1;
                        }
                        i3 = 3;
                    } else {
                        l13Var = l13Var3;
                        z = z2;
                        i = depth;
                        i2 = 1;
                        arrayDeque = arrayDeque3;
                        i3 = i4;
                        if (eventType == i3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i4 = i3;
                    arrayDeque3 = arrayDeque;
                    z2 = z;
                    i5 = i2;
                    l13Var3 = l13Var;
                    depth = i;
                    i6 = 2;
                    f2 = RecyclerView.f7068F0;
                }
                if (!z3) {
                    this.f7559c = m1918a(m13Var.f22759c, m13Var.f22760d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public VectorDrawableCompat(m13 m13Var) {
        this.f7562f = true;
        this.f7563g = new float[9];
        this.f7564h = new Matrix();
        this.f7565i = new Rect();
        this.f7558b = m13Var;
        this.f7559c = m1918a(m13Var.f22759c, m13Var.f22760d);
    }
}
