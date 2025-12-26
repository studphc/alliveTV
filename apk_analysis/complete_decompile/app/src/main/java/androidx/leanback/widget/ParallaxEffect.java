package androidx.leanback.widget;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxTarget;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public abstract class ParallaxEffect {

    /* renamed from: a */
    public final ArrayList f5978a = new ArrayList(2);

    /* renamed from: b */
    public final ArrayList f5979b = new ArrayList(2);

    /* renamed from: c */
    public final ArrayList f5980c = new ArrayList(2);

    /* renamed from: d */
    public final ArrayList f5981d = new ArrayList(4);

    /* renamed from: a */
    public abstract Number mo1460a(Parallax parallax);

    public final void addTarget(ParallaxTarget parallaxTarget) {
        this.f5981d.add(parallaxTarget);
    }

    /* renamed from: b */
    public abstract float mo1461b(Parallax parallax);

    /* renamed from: c */
    public final float m1462c(float f, int i) {
        ArrayList arrayList = this.f5978a;
        if (arrayList.size() >= 3) {
            ArrayList arrayList2 = this.f5979b;
            if (arrayList2.size() == arrayList.size() - 1) {
                ArrayList arrayList3 = this.f5980c;
                float floatValue = ((Float) AbstractC1726qj.m7053i(arrayList3, 1)).floatValue();
                float floatValue2 = (((Float) arrayList2.get(i - 1)).floatValue() * f) / floatValue;
                if (i >= 2) {
                    return (((Float) arrayList3.get(i - 2)).floatValue() / floatValue) + floatValue2;
                }
                return floatValue2;
            }
            float size = arrayList.size() - 1;
            float f2 = f / size;
            if (i >= 2) {
                return f2 + ((i - 1) / size);
            }
            return f2;
        }
        return f;
    }

    public final List<Parallax.PropertyMarkerValue> getPropertyRanges() {
        return this.f5978a;
    }

    public final List<ParallaxTarget> getTargets() {
        return this.f5981d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final List<Float> getWeights() {
        return this.f5979b;
    }

    public final void performMapping(Parallax parallax) {
        int i = 0;
        if (this.f5978a.size() < 2) {
            return;
        }
        if (this instanceof C0401w1) {
            ArrayList arrayList = parallax.f5970a;
            if (arrayList.size() >= 2) {
                int i2 = parallax.f5972c[0];
                int i3 = 1;
                while (i3 < arrayList.size()) {
                    int i4 = parallax.f5972c[i3];
                    if (i4 >= i2) {
                        if (i2 == Integer.MIN_VALUE && i4 == Integer.MAX_VALUE) {
                            int i5 = i3 - 1;
                            throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is UNKNOWN_BEFORE and Property[%d]\"%s\" is UNKNOWN_AFTER", Integer.valueOf(i5), ((Property) arrayList.get(i5)).getName(), Integer.valueOf(i3), ((Property) arrayList.get(i3)).getName()));
                        }
                        i3++;
                        i2 = i4;
                    } else {
                        Integer valueOf = Integer.valueOf(i3);
                        String name = ((Property) arrayList.get(i3)).getName();
                        int i6 = i3 - 1;
                        throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is smaller than Property[%d]\"%s\"", valueOf, name, Integer.valueOf(i6), ((Property) arrayList.get(i6)).getName()));
                    }
                }
            }
        } else {
            ArrayList arrayList2 = parallax.f5970a;
            if (arrayList2.size() >= 2) {
                float f = parallax.f5973d[0];
                int i7 = 1;
                while (i7 < arrayList2.size()) {
                    float f2 = parallax.f5973d[i7];
                    if (f2 >= f) {
                        if (f == -3.4028235E38f && f2 == Float.MAX_VALUE) {
                            int i8 = i7 - 1;
                            throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is UNKNOWN_BEFORE and Property[%d]\"%s\" is UNKNOWN_AFTER", Integer.valueOf(i8), ((Property) arrayList2.get(i8)).getName(), Integer.valueOf(i7), ((Property) arrayList2.get(i7)).getName()));
                        }
                        i7++;
                        f = f2;
                    } else {
                        Integer valueOf2 = Integer.valueOf(i7);
                        String name2 = ((Property) arrayList2.get(i7)).getName();
                        int i9 = i7 - 1;
                        throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is smaller than Property[%d]\"%s\"", valueOf2, name2, Integer.valueOf(i9), ((Property) arrayList2.get(i9)).getName()));
                    }
                }
            }
        }
        float f3 = RecyclerView.f7068F0;
        Number number = null;
        boolean z = false;
        while (true) {
            ArrayList arrayList3 = this.f5981d;
            if (i < arrayList3.size()) {
                ParallaxTarget parallaxTarget = (ParallaxTarget) arrayList3.get(i);
                if (parallaxTarget.isDirectMapping()) {
                    if (number == null) {
                        number = mo1460a(parallax);
                    }
                    parallaxTarget.directUpdate(number);
                } else {
                    if (!z) {
                        f3 = mo1461b(parallax);
                        z = true;
                    }
                    parallaxTarget.update(f3);
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final void removeTarget(ParallaxTarget parallaxTarget) {
        this.f5981d.remove(parallaxTarget);
    }

    public final void setPropertyRanges(Parallax.PropertyMarkerValue... propertyMarkerValueArr) {
        ArrayList arrayList = this.f5978a;
        arrayList.clear();
        for (Parallax.PropertyMarkerValue propertyMarkerValue : propertyMarkerValueArr) {
            arrayList.add(propertyMarkerValue);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setWeights(float... fArr) {
        int length = fArr.length;
        int i = 0;
        while (true) {
            float f = RecyclerView.f7068F0;
            if (i < length) {
                if (fArr[i] > RecyclerView.f7068F0) {
                    i++;
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                ArrayList arrayList = this.f5979b;
                arrayList.clear();
                ArrayList arrayList2 = this.f5980c;
                arrayList2.clear();
                for (float f2 : fArr) {
                    arrayList.add(Float.valueOf(f2));
                    f += f2;
                    arrayList2.add(Float.valueOf(f));
                }
                return;
            }
        }
    }

    public final ParallaxEffect target(ParallaxTarget parallaxTarget) {
        this.f5981d.add(parallaxTarget);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final ParallaxEffect weights(float... fArr) {
        setWeights(fArr);
        return this;
    }

    public final ParallaxEffect target(Object obj, PropertyValuesHolder propertyValuesHolder) {
        this.f5981d.add(new ParallaxTarget.PropertyValuesHolderTarget(obj, propertyValuesHolder));
        return this;
    }

    public final <T, V extends Number> ParallaxEffect target(T t, Property<T, V> property) {
        this.f5981d.add(new ParallaxTarget.DirectPropertyTarget(t, property));
        return this;
    }
}
