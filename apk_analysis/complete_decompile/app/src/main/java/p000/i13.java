package p000;

import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i13 extends j13 {

    /* renamed from: a */
    public final Matrix f18256a;

    /* renamed from: b */
    public final ArrayList f18257b;

    /* renamed from: c */
    public float f18258c;

    /* renamed from: d */
    public float f18259d;

    /* renamed from: e */
    public float f18260e;

    /* renamed from: f */
    public float f18261f;

    /* renamed from: g */
    public float f18262g;

    /* renamed from: h */
    public float f18263h;

    /* renamed from: i */
    public float f18264i;

    /* renamed from: j */
    public final Matrix f18265j;

    /* renamed from: k */
    public String f18266k;

    public i13() {
        this.f18256a = new Matrix();
        this.f18257b = new ArrayList();
        this.f18258c = RecyclerView.f7068F0;
        this.f18259d = RecyclerView.f7068F0;
        this.f18260e = RecyclerView.f7068F0;
        this.f18261f = 1.0f;
        this.f18262g = 1.0f;
        this.f18263h = RecyclerView.f7068F0;
        this.f18264i = RecyclerView.f7068F0;
        this.f18265j = new Matrix();
        this.f18266k = null;
    }

    @Override // p000.j13
    /* renamed from: a */
    public final boolean mo5030a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f18257b;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((j13) arrayList.get(i)).mo5030a()) {
                return true;
            }
            i++;
        }
    }

    @Override // p000.j13
    /* renamed from: b */
    public final boolean mo5031b(int[] iArr) {
        int i = 0;
        boolean z = false;
        while (true) {
            ArrayList arrayList = this.f18257b;
            if (i < arrayList.size()) {
                z |= ((j13) arrayList.get(i)).mo5031b(iArr);
                i++;
            } else {
                return z;
            }
        }
    }

    /* renamed from: c */
    public final void m5147c() {
        Matrix matrix = this.f18265j;
        matrix.reset();
        matrix.postTranslate(-this.f18259d, -this.f18260e);
        matrix.postScale(this.f18261f, this.f18262g);
        matrix.postRotate(this.f18258c, RecyclerView.f7068F0, RecyclerView.f7068F0);
        matrix.postTranslate(this.f18263h + this.f18259d, this.f18264i + this.f18260e);
    }

    public String getGroupName() {
        return this.f18266k;
    }

    public Matrix getLocalMatrix() {
        return this.f18265j;
    }

    public float getPivotX() {
        return this.f18259d;
    }

    public float getPivotY() {
        return this.f18260e;
    }

    public float getRotation() {
        return this.f18258c;
    }

    public float getScaleX() {
        return this.f18261f;
    }

    public float getScaleY() {
        return this.f18262g;
    }

    public float getTranslateX() {
        return this.f18263h;
    }

    public float getTranslateY() {
        return this.f18264i;
    }

    public void setPivotX(float f) {
        if (f != this.f18259d) {
            this.f18259d = f;
            m5147c();
        }
    }

    public void setPivotY(float f) {
        if (f != this.f18260e) {
            this.f18260e = f;
            m5147c();
        }
    }

    public void setRotation(float f) {
        if (f != this.f18258c) {
            this.f18258c = f;
            m5147c();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f18261f) {
            this.f18261f = f;
            m5147c();
        }
    }

    public void setScaleY(float f) {
        if (f != this.f18262g) {
            this.f18262g = f;
            m5147c();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.f18263h) {
            this.f18263h = f;
            m5147c();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.f18264i) {
            this.f18264i = f;
            m5147c();
        }
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [h13, k13] */
    public i13(i13 i13Var, ArrayMap arrayMap) {
        k13 k13Var;
        this.f18256a = new Matrix();
        this.f18257b = new ArrayList();
        this.f18258c = RecyclerView.f7068F0;
        this.f18259d = RecyclerView.f7068F0;
        this.f18260e = RecyclerView.f7068F0;
        this.f18261f = 1.0f;
        this.f18262g = 1.0f;
        this.f18263h = RecyclerView.f7068F0;
        this.f18264i = RecyclerView.f7068F0;
        Matrix matrix = new Matrix();
        this.f18265j = matrix;
        this.f18266k = null;
        this.f18258c = i13Var.f18258c;
        this.f18259d = i13Var.f18259d;
        this.f18260e = i13Var.f18260e;
        this.f18261f = i13Var.f18261f;
        this.f18262g = i13Var.f18262g;
        this.f18263h = i13Var.f18263h;
        this.f18264i = i13Var.f18264i;
        String str = i13Var.f18266k;
        this.f18266k = str;
        if (str != null) {
            arrayMap.put(str, this);
        }
        matrix.set(i13Var.f18265j);
        ArrayList arrayList = i13Var.f18257b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof i13) {
                this.f18257b.add(new i13((i13) obj, arrayMap));
            } else {
                if (obj instanceof h13) {
                    h13 h13Var = (h13) obj;
                    ?? k13Var2 = new k13(h13Var);
                    k13Var2.f17922e = RecyclerView.f7068F0;
                    k13Var2.f17924g = 1.0f;
                    k13Var2.f17925h = 1.0f;
                    k13Var2.f17926i = RecyclerView.f7068F0;
                    k13Var2.f17927j = 1.0f;
                    k13Var2.f17928k = RecyclerView.f7068F0;
                    k13Var2.f17929l = Paint.Cap.BUTT;
                    k13Var2.f17930m = Paint.Join.MITER;
                    k13Var2.f17931n = 4.0f;
                    k13Var2.f17921d = h13Var.f17921d;
                    k13Var2.f17922e = h13Var.f17922e;
                    k13Var2.f17924g = h13Var.f17924g;
                    k13Var2.f17923f = h13Var.f17923f;
                    k13Var2.f20720c = h13Var.f20720c;
                    k13Var2.f17925h = h13Var.f17925h;
                    k13Var2.f17926i = h13Var.f17926i;
                    k13Var2.f17927j = h13Var.f17927j;
                    k13Var2.f17928k = h13Var.f17928k;
                    k13Var2.f17929l = h13Var.f17929l;
                    k13Var2.f17930m = h13Var.f17930m;
                    k13Var2.f17931n = h13Var.f17931n;
                    k13Var = k13Var2;
                } else if (obj instanceof g13) {
                    k13Var = new k13((g13) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f18257b.add(k13Var);
                String str2 = k13Var.f20719b;
                if (str2 != null) {
                    arrayMap.put(str2, k13Var);
                }
            }
        }
    }
}
