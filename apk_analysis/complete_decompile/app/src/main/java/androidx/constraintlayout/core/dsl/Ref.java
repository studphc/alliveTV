package androidx.constraintlayout.core.dsl;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class Ref {

    /* renamed from: a */
    public String f2033a;

    /* renamed from: b */
    public float f2034b;

    /* renamed from: c */
    public float f2035c;

    /* renamed from: d */
    public float f2036d;

    public Ref(String str, float f, float f2, float f3) {
        this.f2033a = str;
        this.f2034b = f;
        this.f2035c = f2;
        this.f2036d = f3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.constraintlayout.core.dsl.Ref, java.lang.Object] */
    public static void addStringToReferences(String str, ArrayList<Ref> arrayList) {
        Object obj;
        if (str != null && str.length() != 0) {
            Object[] objArr = new Object[4];
            StringBuilder sb = new StringBuilder();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (charAt != ' ' && charAt != '\'') {
                    if (charAt != ',') {
                        if (charAt != '[') {
                            if (charAt != ']') {
                                sb.append(charAt);
                            } else if (i2 > 0) {
                                i2--;
                                objArr[i] = sb.toString();
                                sb.setLength(0);
                                Object obj2 = objArr[0];
                                if (obj2 != null) {
                                    arrayList.add(new Ref(obj2.toString(), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3])));
                                    Arrays.fill(objArr, (Object) null);
                                    i = 0;
                                }
                            }
                        } else {
                            i2++;
                        }
                    } else {
                        if (i < 3) {
                            objArr[i] = sb.toString();
                            sb.setLength(0);
                            i++;
                        }
                        if (i2 == 1 && (obj = objArr[0]) != null) {
                            String obj3 = obj.toString();
                            ?? obj4 = new Object();
                            obj4.f2034b = Float.NaN;
                            obj4.f2035c = Float.NaN;
                            obj4.f2036d = Float.NaN;
                            obj4.f2033a = obj3;
                            arrayList.add(obj4);
                            objArr[0] = null;
                            i = 0;
                        }
                    }
                }
            }
        }
    }

    public static float parseFloat(Object obj) {
        try {
            return Float.parseFloat(obj.toString());
        } catch (Exception unused) {
            return Float.NaN;
        }
    }

    public static Ref parseStringToRef(String str) {
        String[] split = str.replaceAll("[\\[\\]\\']", "").split(",");
        if (split.length == 0) {
            return null;
        }
        Object[] objArr = new Object[4];
        for (int i = 0; i < split.length && i < 4; i++) {
            objArr[i] = split[i];
        }
        return new Ref(objArr[0].toString().replace("'", ""), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3]));
    }

    public String getId() {
        return this.f2033a;
    }

    public float getPostMargin() {
        return this.f2036d;
    }

    public float getPreMargin() {
        return this.f2035c;
    }

    public float getWeight() {
        return this.f2034b;
    }

    public void setId(String str) {
        this.f2033a = str;
    }

    public void setPostMargin(float f) {
        this.f2036d = f;
    }

    public void setPreMargin(float f) {
        this.f2035c = f;
    }

    public void setWeight(float f) {
        this.f2034b = f;
    }

    public String toString() {
        boolean z;
        float f;
        String str = this.f2033a;
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            if (Float.isNaN(this.f2034b) && Float.isNaN(this.f2035c) && Float.isNaN(this.f2036d)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                sb.append("[");
            }
            sb.append("'");
            sb.append(this.f2033a);
            sb.append("'");
            boolean isNaN = Float.isNaN(this.f2036d);
            float f2 = RecyclerView.f7068F0;
            if (!isNaN) {
                sb.append(",");
                if (!Float.isNaN(this.f2034b)) {
                    f = this.f2034b;
                } else {
                    f = 0.0f;
                }
                sb.append(f);
                sb.append(",");
                if (!Float.isNaN(this.f2035c)) {
                    f2 = this.f2035c;
                }
                sb.append(f2);
                sb.append(",");
                sb.append(this.f2036d);
            } else if (!Float.isNaN(this.f2035c)) {
                sb.append(",");
                if (!Float.isNaN(this.f2034b)) {
                    f2 = this.f2034b;
                }
                sb.append(f2);
                sb.append(",");
                sb.append(this.f2035c);
            } else if (!Float.isNaN(this.f2034b)) {
                sb.append(",");
                sb.append(this.f2034b);
            }
            if (z) {
                sb.append("]");
            }
            sb.append(",");
            return sb.toString();
        }
        return "";
    }
}
