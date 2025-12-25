package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.core.os.EnvironmentCompat;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.util.HashMap;
import java.util.Set;
import p000.AbstractC1726qj;
import p000.sv2;

/* loaded from: classes.dex */
public class WidgetFrame {
    public static float phone_orientation = Float.NaN;

    /* renamed from: a */
    public final HashMap f2388a;
    public float alpha;

    /* renamed from: b */
    public TypedBundle f2389b;
    public int bottom;
    public float interpolatedPos;
    public int left;
    public String name;
    public float pivotX;
    public float pivotY;
    public int right;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public int top;
    public float translationX;
    public float translationY;
    public float translationZ;
    public int visibility;
    public ConstraintWidget widget;

    public WidgetFrame() {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.f2388a = new HashMap();
        this.name = null;
    }

    /* renamed from: a */
    public static void m463a(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(": ");
        sb.append(f);
        sb.append(",\n");
    }

    /* renamed from: b */
    public static void m464b(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append(": ");
        sb.append(i);
        sb.append(",\n");
    }

    /* renamed from: c */
    public static float m465c(float f, float f2, float f3, float f4) {
        boolean isNaN = Float.isNaN(f);
        boolean isNaN2 = Float.isNaN(f2);
        if (isNaN && isNaN2) {
            return Float.NaN;
        }
        if (isNaN) {
            f = f3;
        }
        if (isNaN2) {
            f2 = f3;
        }
        return AbstractC1726qj.m7051g(f2, f, f4, f);
    }

    public static void interpolate(int i, int i2, WidgetFrame widgetFrame, WidgetFrame widgetFrame2, WidgetFrame widgetFrame3, Transition transition, float f) {
        int i3;
        float f2;
        int i4;
        int i5;
        float f3;
        float f4;
        float f5;
        int i6;
        float f6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        float f7 = 100.0f * f;
        int i13 = (int) f7;
        int i14 = widgetFrame2.left;
        int i15 = widgetFrame2.top;
        int i16 = widgetFrame3.left;
        int i17 = widgetFrame3.top;
        int i18 = widgetFrame2.right - i14;
        int i19 = widgetFrame2.bottom - i15;
        int i20 = widgetFrame3.right - i16;
        int i21 = widgetFrame3.bottom - i17;
        float f8 = widgetFrame2.alpha;
        float f9 = widgetFrame3.alpha;
        if (widgetFrame2.visibility == 8) {
            i15 -= (int) (i21 / 2.0f);
            i5 = i14 - ((int) (i20 / 2.0f));
            if (Float.isNaN(f8)) {
                i4 = i21;
                i3 = i20;
                f2 = RecyclerView.f7068F0;
            } else {
                f2 = f8;
                i3 = i20;
                i4 = i21;
            }
        } else {
            i3 = i18;
            f2 = f8;
            i4 = i19;
            i5 = i14;
        }
        if (widgetFrame3.visibility == 8) {
            i16 -= (int) (i3 / 2.0f);
            i17 -= (int) (i4 / 2.0f);
            i20 = i3;
            i21 = i4;
            if (Float.isNaN(f9)) {
                f9 = RecyclerView.f7068F0;
            }
        }
        if (Float.isNaN(f2) && !Float.isNaN(f9)) {
            f2 = 1.0f;
        }
        if (!Float.isNaN(f2) && Float.isNaN(f9)) {
            f9 = 1.0f;
        }
        if (widgetFrame2.visibility == 4) {
            f4 = f9;
            f3 = RecyclerView.f7068F0;
        } else {
            f3 = f2;
            f4 = f9;
        }
        if (widgetFrame3.visibility == 4) {
            f5 = RecyclerView.f7068F0;
        } else {
            f5 = f4;
        }
        if (widgetFrame.widget != null && transition.hasPositionKeyframes()) {
            sv2 findPreviousPosition = transition.findPreviousPosition(widgetFrame.widget.stringId, i13);
            i6 = i15;
            sv2 findNextPosition = transition.findNextPosition(widgetFrame.widget.stringId, i13);
            if (findPreviousPosition == findNextPosition) {
                findNextPosition = null;
            }
            if (findPreviousPosition != null) {
                i5 = (int) (findPreviousPosition.f26589b * i);
                i10 = i16;
                i9 = i2;
                i6 = (int) (findPreviousPosition.f26590c * i9);
                i11 = findPreviousPosition.f26588a;
            } else {
                i9 = i2;
                i10 = i16;
                i11 = 0;
            }
            i7 = i5;
            if (findNextPosition != null) {
                i8 = (int) (findNextPosition.f26589b * i);
                i17 = (int) (findNextPosition.f26590c * i9);
                i12 = findNextPosition.f26588a;
            } else {
                i12 = 100;
                i8 = i10;
            }
            f6 = (f7 - i11) / (i12 - i11);
        } else {
            i6 = i15;
            f6 = f;
            i7 = i5;
            i8 = i16;
        }
        int i22 = i6;
        widgetFrame.widget = widgetFrame2.widget;
        int i23 = (int) (((i8 - i7) * f6) + i7);
        widgetFrame.left = i23;
        int i24 = (int) ((f6 * (i17 - i22)) + i22);
        widgetFrame.top = i24;
        float f10 = 1.0f - f;
        widgetFrame.right = i23 + ((int) ((i20 * f) + (i3 * f10)));
        widgetFrame.bottom = i24 + ((int) ((i21 * f) + (f10 * i4)));
        widgetFrame.pivotX = m465c(widgetFrame2.pivotX, widgetFrame3.pivotX, 0.5f, f);
        widgetFrame.pivotY = m465c(widgetFrame2.pivotY, widgetFrame3.pivotY, 0.5f, f);
        widgetFrame.rotationX = m465c(widgetFrame2.rotationX, widgetFrame3.rotationX, RecyclerView.f7068F0, f);
        widgetFrame.rotationY = m465c(widgetFrame2.rotationY, widgetFrame3.rotationY, RecyclerView.f7068F0, f);
        widgetFrame.rotationZ = m465c(widgetFrame2.rotationZ, widgetFrame3.rotationZ, RecyclerView.f7068F0, f);
        widgetFrame.scaleX = m465c(widgetFrame2.scaleX, widgetFrame3.scaleX, 1.0f, f);
        widgetFrame.scaleY = m465c(widgetFrame2.scaleY, widgetFrame3.scaleY, 1.0f, f);
        widgetFrame.translationX = m465c(widgetFrame2.translationX, widgetFrame3.translationX, RecyclerView.f7068F0, f);
        widgetFrame.translationY = m465c(widgetFrame2.translationY, widgetFrame3.translationY, RecyclerView.f7068F0, f);
        widgetFrame.translationZ = m465c(widgetFrame2.translationZ, widgetFrame3.translationZ, RecyclerView.f7068F0, f);
        widgetFrame.alpha = m465c(f3, f5, 1.0f, f);
        HashMap hashMap = widgetFrame3.f2388a;
        Set<String> keySet = hashMap.keySet();
        HashMap hashMap2 = widgetFrame.f2388a;
        hashMap2.clear();
        for (String str : keySet) {
            HashMap hashMap3 = widgetFrame2.f2388a;
            if (hashMap3.containsKey(str)) {
                CustomVariable customVariable = (CustomVariable) hashMap3.get(str);
                CustomVariable customVariable2 = (CustomVariable) hashMap.get(str);
                CustomVariable customVariable3 = new CustomVariable(customVariable);
                hashMap2.put(str, customVariable3);
                if (customVariable.numberOfInterpolatedValues() == 1) {
                    customVariable3.setValue(Float.valueOf(m465c(customVariable.getValueToInterpolate(), customVariable2.getValueToInterpolate(), RecyclerView.f7068F0, f)));
                } else {
                    int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
                    float[] fArr = new float[numberOfInterpolatedValues];
                    float[] fArr2 = new float[numberOfInterpolatedValues];
                    customVariable.getValuesToInterpolate(fArr);
                    customVariable2.getValuesToInterpolate(fArr2);
                    for (int i25 = 0; i25 < numberOfInterpolatedValues; i25++) {
                        fArr[i25] = m465c(fArr[i25], fArr2[i25], RecyclerView.f7068F0, f);
                        customVariable3.setValue(fArr);
                    }
                }
            }
        }
    }

    public void addCustomColor(String str, int i) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_COLOR, i);
    }

    public void addCustomFloat(String str, float f) {
        setCustomAttribute(str, TypedValues.Custom.TYPE_FLOAT, f);
    }

    public float centerX() {
        return ((this.right - r0) / 2.0f) + this.left;
    }

    public float centerY() {
        return ((this.bottom - r0) / 2.0f) + this.top;
    }

    public boolean containsCustom(@NonNull String str) {
        return this.f2388a.containsKey(str);
    }

    public CustomVariable getCustomAttribute(String str) {
        return (CustomVariable) this.f2388a.get(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.f2388a.keySet();
    }

    public int getCustomColor(String str) {
        HashMap hashMap = this.f2388a;
        if (hashMap.containsKey(str)) {
            return ((CustomVariable) hashMap.get(str)).getColorValue();
        }
        return -21880;
    }

    public float getCustomFloat(String str) {
        HashMap hashMap = this.f2388a;
        if (hashMap.containsKey(str)) {
            return ((CustomVariable) hashMap.get(str)).getFloatValue();
        }
        return Float.NaN;
    }

    public String getId() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return constraintWidget.stringId;
    }

    public TypedBundle getMotionProperties() {
        return this.f2389b;
    }

    public int height() {
        return Math.max(0, this.bottom - this.top);
    }

    public boolean isDefaultTransform() {
        if (Float.isNaN(this.rotationX) && Float.isNaN(this.rotationY) && Float.isNaN(this.rotationZ) && Float.isNaN(this.translationX) && Float.isNaN(this.translationY) && Float.isNaN(this.translationZ) && Float.isNaN(this.scaleX) && Float.isNaN(this.scaleY) && Float.isNaN(this.alpha)) {
            return true;
        }
        return false;
    }

    public StringBuilder serialize(StringBuilder sb) {
        return serialize(sb, false);
    }

    public void setCustomAttribute(String str, int i, float f) {
        HashMap hashMap = this.f2388a;
        if (hashMap.containsKey(str)) {
            ((CustomVariable) hashMap.get(str)).setFloatValue(f);
        } else {
            hashMap.put(str, new CustomVariable(str, i, f));
        }
    }

    public void setCustomValue(CustomAttribute customAttribute, float[] fArr) {
    }

    public boolean setValue(String str, CLElement cLElement) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1881940865:
                if (str.equals("phone_orientation")) {
                    c = 0;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    c = 1;
                    break;
                }
                break;
            case -1349088399:
                if (str.equals(SchedulerSupport.CUSTOM)) {
                    c = 2;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 3;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 4;
                    break;
                }
                break;
            case -1249320804:
                if (str.equals("rotationZ")) {
                    c = 5;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 6;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 7;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = '\b';
                    break;
                }
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    c = '\t';
                    break;
                }
                break;
            case -987906985:
                if (str.equals("pivotY")) {
                    c = '\n';
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 11;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\f';
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c = '\r';
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 14;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 15;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c = 16;
                    break;
                }
                break;
            case 642850769:
                if (str.equals("interpolatedPos")) {
                    c = 17;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                phone_orientation = cLElement.getFloat();
                return true;
            case 1:
                this.bottom = cLElement.getInt();
                return true;
            case 2:
                CLObject cLObject = (CLObject) cLElement;
                int size = cLObject.size();
                for (int i = 0; i < size; i++) {
                    CLElement value = ((CLKey) cLObject.get(i)).getValue();
                    String content = value.content();
                    if (content.matches("#[0-9a-fA-F]+")) {
                        setCustomAttribute(this.name, TypedValues.Custom.TYPE_COLOR, Integer.parseInt(content.substring(1), 16));
                    } else if (value instanceof CLNumber) {
                        setCustomAttribute(this.name, TypedValues.Custom.TYPE_FLOAT, value.getFloat());
                    } else {
                        setCustomAttribute(this.name, TypedValues.Custom.TYPE_STRING, content);
                    }
                }
                return true;
            case 3:
                this.rotationX = cLElement.getFloat();
                return true;
            case 4:
                this.rotationY = cLElement.getFloat();
                return true;
            case 5:
                this.rotationZ = cLElement.getFloat();
                return true;
            case 6:
                this.translationX = cLElement.getFloat();
                return true;
            case 7:
                this.translationY = cLElement.getFloat();
                return true;
            case '\b':
                this.translationZ = cLElement.getFloat();
                return true;
            case '\t':
                this.pivotX = cLElement.getFloat();
                return true;
            case '\n':
                this.pivotY = cLElement.getFloat();
                return true;
            case 11:
                this.scaleX = cLElement.getFloat();
                return true;
            case '\f':
                this.scaleY = cLElement.getFloat();
                return true;
            case '\r':
                this.top = cLElement.getInt();
                return true;
            case 14:
                this.left = cLElement.getInt();
                return true;
            case 15:
                this.alpha = cLElement.getFloat();
                return true;
            case 16:
                this.right = cLElement.getInt();
                return true;
            case 17:
                this.interpolatedPos = cLElement.getFloat();
                return true;
            default:
                return false;
        }
    }

    public WidgetFrame update() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget != null) {
            this.left = constraintWidget.getLeft();
            this.top = this.widget.getTop();
            this.right = this.widget.getRight();
            this.bottom = this.widget.getBottom();
            updateAttributes(this.widget.frame);
        }
        return this;
    }

    public void updateAttributes(WidgetFrame widgetFrame) {
        if (widgetFrame == null) {
            return;
        }
        this.pivotX = widgetFrame.pivotX;
        this.pivotY = widgetFrame.pivotY;
        this.rotationX = widgetFrame.rotationX;
        this.rotationY = widgetFrame.rotationY;
        this.rotationZ = widgetFrame.rotationZ;
        this.translationX = widgetFrame.translationX;
        this.translationY = widgetFrame.translationY;
        this.translationZ = widgetFrame.translationZ;
        this.scaleX = widgetFrame.scaleX;
        this.scaleY = widgetFrame.scaleY;
        this.alpha = widgetFrame.alpha;
        this.visibility = widgetFrame.visibility;
        this.f2389b = widgetFrame.f2389b;
        HashMap hashMap = this.f2388a;
        hashMap.clear();
        for (CustomVariable customVariable : widgetFrame.f2388a.values()) {
            hashMap.put(customVariable.getName(), customVariable.copy());
        }
    }

    public int width() {
        return Math.max(0, this.right - this.left);
    }

    public StringBuilder serialize(StringBuilder sb, boolean z) {
        sb.append("{\n");
        m464b(sb, "left", this.left);
        m464b(sb, "top", this.top);
        m464b(sb, "right", this.right);
        m464b(sb, "bottom", this.bottom);
        m463a(sb, "pivotX", this.pivotX);
        m463a(sb, "pivotY", this.pivotY);
        m463a(sb, "rotationX", this.rotationX);
        m463a(sb, "rotationY", this.rotationY);
        m463a(sb, "rotationZ", this.rotationZ);
        m463a(sb, "translationX", this.translationX);
        m463a(sb, "translationY", this.translationY);
        m463a(sb, "translationZ", this.translationZ);
        m463a(sb, "scaleX", this.scaleX);
        m463a(sb, "scaleY", this.scaleY);
        m463a(sb, "alpha", this.alpha);
        m464b(sb, "visibility", this.visibility);
        m463a(sb, "interpolatedPos", this.interpolatedPos);
        if (this.widget != null) {
            for (ConstraintAnchor.Type type : ConstraintAnchor.Type.values()) {
                ConstraintAnchor anchor = this.widget.getAnchor(type);
                if (anchor != null && anchor.mTarget != null) {
                    sb.append("Anchor");
                    sb.append(type.name());
                    sb.append(": ['");
                    String str = anchor.mTarget.getOwner().stringId;
                    if (str == null) {
                        str = "#PARENT";
                    }
                    sb.append(str);
                    sb.append("', '");
                    sb.append(anchor.mTarget.getType().name());
                    sb.append("', '");
                    sb.append(anchor.mMargin);
                    sb.append("'],\n");
                }
            }
        }
        if (z) {
            m463a(sb, "phone_orientation", phone_orientation);
        }
        if (z) {
            m463a(sb, "phone_orientation", phone_orientation);
        }
        HashMap hashMap = this.f2388a;
        if (hashMap.size() != 0) {
            sb.append("custom : {\n");
            for (String str2 : hashMap.keySet()) {
                CustomVariable customVariable = (CustomVariable) hashMap.get(str2);
                sb.append(str2);
                sb.append(": ");
                switch (customVariable.getType()) {
                    case TypedValues.Custom.TYPE_INT /* 900 */:
                        sb.append(customVariable.getIntegerValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_FLOAT /* 901 */:
                    case TypedValues.Custom.TYPE_DIMENSION /* 905 */:
                        sb.append(customVariable.getFloatValue());
                        sb.append(",\n");
                        break;
                    case TypedValues.Custom.TYPE_COLOR /* 902 */:
                        sb.append("'");
                        sb.append(CustomVariable.colorString(customVariable.getIntegerValue()));
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_STRING /* 903 */:
                        sb.append("'");
                        sb.append(customVariable.getStringValue());
                        sb.append("',\n");
                        break;
                    case TypedValues.Custom.TYPE_BOOLEAN /* 904 */:
                        sb.append("'");
                        sb.append(customVariable.getBooleanValue());
                        sb.append("',\n");
                        break;
                }
            }
            sb.append("}\n");
        }
        sb.append("}\n");
        return sb;
    }

    public void setCustomAttribute(String str, int i, int i2) {
        HashMap hashMap = this.f2388a;
        if (hashMap.containsKey(str)) {
            ((CustomVariable) hashMap.get(str)).setIntValue(i2);
        } else {
            hashMap.put(str, new CustomVariable(str, i, i2));
        }
    }

    public void setCustomAttribute(String str, int i, boolean z) {
        HashMap hashMap = this.f2388a;
        if (hashMap.containsKey(str)) {
            ((CustomVariable) hashMap.get(str)).setBooleanValue(z);
        } else {
            hashMap.put(str, new CustomVariable(str, i, z));
        }
    }

    public WidgetFrame update(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return this;
        }
        this.widget = constraintWidget;
        update();
        return this;
    }

    public void setCustomAttribute(String str, int i, String str2) {
        HashMap hashMap = this.f2388a;
        if (hashMap.containsKey(str)) {
            ((CustomVariable) hashMap.get(str)).setStringValue(str2);
        } else {
            hashMap.put(str, new CustomVariable(str, i, str2));
        }
    }

    public WidgetFrame(ConstraintWidget constraintWidget) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.f2388a = new HashMap();
        this.name = null;
        this.widget = constraintWidget;
    }

    public WidgetFrame(WidgetFrame widgetFrame) {
        this.widget = null;
        this.left = 0;
        this.top = 0;
        this.right = 0;
        this.bottom = 0;
        this.pivotX = Float.NaN;
        this.pivotY = Float.NaN;
        this.rotationX = Float.NaN;
        this.rotationY = Float.NaN;
        this.rotationZ = Float.NaN;
        this.translationX = Float.NaN;
        this.translationY = Float.NaN;
        this.translationZ = Float.NaN;
        this.scaleX = Float.NaN;
        this.scaleY = Float.NaN;
        this.alpha = Float.NaN;
        this.interpolatedPos = Float.NaN;
        this.visibility = 0;
        this.f2388a = new HashMap();
        this.name = null;
        this.widget = widgetFrame.widget;
        this.left = widgetFrame.left;
        this.top = widgetFrame.top;
        this.right = widgetFrame.right;
        this.bottom = widgetFrame.bottom;
        updateAttributes(widgetFrame);
    }
}
