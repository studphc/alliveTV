package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ma */
/* loaded from: classes.dex */
public final class C1541ma {

    /* renamed from: l */
    public static final RectF f22860l = new RectF();

    /* renamed from: m */
    public static final ConcurrentHashMap f22861m = new ConcurrentHashMap();

    /* renamed from: a */
    public int f22862a = 0;

    /* renamed from: b */
    public boolean f22863b = false;

    /* renamed from: c */
    public float f22864c = -1.0f;

    /* renamed from: d */
    public float f22865d = -1.0f;

    /* renamed from: e */
    public float f22866e = -1.0f;

    /* renamed from: f */
    public int[] f22867f = new int[0];

    /* renamed from: g */
    public boolean f22868g = false;

    /* renamed from: h */
    public TextPaint f22869h;

    /* renamed from: i */
    public final TextView f22870i;

    /* renamed from: j */
    public final Context f22871j;

    /* renamed from: k */
    public final C1347ja f22872k;

    public C1541ma(TextView textView) {
        this.f22870i = textView;
        this.f22871j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f22872k = new C1384ka();
        } else {
            this.f22872k = new C1347ja();
        }
    }

    /* renamed from: b */
    public static int[] m6113b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* renamed from: d */
    public static Method m6114d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f22861m;
            Method method = (Method) concurrentHashMap.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                concurrentHashMap.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* renamed from: e */
    public static Object m6115e(TextView textView, String str, Object obj) {
        try {
            return m6114d(str).invoke(textView, null);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return obj;
        }
    }

    /* renamed from: a */
    public final void m6116a() {
        int measuredWidth;
        if (!m6118f()) {
            return;
        }
        if (this.f22863b) {
            if (this.f22870i.getMeasuredHeight() > 0 && this.f22870i.getMeasuredWidth() > 0) {
                if (this.f22872k.mo5515b(this.f22870i)) {
                    measuredWidth = 1048576;
                } else {
                    measuredWidth = (this.f22870i.getMeasuredWidth() - this.f22870i.getTotalPaddingLeft()) - this.f22870i.getTotalPaddingRight();
                }
                int height = (this.f22870i.getHeight() - this.f22870i.getCompoundPaddingBottom()) - this.f22870i.getCompoundPaddingTop();
                if (measuredWidth > 0 && height > 0) {
                    RectF rectF = f22860l;
                    synchronized (rectF) {
                        try {
                            rectF.setEmpty();
                            rectF.right = measuredWidth;
                            rectF.bottom = height;
                            float m6117c = m6117c(rectF);
                            if (m6117c != this.f22870i.getTextSize()) {
                                m6119g(m6117c, 0);
                            }
                        } finally {
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.f22863b = true;
    }

    /* renamed from: c */
    public final int m6117c(RectF rectF) {
        CharSequence charSequence;
        CharSequence transformation;
        int length = this.f22867f.length;
        if (length != 0) {
            int i = length - 1;
            int i2 = 0;
            int i3 = 1;
            while (i3 <= i) {
                int i4 = (i3 + i) / 2;
                int i5 = this.f22867f[i4];
                TextView textView = this.f22870i;
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                    charSequence = transformation;
                } else {
                    charSequence = text;
                }
                int maxLines = textView.getMaxLines();
                TextPaint textPaint = this.f22869h;
                if (textPaint == null) {
                    this.f22869h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f22869h.set(textView.getPaint());
                this.f22869h.setTextSize(i5);
                StaticLayout m5203a = AbstractC1299ia.m5203a(charSequence, (Layout.Alignment) m6115e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines, textView, this.f22869h, this.f22872k);
                if ((maxLines != -1 && (m5203a.getLineCount() > maxLines || m5203a.getLineEnd(m5203a.getLineCount() - 1) != charSequence.length())) || m5203a.getHeight() > rectF.bottom) {
                    i2 = i4 - 1;
                    i = i2;
                } else {
                    int i6 = i4 + 1;
                    i2 = i3;
                    i3 = i6;
                }
            }
            return this.f22867f[i2];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    /* renamed from: f */
    public final boolean m6118f() {
        if (m6122j() && this.f22862a != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public final void m6119g(float f, int i) {
        Resources resources;
        Context context = this.f22871j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, resources.getDisplayMetrics());
        TextView textView = this.f22870i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean isInLayout = textView.isInLayout();
            if (textView.getLayout() != null) {
                this.f22863b = false;
                try {
                    Method m6114d = m6114d("nullLayouts");
                    if (m6114d != null) {
                        m6114d.invoke(textView, null);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    textView.requestLayout();
                } else {
                    textView.forceLayout();
                }
                textView.invalidate();
            }
        }
    }

    /* renamed from: h */
    public final boolean m6120h() {
        if (m6122j() && this.f22862a == 1) {
            if (!this.f22868g || this.f22867f.length == 0) {
                int floor = ((int) Math.floor((this.f22866e - this.f22865d) / this.f22864c)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round((i * this.f22864c) + this.f22865d);
                }
                this.f22867f = m6113b(iArr);
            }
            this.f22863b = true;
        } else {
            this.f22863b = false;
        }
        return this.f22863b;
    }

    /* renamed from: i */
    public final boolean m6121i() {
        boolean z;
        if (this.f22867f.length > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f22868g = z;
        if (z) {
            this.f22862a = 1;
            this.f22865d = r0[0];
            this.f22866e = r0[r1 - 1];
            this.f22864c = -1.0f;
        }
        return z;
    }

    /* renamed from: j */
    public final boolean m6122j() {
        return !(this.f22870i instanceof AppCompatEditText);
    }

    /* renamed from: k */
    public final void m6123k(float f, float f2, float f3) {
        if (f > RecyclerView.f7068F0) {
            if (f2 > f) {
                if (f3 > RecyclerView.f7068F0) {
                    this.f22862a = 1;
                    this.f22865d = f;
                    this.f22866e = f2;
                    this.f22864c = f3;
                    this.f22868g = false;
                    return;
                }
                throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
            }
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
    }
}
