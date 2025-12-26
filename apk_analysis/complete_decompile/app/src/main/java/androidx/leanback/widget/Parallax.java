package androidx.leanback.widget;

import android.util.Property;
import androidx.annotation.CallSuper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class Parallax<PropertyT extends Property> {

    /* renamed from: a */
    public final ArrayList f5970a;

    /* renamed from: b */
    public final List f5971b;

    /* renamed from: c */
    public int[] f5972c;

    /* renamed from: d */
    public float[] f5973d;

    /* renamed from: e */
    public final ArrayList f5974e;

    /* loaded from: classes.dex */
    public static class FloatProperty extends Property<Parallax, Float> {
        public static final float UNKNOWN_AFTER = Float.MAX_VALUE;
        public static final float UNKNOWN_BEFORE = -3.4028235E38f;

        /* renamed from: a */
        public final int f5975a;

        public FloatProperty(String str, int i) {
            super(Float.class, str);
            this.f5975a = i;
        }

        /* renamed from: at */
        public final PropertyMarkerValue m1458at(float f, float f2) {
            return new C0389t1(this, f, f2);
        }

        public final PropertyMarkerValue atAbsolute(float f) {
            return new C0389t1(this, f, RecyclerView.f7068F0);
        }

        public final PropertyMarkerValue atFraction(float f) {
            return new C0389t1(this, RecyclerView.f7068F0, f);
        }

        public final PropertyMarkerValue atMax() {
            return new C0389t1(this, RecyclerView.f7068F0, 1.0f);
        }

        public final PropertyMarkerValue atMin() {
            return new C0389t1(this, RecyclerView.f7068F0, RecyclerView.f7068F0);
        }

        public final int getIndex() {
            return this.f5975a;
        }

        public final float getValue(Parallax parallax) {
            return parallax.f5973d[this.f5975a];
        }

        public final void setValue(Parallax parallax, float f) {
            int size = parallax.f5970a.size();
            int i = this.f5975a;
            if (i < size) {
                parallax.f5973d[i] = f;
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        @Override // android.util.Property
        public final Float get(Parallax parallax) {
            return Float.valueOf(parallax.f5973d[this.f5975a]);
        }

        @Override // android.util.Property
        public final void set(Parallax parallax, Float f) {
            float floatValue = f.floatValue();
            int size = parallax.f5970a.size();
            int i = this.f5975a;
            if (i < size) {
                parallax.f5973d[i] = floatValue;
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* loaded from: classes.dex */
    public static class IntProperty extends Property<Parallax, Integer> {
        public static final int UNKNOWN_AFTER = Integer.MAX_VALUE;
        public static final int UNKNOWN_BEFORE = Integer.MIN_VALUE;

        /* renamed from: a */
        public final int f5976a;

        public IntProperty(String str, int i) {
            super(Integer.class, str);
            this.f5976a = i;
        }

        /* renamed from: at */
        public final PropertyMarkerValue m1459at(int i, float f) {
            return new C0393u1(this, i, f);
        }

        public final PropertyMarkerValue atAbsolute(int i) {
            return new C0393u1(this, i, RecyclerView.f7068F0);
        }

        public final PropertyMarkerValue atFraction(float f) {
            return new C0393u1(this, 0, f);
        }

        public final PropertyMarkerValue atMax() {
            return new C0393u1(this, 0, 1.0f);
        }

        public final PropertyMarkerValue atMin() {
            return new C0393u1(this, 0, RecyclerView.f7068F0);
        }

        public final int getIndex() {
            return this.f5976a;
        }

        public final int getValue(Parallax parallax) {
            return parallax.f5972c[this.f5976a];
        }

        public final void setValue(Parallax parallax, int i) {
            parallax.m1457a(this.f5976a, i);
        }

        @Override // android.util.Property
        public final Integer get(Parallax parallax) {
            return Integer.valueOf(parallax.f5972c[this.f5976a]);
        }

        @Override // android.util.Property
        public final void set(Parallax parallax, Integer num) {
            parallax.m1457a(this.f5976a, num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static class PropertyMarkerValue<PropertyT> {

        /* renamed from: a */
        public final Object f5977a;

        public PropertyMarkerValue(PropertyT propertyt) {
            this.f5977a = propertyt;
        }

        public PropertyT getProperty() {
            return (PropertyT) this.f5977a;
        }
    }

    public Parallax() {
        ArrayList arrayList = new ArrayList();
        this.f5970a = arrayList;
        this.f5971b = Collections.unmodifiableList(arrayList);
        this.f5972c = new int[4];
        this.f5973d = new float[4];
        this.f5974e = new ArrayList(4);
    }

    /* renamed from: a */
    public final void m1457a(int i, int i2) {
        if (i < this.f5970a.size()) {
            this.f5972c[i] = i2;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public ParallaxEffect addEffect(PropertyMarkerValue... propertyMarkerValueArr) {
        ParallaxEffect parallaxEffect;
        if (propertyMarkerValueArr[0].getProperty() instanceof IntProperty) {
            parallaxEffect = new ParallaxEffect();
        } else {
            parallaxEffect = new ParallaxEffect();
        }
        parallaxEffect.setPropertyRanges(propertyMarkerValueArr);
        this.f5974e.add(parallaxEffect);
        return parallaxEffect;
    }

    public final PropertyT addProperty(String str) {
        ArrayList arrayList = this.f5970a;
        int size = arrayList.size();
        PropertyT createProperty = createProperty(str, size);
        int i = 0;
        if (createProperty instanceof IntProperty) {
            int length = this.f5972c.length;
            if (length == size) {
                int[] iArr = new int[length * 2];
                while (i < length) {
                    iArr[i] = this.f5972c[i];
                    i++;
                }
                this.f5972c = iArr;
            }
            this.f5972c[size] = Integer.MAX_VALUE;
        } else if (createProperty instanceof FloatProperty) {
            int length2 = this.f5973d.length;
            if (length2 == size) {
                float[] fArr = new float[length2 * 2];
                while (i < length2) {
                    fArr[i] = this.f5973d[i];
                    i++;
                }
                this.f5973d = fArr;
            }
            this.f5973d[size] = Float.MAX_VALUE;
        } else {
            throw new IllegalArgumentException("Invalid Property type");
        }
        arrayList.add(createProperty);
        return createProperty;
    }

    public abstract PropertyT createProperty(String str, int i);

    public List<ParallaxEffect> getEffects() {
        return this.f5974e;
    }

    public abstract float getMaxValue();

    public final List<PropertyT> getProperties() {
        return this.f5971b;
    }

    public void removeAllEffects() {
        this.f5974e.clear();
    }

    public void removeEffect(ParallaxEffect parallaxEffect) {
        this.f5974e.remove(parallaxEffect);
    }

    @CallSuper
    public void updateValues() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f5974e;
            if (i < arrayList.size()) {
                ((ParallaxEffect) arrayList.get(i)).performMapping(this);
                i++;
            } else {
                return;
            }
        }
    }
}
