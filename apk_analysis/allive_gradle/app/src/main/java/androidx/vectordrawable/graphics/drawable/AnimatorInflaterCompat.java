package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.annotation.AnimatorRes;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.xmlpull.v1.XmlPullParserException;
import p000.yy2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class AnimatorInflaterCompat {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x037c, code lost:
    
        r1 = new android.animation.Animator[r14.size()];
        r3 = r14.iterator();
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x038b, code lost:
    
        if (r3.hasNext() == false) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x038d, code lost:
    
        r1[r15] = (android.animation.Animator) r3.next();
        r15 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0399, code lost:
    
        if (r34 != 0) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x039b, code lost:
    
        r33.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x039f, code lost:
    
        r33.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x03a2, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0378, code lost:
    
        if (r33 == null) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x037a, code lost:
    
        if (r14 == null) goto L182;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0350  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Animator m1913a(Context context, Resources resources, Resources.Theme theme, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) {
        int i2;
        PropertyValuesHolder[] propertyValuesHolderArr;
        AttributeSet attributeSet2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        int i7;
        PropertyValuesHolder propertyValuesHolder;
        int size;
        int i8;
        Keyframe ofObject;
        Keyframe ofObject2;
        int i9;
        int i10;
        String str2;
        boolean z;
        int i11;
        int i12;
        Keyframe ofInt;
        int i13;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        int depth = xmlResourceParser.getDepth();
        ValueAnimator valueAnimator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlResourceParser.next();
            int i14 = 3;
            int i15 = 0;
            if (next == 3 && xmlResourceParser.getDepth() <= depth) {
                break;
            }
            int i16 = 1;
            if (next == 1) {
                break;
            }
            int i17 = 2;
            if (next == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("objectAnimator")) {
                    ObjectAnimator objectAnimator = new ObjectAnimator();
                    m1916d(context, resources, theme, attributeSet, objectAnimator, f, xmlResourceParser);
                    valueAnimator = objectAnimator;
                } else if (name.equals("animator")) {
                    valueAnimator = m1916d(context, resources, theme, attributeSet, null, f, xmlResourceParser);
                } else {
                    if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources2, theme2, attributeSet, yy2.f29184h);
                        m1913a(context, resources, theme, xmlResourceParser, attributeSet, animatorSet2, TypedArrayUtils.getNamedInt(obtainAttributes, xmlResourceParser, "ordering", 0, 0), f);
                        obtainAttributes.recycle();
                        i2 = depth;
                        valueAnimator = animatorSet2;
                    } else {
                        String str3 = "propertyValuesHolder";
                        if (name.equals("propertyValuesHolder")) {
                            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                            ArrayList arrayList2 = null;
                            while (true) {
                                int eventType = xmlResourceParser.getEventType();
                                if (eventType == i14 || eventType == i16) {
                                    break;
                                }
                                if (eventType != i17) {
                                    xmlResourceParser.next();
                                } else {
                                    if (xmlResourceParser.getName().equals(str3)) {
                                        TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources2, theme2, asAttributeSet, yy2.f29185i);
                                        String namedString = TypedArrayUtils.getNamedString(obtainAttributes2, xmlResourceParser, "propertyName", i14);
                                        int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes2, xmlResourceParser, "valueType", i17, 4);
                                        int i18 = namedInt;
                                        ArrayList arrayList3 = null;
                                        while (true) {
                                            int next2 = xmlResourceParser.next();
                                            attributeSet2 = asAttributeSet;
                                            if (next2 == i14 || next2 == 1) {
                                                break;
                                            }
                                            if (xmlResourceParser.getName().equals("keyframe")) {
                                                int[] iArr = yy2.f29186j;
                                                i10 = i18;
                                                str2 = str3;
                                                if (i10 == 4) {
                                                    TypedArray obtainAttributes3 = TypedArrayUtils.obtainAttributes(resources2, theme2, Xml.asAttributeSet(xmlResourceParser), iArr);
                                                    i9 = depth;
                                                    TypedValue peekNamedValue = TypedArrayUtils.peekNamedValue(obtainAttributes3, xmlResourceParser, "value", 0);
                                                    if (peekNamedValue != null && m1915c(peekNamedValue.type)) {
                                                        i13 = 3;
                                                    } else {
                                                        i13 = 0;
                                                    }
                                                    obtainAttributes3.recycle();
                                                    i10 = i13;
                                                } else {
                                                    i9 = depth;
                                                }
                                                TypedArray obtainAttributes4 = TypedArrayUtils.obtainAttributes(resources2, theme2, Xml.asAttributeSet(xmlResourceParser), iArr);
                                                float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlResourceParser, "fraction", 3, -1.0f);
                                                TypedValue peekNamedValue2 = TypedArrayUtils.peekNamedValue(obtainAttributes4, xmlResourceParser, "value", 0);
                                                if (peekNamedValue2 != null) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                if (i10 == 4) {
                                                    if (z && m1915c(peekNamedValue2.type)) {
                                                        i11 = 3;
                                                    } else {
                                                        i11 = 0;
                                                    }
                                                } else {
                                                    i11 = i10;
                                                }
                                                if (z) {
                                                    if (i11 != 0) {
                                                        if (i11 != 1 && i11 != 3) {
                                                            ofInt = null;
                                                            i12 = 0;
                                                        } else {
                                                            i12 = 0;
                                                            ofInt = Keyframe.ofInt(namedFloat, TypedArrayUtils.getNamedInt(obtainAttributes4, xmlResourceParser, "value", 0, 0));
                                                        }
                                                    } else {
                                                        i12 = 0;
                                                        ofInt = Keyframe.ofFloat(namedFloat, TypedArrayUtils.getNamedFloat(obtainAttributes4, xmlResourceParser, "value", 0, RecyclerView.f7068F0));
                                                    }
                                                } else {
                                                    i12 = 0;
                                                    if (i11 == 0) {
                                                        ofInt = Keyframe.ofFloat(namedFloat);
                                                    } else {
                                                        ofInt = Keyframe.ofInt(namedFloat);
                                                    }
                                                }
                                                int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainAttributes4, xmlResourceParser, "interpolator", 1, i12);
                                                if (namedResourceId > 0) {
                                                    ofInt.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
                                                }
                                                obtainAttributes4.recycle();
                                                if (ofInt != null) {
                                                    if (arrayList3 == null) {
                                                        arrayList3 = new ArrayList();
                                                    }
                                                    arrayList3.add(ofInt);
                                                }
                                                xmlResourceParser.next();
                                            } else {
                                                i9 = depth;
                                                i10 = i18;
                                                str2 = str3;
                                            }
                                            resources2 = resources;
                                            theme2 = theme;
                                            str3 = str2;
                                            asAttributeSet = attributeSet2;
                                            depth = i9;
                                            i18 = i10;
                                            i14 = 3;
                                        }
                                        i4 = depth;
                                        int i19 = i18;
                                        str = str3;
                                        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                                            Keyframe keyframe = (Keyframe) arrayList3.get(0);
                                            Keyframe keyframe2 = (Keyframe) arrayList3.get(size - 1);
                                            float fraction = keyframe2.getFraction();
                                            if (fraction < 1.0f) {
                                                if (fraction < RecyclerView.f7068F0) {
                                                    keyframe2.setFraction(1.0f);
                                                } else {
                                                    int size2 = arrayList3.size();
                                                    if (keyframe2.getType() == Float.TYPE) {
                                                        ofObject2 = Keyframe.ofFloat(1.0f);
                                                    } else if (keyframe2.getType() == Integer.TYPE) {
                                                        ofObject2 = Keyframe.ofInt(1.0f);
                                                    } else {
                                                        ofObject2 = Keyframe.ofObject(1.0f);
                                                    }
                                                    arrayList3.add(size2, ofObject2);
                                                    size++;
                                                }
                                            }
                                            float fraction2 = keyframe.getFraction();
                                            if (fraction2 != RecyclerView.f7068F0) {
                                                if (fraction2 < RecyclerView.f7068F0) {
                                                    keyframe.setFraction(RecyclerView.f7068F0);
                                                } else {
                                                    if (keyframe.getType() == Float.TYPE) {
                                                        ofObject = Keyframe.ofFloat(RecyclerView.f7068F0);
                                                    } else if (keyframe.getType() == Integer.TYPE) {
                                                        ofObject = Keyframe.ofInt(RecyclerView.f7068F0);
                                                    } else {
                                                        ofObject = Keyframe.ofObject(RecyclerView.f7068F0);
                                                    }
                                                    arrayList3.add(0, ofObject);
                                                    size++;
                                                }
                                            }
                                            Keyframe[] keyframeArr = new Keyframe[size];
                                            arrayList3.toArray(keyframeArr);
                                            int i20 = 0;
                                            while (i20 < size) {
                                                Keyframe keyframe3 = keyframeArr[i20];
                                                if (keyframe3.getFraction() < RecyclerView.f7068F0) {
                                                    if (i20 == 0) {
                                                        keyframe3.setFraction(RecyclerView.f7068F0);
                                                    } else {
                                                        int i21 = size - 1;
                                                        if (i20 == i21) {
                                                            keyframe3.setFraction(1.0f);
                                                            i8 = size;
                                                        } else {
                                                            int i22 = i20;
                                                            for (int i23 = i20 + 1; i23 < i21 && keyframeArr[i23].getFraction() < RecyclerView.f7068F0; i23++) {
                                                                i22 = i23;
                                                            }
                                                            float fraction3 = (keyframeArr[i22 + 1].getFraction() - keyframeArr[i20 - 1].getFraction()) / ((i22 - i20) + 2);
                                                            int i24 = i20;
                                                            while (i24 <= i22) {
                                                                keyframeArr[i24].setFraction(keyframeArr[i24 - 1].getFraction() + fraction3);
                                                                i24++;
                                                                size = size;
                                                            }
                                                            i8 = size;
                                                        }
                                                        i20++;
                                                        size = i8;
                                                    }
                                                }
                                                i8 = size;
                                                i20++;
                                                size = i8;
                                            }
                                            i3 = 2;
                                            propertyValuesHolder = PropertyValuesHolder.ofKeyframe(namedString, keyframeArr);
                                            i6 = 3;
                                            if (i19 == 3) {
                                                propertyValuesHolder.setEvaluator(ArgbEvaluator.getInstance());
                                            }
                                        } else {
                                            i6 = 3;
                                            i3 = 2;
                                            propertyValuesHolder = null;
                                        }
                                        i7 = 0;
                                        i5 = 1;
                                        if (propertyValuesHolder == null) {
                                            propertyValuesHolder = m1914b(obtainAttributes2, namedInt, 0, 1, namedString);
                                        }
                                        if (propertyValuesHolder != null) {
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            arrayList2.add(propertyValuesHolder);
                                        }
                                        obtainAttributes2.recycle();
                                    } else {
                                        attributeSet2 = asAttributeSet;
                                        i3 = i17;
                                        str = str3;
                                        i4 = depth;
                                        i5 = i16;
                                        i6 = i14;
                                        i7 = i15;
                                    }
                                    xmlResourceParser.next();
                                    resources2 = resources;
                                    theme2 = theme;
                                    i15 = i7;
                                    i14 = i6;
                                    i16 = i5;
                                    i17 = i3;
                                    str3 = str;
                                    asAttributeSet = attributeSet2;
                                    depth = i4;
                                }
                            }
                            int i25 = i16;
                            i2 = depth;
                            int i26 = i15;
                            if (arrayList2 != null) {
                                int size3 = arrayList2.size();
                                propertyValuesHolderArr = new PropertyValuesHolder[size3];
                                for (int i27 = i26; i27 < size3; i27++) {
                                    propertyValuesHolderArr[i27] = (PropertyValuesHolder) arrayList2.get(i27);
                                }
                            } else {
                                propertyValuesHolderArr = null;
                            }
                            if (propertyValuesHolderArr != null && (valueAnimator instanceof ValueAnimator)) {
                                valueAnimator.setValues(propertyValuesHolderArr);
                            }
                            i15 = i25;
                        } else {
                            throw new RuntimeException("Unknown animator name: " + xmlResourceParser.getName());
                        }
                    }
                    if (animatorSet != null && i15 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAnimator);
                    }
                    resources2 = resources;
                    theme2 = theme;
                    depth = i2;
                }
                i2 = depth;
                if (animatorSet != null) {
                    if (arrayList == null) {
                    }
                    arrayList.add(valueAnimator);
                }
                resources2 = resources;
                theme2 = theme;
                depth = i2;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v26, types: [android.animation.TypeEvaluator, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.animation.TypeEvaluator, java.lang.Object] */
    /* renamed from: b */
    public static PropertyValuesHolder m1914b(TypedArray typedArray, int i, int i2, int i3, String str) {
        boolean z;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        ArgbEvaluator argbEvaluator;
        int i6;
        int i7;
        int i8;
        float f;
        PropertyValuesHolder ofFloat;
        float f2;
        float f3;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i4 = peekValue.type;
        } else {
            i4 = 0;
        }
        TypedValue peekValue2 = typedArray.peekValue(i3);
        if (peekValue2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i5 = peekValue2.type;
        } else {
            i5 = 0;
        }
        if (i == 4) {
            if ((z && m1915c(i4)) || (z2 && m1915c(i5))) {
                i = 3;
            } else {
                i = 0;
            }
        }
        if (i == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            String string = typedArray.getString(i2);
            String string2 = typedArray.getString(i3);
            PathParser.PathDataNode[] createNodesFromPathData = PathParser.createNodesFromPathData(string);
            PathParser.PathDataNode[] createNodesFromPathData2 = PathParser.createNodesFromPathData(string2);
            if (createNodesFromPathData == null && createNodesFromPathData2 == null) {
                return null;
            }
            if (createNodesFromPathData != null) {
                ?? obj = new Object();
                if (createNodesFromPathData2 != null) {
                    if (PathParser.canMorph(createNodesFromPathData, createNodesFromPathData2)) {
                        ofObject = PropertyValuesHolder.ofObject(str, (TypeEvaluator) obj, createNodesFromPathData, createNodesFromPathData2);
                    } else {
                        throw new InflateException(" Can't morph from " + string + " to " + string2);
                    }
                } else {
                    ofObject = PropertyValuesHolder.ofObject(str, (TypeEvaluator) obj, createNodesFromPathData);
                }
                return ofObject;
            }
            if (createNodesFromPathData2 == null) {
                return null;
            }
            return PropertyValuesHolder.ofObject(str, (TypeEvaluator) new Object(), createNodesFromPathData2);
        }
        if (i == 3) {
            argbEvaluator = ArgbEvaluator.getInstance();
        } else {
            argbEvaluator = null;
        }
        if (z3) {
            if (z) {
                if (i4 == 5) {
                    f2 = typedArray.getDimension(i2, RecyclerView.f7068F0);
                } else {
                    f2 = typedArray.getFloat(i2, RecyclerView.f7068F0);
                }
                if (z2) {
                    if (i5 == 5) {
                        f3 = typedArray.getDimension(i3, RecyclerView.f7068F0);
                    } else {
                        f3 = typedArray.getFloat(i3, RecyclerView.f7068F0);
                    }
                    ofFloat = PropertyValuesHolder.ofFloat(str, f2, f3);
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, f2);
                }
            } else {
                if (i5 == 5) {
                    f = typedArray.getDimension(i3, RecyclerView.f7068F0);
                } else {
                    f = typedArray.getFloat(i3, RecyclerView.f7068F0);
                }
                ofFloat = PropertyValuesHolder.ofFloat(str, f);
            }
            propertyValuesHolder = ofFloat;
        } else if (z) {
            if (i4 == 5) {
                i7 = (int) typedArray.getDimension(i2, RecyclerView.f7068F0);
            } else if (m1915c(i4)) {
                i7 = typedArray.getColor(i2, 0);
            } else {
                i7 = typedArray.getInt(i2, 0);
            }
            if (z2) {
                if (i5 == 5) {
                    i8 = (int) typedArray.getDimension(i3, RecyclerView.f7068F0);
                } else if (m1915c(i5)) {
                    i8 = typedArray.getColor(i3, 0);
                } else {
                    i8 = typedArray.getInt(i3, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i7, i8);
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, i7);
            }
        } else if (z2) {
            if (i5 == 5) {
                i6 = (int) typedArray.getDimension(i3, RecyclerView.f7068F0);
            } else if (m1915c(i5)) {
                i6 = typedArray.getColor(i3, 0);
            } else {
                i6 = typedArray.getInt(i3, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6);
        }
        if (propertyValuesHolder != null && argbEvaluator != null) {
            propertyValuesHolder.setEvaluator(argbEvaluator);
            return propertyValuesHolder;
        }
        return propertyValuesHolder;
    }

    /* renamed from: c */
    public static boolean m1915c(int i) {
        return i >= 28 && i <= 31;
    }

    /* renamed from: d */
    public static ValueAnimator m1916d(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, float f, XmlResourceParser xmlResourceParser) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        TypedArray typedArray;
        ValueAnimator valueAnimator3;
        PropertyValuesHolder propertyValuesHolder;
        PropertyValuesHolder propertyValuesHolder2;
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3 = 0;
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, yy2.f29183g);
        TypedArray obtainAttributes2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, yy2.f29187k);
        if (objectAnimator == null) {
            valueAnimator = new ValueAnimator();
        } else {
            valueAnimator = objectAnimator;
        }
        long namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlResourceParser, TypedValues.TransitionType.S_DURATION, 1, HttpStatusCodesKt.HTTP_MULT_CHOICE);
        long namedInt2 = TypedArrayUtils.getNamedInt(obtainAttributes, xmlResourceParser, "startOffset", 2, 0);
        int namedInt3 = TypedArrayUtils.getNamedInt(obtainAttributes, xmlResourceParser, "valueType", 7, 4);
        if (TypedArrayUtils.hasAttribute(xmlResourceParser, "valueFrom") && TypedArrayUtils.hasAttribute(xmlResourceParser, "valueTo")) {
            if (namedInt3 == 4) {
                TypedValue peekValue = obtainAttributes.peekValue(5);
                if (peekValue != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i = peekValue.type;
                } else {
                    i = 0;
                }
                TypedValue peekValue2 = obtainAttributes.peekValue(6);
                if (peekValue2 != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    i2 = peekValue2.type;
                } else {
                    i2 = 0;
                }
                if ((z && m1915c(i)) || (z2 && m1915c(i2))) {
                    namedInt3 = 3;
                } else {
                    namedInt3 = 0;
                }
            }
            PropertyValuesHolder m1914b = m1914b(obtainAttributes, namedInt3, 5, 6, "");
            if (m1914b != null) {
                valueAnimator.setValues(m1914b);
            }
        }
        valueAnimator.setDuration(namedInt);
        valueAnimator.setStartDelay(namedInt2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt(obtainAttributes, xmlResourceParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt(obtainAttributes, xmlResourceParser, "repeatMode", 4, 1));
        if (obtainAttributes2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator;
            String namedString = TypedArrayUtils.getNamedString(obtainAttributes2, xmlResourceParser, "pathData", 1);
            if (namedString != null) {
                String namedString2 = TypedArrayUtils.getNamedString(obtainAttributes2, xmlResourceParser, "propertyXName", 2);
                String namedString3 = TypedArrayUtils.getNamedString(obtainAttributes2, xmlResourceParser, "propertyYName", 3);
                if (namedString2 == null && namedString3 == null) {
                    throw new InflateException(obtainAttributes2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path createPathFromPathData = PathParser.createPathFromPathData(namedString);
                float f2 = 0.5f * f;
                PathMeasure pathMeasure = new PathMeasure(createPathFromPathData, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(RecyclerView.f7068F0));
                float f3 = 0.0f;
                while (true) {
                    f3 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f3));
                    if (!pathMeasure.nextContour()) {
                        break;
                    }
                    valueAnimator = valueAnimator;
                }
                PathMeasure pathMeasure2 = new PathMeasure(createPathFromPathData, false);
                int min = Math.min(100, ((int) (f3 / f2)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f4 = f3 / (min - 1);
                valueAnimator2 = valueAnimator;
                typedArray = obtainAttributes;
                int i4 = 0;
                int i5 = 0;
                float f5 = RecyclerView.f7068F0;
                while (true) {
                    propertyValuesHolder = null;
                    if (i5 >= min) {
                        break;
                    }
                    int i6 = min;
                    pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i4)).floatValue(), fArr3, null);
                    fArr[i5] = fArr3[0];
                    fArr2[i5] = fArr3[1];
                    f5 += f4;
                    int i7 = i4 + 1;
                    if (i7 < arrayList.size() && f5 > ((Float) arrayList.get(i7)).floatValue()) {
                        pathMeasure2.nextContour();
                        i4 = i7;
                    }
                    i5++;
                    min = i6;
                }
                if (namedString2 != null) {
                    propertyValuesHolder2 = PropertyValuesHolder.ofFloat(namedString2, fArr);
                } else {
                    propertyValuesHolder2 = null;
                }
                if (namedString3 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(namedString3, fArr2);
                }
                if (propertyValuesHolder2 == null) {
                    i3 = 0;
                    objectAnimator2.setValues(propertyValuesHolder);
                } else {
                    i3 = 0;
                    if (propertyValuesHolder == null) {
                        objectAnimator2.setValues(propertyValuesHolder2);
                    } else {
                        objectAnimator2.setValues(propertyValuesHolder2, propertyValuesHolder);
                    }
                }
            } else {
                valueAnimator2 = valueAnimator;
                typedArray = obtainAttributes;
                objectAnimator2.setPropertyName(TypedArrayUtils.getNamedString(obtainAttributes2, xmlResourceParser, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator;
            typedArray = obtainAttributes;
        }
        TypedArray typedArray2 = typedArray;
        int namedResourceId = TypedArrayUtils.getNamedResourceId(typedArray2, xmlResourceParser, "interpolator", i3, i3);
        if (namedResourceId > 0) {
            valueAnimator3 = valueAnimator2;
            valueAnimator3.setInterpolator(AnimationUtilsCompat.loadInterpolator(context, namedResourceId));
        } else {
            valueAnimator3 = valueAnimator2;
        }
        typedArray2.recycle();
        if (obtainAttributes2 != null) {
            obtainAttributes2.recycle();
        }
        return valueAnimator3;
    }

    public static Animator loadAnimator(Context context, @AnimatorRes int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return loadAnimator(context, context.getResources(), context.getTheme(), i);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i) {
        return loadAnimator(context, resources, theme, i, 1.0f);
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, @AnimatorRes int i, float f) {
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = resources.getAnimation(i);
                    Animator m1913a = m1913a(context, resources, theme, xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), null, 0, f);
                    xmlResourceParser.close();
                    return m1913a;
                } catch (XmlPullParserException e) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e);
                    throw notFoundException;
                }
            } catch (IOException e2) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
                notFoundException2.initCause(e2);
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
