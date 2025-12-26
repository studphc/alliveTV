package androidx.leanback.graphics;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CompositeDrawable extends Drawable implements Drawable.Callback {

    /* renamed from: b */
    public boolean f5369b = false;

    /* renamed from: a */
    public C0297i f5368a = new C0297i();

    public void addChildDrawable(@NonNull Drawable drawable) {
        this.f5368a.f5377a.add(new ChildDrawable(drawable, this));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        ArrayList arrayList = this.f5368a.f5377a;
        for (int i = 0; i < arrayList.size(); i++) {
            ((ChildDrawable) arrayList.get(i)).f5371b.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable;
        ArrayList arrayList = this.f5368a.f5377a;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                drawable = ((ChildDrawable) arrayList.get(i)).f5371b;
                if (drawable != null) {
                    break;
                }
                i++;
            } else {
                drawable = null;
                break;
            }
        }
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return 255;
    }

    @NonNull
    public ChildDrawable getChildAt(int i) {
        return (ChildDrawable) this.f5368a.f5377a.get(i);
    }

    public int getChildCount() {
        return this.f5368a.f5377a.size();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable.ConstantState getConstantState() {
        return this.f5368a;
    }

    @NonNull
    public Drawable getDrawable(int i) {
        return ((ChildDrawable) this.f5368a.f5377a.get(i)).f5371b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.f5369b && super.mutate() == this) {
            C0297i c0297i = new C0297i(this.f5368a, this);
            this.f5368a = c0297i;
            ArrayList arrayList = c0297i.f5377a;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                Drawable drawable = ((ChildDrawable) arrayList.get(i)).f5371b;
                if (drawable != null) {
                    drawable.mutate();
                }
            }
            this.f5369b = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        ArrayList arrayList = this.f5368a.f5377a;
        for (int i = 0; i < arrayList.size(); i++) {
            ChildDrawable childDrawable = (ChildDrawable) arrayList.get(i);
            BoundsRule boundsRule = childDrawable.f5370a;
            Rect rect2 = childDrawable.f5372c;
            boundsRule.calculateBounds(rect, rect2);
            childDrawable.f5371b.setBounds(rect2);
        }
    }

    public void removeChild(int i) {
        this.f5368a.f5377a.remove(i);
    }

    public void removeDrawable(@NonNull Drawable drawable) {
        ArrayList arrayList = this.f5368a.f5377a;
        for (int i = 0; i < arrayList.size(); i++) {
            if (drawable == ((ChildDrawable) arrayList.get(i)).f5371b) {
                ((ChildDrawable) arrayList.get(i)).f5371b.setCallback(null);
                arrayList.remove(i);
                return;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        ArrayList arrayList = this.f5368a.f5377a;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((ChildDrawable) arrayList.get(i2)).f5371b.setAlpha(i);
        }
    }

    public void setChildDrawableAt(int i, @NonNull Drawable drawable) {
        this.f5368a.f5377a.set(i, new ChildDrawable(drawable, this));
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        ArrayList arrayList = this.f5368a.f5377a;
        for (int i = 0; i < arrayList.size(); i++) {
            ((ChildDrawable) arrayList.get(i)).f5371b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }

    /* loaded from: classes.dex */
    public static final class ChildDrawable {

        /* renamed from: a */
        public final BoundsRule f5370a;

        /* renamed from: b */
        public final Drawable f5371b;

        /* renamed from: c */
        public final Rect f5372c;

        /* renamed from: d */
        public final CompositeDrawable f5373d;
        public static final Property<ChildDrawable, Integer> TOP_ABSOLUTE = new Property<>(Integer.class, "absoluteTop");
        public static final Property<ChildDrawable, Integer> BOTTOM_ABSOLUTE = new Property<>(Integer.class, "absoluteBottom");
        public static final Property<ChildDrawable, Integer> LEFT_ABSOLUTE = new Property<>(Integer.class, "absoluteLeft");
        public static final Property<ChildDrawable, Integer> RIGHT_ABSOLUTE = new Property<>(Integer.class, "absoluteRight");
        public static final Property<ChildDrawable, Float> TOP_FRACTION = new Property<>(Float.class, "fractionTop");
        public static final Property<ChildDrawable, Float> BOTTOM_FRACTION = new Property<>(Float.class, "fractionBottom");
        public static final Property<ChildDrawable, Float> LEFT_FRACTION = new Property<>(Float.class, "fractionLeft");
        public static final Property<ChildDrawable, Float> RIGHT_FRACTION = new Property<>(Float.class, "fractionRight");

        public ChildDrawable(@NonNull Drawable drawable, @NonNull CompositeDrawable compositeDrawable) {
            this.f5372c = new Rect();
            this.f5371b = drawable;
            this.f5373d = compositeDrawable;
            this.f5370a = new BoundsRule();
            drawable.setCallback(compositeDrawable);
        }

        @NonNull
        public BoundsRule getBoundsRule() {
            return this.f5370a;
        }

        @NonNull
        public Drawable getDrawable() {
            return this.f5371b;
        }

        public void recomputeBounds() {
            Rect bounds = this.f5373d.getBounds();
            BoundsRule boundsRule = this.f5370a;
            Rect rect = this.f5372c;
            boundsRule.calculateBounds(bounds, rect);
            this.f5371b.setBounds(rect);
        }

        public ChildDrawable(ChildDrawable childDrawable, CompositeDrawable compositeDrawable) {
            Drawable drawable;
            this.f5372c = new Rect();
            Drawable drawable2 = childDrawable.f5371b;
            if (drawable2 != null) {
                drawable = drawable2.getConstantState().newDrawable();
                drawable.setCallback(compositeDrawable);
                DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(drawable2));
                drawable.setBounds(drawable2.getBounds());
                drawable.setLevel(drawable2.getLevel());
            } else {
                drawable = null;
            }
            BoundsRule boundsRule = childDrawable.f5370a;
            if (boundsRule != null) {
                this.f5370a = new BoundsRule(boundsRule);
            } else {
                this.f5370a = new BoundsRule();
            }
            this.f5371b = drawable;
            this.f5373d = compositeDrawable;
        }
    }
}
