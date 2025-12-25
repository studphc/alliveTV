package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000.C0584c8;
import p000.C1113d8;
import p000.C1149e8;
import p000.f13;
import p000.yy2;

/* loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends f13 implements Animatable2Compat {

    /* renamed from: c */
    public final Context f7550c;

    /* renamed from: d */
    public C0522b f7551d = null;

    /* renamed from: e */
    public ArrayList f7552e = null;

    /* renamed from: f */
    public final C0584c8 f7553f = new C0584c8(this);

    /* renamed from: b */
    public final C1113d8 f7549b = new Drawable.ConstantState();

    /* JADX WARN: Type inference failed for: r2v1, types: [android.graphics.drawable.Drawable$ConstantState, d8] */
    public AnimatedVectorDrawableCompat(Context context) {
        this.f7550c = context;
    }

    @Nullable
    public static AnimatedVectorDrawableCompat create(@NonNull Context context, @DrawableRes int i) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
            Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), i, context.getTheme());
            animatedVectorDrawableCompat.f17083a = drawable;
            drawable.setCallback(animatedVectorDrawableCompat.f7553f);
            new C1149e8(animatedVectorDrawableCompat.f17083a.getConstantState());
            return animatedVectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(context, context.getResources(), xml, asAttributeSet, context.getTheme());
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e) {
            Log.e("AnimatedVDCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("AnimatedVDCompat", "parser error", e2);
            return null;
        }
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.applyTheme(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return DrawableCompat.canApplyTheme(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            return;
        }
        C0522b c0522b = this.f7551d;
        if (c0522b != null) {
            this.f7549b.f16282b.removeListener(c0522b);
            this.f7551d = null;
        }
        ArrayList arrayList = this.f7552e;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        C1113d8 c1113d8 = this.f7549b;
        c1113d8.f16281a.draw(canvas);
        if (c1113d8.f16282b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.f7549b.f16281a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f7549b.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.f7549b.f16281a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f17083a != null && Build.VERSION.SDK_INT >= 24) {
            return new C1149e8(this.f17083a.getConstantState());
        }
        return null;
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
        return this.f7549b.f16281a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f7549b.f16281a.getIntrinsicWidth();
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
        return this.f7549b.f16281a.getOpacity();
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00b6, code lost:
    
        if (r3.f16282b != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b8, code lost:
    
        r3.f16282b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00bf, code lost:
    
        r3.f16282b.playTogether(r3.f16283c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c6, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            C1113d8 c1113d8 = this.f7549b;
            if (eventType == 1 || (xmlPullParser.getDepth() < depth && eventType == 3)) {
                break;
            }
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, yy2.f29181e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat create = VectorDrawableCompat.create(resources, resourceId, theme);
                        create.f7562f = false;
                        create.setCallback(this.f7553f);
                        VectorDrawableCompat vectorDrawableCompat = c1113d8.f16281a;
                        if (vectorDrawableCompat != null) {
                            vectorDrawableCompat.setCallback(null);
                        }
                        c1113d8.f16281a = create;
                    }
                    obtainAttributes.recycle();
                } else if (TypedValues.AttributesType.S_TARGET.equals(name)) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, yy2.f29182f);
                    String string = obtainAttributes2.getString(0);
                    int resourceId2 = obtainAttributes2.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f7550c;
                        if (context != null) {
                            Animator loadAnimator = AnimatorInflaterCompat.loadAnimator(context, resourceId2);
                            loadAnimator.setTarget(c1113d8.f16281a.f7558b.f22758b.f22298o.get(string));
                            if (c1113d8.f16283c == null) {
                                c1113d8.f16283c = new ArrayList();
                                c1113d8.f16284d = new ArrayMap();
                            }
                            c1113d8.f16283c.add(loadAnimator);
                            c1113d8.f16284d.put(loadAnimator, string);
                        } else {
                            obtainAttributes2.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes2.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.f7549b.f16281a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f7549b.f16282b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f7549b.f16281a.isStateful();
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f7549b.f16281a.setBounds(rect);
        }
    }

    @Override // p000.f13, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f7549b.f16281a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f7549b.f16281a.setState(iArr);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).registerAnimationCallback(animationCallback.m1912a());
            return;
        }
        if (animationCallback == null) {
            return;
        }
        if (this.f7552e == null) {
            this.f7552e = new ArrayList();
        }
        if (this.f7552e.contains(animationCallback)) {
            return;
        }
        this.f7552e.add(animationCallback);
        if (this.f7551d == null) {
            this.f7551d = new C0522b(this);
        }
        this.f7549b.f16282b.addListener(this.f7551d);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f7549b.f16281a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.f7549b.f16281a.setAutoMirrored(z);
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
            this.f7549b.f16281a.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        } else {
            this.f7549b.f16281a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
        } else {
            this.f7549b.f16281a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f7549b.f16281a.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        C1113d8 c1113d8 = this.f7549b;
        if (c1113d8.f16282b.isStarted()) {
            return;
        }
        c1113d8.f16282b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f7549b.f16282b.end();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        C0522b c0522b;
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).unregisterAnimationCallback(animationCallback.m1912a());
        }
        ArrayList arrayList = this.f7552e;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        boolean remove = arrayList.remove(animationCallback);
        if (this.f7552e.size() == 0 && (c0522b = this.f7551d) != null) {
            this.f7549b.f16282b.removeListener(c0522b);
            this.f7551d = null;
        }
        return remove;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f17083a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f7549b.f16281a.setColorFilter(colorFilter);
        }
    }

    public static void clearAnimationCallbacks(Drawable drawable) {
        if (drawable instanceof Animatable) {
            if (Build.VERSION.SDK_INT >= 24) {
                ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            } else {
                ((AnimatedVectorDrawableCompat) drawable).clearAnimationCallbacks();
            }
        }
    }

    public static boolean unregisterAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return ((AnimatedVectorDrawable) drawable).unregisterAnimationCallback(animationCallback.m1912a());
        }
        return ((AnimatedVectorDrawableCompat) drawable).unregisterAnimationCallback(animationCallback);
    }

    public static void registerAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null || animationCallback == null || !(drawable instanceof Animatable)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            ((AnimatedVectorDrawable) drawable).registerAnimationCallback(animationCallback.m1912a());
        } else {
            ((AnimatedVectorDrawableCompat) drawable).registerAnimationCallback(animationCallback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
