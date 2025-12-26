package p000;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: az */
/* loaded from: classes.dex */
public final class C0538az {

    /* renamed from: a */
    public final ArrayList f7798a = new ArrayList();

    /* renamed from: b */
    public final ArrayList f7799b = new ArrayList();

    /* renamed from: c */
    public GlideContext f7800c;

    /* renamed from: d */
    public Object f7801d;

    /* renamed from: e */
    public int f7802e;

    /* renamed from: f */
    public int f7803f;

    /* renamed from: g */
    public Class f7804g;

    /* renamed from: h */
    public i90 f7805h;

    /* renamed from: i */
    public Options f7806i;

    /* renamed from: j */
    public Map f7807j;

    /* renamed from: k */
    public Class f7808k;

    /* renamed from: l */
    public boolean f7809l;

    /* renamed from: m */
    public boolean f7810m;

    /* renamed from: n */
    public Key f7811n;

    /* renamed from: o */
    public Priority f7812o;

    /* renamed from: p */
    public DiskCacheStrategy f7813p;

    /* renamed from: q */
    public boolean f7814q;

    /* renamed from: r */
    public boolean f7815r;

    /* renamed from: a */
    public final ArrayList m1981a() {
        boolean z = this.f7810m;
        ArrayList arrayList = this.f7799b;
        if (!z) {
            this.f7810m = true;
            arrayList.clear();
            ArrayList m1982b = m1982b();
            int size = m1982b.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.LoadData loadData = (ModelLoader.LoadData) m1982b.get(i);
                if (!arrayList.contains(loadData.sourceKey)) {
                    arrayList.add(loadData.sourceKey);
                }
                for (int i2 = 0; i2 < loadData.alternateKeys.size(); i2++) {
                    if (!arrayList.contains(loadData.alternateKeys.get(i2))) {
                        arrayList.add(loadData.alternateKeys.get(i2));
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public final ArrayList m1982b() {
        boolean z = this.f7809l;
        ArrayList arrayList = this.f7798a;
        if (!z) {
            this.f7809l = true;
            arrayList.clear();
            List modelLoaders = this.f7800c.getRegistry().getModelLoaders(this.f7801d);
            int size = modelLoaders.size();
            for (int i = 0; i < size; i++) {
                ModelLoader.LoadData buildLoadData = ((ModelLoader) modelLoaders.get(i)).buildLoadData(this.f7801d, this.f7802e, this.f7803f, this.f7806i);
                if (buildLoadData != null) {
                    arrayList.add(buildLoadData);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public final Transformation m1983c(Class cls) {
        Transformation transformation = (Transformation) this.f7807j.get(cls);
        if (transformation == null) {
            Iterator it = this.f7807j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    transformation = (Transformation) entry.getValue();
                    break;
                }
            }
        }
        if (transformation == null) {
            if (this.f7807j.isEmpty() && this.f7814q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return UnitTransformation.get();
        }
        return transformation;
    }
}
