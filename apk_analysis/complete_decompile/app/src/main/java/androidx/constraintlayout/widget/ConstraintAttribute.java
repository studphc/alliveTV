package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class ConstraintAttribute {

    /* renamed from: a */
    public final boolean f3128a;

    /* renamed from: b */
    public final String f3129b;

    /* renamed from: c */
    public final AttributeType f3130c;

    /* renamed from: d */
    public int f3131d;

    /* renamed from: e */
    public float f3132e;

    /* renamed from: f */
    public String f3133f;

    /* renamed from: g */
    public boolean f3134g;

    /* renamed from: h */
    public int f3135h;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class AttributeType {
        public static final AttributeType BOOLEAN_TYPE;
        public static final AttributeType COLOR_DRAWABLE_TYPE;
        public static final AttributeType COLOR_TYPE;
        public static final AttributeType DIMENSION_TYPE;
        public static final AttributeType FLOAT_TYPE;
        public static final AttributeType INT_TYPE;
        public static final AttributeType REFERENCE_TYPE;
        public static final AttributeType STRING_TYPE;

        /* renamed from: a */
        public static final /* synthetic */ AttributeType[] f3136a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Enum, androidx.constraintlayout.widget.ConstraintAttribute$AttributeType] */
        static {
            ?? r8 = new Enum("INT_TYPE", 0);
            INT_TYPE = r8;
            ?? r9 = new Enum("FLOAT_TYPE", 1);
            FLOAT_TYPE = r9;
            ?? r10 = new Enum("COLOR_TYPE", 2);
            COLOR_TYPE = r10;
            ?? r11 = new Enum("COLOR_DRAWABLE_TYPE", 3);
            COLOR_DRAWABLE_TYPE = r11;
            ?? r12 = new Enum("STRING_TYPE", 4);
            STRING_TYPE = r12;
            ?? r13 = new Enum("BOOLEAN_TYPE", 5);
            BOOLEAN_TYPE = r13;
            ?? r14 = new Enum("DIMENSION_TYPE", 6);
            DIMENSION_TYPE = r14;
            ?? r15 = new Enum("REFERENCE_TYPE", 7);
            REFERENCE_TYPE = r15;
            f3136a = new AttributeType[]{r8, r9, r10, r11, r12, r13, r14, r15};
        }

        public static AttributeType valueOf(String str) {
            return (AttributeType) Enum.valueOf(AttributeType.class, str);
        }

        public static AttributeType[] values() {
            return (AttributeType[]) f3136a.clone();
        }
    }

    public ConstraintAttribute(String str, AttributeType attributeType) {
        this.f3128a = false;
        this.f3129b = str;
        this.f3130c = attributeType;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, null).invoke(view, null)));
                }
            } catch (IllegalAccessException e) {
                StringBuilder m7065u = AbstractC1726qj.m7065u(" Custom Attribute \"", str, "\" not found on ");
                m7065u.append(cls.getName());
                Log.e("TransitionLayout", m7065u.toString(), e);
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e2);
            } catch (InvocationTargetException e3) {
                StringBuilder m7065u2 = AbstractC1726qj.m7065u(" Custom Attribute \"", str, "\" not found on ");
                m7065u2.append(cls.getName());
                Log.e("TransitionLayout", m7065u2.toString(), e3);
            }
        }
        return hashMap2;
    }

    public static void parse(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        boolean z = false;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z = true;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, RecyclerView.f7068F0), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, RecyclerView.f7068F0));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    attributeType = AttributeType.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    attributeType = AttributeType.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.CustomAttribute_customReference) {
                    attributeType = AttributeType.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                Object obj2 = valueOf;
                attributeType2 = attributeType;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj, z));
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0038. Please report as an issue. */
    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> hashMap) {
        String str;
        Class<?> cls = view.getClass();
        for (String str2 : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str2);
            if (!constraintAttribute.f3128a) {
                str = AbstractC1726qj.m7038C("set", str2);
            } else {
                str = str2;
            }
            try {
                switch (constraintAttribute.f3130c.ordinal()) {
                    case 0:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f3131d));
                        break;
                    case 1:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f3132e));
                        break;
                    case 2:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f3135h));
                        break;
                    case 3:
                        Method method = cls.getMethod(str, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.f3135h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(str, CharSequence.class).invoke(view, constraintAttribute.f3133f);
                        break;
                    case 5:
                        cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.f3134g));
                        break;
                    case 6:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f3132e));
                        break;
                    case 7:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f3131d));
                        break;
                }
            } catch (IllegalAccessException e) {
                StringBuilder m7065u = AbstractC1726qj.m7065u(" Custom Attribute \"", str2, "\" not found on ");
                m7065u.append(cls.getName());
                Log.e("TransitionLayout", m7065u.toString(), e);
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e2);
            } catch (InvocationTargetException e3) {
                StringBuilder m7065u2 = AbstractC1726qj.m7065u(" Custom Attribute \"", str2, "\" not found on ");
                m7065u2.append(cls.getName());
                Log.e("TransitionLayout", m7065u2.toString(), e3);
            }
        }
    }

    public void applyCustom(View view) {
        String str;
        Class<?> cls = view.getClass();
        boolean z = this.f3128a;
        String str2 = this.f3129b;
        if (!z) {
            str = AbstractC1726qj.m7038C("set", str2);
        } else {
            str = str2;
        }
        try {
            switch (this.f3130c.ordinal()) {
                case 0:
                case 7:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.f3131d));
                    return;
                case 1:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f3132e));
                    return;
                case 2:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.f3135h));
                    return;
                case 3:
                    Method method = cls.getMethod(str, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.f3135h);
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    cls.getMethod(str, CharSequence.class).invoke(view, this.f3133f);
                    return;
                case 5:
                    cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(this.f3134g));
                    return;
                case 6:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f3132e));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            StringBuilder m7065u = AbstractC1726qj.m7065u(" Custom Attribute \"", str2, "\" not found on ");
            m7065u.append(cls.getName());
            Log.e("TransitionLayout", m7065u.toString(), e);
        } catch (NoSuchMethodException e2) {
            Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e2);
        } catch (InvocationTargetException e3) {
            StringBuilder m7065u2 = AbstractC1726qj.m7065u(" Custom Attribute \"", str2, "\" not found on ");
            m7065u2.append(cls.getName());
            Log.e("TransitionLayout", m7065u2.toString(), e3);
        }
    }

    public boolean diff(ConstraintAttribute constraintAttribute) {
        if (constraintAttribute == null) {
            return false;
        }
        AttributeType attributeType = constraintAttribute.f3130c;
        AttributeType attributeType2 = this.f3130c;
        if (attributeType2 != attributeType) {
            return false;
        }
        switch (attributeType2.ordinal()) {
            case 0:
            case 7:
                if (this.f3131d != constraintAttribute.f3131d) {
                    return false;
                }
                return true;
            case 1:
                if (this.f3132e != constraintAttribute.f3132e) {
                    return false;
                }
                return true;
            case 2:
            case 3:
                if (this.f3135h != constraintAttribute.f3135h) {
                    return false;
                }
                return true;
            case 4:
                if (this.f3131d != constraintAttribute.f3131d) {
                    return false;
                }
                return true;
            case 5:
                if (this.f3134g != constraintAttribute.f3134g) {
                    return false;
                }
                return true;
            case 6:
                if (this.f3132e != constraintAttribute.f3132e) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public int getColorValue() {
        return this.f3135h;
    }

    public float getFloatValue() {
        return this.f3132e;
    }

    public int getIntegerValue() {
        return this.f3131d;
    }

    public String getName() {
        return this.f3129b;
    }

    public String getStringValue() {
        return this.f3133f;
    }

    public AttributeType getType() {
        return this.f3130c;
    }

    public float getValueToInterpolate() {
        switch (this.f3130c.ordinal()) {
            case 0:
                return this.f3131d;
            case 1:
            case 6:
                return this.f3132e;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                if (this.f3134g) {
                    return 1.0f;
                }
                return RecyclerView.f7068F0;
            default:
                return Float.NaN;
        }
    }

    public void getValuesToInterpolate(float[] fArr) {
        float f;
        switch (this.f3130c.ordinal()) {
            case 0:
                fArr[0] = this.f3131d;
                return;
            case 1:
                fArr[0] = this.f3132e;
                return;
            case 2:
            case 3:
                int i = (this.f3135h >> 24) & 255;
                float pow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float pow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float pow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = pow3;
                fArr[3] = i / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                if (this.f3134g) {
                    f = 1.0f;
                } else {
                    f = RecyclerView.f7068F0;
                }
                fArr[0] = f;
                return;
            case 6:
                fArr[0] = this.f3132e;
                return;
            default:
                return;
        }
    }

    public boolean isBooleanValue() {
        return this.f3134g;
    }

    public boolean isContinuous() {
        int ordinal = this.f3130c.ordinal();
        if (ordinal != 4 && ordinal != 5 && ordinal != 7) {
            return true;
        }
        return false;
    }

    public boolean isMethod() {
        return this.f3128a;
    }

    public int numberOfInterpolatedValues() {
        int ordinal = this.f3130c.ordinal();
        if (ordinal != 2 && ordinal != 3) {
            return 1;
        }
        return 4;
    }

    public void setColorValue(int i) {
        this.f3135h = i;
    }

    public void setFloatValue(float f) {
        this.f3132e = f;
    }

    public void setIntValue(int i) {
        this.f3131d = i;
    }

    public void setStringValue(String str) {
        this.f3133f = str;
    }

    public void setValue(float[] fArr) {
        switch (this.f3130c.ordinal()) {
            case 0:
            case 7:
                this.f3131d = (int) fArr[0];
                return;
            case 1:
                this.f3132e = fArr[0];
                return;
            case 2:
            case 3:
                int HSVToColor = Color.HSVToColor(fArr);
                this.f3135h = HSVToColor;
                int i = HSVToColor & ViewCompat.MEASURED_SIZE_MASK;
                int i2 = (int) (fArr[3] * 255.0f);
                int i3 = (i2 & (~(i2 >> 31))) - 255;
                this.f3135h = (((i3 & (i3 >> 31)) + 255) << 24) | i;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                this.f3134g = ((double) fArr[0]) > 0.5d;
                return;
            case 6:
                this.f3132e = fArr[0];
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.f3129b = str;
        this.f3130c = attributeType;
        this.f3128a = z;
        setValue(obj);
    }

    public void setValue(Object obj) {
        switch (this.f3130c.ordinal()) {
            case 0:
            case 7:
                this.f3131d = ((Integer) obj).intValue();
                return;
            case 1:
                this.f3132e = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.f3135h = ((Integer) obj).intValue();
                return;
            case 4:
                this.f3133f = (String) obj;
                return;
            case 5:
                this.f3134g = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.f3132e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f3128a = false;
        this.f3129b = constraintAttribute.f3129b;
        this.f3130c = constraintAttribute.f3130c;
        setValue(obj);
    }
}
