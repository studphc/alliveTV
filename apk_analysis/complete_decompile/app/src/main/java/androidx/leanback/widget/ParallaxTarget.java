package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public abstract class ParallaxTarget {

    /* loaded from: classes.dex */
    public static final class DirectPropertyTarget<T, V extends Number> extends ParallaxTarget {

        /* renamed from: a */
        public final Object f5982a;

        /* renamed from: b */
        public final Property f5983b;

        public DirectPropertyTarget(Object obj, Property<T, V> property) {
            this.f5982a = obj;
            this.f5983b = property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.leanback.widget.ParallaxTarget
        public void directUpdate(Number number) {
            this.f5983b.set(this.f5982a, number);
        }

        @Override // androidx.leanback.widget.ParallaxTarget
        public boolean isDirectMapping() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class PropertyValuesHolderTarget extends ParallaxTarget {

        /* renamed from: a */
        public final ObjectAnimator f5984a;

        public PropertyValuesHolderTarget(Object obj, PropertyValuesHolder propertyValuesHolder) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, propertyValuesHolder);
            this.f5984a = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            ofPropertyValuesHolder.setDuration(1000000L);
        }

        @Override // androidx.leanback.widget.ParallaxTarget
        public void update(float f) {
            this.f5984a.setCurrentPlayTime(f * 1000000.0f);
        }
    }

    public void directUpdate(Number number) {
    }

    public boolean isDirectMapping() {
        return false;
    }

    public void update(float f) {
    }
}
